package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Orderpage extends Basepage {

    @FindBy(linkText = "Proceed to checkout")
    protected WebElement proceedToCheckout;

    public Orderpage() {
        initElements(this);
    }

    public Orderpage deleteProduct(String productName) {
        driver.findElement(By.linkText(productName))
                .findElement(By.xpath("ancestor::td//following-sibling::td[contains(@class,'cart_delete')]//i")).click();
        return new Orderpage();
    }

    public Authentication proceedToCheckout() {
        proceedToCheckout.click();
        return new Authentication();
    }
}
