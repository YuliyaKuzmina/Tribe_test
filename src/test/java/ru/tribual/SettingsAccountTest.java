package ru.tribual;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.tribual.common.BaseTest;

public class SettingsAccountTest extends BaseTest {
    @Test
    public void settingsAccount () {
    WebDriver driver = getDriver();

    String newLogin = "jkuzzz";
    driver.findElement(By.xpath("//*[@alt='profile avatar']")).click();
    getWait5();
    driver.findElement(By.xpath("//li[contains (text(), 'Настройки')]")).click();

    driver.findElement(By.xpath("(//*[@class='_form__input_clear_zs1xn_140'])[1]")).click();
    driver.findElement(By.xpath("//input[@placeholder='Логин *']")).sendKeys(newLogin);

    driver.findElement(By.xpath("(//*[@class='_form__input_clear_zs1xn_140'])[2]")).click();
    driver.findElement(By.xpath("//input[@placeholder='Имя']")).sendKeys("YuliyA");

    driver.findElement(By.xpath("(//*[@class='_form__input_clear_zs1xn_140'])[3]")).click();
    driver.findElement(By.xpath("//input[@placeholder='Фамилия']")).sendKeys("Кузьмина");

    driver.findElement(By.xpath("//p[contains(text(), 'Сохранить изменения')]")).click();

    Assert.assertEquals(driver.findElement(By.xpath("//*[@class='_user__username_zs1xn_80']")).getText(),"@"+ newLogin);
    }

    @Test
    public void settingsBirthDay () {
        WebDriver driver = getDriver();
        driver.findElement(By.xpath("//*[@alt='profile avatar']")).click();
        getWait5();
        driver.findElement(By.xpath("//li[contains (text(), 'Настройки')]")).click();

        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("1985-05-09"); // Разобраться с вводом в секции дд.мм.гггг

        driver.findElement(By.xpath("//p[contains(text(), 'Сохранить изменения')]")).click();

       // Assert.assertEquals(driver.findElement(By.xpath("//input[@type='date']")).getText("1985-05-09"));
    }
}
