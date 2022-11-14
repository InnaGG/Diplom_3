package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryPage extends BasePage {

    //field email
    private final By emailField = By.xpath("//*[.='Email']/input");
    //field password
    private final By passwordField = By.xpath("//*[.='Пароль']/input");
    //button Enter
    private final By entryButton = By.xpath("//*[.='Войти']");

    @Step("Заполнить поле Email")
    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнить поле Пароль")
    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Кликнуть кнопку Войти")
    public void clickEntryButton() {
        driver.findElement(entryButton).click();
    }

    @Step("Ожидание, пока появится форма Хоум пейдж после входа")
    public void waitForEntryFormToAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
    }

    public EntryPage(WebDriver driver) {
        super(driver);
    }
}
