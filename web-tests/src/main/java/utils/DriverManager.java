package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.stqa.selenium.factory.WebDriverPool;

public class DriverManager {

    //Get Chrome Options
    public static WebDriver getChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver getFireFox() {
        WebDriverManager.firefoxdriver().setup();
        return WebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
    }
}
