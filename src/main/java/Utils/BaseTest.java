package Utils;

import browsers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverManager.getDriver();
        driver.get(Constants.URL);
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}