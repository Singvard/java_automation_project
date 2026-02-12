package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

public class DeletedAccountPage implements PageUrlVerifier {
    private static final String URL = "/delete_account";
    private static final SelenideElement ACCOUNT_DELETED = Selenide.$("[data-qa='account-deleted']");
    private static final String RESULT_TEXT = "Account Deleted!";
    private static final SelenideElement CONTINUE_BUTTON = Selenide.$("[data-qa='continue-button']");

    @Step("Проверить загрузку страницу.")
    public DeletedAccountPage verifyPageIsLoaded() {
        verifyPageUrl(URL);
        Assertions.assertThat(ACCOUNT_DELETED.shouldBe(Condition.visible).text())
                .as("Текст надписи не совпадает с ожидаемым!")
                .isEqualToIgnoringCase(RESULT_TEXT);
        Assertions.assertThat(CONTINUE_BUTTON.shouldBe(Condition.visible).text())
                .as("Кнопка должна называться 'Continue'")
                .isEqualTo("Continue");
        return this;
    }

    @Step("Кликнуть по кнопке 'Continue'.")
    public NoAuthHomePage clickContinue() {
        CONTINUE_BUTTON.click();
        return new NoAuthHomePage();
    }
}
