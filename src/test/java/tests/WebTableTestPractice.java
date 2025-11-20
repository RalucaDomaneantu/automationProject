package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class WebTableTestPractice extends SharedData {

    @Test

    public void metodaTest() {

        // deschidem un browser

        //getDriver()= new ChromeDriver();

        //accesam un URL

        getDriver().get("https://demoqa.com/webtables");

        getDriver().manage().window().maximize();

        // definim un element

        WebElement addElement = getDriver().findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstNameElement = getDriver().findElement(By.id("firstName"));
        String firstName = "Raluca";
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement = getDriver().findElement(By.id("lastName"));
        String lastName = "Domaneantu";
        lastNameElement.sendKeys(lastName);

        WebElement emailElement = getDriver().findElement(By.id("userEmail"));
        String email = "Raluca@gmail.com";
        emailElement.sendKeys(email);

        WebElement ageElement = getDriver().findElement(By.id("age"));
        String age = "30";
        ageElement.sendKeys(age);

        WebElement salaryElement = getDriver().findElement(By.id("salary"));
        String salary = "5000";
        salaryElement.sendKeys(salary);

        WebElement departamentElement = getDriver().findElement(By.id("department"));
        String departament = "calitate";
        departamentElement.sendKeys(departament);

        WebElement submitElement = getDriver().findElement(By.id("submit"));
        submitElement.click();
    }
    @Test
    public void metodaTest1() {

        // deschidem un browser

        //getDriver() = new ChromeDriver();

        //accesam un URL

        getDriver().get("https://demoqa.com/text-box");

        getDriver().manage().window().maximize();

        WebElement fullnameElement = getDriver().findElement(By.id("userName"));
        String fullname = "Raluca Domaneantu";
        fullnameElement.sendKeys(fullname);

        WebElement emailElement = getDriver().findElement(By.id("userEmail"));
        String email = "Raluca@gmail.com";
        emailElement.sendKeys(email);

        WebElement currentaddressElement = getDriver().findElement(By.id("currentAddress"));
        String currentaddress = "Timis";
        currentaddressElement.sendKeys(currentaddress);

        WebElement permanentaddressElement = getDriver().findElement(By.id("permanentAddress"));
        String permanentaddress = "Timisoara";
        permanentaddressElement.sendKeys(permanentaddress);

        WebElement submitElement = getDriver().findElement(By.id("submit"));
        submitElement.click();

    }
}