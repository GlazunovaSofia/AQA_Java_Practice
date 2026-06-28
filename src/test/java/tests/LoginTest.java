package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest{

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productPage.getTitle(), "Products", "Заголовок страницы не соответствует");
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"incorrrectLogin", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user", "incorrectPassword", "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username is required"},
                {"Standard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(dataProvider = "incorrectLoginData", testName = "Авторизация под кредами: {0, 1}")
    public void checkIncorrectLogin(String login, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(login, password);

        assertTrue(loginPage.isErrorDisplayed(), "Сообщение об ошибке не отображается");
        assertEquals(loginPage.getErrorText(), errorMessage, "Сообщение об ошибке не соответствует");
    }
}
