
package tests;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import modelObject.AlertModel;
import org.testng.annotations.Test;
import pages.AlertsWindows;
import pages.HomePage;
import sharedData.Hooks;
import sharedData.SharedData;

public class AlertTest extends Hooks {
    ElementsMethods elementsMethods;
    AlertsMethods alertsMethods;

    @Test

    public void metodaTest() {

        elementsMethods = new ElementsMethods(getDriver());
        alertsMethods = new AlertsMethods(getDriver());
        AlertModel testData = new AlertModel("src/test/resources/inputData/AlertResource.json");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertsWindows alertsWindows = new AlertsWindows(getDriver());
        alertsWindows.clickAlert();
        alertsWindows.dealAlertProcess(testData);
    }
}