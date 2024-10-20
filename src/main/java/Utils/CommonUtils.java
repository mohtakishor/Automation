package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUtils {

    public void selectFromDropDown(WebElement element, String value) {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(value);
    }

    public void clickAndSend(WebElement element, String value) {
        element.click();
        element.sendKeys(value);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void clear(WebElement element) {
        element.clear();
    }

    public String getText(WebElement element) {
        String text = element.getText();
        Log.info("Fetched Text is : " + text);
        return text;
    }

    public WebElement explicitWait(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30));
        WebElement elementFound = wait.until(ExpectedConditions.visibilityOf(element));
        return elementFound;
    }

    public void waitForElement(WebElement element, WebDriver driver) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofMillis(40));
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}
