package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends Basepage {

    public Header header;

    @FindBy(id = "homeslider")
    protected WebElement slider;

    public Home() {
        initElements(this);
        header = new Header();
    }

    public Home openHomePage() {
        driver.get("http://automationpractice.com/index.php");
        waitUntilElementIsDisplayed(slider);
        return this;
    }

}
