package cn.imtiger.saml.util;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;

/**
 * SAML2.0������
 * @author shen_hongtai
 * @date 2019-11-29
 */
public abstract class SAMLUtil {
	
	/**
	 * ��ȡ��ǰʱ��
	 * @return
	 */
	public static DateTime getIssueInstant() {
		Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        return new DateTime(year, month, day, hour, minute, second, 0, ISOChronology.getInstanceUTC());
	}

	/**
	 * ��ȡ���ѽ�ֹʱ�䣨Ĭ��Ϊ��ǰʱ���5���ӣ�
	 * @return
	 */
	public static DateTime getNotOnOrAfter() {
		return getNotOnOrAfter(5);
	}

	/**
	 * ��ȡ���ѽ�ֹʱ��
	 * @param expiredMinutes ��Ч�ڣ���λ�����ӣ�
	 * @return
	 */
	public static DateTime getNotOnOrAfter(Integer expiredMinutes) {
		Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE) + expiredMinutes;
        int second = cal.get(Calendar.SECOND);
        return new DateTime(year, month, day, hour, minute, second, 0, ISOChronology.getInstanceUTC());
	}
	
}
