package review1;

import org.testng.annotations.*;

public class AnnotationsTestNg {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }

    @Test
    public void actualTestCase(){
        System.out.println("This is my actual test case");
    }

    @Test
    public void secondTestCase(){
        System.out.println("This is my second test case");
    }
}
