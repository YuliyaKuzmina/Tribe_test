package ru.tribual.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {
    private WebDriverWait wait5;
    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod(Method method){
        driver = ProjectUtils.createDriver();
        ProjectUtils.get(driver);
        TribeUtils.login(driver);
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult testResult) {
        if (testResult.isSuccess()) {
            driver.quit();
            wait5 = null;
        }
    }

    protected WebDriver getDriver() {
        return driver;}

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

        return wait5;
    }
}
