

import java.util.*;

public class Sighting {

    public void printUfoSightings(List<Calendar> sightings)
    {
        if(sightings==null || sightings.size()==0)
        {
            System.out.println("No data to show");
            return;
        }

        //STEP 1 :AS IN QUESTION IT HAS BEEN MENTIONED THAT DIFFERENT SIGHTING RECORDS CAN BE OF
        //DIFFERENT TIME ZONE , THEREFORE WE NEED TO CONVERT ALL INTO ANY ONE ,I.E UTC AS
        //OUTPUT IS REQUIRED IN UTC

        convertToUTCTimeZone(sightings);

        //STEP 2 : FIND MINIMUM AND MAXIMUM DATE THE LIST HAS RECORD SO THAT WE CAN ITERATE FROM LEAST
        //TO MAX DAY , AND COULD FIND THE RECORDS OF EACH DAY WITHOUT SKIPPING ANY OF THE DAY

        long[] rangeOfDaysGivenInRecords=new long[2];
        findTheMinAndMaxDayFromTheRecord(sightings,rangeOfDaysGivenInRecords);


        //STEP 3 : GROUPING , AS THE QUESTION ASK FOR TO DISPLAY THE TOTAL NUMBER OF SIGHTINGS ON DAY BASIS
        //RATHER THAN YEAR OR MONTH, MY GROUPING KEY WILL BE  DD-MM-YYYY
        //AS ALL OF THE DATA NOW AVAILABLE IS IN UTC I CAN USE HASH MAP TO GROUP THE RECORDS OF SAME DAY
        //IF THE QUESTION WOULD HAVE ASKED TO DISPLAY ON THE MONTH BASIS THEN MY GROUPING KEY WOULD BE
        //MM-YYYY
        HashMap<String,Integer> numberOfSightingsOnEachDay=new HashMap<>();
        groupEachRecordsOnTheBasisOfDay(sightings,numberOfSightingsOnEachDay);


        //STEP 4 : NOW  I HAVE TO ITERATE THROUGH LEAST DATE TILL MAX DATE, JUST WHILE ITERATING I HAVE
        //TO CHECK WHETHER THE RECORD IS PRESENT OR NOT USING HASHMAP KEY, IF NOT THEN JUST PRINT 0

        printEachDayRecord(numberOfSightingsOnEachDay,rangeOfDaysGivenInRecords);

    }

    private void printEachDayRecord(HashMap<String, Integer> numberOfSightingsOnEachDay, long[] rangeOfDaysGivenInRecords) {
        long startTime = rangeOfDaysGivenInRecords[0];
        long endTime = rangeOfDaysGivenInRecords[1];
        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
        HashMap<Integer,String> listOfMonths = new HashMap<>();
        listOfMonths.put( 1,"January");
        listOfMonths.put( 2,"February");
        listOfMonths.put( 3,"March");
        listOfMonths.put( 4,"April");
        listOfMonths.put( 5,"May");
        listOfMonths.put( 6,"June");
        listOfMonths.put( 7,"July");
        listOfMonths.put( 8,"August");
        listOfMonths.put( 9,"September");
        listOfMonths.put( 10,"October");
        listOfMonths.put( 11,"November");
        listOfMonths.put( 12,"December");

        int[] days=new int[12];
        days[0]=31;
        days[1]=29;
        days[2]=31;
        days[3]=30;
        days[4]=31;
        days[5]=30;
        days[6]=31;
        days[7]=31;
        days[8]=30;
        days[9]=31;
        days[10]=30;
        days[11]=31;

        for (int month=1;month<=12;month++) {
            // Perform operations for each day
            int lastDayOfMonth = days[month - 1];
            for (int day = 1; day <= lastDayOfMonth; day++) {


                String key = day + "-" + month;
                if (numberOfSightingsOnEachDay.containsKey(key))
                    System.out.println(day + "-" +listOfMonths.get(month)+": "+ numberOfSightingsOnEachDay.get(key));
                else
                    System.out.println(day + "-" +listOfMonths.get(month)+": 0 ");

            }
        }

    }

    private void groupEachRecordsOnTheBasisOfDay(List<Calendar> sightings, HashMap<String, Integer> numberOfSightingsOnEachDay) {
        for(Calendar calendar : sightings) {
            int day=calendar.get(Calendar.DAY_OF_MONTH);
            int month=calendar.get(Calendar.MONTH)+1;
            int year=calendar.get(Calendar.YEAR);

            String key=day+"-"+month;
            if(numberOfSightingsOnEachDay.containsKey(key)) {
                numberOfSightingsOnEachDay.put(key,numberOfSightingsOnEachDay.get(key)+1);
            }
            else
            {
                numberOfSightingsOnEachDay.put(key,1);
            }
        }

    }

    private void findTheMinAndMaxDayFromTheRecord(List<Calendar> sightings, long[] rangeOfDaysGivenInRecords) {

        long minDateInMillis = Long.MAX_VALUE;
        long maxDateInMillis = Long.MIN_VALUE;
        for(Calendar sighting : sightings) {
            if(sighting.getTimeInMillis()<minDateInMillis)
                minDateInMillis = sighting.getTimeInMillis();
            if(sighting.getTimeInMillis()>maxDateInMillis)
                maxDateInMillis = sighting.getTimeInMillis();
        }
        rangeOfDaysGivenInRecords[0]=minDateInMillis;
        rangeOfDaysGivenInRecords[1]=maxDateInMillis;
    }

    private void convertToUTCTimeZone(List<Calendar> sightings) {

        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");

        for(Calendar calendar : sightings) {
            long milliseconds = calendar.getTimeInMillis();
            calendar.setTimeZone(utcTimeZone);
            calendar.setTimeInMillis(milliseconds);
        }

    }
}
