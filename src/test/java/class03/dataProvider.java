package class03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class dataProvider {

//    Test Scenario:
//    navigate to syntax HRMS
//    login into the webiste using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"

    WebDriver driver;
    @BeforeMethod
    public  void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
        @DataProvider(name = "credentials")
        public Object[][] data () {
            Object[][] loginData = {
                    {"Admin", "12345", "Invalid credential"},
                    {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                    {"Admin", "", "Password cannot be empt"},
                    {"", "Hum@nhrm123", "Username cannot be empt"}
            };
            return loginData;
        }

    @BeforeClass
    public void beforeClass(){
        System.out.println("i am Before class");
    }

    @Test(dataProvider = "credentials")
    public void LoginWithInvalidCredentials(String userName, String Password, String ExpectedErrorMsg){
        //finding the username text box
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        //send username
        username.sendKeys(userName);
        //        finding the password field
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
//        send password
        pswrd.sendKeys(Password);
        //        finding the element login btn
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
//        click the login
        loginBtn.click();
//             get the element message invalid crdentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        //        extract the error message
        String actualError = errorMsg.getText();
//assertion
        Assert.assertEquals(actualError,ExpectedErrorMsg);

    }

    @AfterMethod
    public  void closeBrowser(){
        driver.quit();
    }

}
//8:45
