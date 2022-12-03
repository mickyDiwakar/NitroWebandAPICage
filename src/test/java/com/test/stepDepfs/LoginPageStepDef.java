package com.test.stepDepfs;

import com.test.pages.CommonPages.BasePage;
import com.test.pages.Pages.searchbtn;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

public class LoginPageStepDef extends BasePage {

   public  WebDriver driver;
   public String  Threadcheck ;
   Scenario scn;
    searchbtn sb;
    public LoginPageStepDef(SharedContext context) {
        scn= context.getScn();
        driver= context.finalDriver();
        sb=new searchbtn();
    }

    @Given("^I will enter the url$")
    public void i_will_enter_the_url() {
        System.out.println("india is my count");
        // commonMethod.invokeBrowser();
        getnagivationUrl(driver);
        setMap("fname",Thread.currentThread().getId());
        System.out.println("..........."+getMap("fname"));

    }
    @Then("^I will verify the home page title$")
    public void i_will_verify_the_home_page_title() throws InterruptedException {
        System.out.println("I am on search btn");
        sb.getsearchbtn();
        System.out.println(Thread.currentThread().getId()+getMap("fname").toString());
        Thread.sleep(6000);
       scn.log( scn.getName());

    }



}
