package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGAnnotations {

//    first test case
    @Test
    public void AFirstTestCase(){
        System.out.println("i am the first test case");
    }

    @Test
    public void BSecondTestCase(){
        System.out.println("i am second test case");
    }

    @Test
    public  void ThirdTestCase(){
        System.out.println("i am third test case");
    }

    @Test
    public void FourthTestCase(){
        System.out.println("i am fourth test case");
    }
    @BeforeMethod
    public  void beforeMethod(){
        System.out.println("i am a before method");
    }

    @AfterMethod
    public void afterMehtod(){
        System.out.println(" i am after method");
    }
}
