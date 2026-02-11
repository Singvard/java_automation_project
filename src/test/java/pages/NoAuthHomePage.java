package pages;

import com.codeborne.selenide.Selenide;
import elements.NoAuthShopMenu;
import io.qameta.allure.Step;
import utils.CookieBannerHandler;

public class NoAuthHomePage extends HomePage {
    private final NoAuthShopMenu shopMenu;

    public NoAuthHomePage() {
        this.shopMenu = new NoAuthShopMenu();
    }

    @Step("Открыть домашнюю страницу.")
    public NoAuthHomePage open() {
        Selenide.open(URL);
        return this;
    }

    @Step("Принять куки.")
    public NoAuthHomePage consentCookies() {
        CookieBannerHandler.handleCookieBanner();
        return this;
    }

    public NoAuthHomePage verifyPageIsLoaded() {
        super.verifyPageLoad();
        shopMenu.verifyVisibility();
        return this;
    }

    public LoginPage goToLoginPage() {
        shopMenu.login();
        return new LoginPage();
    }
}
