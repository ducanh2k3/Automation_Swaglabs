package Page;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
    }
    private final By btnAddToCart = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private final By btnRemoveFromCart = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    private final By lnkCart = By.xpath("//a[@class='shopping_cart_link']");
    private final By txtName = By.xpath("//div[@class='inventory_details_name large_size']");


    public void addToCart(){
        driver.findElement(btnAddToCart).click();
    }
    public void verifyAddedToCart() {
        boolean isButtonDisplayed = driver.findElement(btnRemoveFromCart).isDisplayed();
        Assert.assertTrue(isButtonDisplayed);
    }
    public void navigateToCarṭ() {
        driver.findElement(lnkCart).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/cart.html",currentUrl);
    }
    public String getItemName() {
        return driver.findElement(txtName).getText();
    }
}
