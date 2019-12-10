package cn.imtiger.saml.service;

import cn.imtiger.saml.entity.SAMLRequestBean;
import cn.imtiger.saml.entity.SAMLResponseBean;

/**
 * SAML2.0����
 * @author shen_hongtai
 * @date 2019-11-29
 */
public interface SAMLService {
	
	/**
	 * ����SAML������
	 * @param localDomain �ͻ��˵�ַ
	 * @param destination ����˵�¼��ַ
	 * @param assertionConsumerServiceURL �ͻ��˻ص���ַ
	 * @return
	 */
	public String buildSAMLRequest(String localDomain, String destination, String assertionConsumerServiceURL);
	
	/**
	 * ����SAML��Ӧ����
	 * @param requestId SAML����ID authnRequest.getID()
	 * @param userId ��¼�û�ID
	 * @param destination �ͻ��˻ص���ַ authnRequest.getAssertionConsumerServiceURL()
	 * @param audience authnRequest.getIssuer().getValue();
	 * @param localDomain ����˵�ַ
	 * @return
	 */
	public String buildSAMLResponse(String requestId, String userId, String destination, String audience, String localDomain);

	/**
	 * ����SAML������
	 * @param encodedRequest SAML������
	 * @return
	 */
	public SAMLRequestBean resolveSAMLRequest(String encodedRequest);
	
	/**
	 * ����SAML���ر���
	 * @param encodedResponse SAML���ر���
	 * @return
	 */
	public SAMLResponseBean resolveSAMLResponse(String encodedResponse) throws Exception;
}
