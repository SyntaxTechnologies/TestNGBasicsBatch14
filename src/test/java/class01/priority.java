package class01;

import org.testng.annotations.Test;

public class priority {

    @Test(priority = 3)
    public void Atest(){

        System.out.println("i am A test");
    }
    @Test(priority = 1)
    public void Btest(){

        System.out.println("i am B test");
    }
    @Test(priority = 2)
    public void Ctest(){

        System.out.println("i am C test");
    }
//    by deafult priority is zero
    @Test
    public void Dtest(){

        System.out.println("i am D test");
    }
    @Test
    public void ABtest(){

        System.out.println("i am AB test");
    }
}
