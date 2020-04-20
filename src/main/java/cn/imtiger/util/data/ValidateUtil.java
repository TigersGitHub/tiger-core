package cn.imtiger.util.data;

/**
 * 校验工具类
 * @author ShenHongtai
 * @date 2020-4-20
 */
public class ValidateUtil {

	/**
	 * 校验小时数是否合法
	 * @param value
	 * @return
	 */
	public static boolean isValidHour(String value) {
		if (isNumeric(value)) {
			return isValidHour(Integer.parseInt(value));
		}
		return false;
	}

	/**
	 * 校验小时数是否合法
	 * @param value
	 * @return
	 */
	public static boolean isValidHour(int value) {
		return value >= 0 && value <= 23;
	}
	
	/**
	 * 校验分钟数是否合法
	 * @param value
	 * @return
	 */
	public static boolean isValidMinute(int value) {
		return isValidSecond(value);
	}

	/**
	 * 校验分钟数是否合法
	 * @param value
	 * @return
	 */
	public static boolean isValidMinute(String value) {
		return isValidSecond(value);
	}

	/**
	 * 校验秒数是否合法
	 * @param value
	 * @return
	 */
	public static boolean isValidSecond(String value) {
		if (isNumeric(value)) {
			return isValidSecond(Integer.parseInt(value));
		}
		return false;
	}

	/**
	 * 校验秒数是否合法
	 * @param value
	 * @return
	 */
	public static boolean isValidSecond(int value) {
		return value >= 0 && value <= 59;
	}
	
    /**
     * 校验字符串不为空
     * @param value
     * @return
     */
    public static boolean isNotNull(String value) {
        return !isNull(value);
    }

    /**
     * 校验字符串为空
     * @param value
     * @return
     */
    public static boolean isNull(String value) {
        return value == null || "".equals(value);
    }
    
    /**
     * 校验数组不为空
     * @param value
     * @return
     */
    public static boolean isNotNull(Object[] value) {
    	return !isNull(value);
    }
        
    /**
     * 校验数组为空
     * @param value
     * @return
     */
    public static boolean isNull(Object[] value) {
    	return value == null || value.length == 0;
    }
    
    /**
     * 校验字符串非空白
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
    
	/**
	 * 校验字符串为空白
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
	 * 校验字符串是否为纯字母
	 * @param str
	 * @return
	 */
	public static boolean isLetter(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return false;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isLetter(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
	
	/**
	 * 校验字符串是否为纯字母
	 * @param str
	 * @return
	 */
	public static boolean isLetter(String[] str) {
		for (int i = 0; i < str.length; i++) {
			if (!isLetter(str[i])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 校验字符串是否为纯数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return false;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isDigit(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
	
	/**
	 * 校验字符串是否为纯数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String[] str) {
		for (int i = 0; i < str.length; i++) {
			if (!isNumeric(str[i])) {
				return false;
			}
		}
		return true;
	}

    /**
     * 校验字符串是否为邮箱格式
     * @param email
     * @return
     */
	public static boolean isEmail(String email) {
		String regex = "^[A-Za-z0-9_.]{1,}[@][A-Za-z0-9]{1,}([.][A-Za-z0-9]{1,}){1,2}$";
		return email.matches(regex);
	}
    
    /**
     * 校验字符串是否为手机号码格式
     * @param mobile
     * @return
     */
	public static boolean isMobile(String mobile) {
		String regex = "^[1][0-9]{10}$";
		return mobile.matches(regex);
	}
	
	/**
	 * 校验字符串是否为IPv4地址格式
	 * @param ip
	 * @return
	 */
	public static boolean isIPv4(String ip) {
		String regex = "^(((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))$";
		return ip.matches(regex);
	}
	
	/**
	 * 校验地址是否为文件
	 * @param url
	 * @return
	 */
	public static boolean isFileUrl(String url) {
		return isFileName(url.split("\\?")[0]);
	}
	
	/**
	 * 校验字符串是否为文件名
	 * @param fileName
	 * @return
	 */
	public static boolean isFileName(String fileName) {
		String regex = "^.{1,}[\\.][a-zA-Z0-9]{1,}$";
		return fileName.matches(regex);
	}
	
	/**
	 * 校验字符串是否为指定类型的文件名
	 * @param fileName
	 * @param extendType
	 * @return
	 */
	public static boolean isSpecifiedFileType(String fileName, String extendType){
        String regex = "^.+\\.(?i)(" + extendType + ")$";
		return fileName.matches(regex);
    }
}
