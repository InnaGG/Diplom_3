package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page_object.RegisterPage;

public class RegistrationTest extends BaseUISettings {

    private RegisterPage registerPage;
    private Faker faker = new Faker();


    @Before
    public void openRegistryPage() {
        registerPage = new RegisterPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @DisplayName("Регистрация")
    @Test
    public void signUpPositive() {
        registerPage.fillName(String.valueOf(faker.name().fullName()));
        registerPage.fillEmail(String.valueOf(faker.internet().emailAddress()));
        registerPage.fillPassword(RandomStringUtils.randomAlphabetic(6));
        registerPage.clickRegisterButton();
        registerPage.waitForLoginPageAfterRegistry();
        String redirectedURL = driver.getCurrentUrl();
        String expectedURL = "https://stellarburgers.nomoreparties.site/login";
        Assert.assertEquals(expectedURL, redirectedURL);
    }

    @DisplayName("Регистрация с паролем, меньше чем 6 символов. Негативный кейс.")
    @Test
    public void signUpPasswordLessThanSixElementsNegative() {
        registerPage.fillName(String.valueOf(faker.name().fullName()));
        registerPage.fillEmail(String.valueOf(faker.internet().emailAddress()));
        registerPage.fillPassword(RandomStringUtils.randomAlphabetic(5));
        registerPage.clickRegisterButton();
        Assert.assertTrue(registerPage.isErrorOfIncorrectPasswordDisplayed());
    }
}
