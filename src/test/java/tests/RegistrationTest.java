package tests;

import models.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.NoAuthHomePage;

class RegistrationTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(RegistrationTest.class);

    @Test
    @DisplayName("Проверка успешной регистрации пользователя.")
    void testSuccessfulUserRegistration() {
        var account = Account.fullySubscribedRandom();
        log.info("email: {}, password: {}", account.email(), account.password());
        new NoAuthHomePage().open()
                .consentCookies()
                .verifyPageIsLoaded()
                .goToLoginPage()
                .verifyPageIsLoaded()
                .registerWithSuccess(account)
                .verifyPageIsLoaded()
                .createAccount(account)
                .verifyPageIsLoaded()
                .clickContinue()
                .verifyPageIsLoaded()
                .verifyLogin(account.name())
                .deleteAccount()
                .verifyPageIsLoaded()
                .clickContinue()
                .verifyPageIsLoaded();
    }

    @Test
    @DisplayName("Проверка неуспешной регистрации с уже существующим email.")
    void testUserRegistrationWithExistingEmail() {
        var account = Account.withEmailAndSubscriptions("special@autotest.ru", false, false);
        new NoAuthHomePage().open()
                .consentCookies()
                .verifyPageIsLoaded()
                .goToLoginPage()
                .verifyPageIsLoaded()
                .registerWithError(account)
                .verifyEmailAlreadyExistsError();
    }
}
