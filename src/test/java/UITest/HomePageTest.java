package UITest;

import Utils.BaseTest;
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
        Assert.assertEquals(pageTitle, "Buy Plants Online | Order Live Plants for Sale | Lively Root", "Failed to verify pageTitle");
        Assert.assertTrue(homePage.isLogoVisible(), "Logo is not visible");
        Assert.assertTrue(homePage.isSearchBoxVisible(), "Search box is not visible");
    }

    @Test
    public void verifyValidSearchFunctionality() {
        homePage.search("Fiddle Leaf Fig");
        homePage.submitSearch();
        homePage.getTextForSuccessSearchResult();
        driver.navigate().back();
    }

    @Test
    public void verifyPartialSearchFunctionality() {
        homePage.search("Fiddle");
        homePage.submitSearch();
        homePage.getTextForSuccessSearchResult();
        driver.navigate().back();
    }

    @Test
    public void verifyZCaseInsensitiveSearchTest() {
        homePage.search("fIDDLE LEAF fig");
        homePage.submitSearch();
        homePage.getTextForSuccessSearchResult();
        driver.navigate().back();
    }

    @Test
    public void verifyZNumericSearchTest() {
        homePage.search("123456");
        System.out.println(homePage.getTextForFailureMessage());
    }
}