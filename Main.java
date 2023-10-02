import java.util.Scanner;


public class Main {
    static String[] arab = {"10", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    static String[] rome = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static String rimToArab(String rim) {


        for (int i = 0; i < rome.length; i++) {
            if (rome[i].equals(rim))
                return arab[i];


        }
        throw new IllegalArgumentException();

    }
    public static String arabToRim(int a) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[a];
    }


    public static boolean isRim(String par) {
        for (int i = 0; i < rome.length; i++) {
            if (rome[i].equals(par))
                return true;
        }
        return false;
    }

    public static String calculator(String str) {

        if (str.split(" ").length != 3)
            throw new IllegalArgumentException();

        String a, b;
        char operation;
        boolean x, y;

        a = str.split(" ")[0];
        b = str.split(" ")[2];
        operation = (char) str.split(" ")[1].codePointAt(0);


        x = isRim(String.valueOf(a));
        y = isRim(String.valueOf(b));

        if ((x && !y) || (!x && y)) {
            throw new NumberFormatException();

        } else if (x && y) {
            a = rimToArab(a);
            b = rimToArab(b);
            check(a, b, operation);
            return arabToRim(Integer.parseInt(operations(Integer.parseInt(a), Integer.parseInt(b), operation)));

        } else {

            return check(a, b, operation);
        }
    }

    public static String check(String a, String b, char operation) {
        if (Integer.parseInt(a) < 0 || Integer.parseInt(b) < 0)
            throw new NumberFormatException();
        return operations(Integer.parseInt(a), Integer.parseInt(b), operation);
    }

    public static String operations(int a, int b, char op) {
        switch (op) {
            case '+':
                return String.valueOf(a + b);
            case '-':
                return String.valueOf(a - b);
            case '*':
                return String.valueOf(a * b);
            case '/':
                return String.valueOf(a / b);
            default:
                throw new ArithmeticException();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true)
            System.out.println(calculator(sc.nextLine()));


    }


}