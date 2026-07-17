package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.util.List;
import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Story("Добавление товаров в корзину")
@Issue("SauseDemo")
@Owner("Sofia Glazunova")
public class ProductsTest extends BaseTest {
    List<String> allGoodsList =
            List.of(
                    "Sauce Labs Backpack",
                    "Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Onesie",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Fleece Jacket",
                    "Test.allTheThings() T-Shirt (Red)");

    @Description("Проверка цвета каунтера")
    @Test(description = "Проверка цвета каунтера", priority = 3)
    public void checkGoodsAdded() {
        loginPage
                .open()
                .login(withAdminPermission());

        assertEquals(productPage.getTitle(), PRODUCTS.getDisplayName(), "Заголовок страницы не соответствует");

        productPage.addGoodsToCart("Sauce Labs Backpack");
        assertEquals(productPage.checkCounterValue(), "rgba(226, 35, 26, 1)");
    }

    @Description("Проверка отображения каунтера")
    @Test(description = "Проверка отображения каунтера", priority = 2)
    public void checkCounterDisplayed() {
        loginPage
                .open()
                .login(withAdminPermission());
        productPage.addGoodsToCart("Sauce Labs Backpack");

        assertTrue(productPage.isCounterDisplayed(), "Каунтер не отображается");
    }

    @Description("Проверка значения каунтера")
    @Test(description = "Проверка значения каунтера", priority = 1)
    public void checkCounterValue() {
        loginPage
                .open()
                .login(withAdminPermission());
        productPage.addGoodsToCart("Sauce Labs Bike Light");

        assertEquals(productPage.counterValue(), "1", "Некорректное отображение счетчика товаров в корзине.");
    }

    @Description("Проверка цвета каунтера при добавлении всех товаров в корзину")
    @Test(description = "Проверка цвета каунтера при добавлении всех товаров в корзину", priority = 3)
    public void checkAllGoodsAddedCounter() {
        List<String> goodsForAdded = allGoodsList;

        loginPage
                .open()
                .login(withAdminPermission());

        for (String goods : goodsForAdded) {
            productPage.addGoodsToCart(goods);
        }

        assertTrue(productPage.isCounterDisplayed(), "Счетчик не отображается");
        assertEquals(productPage.checkCounterValue(), "rgba(226, 35, 26, 1)", "Некорректный цвет счетчика");
    }

    @Description("Проверка значения каунтера при добавлении всех товаров в корзину")
    @Test(description = "Проверка значения каунтера при добавлении всех товаров в корзину", priority = 1)
    public void checkAllGoodsAddedCounterValue() {
        List<String> goodsForAdded = allGoodsList;

        loginPage
                .open()
                .login(withAdminPermission());

        for (String goods : goodsForAdded) {
            productPage.addGoodsToCart(goods);
        }

        assertEquals(productPage.counterValue(), String.valueOf(goodsForAdded.size()), "Некорректное отображение счетчика товаров в корзине.");
    }
}
