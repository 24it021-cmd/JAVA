
public class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;

    private static int totalBooked = 0;

    // Constructor with title and capacity
    public CinemaShow(String title, int capacity) {

        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    // Constructor chaining
    public CinemaShow(String title) {
        this(title, 100);
    }

    // Book seats
    public boolean book(int n) {

        if (n > 0 && n <= seatsAvailable) {
            seatsAvailable = seatsAvailable - n;
            totalBooked = totalBooked + n;
            return true;
        }

        return false;
    }

    // Cancel seats
    public void cancel(int n) {

        if (n > 0) {
            seatsAvailable = seatsAvailable + n;

            if (seatsAvailable > capacity) {
                seatsAvailable = capacity;
            }
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println("Movie: Avengers");
        System.out.println("Available seats: "
                + show.getSeatsAvailable());

        System.out.println("Book 10 seats: " + show.book(10));
        System.out.println("Available seats: "
                + show.getSeatsAvailable());

        System.out.println("Book 30 seats: " + show.book(30));
        System.out.println("Available seats: "
                + show.getSeatsAvailable);

        System.out.println("Book 20 seats: " + show.book(20));
        System.out.println("Available seats: "
                + show.getSeatsAvailable);

        show.cancel(5);
        System.out.println("After cancellation: "
                + show.getSeatsAvailable);

        System.out.println("Total booked: "
                + CinemaShow.getTotalBooked);
    }
}
