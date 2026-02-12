package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;


public class AccountCreatedPage implements PageUrlVerifier {
    private static final String URL = "/account_created";
    private static final SelenideElement SUCCESS_HEADER = Selenide.$("[data-qa='account-created']");
    private static final String RESULT_TEXT = "Account Created!";
    private static final SelenideElement CONTINUE_BUTTON = Selenide.$("[data-qa='continue-button']");

    @Step("Проверить загрузку страницы.")
    public AccountCreatedPage verifyPageIsLoaded() {
        verifyPageUrl(URL);
        SUCCESS_HEADER.shouldBe(Condition.visible);
        Assertions.assertThat(SUCCESS_HEADER.text())
                .as("Текст надписи не совпадает с ожидаемым!")
                .isEqualToIgnoringCase(RESULT_TEXT);
        Assertions.assertThat(CONTINUE_BUTTON.shouldBe(Condition.visible).text())
                .as("Кнопка должна называться 'Continue'")
                .isEqualTo("Continue");
        return this;
    }

    @Step("Кликнуть по кнопке 'Continue'.")
    public AuthHomePage clickContinue() {
        CONTINUE_BUTTON.click();
        return new AuthHomePage();
    }
}
