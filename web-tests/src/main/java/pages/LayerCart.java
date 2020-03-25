package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayerCart extends Basepage {

    //@FindBy(xpath = "//*[@id='layer_cart']//a[@title='Proceed to checkout']")
    @FindBy(css = "#layer_cart a[title='Proceed to checkout']")
    protected WebElement btn_proceedToCheckout;

    public LayerCart() {
        initElements(this);
    }

    public Orderpage proceedToOrderPage() throws Exception {
        waitUntilElementIsClickable(btn_proceedToCheckout);
        btn_proceedToCheckout.click();
        return new Orderpage();
    }
}
