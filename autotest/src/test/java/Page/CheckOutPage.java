package Page;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    private final By txtFirstName = By.xpath("//input[@id='first-name']");
    private final By txtLastName = By.xpath("//input[@id='last-name']");
    private final By txtPostalCode =By.xpath("//input[@id='postal-code']");
    private final  By btnContinue = By.xpath("//input[@id='continue']");

    public void fillTheForm(String FirstName,String LastName,String PostCode){
        driver.findElement(txtFirstName).sendKeys(FirstName);
        driver.findElement(txtLastName).sendKeys(LastName);
        driver.findElement(txtPostalCode).sendKeys(PostCode);
    }
    public void navigateToCheckOutStepTwo(){
        driver.findElement(btnContinue).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html",currentUrl);

    }
}
