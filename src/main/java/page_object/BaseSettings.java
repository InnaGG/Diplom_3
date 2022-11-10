package page_object;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class BaseSettings {

    protected final WebDriver driver;

    public BaseSettings(WebDriver driver) {
        this.driver = driver;
    }

    public void waitFor5Seconds() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
