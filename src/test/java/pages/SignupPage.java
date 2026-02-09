package pages;

import elements.LoginForm;

public class SignupPage {
    private static final String URL = "/signup";
    private final LoginForm loginForm;

    public SignupPage() {
        this.loginForm = new LoginForm();
    }

    public SignupPage verifyPageIsLoaded() {
        loginForm.verifyFormIsLoaded();
        return this;
    }

    public SignupPage createAccount(Account account) {

    }
}
