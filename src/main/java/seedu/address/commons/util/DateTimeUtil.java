package seedu.address.commons.util;

import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class DateTimeUtil {
    public static final String DATE_CONSTRAINTS =
            "Date should be a valid date in the format of dd-MM-yyyy.";
    public static final String TIME_CONSTRAINTS =
            "Time should be a valid time in the format of HH:mm.";
    public static final String DATE_TIME_CONSTRAINTS =
            "DateTime should be a valid date and time in the format of dd-MM-yyyy HH:mm.";
    public static final String DATE_VALIDATION_REGEX = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$";
    public static final String DATETIME_VALIDATION_REGEX =
            "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4} (2[0-3]|[01][0-9]):([0-5][0-9])$";
    public static final String TIME_VALIDATION_REGEX = "^(2[0-3]|[01][0-9]):([0-5][0-9])$";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    public static final String SEARCH_TIME_CONSTRAINTS =
            "Search phrase for time should be in the format of HH:mm.";
    public static final String SEARCH_DATE_CONSTRAINTS =
            "Search phrase for date should be in the format of dd-MM-yyyy.";
    public static final String DAY_MESSAGE_CONSTRAINTS =
            "Day should be in the format of MONDAY, TUESDAY, ..., SUNDAY";
    public static final LocalDateTime DEFAULT_DATETIME = LocalDateTime.parse("01-01-1000 00:00",
            DATETIME_FORMATTER.withResolverStyle(ResolverStyle.SMART)); // smartly resolve the default datetime
    public static final String RANGE_CONSTRAINTS = "Start date should be before end date";

    /**
     * Returns true if a given string is a valid date number.
     *
     * @param test the string value to be put to test.
     * @return true if the test string is valid and false otherwise
     */
    public static boolean isValidDate(String test) {
        return test.matches(DATE_VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is a valid date number.
     *
     * @param test the string value to be put to test.
     * @return true if the test string is valid and false otherwise
     */
    public static boolean isValidDateTime(String test) {
        return test.matches(DATETIME_VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is a valid date number.
     *
     * @param test the string value to be put to test.
     * @return true if the test string is valid and false otherwise
     */
    public static boolean isValidTime(String test) {
        return test.matches(TIME_VALIDATION_REGEX);
    }
    /**
     * Returns true if the start date is before the end date.
     */
    public static boolean isStartDateBeforeEndDate(LocalDate startDate, LocalDate endDate) {
        return startDate.isBefore(endDate);
    }
    /**
     * Returns true if the start time is before the end time.
     */
    public static boolean isStartTimeBeforeEndTime(LocalTime startTime, LocalTime endTime) {
        return startTime.isBefore(endTime);
    }
    /**
     * @param input the string value for a date
     * @return a LocalDate object representing the specific date
     */
    public static LocalDate toLocalDate(String input) {
        checkArgument(isValidDate(input), DATE_TIME_CONSTRAINTS);
        return LocalDate.parse(input, DateTimeUtil.DATE_FORMATTER);
    }
}
