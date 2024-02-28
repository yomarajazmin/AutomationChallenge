package pages;

import common.Session;
import common.control.Button;
import common.control.Label;
import common.entities.Item;
import common.locators.CartPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCartPage {

    public Button placeOrderButton = new Button(By.xpath(CartPageLocators.BUTTON_PLACE_ORDER.xPath));
    public Label totalPrice = new Label(By.id(CartPageLocators.TOTAL_PRICE.xPath));

    public boolean checkAllItemsAreInCart(List<Item> items){
        boolean found=true, itemFound=false;
        String xPathItem=CartPageLocators.PRODUCTS_TABLE_CONTENT.xPath.toString();
        List<WebElement> cols;
        String title,price;
        List<WebElement> elements = Session.getInstance().getDriver().findElements(By.xpath(CartPageLocators.PRODUCTS_TABLE_CONTENT.xPath));
        Wait<WebDriver> wait = new WebDriverWait(Session.getSession().getDriver(), Duration.ofSeconds(10));
        wait.until(d -> elements.get(0).isDisplayed());

        for (Item item:items) {
            for (int i = 1; i <= elements.size() && !itemFound; i++) {
                cols = Session.getInstance().getDriver().findElements(By.xpath(xPathItem+"["+i+"]/td"));

                title=cols.get(1).getAttribute("textContent");
                price=cols.get(2).getAttribute("textContent");
                if(item.getName().equals(title))
                    if(item.getPrice()==Double.parseDouble(price)) {
                        itemFound = true;
                    }
            }
            found = found && itemFound;
            itemFound = false;
        }
        return found;
    }

    public double getTotalIsSumOfItemPrices(List<Item> items){
        double total=0;
        for (Item item:items) {
            total += item.getPrice();
        }
        return total;
    }
}
