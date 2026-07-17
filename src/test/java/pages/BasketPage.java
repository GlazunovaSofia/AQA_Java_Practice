package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {
    private final By pageTitle = By.xpath("//*[@class='title']");
    private final By goodsTitle = By.cssSelector(".inventory_item_name");
    private final By checkoutButton = By.cssSelector("#checkout");
    public static final String REMOVE_FROM_BASKET = "//*[text() = '%s']//ancestor::div[@class='cart_item']//child::button[text()='Remove']";

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getProductsNames() {
        List<WebElement> allProducts = driver.findElements(goodsTitle);

        ArrayList<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void clickOnCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void removeGoodsFromBasket(String goodsName) {
        By removeFromBasket = By.xpath(REMOVE_FROM_BASKET.formatted(goodsName));
        driver.findElement(removeFromBasket).click();
    }
}
