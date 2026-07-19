package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;
import java.time.Duration;

public class BasePage {
    public static final String BASE_URL = PropertyReader.getProperty("sausedemo.url");
    public static final String DATA_TEXT_PATTERN = "//*[@data-test='%s']";
    WebDriver driver;
    WebDriverWait wait;
    public NavigationalPanel navigationalPanel;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.navigationalPanel = new NavigationalPanel(driver);
    }
}
