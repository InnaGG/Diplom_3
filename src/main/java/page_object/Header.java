package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BaseSettings {
    //constructor button in header
    private final By constructorButton = By.xpath("//a[.='Конструктор']");
    //logo
    private final By logo = By.xpath("//div/a/svg");
    //user account
    private final By userAccount = By.xpath("//a[.='Личный Кабинет']");

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickUserAccount() {
        driver.findElement(userAccount).click();
    }

    public Header(WebDriver driver) {
        super(driver);
    }
}
