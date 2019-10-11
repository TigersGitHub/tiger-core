package cn.imtiger.util.net;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import cn.imtiger.util.data.ValidateUtil;

/**
 * �����ʼ�������
 * @author ShenHongtai
 * @date 2019-7-13
 */
public class EmailUtil {
	/**
	 * ��������
	 */
	public static final Object[] PROVIDER_163 = { "smtp.163.com", 465 };
	
	/**
	 * ����������Ϣ�ʼ�
	 * @param provider
	 * @param senderName
	 * @param senderAddress
	 * @param senderPassword
	 * @param acceptorAddress
	 * @param copyAddress
	 * @param title
	 * @param message
	 * @throws Exception
	 */
	public static void send(Object[] provider, String senderName, String senderAddress, String senderPassword,
			String[] acceptorAddress, String[] copyAddress, String title, String message) throws Exception {
		if (provider == null || ValidateUtil.isNull((String) provider[0]) || ValidateUtil.isNull(provider[1] + "")) {
			throw new Exception("�����ʼ������̲���Ϊ��");
		}

		if (ValidateUtil.isNull(senderAddress) || ValidateUtil.isNull(senderPassword)) {
			throw new Exception("��������Ϣ����Ϊ��");
		}
		
		if (ValidateUtil.isNull(acceptorAddress)) {
			throw new Exception("�ռ��˲���Ϊ��");
		}
		
		if (ValidateUtil.isNull(title)) {
			throw new Exception("���ⲻ��Ϊ��");
		}
		
		if (ValidateUtil.isNull(message)) {
			throw new Exception("�ʼ����ݲ���Ϊ��");
		}

		try {
			Email email = new SimpleEmail();
			email.setHostName((String) provider[0]);
			email.setSmtpPort((Integer) provider[1]);
			email.setAuthenticator(new DefaultAuthenticator(senderAddress, senderPassword));
			email.setSSLOnConnect(true);
			email.setFrom(senderAddress, senderName);
			email.setSubject(title);
			email.setMsg(message);
			if (acceptorAddress != null) {
				for (String string : acceptorAddress) {
					email.addTo(string, string);
				}
			}
			if (copyAddress != null) {
				for (String string : copyAddress) {
					email.addCc(string);
				}
			}
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
			throw new Exception("�ʼ�����ʧ�ܣ�" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		String title = "A simple mail";
		String message = "Welcome to my company, and I wish you have a good time.";
		try {
			send(PROVIDER_163, "TigerSoftSystem", "443122163@163.com", "shen9211025",
					new String[] { "15853107903@163.com" }, null, title, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
