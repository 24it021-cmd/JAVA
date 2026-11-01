abstract class Media{

    String title;

    Media(String title){
        this.title=title;
    }

    abstract double lateFee(int days);
}

class Book extends Media{

    Book(String title){
        super(title);
    }

    double lateFee(int days){
        return days*2;
    }
}

class DVD extends Media{

    DVD(String title){
        super(title);
    }

    double lateFee(int days){
        return days*5;
    }
}

class Magazine extends Media{

    Magazine(String title){
        super(title);
    }

    double lateFee(int days){
        return days*1;
    }
}

public class MediaDemo{

    public static void main(String args[]){

        Media m[]={
                new Book("Java"),
                new DVD("Avengers"),
                new Magazine("Science")
        };

        int days=4;
        double total=0;

        for(Media x:m){

            double fee=x.lateFee(days);

            System.out.println(x.title+" Late Fee = "+fee);

            total+=fee;
        }

        System.out.println("Total Late Fee = "+total);
    }
}