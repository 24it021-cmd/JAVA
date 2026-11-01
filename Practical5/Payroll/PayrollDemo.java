abstract class Employee {

    String name;

    Employee(String name){
        this.name = name;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee{

    double salary;

    FullTime(String name,double salary){
        super(name);
        this.salary=salary;
    }

    double monthlySalary(){
        return salary;
    }
}

class PartTime extends Employee{

    int hours;
    double rate;

    PartTime(String name,int hours,double rate){
        super(name);
        this.hours=hours;
        this.rate=rate;
    }

    double monthlySalary(){
        return hours*rate;
    }
}

class Intern extends Employee{

    double stipend;

    Intern(String name,double stipend){
        super(name);
        this.stipend=stipend;
    }

    double monthlySalary(){
        return stipend;
    }
}

public class PayrollDemo{

    public static void main(String args[]){

        Employee emp[]={
                new FullTime("Rahul",50000),
                new PartTime("Priya",80,300),
                new Intern("Amit",10000)
        };

        double total=0;

        for(Employee e:emp){

            System.out.println(e.name+" Salary = "+e.monthlySalary());

            total+=e.monthlySalary();

            if(e instanceof Intern)
                System.out.println("Note : Intern receives stipend.");
        }

        System.out.println("Total Salary = "+total);
    }
}