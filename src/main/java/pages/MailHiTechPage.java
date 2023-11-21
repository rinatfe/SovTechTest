package pages;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class MailHiTechPage extends BasePage<MailHiTechPage> {

    public MailHiTechPage getAllHeaders() {
        $$x("//header[contains(.,'Новости')]/following-sibling::div//li")
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .asDynamicIterable()
                .stream()
                .forEach(x-> System.out.println(x.getText()));
        return this;
    }

    public MailHiTechPage getAltAttributeValue() {
        System.out.println($$("img.pm-logo__link__pic").first().getAttribute("alt"));
        return this;
    }

}
