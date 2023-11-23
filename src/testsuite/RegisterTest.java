package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterTest extends BaseTest {

    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        // Find and click on create an account link
        driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")).click();
        // Verify 'Create New Customer Account' text
        String expectedCreateAccountText = "Create New Customer Account";
        String actualCreateAccountText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedCreateAccountText, actualCreateAccountText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // Find and click on create account link
        driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")).click();
        // Find and enter first name in the field
        driver.findElement(By.id("firstname")).sendKeys("Tester");
        // Find and enter last name in the field
        driver.findElement(By.name("lastname")).sendKeys("Ninja");
        // Find and enter email id field
        Random randomGenerator = new Random(); // Using random int generator to create unique email id everytime for registration
        int randomInt = randomGenerator.nextInt(1000);
        driver.findElement(By.id("email_address")).sendKeys("happytester" + randomInt + "@gmail.com");
        // Find and enter password in the field
        driver.findElement(By.name("password")).sendKeys("Happy1234");
        // Find and enter confirm password in the field
        driver.findElement(By.name("password_confirmation")).sendKeys("Happy1234");
        // Click on the create account button
        driver.findElement(By.xpath("//button[@class='action submit primary']//span[contains(text(),'Create an Account')]")).click();
        // Verify text post registration
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[@class='message-success success message']//div[contains(text(),'Thank you for registering with Main Website Store.')]")).getText();
        Assert.assertEquals(expectedText, actualText);
        // Find and click on down arrow near registration
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
        // Find and click on the sign out link
        driver.findElement(By.xpath("//li[@class='customer-welcome active']//a[normalize-space()='Sign Out']")).click();
        // Verify the sign out text //li[@class='customer-welcome active']//a[normalize-space()='Sign Out']
        String expectedSignOut = "You are signed out";
        String actualSignOut = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedSignOut, actualSignOut);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
