package tests;

import org.testng.annotations.Test;
import pages.Home;
import pages.MyAccount;
import utils.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class SignInTest extends BaseTest {

    String existingUserEmail = "ankit.laddha+demo@live.com";
    //This pwd is incorrect. Use your own account pls
    String existingUserPassword = "test@123";

    @Test(priority = 1, groups = {"login", "smoke"})
    public void loginWithExistingUser_should_be_successful() throws Exception {
        String fullName = "Ankit Laddha";
        Home homepage = new Home();
        MyAccount myAccount = homepage.header.initiateSignIn().signIn(existingUserEmail, existingUserPassword);
        myAccount.waitForMyAccountToLoad();

        assertThat(myAccount.getHeaderText()).isEqualTo("MY ACCOUNT");
        assertThat(homepage.header.getUserDetails()).isEqualTo(fullName);
        assertThat(myAccount.getWelcomeText()).contains("Welcome to your account.");
        Thread.sleep(5000);
        //Failing this specifically to capture screenshot and display in reports
        assertThat(homepage.header.isLogoutDisplayed()).isTrue();
        assertThat(driver.getCurrentUrl()).contains("controller=my-account");
    }

}