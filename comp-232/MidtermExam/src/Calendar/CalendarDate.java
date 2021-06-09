package Calendar;

public class CalendarDate implements Comparable<CalendarDate> {

    public enum Month {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
    private Month month;
    private int day;

    public CalendarDate() {
        this.month = Month.MAY;
        this.day = (int) (Math.random() * (31 - 1 + 1) + 1);
    }
    public CalendarDate(Month month, int day) {
        this.month = month;
        this.day = day;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(day > 0 && day < 32) {
            this.day = day;
        } else {
            System.out.println("Invalid day.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CalendarDate) {
            CalendarDate otherDate = (CalendarDate) obj;
            return month.equals(otherDate.month) && (day == otherDate.day);
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(CalendarDate otherDate) {
        if(month.equals(otherDate.month)) {
            return Integer.compare(day, otherDate.day);
        } else return month.compareTo(otherDate.month);
    }

    public boolean checkDate(CalendarDate[] dates) {
        for(CalendarDate d : dates) {
            if(this.equals(d)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return month + ", " + day;
    }
}
