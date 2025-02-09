package Base;

import Utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){

        driver = DriverFactory.getDriver(DriverFactory.BrowserType.chrome);
        driver.get("https://www.saucedemo.com/");

    }
    @AfterMethod
    public  void tearDown(){
        driver.quit();
    }
}
