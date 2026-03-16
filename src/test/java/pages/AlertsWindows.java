
package pages;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import modelObject.AlertModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AlertsWindows extends BasePage{

    public WebDriver driver;
    public ElementsMethods elementsMethods;
    public AlertsMethods alertsMethods;

    public AlertsWindows(WebDriver driver) {
        super(driver);
        this.driver = driver;
        elementsMethods= new ElementsMethods(this.driver);
        alertsMethods = new AlertsMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alert;

    @FindBy(id = "alertButton")
    private WebElement firstAlertElement;

    @FindBy(id ="timerAlertButton")
    private WebElement secondAlert;

    @FindBy(id = "confirmButton")
    private WebElement thirdAlertElement;

    @FindBy(id = "confirmResult")
    private WebElement textThirdAlert;

    @FindBy(id = "promtButton")
    private WebElement fourthAlertElement;

    public void clickAlert(){
        elementsMethods.javaScriptElement(alert);
        loggerUtility.infoLog("The user clicks on AlertSubmenu");
    }

    AlertModel testData = new AlertModel("src/test/resources/inputData/AlertResource.json");



    public  void dealAlertProcess(AlertModel testData){
        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethods.clickElement(firstAlertElement);
        loggerUtility.infoLog("THe user clicks on First Alert Element");
        alertsMethods.acceptAlert();
        loggerUtility.infoLog("The user accept the Alert");

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.clickElement(secondAlert);
        loggerUtility.infoLog("The user clicks on Second Alert Element");
        alertsMethods.acceptAlert();
        loggerUtility.infoLog("The user accept the Alert");


        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethods.clickElement(thirdAlertElement);
        loggerUtility.infoLog("The user clicks on Third Alert Element");

        boolean chooseAccept = true;  // pune false daca vrei Cancel
        alertsMethods.acceptAlert(chooseAccept);

        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String actualText = textThirdAlert.getText();
        alertsMethods.verifyConfirmAlert(actualText, true);
        loggerUtility.infoLog("The user verify if the alert is confirmed");

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethods.clickElement(fourthAlertElement);
        loggerUtility.infoLog("The user clicks on Fourth Alert Element");
        alertsMethods.fillAlert(testData.getAlertText());
        loggerUtility.infoLog("The user fills the Alert displayed");

    }
}
