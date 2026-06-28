package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productPage.getTitle(), "Products", "Заголовок страницы не соответствует");

        productPage.addGoodsToCart("Sauce Labs Backpack");
        assertEquals(productPage.checkCounterValue(), "rgba(226, 35, 26, 1)");
    }

    @Test
    public void checkCounterDisplayed() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addGoodsToCart("Sauce Labs Backpack");

        assertTrue(productPage.isCounterDisplayed(), "Каунтер не отображается");
    }

    @Test
    public void checkCounterValue() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addGoodsToCart("Sauce Labs Bike Light");

        assertEquals(productPage.counterValue(), "1", "Некорректное отображение счетчика товаров в корзине.");
    }
}
