package com.upgrad.booking.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class BookingUtil {
    public static ArrayList<String> getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String>numberList = new ArrayList<String>();

        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }

        return numberList;
    }
    public static int getNumberofDays(LocalDateTime fromDate, LocalDateTime toDate) {
        long daysBetween = Duration.between(fromDate, toDate).toDays();
        System.out.println ("Days: " + daysBetween);
        return (int) daysBetween;
    }
}
