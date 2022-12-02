package review1;

import org.testng.annotations.Test;

public class PriorityExample {
    @Test(priority = 2)
    public void firstTestCase(){
        System.out.println("My first test case");
    }

    @Test(priority = 1)
    public void secondTestCase(){
        System.out.println("My another test case");
    }
}
