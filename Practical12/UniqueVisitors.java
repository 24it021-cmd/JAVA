
import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {

        String[] logins = {
            "Riya", "Aman", "Riya", "Neha",
            "Aman", "Karan", "Priya"
        };

        // HashSet stores only unique names
        HashSet<String> users = new HashSet<>();

        // LinkedHashSet keeps the original order
        LinkedHashSet<String> orderedUsers = new LinkedHashSet<>();

        for (String name : logins) {
            users.add(name);
            orderedUsers.add(name);
        }

        // Print unique user count
        System.out.println("Unique visitors: " + users.size());

        // Print the first three distinct names
        System.out.println("First three visitors:");

        int count = 0;

        for (String name : orderedUsers) {
            if (count == 3) {
                break;
            }

            System.out.println(name);
            count++;
        }
    }
}
