package helpers;

import java.text.SimpleDateFormat;

public class Date {
    /*
      get current date in the "dd.MM.yyyy" pattern
     */
    public static String getCurrentDate() {
        return getCurrentDate("dd.MM.yyyy");
    }

    /*
      get current date in the custom pattern
     */
    public static String getCurrentDate(String pattern) {
        return formatDate(new Date(), pattern);
    }

    /*
      Format date to string using custom pattern
     */
    public static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

}
