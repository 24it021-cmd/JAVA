class Cinema {
    int seatsLeft = 5;

    synchronized void book() {

        if (seatsLeft > 0) {

            System.out.println(
                Thread.currentThread().getName() +
                " booked a seat"
            );

            seatsLeft--;
        }
    }
}

class BookingThread extends Thread {

    Cinema cinema;

    BookingThread(Cinema cinema) {
        this.cinema = cinema;
    }

    public void run() {
        cinema.book();
    }
}

public class SeatBookingWithSync {

    public static void main(String[] args) throws Exception {

        Cinema cinema = new Cinema();

        for (int i = 1; i <= 10; i++) {
            new BookingThread(cinema).start();
        }

        Thread.sleep(500);

        System.out.println("Seats left = " + cinema.seatsLeft);
    }
}