package UITest;

import Utils.BaseTest;
import Utils.Log;
import modules.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass
    public void setupPage() {
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyHomePage() {
        String pageTitle = homePage.getPageTitle();
        Log.info("Fetching Page title");
        Assert.assertEquals(pageTitle, "Buy Plants Online | Order Live Plants for Sale | Lively Root", "Failed to verify pageTitle");
        Log.info("Verifying Logo");
        Assert.assertTrue(homePage.isLogoVisible(), "Logo is not visible");
        Log.info("Verifying Search Box");
        Assert.assertTrue(homePage.isSearchBoxVisible(), "Search box is not visible");
    }

    @Test
    public void verifyValidSearchFunctionality() {
        Log.info("Searching for Valid text");
        homePage.search("Fiddle Leaf Fig");
        homePage.submitSearch();
        Log.info("Fetching the text after search");
        homePage.getTextForSuccessSearchResult();
        Log.info("Navigating back to Home Page");
        driver.navigate().to("https://www.livelyroot.com/");
    }

    @Test
    public void verifyPartialSearchFunctionality() {
        Log.info("Searching for Partial Valid text");
        homePage.search("Fiddle");
        homePage.submitSearch();
        Log.info("Fetching the text after search");
        homePage.getTextForSuccessSearchResult();
        Log.info("Navigating back to Home Page");
        driver.navigate().to("https://www.livelyroot.com/");
    }

    @Test
    public void verifyZCaseInsensitiveSearchTest() {
        Log.info("Searching for CASE Insensitive Valid text");
        homePage.search("fIDDLE LEAF fig");
        homePage.submitSearch();
        Log.info("Fetching the text after search");
        homePage.getTextForSuccessSearchResult();
        Log.info("Navigating back to Home Page");
        driver.navigate().to("https://www.livelyroot.com/");
    }

    @Test
    public void verifyZNumericSearchTest() {
        Log.info("Searching for Non Valid text");
        homePage.search("123456");
        homePage.submitSearch();
        Log.info("Fetching the text after search");
        System.out.println(homePage.getTextForFailureMessage());
    }
}
