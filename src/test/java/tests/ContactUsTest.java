package tests;

import models.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.NoAuthHomePage;

class ContactUsTest extends BaseTest {
    @Test
    @DisplayName("Тест на отправку сообщения обратной связи.")
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
