import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class OpeningNewWindow {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    @Description("Drag and Drop Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Before Click the string of the window is  "+ mainWindowHandle); //unique string aligned to the window will appear

        Thread.sleep(5000);

        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();
        Thread.sleep(5000);
        //After clicking we will have two windows hence we would use set data structures.
        //Why Set and not list ? Because all window tabs have unique strings
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handles: windowHandles){
            //Now for switching from one window to another we can use
            driver.switchTo().window(handles);
            System.out.println(handles);
            //Second page will open and then it would see the page source and then new window.
            if (driver.getPageSource().contains("New Window")){
                System.out.println("Test Case Passed");
            }
        }

    }
}
