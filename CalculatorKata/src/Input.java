import java.util.Scanner;
import java.util.regex.Pattern;

class Input {
    private static String input;
    private static boolean isRoman;

    public static String inputString() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: " );
        input = in.nextLine();
        input = input.replace(" ","");

        System.out.printf("Выше выражение: %s \n", input);

        return input;
    }

    public static boolean inputVerification() throws IncorrectInputDataException {
        String patternArabicString = "^[ ]*([1-9]|10)[ ]*([+-/*])[ ]*([1-9]|10)[ ]*$";
        boolean matchesArabicPattern = Pattern.matches(patternArabicString, input);
        String patternRomanString = "^[ ]*(V?I|V?I{2}|V?I{3}|IV|V|IX|X)[ ]*([+-/*])[ ]*(V?I|V?I{2}|V?I{3}|IV|V|IX|X)[ ]*$";
        boolean matchesRomanPattern = Pattern.matches(patternRomanString, input);

        if (matchesArabicPattern==true) {
            isRoman = false;
        } else {
            if (matchesRomanPattern==true) {isRoman = true;}
            else { throw new IncorrectInputDataException("Некорректные входные данные!");
            }
        }

        return isRoman;
    }

    public static boolean getIsRoman() {
        return isRoman;
    }

    public static String getInput() {
        return input;
    }
}