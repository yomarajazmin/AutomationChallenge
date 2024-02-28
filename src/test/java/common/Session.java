package common;

import org.openqa.selenium.WebDriver;

public class Session {

    private static Session session = null;
    private WebDriver driver;

    private Session(){
        driver = Chrome.create();
    }
    public static Session getInstance(){
        if (session == null)
            session = new Session();
        return session;
    }

    public void closeSession(){
        driver.quit();
        session = null;
    }

    public static Session getSession() {
        return session;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
