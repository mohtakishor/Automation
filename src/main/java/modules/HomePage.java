package modules;

import Utils.CommonUtils;
import Utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonUtils {

    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='logo']")
    private WebElement logo;

    @FindBy(xpath = "//button[@aria-label='Search']")
    private WebElement searchIcon;

    @FindBy(xpath = "//div[@class='snize-no-products-found-text']")
    private WebElement failureMessage;

    @FindBy(xpath = "//div[@class=\"snize-search-results-header\"]")
    private WebElement searchResultMessage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLogoVisible() {
        return isElementDisplayed(logo);
    }

    public boolean isSearchBoxVisible() {
        return isElementDisplayed(searchBox);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clearSearchBoxText() {
        waitForElement(searchBox, driver);
        clear(searchBox);
    }

    public void search(String searchForPlants) {
        waitForElement(searchBox, driver);
        clickAndSend(searchBox, searchForPlants);
    }

    public void submitSearch() {
        click(searchIcon);
    }

    public String getTextForFailureMessage() {
        return getText(failureMessage);
    }

    public String getTextForSuccessSearchResult() {
        return getText(searchResultMessage);
    }
}
