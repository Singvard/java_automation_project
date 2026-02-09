package tests;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.HomePage;

class MyTest extends BaseTest {

    private static final Faker faker = new Faker();

    @Test
    void testSuccessfulRegistration() {
        new HomePage().open()
                .verifyPageIsLoaded()
                .goToLoginPage()
                .verifyPageIsLoaded()
                .register(faker.credentials().username(), faker.internet().emailAddress());
    }

}
