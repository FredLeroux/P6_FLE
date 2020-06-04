package fle.toolBox.dateAndTime;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import fle.toolBox.dateAndTime.annotation.DateTimeRawFormat;

public class FredDateTimeFormatter {

	private static final Class<DateTimeRawFormat> DATE_TIME_RAW_FORMAT_PATTERN = DateTimeRawFormat.class;

	public static String date(Field field, String rawDateAndTime) {
		if(field.getType().getSimpleName().toLowerCase().equals("localdate")) {
			return dateFormatted(parseToDate(field, rawDateAndTime),formatStyle(field));
		}else {
			return dateFormatted(parseToDateTime(field, rawDateAndTime),formatStyle(field));
		}
		
		
	}

	public static String time(Field field, String rawDateAndTime) {
		return TimeFormatted(parseToTime(field, rawDateAndTime));
	}

	private static LocalDate parseToDate(Field field, Object rawDateAndTime) {
		DateTimeFormatter dtf = dateTimeFormatter(field);
		LocalDate date = LocalDate.parse(rawDateAndTime.toString(), dtf);
		return date;
	}
	
	private static LocalDateTime parseToDateTime(Field field, Object rawDateAndTime) {
		DateTimeFormatter dtf = dateTimeFormatter(field);
		LocalDateTime date = LocalDateTime.parse(rawDateAndTime.toString(), dtf);
		return date;
	}


	private static LocalTime parseToTime(Field field, Object rawDateAndTime) {
		DateTimeFormatter dtf = dateTimeFormatter(field);
		LocalTime time = LocalTime.parse(rawDateAndTime.toString(), dtf);
		return time;
	}

	private static String rawPatternFromAnnotation(Field field) {
		return field.getAnnotation(DATE_TIME_RAW_FORMAT_PATTERN).rawFormatPattern();
	}

	private static String dateFormatted(LocalDate date, FormatStyle formatStyle) {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(formatStyle);
		return date.format(dtf);
	}
	
	private static String dateFormatted(LocalDateTime date, FormatStyle formatStyle) {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(formatStyle);
		return date.format(dtf);
	}

	private static String TimeFormatted(LocalTime time) {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		return dtf.format(time);
	}

	private static DateTimeFormatter dateTimeFormatter(Field field) {
		String timePattern = rawPatternFromAnnotation(field);
		if (timePattern.equalsIgnoreCase("basicIsoDate")) {
			return DateTimeFormatter.BASIC_ISO_DATE;
		} else if (timePattern.equalsIgnoreCase("IsoLocalDate")) {
			return DateTimeFormatter.ISO_LOCAL_DATE;
		} else if (timePattern.equalsIgnoreCase("IsoLocalTime")) {
			return DateTimeFormatter.ISO_LOCAL_TIME;
		} else if (timePattern.equalsIgnoreCase("IsoLocalDateTime")) {
			return DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		} else {
			return DateTimeFormatter.ofPattern(timePattern);
		}
	}
	
	private static FormatStyle formatStyle(Field field) {
		return field.getAnnotation(DATE_TIME_RAW_FORMAT_PATTERN).dateFormatStyle();
	}

}
