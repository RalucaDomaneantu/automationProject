package tests;

import helpMethods.ElementsMethods;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    ElementsMethods elementsMethod;

    @Test

    public void metodaTest() {

        elementsMethod = new ElementsMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickWebTable();

        WebTablePage webTablesPage = new WebTablePage(getDriver());
        webTablesPage.createProcess();
        webTablesPage.editProcess();
        webTablesPage.deleteProcess();

    }
}