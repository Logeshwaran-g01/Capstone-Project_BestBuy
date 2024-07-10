package tests;

import Pages.CheckoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckoutPageTest extends baseTest{

    @Test(priority = 4)
    public void testCheckoutPage(){

        //Giving Address to place the order
        checkoutPage.setCheckout();
        checkoutPage.setContinueAsGuest();
        checkoutPage.setSwitchToPickup();
        checkoutPage.setFirstName("Logeshwaran");
        checkoutPage.setLastName("Gangadharan");
        checkoutPage.setAddress("Ambattur, Chennai");
        checkoutPage.setCity("Chennai");
        //Dropdown
        WebElement dd = driver.findElement(By.xpath("//select[@id='state']"));
        Select select = new Select(dd);
        select.selectByIndex(1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        checkoutPage.setZipCode("600077");
        checkoutPage.setSaveAddress();
        checkoutPage.setKeepAddressEntered();

        //Scrolling down to the Email block
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);");
        checkoutPage.setEmailAddress("Lokeshdharan@gmail.com");
        checkoutPage.setMobileNumber("9876543210");
        checkoutPage.setCheckBox();
        checkoutPage.setPaymentInformation();
        checkoutPage.setCardNumber("6789543223451234");
        checkoutPage.setExpiryDate("06/28");
        checkoutPage.setCvvNumber("609");
        checkoutPage.setApply();
        //Scrolling down to the Place order button
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);");
        checkoutPage.setPlaceOrder();
        //Assertion
        String str = driver.getTitle();
        System.out.println("The title of the page is: " + str);
        Assert.assertEquals(str,"Checkout - Best Buy");


    }
}
