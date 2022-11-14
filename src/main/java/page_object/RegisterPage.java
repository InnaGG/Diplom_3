package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BasePage {

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

    @Step("Заполнить поле Имя")
    public void fillName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Заполнить поле Email")
    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнить поле Пароль")
    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Кликнуть кнопку - Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Ожидание, пока появится страничка логина после регистрации")
    public void waitForLoginPageAfterRegistry() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
    }

    @Step("Проверка, отображается ли ошибка при введении неправильного пароля")
    public boolean isErrorOfIncorrectPasswordDisplayed() {
        return driver.findElement(incorrectPasswordError).isDisplayed();
    }

    @Step("Кликнуть кнопку Входа")
    public void clickEntryButton() {
        driver.findElement(entryButton).click();
    }

}
