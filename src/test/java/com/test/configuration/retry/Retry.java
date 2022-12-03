package com.test.configuration.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int count=0;
    static int  maxretryCount=2;
    @Override
    public boolean retry(ITestResult iTestResult) {

        if(count<maxretryCount){
            count++;
            return true;
        }else{
            return false;
        }

    }
}
