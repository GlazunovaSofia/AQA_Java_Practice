package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.OrderUser;

public class CheckoutInformationPage extends BasePage {
    private final By firstNameInput = By.xpath("//input[@placeholder='First Name']");
    private final By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
    private final By zipCodeInput = By.xpath("//input[@placeholder='Zip/Postal Code']");
    private final By continueButton = By.xpath(DATA_TEXT_PATTERN.formatted("continue"));
    private final By error = By.xpath(DATA_TEXT_PATTERN.formatted("error"));
    private final By errorContainer = By.xpath("//div[starts-with(@class, 'error-message-container')]");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public void fillOrderInfo(OrderUser orderUser) {
        fillFirstNameInput(orderUser.getFirstName());
        fillLastNameInput(orderUser.getLastName());
        fillZipCodeInput(orderUser.getZipCode());
        driver.findElement(continueButton).click();
    }

    public void fillFirstNameInput(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void fillLastNameInput(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void fillZipCodeInput(String zipCode) {
        driver.findElement(zipCodeInput).sendKeys(zipCode);
    }

    public boolean isErrorDisplayed(){
        return driver.findElement(error).isDisplayed();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    public String checkErrorColor() {
        return driver.findElement(errorContainer).getCssValue("background-color");
    }
}
