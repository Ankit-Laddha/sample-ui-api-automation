package tests;

import org.testng.annotations.Test;
import pages.Home;
import pages.Orderpage;
import utils.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test(priority = 3, groups = {"checkout", "smoke"})
    public void checkoutTest() throws Exception {
        logger.info("Starting Test: checkoutTest" );
        Home homepage = new Home();

        homepage
                .header
                .gotoCategory("Women")
                .openProductByName("Printed Chiffon Dress")
                .addToCartDefault();

        homepage
                .openHomePage()
                .header
                .gotoCategory("Women")
                .openProductByName("Faded Short Sleeve T-shirts")
                .addToCartDefault();

        homepage
                .openHomePage()
                .header
                .search("Blouse")
                .openProductByName("Blouse")
                .addToCartDefault()
                .proceedToOrderPage();

        new Orderpage()
                .deleteProduct("Blouse")
                .proceedToCheckout();
    }
}
