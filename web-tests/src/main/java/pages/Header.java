package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends Basepage {

    @FindBy(id = "search_query_top")
    protected WebElement searchBox;

    @FindBy(name = "submit_search")
    protected WebElement submitSearchBtn;

    @FindBy(className = "login")
    protected WebElement signIn;

    @FindBy(className = "account")
    protected WebElement userDetails;

    @FindBy(className = "logout")
    protected WebElement logout;

    public Header() {
        initElements(this);
    }

    public Authentication initiateSignIn() {
        waitUntilElementIsClickable(signIn);
        signIn.click();
        return new Authentication();
    }

    public CategoryPage search(String productName) {
        enterText(searchBox, productName);
        submitSearchBtn.click();
        return new CategoryPage();
    }

    public String getUserDetails() {
        return userDetails.getText();
    }

    public boolean isLogoutDisplayed() {
        return isElementDisplayed(logout);
    }

    public CategoryPage gotoCategory(String categoryName) {
        driver.findElement(By.linkText(categoryName)).click();
        return new CategoryPage();
    }
}
