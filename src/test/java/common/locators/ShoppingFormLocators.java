package common.locators;

public enum ShoppingFormLocators {

    USER_NAME("name"),
    USER_COUNTRY("country"),
    USER_CITY("city"),
    USER_CREDIT_CARD("card"),
    USER_CREDIT_CARD_MONTH("month"),
    USER_CREDIT_CARD_YEAR("year"),
    BUTTON_PURCHASE("//button[@type='button' and contains(text(), 'Purchase')]"),
    SUM_ALERT_PURCHASE("//div[contains(@class,'sweet-alert')]");

    public final String xPath;

    private ShoppingFormLocators(String xPath){
        this.xPath= xPath;
    }
}
