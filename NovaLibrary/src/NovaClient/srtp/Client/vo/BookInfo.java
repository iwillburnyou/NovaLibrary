package seu.Client.vo;

import java.io.Serializable;

/**
 * @��װ�鼮��Ϣ��ʵ����
 * @author ����
 */
public class BookInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String BookNo;
	public String Name;
	public String Publiser;
	public String Writer;
	public String Price;
	public String Indate;
	public String BookType;
	/**
	 * ����һ���鼮��Ϣʵ�����ȫ����Ա
	 * @param bookNo
	 * �鼮�ı��
	 * @param name
	 * �鼮����
	 * @param Publiser
	 * ������
	 * @param Writer
	 * ����
	 * @param Price
	 * ��Ǯ
	 * @param Indate
	 * �������
	 * @param BookType
	 * �鼮����
	 */
	public void setAll(String bookNo,String name,String Publiser , String Writer, String Price ,String Indate ,String BookType){
		this.BookNo = bookNo;
		this.Name = name;
		this.Publiser =Publiser ;
		this.Writer =Writer;
		this.Price = Price;
		this.Indate = Indate;
		this.BookType = BookType;
		
	}
	
	
//	ѧ��", "Two" }, { "����", "Four" }, { "�Ա�", "Four" }, { "�꼶", "Four" }
//	, { "Ժϵ", "Four" }, { "רҵ", "Four" }, { "���֤��", "Four" }

}

