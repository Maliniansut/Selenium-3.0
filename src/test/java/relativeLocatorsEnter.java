import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

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

        //To find list of all elements
        //table[@id='example']/tbody/tr/td[2]

        List<WebElement> list_of_Elements = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
        for(WebElement l: list_of_Elements){
            String s1= driver.findElement(with(By.tagName("p")).toRightOf(l)).getText();
            String s2= driver.findElement(with(By.tagName("p")).toLeftOf(l)).getText();
            System.out.println(l + "->" + s1 + "->" + s2);
        }
        Thread.sleep(5000);
    }
}
