package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

   public WebDriver driver;


   @Test

    public void metodaTest(){

       //deschidem un browser
        driver= new ChromeDriver();
       JavascriptExecutor js = (JavascriptExecutor)driver;

        //accesam un URL;

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        WebElement elementsMeniu = driver.findElement(By.xpath("//h5[text()='Elements']"));
       js.executeScript("arguments[0].click();", elementsMeniu);

       WebElement webTable = driver.findElement(By.xpath("//span[text()='Web Tables']"));
       js.executeScript("arguments[0].click();", webTable);

       List<WebElement> continutTabel=driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
         // System.out.println("Dimensiunea tabelului este" +continutTabel.size());
       Assert.assertEquals(continutTabel.size(), 3, "Marimea tabelului nu este 3");


        //definim un element
       WebElement addEllement = driver.findElement(By.id("addNewRecordButton"));
       addEllement.click();

       WebElement firstNameElement = driver.findElement(By.id("firstName"));
       String firstName= "Raluca";
       firstNameElement.sendKeys(firstName);

       WebElement lastNameElement = driver.findElement(By.id("lastName"));
       String lastName= "Domaneantu";
       lastNameElement.sendKeys(lastName);

       WebElement emailElement = driver.findElement(By.id("userEmail"));
       String userEmail= "ralucadomaneantu@gmail.com";
       emailElement.sendKeys(userEmail);

       WebElement ageElement = driver.findElement(By.id("age"));
       String age= "39";
       ageElement.sendKeys(age);

       WebElement salaryElement = driver.findElement(By.id("salary"));
       String salary= "1000";
       salaryElement.sendKeys(salary);

       WebElement departmentElement = driver.findElement(By.id("department"));
       String department= "hr";
       departmentElement.sendKeys(department);

       WebElement submitEllement = driver.findElement(By.id("submit"));
       submitEllement.click();

// Validam noua dimensiune a tabelului

       List<WebElement> continutTabelNou=driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
       Assert.assertEquals(continutTabelNou.size(), 4, "Marimea tabelului nu este 4");

// Validam valorile pe care le-am introdus

       String continutRand = continutTabelNou.get(3).getText();
       Assert.assertTrue(continutRand.contains(firstName),"Randul nu contine first name");
       Assert.assertTrue(continutRand.contains(lastName), "Randul nu contine last name"  );
       Assert.assertTrue(continutRand.contains(userEmail),"Randul nu contine first email");
       Assert.assertTrue(continutRand.contains(age),"Randul nu contine age");
       Assert.assertTrue(continutRand.contains(salary),"Randul nu contine salary");
       Assert.assertTrue(continutRand.contains(department),"Randul nu contine department");


       //edit Functionality
       WebElement editElement = driver.findElement(By.id("edit-record-4"));
       editElement.click();


       WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
       editFirstNameElement.clear();
       String nume2="Richard";
       editFirstNameElement.sendKeys(nume2);

       WebElement editLastNameElement = driver.findElement(By.id("lastName"));
       editLastNameElement.clear();
       String nume3="Peter";
       editLastNameElement.sendKeys(nume3);

       WebElement editEmailElement = driver.findElement(By.id("userEmail"));
       editEmailElement.clear();
       String email2="ralustoica@gmail.com";
       editEmailElement.sendKeys(email2);

       WebElement editAgeElement = driver.findElement(By.id("age"));
       editAgeElement.clear();
       String age2="33";
       editAgeElement.sendKeys(age2);

       WebElement submitbutton2Button = driver.findElement(By.id("submit"));
       submitbutton2Button.click();


       WebElement deleteElement = driver.findElement(By.id("delete-record-4") );
       deleteElement.click();


       //driver.close();

       //daca vreti sa identificati un element doar dupa text, putem face asta doar cu XPath.
       //CSS Selector nu permite acest lucru.
       //XPath are o structura specifica: tag,atribut, valoare
       //CTRL + F ca sa deschida search-ul
       // formula pentru XPath //h5[text()='Elements']

    }

}




