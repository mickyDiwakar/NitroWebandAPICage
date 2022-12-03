package com.test.pages.Pages;


import com.test.pages.CommonPages.BasePage;
import com.test.pages.CommonPages.CommonMethod;

import com.test.stepDepfs.SharedContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends  BasePage {


     WebDriver driver;
    public loginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="q")
WebElement searchbox;




    public void enterValue(String s){
       // searchbox.sendKeys("a");

       enterKeys(driver,searchbox,s);
       // enterKeys(searchbox,s);
    }
    public void checkloginpage(){
        System.out.println("loginpagecheck");
    }
}
