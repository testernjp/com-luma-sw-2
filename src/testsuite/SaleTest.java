package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        // Find and click on the sale menu
        driver.findElement(By.id("ui-id-8")).click();
        // Find and click on jackets link
        driver.findElement(By.xpath("(//a[normalize-space()='Jackets'])[3]")).click();
        //Verify Jacket text
        String expectedJacketText = "Jackets";
        String actualJacketText = driver.findElement(By.id("page-title-heading")).getText();
        Assert.assertEquals(expectedJacketText, actualJacketText);
        // Count the total items displayed on the page and print
        List<WebElement> linksElements = driver.findElements(By.tagName("ol"));
        System.out.println("The number of links is " + linksElements.size());
        for (WebElement links : linksElements) {
            System.out.println("Linked Text: " + links.getText());
        }
        // Verify total 12 items displayed on page
        int productCount = driver.findElements(By.className("product-image-photo")).size();
        Assert.assertEquals(productCount, 12);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
