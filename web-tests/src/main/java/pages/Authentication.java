package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Authentication extends Basepage {

    @FindBy(id = "email")
    protected WebElement signInEmail;

    @FindBy(id = "passwd")
    protected WebElement signInPwd;

    @FindBy(id = "SubmitLogin")
    protected WebElement btn_signIn;

    @FindBy(id = "email_create")
    protected WebElement txt_emailAddress;

    @FindBy(id = "SubmitCreate")
    protected WebElement btn_createAnAccount;

    public Authentication() {
        initElements(this);
    }

    public MyAccount signIn(String existingUserEmail, String existingUserPassword) {
        enterText(signInEmail, existingUserEmail);
        enterText(signInPwd, existingUserPassword);
        btn_signIn.click();
        return new MyAccount();
    }

    public boolean isEmailDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        return isElementDisplayed(signInEmail);
    }
}
