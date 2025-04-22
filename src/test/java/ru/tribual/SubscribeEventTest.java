package ru.tribual;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.tribual.common.BaseTest;

import java.util.List;

public class SubscribeEventTest extends BaseTest {
    @Test
    public  void alreadyHaveSubscribtionToEvent () {
        WebDriver driver = getDriver();
        driver.findElement(By.xpath("//*[@placeholder='Поиск...']")).sendKeys("Генерал");
        driver.findElement(By.xpath("//div[@title='спектакль «Генерал и его семья» в Театре имени Вахтангова']")).click();


        List<WebElement> buttons = driver.findElements(By.xpath("//*[contains(text(), 'Я пойду')]/parent::button"));


      //  boolean isVisible = button.isDisplayed(); //true если видим кнопку

         if  (buttons.isEmpty() == false) {
             driver.findElement(By.xpath("//*[contains(text(), 'Я пойду')]/parent::button")).click();
             driver.findElement(By.xpath("//*[contains(text(), 'Подтвердить')]")).click();
         } else {
           WebElement subscribeButton = driver.findElement(By.xpath("//*[contains(text(), 'Вы идете на это событие')]/parent::button"));
             Assert.assertTrue(subscribeButton.isDisplayed(), "Вы уже подписаны на это событие");
         }

//       String expectedUrl = "https://tribual.ru/#/fid/15575";
//       String actualUrl = driver.getCurrentUrl();
//      Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
