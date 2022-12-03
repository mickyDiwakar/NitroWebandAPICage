package com.test.stepDepfs;

import com.test.pages.CommonPages.BasePage;
import com.test.pages.Pages.loginPage;
import com.test.pages.Pages.searchbtn;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomepageStepdef extends  BasePage {
    //SharedContext context;

    WebDriver driver;
    loginPage lp;
    searchbtn sb;

Scenario scn;
    public HomepageStepdef(SharedContext context) {
        driver= context.finalDriver();
         lp=  new loginPage(driver);
         sb=new searchbtn();
         scn = context.getScn();
    }

    /*@When("^I will enter the {string}$")
        public void i_will_enter_the_and(String string, String string2) {
            System.out.println("india is my count"+ string+string2);
           lp.enterValue(string);

        }*/
    @When("I will click on {string} login btn")
    public void i_will_click_on_login_btn(String s) throws InterruptedException {

        System.out.println("i will click on login btn");
       // System.out.println( commonMethod.getDriver());

        //loginPage.checkloginpage();
       lp.enterValue(s);
        scn.log("1001");
       // SharedContext.get.log("1001");
        Thread.sleep(3000);

    }


    @And("I try to get chnaged value")
    public void iTryToGetChnagedValue() {
        System.out.println(Thread.currentThread().getId()+"...........");
        System.out.println(Thread.currentThread().getId()+"leastthread"+"..........."+getMap("fname"));
        System.out.println(Thread.currentThread().getId()+"................"+scn.getName());
    }


}
