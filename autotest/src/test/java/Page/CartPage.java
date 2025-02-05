package Page;

import Base.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By lnkCheckOut = By.xpath("//button[@id='checkout']");
    WebElement cartQuantityElement = driver.findElement(By.xpath("//div[@class='cart_quantity']"));

    WebElement itemNameElement = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

    WebElement itemDescElement = driver.findElement(By.xpath("//div[@class='inventory_item_desc']"));

    WebElement itemPriceElement = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));

    private final By txtName = By.xpath("//div[@class='inventory_item_name']");

    public void navigateToCheckOut() {
        driver.findElement(lnkCheckOut).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html", currentUrl);
    }

    public String getCartItemName() {
        return driver.findElement(txtName).getText();
    }

    public List<String> getInformation() {
        List<String> information = new ArrayList<>();
        information.add(cartQuantityElement.getText());
        information.add(itemNameElement.getText());
        information.add(itemDescElement.getText());
        information.add(itemPriceElement.getText());
        return information;
    }


}
