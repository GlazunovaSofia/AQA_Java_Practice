import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest{
    By loginField = By.xpath("//input[@id='user-name']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//input[@id='login-button']");
    By titleOfSection = By.xpath("//*[@class='title']");
    By titleError = By.xpath("//h3[@data-test='error']");

    @Test
    public void checkLogin() {
        driver.findElement(loginField).sendKeys("standard_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
        String sectionName = driver.findElement(titleOfSection).getText();

        assertEquals(sectionName, "Products", "Заголовок страницы не соответствует");
    }

    @Test
    public void checkIncorrectLogin() {
        driver.findElement(loginField).sendKeys("45454545");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
        boolean isErrorTitleVisible = driver.findElement(titleError).isDisplayed();
        String errorText = driver.findElement(titleError).getText();

        assertTrue(isErrorTitleVisible, "Сообщение об ошибке не отображается");
        assertEquals(errorText, "Epic sadface: Username and password do not match any user in this service", "Сообщение об ошибке не соответствует");
    }

    @Test
    public void checkEmptyLogin() {
        driver.findElement(loginField).sendKeys("");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
        boolean isErrorTitleVisible = driver.findElement(titleError).isDisplayed();
        String errorText = driver.findElement(titleError).getText();

        assertTrue(isErrorTitleVisible, "Сообщение об ошибке не отображается");
        assertEquals(errorText, "Epic sadface: Username is required", "Сообщение об ошибке не соответствует");
    }
}
