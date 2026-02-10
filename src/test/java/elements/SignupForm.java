package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

public class SignupForm {
    public static final SelenideElement FORM = Selenide.$(".signup-form");
    public static final SelenideElement FORM_HEADER = Selenide.$(".signup-form h2");
    public static final SelenideElement NAME_INPUT = Selenide.$("[data-qa='signup-name']");
    public static final SelenideElement EMAIL_INPUT = Selenide.$("[data-qa='signup-email']");
    public static final SelenideElement SIGNUP_BUTTON = Selenide.$("[data-qa='signup-button']");

    public void verifyFormIsLoaded() {
        FORM.shouldBe(Condition.visible);

        FORM_HEADER.shouldBe(Condition.visible);

        Assertions.assertThat(FORM_HEADER.text())
                .as("Текст заголовка должен соответствовать ожиданию!")
                .isEqualTo("New User Signup!");

        NAME_INPUT.shouldBe(Condition.visible);

        Assertions.assertThat(NAME_INPUT.getAttribute("placeholder"))
                .as("Поле должно иметь соответствующий плейсхолдер!")
                .isEqualTo("Name");

        EMAIL_INPUT.shouldBe(Condition.visible);

        Assertions.assertThat(EMAIL_INPUT.getAttribute("placeholder"))
                .as("Поле должно иметь соответствующий плейсхолдер!")
                .isEqualTo("Email Address");

        SIGNUP_BUTTON.shouldBe(Condition.visible);

        Assertions.assertThat(SIGNUP_BUTTON.text())
                .as("Надпись на кнопке регистрации должна соответствовать ожиданию!")
                .isEqualTo("Signup");
    }

    @Step("Ввести имя {name}")
    public SignupForm inputName(String name) {
        NAME_INPUT.setValue(name);
        return this;
    }

    @Step("Ввести имя {email}")
    public SignupForm inputEmail(String email) {
        EMAIL_INPUT.setValue(email);
        return this;
    }


    public void signup() {
        SIGNUP_BUTTON.click();
    }
}
