package pages;

import elements.RegisterForm;
import models.Account;

public class SignupPage implements PageUrlVerifier {
    private static final String URL = "/signup";
    private final RegisterForm loginForm;

    public SignupPage() {
        this.loginForm = new RegisterForm();
    }

    public SignupPage verifyPageIsLoaded() {
        verifyPageUrl(URL);

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
