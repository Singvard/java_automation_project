package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class CookieBannerHandler {
    private static final SelenideElement CONSENT_ROOT = Selenide.$(".fc-consent-root");
    private static final SelenideElement CHOICE_DIALOG = Selenide.$(".fc-dialog.fc-choice-dialog");
    private static final SelenideElement CONSENT_BUTTON = Selenide.$(".fc-button.fc-cta-consent");

    public static void handleCookieBanner() {
        if (isCookieBannerPresent()) {
            closeCookieBanner();
        }
    }

    private static boolean isCookieBannerPresent() {
        return CONSENT_ROOT.exists() ||
                CHOICE_DIALOG.exists() ||
                CONSENT_BUTTON.exists();
    }

    private static void closeCookieBanner() {
        CONSENT_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
        CONSENT_ROOT.should(Condition.disappear, Duration.ofSeconds(10));
    }
}
