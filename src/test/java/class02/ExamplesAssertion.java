package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ExamplesAssertion {

//    goto syntax hrms
//    verify that login btn is dislayed
//    verify that login btn is Enabled
//    close the browser

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
    public void LoginBtnIsDisplyed(){

        //        login btn
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        boolean isdisplayed = logIn.isDisplayed();
//        use soft assertion
        SoftAssert soft= new SoftAssert();
//        assertion
        soft.assertTrue(isdisplayed);

//        test if it is enabled
        boolean isenabled = logIn.isEnabled();
//        assertion
        soft.assertTrue(isenabled);
//        assert all
        soft.assertAll();
    }

@Test
public void testing(){
    System.out.println("i am a test2");
}

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


}
