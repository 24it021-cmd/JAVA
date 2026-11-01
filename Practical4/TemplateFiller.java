import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TemplateFiller {

    public String findValue(String key, String[] names, String[] values) {

        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(key)) {
                return values[i];
            }
        }

        return "[?]";
    }
}

class Driver {

    public static void main(String[] args) {

        String template = "Dear {name}, order {id} ships {date}.";

        String[] names = {
                "name",
                "id"
        };

        String[] values = {
                "Riya",
                "A07"
        };

        TemplateFiller tf = new TemplateFiller();

        Pattern p = Pattern.compile("\\{(\\w+)\\}");
        Matcher m = p.matcher(template);

        StringBuilder result = new StringBuilder();

        int last = 0;

        while (m.find()) {

            result.append(template.substring(last, m.start()));

            String key = m.group(1);

            result.append(tf.findValue(key, names, values));

            last = m.end();
        }

        result.append(template.substring(last));

        System.out.println(result);
    }
}