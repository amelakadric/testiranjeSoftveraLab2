import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewSeleneseIT {
    WebDriver driver;
    
    @Test
    public void testSimple() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\TEMP\\chromedriver.exe");
        
        driver = new ChromeDriver();
        String baseUrl="https://www.saucedemo.com";
        
        driver.get(baseUrl);
        driver.manage().window().maximize();
        
        WebDriverWait cekaj = new WebDriverWait(driver, 10);
        
//        Thread.sleep(5000);
    //  implicitni wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        
        //explicitni wait
        WebElement username = cekaj.until(ExpectedConditions.elementToBeClickable(By.id("user-name")));
        username.sendKeys("standard_user");
        
        WebElement psw = driver.findElement(By.id("password"));
        psw.sendKeys("secret_sauce");
        
        WebElement dugme = cekaj.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-button']")));
        dugme.click();
        Thread.sleep(5000);
        
        String welcomeText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("PRODUCTS", welcomeText);
        

        //Close the browser
        driver.quit();
    }
    
    @BeforeTest
    public void pre(){
        System.setProperty("webdriver.chrome.driver", "C:\\TEMP\\chromedriver.exe");
        
        driver = new ChromeDriver();
        String baseUrl="https://www.saucedemo.com";
        
        driver.get(baseUrl);
        driver.manage().window().maximize();
        
    
    }
    
    
    @AfterTest
    public void posle(){
        if(driver !=null)driver.quit();
        
    }
    
}
