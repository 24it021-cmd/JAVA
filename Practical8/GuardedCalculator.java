import java.util.Scanner;

class DivideByZeroException extends Exception {
    DivideByZeroException(String message) {
        super(message);
    }
}

public class GuardedCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean done = false;

        while (!done) {

            try {
                System.out.print("Enter first number: ");
                double a = Double.parseDouble(sc.nextLine());

                System.out.print("Enter operator: ");
                char op = sc.nextLine().charAt(0);

                System.out.print("Enter second number: ");
                double b = Double.parseDouble(sc.nextLine());

                if (op == '/' && b == 0) {
                    throw new DivideByZeroException("Cannot divide by zero");
                }

                double result = 0;

                if (op == '+')
                    result = a + b;
                else if (op == '-')
                    result = a - b;
                else if (op == '*')
                    result = a * b;
                else if (op == '/')
                    result = a / b;
                else {
                    System.out.println("Invalid operator");
                    continue;
                }

                System.out.println("Result = " + result);
                done = true;

            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid number. Enter numbers only.");
            } 
            catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
            } 
            finally {
                System.out.println("Attempt completed.");
            }
        }

        sc.close();
    }
}