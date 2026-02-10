package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public interface ShopMenu {
    SelenideElement MENU = Selenide.$(".shop-menu.pull-right");
    ElementsCollection MENU_ITEMS = Selenide.$$("ul.nav.navbar-nav li");

    @Step("Проверить отображение меню магазина")
    void verifyVisibility();
}
