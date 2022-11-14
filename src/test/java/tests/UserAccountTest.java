package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page_object.EntryPage;
import page_object.Header;
import page_object.UserAccountPage;

public class UserAccountTest extends BaseUISettings {

    private UserAccountPage userAccountPage;
    private Header header;
    private EntryPage entryPage;

    @Before
    public void openUserAccount() {
        userAccountPage = new UserAccountPage(driver);
        entryPage = new EntryPage(driver);
        header = new Header(driver);
    }

    @DisplayName("Открыть личный кабинет через кнопку в хедере")
    @Test
    public void openUserAccountFromButtonInHeaderPositive() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        String email = "innageldyeva@mail.ru";
        String password = "12345678";
        entryPage.fillEmail(email);
        entryPage.fillPassword(password);
        entryPage.clickEntryButton();
        entryPage.waitFor5Seconds();
        header.clickUserAccount();
        userAccountPage.waitForAProfileButtonToAppear();
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://stellarburgers.nomoreparties.site/account/profile";
        Assert.assertEquals(expectedURL, currentURL);
    }

    @DisplayName("Открыть конструктор через кнопку в Личном кабинете")
    @Test
    public void clickConstructorButtonFromUserAccountPage() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        String email = "innageldyeva@mail.ru";
        String password = "12345678";
        entryPage.fillEmail(email);
        entryPage.fillPassword(password);
        entryPage.clickEntryButton();
        entryPage.waitFor5Seconds();
        header.clickUserAccount();
        userAccountPage.waitForAProfileButtonToAppear();
        header.clickConstructorButton();
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://stellarburgers.nomoreparties.site/";
        Assert.assertEquals(expectedURL, currentURL);
    }

    @DisplayName("Выход из личного кабинета")
    @Test
    public void exitFromUserAccountPositive() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        String email = "innageldyeva@mail.ru";
        String password = "12345678";
        entryPage.fillEmail(email);
        entryPage.fillPassword(password);
        entryPage.clickEntryButton();
        entryPage.waitFor5Seconds();
        header.clickUserAccount();
        userAccountPage.waitForAProfileButtonToAppear();
        userAccountPage.clickExitButton();
        entryPage.waitForEntryFormToAppear();
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://stellarburgers.nomoreparties.site/login";
        Assert.assertEquals(expectedURL, currentURL);
    }
}
