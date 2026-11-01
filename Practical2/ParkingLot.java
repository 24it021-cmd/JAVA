
public class ParkingLot {

    private int twoWheelers;
    private int fourWheelers;

    private final int twoCap;
    private final int fourCap;

    private static long revenue = 0;

    // Constructor
    public ParkingLot(int twoCap, int fourCap) {

        this.twoCap = twoCap;
        this.fourCap = fourCap;

        twoWheelers = 0;
        fourWheelers = 0;
    }

    // Park vehicle
    public void park(String type) {

        if (type.equalsIgnoreCase("two")) {

            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue = revenue + 20;
                System.out.println("Two-wheeler parked");
            } else {
                System.out.println("Full");
            }

        } else if (type.equalsIgnoreCase("four")) {

            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue = revenue + 40;
                System.out.println("Four-wheeler parked");
            } else {
                System.out.println("Full");
            }

        } else {
            System.out.println("Invalid vehicle type");
        }
    }

    // Leave parking
    public void leave(String type) {

        if (type.equalsIgnoreCase("two")) {

            if (twoWheelers > 0) {
                twoWheelers--;
                System.out.println("Two-wheeler left");
            }

        } else if (type.equalsIgnoreCase("four")) {

            if (fourWheelers > 0) {
                fourWheelers--;
                System.out.println("Four-wheeler left");
            }
        }
    }

    public static void main(String[] args) {

        ParkingLot p = new ParkingLot(2, 1);

        p.park("two");
        p.park("two");
        p.park("two");

        p.park("four");
        p.park("four");

        p.leave("two");

        System.out.println("Two-wheelers: " + p.twoWheelers);
        System.out.println("Four-wheelers: " + p.fourWheelers);

        System.out.println("Total revenue: " + revenue);
    }
}
