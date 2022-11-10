package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage extends BaseSettings {

    //entry button
    private final By entryButton = By.xpath("//*[.='Войти']");

    public void clickEntryButton() {
        driver.findElement(entryButton).click();
    }

    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }
}
