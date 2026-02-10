package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

public class NoAuthShopMenu implements ShopMenu {
    private static final SelenideElement LOGIN = Selenide.$(Selectors.byText("Signup / Login"));
    private static final int NUMBER_OF_ITEMS = 8;

    @Override
    public void verifyVisibility() {
        MENU.shouldBe(Condition.visible);

        Assertions.assertThat(MENU_ITEMS.size())
                .as("Кол-во пунктов меню должно быть больше 0!")
                .isGreaterThan(0)
                .as("В меню должно быть %d пунктов!".formatted(NUMBER_OF_ITEMS))
                .isEqualTo(NUMBER_OF_ITEMS);
    }

    @Step("Кликнуть кнопку логина.")
    public void login() {
        LOGIN.click();
    }
}
