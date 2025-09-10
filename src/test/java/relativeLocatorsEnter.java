import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class relativeLocatorsEnter {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    @Description("Relative Locator Test")
    public void testPositive() throws InterruptedException {
        String URL = "https://www.aqi.in/real-time-most-polluted-city-ranking";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement searchElement= driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchElement.sendKeys("India"+ Keys.ENTER);

        Thread.sleep(5000);
    }
}
