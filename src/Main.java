import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Sighting sighting = new Sighting();

    public static void main(String[] args) {
       // SpringApplication.run(SightingDetailsApplication.class, args);
        List<Calendar> testOne=new ArrayList<>();
        Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
        Calendar calendar3 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        Calendar calendar4 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar4.set(Calendar.YEAR, 2024);
        calendar4.set(Calendar.MONTH, Calendar.JUNE); // Months are 0-based, so Calendar.JUNE = 5
        calendar4.set(Calendar.DAY_OF_MONTH, 21);
        calendar4.set(Calendar.HOUR_OF_DAY, 18);
        calendar4.set(Calendar.MINUTE, 30);
        calendar4.set(Calendar.SECOND, 0);
        calendar4.set(Calendar.MILLISECOND, 0);


        Calendar calendar5 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar5.set(Calendar.YEAR, 2024);
        calendar5.set(Calendar.MONTH, Calendar.JULY); // Months are 0-based, so Calendar.JUNE = 5
        calendar5.set(Calendar.DAY_OF_MONTH, 31);
        calendar5.set(Calendar.HOUR_OF_DAY, 23);
        calendar5.set(Calendar.MINUTE, 59);
        calendar5.set(Calendar.SECOND, 0);
        calendar5.set(Calendar.MILLISECOND, 0);
        testOne.add(calendar1);
        testOne.add(calendar2);
        testOne.add(calendar3);

        Calendar calendar6 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar6.set(Calendar.YEAR, 1994);
        calendar6.set(Calendar.MONTH, Calendar.JANUARY); // Months are 0-based, so Calendar.JUNE = 5
        calendar6.set(Calendar.DAY_OF_MONTH, 31);
        calendar6.set(Calendar.HOUR_OF_DAY, 23);
        calendar6.set(Calendar.MINUTE, 59);
        calendar6.set(Calendar.SECOND, 0);
        calendar6.set(Calendar.MILLISECOND, 0);


        Calendar calendar7 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar7.set(Calendar.YEAR, 1924);
        calendar7.set(Calendar.MONTH, Calendar.JUNE); // Months are 0-based, so Calendar.JUNE = 5
        calendar7.set(Calendar.DAY_OF_MONTH, 21);
        calendar7.set(Calendar.HOUR_OF_DAY, 23);
        calendar7.set(Calendar.MINUTE, 59);
        calendar7.set(Calendar.SECOND, 0);
        calendar7.set(Calendar.MILLISECOND, 0);

        testOne.add(calendar1);
        testOne.add(calendar2);
        testOne.add(calendar3);

        testOne.add(calendar4);
        testOne.add(calendar5);
        testOne.add(calendar6);
        testOne.add(calendar7);
        sighting.printUfoSightings(testOne);

    }
}