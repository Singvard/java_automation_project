package pages;

import com.codeborne.selenide.*;
import config.WebDriverConfig;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

public class ContactUsPage {
    private static final String URL = "/";
    private static final SelenideElement HEADER = Selenide.$(".contact-form h2");
    private static final SelenideElement NAME = Selenide.$("data-qa='name'");
    private static final SelenideElement EMAIL = Selenide.$("data-qa='email'");
    private static final SelenideElement SUBJECT = Selenide.$("data-qa='subject'");
    private static final SelenideElement MESSAGE = Selenide.$("data-qa='message'");
    private static final SelenideElement UPLOAD_BUTTON = Selenide.$(Selectors.byName("upload_file"));
    private static final SelenideElement SUBMIT_BUTTON = Selenide.$("data-qa='submit-button'");

    public void verifyPageLoad() {
        verifyPageAddress();
        verifyHeader();
        Assertions.assertThat(NAME.shouldBe(Condition.visible).getAttribute("placeholder"))
                .as("")
                .isEqualTo("Name");

        Assertions.assertThat(EMAIL.shouldBe(Condition.visible).getAttribute("placeholder"))
                .as("")
                .isEqualTo("Email");

        Assertions.assertThat(SUBJECT.shouldBe(Condition.visible).getAttribute("placeholder"))
                .as("")
                .isEqualTo("Subject");

        Assertions.assertThat(MESSAGE.shouldBe(Condition.visible).getAttribute("placeholder"))
                .as("")
                .isEqualTo("Your Message Here");

        UPLOAD_BUTTON.shouldBe(Condition.visible);

        Assertions.assertThat(SUBMIT_BUTTON.shouldBe(Condition.visible).val())
                .as("")
                .isEqualTo("Submit");
    }

    @Step("Проверить адрес страницы.")
    private void verifyPageAddress() {
        WebDriverRunner.url().equals(WebDriverConfig.BASE_URL + URL);
    }

    @Step("Проверить заголовок контактной формы.")
    private void verifyHeader() {
        Assertions.assertThat(HEADER.shouldBe(Condition.visible).text())
                .as("")
                .isEqualToIgnoringCase("Get In Touch");
    }
}
