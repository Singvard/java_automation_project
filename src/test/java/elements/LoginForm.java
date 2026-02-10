package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.Country;
import models.Title;

public class LoginForm {
    private static final SelenideElement LOGIN_FORM = Selenide.$(".login-form");
    private static final SelenideElement ACCOUNT_INFO = Selenide.$$(".login-form h2")
            .findBy(Condition.text("Enter Account Information"));
    private static final SelenideElement ADDRESS_INFO = Selenide.$$(".login-form h2")
            .findBy(Condition.text("Address Information"));
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
        LOGIN_FORM.shouldBe(Condition.visible);
        ACCOUNT_INFO.shouldBe(Condition.visible);
        ADDRESS_INFO.shouldBe(Condition.visible);
        MR.shouldBe(Condition.visible);
        MRS.shouldBe(Condition.visible);
        NAME.shouldBe(Condition.visible);
        EMAIL.shouldBe(Condition.visible);
        PASSWORD.shouldBe(Condition.visible);
        DAYS.shouldBe(Condition.visible);
        MONTHS.shouldBe(Condition.visible);
        YEARS.shouldBe(Condition.visible);
        NEWSLETTER.shouldBe(Condition.visible);
        OPTIN.shouldBe(Condition.visible);
        FIRST_NAME.shouldBe(Condition.visible);
        LAST_NAME.shouldBe(Condition.visible);
        COMPANY.shouldBe(Condition.visible);
        ADDRESS.shouldBe(Condition.visible);
        ADDRESS2.shouldBe(Condition.visible);
        COUNTRY.shouldBe(Condition.visible);
        STATE.shouldBe(Condition.visible);
        CITY.shouldBe(Condition.visible);
        ZIPCODE.shouldBe(Condition.visible);
        MOBILE_NUMBER.shouldBe(Condition.visible);
        CREATE_ACCOUNT.shouldBe(Condition.visible);
    }

    public LoginForm fillTitle(Title title) {
        switch (title) {
            case MR -> MR.click();
            case MRS -> MRS.click();
        }
        return this;
    }

    public LoginForm fillName(String name) {
        if (!NAME.val().equals(name)) NAME.setValue(name);
        return this;
    }

    public LoginForm fillEmail(String email) {
        if (!EMAIL.val().equals(email)) EMAIL.setValue(email);
        return this;
    }

    public LoginForm fillPassword(String password) {
        PASSWORD.setValue(password);
        return this;
    }

    public LoginForm setDateOfBirth(int day, String month, int year) {
        DAYS.selectOption(String.valueOf(day));
        MONTHS.selectOption(month);
        YEARS.selectOption(String.valueOf(year));
        return this;
    }

    public LoginForm signUpForNewsletter(boolean sign) {
        if (sign) NEWSLETTER.click();
        return this;
    }

    public LoginForm signUpForPartners(boolean sign) {
        if (sign) OPTIN.click();
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

    public LoginForm setCountry(Country country) {
        COUNTRY.selectOption(country.getName());
        return this;
    }

    public LoginForm fillState(String state) {
        STATE.setValue(state);
        return this;
    }

    public LoginForm fillCity(String city) {
        CITY.setValue(city);
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
