package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static final String url = "http://automationpractice.com/index.php";

    protected WebDriver webDriver;

    @Parameters({"browser"})
    @BeforeClass()
    public void setup(@Optional("chrome") String browser) {

        webDriver = DriverFactory.createInstance(browser);
        DriverManager.setWebDriver(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(url);
    }

    @AfterClass()
    public void tearDown() {
        DriverManager.quitWebDriver();
    }
}
