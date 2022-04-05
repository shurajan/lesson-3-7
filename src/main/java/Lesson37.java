import Test.Test;
import Test.BeforeSuite;
import Test.AfterSuite;
import Test.UnitTest;

public class Lesson37 {

    public static void main(String[] args) {
        UnitTest ut = new UnitTest();
        ut.test(Lesson37.class);
    }

    @BeforeSuite
    public void init() {
        System.out.println("Init - BeforeSuite");
    }

    @Test(priority = 10)
    public void Test1() {
        System.out.println("Test 1");
    }

    @Test(priority = 1)
    public void Test2() {
        System.out.println("Test 2");
    }


    @Test(priority = 2)
    public void Test3() {
        System.out.println("Test 3");
    }

    @Test(priority = 2)
    public void Test4() {
        System.out.println("Test 4");
    }

    @Test(priority = 10)
    public void Test5() {
        System.out.println("Test 5");
    }

    public void Test6() {
        System.out.println("НЕ ВЫЗЫВАЕТСЯ Test 6");
    }

    @AfterSuite
    public void close() {
        System.out.println("Close - AfterSuite");
    }

}
