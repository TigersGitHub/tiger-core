package cn.imtiger.saml.entity;

import org.opensaml.saml2.core.AuthnRequest;

import com.alibaba.fastjson.JSON;

/**
 * SAML2.0��������������
 * @author shen_hongtai
 * @date 2019-12-5
 */
public class SAMLRequestBean {
	String id;
	String version;
	String provider;
	String destination;
	String audience;

	public SAMLRequestBean(AuthnRequest authnRequest) {
		this.id = authnRequest.getID();
		this.version = authnRequest.getVersion().toString();
		this.provider = authnRequest.getProviderName();
		this.destination = authnRequest.getAssertionConsumerServiceURL();
		this.audience = authnRequest.getIssuer().getValue();
	}

	/**
	 * ��ȡSAML����ID
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * ��ȡSAML����汾
	 * @return
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * ��ȡ��¼�����ṩ������
	 * @return
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * ��ȡ�ͻ��˻ص���ַ
	 * @return
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * ��ȡ�ͻ�������
	 * @return
	 */
	public String getAudience() {
		return audience;
	}

	@Override
	public String toString() {
		return "[SAMLRequestInfo]" + JSON.toJSONString(this);
	}

}
