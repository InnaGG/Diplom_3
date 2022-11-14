package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {
    //constructor button in header
    private final By constructorButton = By.xpath("//a[.='Конструктор']");
    //logo
    private final By logo = By.xpath("//div/a/svg");
    //user account
    private final By userAccount = By.xpath("//a[.='Личный Кабинет']");

    @Step("Кликнуть кнопку Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Кликнуть лого")
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    @Step("Кликнуть Личный кабинет")
    public void clickUserAccount() {
        driver.findElement(userAccount).click();
    }

    public Header(WebDriver driver) {
        super(driver);
    }
}
