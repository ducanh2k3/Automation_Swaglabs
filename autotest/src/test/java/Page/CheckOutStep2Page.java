package Page;

import Base.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckOutStep2Page extends BasePage {
    public CheckOutStep2Page(WebDriver driver) {
        super(driver);
    }

    private final By btnFinish = By.xpath("//button[@id='finish']");
    WebElement cartQuantityElement = driver.findElement(By.xpath("//div[@class='cart_quantity']"));

    WebElement itemNameElement = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

    WebElement itemDescElement = driver.findElement(By.xpath("//div[@class='inventory_item_desc']"));

    WebElement itemPriceElement = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));

    public List<String> getInformation() {
        List<String> information = new ArrayList<>();
        information.add(cartQuantityElement.getText());
        information.add(itemNameElement.getText());
        information.add(itemDescElement.getText());
        information.add(itemPriceElement.getText());
        return information;
    }
    public void navigateToCompletePage(){
        driver.findElement(btnFinish).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", currentUrl);

    }

}
