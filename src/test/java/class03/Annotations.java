package class03;

import org.testng.annotations.*;

public class Annotations {


@BeforeTest
public void t(){
    System.out.println("i am before test");
}
    @AfterTest
    public void t2(){
        System.out.println("i am after test");
    }


    @BeforeMethod
    public  void BeforeMethod(){
        System.out.println("I am Before Method");
    }
    @Test
    public void AFirstTest(){
        System.out.println("I am A 1 Test");
    }


    @Test
    public void BSecondTest(){
        System.out.println("I am B 2 Test");
    }

    @AfterMethod
    public  void AfterMethod(){
        System.out.println("I am After Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("i am after class");
    }


}
