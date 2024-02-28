package pages;

import common.Session;
import common.control.Label;
import common.locators.ItemPageLocators;
import common.locators.MainPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    public Label homeTopMenuOption = new Label(By.xpath(MainPageLocators.TOP_MENU_OPTION_HOME.xPath));
    public Label contactTopMenuOption = new Label(By.xpath(MainPageLocators.TOP_MENU_OPTION_CONTACT.xPath));
    public Label aboutUsTopMenuOption = new Label(By.xpath(MainPageLocators.TOP_MENU_OPTION_ABOUT_US.xPath));
    public Label cartTopMenuOption = new Label(By.xpath(MainPageLocators.TOP_MENU_OPTION_CART.xPath));
    public Label logInTopMenuOption = new Label(By.xpath(MainPageLocators.TOP_MENU_OPTION_LOG_IN.xPath));
    public Label signUpTopMenuOption = new Label(By.xpath(MainPageLocators.TOP_MENU_OPTION_SIGN_UP.xPath));

    public Label laptopCategory = new Label(By.xpath(MainPageLocators.CATEGORY_LAPTOPS.xPath));
    public Label phoneCategory = new Label(By.xpath(MainPageLocators.CATEGORY_PHONES.xPath));
    public Label monitorCategory = new Label(By.xpath(MainPageLocators.CATEGORY_MONITORS.xPath));

    public void clickOnItem(String itemName){
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath(MainPageLocators.ITEM.xPath.replace("NAME_ITEM", itemName)));
        Wait<WebDriver> wait = new WebDriverWait(Session.getSession().getDriver(), Duration.ofSeconds(10));
        wait.until(d -> element.isDisplayed());
        element.click();
    }
}
