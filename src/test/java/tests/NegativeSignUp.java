package tests;

import Pages.HomePage;
import Pages.SignUpPage;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeSignUp extends baseTest{

    @Test
    public void negativeSignUp() throws InterruptedException {

        //Clicking Account Button
        homePage.setAccount();

        Thread.sleep(2000);
        homePage.setCreateAccount();
        //Sending keys to create new account
        signUpPage.setFirstName("Lokki");
        signUpPage.setLastName("G");
        signUpPage.setEmail("Lokki199604@test.com");
        signUpPage.setPassword("Lokki@0412");
        signUpPage.setReEnterPassword("Lokki@0412");
        signUpPage.setPhoneNumber("9940584857");
        signUpPage.setRecoverPhoneNum();
        signUpPage.setSubmit();
        //Getting error message
        WebElement error = driver.findElement(By.xpath("//strong[text()='An account with this email already exists.']"));
        Thread.sleep(5000);
        String actualErrorMessage =  error.getText();
        Assert.assertEquals(actualErrorMessage,"An account with this email already exists.");

    }
}
