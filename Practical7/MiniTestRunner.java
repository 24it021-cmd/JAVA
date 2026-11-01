
import java.lang.annotation.*;
import java.lang.reflect.*;

// Custom Run annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

// Class containing test methods
class MyTests {

    @Run
    public void testOne() {
        System.out.println("Test One executed");
    }

    @Run
    public void testTwo() {
        System.out.println("Test Two executed");
    }

    public void normalMethod() {
        System.out.println("Normal method");
    }

    @Run
    public void testThree() {
        System.out.println("Test Three executed");
    }
}

public class MiniTestRunner {

    public static void main(String[] args) throws Exception {

        MyTests obj = new MyTests();

        Method[] methods = obj.getClass().getDeclaredMethods();

        int count = 0;

        for (Method method : methods) {

            if (method.isAnnotationPresent(Run.class)) {

                method.invoke(obj);
                count++;
            }
        }

        System.out.println("Total methods executed: " + count);
    }
}
