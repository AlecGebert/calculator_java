import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String[] calc(String input) {
        String[] strEl = input.split(" ");
        if (strEl.length != 3) {
            throw new IllegalArgumentException("Должно быть 2 операнда и 1 оператор");
        }

        if (!(strEl[1].equals("+") || strEl[1].equals("-") || strEl[1].equals("*") || strEl[1].equals("/"))) {
            throw new IllegalArgumentException("Некорректный оператор");
        }
        HashMap<String, Integer> values = new HashMap<>();
        values.put("I", 1);
        values.put("II", 2);
        values.put("III", 3);
        values.put("IV", 4);
        values.put("V", 5);
        values.put("VI", 6);
        values.put("VII", 7);
        values.put("VIII", 8);
        values.put("IX", 9);
        values.put("X", 10);

        if ((!(values.containsKey(strEl[0])) || !(values.containsKey(strEl[2]))) && (parseInt(strEl[0]) < 1 || parseInt(strEl[0]) > 10 || parseInt(strEl[2]) < 1 || parseInt(strEl[2]) > 10)) {
            throw new IllegalArgumentException("Неверный операнд");
        }

        int result;
        if (values.containsKey(strEl[0]) && values.containsKey(strEl[2])) {
            int operand1 = values.get(strEl[0]);
            int operand2 = values.get(strEl[2]);
            result = switch (strEl[1]) {
                case "+" -> operand1 + operand2;
                case "-" -> operand1 - operand2;
                case "*" -> operand1 * operand2;
                case "/" -> operand1 / operand2;
                default -> throw new IllegalArgumentException("Некорректный оператор");
            };
            if (result < 0) {
                throw new IllegalArgumentException("Недопустимый вывод");
            }
            return new String[]{romanice(result)};

        } else {
            int operand1 = parseInt(strEl[0]);
            int operand2 = parseInt(strEl[2]);
            result = switch (strEl[1]) {
                case "+" -> operand1 + operand2;
                case "-" -> operand1 - operand2;
                case "*" -> operand1 * operand2;
                case "/" -> operand1 / operand2;
                default -> throw new IllegalArgumentException("Некорректный оператор");
            };
            System.out.println(result);
            if (result < 0) {
                throw new IllegalArgumentException("Недопустимый вывод");
            }
            return new String[]{Integer.toString(result)};
        }

    }
    private static String romanice(int num) {
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < romanNumerals.length; i++) {
            while (num >= values[i]) {
                roman.append(romanNumerals[i]);
                num -= values[i];
            }
        }
        return roman.toString();
    }
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         System.out.print("Введите выражение: ");
         String input = in.nextLine();
        System.out.println(Arrays.toString(calc(input)));
         in.close();
      }
    }

