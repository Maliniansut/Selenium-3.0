import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragnDrop1 {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }

    @Test
    @Description("Drag and Drop Description")
    public void testPositive() throws InterruptedException{
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);
        //driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.id("column-a")); //from where we want to drag
        WebElement to = driver.findElement(By.id("column-b"));   //to where we want it to be dragged

        //First way is drag n drop function
        //actions.dragAndDrop(from,to).perform();

        //Second way is click and hold
        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();

        Thread.sleep(4000);

    }
}

