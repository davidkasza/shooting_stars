import java.util.HashMap;

public class MapYear {
    private static HashMap<String, Integer> monthDays = new HashMap<>() {{
        put("January", 31);
        put("February", 28);
        put("March", 31);
        put("April", 30);
        put("May", 31);
        put("June", 30);
        put("July", 31);
        put("August", 31);
        put("September", 30);
        put("October", 31);
        put("November", 30);
        put("December", 31);
    }};

    public static HashMap<String, Integer> getMonthDays(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            monthDays.put("February", 29);
        } else {
            monthDays.put("February", 28);
        }
        return monthDays;
    }
}
