import java.time.Duration;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewSeleneseIT {
    
    @Test
    public void testSimple() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\TEMP\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        String baseUrl="https://www.saucedemo.com";
        
        driver.get(baseUrl);
        driver.manage().window().maximize();
        
        WebDriverWait cekaj = new WebDriverWait(driver, 10);
        
        WebElement username = cekaj.until(ExpectedConditions.elementToBeClickable(By.id("user-name")));

        //Close the browser
        driver.quit();
    }
    
}
