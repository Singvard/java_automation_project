package pages;

import com.codeborne.selenide.*;
import config.WebDriverConfig;
import io.qameta.allure.Step;
import models.Message;
import org.assertj.core.api.Assertions;

import java.util.Objects;

public class ContactUsPage {
    private static final String URL = "/";
    private static final SelenideElement HEADER = Selenide.$(".contact-form h2");
    private static final SelenideElement NAME_INPUT = Selenide.$("[data-qa='name']");
    private static final SelenideElement EMAIL_INPUT = Selenide.$("[data-qa='email']");
    private static final SelenideElement SUBJECT_INPUT = Selenide.$("[data-qa='subject']");
    private static final SelenideElement MESSAGE_INPUT = Selenide.$("[data-qa='message']");
    private static final SelenideElement UPLOAD_BUTTON = Selenide.$(Selectors.byName("upload_file"));
    private static final SelenideElement SUBMIT_BUTTON = Selenide.$("[data-qa='submit-button']");
    private static final SelenideElement SUCCESS_MESSAGE = Selenide.$(".status.alert.alert-success");

    @Step("Проверить, что страница загрузилась.")
    public ContactUsPage verifyPageLoad() {
        Selenide.Wait().until(driver ->
                Objects.equals(WebDriverRunner.url(), WebDriverConfig.BASE_URL + URL)
        );

        Assertions.assertThat(HEADER.shouldBe(Condition.visible).text())
                .as("Заголовок страницы должен быть 'Get In Touch'")
                .isEqualToIgnoringCase("Get In Touch");

        Assertions.assertThat(NAME_INPUT.shouldBe(Condition.visible).getAttribute("placeholder"))
                .as("Плейсхолдер поля 'Name' должен быть 'Name'")
                .isEqualTo("Name");

        Assertions.assertThat(EMAIL_INPUT.shouldBe(Condition.visible)
                        .shouldHave(Condition.attribute("required"))
                        .getAttribute("placeholder"))
                .as("Поле 'Email' должно быть обязательным и иметь плейсхолдер 'Email'")
                .isEqualTo("Email");

        Assertions.assertThat(SUBJECT_INPUT.shouldBe(Condition.visible).getAttribute("placeholder"))
                .as("Плейсхолдер поля 'Subject' должен быть 'Subject'")
                .isEqualTo("Subject");

        Assertions.assertThat(MESSAGE_INPUT.shouldBe(Condition.visible).getAttribute("placeholder"))
                .as("Плейсхолдер поля 'Message' должен быть 'Your Message Here'")
                .isEqualTo("Your Message Here");

        UPLOAD_BUTTON.shouldBe(Condition.visible);

        Assertions.assertThat(SUBMIT_BUTTON.shouldBe(Condition.visible).val())
                .as("Текст на кнопке отправки формы должен быть 'Submit'")
                .isEqualTo("Submit");

        return this;
    }

    @Step("Заполнить поля Name, Email, Subject, Message.")
    public ContactUsPage fillInData(Message message) {
        NAME_INPUT.setValue(message.name());
        EMAIL_INPUT.setValue(message.email());
        SUBJECT_INPUT.setValue(message.subject());
        MESSAGE_INPUT.setValue(message.text());
        UPLOAD_BUTTON.uploadFile(message.attachment());
        return this;
    }

    @Step("Кликнуть кнопку Submit.")
    public ContactUsPage submit() {
        SUBMIT_BUTTON.click();
        return this;
    }

    @Step("Кликнуть Ok в модальном окне.")
    public ContactUsPage ok() {
        Selenide.confirm();
        return this;
    }

    @Step("Проверить сообщение об успешной отправке формы.")
    public void verifySuccessMessage() {
        Assertions.assertThat(SUCCESS_MESSAGE.shouldBe(Condition.visible).text())
                .as("Сообщение об успешной отправке должно отображаться с корректным текстом")
                .isEqualTo("Success! Your details have been submitted successfully.");
    }
}
