package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;
@SuppressWarnings("unchecked")
public class BasePage<Page extends BasePage<Page>> {

    SelenideElement logoWithTitle = $x("//div[@class='pm-logo__name__title']");
    public Page checkTitle(String mainTitle){
        logoWithTitle.shouldHave(Condition.text(mainTitle));
        return (Page) this;
    }

    public Page clickLogo(String mainTitle) {
        $x("//a[@class='pm-logo__name']").click();
        return (Page) this;
    }

    public Page chooseTab(String tabName) {
        $x("//div[contains(@class, 'tabs ')]//a[text()='%s']".formatted(tabName)).shouldBe(Condition.visible).doubleClick();
        return (Page) this;
    }

    public Page checkCurrencyURL(String expectedUrl) {
        String currentUrl =  WebDriverRunner.url();
        Assertions.assertEquals(expectedUrl,currentUrl, "Url: " + expectedUrl + " не совпадает с текущим");
        return (Page) this;
    }
}
