package com.gearcode.feawap.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat CN_DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日");
	
	public static String formatCnDate(Date date) {
		synchronized (CN_DATE_FORMAT) {
			return CN_DATE_FORMAT.format(date);
		}
	}
	
	public static Date parseCnDate(String date) {
		synchronized (CN_DATE_FORMAT) {
			try {
				return CN_DATE_FORMAT.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
