package seu.Client.vo;

import java.io.Serializable;
/**
 *��Ʒ��Ϣ��ʵ����
 *@author ����΢ 
 */
public class ProductInfo implements Serializable{
	private static final long serialVersionUID = 1L;

	String Name;
	int Count;
	String Type;
	double Price;
	/**
	 * ��Ʒ��Ϣʵ�����Ĭ�Ϲ��캯��
	 */
	public ProductInfo(){
		
	}

/**
 * ��Ʒ��Ϣʵ������������г�Ա�ĺ���
 * @param type
 * ��Ʒ����
 * @param name
 * ��Ʒ����
 * @param price
 * ��Ʒ�۸�
 * @param count
 * �������
 */
	public  void ProsetAll(String type,String name,double price,int count) {
		this.Name = name;
		this.Count = count;
		this.Type = type;
		this.Price = price;

	}
	
	/**
	 * ��ȡ��ƷID
	 * 
	 * @return
	 * ��ƷID
	 * public String getId() {
		return Id;
	}

	 */
	
	/**
	 * ������ƷID
	 * 
	 * @param id
	 * ��ƷID
	 * public void setId(String id) {
		Id = id;
	}

	 */
	
	/**
	 * ��ȡ��Ʒ����
	 * 
	 * @return
	 * ��Ʒ����
	 */
	public String getName() {
		return Name;
	}

	/**
	 * ������Ʒ����
	 * 
	 * @param name
	 * ��Ʒ����
	 */
	public void setName(String name) {
		Name = name;
	}

	
	/**
	 * ��ȡ��Ʒ����
	 * 
	 * @return
	 * ��Ʒ����
	 */
	public int getCount() {
		return Count;
	}

	/**
	 * ������Ʒ����
	 * 
	 * @param count
	 * ��Ʒ����
	 */
	public void setCount(int count) {
		Count = count;
	}

	/**
	 * ��ȡ��Ʒ����
	 * 
	 * @return
	 * ��Ʒ����
	 */
	public String getType() {
		return Type;
	}

	/**
	 * ������Ʒ����
	 * 
	 * @param type
	 * ��Ʒ����
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * ��ȡ��Ʒ�۸�
	 * 
	 * @return
	 * ��Ʒ�۸�
	 */
	public double getPrice() {
		return Price;
	}

	/**
	 * ������Ʒ�۸�
	 * 
	 * @param price
	 * ��Ʒ�۸�
	 */
	public void setPrice(double price) {
		Price = price;
	}

}
