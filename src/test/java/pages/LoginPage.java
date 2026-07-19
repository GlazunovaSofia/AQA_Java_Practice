package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private final By loginInput = By.xpath(DATA_TEXT_PATTERN.formatted("username"));
    private final By passwordInput = By.xpath("//input[@id='password']");
    private final By submitButton = By.xpath("//input[@id='login-button']");
    private final By error = By.xpath(DATA_TEXT_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие стартовой страницы")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Логин на сайте")
    public LoginPage login(User user) {
        fillLoginField(user.getName());
        fillPasswordField(user.getPassword());
        driver.findElement(submitButton).click();
        return this;
    }

    @Step("Заполнение поля логина")
    public void fillLoginField(String login) {
        driver.findElement(loginInput).sendKeys(login);
    }

    @Step("Заполнение поля пароля")
    public void fillPasswordField(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Проверка отображения блока с информацией об ошибке при некорректных кредах")
    public boolean isErrorDisplayed(){
        return driver.findElement(error).isDisplayed();
    }

    @Step("Получение текста в блоке с информацией об ошибке при некорректных кредах")
    public String getErrorText() {
        return driver.findElement(error).getText();
    }
}
