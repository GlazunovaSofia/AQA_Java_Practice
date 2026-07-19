package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NavigationalPanel {
    WebDriver driver;
    WebDriverWait wait;
    private final By burgerMenuOpenButton = By.xpath("//button[starts-with(@id, 'react-burger-menu')]");
    private final By burgerMenuCloseButton = By.xpath("//button[starts-with(@id, 'react-burger-cross')]");
    private final By cartLink = By.cssSelector(".shopping_cart_link");

    public NavigationalPanel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Step("Открытие бургер-меню")
    public NavigationalPanel switchToBurgerMenu(){
        driver.findElement(burgerMenuOpenButton).click();
        return this;
    }

    @Step("Закрытие бургер-меню")
    public NavigationalPanel closeBurgerMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenuCloseButton)).click();
        return this;
    }

    @Step("Переход в корзину")
    public void switchToBasket() {
        driver.findElement(cartLink).click();
    }

    @Step("Проверка отображения бургер-меню")
    public boolean isBurgerMenuOpen(){
        return driver.findElement(burgerMenuCloseButton).isDisplayed();
    }

    @Step("Ожидание закрытия бургер-меню")
    public NavigationalPanel waitUntilBurgerMenuClose(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(burgerMenuCloseButton));
        return this;
    }

    @Step("Ожидание открытия бургер-меню")
    public NavigationalPanel waitUntilBurgerMenuOpen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(burgerMenuCloseButton));
        return this;
    }
}
