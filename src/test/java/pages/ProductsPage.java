package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART = "//*[text() = '%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private final By title = By.xpath("//*[@class='title']");
    private final By counter = By.xpath(DATA_TEXT_PATTERN.formatted("shopping-cart-badge"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение заголовка страницы")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Добавление товаров в корзину")
    public void addGoodsToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    @Step("Проверка цвета каунтера")
    public String checkCounterValue() {
        return driver.findElement(counter).getCssValue("background-color");
    }

    @Step("Проверка отображения каунтера")
    public boolean isCounterDisplayed() {
        return driver.findElement(counter).isDisplayed();
    }

    @Step("Проверка значения каунтера")
    public String counterValue() {
        return driver.findElement(counter).getText();
    }
}
