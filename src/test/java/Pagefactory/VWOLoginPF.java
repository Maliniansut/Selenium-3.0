package Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VWOLoginPF {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Initialize Page Object
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testVwoLogin() {
        // Navigate to VWO
        loginPage.navigateToVWO();

        // Verify page title and URL
        System.out.println("Page Title: " + loginPage.getPageTitle());
        Assert.assertEquals(loginPage.getPageTitle(), "Login - VWO", "Page title mismatch");
        Assert.assertEquals(loginPage.getCurrentUrl(), "https://app.vwo.com/#/login", "URL mismatch");

        // Perform login with invalid credentials
        loginPage.performLogin("maliniansut@gmail.com", "123@Malini");

        // Verify error message
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Your account has been deleted. Please sign up for a new account.";

        System.out.println("Error Message: " + actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
