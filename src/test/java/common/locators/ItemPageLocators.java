package common.locators;

public enum ItemPageLocators {

    ITEM_NAME("//div[@id='tbodyid']/h2[@class='name']"),
    ITEM_PRICE("//div[@id='tbodyid']/h3[@class='price-container']"),
    BUTTON_ADD_TO_CART("//a[contains(@class,'btn-success') and contains(text(),'Add to cart')]");

    public final String xPath;

    private ItemPageLocators(String xPath){
        this.xPath= xPath;
    }
}
