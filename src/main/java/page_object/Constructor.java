package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Constructor extends BasePage {
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

    @Step("Кликнуть Булки")
    public void clickBuns() {
        driver.findElement(buns).click();
    }

    @Step("Кликнуть Соусы")
    public void clickSauces() {
        driver.findElement(sauces).click();
    }

    @Step("Кликнуть Начинки")
    public void clickFillings() {
        driver.findElement(fillings).click();
    }

    @Step("Кликнуть кнопку Войти")
    public void clickEnterAnAccount() {
        driver.findElement(enterAccountButton).click();
    }

    @Step("Кликнуть кнопку Войти")
    public boolean isConstructorPanelHasAppeared() {
        return driver.findElement(constructorPanel).isDisplayed();
    }

//button that we clicked on changes its class; we consider test positive if the class has been changed
    @Step("Проверка, что после клика на кнопку Булки сменился класс")
    public boolean isBunsSectionWasChosen() {
        return driver.findElement(anyButtonAfterClicking).getText().equals("Булки");
    }

    @Step("Проверка, что после клика на кнопку Соусы сменился класс")
    public boolean isSaucesSectionWasChosen() {
        return driver.findElement(anyButtonAfterClicking).getText().equals("Соусы");
    }

    @Step("Проверка, что после клика на кнопку Начинки сменился класс")
    public boolean isFillingsSectionWasChosen() {
        return driver.findElement(anyButtonAfterClicking).getText().equals("Начинки");
    }

    public Constructor(WebDriver driver) {
        super(driver);
    }
}
