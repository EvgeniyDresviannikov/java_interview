package three.one;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

public class FormatterSetting {
    public static void main(String[] strings) {
        FormatterSetting formatterSetting = new FormatterSetting();

        //LocalDateTime localDateTime = formatterSetting.toMoscowTime(LocalDateTime.now(), "Europe/London");
        //formatterSetting.instantToDate(Instant.now());

        Map<DayOfWeek, WorkingDayTime> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, new WorkingDayTimeImpl(LocalTime.of(9, 0), LocalTime.of(18,0)));
        schedule.put(DayOfWeek.TUESDAY, new WorkingDayTimeImpl(LocalTime.of(9, 0), LocalTime.of(18,0)));
        schedule.put(DayOfWeek.WEDNESDAY, new WorkingDayTimeImpl(LocalTime.of(10, 0), LocalTime.of(18,0)));
        schedule.put(DayOfWeek.THURSDAY, new WorkingDayTimeImpl(LocalTime.of(9, 0), LocalTime.of(18,0)));
        schedule.put(DayOfWeek.SUNDAY, new WorkingDayTimeImpl(LocalTime.of(9, 0), LocalTime.of(18,0)));

        String result = formatterSetting.getOperationTime(schedule);

        System.out.println(result);

    }
    DateTimeFormatter format() {
        return DateTimeFormatter.ofPattern("yyyy-'M'M-'W'W-E:HH:mm",  Locale.UK);
    }

    LocalDateTime toMoscowTime(LocalDateTime localDateTime, String zoneName) {
        System.out.println(localDateTime);
        Instant localDateTimeInst = localDateTime.toInstant(ZoneOffset.of(ZoneId.of(zoneName).getId()));
        System.out.println(localDateTimeInst);
        ZoneId newZone = ZoneId.of("Europe/Moscow");
        ZonedDateTime localDateTimeWithNewZone = ZonedDateTime.ofInstant(localDateTimeInst, newZone);
        System.out.println(localDateTimeWithNewZone);

        return localDateTimeWithNewZone.toLocalDateTime();

    }

    Date instantToDate(Instant instant) {
        Date max = new Date(Long.MAX_VALUE);
        Date min = new Date(Long.MIN_VALUE);
        if (max.toInstant().isBefore(instant)) {return max;}
        if (min.toInstant().isAfter(instant)) {return min;}

        return Date.from(instant);
    }


    String getOperationTime(Map<DayOfWeek, WorkingDayTime> dayTimeMap) {
        Locale rus = new Locale("ru", "RU");
        final WorkingDayTimeImpl PREVIOUS_EMPTY = new WorkingDayTimeImpl(LocalTime.of(0,0), LocalTime.of(0,0));
        int counterOffDays = 0;
        int counterWorkDays = 0;
        WorkingDayTimeImpl previous = PREVIOUS_EMPTY;

        StringBuilder builder = new StringBuilder();

        for (DayOfWeek day : DayOfWeek.values()) {
            if (dayTimeMap.get(day) == null) {
                counterOffDays++;
                if (counterWorkDays > 0) {
                    builder.append(day.minus(counterWorkDays).getDisplayName(TextStyle.SHORT, rus))
                            .append("-")
                            .append(day.minus(1).getDisplayName(TextStyle.SHORT, rus))
                            .append(" ")
                            .append(previous.toString())
                            .append(", ");
                }
                counterWorkDays = 0;

                if (day.equals(DayOfWeek.SUNDAY)) {
                    builder.append(day.minus(counterOffDays-1).getDisplayName(TextStyle.SHORT, rus))
                            .append(" - ")
                            .append(day.getDisplayName(TextStyle.SHORT, rus))
                            .append(" - выходные, ");
                }

            } else {
                if (counterOffDays > 0) {
                    builder.append(day.minus(counterOffDays).getDisplayName(TextStyle.SHORT, rus))
                            .append(" - ")
                            .append(day.minus(1).getDisplayName(TextStyle.SHORT, rus))
                            .append(" - выходные, ");
                }
                if ( (counterWorkDays > 0
                        && previous.getStart().equals(dayTimeMap.get(day).getStart())
                        && previous.getEnd().equals(dayTimeMap.get(day).getEnd()))
                        || previous.equals(PREVIOUS_EMPTY)) {

                    previous = (WorkingDayTimeImpl) dayTimeMap.get(day);
                    counterWorkDays++;
                    counterOffDays = 0;


                } else {
                    builder.append(day.minus(counterWorkDays).getDisplayName(TextStyle.SHORT, rus))
                                .append("-")
                                .append(day.minus(1).getDisplayName(TextStyle.SHORT, rus))
                                .append(" ")
                                .append(previous.toString())
                                .append(", ");

                    counterWorkDays = 0;
                    previous = PREVIOUS_EMPTY;
                }

                /*
                if (day.equals(DayOfWeek.SUNDAY)) {
                    builder.append(day.minus(counterWorkDays-1).getDisplayName(TextStyle.SHORT, rus))
                            .append("-")
                            .append(day.getDisplayName(TextStyle.SHORT, rus))
                            .append(" ")
                            .append(previous.toString())
                            .append(", ");
                }

                 */
            }
        }

        return builder.toString();
    }




}

class WorkingDayTimeImpl implements WorkingDayTime {
    private LocalTime start;
    private LocalTime end;

    public WorkingDayTimeImpl(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public LocalTime getStart() {
        return this.start;
    }

    @Override
    public LocalTime getEnd() {
        return this.end;
    }

    @Override
    public String toString() {
        return start + "-" + end;
    }
}

interface WorkingDayTime {
    LocalTime getStart();
    LocalTime getEnd();
}
