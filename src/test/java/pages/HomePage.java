package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.ShopMenu;
import org.assertj.core.api.Assertions;

public class HomePage {
    private static final String URL = "/";
    private static final SelenideElement CAROUSEL = Selenide.$("#slider-carousel");

    private final ShopMenu shopMenu;

    public HomePage() {
        this.shopMenu = new ShopMenu();
    }

    public HomePage open() {
        Selenide.open(URL);
        return this;
    }

    public HomePage verifyPageIsLoaded() {
        shopMenu.verifyVisibility();
        return verifyCarouselVisibility();
    }

    public HomePage verifyCarouselVisibility() {
        Assertions.assertThat(CAROUSEL.isDisplayed())
                .as("Карусель слайдов должна отображаться!")
                .isTrue();
        return this;
    }

    public LoginPage goToLoginPage() {
        shopMenu.login();
        return new LoginPage();
    }
}
