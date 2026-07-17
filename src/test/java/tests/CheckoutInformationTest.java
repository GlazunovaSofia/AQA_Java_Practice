package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.OrderUser;
import static enums.TitleNaming.CHECKOUT_OVERVIEW;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

@Story("Заполнение информации о заказе")
@Issue("SauseDemo")
@Owner("Sofia Glazunova")
public class CheckoutInformationTest extends BaseTest {

    @Description("Проверка перехода к странице просмотра информации о заказе при корректных кредах")
    @Test(description = "Проверка перехода к странице просмотра информации о заказе при корректных кредах", priority = 1, enabled = true)
    public void checkCorrectInfo() {
        loginPage
                .open()
                .login(withAdminPermission());
        productPage.addGoodsToCart("Sauce Labs Backpack");
        productPage.navigationalPanel.switchToBasket();
        basketPage.clickOnCheckoutButton();

        checkoutInformationPage.fillOrderInfo(new OrderUser("Sofia", "Glazunova", "343434"));

        assertEquals(productPage.getTitle(), CHECKOUT_OVERVIEW.getDisplayName(), "Заголовок страницы не соответствует");
    }

    @DataProvider(name = "incorrectOrderData")
    public Object[][] orderData() {
        return new Object[][] {
                  {new OrderUser("", "", ""), "Error: First Name is required"},
                  {new OrderUser("", "Glazunova", "343434"), "Error: First Name is required"},
                  {new OrderUser("Sofia", "", "343434"), "Error: Last Name is required"},
                  {new OrderUser("Sofia", "Glazunova", ""), "Error: Postal Code is required"},
        };
    }

    @Description("Проверка сообщения об ошибках при некорректных кредах")
    @Test(dataProvider = "incorrectOrderData")
    public void checkIncorrectOrderInfo(OrderUser orderUser, String errorMessage) {
        loginPage
                .open()
                .login(withAdminPermission());
        productPage.addGoodsToCart("Sauce Labs Backpack");
        productPage.navigationalPanel.switchToBasket();
        basketPage.clickOnCheckoutButton();

        checkoutInformationPage.fillOrderInfo(orderUser);

        assertTrue(checkoutInformationPage.isErrorDisplayed(), "Сообщение об ошибке не отображается");
        assertEquals(checkoutInformationPage.checkErrorColor(), "rgba(226, 35, 26, 1)", "Цвет блока сообщения об ошибке не соответствует ожидаемому");
        assertEquals(checkoutInformationPage.getErrorText(), errorMessage, "Сообщение об ошибке не соответствует ожидаемому");
    }
}
