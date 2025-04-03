package ru.tribual;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.tribual.common.BaseTest;

import static org.testng.Assert.assertEquals;

public class SearchTest extends BaseTest {

    @Test
    public void testSearch() {
        WebDriver driver = getDriver();
        String title = driver.getTitle();
        assertEquals(title, "Tribe");

        WebElement search = driver.findElement(By.xpath("//*[@placeholder='Поиск...']"));
        search.sendKeys("Саратов");

        WebElement enterCity = driver.findElement(By.xpath("//*[@value='Саратов']"));
        //assertEquals(enterCity, "Саратов");
    }
}
