package Utils;

import browsers.WebDriverManager;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Log {
    protected WebDriver driver;
    ExtentTest test;

    @BeforeClass
    public void setup() {
        driver = WebDriverManager.getDriver();
        Log.info("Launching URL : " + Constants.URL);
        driver.get(Constants.URL);
    }

    @BeforeMethod
    public void genrateReport(ITestResult result) {
        ExtentReportManager.getInstance();
        test = ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @AfterClass
    public void tearDown() {
        Log.info("Quiting Web Driver");
        ExtentReportManager.flush();
        WebDriverManager.quitDriver();
    }
}