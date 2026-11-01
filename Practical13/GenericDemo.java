
class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

class Pair<A, B> {
    A first;
    B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    void display() {
        System.out.println(first + " - " + second);
    }
}

public class GenericDemo {

    // Generic method to return first element
    public static <T> T getFirst(T[] array) {
        return array[0];
    }

    public static void main(String[] args) {

        // Using Box with different types
        Box<Integer> b1 = new Box<>();
        b1.set(100);

        Box<String> b2 = new Box<>();
        b2.set("Hello Java");

        System.out.println("Integer Box: " + b1.get());
        System.out.println("String Box: " + b2.get());

        // Using Pair with different types
        Pair<Integer, String> p1 =
            new Pair<>(1, "Riya");

        Pair<String, Double> p2 =
            new Pair<>("Price", 99.5);

        System.out.print("Pair 1: ");
        p1.display();

        System.out.print("Pair 2: ");
        p2.display();

        // Using generic method
        String[] names = {"Aman", "Riya", "Neha"};
        Integer[] numbers = {10, 20, 30};

        System.out.println("First Name: " + getFirst(names));
        System.out.println("First Number: " + getFirst(numbers));
    }
}
