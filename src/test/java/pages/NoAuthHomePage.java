package pages;

import com.codeborne.selenide.Selenide;
import elements.NoAuthShopMenu;
import io.qameta.allure.Step;

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
