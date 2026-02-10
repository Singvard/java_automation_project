package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import config.WebDriverConfig;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;


public class AccountCreatedPage {
    private static final String URL = "/account_created";
    private static final SelenideElement SUCCESS_HEADER = Selenide.$("[data-qa='account-created']");
    private static final String RESULT_TEXT = "Account Created!";
    private static final SelenideElement CONTINUE_BUTTON = Selenide.$("[data-qa='continue-button']");

    @Step("Проверить загрузку страницу.")
    public AccountCreatedPage verifyPageIsLoaded() {
        WebDriverRunner.url().equals(WebDriverConfig.BASE_URL + URL);
        SUCCESS_HEADER.shouldBe(Condition.visible);
        Assertions.assertThat(SUCCESS_HEADER.text())
                .as("Текст надписи не совпадает с ожидаемым!")
                .isEqualToIgnoringCase(RESULT_TEXT);
        CONTINUE_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    @Step("Кликнуть кнопку 'Continue'.")
    public AuthHomePage clickContinue() {
        CONTINUE_BUTTON.click();
        return new AuthHomePage();
    }
}
