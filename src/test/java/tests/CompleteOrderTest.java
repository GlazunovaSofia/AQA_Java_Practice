package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import user.OrderUser;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Story("Проверка страницы с сообщением об успешном заказе")
@Issue("SauseDemo")
@Owner("Sofia Glazunova")
public class CompleteOrderTest extends BaseTest {

    @Description("Проверка отображения галочки успешного заказа")
    @Test(description = "Проверка отображения галочки успешного заказа", priority = 2)
    public void checkCompleteLabelDisplayed() {
        loginPage
                .open()
                .login(withAdminPermission());
        productPage.addGoodsToCart("Sauce Labs Backpack");
        productPage.navigationalPanel.switchToBasket();
        basketPage.clickOnCheckoutButton();
        checkoutInformationPage.fillOrderInfo(new OrderUser("Sofia", "Glazunova", "343434"));
        checkoutOverviewPage.clickOnFinishButton();

        assertTrue(completeOrderPage.isCompleteLabelDisplayed(), "Галочка успешного заказа не отображается");
    }

    @Description("Проверка содержания заголовка об успешном заказе")
    @Test(description = "Проверка содержания заголовка об успешном заказе", priority = 2)
    public void checkCompleteTextDisplayed() {
        loginPage
                .open()
                .login(withAdminPermission());
        productPage.addGoodsToCart("Sauce Labs Backpack");
        productPage.navigationalPanel.switchToBasket();
        basketPage.clickOnCheckoutButton();
        checkoutInformationPage.fillOrderInfo(new OrderUser("Sofia", "Glazunova", "343434"));
        checkoutOverviewPage.clickOnFinishButton();

        assertEquals(completeOrderPage.getCompleteHeaderText(), "Thank you for your order!", "Текст об успешном заказе не соответствует");
    }

    @Description("Проверка названия и цвета кнопки возврата на главную страницу")
    @Test(description = "Проверка названия и цвета кнопки возврата на главную страницу", priority = 3)
    public void checkBackHomeButton() {
        loginPage
                .open()
                .login(withAdminPermission());
        productPage.addGoodsToCart("Sauce Labs Backpack");
        productPage.navigationalPanel.switchToBasket();
        basketPage.clickOnCheckoutButton();
        checkoutInformationPage.fillOrderInfo(new OrderUser("Sofia", "Glazunova", "343434"));
        checkoutOverviewPage.clickOnFinishButton();

        assertEquals(completeOrderPage.getBackHomeButtonText(), "Back Home", "Название кнопки возврата на главную страницу не соответствует");
        assertEquals(completeOrderPage.checkBackHomeButtonColor(), "rgba(61, 220, 145, 1)", "Цвет кнопки возврата на главную страницу не соответствует");
    }

    @Description("Проверка открытия бургер-меню")
    @Test(description = "Проверка открытия бургер-меню", priority = 2)
    public void checkBurgerMenuOpen() {
        loginPage
                .open()
                .login(withAdminPermission());
        productPage.addGoodsToCart("Sauce Labs Backpack");
        productPage.navigationalPanel.switchToBasket();
        basketPage.clickOnCheckoutButton();
        checkoutInformationPage.fillOrderInfo(new OrderUser("Sofia", "Glazunova", "343434"));
        checkoutOverviewPage.clickOnFinishButton();
        completeOrderPage.navigationalPanel
                .switchToBurgerMenu()
                .waitUntilBurgerMenuOpen();

        assertTrue(completeOrderPage.navigationalPanel.isBurgerMenuOpen(), "Бургер-меню не открылось");
    }

    @Description("Проверка закрытия бургер-меню")
    @Test(description = "Проверка закрытия бургер-меню", priority = 2)
    public void checkBurgerMenuClose() {
        loginPage
                .open()
                .login(withAdminPermission());
        productPage.addGoodsToCart("Sauce Labs Backpack");
        productPage.navigationalPanel.switchToBasket();
        basketPage.clickOnCheckoutButton();
        checkoutInformationPage.fillOrderInfo(new OrderUser("Sofia", "Glazunova", "343434"));
        checkoutOverviewPage.clickOnFinishButton();
        completeOrderPage.navigationalPanel
                                        .switchToBurgerMenu()
                                        .waitUntilBurgerMenuOpen()
                                        .closeBurgerMenu()
                                        .waitUntilBurgerMenuClose();

        assertFalse(completeOrderPage.navigationalPanel.isBurgerMenuOpen(), "Бургер-меню не закрылось");
    }
}
