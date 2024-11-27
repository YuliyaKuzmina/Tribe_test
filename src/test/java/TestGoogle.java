import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestGoogle {
   WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void baseURL() {
        driver.get("https://tribual.ru");
        driver.manage().window().maximize();
    }
    @Test
    public void testDriver() {
       // driver.get("https://tribual.ru");
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        System.out.println(pageTitle.equals("Tribe"));

    }

    @Test
    public void testSearch() throws InterruptedException {
        //driver.get("https://tribual.ru");
        WebElement textSearch = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/input")); //*[@id="root"]/div/div[1]/div/div[2]/div[1]/input
        textSearch.sendKeys("Москва");
        textSearch.sendKeys(Keys.ENTER);
        //WebElement title = driver.findElement(By.className("MuiTypography-root MuiTypography-body2 css-681fs5"));
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[1]/a/p"));

        Assert.assertEquals(title.getText(), "г. Москва");
        driver.quit();
    }

    @Test
    public void testCreateButton() {
        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[2]/div/button"));
        createButton.click();
       // WebElement helloTitle = driver.findElement(By.className("_modal_title_1gz4i_5"));
        WebElement helloTitle = driver.findElement(By.xpath("//*[contains(text(), 'Привет!')]"));
        System.out.println(helloTitle.equals("Привет!"));

        Assert.assertEquals(helloTitle.getText(), "Привет!");
        driver.quit();
    }

    @Test
    public void testAuthorisation() throws InterruptedException {
        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[2]/div/button"));
        createButton.click();
        WebElement enterMode = driver.findElement(By.id("simple-tab-0"));
        //WebElement enterButton = driver.findElement(By.tagName("button"));
        //WebElement enterButton = driver.findElement(By.className("MuiButtonBase-root MuiTab-root MuiTab-textColorPrimary Mui-selected css-bsxtvb"));
        //WebElement indicator = driver.findElement(By.xpath("//*[contains(text(), 'Вход')]"));
        Assert.assertEquals(enterMode.getText(), "ВХОД");

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("prodigy.u1+2@mail.ru");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("qwerty66");
        WebElement enterBut = driver.findElement(By.xpath("//*[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary css-1yf7mds']"));
        enterBut.click();

        WebElement avatar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/div"));
        Thread.sleep(1000);
        avatar.click();
        //driver.get("https://tribual.ru/#/profile/myevents");
        Thread.sleep(2000);

        WebElement profile = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/ul/a[1]/li"));
        profile.click();
        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.xpath("//*[contains (text(), '@LadyBug')]"));

        Assert.assertEquals(userName.getText(), "@LadyBug");
        driver.quit();
    }
}
