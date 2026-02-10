package models;

import net.datafaker.Faker;

import java.time.format.TextStyle;
import java.util.Locale;

public record Account(
        Title title,
        String name,
        String email,
        String password,
        int day,
        String month,
        int year,
        boolean isSignedUpForNewsletter,
        boolean isSignUpForPartners,
        String firstName,
        String lastName,
        String company,
        String address,
        String address2,
        Country country,
        String state,
        String city,
        String zipcode,
        String mobilePhone
) {
    public static Account createRandomAccount(boolean isSignedUpForNewsletter, boolean isSignUpForPartners) {
        var faker = new Faker();
        var name = faker.name();

        return new Account(
                faker.options().option(Title.class),
                name.name(),
                faker.internet().safeEmailAddress(),
                faker.credentials().password(),
                faker.number().numberBetween(1, 32),
                faker.timeAndDate()
                        .birthday()
                        .getMonth()
                        .getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                faker.number().numberBetween(1900, 2022),
                isSignedUpForNewsletter,
                isSignUpForPartners,
                name.firstName(),
                name.lastName(),
                faker.company().name(),
                faker.address().fullAddress(),
                faker.address().fullAddress(),
                faker.options().option(Country.class),
                faker.address().state(),
                faker.address().cityName(),
                faker.address().zipCode(),
                faker.phoneNumber().phoneNumber()
        );
    }

    public static Account createFullySubscribedRandomAccount() {
        return createRandomAccount(true, true);
    }
}
