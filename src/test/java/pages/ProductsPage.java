package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART = "//*[text() = '%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private final By title = By.xpath("//*[@class='title']");
    private final By counter = By.xpath(DATA_TEXT_PATTERN.formatted("shopping-cart-badge"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void addGoodsToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public String checkCounterValue() {
        return driver.findElement(counter).getCssValue("background-color");
    }

    public boolean isCounterDisplayed() {
        return driver.findElement(counter).isDisplayed();
    }

    public String counterValue() {
        return driver.findElement(counter).getText();
    }
}
