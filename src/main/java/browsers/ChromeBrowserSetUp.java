package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeBrowserSetUp implements BrowserDriver {
    public static ChromeOptions chromeOptions;

    @Override
    public WebDriver getDriver() {
        setPathForDriver();
        return new ChromeDriver(chromeOptions());
    }

    private ChromeOptions chromeOptions() {
        chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--lang=en");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        return chromeOptions;
    }

    @Override
    public void setPathForDriver() {
        WebDriverManager.chromedriver().setup();
    }
}
