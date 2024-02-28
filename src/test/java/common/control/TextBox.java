package common.control;

import org.openqa.selenium.By;

public class TextBox extends Control{
    public TextBox(By locator) {
        super(locator);
    }

    public void writeText(String text){
        findControl();
        control.clear();
        control.sendKeys(text);
    }
}
