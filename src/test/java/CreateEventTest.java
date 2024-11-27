import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class CreateEventTest {
    WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void baseURL() {
        driver.get("https://tribual.ru");
        driver.manage().window().maximize();
        WebElement avatar = driver.findElement(By.xpath("//div[@class=\"MuiBox-root css-0\"]"));
        avatar.click();
        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("prodigy.u1+2@mail.ru");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("qwerty66");
        WebElement enter = driver.findElement(By.xpath("//*[contains (text(), 'Войти')]"));
        enter.click();
    }

    @Test
    public void createButton() throws InterruptedException {
        WebElement createButton = driver.findElement(By.xpath("//*[contains (text(), '+ Создать событие')]"));
        createButton.click();
        WebElement inputCity = driver.findElement(By.xpath("//input[@placeholder=\"Выберите город\"]"));
        inputCity.sendKeys("Пенза");
       // inputCity.sendKeys(Keys.ENTER);
        //Select drpCity= new Select(driver.findElement(By.xpath("//Input[@id='asynchronous']")));
       // drpCity.selectByVisibleText("г. Пенза");
       // drpCity.selectByValue("asynchronous-option-0");
        Thread.sleep(3000);
        WebElement listCity = driver.findElement(By.xpath("//*[contains (text(), 'г. Пенза')]"));
        listCity.click();
        Thread.sleep(2000);

        //WebElement inputAdress = driver.findElement(By.xpath("//input[@placeholder=\"Выберите город\"]"));
       // inputAdress.sendKeys("Мос");
    }
}
