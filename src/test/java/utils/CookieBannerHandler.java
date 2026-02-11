package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class CookieBannerHandler {
    private static final SelenideElement BANNER = Selenide.$(".fc-consent-root");
    private static final SelenideElement DIALOG = Selenide.$(".fc-dialog.fc-choice-dialog");
    private static final SelenideElement ACCEPT_BUTTON = Selenide.$(".fc-button.fc-cta-consent");

    public static void handleCookieBanner() {
        if (isCookieBannerPresent()) {
            closeCookieBanner();
        }
    }

    private static boolean isCookieBannerPresent() {
        return BANNER.exists() ||
                DIALOG.exists() ||
                ACCEPT_BUTTON.exists();
    }

    private static void closeCookieBanner() {
        ACCEPT_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(5))
                .click();
        BANNER.should(Condition.disappear, Duration.ofSeconds(5));
    }
}
