package tests;

import models.Account;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.NoAuthHomePage;

class MyTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(MyTest.class);

    @Test
    void testSuccessfulRegistration() {
        var account = Account.createFullySubscribedRandomAccount();
        log.info("email: {}, password: {}", account.email(), account.password());
        new NoAuthHomePage().open()
                .verifyPageIsLoaded()
                .goToLoginPage()
                .verifyPageIsLoaded()
                .register(account)
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

}
