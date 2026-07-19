package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompleteOrderPage extends BasePage {
    private final By completeLabel = By.xpath(DATA_TEXT_PATTERN.formatted("pony-express"));
    private final By completeHeader = By.xpath(DATA_TEXT_PATTERN.formatted("complete-header"));
    private final By backHomeButton = By.xpath(DATA_TEXT_PATTERN.formatted("back-to-products"));

    public CompleteOrderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка отображения галочки об успешном оформлении заказа")
    public boolean isCompleteLabelDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completeLabel)).isDisplayed();
    }

    @Step("Получение текста об успешном оформлении заказа")
    public String getCompleteHeaderText() {
        return driver.findElement(completeHeader).getText();
    }

    @Step("Получение названия кнопки Bach Home")
    public String getBackHomeButtonText() {
        return driver.findElement(backHomeButton).getText();
    }

    @Step("Получение цвета кнопки Bach Home")
    public String checkBackHomeButtonColor() {
        return driver.findElement(backHomeButton).getCssValue("background-color");
    }
}
