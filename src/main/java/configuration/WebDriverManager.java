package configuration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class WebDriverManager {
    static {
        Configuration.browser = "chrome";
        Configuration.browserPosition = "0x0";
        Configuration.browserVersion = "115.0";
        Configuration.timeout = 20 * 1000;
        Configuration.pageLoadTimeout = 30 * 1000;
        Configuration.browserSize = "1920x1080";
    }

    public void browserUp(String url) {
        Selenide.open(url);
    }

    public void browserTearDown() {
        Selenide.closeWebDriver();
    }
}
