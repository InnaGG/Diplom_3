package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page_object.Constructor;

public class ConstructorPageTest extends BaseUISettings {
    private Constructor constructor;

    @Before
    public void openRegistryPage() {
        constructor = new Constructor(driver);
        driver.get("https://stellarburgers.nomoreparties.site/");
        constructor.waitFor5Seconds();
    }

    @DisplayName("При нажатии на Булки отображаются нужные ингредиенты")
    @Test
    public void checkBunsListBeingDisplayedPositive() {
        constructor.clickFillings();
        constructor.clickBuns();
        constructor.waitFor5Seconds();
        Assert.assertTrue(constructor.isBunsSectionWasChosen());
    }

    @DisplayName("При нажатии на Соусы отображаются нужные ингредиенты")
    @Test
    public void checkSaucesListBeingDisplayedPositive() {
        constructor.clickSauces();
        constructor.waitFor5Seconds();
        Assert.assertTrue(constructor.isSaucesSectionWasChosen());
    }

    @DisplayName("При нажатии на Начинки отображаются нужные ингредиенты")
    @Test
    public void checkFillingsListBeingDisplayedPositive() {
        constructor.clickFillings();
        constructor.waitFor5Seconds();
        Assert.assertTrue(constructor.isFillingsSectionWasChosen());
    }
}
