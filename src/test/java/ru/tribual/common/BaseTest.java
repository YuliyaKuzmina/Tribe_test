package ru.tribual.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class BaseTest {
    private WebDriverWait wait5;
    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod(Method method){
        driver = ProjectUtils.createDriver();
        ProjectUtils.get(driver);
    }

    protected WebDriver getDriver() {
        return driver;}
}
