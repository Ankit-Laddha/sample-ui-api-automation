package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import java.time.Duration;

public abstract class Basepage {

    protected WebDriver driver;

    protected void initElements(Object instance) {
        this.driver = WebDriverFactory.getCurrentDriver();
        PageFactory.initElements(this.driver, instance);
    }

    protected void enterText(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    protected void waitUntilElementIsClickable(WebElement element) {
        waitUntilElementIsDisplayed(element);
        new WebDriverWait(this.driver, 30)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilElementIsDisplayed(WebElement element) {
        FluentWait<WebElement> wait = new FluentWait<>(element);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.until(webElement -> isElementDisplayed(webElement));
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (TimeoutException e) {
            return false;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }
}
