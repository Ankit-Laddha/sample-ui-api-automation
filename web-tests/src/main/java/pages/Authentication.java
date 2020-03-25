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

   /* public MyAccount createAnAccount() throws Exception {

        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";

        enterText(txt_emailAddress, email);
        Registration accountCreation = submit();
        return accountCreation.registerForAccount();

    }

    private Registration submit() throws Exception {
        btn_createAnAccount.click();
        return new Registration();
    }*/

    public MyAccount signIn(String existingUserEmail, String existingUserPassword) {
        enterText(signInEmail, existingUserEmail);
        enterText(signInPwd, existingUserPassword);
        btn_signIn.click();
        return new MyAccount();
    }
}
