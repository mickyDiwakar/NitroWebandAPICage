package com.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        plugin= {"pretty","html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/cucumberTestReport.json",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"
        },
        dryRun=false,
        monochrome=true,
        glue={"classpath:com/test/stepDepfs"},
        features="classpath:features",
        tags= "@testcon"
)
//from cmd run the command to retry run //mvn clean test -Dsurefire.rerunFailingTestsCount=2
public class TestRunner extends AbstractTestNGCucumberTests {

    //retry 1. run from testngxml,2. run testrunner from cmd 3. the command metioned above if you wnat to chnage the retry count


// run parallel by making parrael true and count is in pom.xml or mvn clean test -DthreadCount=2
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
