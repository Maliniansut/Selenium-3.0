import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class relativeLocatorUnderneath {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    @Description("Relative Locator Test")
    public void testPositive() throws InterruptedException {
        String URL = "https://codepen.io/AbdullahSajjad/full/LYGVRgK";
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //First we need to switch the iframe so we would require id of iframe
        //If we don't switch to iframe we would not be able to find the elements
        driver.switchTo().frame("result");

        //form[@id='form']/button
        WebElement submitElement = driver.findElement(By.xpath("//form[@id='form']/button"));
        submitElement.click();

        WebElement element = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement error_element = driver.findElement(with(By.tagName("small")).below(element));
        String errorText = error_element.getText();
        Assert.assertTrue(error_element.isDisplayed());
        Assert.assertEquals(errorText,"Username must be at least 3 characters");
        Thread.sleep(5000);

    }

}
