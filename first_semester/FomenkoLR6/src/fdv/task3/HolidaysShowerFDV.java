package fdv.task3;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HolidaysShowerFDV {

    private Map<String, List<String>> readFileToMap(String filePath) {
        Map<String, List<String>> map = new TreeMap<>();
        String str;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((str = reader.readLine()) != null) {
                String[] list = str.split(" ", 2);
                String key = list[0].trim();
                String value = list[1].trim();
                List<String> valueList = map.get(key);
                if (valueList == null) {
                    valueList = new ArrayList<>();
                }
                valueList.add(value);
                map.put(key, valueList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }


    public void printHolidaysByDate(String holidaysFilePath, String dateStr, int numOfDays) {
        Map<String, List<String>> holidaysMap = (new HolidaysShowerFDV()).readFileToMap(holidaysFilePath);

        DateFormat txtFileFormat = new SimpleDateFormat("M/d");
        txtFileFormat.setLenient(false);

        Date date = new Date();
        try {
            date = txtFileFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("!!! The entered date format is incorrect, so the holidays are displayed starting from today !!!\n");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        for (int i = 0; i < numOfDays; i++) {
            String strDate = txtFileFormat.format(calendar.getTime());
            System.out.println(strDate);

            if (holidaysMap.get(strDate) != null) {
                for (String j : holidaysMap.get(strDate)) {
                    System.out.println(j);
                }
            } else {
                System.out.println("There are no holidays on this day");
            }
            calendar.add(Calendar.DATE, 1);
            System.out.println();
        }
    }
}
