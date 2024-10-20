package Utils;

import browsers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Log{
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverManager.getDriver();
        driver.get(Constants.URL);
        openPage(Constants.URL);

    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}