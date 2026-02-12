package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public abstract class HomePage implements PageUrlVerifier {
    protected static final String URL = "/";
    private static final SelenideElement CAROUSEL = Selenide.$("#slider-carousel");

    protected void verifyPageLoad() {
        verifyPageAddress();
        verifyCarouselVisibility();
    }

    @Step("Проверить адрес страницы.")
    private void verifyPageAddress() {
        verifyPageUrl(URL);
    }

    @Step("Проверить отображение карусели слайдов.")
    private void verifyCarouselVisibility() {
        CAROUSEL.shouldBe(Condition.visible);
    }
}
