package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Find and click on sign in link
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        // Find and enter email address
        driver.findElement(By.id("email")).sendKeys("welcome2luton@gmail.com");
        // Find and enter password
        driver.findElement(By.id("pass")).sendKeys("Welcome10");
        // Find and click on the sign in button
        driver.findElement(By.name("send")).click();
        // Verify the welcome text
        String expectedWelcomeText = "Welcome, njp prish!";
        String actualWelcomeText = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, njp prish!']")).getText();
        Assert.assertEquals(expectedWelcomeText, actualWelcomeText);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        // Find and click on sign in link
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        // Find and enter email address
        driver.findElement(By.id("email")).sendKeys("welcome2luton@gmail.com");
        // Find and enter password
        driver.findElement(By.name("login[password]")).sendKeys("Welcome1");
        // Find and click on the sign in button
        driver.findElement(By.name("send")).click();
        // Verify the error message
        String expectedError = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualError = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]")).getText();
        Assert.assertEquals(expectedError, actualError);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        // Find and click on sign in link
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        // Find and enter email address
        driver.findElement(By.id("email")).sendKeys("welcome2luton@gmail.com");
        // Find and enter password
        driver.findElement(By.name("login[password]")).sendKeys("Welcome10");
        // Find and click on the sign in button
        driver.findElement(By.name("send")).click();
        // Verify the welcome text
        String expectedWelcomeText = "Welcome, njp prish!";
        String actualWelcomeText = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, njp prish!']")).getText();
        Assert.assertEquals(expectedWelcomeText, actualWelcomeText);
        // Find and click on down arrow near registration
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
        // Find and click on the signout link
        driver.findElement(By.xpath("//li[@class='customer-welcome active']//a[normalize-space()='Sign Out']")).click();
        // Verify the signout text //li[@class='customer-welcome active']//a[normalize-space()='Sign Out']
        String expectedSignOut = "You are signed out";
        String actualSignOut = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedSignOut, actualSignOut);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
