import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        Thread.sleep(1000);
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

        WebElement inputAdress = driver.findElement(By.xpath("//input[@placeholder=\"Выберите адрес\"]"));
       // inputAdress.click();
        inputAdress.sendKeys("Мостовая 6");
        Thread.sleep(3000);
        WebElement listAdress = driver.findElement(By.xpath("//*[contains (text(), 'ул. Мостовая 6')]"));
        listAdress.click();

        WebElement nextButton = driver.findElement(By.xpath("//p[contains(text(), 'Далее')]"));
        Assert.assertTrue(nextButton.isDisplayed());
      // step 2
        nextButton.click();
        WebElement createEvent = driver.findElement(By.xpath("//div[contains (text(), 'Создание события')]"));
        Assert.assertEquals(createEvent.getText(), "Создание события");
        Thread.sleep(1000);
        //WebElement typeOfEvent = driver.findElement(By.xpath("//div[contains (text(), 'Выберите тип события')]"));
        WebElement typeOfEvent = driver.findElement(By.xpath("//div[@class = \" css-19bb58m\"]"));
        typeOfEvent.click();
        Thread.sleep(1000);
        WebElement traveling = driver.findElement(By.xpath("//div[contains (text(), 'Поездки')]"));
        traveling.click();
        WebElement setTypeOfEvent = driver.findElement(By.xpath("//div[@class=\" css-uwhgar-singleValue\"]"));
        Assert.assertEquals(setTypeOfEvent.getText(), "Поездки");

        WebElement eventName = driver.findElement(By.xpath("//input[@placeholder=\"Название\"]"));
        eventName.click();
        eventName.sendKeys("Сплав на байдарках");
        //eventName = driver.findElement(By.xpath("//input[@value=\"Сплав на байдарках\"]"));
        String value = eventName.getAttribute("value");
        Assert.assertEquals(value, "Сплав на байдарках");

        driver.quit();

    }
}
