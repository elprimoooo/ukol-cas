package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadejte rok: ");
        int userYear = scanner.nextInt();
        boolean isLeapYear = isLeapYear(userYear);
        System.out.println("Rok " + userYear + " " + (isLeapYear ? "je" : "není") + " přestupný.");

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        isLeapYear = isLeapYear(currentYear);
        System.out.println("Aktuální rok " + currentYear + " " + (isLeapYear ? "je" : "není") + " přestupný.");
        if (!isLeapYear) {
            int nextLeapYear = findNextLeapYear(currentYear);
            System.out.println("Další přestupný rok bude " + nextLeapYear + ".");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date now = new Date(System.currentTimeMillis());
        String formattedDate = dateFormat.format(now);
        System.out.println("Aktuální systémový čas: " + formattedDate);

        System.out.print("Zadejte den (1-31): ");
        int day = scanner.nextInt();
        System.out.print("Zadejte měsíc (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Zadejte rok: ");
        int targetYear = scanner.nextInt();
        Date targetDate = new Date(targetYear - 1900, month - 1, day);
        long remainingTime = targetDate.getTime() - now.getTime();

        int remainingSeconds = (int) (remainingTime / 1000);
        int remainingMinutes = remainingSeconds / 60;
        remainingSeconds %= 60;
        int remainingHours = remainingMinutes / 60;
        remainingMinutes %= 60;
        int remainingDays = remainingHours / 24;
        remainingHours %= 24;
        int remainingMonths = remainingDays / 30;
        remainingDays %= 30;
        int remainingYears = remainingMonths / 12;
        remainingMonths %= 12;

        System.out.println("Do zadaného data zbývá:");
        System.out.println(remainingYears + " let, " + remainingMonths + " měsíců, " + remainingDays + " dní, " +
                remainingHours + " hodin, " + remainingMinutes + " minut, " + remainingSeconds + " sekund.");
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int findNextLeapYear(int year) {
        while (!isLeapYear(++year)) ;
        return year;
    }
}
