package pages;

import com.codeborne.selenide.WebDriverRunner;
import config.WebDriverConfig;
import elements.LoginForm;
import models.Account;

public class SignupPage {
    private static final String URL = "/signup";
    private final LoginForm loginForm;

    public SignupPage() {
        this.loginForm = new LoginForm();
    }

    public SignupPage verifyPageIsLoaded() {
        WebDriverRunner.url().equals(WebDriverConfig.BASE_URL + URL);
        loginForm.verifyFormIsLoaded();
        return this;
    }

    public AccountCreatedPage createAccount(Account account) {
        loginForm.fillTitle(account.title())
                .fillName(account.name())
                .fillEmail(account.email())
                .fillPassword(account.password())
                .setDateOfBirth(account.day(), account.month(), account.year())
                .signUpForNewsletter(account.isSignedUpForNewsletter())
                .signUpForPartners(account.isSignUpForPartners())
                .fillFirstName(account.firstName())
                .fillLastName(account.lastName())
                .fillCompany(account.company())
                .fillAddress(account.address())
                .fillAddress2(account.address2())
                .setCountry(account.country())
                .fillState(account.state())
                .fillCity(account.city())
                .fillZipcode(account.zipcode())
                .fillMobilePhone(account.mobilePhone())
                .clickCreateAccount();

        return new AccountCreatedPage();
    }
}
