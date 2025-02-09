package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public enum BrowserType {
        chrome, firefox, edge
    }

    public static WebDriver getDriver(BrowserType browserType) {
        WebDriver driver;
        switch (browserType) {
            case edge:
                driver = new EdgeDriver();
                break;
            case chrome:
                driver = new ChromeDriver();
                break;
            case firefox:
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
