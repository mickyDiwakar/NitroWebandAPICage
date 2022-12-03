package com.test.stepDepfs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DemoSD {
    static WebDriver wdriver;
    @When("^I will enter the deatils$")
        public void iwilleneterdeatil(DataTable dt){
     //   DataTable dt = null;
        List<Map<String,String>>map=dt.asMaps(String.class,String.class);
        WebElement ele=wdriver.findElement(By.id("yearbox"));
        WebDriverWait wait=new WebDriverWait(wdriver,15);
        wait.until(ExpectedConditions.visibilityOf(ele));
        /*driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-invalid-required ng-touched']"))
                .sendKeys("diwakar");*/
        //WebElement ele=driver.findElement(By.id("yearbox"));
        wdriver.findElement(By.xpath("//input[@type='email']")).sendKeys(map.get(0).get("Data"));
        Select s=new Select(ele);
        s.selectByVisibleText("1916");
        s.selectByIndex(2);
       WebElement elements= wdriver.findElement(By.id("Skills"));
      List<WebElement>ddvalue= elements.findElements(By.tagName("option"));
        System.out.println(ddvalue.get(1).getText());
       for(WebElement e:ddvalue){
           System.out.println(e.getText());
           if(e.getText().equalsIgnoreCase("Analytics")){
               e.click(); break;
           }


       }

        }

    @Then("Verfiy few {string} links")
    public void verfiyFewLinks(String value) {

       List<WebElement>tabs= wdriver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li"));
       tabs.get(3).click();
       Actions actions=new Actions(wdriver);
       WebElement actionalert=wdriver.findElement(By.xpath("//a[contains(@href,'Alerts')]"));

       actions.moveToElement(actionalert).click().perform();
       wdriver.findElement(By.xpath("//li/a[contains(text(),'Alert with Textbox')]")).click();
       wdriver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
       wdriver.switchTo().alert().sendKeys(value);

        wdriver.switchTo().alert().accept();

    }

    @Given("I will login to the application with {string}")
    public void iWillLoginToTheApplicationWith(String url) {
        WebDriverManager.chromedriver().setup();
        wdriver=new ChromeDriver();
        wdriver.manage().deleteAllCookies();
        wdriver.manage().window().maximize();
        wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wdriver.get(url);
        wdriver.findElement(By.xpath("//input[contains(@placeholder,'Email')]")).sendKeys("diwisuji@gmail.com");
        wdriver.findElement(By.xpath("//a[contains(@href,'Register')]")).click();
    }


}
