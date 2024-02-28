package common.locators;

public enum CartPageLocators {

    PRODUCTS_TABLE_CONTENT("//table//tbody[@id='tbodyid']/tr"),
    TOTAL_PRICE("totalp"),
    BUTTON_PLACE_ORDER("//button[@type='button' and contains(text(), 'Place Order')]");

    public final String xPath;

    private CartPageLocators(String xPath){
        this.xPath= xPath;
    }
}
