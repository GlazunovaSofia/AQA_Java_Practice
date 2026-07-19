package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import static enums.TitleNaming.*;
import static org.testng.Assert.*;
import static user.UserFactory.*;

@Story("Ввод персональных данных")
@Severity(SeverityLevel.BLOCKER)
@Issue("SauseDemo")
@Owner("Sofia Glazunova")
public class LoginTest extends BaseTest{

    @Description("Проверка перехода к товарам при корректных кредах")
    @Test(description = "Проверка перехода к товарам при корректных кредах", priority = 1)
    public void checkLogin() {
        loginPage
                .open()
                .login(withAdminPermission());

        assertEquals(productPage.getTitle(), PRODUCTS.getDisplayName(), "Заголовок страницы не соответствует");
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {withIncorrectLogin(), "Epic sadface: Username and password do not match any user in this service"},
                {withEmptyLogin(), "Epic sadface: Username is required"},
                {withEmptyPassword(), "Epic sadface: Password is required"},
                {withIncorrectPassword(), "Epic sadface: Username and password do not match any user in this service"},
                {withEmptyLoginAndPassword(), "Epic sadface: Username is required"},
                {withLoginWithUpperCase(), "Epic sadface: Username and password do not match any user in this service"},
                {withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Description("Проверка сообщений об ошибках при некорректных кредах")
    @Test(dataProvider = "incorrectLoginData", testName = "Авторизация под кредами: {0, 1}")
    public void checkIncorrectLogin(User user, String errorMessage) {
        loginPage
                .open()
                .login(user);

        assertTrue(loginPage.isErrorDisplayed(), "Сообщение об ошибке не отображается");
        assertEquals(loginPage.getErrorText(), errorMessage, "Сообщение об ошибке не соответствует");
    }
}
