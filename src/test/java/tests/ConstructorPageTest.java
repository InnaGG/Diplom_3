package tests;

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

    @Test
    public void checkBunsListBeingDisplayedPositive() {
        constructor.clickFillings();
        constructor.clickBuns();
        constructor.waitFor5Seconds();
        Assert.assertTrue(constructor.isBunsSectionWasChosen());
    }

    @Test
    public void checkSaucesListBeingDisplayedPositive() {
        constructor.clickSauces();
        constructor.waitFor5Seconds();
        Assert.assertTrue(constructor.isSaucesSectionWasChosen());
    }

    @Test
    public void checkFillingsListBeingDisplayedPositive() {
        constructor.clickFillings();
        constructor.waitFor5Seconds();
        Assert.assertTrue(constructor.isFillingsSectionWasChosen());
    }
}
