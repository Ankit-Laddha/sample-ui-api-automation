package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public synchronized static WebDriver getWebDriver() {
        return webDriver.get();
    }

    public synchronized static void setWebDriver(WebDriver webDriver) {
        DriverManager.webDriver.set(webDriver);
    }

    public synchronized static void quitWebDriver() {
        WebDriver driver = webDriver.get();
        if (driver != null) {
            driver.quit();
        }
    }
}
