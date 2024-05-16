package info.tourkorea.token;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class DateUtil {
    
    public static Date generateSecondsAfterDate(int sec) {
        Instant now = Instant.now();
        Instant newDate = now.plus(Duration.ofSeconds(sec));
        return Date.from(newDate);
    }
    
    public static Date generateHoursAfterDate(int hour) {
        Instant now = Instant.now();
        Instant newDate = now.plus(Duration.ofHours(hour));
        return Date.from(newDate);
    }
    
    public static Date generateDaysAfterDate(int days) {
        Instant now = Instant.now();
        Instant newDate = now.plus(Duration.ofDays(days));
        return Date.from(newDate);
    }
}
