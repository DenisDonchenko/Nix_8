package ua.com.alevel.calendar;

import ua.com.alevel.calendar.entity.Date;
import ua.com.alevel.calendar.util.Months;

import java.util.Arrays;
import java.util.List;

public class Calendar {

   private Date date;

    private final List<String> formatDate = Arrays.asList("m/d/yyyy", "dd/m/yyyy", "mmm-d-yyyy", "dd-mmm-yyyy");

    public Calendar() {
        this.date = new Date(5, Months.getMonthByIndex(11), 2021, 0, 0, 0, 0, formatDate.get(2), formatDate.get(2));
    }

    public String getDate(){
        return date.toString();
    }
}

