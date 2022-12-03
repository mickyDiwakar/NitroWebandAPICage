package com.test.stepDepfs;

import com.test.pages.CommonPages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Threadmethod extends BasePage {
    static String  key="fname";
    int s=10;
    @When("I enter value in map")
    public void iEnterValueInMap() {
       String  Value1= String.valueOf(Thread.currentThread().getId());

        setMap(key,Value1);
        System.out.println(Thread.currentThread().getId()+"..........."+s);
        System.out.println(Thread.currentThread().getId()+"..........."+getMap(key));
    }

    @Then("I retrive value in thread")
    public void iRetriveValueInThread() {
        System.out.println(Thread.currentThread().getId()+"..........."+s);
        System.out.println(Thread.currentThread().getId()+"..........."+getMap(key));
    }
    @Then("I retrive value in thread again")
    public void iRetriveValueInThreadagain() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getId()+"..........."+s);
        System.out.println(Thread.currentThread().getId()+"leastthread"+"..........."+getMap(key));
    }
    @And("I change value in map")
    public void iChangeValueInMap() {
        s=s+1;
    }
}
