package Page;

import Base.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {
    public CompletePage(WebDriver driver) {
        super(driver);
    }

    private final By txtConfirmHeader = By.xpath("//h2[@class='complete-header']");
    private final By txtComplete = By.xpath("//div[@class='complete-text']");
    private final By btnComplete = By.xpath("//button[@id='back-to-products']");
    public void verifyText(String headerConfirm,String txtCompelte){

       String header= driver.findElement(txtConfirmHeader).getText();
       String text= driver.findElement(txtComplete).getText();
        Assert.assertEquals(headerConfirm,header);
        Assert.assertEquals(txtCompelte,text);


    }

    public void navigateToHome(String destinationUrl ) {
        driver.findElement(btnComplete).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(destinationUrl,currentUrl);
    }


}
