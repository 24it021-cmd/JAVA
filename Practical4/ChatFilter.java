import java.util.Scanner;
public class ChatFilter {

    public boolean containsKeyword(String message, String keyword) {
        return message.toLowerCase().contains(keyword.toLowerCase());
    }
}



class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] logs = {
                "10:05 alice Hello there",
                "10:10 bob Good Morning",
                "WrongLine",
                "10:20 riya hello everyone"
        };

        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        ChatFilter cf = new ChatFilter();

        int count = 0;
        StringBuilder report = new StringBuilder();

        for (String line : logs) {

            String[] parts = line.split(" ", 3);

            if (parts.length < 3)
                continue;

            String time = parts[0];
            String user = parts[1];
            String message = parts[2];

            if (cf.containsKeyword(message, keyword)) {
                count++;
                report.append(time)
                      .append(" ")
                      .append(user)
                      .append(": ")
                      .append(message)
                      .append("\n");
            }
        }

        System.out.println("\nMatches: " + count);
        System.out.println(report);
    }
}