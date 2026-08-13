package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    By jsAlertButton = By.cssSelector("button[onclick='jsAlert()']");
    By jsConfirmButton = By.cssSelector("button[onclick='jsConfirm()']");
    By jsPromptButton = By.cssSelector("button[onclick='jsPrompt()']");
    By resultLocator = By.id("result");

    public void triggerAlert() {
        driver.findElement(jsAlertButton).click();
    }

    public void triggerConfirm() {
        driver.findElement(jsConfirmButton).click();
    }

    public void triggerPrompt() {
        driver.findElement(jsPromptButton).click();
    }

    public void acceptDialog() {
        waitForAlert().accept();
    }

    public void dismissDialog() {
        waitForAlert().dismiss();
    }

    public void enterPromptTextAndAccept(String text) {
        Alert alert = waitForAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResult() {
        return driver.findElement(resultLocator).getText();
    }
}
