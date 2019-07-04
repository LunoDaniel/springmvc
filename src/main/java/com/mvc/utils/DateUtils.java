package com.mvc.utils;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.mvc.repository.DateRepository;

public class DateUtils {

	@Autowired DateRepository dates;
	
	DateUtils(){}
	
	public static Date addDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	
	public static Date getDateWithDaysDiference(int dias) {
		return addDays(new Date(), dias);
	}
	
	public static Date getDate(int dia, int mes, int ano){
		Calendar calendar = Calendar.getInstance();
		calendar.set(DAY_OF_MONTH, dia);
		calendar.set(MONTH, mes - 1);
		calendar.set(YEAR, ano);
		return calendar.getTime();
	}
	
	public static boolean isSameDate(Date fDate, Date sDate) {
		Calendar firstCalendar = Calendar.getInstance();
		firstCalendar.setTime(fDate);
		Calendar secondCalendar = Calendar.getInstance();
		secondCalendar.setTime(sDate);
		return (firstCalendar.get(DAY_OF_MONTH) == secondCalendar.get(DAY_OF_MONTH))
				&& (firstCalendar.get(MONTH) == secondCalendar.get(MONTH))
				&& (firstCalendar.get(YEAR) == secondCalendar.get(YEAR));
	}
	
	public static boolean verifyDayOfWeek(Date date, int weekOfDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(DAY_OF_WEEK) == weekOfDay;
	}
}
