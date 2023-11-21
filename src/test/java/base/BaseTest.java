package base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import configuration.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class BaseTest {
    WebDriverManager driver = new WebDriverManager();

    public void switchTab(String tabName) {
        WebDriver driver = WebDriverRunner.getWebDriver();

        for(String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().contains(tabName)) {
                return;
            }
        }
    }

    public void openBrowser(String url){
        driver.browserUp(url);
    }

    @AfterEach
    public void closeBrowser() {
        driver.browserTearDown();
    }

}
