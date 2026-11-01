public class PasswordChecker {

    public boolean hasLength(String pw) {
        return pw.length() >= 8;
    }

    public boolean hasUppercase(String pw) {
        for (int i = 0; i < pw.length(); i++) {
            if (Character.isUpperCase(pw.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDigit(String pw) {
        for (int i = 0; i < pw.length(); i++) {
            if (Character.isDigit(pw.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSpecial(String pw) {
        for (int i = 0; i < pw.length(); i++) {
            char ch = pw.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    public String strength(String pw) {
        int count = 0;

        if (hasLength(pw))
            count++;
        if (hasUppercase(pw))
            count++;
        if (hasDigit(pw))
            count++;
        if (hasSpecial(pw))
            count++;

        if (count <= 1)
            return "Weak";
        else if (count <= 3)
            return "Medium";
        else
            return "Strong";
    }
}

class Driver {

    public static void main(String[] args) {

        PasswordChecker pc = new PasswordChecker();

        String[] passwords = {
                "abc",
                "Abcd1234!",
                "Hello12",
                "hello123"
        };

        for (String pw : passwords) {

            System.out.println("Password: " + pw);
            System.out.println("Length: " + pc.hasLength(pw));
            System.out.println("Uppercase: " + pc.hasUppercase(pw));
            System.out.println("Digit: " + pc.hasDigit(pw));
            System.out.println("Special Character: " + pc.hasSpecial(pw));
            System.out.println("Strength: " + pc.strength(pw));
            System.out.println();
        }
    }
}