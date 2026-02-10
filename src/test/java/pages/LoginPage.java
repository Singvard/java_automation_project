package pages;

import com.codeborne.selenide.WebDriverRunner;
import config.WebDriverConfig;
import elements.SignupForm;
import models.Account;

public class LoginPage {
    private static final String URL = "/login";
    private final SignupForm signupForm;

    public LoginPage() {
        this.signupForm = new SignupForm();
    }

    public LoginPage verifyPageIsLoaded() {
        WebDriverRunner.url().equals(WebDriverConfig.BASE_URL + URL);
        signupForm.verifyFormIsLoaded();
        return this;
    }

    public SignupPage register(Account account) {
        signupForm.inputName(account.name())
                .inputEmail(account.email())
                .signup();
        return new SignupPage();
    }
}
