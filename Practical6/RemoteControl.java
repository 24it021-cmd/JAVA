
interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("Fan is ON");
    }

    public void off() {
        System.out.println("Fan is OFF");
    }
}

class Light implements Switchable {
    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}

@FunctionalInterface
interface Permission {
    boolean canSwitchOn(Switchable device, int hour);
}

public class RemoteControl {
    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(), new Light()
        };

        for (Switchable d : devices) {
            d.toggle();
            d.off();
        }

        // Anonymous class
        Permission p1 = new Permission() {
            public boolean canSwitchOn(Switchable d, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        // Lambda expression
        Permission p2 = (d, hour) -> hour >= 6 && hour <= 22;

        System.out.println("Anonymous class: "
                + p1.canSwitchOn(devices[0], 10));

        System.out.println("Lambda: "
                + p2.canSwitchOn(devices[1], 23));
    }
}
