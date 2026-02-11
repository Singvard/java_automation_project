package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import java.time.Duration;

public class LoginForm {
    public static final SelenideElement FORM = Selenide.$(".login-form");
    public static final SelenideElement FORM_HEADER = Selenide.$(".login-form h2");
    public static final SelenideElement EMAIL_INPUT = Selenide.$("[data-qa='login-email']");
    public static final SelenideElement PASSWORD_INPUT = Selenide.$("[data-qa='login-password']");
    public static final SelenideElement LOGIN_BUTTON = Selenide.$("[data-qa='login-button']");
    public static final SelenideElement ERROR_MESSAGE = Selenide.$(".login-form p[style*='color: red']");

    public void verifyFormIsLoaded() {
        FORM.shouldBe(Condition.visible);

        FORM_HEADER.shouldBe(Condition.visible);

        Assertions.assertThat(FORM_HEADER.text())
                .as("Текст заголовка должен соответствовать ожиданию!")
                .isEqualTo("Login to your account");

        EMAIL_INPUT.shouldBe(Condition.visible);

        Assertions.assertThat(EMAIL_INPUT.getAttribute("placeholder"))
                .as("Поле должно иметь соответствующий плейсхолдер!")
                .isEqualTo("Email Address");

        PASSWORD_INPUT.shouldBe(Condition.visible);

        Assertions.assertThat(PASSWORD_INPUT.getAttribute("placeholder"))
                .as("Поле должно иметь соответствующий плейсхолдер!")
                .isEqualTo("Password");

        LOGIN_BUTTON.shouldBe(Condition.visible);

        Assertions.assertThat(LOGIN_BUTTON.text())
                .as("Надпись на кнопке входа должна соответствовать ожиданию!")
                .isEqualTo("Login");
    }

    @Step("Ввести email {email}.")
    public LoginForm inputEmail(String email) {
        EMAIL_INPUT.setValue(email);
        return this;
    }

    @Step("Ввести пароль.")
    public LoginForm inputPassword(String password) {
        PASSWORD_INPUT.setValue(password);
        return this;
    }

    @Step("Кликнуть кнопку Login")
    public void login() {
        LOGIN_BUTTON.click();
    }

    @Step("Проверить появление ошибки с текстом: {text}")
    public void verifyErrorMessage(String text) {
        ERROR_MESSAGE.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .shouldHave(Condition.text(text));
    }
}
