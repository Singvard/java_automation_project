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

    public static void setConsentCookiesBeforeNavigation() {
        var cookiesScript =
                """
                const domain = window.location.hostname;
                const expiry = new Date(Date.now() + 365 * 24 * 60 * 60 * 1000).toUTCString();
                
                const cookies = [
                    'fc:consent=granted',
                    'cookie_consent=accepted',
                    'gdpr=accepted',
                    'privacy=accepted',
                    'consent=true'
                ];
                
                localStorage.setItem('fc:consent', 'granted');
                localStorage.setItem('fc:showConsentDialog', 'false');
                localStorage.setItem('cookie_consent', 'accepted');
                localStorage.setItem('gdpr_consent', 'accepted');
                """;
        Selenide.executeJavaScript(cookiesScript);
    }
}
