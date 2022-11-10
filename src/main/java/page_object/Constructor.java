package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Constructor extends BaseSettings {
    //buns button
    private final By buns = By.xpath("//span[.='Булки']");
    //sauces button
    private final By sauces = By.xpath("//span[.='Соусы']");
    //fillings button
    private final By fillings = By.xpath("//span[.='Начинки']");
    // button after clicking (that could be buns, sauces or fillings)
    private final By anyButtonAfterClicking = By.cssSelector(".tab_tab__1SPyG.tab_tab_type_current__2BEPc.pt-4.pr-10.pb-4.pl-10.noselect");
    //constructor panel
    private final By constructorPanel = By.xpath("//*[.='Соберите бургер']");
    //enter an account button Войти в аккаунт
    private final By enterAccountButton = By.xpath("//*[.='Войти в аккаунт']");

    public void clickBuns() {
        driver.findElement(buns).click();
    }

    public void clickSauces() {
        driver.findElement(sauces).click();
    }

    public void clickFillings() {
        driver.findElement(fillings).click();
    }

    public void clickEnterAnAccount() {
        driver.findElement(enterAccountButton).click();
    }

    public boolean isConstructorPanelHasAppeared() {
        return driver.findElement(constructorPanel).isDisplayed();
    }

    //button that we clicked on changes its class; we consider test positive if the class has been changed
    public boolean isBunsSectionWasChosen() {
        return driver.findElement(anyButtonAfterClicking).getText().equals("Булки");
    }

    public boolean isSaucesSectionWasChosen() {
        return driver.findElement(anyButtonAfterClicking).getText().equals("Соусы");
    }

    public boolean isFillingsSectionWasChosen() {
        return driver.findElement(anyButtonAfterClicking).getText().equals("Начинки");
    }

    public Constructor(WebDriver driver) {
        super(driver);
    }
}
