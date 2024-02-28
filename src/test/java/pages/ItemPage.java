package pages;

import common.Session;
import common.control.Button;
import common.control.Label;
import common.locators.ItemPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemPage {

    public Button addToCart = new Button(By.xpath(ItemPageLocators.BUTTON_ADD_TO_CART.xPath));

    public String getName(){
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath(ItemPageLocators.ITEM_NAME.xPath));
        return element.getAttribute("textContent").isEmpty()?"":element.getAttribute("textContent");
    }
    public double getPrice(){
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath(ItemPageLocators.ITEM_PRICE.xPath));
        String content =element.getAttribute("textContent");
        content= content.split(" ")[0].replace("$","");
        if(!content.isEmpty())
            return Double.parseDouble(content);
        return 0;
    }

}
