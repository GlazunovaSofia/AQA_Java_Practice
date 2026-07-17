package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import user.OrderUser;
import java.util.List;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

@Story("Проверка информации о заказе")
@Issue("SauseDemo")
@Owner("Sofia Glazunova")
public class CheckoutOverviewTest extends BaseTest{

    @Description("Проверка наличия всех товаров в заказе")
    @Test(description = "Проверка наличия всех товаров в заказе", priority = 1)
    public void checkCorrectProductsInOrder(){
        List<String> goodsList =
                List.of(
                        "Sauce Labs Backpack",
                        "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Onesie");

        loginPage
                .open()
                .login(withAdminPermission());

        for (String goods : goodsList) {
            productPage.addGoodsToCart(goods);
        }

        productPage.navigationalPanel.switchToBasket();
        basketPage.clickOnCheckoutButton();
        checkoutInformationPage.fillOrderInfo(new OrderUser("Sofia", "Glazunova", "343434"));

        assertTrue(checkoutOverviewPage.getProductsNamesInOrder().equals(goodsList));
    }

    @Description("Проверка стоимости товаров в заказе (строка Item total)")
    @Test(description = "Проверка стоимости товаров в заказе", priority = 1)
    public void checkCorrectCostInOrder(){
        List<String> goodsList =
                List.of(
                        "Sauce Labs Backpack",
                        "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Onesie");

        loginPage
                .open()
                .login(withAdminPermission());

        for (String goods : goodsList) {
            productPage.addGoodsToCart(goods);
        }

        productPage.navigationalPanel.switchToBasket();
        basketPage.clickOnCheckoutButton();
        checkoutInformationPage.fillOrderInfo(new OrderUser("Sofia", "Glazunova", "343434"));

        assertTrue(checkoutOverviewPage.getRealCostInOrder().equals(checkoutOverviewPage.getCoastInOrder()));
    }
}
