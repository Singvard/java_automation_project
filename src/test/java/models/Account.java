package models;

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
}
