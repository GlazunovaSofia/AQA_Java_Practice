package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class CheckoutOverviewPage extends BasePage {
    private final By finishButton = By.xpath(DATA_TEXT_PATTERN.formatted("finish"));
    private final By goodsTitle = By.cssSelector(".inventory_item_name");
    private final By goodsCost = By.cssSelector(".inventory_item_price");
    private final By orderPrice = By.cssSelector(".summary_subtotal_label");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFinishButton() {
        driver.findElement(finishButton).click();
    }

    public ArrayList<String> getProductsNamesInOrder() {
        List<WebElement> allProducts = driver.findElements(goodsTitle);

        ArrayList<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }

    public String getRealCostInOrder() {
        List<WebElement> allPrices = driver.findElements(goodsCost);

        double cost = 0.00;

        for (WebElement price : allPrices) {
            String textPrice = price.getText().replace("$", "");
            cost += Double.parseDouble(textPrice);
        }
        return String.valueOf(cost);
    }

    public String getCoastInOrder(){
        return driver.findElement(orderPrice).getText().replace("Item total: $", "");
    }
}
