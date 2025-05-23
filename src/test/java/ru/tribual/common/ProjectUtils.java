package ru.tribual.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Properties;

public final class ProjectUtils {
    private static final Properties properties;

    private static final ChromeOptions chromeOptions;

    static {
        properties = new Properties();
        chromeOptions = new ChromeOptions();
        String options = getValue("browser." + "chrome");
    }

    static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //ожидает пока загрузится страница поиска элемента перед следующим шагом (минимум 0,5 сек - макс - 2 сек)

        return driver;
    }

    private static String convertPropToEnvName(String propName) {
        return propName.replace('.', '_').toUpperCase();
    }

    private static String getValue(String name) {
        return properties.getProperty(name, System.getenv(convertPropToEnvName(name)));
    }

    static void get(WebDriver driver) {
        driver.get(getURL());
    }

    static String getURL() {
        String baseURL = "https://tribual.ru";
        return baseURL;
    }
}
