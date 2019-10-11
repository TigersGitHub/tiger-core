package cn.imtiger.util.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ����ʱ�乤����
 * @author ShenHongtai
 * @date 2019-7-13
 */
public class DatetimeUtil {
	/**
	 * ��ȡָ����������ʱ��
	 * 
	 * @author ShenHongtai
	 */
	public static String getPastDateTime(int pastday) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date(date.getTime() - (pastday - 1) * 24 * 60 * 60 * 1000)) + " 00:00:00";
	}

	/**
	 * ��ʽ������ʱ��
	 * 
	 * @author ShenHongtai
	 */
	public static String formatDateTime(Calendar dateTime, String dateFormat) {
		if (dateTime == null) {
			return getNowDateTime(dateFormat);
		} else {
			return new SimpleDateFormat(dateFormat).format(dateTime.getTime());
		}
	}

	/**
	 * ��ʽ������ʱ��
	 * 
	 * @author ShenHongtai
	 */
	public static String formatDateTime(Date dateTime, String dateFormat) {
		if (dateTime == null) {
			return getNowDateTime(dateFormat);
		} else {
			return new SimpleDateFormat(dateFormat).format(dateTime);
		}
	}

	/**
	 * ��ȡ��ǰ����ʱ��
	 * 
	 * @author ShenHongtai
	 */
	public static String getNowDateTime(String dateFormat) {
		return new SimpleDateFormat(dateFormat).format(Calendar.getInstance().getTime());
	}

	/**
	 * ��ȡ��ǰ����ʱ��
	 * 
	 * @author ShenHongtai
	 */
	public static String getNow() {
		return getNowDateTime("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * ��ȡĬ�ϸ�ʽʱ��
	 * 
	 * @author ShenHongtai
	 */
	public static String getNowTime() {
		return getNowDateTime("HH:mm:ss");
	}
	
	/**
	 * ��ȡĬ�ϸ�ʽ����
	 * 
	 * @author ShenHongtai
	 */
	public static String getNowDate() {
		return getNowDateTime("yyyy-MM-dd");
	}
}
