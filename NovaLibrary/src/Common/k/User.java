package k;

import java.io.Serializable;

/**
 * ѧ��ʵ���ඨ�壬��������ÿ����½�˺ŵı�Ҫ��Ϣ
 * setters and getters ��javadoc��ʡ���� ���Ǵ��ڵ�
 * @author ��һ��
 */


public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String cardNo; //һ��ͨ��Ҳ�ǵ�½�˻���
	String studentNo;//ѧ��
	String name;		
	String psd;	//����
	String role;// 'super' 'ѧ��' 'ʳ�ù���Ա' 'ѧ��ϵͳ����Ա' 'ͼ��ݹ���Ա' ѡ��ϵͳ����Ա �������Ա �̵�ϵͳ����Ա
	String accounts;//�˺����
	/**
	 * User��Ĺ��캯������˳���ʼ��User��ÿ�����ݳ�Ա
	 * 
	 * @author ��һ��
	 */
	public User(String str1,String str2,String str3,String str4,String str5){
		cardNo = str1;
		studentNo = str2;
		name = str3;
		psd = str4;
		role = str5;
	}
	/**
	 * User���Ĭ�Ϲ��캯��
	 * 
	 * 
	 */
	public User(){
		cardNo = "213100262";
		studentNo = "09011222";
		name = "ZWL";
		psd = "zwl";
		role = "ѧ��";
	}
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}





	



}


