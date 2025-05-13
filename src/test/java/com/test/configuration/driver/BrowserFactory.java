package com.test.configuration.driver;


import com.test.configuration.configManager.ManageConfig;
import com.test.configuration.enums.BrowserType;
import com.test.utils.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

    private static BrowserFactory browserFactory=null;
    private WebDriver driver;
    private static String browser=  ManageConfig.getPropertiesConfigurator().browser();
    private static String environment= ManageConfig.getPropertiesConfigurator().environment();
    private BrowserFactory(){}

    public static BrowserFactory getInstanceBrowserFactory(){
        return (browserFactory==null)?new BrowserFactory():browserFactory;
    }


    public   WebDriver  initDriver(){
        if(environment.equalsIgnoreCase("LOCAL")){
            createLocalDriver(browser);
        }else{
            createRemoteDriver( browser);
        }

      return driver;
    }


    private WebDriver createLocalDriver(String browser){
       BrowserType browserType= getBrowserType(browser);
        if(BrowserType.CHROME.equals(browserType)){
            System.out.println(System.getProperty("user.dir"));
           // System.setProperty(Constant.WEB_CHROME_DRIVER, Constant.USER_DIR+"/browserdrivers/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options =new ChromeOptions();
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            if(driver==null){
                driver=new ChromeDriver(options);
            }

           // driver.get("https://google.com");


        } else if (BrowserType.FIREFOX.equals(browserType)) {
            System.setProperty(Constant.WEB_FF_DRIVER, Constant.USER_DIR+"/browserdrivers/chromedriver.exe");
            FirefoxOptions options =new FirefoxOptions();

            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
            driver=new FirefoxDriver(options);


        } else if (BrowserType.EDGE.equals(browserType)) {
            //DesiredCapabilities capabilities=DesiredCapabilities.chrome();
         //   capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

        }

        return driver;
    }
    private WebDriver createRemoteDriver(String browser){
        return driver;

    }
    private BrowserType getBrowserType(String browser){
        BrowserType browserType = null;
        switch(browser.toUpperCase()){
            case "CHROME":
                browserType= BrowserType.CHROME;
                break;

            case "FIREFOX" :
                browserType=  BrowserType.FIREFOX;
                break;

            case "EDGE":
                browserType= BrowserType.EDGE;
                break;

        }

        return browserType;
    }

}
