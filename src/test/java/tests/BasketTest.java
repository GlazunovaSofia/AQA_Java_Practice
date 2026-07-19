package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import java.util.List;
import static enums.TitleNaming.CART;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Story("Проверка товаров в корзине")
@Issue("SauseDemo")
@Owner("Sofia Glazunova")
public class BasketTest extends BaseTest {
    List<String> allGoodsList =
            List.of(
                    "Sauce Labs Backpack",
                    "Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Onesie",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Fleece Jacket",
                    "Test.allTheThings() T-Shirt (Red)");

    @Description("Проверка перехода в корзину")
    @Test(description = "Проверка перехода в корзину", priority = 1, enabled = true)
    public void checkSwitchToBasket() {
        List<String> addGoodsList = allGoodsList;

        loginPage
                .open()
                .login(withAdminPermission());

        for (String goods : addGoodsList) {
            productPage.addGoodsToCart(goods);
        }
        productPage.navigationalPanel.switchToBasket();

        assertEquals(productPage.getTitle(), CART.getDisplayName(), "Заголовок страницы не соответствует");
    }

    @Description("Проверка наличия товаров в корзине")
    @Test(description = "Проверка наличия товаров в корзине", priority = 1, timeOut = 15000)
    public void checkProductsInBasket() {
        List<String> addGoodsList = allGoodsList;

        loginPage
                .open()
                .login(withAdminPermission());

        for (String goods : addGoodsList) {
            productPage.addGoodsToCart(goods);
        }
        productPage.navigationalPanel.switchToBasket();

        assertTrue(basketPage.getProductsNames().equals(allGoodsList));
    }

    @Description("Проверка удаления товара из корзины")
    @Test(description = "Проверка удаления товара из корзины", priority = 1, timeOut = 15000)
    public void checkRemoveProductInBasket() {
        List<String> goodsAddList =
                List.of(
                        "Sauce Labs Backpack",
                        "Sauce Labs Onesie");

        String removeGoods = "Sauce Labs Onesie";

        loginPage
                .open()
                .login(withAdminPermission());

        for (String goods : goodsAddList) {
            productPage.addGoodsToCart(goods);
        }

        productPage.navigationalPanel.switchToBasket();
        basketPage.removeGoodsFromBasket(removeGoods);

        assertFalse(basketPage.getProductsNames().contains(removeGoods), "Товар не удален из корзины");
    }
}
