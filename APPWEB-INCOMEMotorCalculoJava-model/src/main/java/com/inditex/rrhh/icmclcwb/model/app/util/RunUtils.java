package com.inditex.rrhh.icmclcwb.model.app.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class RunUtils {

    private RunUtils() {
    }
    
    public static String addDays(final LocalDateTime ldt, int number, String datePattern) {
        LocalDateTime date = LocalDateTime.of(ldt.getYear(),
                ldt.getMonthValue(), ldt.getDayOfMonth(), ldt.getHour(), ldt.getMinute(), ldt.getSecond());
        return date.plusDays(number).format(DateTimeFormatter.ofPattern(datePattern));
    }

}
