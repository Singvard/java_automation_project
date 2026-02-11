package tests;

import models.Account;
import org.junit.jupiter.api.Test;
import pages.NoAuthHomePage;

class LoginTest extends BaseTest {

    @Test
    void testSuccessfulLogin() {
        var account = Account.withEmailAndPasswordAndSubscriptions("special@autotest.ru", "hQgd+u}s%4!.Fa;", false, false);

        new NoAuthHomePage().open()
                .consentCookies()
                .verifyPageIsLoaded()
                .goToLoginPage()
                .loginWithSuccess(account)
                .verifyPageIsLoaded()
                .verifyLogin("special.autotest");
    }

    @Test
    void testFailedLogin() {
        var account = Account.fullySubscribedRandom();

        new NoAuthHomePage().open()
                .consentCookies()
                .verifyPageIsLoaded()
                .goToLoginPage()
                .loginWithError(account)
                .verifyEmailOrPasswordIncorrectError();
    }

    @Test
    void testLoginWithLogout() {
        var account = Account.withEmailAndPasswordAndSubscriptions("special@autotest.ru", "hQgd+u}s%4!.Fa;", false, false);

        new NoAuthHomePage().open()
                .consentCookies()
                .verifyPageIsLoaded()
                .goToLoginPage()
                .loginWithSuccess(account)
                .verifyPageIsLoaded()
                .verifyLogin("special.autotest")
                .logout()
                .verifyPageIsLoaded();
    }
}
