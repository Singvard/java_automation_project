package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.WebDriverConfig;

import java.util.Objects;

public interface PageUrlVerifier {

    default void verifyPageUrl(String pageUrl) {
        Selenide.Wait().until(driver ->
                Objects.equals(WebDriverRunner.url(), WebDriverConfig.BASE_URL + pageUrl)
        );
    }
}
