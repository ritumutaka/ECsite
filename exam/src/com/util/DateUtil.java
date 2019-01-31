package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getDate() {
		
		Date date = new Date();
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		return SDF.format(date);
	}
}
