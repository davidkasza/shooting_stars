import java.util.HashMap;
import java.util.Map;

public class ShootingStar {
    //Question: How many shooting stars did they count on the 2nd day of any month?
    public int shootingStarsSecondDayOfAnyMonth(HashMap<Integer, HashMap<String, HashMap<Integer, Integer>>> shootingStars) {
        int sum = 0;

        for (Map.Entry<Integer, HashMap<String, HashMap<Integer, Integer>>> entry : shootingStars.entrySet()) {
            for (Map.Entry<String, Integer> months : MapYear.getMonthDays(entry.getKey()).entrySet()) {
                sum = sum + entry.getValue().get(months.getKey()).get(2);
            }
        }

        return sum;
    }

    //Question: How many shooting stars did they count every November?
    public int shootingStarsEveryNovember(HashMap<Integer, HashMap<String, HashMap<Integer, Integer>>> shootingStars) {
        int sum = 0;

        for (Map.Entry<Integer, HashMap<String, HashMap<Integer, Integer>>> entry : shootingStars.entrySet()) {
            for (int i = 1; i <= MapYear.getMonthDays(entry.getKey()).get("November"); i++) {
                sum = sum + entry.getValue().get("November").get(i);
            }
        }

        return sum;
    }

    public HashMap<Integer, HashMap<String, HashMap<Integer, Integer>>> fillShootingStarData(int yearFrom, int yearTo) {
        HashMap<String, HashMap<Integer, Integer>> monthsAndDaysAndShootingStarsInnerMap;
        HashMap<Integer, HashMap<String, HashMap<Integer, Integer>>> shootingStars = new HashMap<>();
        for (int i = yearFrom; i <= yearTo; i++) {
            monthsAndDaysAndShootingStarsInnerMap = fillMonthsAndDaysAndShootingStarsInnerMap(MapYear.getMonthDays(i));
            shootingStars.put(i, monthsAndDaysAndShootingStarsInnerMap);
        }
        return shootingStars;
    }

    private HashMap<String, HashMap<Integer, Integer>> fillMonthsAndDaysAndShootingStarsInnerMap(HashMap<String, Integer> monthDays) {
        HashMap<String, HashMap<Integer, Integer>> monthsAndDaysAndShootingStarsInnerMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : monthDays.entrySet()) {
            HashMap<String, Integer> mapToPass = new HashMap<>();
            mapToPass.put(entry.getKey(), entry.getValue());
            monthsAndDaysAndShootingStarsInnerMap.put(entry.getKey(), fillDaysAndShootingStars(mapToPass));
        }

        return monthsAndDaysAndShootingStarsInnerMap;
    }

    private HashMap<Integer, Integer> fillDaysAndShootingStars(HashMap<String, Integer> mapFromPass) {
        HashMap<Integer, Integer> daysAndShootingStarsInnerMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : mapFromPass.entrySet()) {
            for (int i = 1; i <= entry.getValue(); i++) {
                daysAndShootingStarsInnerMap.put(i, randomGenerator(2, 2));
            }
        }

        return daysAndShootingStarsInnerMap;
    }

    private int randomGenerator(int from, int to) {
        return (int) Math.floor(Math.random() * (to - from + 1) + from);
    }
}
