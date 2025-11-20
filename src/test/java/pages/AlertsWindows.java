
package pages;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.util.Elements;

public class AlertsWindows {

    public WebDriver driver;
    public ElementsMethods elementsMethods;
    public AlertsMethods alertsMethods;

    public AlertsWindows(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        alertsMethods = new AlertsMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alert;

    @FindBy(id = "alertButton")
    private WebElement firstAlertElement;

    @FindBy(id = "timerAlertButton")
    private WebElement secondAlertButton;

    @FindBy(id = "confirmButton")
    private WebElement thirdAlertButton;

    @FindBy(id = "confirmResult")
    private WebElement textThirdAlert;

    @FindBy(id = "promtButton")
    private WebElement fourthAlertElement;

    public void clickAlert() {
        elementsMethods.javaScriptElement(alert);
    }

    public void dealAlertProcess() {
        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethods.javaScriptElement(firstAlertElement);
        alertsMethods.acceptAlert();

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.javaScriptElement(secondAlert);

        alertsMethods.acceptAlert();

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethods.javaScriptElement(thirdAlertElement);
        boolean chooseAccept = true;
        alertsMethods.acceptAlert(chooseAccept);

        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String actualText = textThirdAlert.getText();
        alertsMethods.verifyConfirmAlert(actualText, true);

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethods.clickElement(fourthAlertElement);
        alertsMethods.fillAlert("Buna ziua");
    }
}
