package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Basepage {

    @FindBy(name = "Submit")
    protected WebElement btn_addToCart;

    public ProductPage() {
        initElements(this);
    }

    public LayerCart addToCartDefault() {
        btn_addToCart.click();
        return new LayerCart();
    }
}
