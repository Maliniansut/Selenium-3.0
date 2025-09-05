import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionClass {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Description("Drag and Drop Description")
    public void testPositive() throws InterruptedException{
        String URL = "https://www.makemytrip.com";
        driver.get(URL);
        driver.manage().window().maximize();

        //Creating an instance of actions class
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();  //Page down (downward arrow button as with help of keyboard that button help to scroll down).
        //build() : to build all the actions into a composite action
        //perform() : Actually executes the actions that were built
        System.out.println("Scroll Down");
    }
}
