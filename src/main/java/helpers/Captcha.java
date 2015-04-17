package helpers;

public class Captcha {

    public static String getCaptchaResult(String str) {
        String[] words = str.replace("Captcha: ", "").split(" ");

        String[] expression = new String[4];

        for (int i = 0; i<expression.length; ++i) {
            if (words[i].isEmpty()) {
                continue;
            }
            if (isNumber(words[i]) | isSign(words[i])) {
                expression[i] = words[i];
            }
            else {
                expression[i] = String.valueOf(getNumberFromString(words[i]));
            }
        }

        int a = count(expression);

        return String.valueOf(count(expression));
    }

    private static int getNumberFromString(String numberString) {
        int number = 0;

        String[] fullNumber = numberString.split(" ");

        for (String s : fullNumber) {
            int x = convertWordToNum(s);
            if (x == 0) {
                continue;
            }
            if (x<100) {
                number += x;
            }
            else number *= x;
        }

        return number;
    }

    private static int convertWordToNum(String word) {
        switch (word.toLowerCase()) {
            case "one" : return 1;
            case "two" : return 2;
            case "three" : return 3;
            case "four" : return 4;
            case "five" : return 5;
            case "six" : return 6;
            case "seven" : return 7;
            case "eight" : return 8;
            case "nine" : return 9;
            case "ten" : return 10;
            case "eleven" : return 11;
            case "twelve" : return 12;
            case "thirteen" : return 13;
            case "fourteen" : return 14;
            case "fifteen" : return 15;
            case "sixteen" : return 16;
            case "seventeen" : return 17;
            case "eighteen" : return 18;
            case "nineteen" : return 19;
            case "twenty" : return 20;
            case "thirty" : return 30;
            case "fourty" : return 40;
            case "fifty" : return 50;
            case "sixty" : return 60;
            case "seventy" : return 70;
            case "eighty" : return 80;
            case "ninety" : return 90;
            case "hundred" : return 100;
            default : return 0;
        }
    }

    private static boolean isNumber (String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    private static boolean isSign (String str) {
        if (str.equals("+") | str.equals("-") | str.equals("/") | str.equals("×") | str.equals("=")) {
            return true;
        }
        return false;
    }

    private static int count(String[] expression) {
        int answer = 0;
        if (isSign(expression[0])) {
            answer = xIsFirst(expression);
        }
        else if (isSign(expression[1]) && isSign(expression[2])) {
            answer = xIsSecond(expression);
        }
        else {
            answer = xIsLast(expression);
        }

        return answer;
    }

    private static int xIsFirst(String[] expression) {
        switch (expression[0]) {
            case "+" : return Integer.parseInt(expression[3]) - Integer.parseInt(expression[1]);
            case "×" : return Integer.parseInt(expression[3]) / Integer.parseInt(expression[1]);
            case "-" : return Integer.parseInt(expression[3]) + Integer.parseInt(expression[1]);
            case "/" : return Integer.parseInt(expression[3]) * Integer.parseInt(expression[1]);
            default : return 0;
        }
    }

    private static int xIsSecond(String[] expression) {
        switch (expression[1]) {
            case "+" : return Integer.parseInt(expression[3]) - Integer.parseInt(expression[0]);
            case "×" : return Integer.parseInt(expression[3]) / Integer.parseInt(expression[0]);
            case "-" : return Integer.parseInt(expression[0]) - Integer.parseInt(expression[3]);
            case "/" : return Integer.parseInt(expression[0]) / Integer.parseInt(expression[3]);
            default : return 0;
        }
    }

    private static int xIsLast(String[] expression) {
        switch (expression[1]) {
            case "+" : return Integer.parseInt(expression[0]) + Integer.parseInt(expression[2]);
            case "×" : return Integer.parseInt(expression[0]) * Integer.parseInt(expression[2]);
            case "-" : return Integer.parseInt(expression[0]) - Integer.parseInt(expression[2]);
            case "/" : return Integer.parseInt(expression[0]) / Integer.parseInt(expression[2]);
            default : return 0;
        }
    }
}
