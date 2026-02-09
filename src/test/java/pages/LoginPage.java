package pages;

import elements.SignupForm;

public class LoginPage {
    private static final String URL = "/login";
    private final SignupForm signupForm;

    public LoginPage() {
        this.signupForm = new SignupForm();
    }

    public LoginPage verifyPageIsLoaded() {
        signupForm.verifyFormIsLoaded();
        return this;
    }

    public SignupPage register(String name, String email) {
        signupForm.inputName(name)
                .inputEmail(email)
                .signup();
        return new SignupPage();
    }
}
