package com.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        plugin= {"pretty","html:target/cucumber-reports/cucumber-pretty",
                "json:target/target1/cucumber-reports/cucumberTestReport.json",
                "html:target/target1/cucumber-reports/cucumberTestReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun=false,
        monochrome=true,
        glue={"classpath:com/test/stepDepfs"},

        tags= "@smoke",
        features="@target/rerun.txt"

)
public class TestZReRunner extends AbstractTestNGCucumberTests {

}
