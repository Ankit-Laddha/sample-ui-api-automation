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

    public ProductPage openProductByName(String productName) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(String.format("//a[@title='%s" +
                "']/ancestor::li", productName)));
        int counter = 0;
        do {

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                    element);

            waitUntilElementIsDisplayed(element);

            Actions action = new Actions(driver);
            action.moveToElement(element).click(element).build().perform();
            action.moveToElement(more).click(more).build().perform();
            Thread.sleep(2000);
        } while (isElementDisplayed(element) && counter++ < 3);

        return new ProductPage();
    }
}
