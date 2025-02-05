package Page;

import Base.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getItemByNumber(int itemNumber) {

        String itemCssSelector = String.format("a[id='item_%d_title_link'] div[class='inventory_item_name ']", itemNumber);


        return driver.findElement(By.cssSelector(itemCssSelector));
    }

    public void navigateToItemPage(int itemNumber) {
        WebElement item = getItemByNumber(itemNumber);

        item.click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=" + itemNumber;
        Assert.assertEquals(expectedUrl, currentUrl);
    }
    public void verifyImage(){
        List<String> imageUrls = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {

            String xpath = "(//div[@class='inventory_item'])[" + i + "]//div[@class='inventory_item_img']//img";

            WebElement imgElement = driver.findElement(By.xpath(xpath));


            String src = imgElement.getAttribute("src");
            imageUrls.add(src);
//            System.out.println("All image URLs are same: " + src);
        }
        boolean allUrlsAreSame = areAllUrlsSame(imageUrls);
        System.out.println("All image URLs are same: " + allUrlsAreSame);

    }
    private static boolean areAllUrlsSame(List<String> urls) {

        if (urls.isEmpty() || urls.size() == 1) {
            return true;
        }
        String firstUrl = urls.get(0);
        for (int i = 1; i < urls.size(); i++) {
            if (!urls.get(i).equals(firstUrl)) {
                return false;
            }
        }
        return true;
    }

}
