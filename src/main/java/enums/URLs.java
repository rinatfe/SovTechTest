package enums;

public enum URLs {
    HI_TECH_MAIL("https://hi-tech.mail.ru/"),
    DA_DATA("https://cleaner.dadata.ru/api/v1/clean/phone"),
    MAIL("https://mail.ru/"),
    RANDOM_USER("https://randomuser.me/api/"),
    DEMO_QA("https://demoqa.com/automation-practice-form"),
    PEOPLE_TEST("https://people.sovcombank.ru/");


    private final String url;

    URLs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
