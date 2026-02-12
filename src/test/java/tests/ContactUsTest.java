package tests;

import models.Message;
import org.junit.jupiter.api.Test;
import pages.NoAuthHomePage;

class ContactUsTest extends BaseTest {
    @Test
    void testContactUs() {
        var message = Message.random();
        new NoAuthHomePage().open()
                .consentCookies()
                .verifyPageIsLoaded()
                .goToContactUsPage()
                .verifyPageLoad()
                .fillInData(message)
                .submit()
                .ok()
                .verifySuccessMessage();

    }
}
