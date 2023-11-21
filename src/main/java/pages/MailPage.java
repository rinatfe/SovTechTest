package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class MailPage extends BasePage<MailPage>{

    public MailPage getCourseByCurrency(String currency) {
        System.out.println(
                $x("//div[contains(@class, 'rates')]//a[contains(@href, '%s')]".formatted(currency.toUpperCase()))
                        .shouldBe(Condition.visible)
                        .getText());
        return this;
    }
}
