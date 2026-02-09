package elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;

public class SignupForm {
    public static final SelenideElement FORM = Selenide.$(".signup-form");
    public static final SelenideElement FORM_HEADER = Selenide.$(".signup-form h2");
    public static final SelenideElement NAME_INPUT = Selenide.$("[data-qa='signup-name']");
    public static final SelenideElement EMAIL_INPUT = Selenide.$("[data-qa='signup-email']");
    public static final SelenideElement SIGNUP_BUTTON = Selenide.$("[data-qa='signup-button']");

    public void verifyFormIsLoaded() {
        Assertions.assertThat(FORM.isDisplayed())
                .as("Форма регистрации должна быть видима!")
                .isTrue();

        Assertions.assertThat(FORM_HEADER.isDisplayed())
                .as("Заголовок формы должен быть видимым!")
                .isTrue();

        Assertions.assertThat(FORM_HEADER.getText())
                .as("Текст заголовка должен соответствовать ожиданию!")
                .isEqualTo("New User Signup!");

        Assertions.assertThat(NAME_INPUT.isDisplayed())
                .as("Поле ввода логина должно быть видимым!")
                .isTrue();

        Assertions.assertThat(NAME_INPUT.getAttribute("placeholder"))
                .as("Поле должно иметь соответствующий плейсхолдер!")
                .isEqualTo("Name");

        Assertions.assertThat(EMAIL_INPUT.isDisplayed())
                .as("Поле ввода email должно быть видимым")
                .isTrue();

        Assertions.assertThat(EMAIL_INPUT.getAttribute("placeholder"))
                .as("Поле должно иметь соответствующий плейсхолдер!")
                .isEqualTo("Email Address");

        Assertions.assertThat(SIGNUP_BUTTON.isDisplayed())
                .as("Кнопка регистрации должна быть видимой")
                .isTrue();

        Assertions.assertThat(SIGNUP_BUTTON.getText())
                .as("Надпись на кнопке регистрации должна соответствовать ожиданию!")
                .isEqualTo("Signup");
    }

    public SignupForm inputName(String name) {
        NAME_INPUT.setValue(name);
        return this;
    }


    public SignupForm inputEmail(String email) {
        EMAIL_INPUT.setValue(email);
        return this;
    }


    public void signup() {
        SIGNUP_BUTTON.click();
    }
}
