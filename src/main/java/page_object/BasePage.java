package page_object;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitFor5Seconds() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
