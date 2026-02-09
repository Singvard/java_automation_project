package elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.Title;
import org.assertj.core.api.Assertions;

public class LoginForm {
    private static final SelenideElement LOGIN_FORM = Selenide.$(".login-form");
    private static final SelenideElement ACCOUNT_INFO = Selenide.$(".login-form h2")
            .$(Selectors.byText("Enter Account Information"));
    private static final SelenideElement ADDRESS_INFO = Selenide.$(".login-form h2")
            .$(Selectors.byText("Address Information"));
    private static final SelenideElement MR = Selenide.$("#id_gender1");
    private static final SelenideElement MRS = Selenide.$("#id_gender2");
    private static final SelenideElement NAME = Selenide.$("[data-qa='name']");
    private static final SelenideElement EMAIL = Selenide.$("[data-qa='email']");
    private static final SelenideElement PASSWORD = Selenide.$("[data-qa='password']");
    private static final SelenideElement DAYS = Selenide.$("[data-qa='days']");
    private static final SelenideElement MONTHS = Selenide.$("[data-qa='months']");
    private static final SelenideElement YEARS = Selenide.$("[data-qa='years']");
    private static final SelenideElement NEWSLETTER = Selenide.$("#newsletter");
    private static final SelenideElement OPTIN = Selenide.$("#optin");
    private static final SelenideElement FIRST_NAME = Selenide.$("[data-qa='first_name']");
    private static final SelenideElement LAST_NAME = Selenide.$("[data-qa='last_name']");
    private static final SelenideElement COMPANY = Selenide.$("[data-qa='company']");
    private static final SelenideElement ADDRESS = Selenide.$("[data-qa='address']");
    private static final SelenideElement ADDRESS2 = Selenide.$("[data-qa='address2']");
    private static final SelenideElement COUNTRY = Selenide.$("[data-qa='country']");
    private static final SelenideElement STATE = Selenide.$("[data-qa='state']");
    private static final SelenideElement CITY = Selenide.$("[data-qa='city']");
    private static final SelenideElement ZIPCODE = Selenide.$("[data-qa='zipcode']");
    private static final SelenideElement MOBILE_NUMBER = Selenide.$("[data-qa='mobile_number']");
    private static final SelenideElement CREATE_ACCOUNT = Selenide.$("[data-qa='create-account']");

    public void verifyFormIsLoaded() {
        Assertions.assertThat(LOGIN_FORM.isDisplayed()).isTrue();
        Assertions.assertThat(ACCOUNT_INFO.isDisplayed()).isTrue();
        Assertions.assertThat(ADDRESS_INFO.isDisplayed()).isTrue();
        Assertions.assertThat(MR.isDisplayed()).isTrue();
        Assertions.assertThat(MRS.isDisplayed()).isTrue();
        Assertions.assertThat(NAME.isDisplayed()).isTrue();
        Assertions.assertThat(EMAIL.isDisplayed()).isTrue();
        Assertions.assertThat(PASSWORD.isDisplayed()).isTrue();
        Assertions.assertThat(DAYS.isDisplayed()).isTrue();
        Assertions.assertThat(MONTHS.isDisplayed()).isTrue();
        Assertions.assertThat(YEARS.isDisplayed()).isTrue();
        Assertions.assertThat(NEWSLETTER.isDisplayed()).isTrue();
        Assertions.assertThat(OPTIN.isDisplayed()).isTrue();
        Assertions.assertThat(FIRST_NAME.isDisplayed()).isTrue();
        Assertions.assertThat(LAST_NAME.isDisplayed()).isTrue();
        Assertions.assertThat(COMPANY.isDisplayed()).isTrue();
        Assertions.assertThat(ADDRESS.isDisplayed()).isTrue();
        Assertions.assertThat(ADDRESS2.isDisplayed()).isTrue();
        Assertions.assertThat(COUNTRY.isDisplayed()).isTrue();
        Assertions.assertThat(STATE.isDisplayed()).isTrue();
        Assertions.assertThat(CITY.isDisplayed()).isTrue();
        Assertions.assertThat(ZIPCODE.isDisplayed()).isTrue();
        Assertions.assertThat(MOBILE_NUMBER.isDisplayed()).isTrue();
        Assertions.assertThat(CREATE_ACCOUNT.isDisplayed()).isTrue();
    }

    public LoginForm fillTitle (Title title) {
        switch (title) {
            case MR -> MR.click();
            case MRS -> MRS.click();
        }
        return this;
    }

    public LoginForm fillName (String name) {
        NAME.setValue(name);
        return this;
    }

    public LoginForm fillEmail (String email) {
        EMAIL.setValue(email);
        return this;
    }

    public LoginForm fillPassword (String password) {
        PASSWORD.setValue(password);
        return this;
    }

    public LoginForm setDateOfBirth (int day, String month, int year) {
        DAYS.selectOption(String.valueOf(day));
        MONTHS.selectOption(month);
        YEARS.selectOption(String.valueOf(year));
        return this;
    }

    public LoginForm signUpForNewsletter() {
        NEWSLETTER.click();
        return this;
    }

    public LoginForm signUpForPartners() {
        OPTIN.click();
        return this;
    }

    public LoginForm fillFirstName(String firstName) {
        FIRST_NAME.setValue(firstName);
        return this;
    }

    public LoginForm fillLastName(String lastName) {
        LAST_NAME.setValue(lastName);
        return this;
    }

    public LoginForm fillCompany(String company) {
        COMPANY.setValue(company);
        return this;
    }

    public LoginForm fillAddress(String address) {
        ADDRESS.setValue(address);
        return this;
    }

    public LoginForm fillAddress2(String address) {
        ADDRESS2.setValue(address);
        return this;
    }

    public LoginForm setCountry(String country) {
        COUNTRY.selectOption(country);
        return this;
    }

    public LoginForm fillState(String state) {
        STATE.setValue(state);
        return this;
    }

    public LoginForm fillCity(String city) {
        STATE.setValue(city);
        return this;
    }

    public LoginForm fillZipcode(String zipcode) {
        ZIPCODE.setValue(zipcode);
        return this;
    }

    public LoginForm fillMobilePhone(String mobilePhone) {
        MOBILE_NUMBER.setValue(mobilePhone);
        return this;
    }

    public void clickCreateAccount() {
        CREATE_ACCOUNT.click();
    }
}
