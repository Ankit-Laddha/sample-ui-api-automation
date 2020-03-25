package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    public static final String url = "http://automationpractice.com/index.php";

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setup(@Optional("chrome") String browser) {

        System.out.println("ABC = In setup() ");
        System.out.println("browser = " + browser);
        WebDriverFactory.init(browser);
        this.driver = WebDriverFactory.getCurrentDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get(url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDownNew() {
        System.out.println(" ABC = tearDownNew ");
        WebDriverFactory.getCurrentDriver().quit();
    }

}
