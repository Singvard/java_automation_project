package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import config.WebDriverConfig;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import java.util.Objects;

public class DeletedAccountPage {
    private static final String URL = "/delete_account";
    private static final SelenideElement ACCOUNT_DELETED = Selenide.$("[data-qa='account-deleted']");
    private static final String RESULT_TEXT = "Account Deleted!";
    private static final SelenideElement CONTINUE_BUTTON = Selenide.$("[data-qa='continue-button']");

    @Step("Проверить загрузку страницу.")
    public DeletedAccountPage verifyPageIsLoaded() {
        Selenide.Wait().until(driver ->
                Objects.equals(WebDriverRunner.url(), WebDriverConfig.BASE_URL + URL)
        );
        ACCOUNT_DELETED.shouldBe(Condition.visible);
        Assertions.assertThat(ACCOUNT_DELETED.text())
                .as("Текст надписи не совпадает с ожидаемым!")
                .isEqualToIgnoringCase(RESULT_TEXT);
        CONTINUE_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    @Step("Кликнуть кнопку 'Continue'.")
    public NoAuthHomePage clickContinue() {
        CONTINUE_BUTTON.click();
        return new NoAuthHomePage();
    }
}
