package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By loginInput = By.xpath(DATA_TEXT_PATTERN.formatted("username"));
    private final By passwordInput = By.xpath("//input[@id='password']");
    private final By submitButton = By.xpath("//input[@id='login-button']");
    private final By error = By.xpath(DATA_TEXT_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String login, String password) {
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public boolean isErrorDisplayed(){
        return driver.findElement(error).isDisplayed();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }
}
