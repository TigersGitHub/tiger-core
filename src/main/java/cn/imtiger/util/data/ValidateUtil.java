package cn.imtiger.util.data;

/**
 * ����У�鹤����
 * @author ShenHongtai
 * @date 2019-10-10
 */
public class ValidateUtil {
    /**
     * У���ַ�����Ϊ��
     * @param value
     * @return
     */
    public static boolean isNotNull(String value) {
        return !isNull(value);
    }

    /**
     * У���ַ���Ϊ��
     * @param value
     * @return
     */
    public static boolean isNull(String value) {
        return value == null || "".equals(value);
    }
    
    /**
     * У���ַ�����Ϊ��
     * @param value
     * @return
     */
    public static boolean isNull(String[] value) {
    	return value == null || value.length == 0;
    }
    
    /**
     * У���ַ����ǿհ�
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
    
	/**
	 * У���ַ���Ϊ�հ�
	 * @param value
	 * @return
	 */
	public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * У���ַ����Ƿ�Ϊ�����ʽ
     * @param email
     * @return
     */
	public static boolean isEmail(String email) {
		String regex = "^[A-Za-z0-9_.]{1,}[@][A-Za-z0-9]{1,}([.][A-Za-z0-9]{1,}){1,2}$";
		return email.matches(regex);
	}
    
    /**
     * У���ַ����Ƿ�Ϊ�ֻ������ʽ
     * @param mobile
     * @return
     */
	public static boolean isMobile(String mobile) {
		String regex = "^[1][0-9]{10}$";
		return mobile.matches(regex);
	}
	
	/**
	 * У���ַ����Ƿ�ΪIPv4��ַ��ʽ
	 * @param ip
	 * @return
	 */
	public static boolean isIPv4(String ip) {
		String regex = "^(((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))$";
		return ip.matches(regex);
	}
	
	/**
	 * У���ַ�Ƿ�Ϊ�ļ�
	 * @param url
	 * @return
	 */
	public static boolean isFileUrl(String url) {
		return isFileName(url.split("\\?")[0]);
	}
	
	/**
	 * У���ַ����Ƿ�Ϊ�ļ���
	 * @param fileName
	 * @return
	 */
	public static boolean isFileName(String fileName) {
		String regex = "^.{1,}[\\.][a-zA-Z0-9]{1,}$";
		return fileName.matches(regex);
	}
	
	/**
	 * У���ַ����Ƿ�Ϊָ�����͵��ļ���
	 * @param fileName
	 * @param extendType
	 * @return
	 */
	public static boolean isSpecifiedFileType(String fileName, String extendType){
        String regex = "^.+\\.(?i)(" + extendType + ")$";
		return fileName.matches(regex);
    }
}
