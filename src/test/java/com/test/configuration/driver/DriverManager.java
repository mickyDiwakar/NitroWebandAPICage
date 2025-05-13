package com.test.configuration.driver;



import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static DriverManager driverMaager=null;
    public  WebDriver driver;
    private DriverManager(){

    }
    public static DriverManager getInstanceDriverManager(){
        return ((driverMaager==null)?new DriverManager():driverMaager);
    }

    public  WebDriver getDriver(){
        //driver= BrowserFactory.getInstanceBrowserFactory().initDriver();
        return driver;
    }

    private static ThreadLocal<WebDriver>tldriver=new ThreadLocal<>();
    public static  WebDriver getthreadlocaldriver() {
        System.out.println(Thread.currentThread());
        return tldriver.get();
    }

    public static void setthreadlocaldriver(WebDriver bowseFactorydriver) {
          tldriver.set(bowseFactorydriver);
    }
    public static void unload(){
        tldriver.remove();
    }
}
