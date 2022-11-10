package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BaseSettings {

    //field name
    private final By nameField = By.xpath("//*[.='Имя']/input");
    //field email
    private final By emailField = By.xpath("//*[.='Email']/input");
    //field password
    private final By passwordField = By.xpath("//*[.='Пароль']/input");
    //button "register"
    private final By registerButton = By.xpath("//*[.='Зарегистрироваться']");
    //button "Enter"
    private final By entryButton = By.className("Auth_link__1fOlj");
    //error 'Incorrect password'
    private final By incorrectPasswordError = By.xpath("//*[.='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void waitForLoginPageAfterRegistry() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
    }

    public boolean isErrorOfIncorrectPasswordDisplayed() {
        return driver.findElement(incorrectPasswordError).isDisplayed();
    }

    public void clickEntryButton() {
        driver.findElement(entryButton).click();
    }

}
