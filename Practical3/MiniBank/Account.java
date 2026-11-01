

import java.util.Objects;

public class Account {

    private int accountNumber;
    private String ownerName;
    private double balance;

    public Account(int accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                ", Owner Name: " + ownerName +
                ", Balance: " + balance;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Account))
            return false;

        Account a = (Account) obj;

        return accountNumber == a.accountNumber;
    }
    
    @Override
    public int hashCode() 
    {
        return Objects.hash(accountNumber);
    }
    // Customer Class//

    static class Customer implements Cloneable {
        private String name;
        private Address address;
        public Customer(String name, Address address) {
            this.name = name;
            this.address = address;
        }
        public Address getAddress() {
            return address;
        }
        public static class Address 
        {
            private String line;
            private String city;
            private String pincode;

            public Address(String line, String city, String pincode) {
                this.line = line;
                this.city = city;
                this.pincode = pincode;
            }
            public String getLine() {
                return line;
            }
            public String getCity() {
                return city;
            }
            public String getPincode() {
                return pincode;
            }
        }
        
        @Override
        public Customer clone() {

            try {
                return (Customer) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
    }

    // Driver //

    public static void main(String[] args) {

        Account a1 = new Account(101, "Niksha", 5000);
        Account a2 = new Account(101, "Riya", 9000);
        Account a3 = new Account(102, "Rahul", 8000);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        System.out.println("\na1 equals a2: " + a1.equals(a2));
        System.out.println("a1 equals a3: " + a1.equals(a3));
        if (a1 instanceof Account) {
            System.out.println("\na1 is an Account object.");
        }
        Customer.Address address =
                new Customer.Address("MG Road", "Bangalore", "560001");

        Customer c1 = new Customer("Niksha", address);
        Customer c2 = c1.clone();
        System.out.println("\nCustomer cloned successfully.");
        System.out.println("Address: " +
                c1.getAddress().getLine() + ", " +
                c1.getAddress().getCity() + ", " +
                c1.getAddress().getPincode());
    }
}

