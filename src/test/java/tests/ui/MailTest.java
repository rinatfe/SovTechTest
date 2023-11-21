package tests.ui;

import base.BaseTest;
import enums.URLs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.MailHiTechPage;
import pages.MailPage;

public class MailTest extends BaseTest {

    static MailPage mailPage;
    static MailHiTechPage mailHiTechPage;

    @BeforeAll
    public static void setUp() {
        mailPage = new MailPage();
        mailHiTechPage = new MailHiTechPage();
    }

    @Test
    public void mailTest() {
        openBrowser(URLs.MAIL.getUrl());
        mailPage        .getCourseByCurrency("USD")
                        .chooseTab("Hi-Tech");
                        switchTab("Hi-Tech");
        mailHiTechPage  //.checkTitle("Hi-Tech")
                        .getAllHeaders()
                        .clickLogo("Hi-Tech")
                        .checkCurrencyURL(URLs.HI_TECH_MAIL.getUrl())
                        .getAltAttributeValue();
    }
}
