package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HardAssertions {

    WebDriver driver;
    @BeforeMethod
    public void launchTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void invalidCredentials(){
     //username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
//        password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("abracadabra");
//        login
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();
//        invalid credentials
        WebElement errorMSG = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String ActualErrorMsg = errorMSG.getText();
         String ExpectedErrorMsg="Invalid credential";
//   Assertion
        Assert.assertEquals(ActualErrorMsg,ExpectedErrorMsg);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
