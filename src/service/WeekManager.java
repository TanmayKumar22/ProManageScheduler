package service;

public class WeekManager {

    private static int currentWeek = 1;

    public static int getCurrentWeek() {
        return currentWeek;
    }

    public static void nextWeek() {
        currentWeek++;
    }
}