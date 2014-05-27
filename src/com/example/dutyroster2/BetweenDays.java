package com.example.dutyroster2;

import android.annotation.SuppressLint;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BetweenDays {

	@SuppressLint("SimpleDateFormat")
	public static long betweenTwoDays(String startTime,String endTime){
		long quot = 0;
		  SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
		  try {
		   Date date1 = ft.parse(startTime);
		   Date date2 = ft.parse(endTime);
		   quot = date2.getTime() - date1.getTime();
		   quot = quot / 1000 / 60 / 60 / 24;
		  } catch (ParseException e) {
		   e.printStackTrace();
		  }
		  return quot;
	}
}
