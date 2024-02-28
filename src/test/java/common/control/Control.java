package common.control;

import common.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Control {

    protected WebElement control;
    protected By locator;

    public Control(By locator){
        this.locator = locator;
    }

    public WebElement getControl() {
        return control;
    }

    public By getLocator() {
        return locator;
    }

    protected void findControl(){
        control = Session.getInstance().getDriver().findElement(locator);
    }

    public void click(){
        findControl();
        control.click();
    }

    public boolean isControlDisplayed(){
        try{
            findControl();
            return control.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public String getAttribute(String attributeName){
        try{
            findControl();
            return control.getAttribute(attributeName);
        } catch (Exception e){
            return "";
        }
    }
}
