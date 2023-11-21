package tests.ui;

import base.BaseTest;
import enums.URLs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PeopleSovcomPage;

public class PeopleSovcomTest extends BaseTest {
    static PeopleSovcomPage page;

    @BeforeAll
    public static void setUp() {
        page = new PeopleSovcomPage();
    }
    @Test
    public void checkFilterByCityAndCompany() {
        openBrowser(URLs.PEOPLE_TEST.getUrl());
        page    .clickButton("Вакансии")
                .chooseItemFromListByLabel("Город", "Москва")
                .chooseItemFromListByLabel("Компания", "Совкомбанк Технологии")
                .checkResults("Москва", "Совкомбанк Технологии");
        System.out.println("");
    }
}
