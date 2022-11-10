package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryPage extends BaseSettings {

    //field email
    private final By emailField = By.xpath("//*[.='Email']/input");
    //field password
    private final By passwordField = By.xpath("//*[.='Пароль']/input");
    //button Enter
    private final By entryButton = By.xpath("//*[.='Войти']");

    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickEntryButton() {
        driver.findElement(entryButton).click();
    }

    public void waitForEntryFormToAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
    }

    public EntryPage(WebDriver driver) {
        super(driver);
    }
}
