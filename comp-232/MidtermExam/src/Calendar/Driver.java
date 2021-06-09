package Calendar;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {

    public static void main(String[] args) {
        CalendarDate d1 = new CalendarDate();
        CalendarDate d2 = new CalendarDate();
        d2.setDay(15);

        System.out.println(d1.getDay());
        System.out.println(d2.getDay());
        d2.setMonth(CalendarDate.Month.AUGUST);
        ArrayList<CalendarDate> arr = new ArrayList<>();
        arr.add(d1);
        arr.add(d2);
        Collections.sort(arr);
        for(CalendarDate d : arr) {
            System.out.println(d);
        }
        CalendarDate[] dates = {d1, d2};
        System.out.println(d1.checkDate(dates));

    }
}
