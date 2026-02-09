package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;

public class ShopMenu {
    private static final SelenideElement MENU = Selenide.$(".shop-menu.pull-right");
    private static final ElementsCollection MENU_ITEMS = Selenide.$$("ul.nav.navbar-nav li");
    private static final SelenideElement LOGIN = Selenide.$(Selectors.byText("Signup / Login"));

    public void verifyVisibility() {
        Assertions.assertThat(MENU.isDisplayed())
                .as("Меню магазина должно быть видимо!")
                .isTrue();

        Assertions.assertThat(MENU_ITEMS.size())
                .as("Кол-во пунктов меню должно быть больше 0!")
                .isGreaterThan(0)
                .as("В меню должно быть 8 пунктов!")
                .isEqualTo(8);
    }

    public void login() {
        LOGIN.click();
    }
}
