package pages;

import com.codeborne.selenide.WebDriverRunner;
import config.WebDriverConfig;
import elements.LoginForm;
import elements.SignupForm;
import models.Account;

public class LoginPage {
    private static final String URL = "/login";
    private static final String EMAIL_OR_PASSWORD_INCORRECT_ERROR = "Your email or password is incorrect!";
    private static final String EMAIL_ALREADY_EXISTS_ERROR = "Email Address already exist!";
    private final LoginForm loginForm;
    private final SignupForm signupForm;

    public LoginPage() {
        this.loginForm = new LoginForm();
        this.signupForm = new SignupForm();
    }

    public LoginPage verifyPageIsLoaded() {
        WebDriverRunner.url().equals(WebDriverConfig.BASE_URL + URL);
        loginForm.verifyFormIsLoaded();
        signupForm.verifyFormIsLoaded();
        return this;
    }

    public AuthHomePage loginWithSuccess(Account account) {
        login(account);
        return new AuthHomePage();
    }

    public LoginPage loginWithError(Account account) {
        login(account);
        return this;
    }

    public void verifyEmailOrPasswordIncorrectError() {
        loginForm.verifyErrorMessage(EMAIL_OR_PASSWORD_INCORRECT_ERROR);
    }

    public void verifyEmailAlreadyExistsError() {
        signupForm.verifyErrorMessage(EMAIL_ALREADY_EXISTS_ERROR);
    }

    public SignupPage registerWithSuccess(Account account) {
        signupForm.inputName(account.name())
                .inputEmail(account.email())
                .signup();
        return new SignupPage();
    }

    public LoginPage registerWithError(Account account) {
        register(account);
        return new LoginPage();
    }

    private void login(Account account) {
        loginForm.inputEmail(account.email())
                .inputPassword(account.password())
                .login();
    }

    private void register(Account account) {
        signupForm.inputName(account.name())
                .inputEmail(account.email())
                .signup();
    }

}
