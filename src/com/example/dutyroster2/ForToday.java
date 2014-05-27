package com.example.dutyroster2;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class ForToday {
	public static Calendar calendar = new GregorianCalendar();
	public static int year=calendar.get(Calendar.YEAR);
	public static int month=calendar.get(Calendar.MONTH) + 1;
	public static int dayofMonth=calendar.get(Calendar.DAY_OF_MONTH);
	public static String today=String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayofMonth);
}
