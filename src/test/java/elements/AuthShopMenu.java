package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

public class AuthShopMenu implements ShopMenu {
    private static final SelenideElement LOGOUT = Selenide.$(Selectors.byText("Logout"));
    private static final SelenideElement DELETE_ACCOUNT = Selenide.$(Selectors.byText("Delete Account"));
    private static final SelenideElement LOGGED_IN_AS = Selenide.$(Selectors.withText("Logged in as"));
    private static final int NUMBER_OF_ITEMS = 10;


    @Override
    public void verifyVisibility() {
        MENU.shouldBe(Condition.visible);

        Assertions.assertThat(MENU_ITEMS.size())
                .as("Кол-во пунктов меню должно быть больше 0!")
                .isGreaterThan(0)
                .as("В меню должно быть %d пунктов!".formatted(NUMBER_OF_ITEMS))
                .isEqualTo(NUMBER_OF_ITEMS);

        DELETE_ACCOUNT.shouldBe(Condition.visible);

        LOGGED_IN_AS.shouldBe(Condition.visible);
    }

    @Step("Проверить, что видна надпись 'Logged in as {name}'.")
    public void verifyLoggedText(String name) {
        Assertions.assertThat(LOGGED_IN_AS.text())
                .as("")
                .isEqualToIgnoringNewLines("Logged in as " + name);
    }

    @Step("Кликнуть 'Logout'.")
    public void clickLogout() {
        LOGOUT.click();
    }

    @Step("Кликнуть 'Delete Account'.")
    public void clickDeleteAccount() {
        DELETE_ACCOUNT.click();
    }
}
