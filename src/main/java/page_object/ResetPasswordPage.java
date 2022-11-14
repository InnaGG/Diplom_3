package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage extends BasePage {

    //entry button
    private final By entryButton = By.xpath("//*[.='Войти']");

    @Step("Кликнуть кнопку Входа")
    public void clickEntryButton() {
        driver.findElement(entryButton).click();
    }

    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }
}
