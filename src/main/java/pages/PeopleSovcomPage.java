package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PeopleSovcomPage extends BasePage<PeopleSovcomPage> {
    public PeopleSovcomPage chooseItemFromListByLabel(String label, String itemName) {
        String resultBefore = $x("//span[@class='page-vacancies__search-result__result']")
                .shouldBe(Condition.visible)
                .getText().trim();
        $x("//div[normalize-space()='%s']/following-sibling::div//i".formatted(label)).click();
        $$x("//div[@role='listbox']/div")
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .findBy(Condition.text(itemName))
                .click();
        $x("//span[normalize-space()='%s']".formatted(resultBefore)).should(Condition.disappear);
        return this;
    }

    public PeopleSovcomPage checkResults(String ... args) {
        ElementsCollection listOFVacancies = $$x("//div[@class='section-vacancies full-width']//a")
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        for(String item: args) {
            listOFVacancies .asDynamicIterable()
                            .stream()
                            .forEach(x-> Assertions.assertTrue(x.getText().contains(item), "Элемент не содержит " + item));
        }
        return this;
    }
}
