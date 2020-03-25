package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccount extends Basepage {

    @FindBy(css = "h1")
    protected WebElement heading;

    @FindBy(className = "info-account")
    protected WebElement account_welcome_msg;

    public MyAccount() {
        initElements(this);
    }

    public String getHeaderText() {
        return heading.getText();
    }

    public String getWelcomeText() {
        return account_welcome_msg.getText();
    }

    public void waitForMyAccountToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(it -> isElementDisplayed(heading));
    }
}
