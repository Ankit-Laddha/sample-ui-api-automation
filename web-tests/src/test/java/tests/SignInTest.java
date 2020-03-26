package tests;

import org.testng.annotations.Test;
import pages.Home;
import pages.MyAccount;
import utils.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class SignInTest extends BaseTest {

    String existingUserEmail = System.getenv("DEMO_UNAME");

    String existingUserPassword = System.getenv("DEMO_PWD");

    @Test(priority = 1, groups = {"login", "smoke"})
    public void loginWithExistingUser_should_be_successful() throws Exception {

        logger.info("Starting Test: loginWithExistingUser_should_be_successful");
        String fullName = "Ankit Laddha";
        Home homepage = new Home();
        MyAccount myAccount = homepage.header.initiateSignIn().signIn(existingUserEmail, existingUserPassword);
        myAccount.waitForMyAccountToLoad();

        assertThat(myAccount.getHeaderText()).isEqualTo("MY ACCOUNT");
        assertThat(homepage.header.getUserDetails()).isEqualTo(fullName);
        assertThat(myAccount.getWelcomeText()).contains("Welcome to your account.");

        assertThat(webDriver.getCurrentUrl()).contains("controller=my-account");

        assertThat(homepage.header.isLogoutDisplayed()).isTrue();
    }

}
