package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import config.WebDriverConfig;
import io.qameta.allure.Step;

public abstract class HomePage {
    protected static final String URL = "/";
    private static final SelenideElement CAROUSEL = Selenide.$("#slider-carousel");

    protected void verifyPageLoad() {
        verifyPageAddress();
        verifyCarouselVisibility();
    }

    @Step("Проверить адрес страницы.")
    private void verifyPageAddress() {
        WebDriverRunner.url().equals(WebDriverConfig.BASE_URL + URL);
    }

    @Step("Проверить отображение карусели слайдов.")
    private void verifyCarouselVisibility() {
        CAROUSEL.shouldBe(Condition.visible);
    }
}
