package utils.steps;

import common.Session;
import common.entities.Item;
import common.locators.MainPageLocators;
import common.locators.ShoppingFormLocators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ItemPage;
import pages.MainPage;
import pages.ShoppingCartPage;
import pages.ShoppingFormPage;

import java.text.ParseException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class ShoppingStepDefinition {
    MainPage mainPage = new MainPage();
    ItemPage itemPage=new ItemPage();
    ShoppingCartPage cartPage = new ShoppingCartPage();
    ShoppingFormPage formPage = new ShoppingFormPage();
    List<Item> items = new LinkedList<>();
    Item newItem=new Item();
    String userName ="";
    String cardNumber ="";
    Double totalAmount = 0.0;

    @Given("I am at the {string} page")
    public void iAmAtThePage(String arg0) {
        Session.getInstance().getDriver().get("https://www.demoblaze.com/index.html#");
    }

    @And("^I select the (Phones|Laptops|Monitors) category$")
    public void iSelectTheLaptopsCategory(String categoryName) {
        switch (categoryName){
            case "Phones" -> mainPage.phoneCategory.click();
            case "Laptops" -> mainPage.laptopCategory.click();
            case "Monitors" -> mainPage.monitorCategory.click();
        }
        Session.getSession().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("I click on a {string} item")
    public void iClickOnItem(String itemName) {
        mainPage.clickOnItem(itemName);
    }

    @Then("I add the selected product to the shopping card in the item page")
    public void iAddTheSelectedItemToTheShoppingCardInTheItemPage() {
        newItem=new Item();
        newItem.setName(itemPage.getName());
        newItem.setPrice(itemPage.getPrice());

        itemPage.addToCart.click();
        items.add(newItem);
    }

    @And("^I click on (.*) in the popup of the item page$")
    public void iClickOnOKInThePopupOfTheItemPage(String value) {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Session.getInstance().getDriver().switchTo().alert().accept();
    }

    @And("^I go to (Home|Contact|About us|Cart|Log in|Sign up) in main page$")
    public void iReturnToHomeInMainPage(String option) {
        switch (option){
            case "Home" -> mainPage.homeTopMenuOption.click();
            case "Contact" -> mainPage.contactTopMenuOption.click();
            case "About us" -> mainPage.aboutUsTopMenuOption.click();
            case "Cart" -> mainPage.cartTopMenuOption.click();
            case "Log in" -> mainPage.logInTopMenuOption.click();
            case "Sign up" -> mainPage.signUpTopMenuOption.click();
        }
    }

    @Then("I check all items added are listed in shopping card view")
    public void iCheckAllItemsAddedAreListedInShoppingCardView() {
        Assert.assertTrue(cartPage.checkAllItemsAreInCart(items));
    }

    @And("I click on {string} from shopping card page")
    public void iClickOnPlaceOrderFromShoppingCardPage(String value) {
        cartPage.placeOrderButton.click();
    }

    @Then("I check total is the sum of the prices in shopping card view")
    public void iCheckTotalIsTheSumOfThePricesInShoppingCardView() {
        totalAmount = cartPage.getTotalIsSumOfItemPrices(items);
        Assert.assertEquals(totalAmount, Double.parseDouble(cartPage.totalPrice.getAttribute("textContent")), 0.0);
    }

    @And("^I write (.*) in (name|country|city|credit card number|credit card month|credit card year) field of shopping form page$")
    public void iWriteUserNameInNameFieldOfShoppingFormPage(String value, String fieldName) {
        switch (fieldName){
            case "name" -> {formPage.userName.writeText(value);
                            userName=value;}
            case "country" -> formPage.userCountry.writeText(value);
            case "city" -> formPage.userCity.writeText(value);
            case "credit card number" -> {formPage.userCard.writeText(value);
                            cardNumber=value;}
            case "credit card month" -> formPage.userCardMonth.writeText(value);
            case "credit card year" -> formPage.userCardYear.writeText(value);
        }
    }

    @When("I click on {string} of shopping form page")
    public void iClickOnPurchaseOfShoppingFormPage(String value) {
        formPage.purchaseButton.click();
    }

    @Then("I check the summary of the purchase in shopping form page")
    public void iCheckTheSummaryOfThePurchaseInShoppingFormPage() throws ParseException {
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath(ShoppingFormLocators.SUM_ALERT_PURCHASE.xPath));
        Wait<WebDriver> wait = new WebDriverWait(Session.getSession().getDriver(), Duration.ofSeconds(10));
        wait.until(d -> element.isDisplayed());
        String value = element.getText();
        Assert.assertTrue("Some of the data in the summary of the purchase is not what was expected.", formPage.checkSummaryOfPurchase(userName, cardNumber, totalAmount, value));
    }

    @And("I click on OK to close the summary of the purchase in shopping form page")
    public void iClickOnOKToCloseTheSummaryOfThePurchaseInShoppingFormPage() {
        Session.getInstance().getDriver().switchTo().alert().accept();
    }
}
