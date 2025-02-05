package TestCase;

import Base.TestBase;
import Page.*;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class TestCase1 extends TestBase {
    @Test
    public void TC1() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFromExcel("C:\\Users\\catsl\\IdeaProjects\\autotest\\data.xlsx", 1);
        loginPage.verifyUrl("https://www.saucedemo.com/inventory.html");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToItemPage(4);
        ItemPage itemPage = new ItemPage(driver);
        itemPage.addToCart();
        itemPage.verifyAddedToCart();
        String itemNameOnItemPage = itemPage.getItemName();
        itemPage.navigateToCarṭ();
        CartPage cartPage = new CartPage(driver);
        String itemNameOnCartPage = cartPage.getCartItemName();
        Assert.assertEquals(itemNameOnItemPage, itemNameOnCartPage);
        List<String> cartPageInfor = cartPage.getInformation();
        cartPage.navigateToCheckOut();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.fillTheForm("Pham Dang ", "Duc Anh", "100000000");
        checkOutPage.navigateToCheckOutStepTwo();
        CheckOutStep2Page checkOutStep2Page = new CheckOutStep2Page(driver);
        List<String> checkOutPageInfor = checkOutStep2Page.getInformation();
        for (int i = 0; i < cartPageInfor.size(); i++) {
            String itemPageValue = cartPageInfor.get(i);
            String cartPageValue = checkOutPageInfor.get(i);
            System.out.println("Comparing: " + itemPageValue + " vs " + cartPageValue);
            Assert.assertEquals(itemPageValue, cartPageValue);
        }
        checkOutStep2Page.navigateToCompletePage();
        CompletePage completePage= new CompletePage(driver);
        completePage.verifyText("Thank you for your order!","Your order has been dispatched, and will arrive just as fast as the pony can get there!");
completePage.navigateToHome("https://www.saucedemo.com/inventory.html");

        Thread.sleep(5000);
    }

    @Test
    public void TC2() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFromExcel("C:\\Users\\catsl\\IdeaProjects\\autotest\\data.xlsx", 2);
        loginPage.verifyUrl("https://www.saucedemo.com/");
        loginPage.verifyText("Epic sadface: Sorry, this user has been locked out.");
        Thread.sleep(5000);
    }

    @Test
    public void TC3() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFromExcel("C:\\Users\\catsl\\IdeaProjects\\autotest\\data.xlsx", 3);
        loginPage.verifyUrl("https://www.saucedemo.com/inventory.html");
        HomePage homePage = new HomePage(driver);
        homePage.verifyImage();
        Thread.sleep(5000);
    }


}
