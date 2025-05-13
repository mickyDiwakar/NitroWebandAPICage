package com.test.stepDepfs;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.configuration.driver.DriverManager;
import com.test.configuration.configManager.ManageConfig;

import com.test.pages.CommonPages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SharedContext extends BasePage {


    public  Scenario scn;

    public WebDriver driver;
    @Before
    public void setupforrestassured(Scenario scenario){
        scn = scenario;

        setMap("Scenario",scenario);
        setMap("scName",scenario.getName());
        System.out.println(scenario.getName());

    }
   // @Before()
public void setUp(Scenario scenario){
         scn = scenario;

         setMap("Scenario",scenario);
        setMap("scName",scenario.getName());
        System.out.println(scenario.getName());

 ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        extent.createTest(scenario.getName());
        invokeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));


    }

    public WebDriver invokeDriver(){
      driver= DriverManager.getInstanceDriverManager().getDriver();
         return driver;
    }
    public WebDriver finalDriver(){
        return driver;
    }

//@After()
    public void tearDown(Scenario scenario) throws IOException {
        scenario.attach(takeScreenshots(driver),"image/png",scenario.getName());

        driver.quit();
    }

  //  @AfterStep()
    public void AfterStep(Scenario scenario) throws IOException {
      byte[] screenshot=  takeScreenshots(driver);
      scenario.attach(screenshot,"image/png",scenario.getName());
        takeScreenshots(driver,scenario);

    }
    public Scenario getScn() {
        return scn;
    }
}
