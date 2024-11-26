package ru.tribual;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFirefox {
    WebDriver driver = new FirefoxDriver();
    @BeforeMethod
    public  void baseURL() {driver.get("https://tribual.ru");}

    @Test
    public void testDriver() {
        driver.get("https://tribual.ru");
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        System.out.println(pageTitle.equals("Tribe"));
        Assert.assertEquals(pageTitle, "Tribe");
        driver.quit();
    }
    @Test
    public void testSearch() throws InterruptedException {
        driver.get("https://tribual.ru");
        WebElement textSearch = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/input")); //*[@id="root"]/div/div[1]/div/div[2]/div[1]/input
        textSearch.sendKeys("Москва");
        textSearch.sendKeys(Keys.ENTER);
        //WebElement title = driver.findElement(By.className("MuiTypography-root MuiTypography-body2 css-681fs5"));
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[1]/a/p"));

        Assert.assertEquals(title.getText(), "г. Москва");
    }
}
