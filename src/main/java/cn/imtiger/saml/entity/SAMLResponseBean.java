package cn.imtiger.saml.entity;

import java.util.Date;

import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.AuthnStatement;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.SubjectConfirmation;

import com.alibaba.fastjson.JSON;

/**
 * SAML2.0��Ӧ�����������
 * @author shen_hongtai
 * @date 2019-12-5
 */
public class SAMLResponseBean {
	String id;
	String inResponseTo;
	String assertionId;
	String userId;
	Date issueInstant;
	Date notOnOrAfter;

	public SAMLResponseBean(Response response) {
		Assertion assertion = response.getAssertions().get(0);
		AuthnStatement authnStatement = assertion.getAuthnStatements().get(0);
		SubjectConfirmation subjectConfirmation = assertion.getSubject()
				.getSubjectConfirmations().get(0);

		this.id = response.getID();
		this.inResponseTo = response.getInResponseTo();
		this.assertionId = assertion.getID();
		this.userId = assertion.getSubject().getNameID().getValue();
		this.issueInstant = new Date(authnStatement.getAuthnInstant()
				.getMillis());
		this.notOnOrAfter = new Date(subjectConfirmation
				.getSubjectConfirmationData().getNotOnOrAfter().getMillis());
	}

	/**
	 * ��ȡSAML����ID
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * ��ȡ���ص�ַ
	 * @return
	 */
	public String getInResponseTo() {
		return inResponseTo;
	}

	/**
	 * ��ȡ����ID
	 * @return
	 */
	public String getAssertionId() {
		return assertionId;
	}

	/**
	 * ��ȡ��¼�û�ID
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ��ȡSAML��Ӧʱ��
	 * @return
	 */
	public Date getIssueInstant() {
		return issueInstant;
	}

	/**
	 * ��ȡSAML��Ӧ����ʱ��
	 * @return
	 */
	public Date getNotOnOrAfter() {
		return notOnOrAfter;
	}

	@Override
	public String toString() {
		return "[SAMLResponseInfo]" + JSON.toJSONString(this);
	}

}
