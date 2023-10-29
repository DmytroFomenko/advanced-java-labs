package fdv.task1and2;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;


public class DataTimeProcessing {
    static String goalDate(String setDate, int numDateDifference) {

        DateFormat myFormatDate = new SimpleDateFormat("dd.MM.yyyy");
        myFormatDate.setLenient(false);
        Date date;

        try {
            date = myFormatDate.parse(setDate);
        } catch (ParseException e) {
            return "Wrong date format";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, numDateDifference);

        return myFormatDate.format(calendar.getTime());
    }


    static String goalTime(String setTime, int numMinDifference, int numSecDifference) {

        DateFormat myFormatTime = new SimpleDateFormat("HH:mm:ss");
        myFormatTime.setLenient(false);
        Date time;

        try {
            time = myFormatTime.parse(setTime);
        } catch (ParseException e) {
            return "Wrong time format";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.MINUTE, numMinDifference);
        calendar.add(Calendar.SECOND, numSecDifference);

        return myFormatTime.format(calendar.getTime());
    }


    static String yearsMonthDays(String setDate) {
        StringBuilder sb = new StringBuilder();
        DateFormat myFormatDate = new SimpleDateFormat("dd.MM.yyyy");
        myFormatDate.setLenient(false);
        LocalDate now = LocalDate.now();

        Date date;
        try {
            date = myFormatDate.parse(setDate);
        } catch (ParseException e) {
            return "Wrong date format";
        }

        LocalDate dateLocal = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Period diff = Period.between(dateLocal, now);

        int yearsDiff = diff.getYears();
        int monthsDiff = diff.getMonths();
        int daysDiff = diff.getDays();

        sb.append(yearsDiff)
                .append(" years, ")
                .append(monthsDiff)
                .append(" months, ")
                .append(daysDiff)
                .append(" days");

        return sb.toString();
    }


    static String showMeetingData(int quarter) {

        StringBuilder sb = new StringBuilder();
        DateFormat myFormatDate = new SimpleDateFormat("dd.MM.yyyy");

        Month firstMonth = null;

        if (quarter == 1) {
            firstMonth = Month.of(1);
        } else if (quarter == 2) {
            firstMonth = Month.of(4);
        } else if (quarter == 3) {
            firstMonth = Month.of(7);
        } else if (quarter == 4) {
            firstMonth = Month.of(10);
        } else {
            return "Wrong number of quarter!!!";
        }

        int yearNow = Year.now().getValue();
        YearMonth ym = YearMonth.of(yearNow, firstMonth);
        LocalDate secondWed = ym.atDay(1).with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.WEDNESDAY));
        Date DateSecondWed = java.sql.Date.valueOf(secondWed);
        String formattedStrSecondWed = myFormatDate.format(DateSecondWed);

        sb.append("Date of summary of quarter ").append(quarter).append(" is ").append(formattedStrSecondWed);

        return sb.toString();
    }
}
