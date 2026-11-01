class OutOfStockException extends Exception {
    int shortfall;

    OutOfStockException(String message, int shortfall) {
        super(message);
        this.shortfall = shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {

    int stock = 10;

    void issue(int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than 0"
            );
        }

        if (qty > stock) {
            int shortfall = qty - stock;

            throw new OutOfStockException(
                "Not enough stock", shortfall
            );
        }

        stock = stock - qty;

        System.out.println("Item issued successfully.");
        System.out.println("Remaining stock: " + stock);
    }
}

public class StockIssue {

    public static void main(String[] args) {

        Warehouse w = new Warehouse();

        int[] requests = {3, 20, 0, 4};

        for (int qty : requests) {

            try {
                System.out.println("\nRequest: " + qty);
                w.issue(qty);

            } catch (OutOfStockException e) {
                System.out.println(e.getMessage());
                System.out.println("Shortfall: " + e.shortfall);

            } catch (InvalidQuantityException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nAll requests completed.");
    }
}