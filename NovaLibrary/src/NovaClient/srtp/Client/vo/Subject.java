package seu.Client.vo;

import java.io.Serializable;
/**
 * ѧ����Ϣ��ʵ����
 * @author ����¶
 *
 */
public class Subject implements Serializable{
	private static final long serialVersionUID = 1L;
	String Id;    //�γ�ID
	String Name;   //�γ�����
	String Teacher;   //�ο���ʦ
	String Num;       //��ʱ
	String Credit;   //ѧ��
	String Type;     //�γ�����
	/**
	 * ѧ����Ϣʵ����Ĺ��캯��
	 * @param s0
	 * �γ̴���
	 * @param s1
	 * �γ�����
	 * @param s2
	 * �ڿ���ʦ
	 * @param s3
	 * �γ̱��
	 * @param s4
	 * ѧ����
	 * @param s5
	 * �γ�����
	 */

	public Subject(String s0, String s1, String s2, String s3, String s4,
			String s5) {
		// TODO Auto-generated constructor stub
		Id=s0;
		Name=s1;
		Teacher=s2;
		Num=s3;
		Credit=s4;
		Type=s5;
		
	}



	/**
	 * ��ȡ�γ�ID
	 * 
	 * @return
	 * �γ�ID
	 */
	public String getId() {
		return Id;
	}
	
	/**
	 * ���ÿγ�ID
	 * 
	 * @param id
	 * �γ���ID
	 */
	public void setId(String id) {
		Id = id;
	}
	
	/**
	 * ��ȡ�γ�����
	 * 
	 * @return
	 * �γ�����
	 */
	public String getName() {
		return Name;
	}
	
	/**
	 * ���ÿγ�����
	 * 
	 * @param name
	 * �γ�����
	 */
	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * ��ȡ��ʦ
	 * 
	 * @return
	 * ��ʦ
	 */
	public String getTeacher() {
		return Teacher;
	}
	
	/**
	 * ������ʦ����
	 * 
	 * @param teacher
	 * ��ʦ����
	 */
	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
	
	/**
	 * ��ȡ��ʱ
	 * 
	 * @return
	 * ��ʱ
	 */
	public String getNum() {
		return Num;
	}
	
	/**
	 * ���ÿ�ʱ
	 * 
	 * @param num
	 * ��ʱ
	 */
	public void setNum(String num) {
		Num = num;
	}
	
	/**
	 * ��ȡѧ��
	 * 
	 * @return
	 * ѧ��
	 */
	public String getCredit() {
		return Credit;
	}
	
	/**
	 * ����ѧ��
	 * 
	 * @param credit
	 * ѧ��
	 */
	public void setCredit(String credit) {
		Credit = credit;
	}
	
	/**
	 * ��ȡ�γ�����
	 * 
	 * @return
	 * �γ�����
	 */
	public String getType() {
		return Type;
	}
	
	/**
	 * ���ÿγ�����
	 * 
	 * @param type
	 * �γ�����
	 */
	public void setType(String type) {
		Type = type;
	}

}
