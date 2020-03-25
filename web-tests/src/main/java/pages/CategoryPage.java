package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends Basepage {

    public CategoryPage() {
        initElements(this);
    }

    @FindBy(linkText = "More")
    protected WebElement more;

    public ProductPage openProductByName(String productName) {

        WebElement element = driver.findElement(By.xpath(String.format("//a[@title='%s']/ancestor::li", productName)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        waitUntilElementIsDisplayed(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().perform();
        action.moveToElement(more).click(more).build().perform();
        return new ProductPage();
    }
}
