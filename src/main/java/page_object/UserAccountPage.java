package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserAccountPage extends BaseSettings {

    //exit button
    private final By exitButton = By.xpath("//button[.='Выход']");
    //profile button
    private final By profileButton = By.xpath("//a[.='Профиль']");

    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    public void waitForAProfileButtonToAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileButton));
    }

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }
}
