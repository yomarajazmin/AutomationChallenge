package common.locators;

public enum MainPageLocators {

    //CATEGORY_LAPTOPS("//a[@id='cat']/parent::div/a[contains(.,'Laptops')]"),
    CATEGORY_LAPTOPS("//a[contains(.,'Laptops')]"),
    CATEGORY_PHONES("//a[@id='cat']/parent::div/a[contains(.,'Phones')]"),
    CATEGORY_MONITORS("//a[@id='cat']/parent::div/a[contains(.,'Monitors')]"),

    ITEM("//a[contains(.,'NAME_ITEM')]"),

    TOP_MENU_OPTION_HOME("//div[@id='navbarExample']//a[contains(.,'Home')]"),
    TOP_MENU_OPTION_CONTACT("//div[@id='navbarExample']//a[contains(.,'Contact')]"),
    TOP_MENU_OPTION_ABOUT_US("//div[@id='navbarExample']//a[contains(.,'About us')]"),
    TOP_MENU_OPTION_CART("//div[@id='navbarExample']//a[contains(.,'Cart')]"),
    TOP_MENU_OPTION_LOG_IN("//div[@id='navbarExample']//a[contains(.,'Log in')]"),
    TOP_MENU_OPTION_SIGN_UP("//div[@id='navbarExample']//a[contains(.,'Sign up')]");

    public final String xPath;

    private MainPageLocators(String xPath){
        this.xPath= xPath;
    }


}
