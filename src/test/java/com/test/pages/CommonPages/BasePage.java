package com.test.pages.CommonPages;


import com.test.configuration.configManager.ManageConfig;

import com.test.configuration.driver.BrowserFactory;
import com.test.configuration.driver.DriverManager;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class BasePage{

   //private volatile static ConcurrentHashMap map= new ConcurrentHashMap();
   protected static ThreadLocal<HashMap<String,Object>> sharddata=new ThreadLocal<HashMap<String,Object>>(){
       @Override
       protected HashMap<String,Object> initialValue(){
           return new HashMap<>();
       }
   };

    public Object getMap(String Key){
      return  sharddata.get().get(Key);
        //return map.get(Key);
    }
    public void setMap(String Key,Object value){
        sharddata.get().put(Key,value);
        //map.put(Key,value);

    }

 /*public void invokeBrowser(WebDriver driver){
        BrowserFactory.getInstanceBrowserFactory().initDriver();
       driver= DriverManager.getthreadlocaldriver();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(ManageConfig.getManageConfigInstance().getPropertiesConfigurator().implicitTimeout(),TimeUnit.SECONDS);


    }*/

/*public  WebDriver getDriver(){
        this.driver= DriverManager.getthreadlocaldriver();
        return  driver;
    }

public void setDriver(){
        WebDriver ldriver=   BrowserFactory.getInstanceBrowserFactory().initDriver();
        DriverManager.setthreadlocaldriver(ldriver);
    }*/


    public void getnagivationUrl(WebDriver driver){

        driver.get(ManageConfig.getPropertiesConfigurator().protalUrl());
    }
    public void closeBrowser(WebDriver driver){
        driver.close();

    }




    public void enterKeys(WebDriver driver,WebElement ele, String value){
        WebDriverWait wait =new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.sendKeys(value);
        // getFinalDriver().findElement(By.name("q")).sendKeys("Test");
    }
    public byte[] takeScreenshots(WebDriver driver) throws IOException {
        TakesScreenshot ts=(TakesScreenshot)driver;
      byte[] bytevalue= ts.getScreenshotAs(OutputType.BYTES);
           return bytevalue;

    }
    public void takeScreenshots(WebDriver driver, Scenario s) throws IOException {

        TakesScreenshot ts=(TakesScreenshot)driver;
        File f= ts.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("d-MM-YYYY");
         String Date= simpleDateFormat.format(new Date());
        String path="target/Screenshot/"+Date+"/"+s.getName()+"/"+System.currentTimeMillis()+".png";
        FileUtils.copyFile(f,new File(path));


    }
    public void waitForPageLoad(WebDriver driver){
        new WebDriverWait(driver,20).
                until((ExpectedCondition<Boolean>)wd->
                        ((JavascriptExecutor)wd).executeScript("return document.readyState").equals("complete"));
    }
    public void switchToParticularWindow(WebDriver driver,String window){
        driver.switchTo().window(window);
    }

    public int getNumberofWindow(WebDriver driver){
        try{
          return  driver.getWindowHandles().size();
        }catch(Exception e){
            throw e;
        }


    }
    public String getParentWindow(WebDriver driver){
        return driver.getWindowHandle();
    }
    public void switchToChildWindow(WebDriver driver){
        try{
            new WebDriverWait(driver,20)
                    .until((ExpectedCondition<Boolean>)wd->
                            wd.getWindowHandles().size()>1);
            Iterator<String>handles=driver.getWindowHandles().iterator();
            while(handles.hasNext()){
                String childWindow=handles.next();
                if(childWindow!=getParentWindow(driver)){
                    driver.switchTo().window(childWindow);
                    break;
                }

            }

        }
        catch(Exception e){
            System.out.println("No mutiple window present");
        }

    }
    public void switchToChildWindow(WebDriver driver,int childwindowindex){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.numberOfWindowsToBe(childwindowindex));
       Set<String> windowHandles=driver.getWindowHandles();
       Iterator<String> iterator=windowHandles.iterator();
       while(iterator.hasNext()){

       }


    }


}
