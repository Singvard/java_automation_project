package tests;

import org.junit.jupiter.api.Test;
import pages.NoAuthHomePage;

class ContactUsTest {
    @Test
    void testContactUs() {
        new NoAuthHomePage().open()
                .consentCookies()
                .verifyPageIsLoaded()
                .goToContactUsPage();

    }
}
