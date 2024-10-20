package browsers;

import org.openqa.selenium.WebDriver;

public interface BrowserDriver {

    WebDriver getDriver();

    void setPathForDriver();
}

