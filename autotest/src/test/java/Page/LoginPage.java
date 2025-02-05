package Page;

import Base.BasePage;
import junit.framework.Assert;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private  final By inputUserNameXpath= By.xpath("//input[@id='user-name']");
    private  final By inputPasswordXpath= By.xpath("//input[@id='password']");
    private  final By btnLoginXpath = By.xpath("//input[@id='login-button']");

    public void loginToSystem(String username,String password){
        driver.findElement(inputUserNameXpath).sendKeys(username);
        driver.findElement(inputPasswordXpath).sendKeys(password);
        driver.findElement(btnLoginXpath).click();
    }

    public void verifyUrl(String destinationUrl){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(destinationUrl, currentUrl);
    }
    public void loginFromExcel(String filePath, int rowNumber) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);


        Row row = sheet.getRow(rowNumber);
        String username = row.getCell(0).getStringCellValue();
        String password = row.getCell(1).getStringCellValue();

        loginToSystem(username, password);

        fileInputStream.close();
    }
    public void verifyText(String expectedTxt){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement warningTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
        String text1 = warningTxt.getText();

        System.out.println("Text from the element: " + text1);
        Assert.assertEquals(expectedTxt,text1);

    }





}
