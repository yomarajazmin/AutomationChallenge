package pages;

import common.control.Alert;
import common.control.Button;
import common.control.TextBox;
import common.locators.ShoppingFormLocators;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShoppingFormPage {

    public TextBox userName=new TextBox(By.id(ShoppingFormLocators.USER_NAME.xPath));
    public TextBox userCountry=new TextBox(By.id(ShoppingFormLocators.USER_COUNTRY.xPath));
    public TextBox userCity=new TextBox(By.id(ShoppingFormLocators.USER_CITY.xPath));
    public TextBox userCard=new TextBox(By.id(ShoppingFormLocators.USER_CREDIT_CARD.xPath));
    public TextBox userCardMonth=new TextBox(By.id(ShoppingFormLocators.USER_CREDIT_CARD_MONTH.xPath));
    public TextBox userCardYear=new TextBox(By.id(ShoppingFormLocators.USER_CREDIT_CARD_YEAR.xPath));
    public Button purchaseButton=new Button(By.xpath(ShoppingFormLocators.BUTTON_PURCHASE.xPath));
    public Alert summaryAlert =new Alert(By.xpath(ShoppingFormLocators.SUM_ALERT_PURCHASE.xPath));

    public boolean checkSummaryOfPurchase(String userNameExpected, String cardNumberExpected, Double totalExpected, String valueToCompare) throws ParseException {
        //Thank you for your purchase!
        //Id: 3840153
        //Amount: 1400 USD
        //Card Number: 4411111111
        //Name: test user
        //Date: 28/1/2024
        //OK
        String[] purchaseData=valueToCompare.split("\n");
        String id = purchaseData[1].replace("Id: ", "");
        String amount = purchaseData[2].replace("Amount: ","").replace(" USD", "");
        String cardNumber = purchaseData[3].replace("Card Number: ","");
        String userName = purchaseData[4].replace("Name: ","");
        String dateText = purchaseData[5].replace("Date: ","");
        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sourceFormat.parse(dateText);
        Date currentDate = new Date();

        return !id.isEmpty() &&
                userName.equals(userNameExpected) &&
                cardNumber.equals(cardNumberExpected) &&
                Double.parseDouble(amount) == totalExpected &&
                date.equals(currentDate);
    }
}
