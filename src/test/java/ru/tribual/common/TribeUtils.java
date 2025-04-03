package ru.tribual.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TribeUtils {
    static void login(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div[2]")).click();
        driver.findElement(By.xpath("//*[@placeholder='Логин']")).sendKeys("prodigy.u1@mail.ru");
        driver.findElement(By.xpath("//*[@placeholder='Пароль']")).sendKeys("asdfg123");
        driver.findElement(By.xpath("//*[@id='simple-tabpanel-0']/div/form/div[2]/button")).click();
    }
}
