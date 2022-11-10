package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page_object.*;

public class EntryPageTest extends BaseUISettings {

    private EntryPage entryPage;
    private Constructor constructor;
    private Header header;
    private RegisterPage registerPage;

    @Before
    public void settings() {
        entryPage = new EntryPage(driver);
        constructor = new Constructor(driver);
        header = new Header(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void entryFromMainPageEntryButtonPositive() {
        String email = "innageldyeva@mail.ru";
        String password = "12345678";
        driver.get("https://stellarburgers.nomoreparties.site/");
        constructor.clickEnterAnAccount();
        entryPage.waitForEntryFormToAppear();
        entryPage.fillEmail(email);
        entryPage.fillPassword(password);
        entryPage.clickEntryButton();
        entryPage.waitFor5Seconds();
        boolean isMainPageAppeared = constructor.isConstructorPanelHasAppeared();
        Assert.assertTrue(isMainPageAppeared);
    }

    @Test
    public void entryFromAfterClickingUserAccountInHeaderPositive() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        header.clickUserAccount();
        String expectedPage = "https://stellarburgers.nomoreparties.site/login";
        String actualPage = driver.getCurrentUrl();
        Assert.assertEquals(expectedPage, actualPage);
        String email = "innageldyeva@mail.ru";
        String password = "12345678";
        entryPage.fillEmail(email);
        entryPage.fillPassword(password);
        entryPage.clickEntryButton();
        entryPage.waitFor5Seconds();
        boolean isMainPageAppeared = constructor.isConstructorPanelHasAppeared();
        Assert.assertTrue(isMainPageAppeared);
    }

    @Test
    public void entryFromRegistryFormPositive() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registerPage.clickEntryButton();
        registerPage.waitForLoginPageAfterRegistry();
        String email = "innageldyeva@mail.ru";
        String password = "12345678";
        entryPage.fillEmail(email);
        entryPage.fillPassword(password);
        entryPage.clickEntryButton();
        entryPage.waitFor5Seconds();
        boolean isMainPageAppeared = constructor.isConstructorPanelHasAppeared();
        Assert.assertTrue(isMainPageAppeared);
    }

    @Test
    public void entryFromResetPasswordPage() {
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        resetPasswordPage.clickEntryButton();
        entryPage.waitForEntryFormToAppear();
        String email = "innageldyeva@mail.ru";
        String password = "12345678";
        entryPage.fillEmail(email);
        entryPage.fillPassword(password);
        entryPage.clickEntryButton();
        entryPage.waitFor5Seconds();
        boolean isMainPageAppeared = constructor.isConstructorPanelHasAppeared();
        Assert.assertTrue(isMainPageAppeared);
    }

}
