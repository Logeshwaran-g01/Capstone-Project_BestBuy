package tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends baseTest {

    @Test
    public void testLoginPage() throws InterruptedException {

        homePage.setAccount();
        Thread.sleep(2000);
        homePage.setSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailAdd("Logeshwaran1996@gmail.com");
        loginPage.setPaWord("Lokki@0412");
        loginPage.setClickSignIn();
        loginPage.setLoginSkipNow();

        //Validating Assertion
        String str = driver.getTitle();
        System.out.println(str);
        Assert.assertEquals(str,"Best Buy | Official Online Store | Shop Now & Save ");




    }
}
