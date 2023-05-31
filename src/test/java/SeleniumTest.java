import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
        File file = new File("HelloUser.html");
        // Open the HTML file
        driver.get(file.getAbsolutePath());
    }
    @Test
    public void testNoName() {
        // Find the submit button and click it
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Find the text element and verify the greeting
        WebElement displayElement = driver.findElement(By.id("text"));
        assertEquals("Hello,", displayElement.getText());
    }

    @Test
    public void testShortName() {
        // fill in the input box with a name:
        WebElement inputBox = driver.findElement(By.id("input"));
        inputBox.sendKeys("Rick");

        // Find the submit button and click it
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Find the text element and verify the greeting
        WebElement displayElement = driver.findElement(By.id("text"));
        assertEquals("Hello, Rick", displayElement.getText());
    }

    @Test
    public void testLongName() {
        // fill in the input box with a name:
        WebElement inputBox = driver.findElement(By.id("input"));
        inputBox.sendKeys("Alexander Sebastian Montgomery Fitzgerald-Jenkins");

        // Find the submit button and click it
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Find the text element and verify the greeting
        WebElement displayElement = driver.findElement(By.id("text"));
        assertEquals("Hello, Alexander Sebastian Montgomery Fitzgerald-Jenkins", displayElement.getText());
    }
    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}