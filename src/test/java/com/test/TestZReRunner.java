package com.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.IOException;
import java.util.*;

@CucumberOptions(
        plugin= {"pretty","html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/cucumberrerunTestReport.json",
                "html:target/cucumber-reports/cucumberrerunTestReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun=false,
        monochrome=true,
        glue={"classpath:com/test/stepDepfs"},

       // tags= "@smoke",
        features="@target/rerun.txt"

)
public class TestZReRunner extends AbstractTestNGCucumberTests {


}
