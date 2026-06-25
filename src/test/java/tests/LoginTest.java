package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest{

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productPage.getTitle(), "Products", "Заголовок страницы не соответствует");
    }

    @Test
    public void checkIncorrectLogin() {
        loginPage.open();
        loginPage.login("incorrrectLogin", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Сообщение об ошибке не отображается");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username and password do not match any user in this service", "Сообщение об ошибке не соответствует");
    }

    @Test
    public void checkEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Сообщение об ошибке не отображается");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required", "Сообщение об ошибке не соответствует");
    }

    @Test
    public void checkEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");

        assertTrue(loginPage.isErrorDisplayed(), "Сообщение об ошибке не отображается");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Password is required", "Сообщение об ошибке не соответствует");
    }

    @Test
    public void checkIncorrectPassword() {
        loginPage.open();
        loginPage.login("standard_user", "incorrectPassword");

        assertTrue(loginPage.isErrorDisplayed(), "Сообщение об ошибке не отображается");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username and password do not match any user in this service", "Сообщение об ошибке не соответствует");
    }

    @Test
    public void checkEmptyPasswordAndLogin() {
        loginPage.open();
        loginPage.login("", "");

        assertTrue(loginPage.isErrorDisplayed(), "Сообщение об ошибке не отображается");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required", "Сообщение об ошибке не соответствует");
    }

    @Test
    public void checkIncorrectLoginWithUpperCase() {
        loginPage.open();
        loginPage.login("Standard_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Сообщение об ошибке не отображается");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username and password do not match any user in this service", "Сообщение об ошибке не соответствует");
    }

    @Test
    public void checkLoginWithBlockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Сообщение об ошибке не отображается");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Sorry, this user has been locked out.", "Сообщение об ошибке не соответствует");
    }
}
