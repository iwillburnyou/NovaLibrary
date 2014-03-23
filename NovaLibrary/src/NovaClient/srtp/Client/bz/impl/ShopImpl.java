package seu.Client.bz.impl;


import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import seu.Client.vo.*;

import k.*;

import seu.Client.util.SocketHelper;
//import seu.server.dao.DbHelper;
import seu.Client.vo.*;
/**�ͻ����̵�ϵͳģ�鹦�ܺ�����
 * 
 * @author ����΢
 *
 */

public class ShopImpl extends CommonImpl{
	public ShopImpl() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	static MyMessage serverRe = null; // ���������ص�message
	/**
	 * �̵�ϵͳ���ж���������Ʒ�Ƿ���ڵĺ���
	 * 
	 * @return boolean 
	 * �Ƿ����
	 * 
	 * @param str
	 * String ��ʾ��Ʒ���Ƶ��ַ���

	 */
	public  boolean  IsExist(String str){
		MyMessage mm = new MyMessage(MessageType.IS_EXIST,
				str);
		serverRe = sendMessage(mm);
		int i= (Integer) serverRe.getOb();
		System.out.println(i + "hehe");
		if (i==1){
			return true;
		}
		else{
			return false;
		}
		}
	
	
    //�̵깺��ҳ����ز���

	/**
	 * �̵�ϵͳ�з���ѧϰ��Ʒ������ҳ��ĺ���
	 * 
	 * @return Vector 
	 * ���ط�����������Ʒ��Ϣ
	 * 
	 * @param str
     * String ���ַ���

	 */

	public static Vector ShStudyPro(String str) {
		MyMessage mm = new MyMessage(MessageType.INQUIRY_STUDY_PRO,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
	}


	/**
	 * �̵�ϵͳ�з���������Ʒ������ҳ��ĺ���
	 * 
	 * @return Vector 
	 * ���ط�����������Ʒ��Ϣ
	 * 
	 * @param str
	 * String ���ַ���

	 */

	public static Vector ShLifePro(String str) {

		MyMessage mm = new MyMessage(MessageType.INQUIRY_LIFE_PRO,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
	}

	
	/**
	 * �̵�ϵͳ�з���ʳƷ������ҳ��ĺ���
	 * 
	 * @return Vector 
	 * ���ط�����������Ʒ��Ϣ
	 * 
	 * @param str
	 * String ���ַ���

	 */
	public static Vector ShFoodPro(String str) {

		MyMessage mm = new MyMessage(MessageType.INQUIRY_FOOD_PRO,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
	}

	// ����ȫ��������ҳ��
	/**
	 * �̵�ϵͳ�з���ȫ��������ҳ��ĺ���
	 * 
	 * @return Vector 
	 * ���ط�����������Ʒ��Ϣ
	 * 
	 * @param str
	 * String ���ַ���

	 */
	public static Vector ShAllPro(String str) {

		MyMessage mm = new MyMessage(MessageType.INQUIRY_ALL_PRO,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
	}


	
	// ��������Ʒ������ɵľ�ȷ����������ҳ��
	/**
	 * �̵�ϵͳ�з�������Ʒ������ɵľ�ȷ����������ҳ��ĺ���
	 * 
	 * @return Vector 
	 * ���ط�����������Ʒ��Ϣ
	 * 
	 * @param str
	 * String ���ֱ�ʾ��Ʒ���Ƶķ���

	 */

	public static Vector SearByName(String str) {
		MyMessage mm = new MyMessage(MessageType.INQUIRY_GOODS_BY_NAME,
				str);
		serverRe = sendMessage(mm);
		return (Vector) serverRe.getOb();
	}
	
	//���빺�ﳵ
	/**
	 * �̵�ϵͳ�м��빺�ﳵ�ĺ���
	 * 
	 * @return void 
	 * �޷���ֵ
	 * 
	 * @param str1
	 * String ��ʾ��Ʒ�����ַ���
	 * @param str2
	 * String ��ʾ��Ʒ���Ƶ��ַ���
	 * @param i1
	 * double ��ʾ��Ʒ�۸�
	 * @param i2
	 * int ��ʾ������Ʒ����
	 * 

	 */
    public static void AddToCart(String str1,String str2,double i1,int i2 ) throws SQLException{
    	ProductInfo p = new ProductInfo();
        p.ProsetAll(str1,str2, i1,i2);
        MyMessage mm = new MyMessage(MessageType.RESERVE_GOODS,
				p);
		serverRe = sendMessage(mm);
		System.out.println(serverRe.getOb());
		
	}
	
	
	
    //���ﳵ��ز���
    //�Ƿ��Ѿ������ڹ��ﳵ��
    /*
    public static  boolean  IsExistCart(String str){
    	MyMessage mm = new MyMessage(MessageType.INQUIRY_STUDY_PRO,str);
		serverRe = sendMessage(mm);
		Vector vector=(Vector) serverRe.getOb();
		
		if(vector.size()==0) return false;
		else  return true;
	
	}
    */
	// ���ع��ﳵ�������������ﳵҳ��
    /**
	 * �̵�ϵͳ�з��ع��ﳵ�������������ﳵҳ��ĺ���
	 * 
	 * @return Vector 
	 * ���ط�����������Ʒ��Ϣ
	 * 
	 * @param str
	 * String ���ֱ�ʾ��Ʒ���Ƶķ���

	 */
	public static Vector ShCart(String str) {
		MyMessage mm = new MyMessage(MessageType.PERSON_RESERVE_RECORD,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
	}

	// �����ѹ�����Ʒ�������������ﳵҳ��
	 /**
		 * �̵�ϵͳ�з����ѹ�����Ʒ�������������ﳵҳ��ĺ���
		 * 
		 * @return Vector 
		 * ���ط�����������Ʒ��Ϣ
		 * 
		 * @param str
		 * String ���ֱ�ʾ��Ʒ���Ƶķ���

		 */
	public static Vector ShPaidPro(String str) {
		MyMessage mm = new MyMessage(MessageType.SHOW_PAID_PRO,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
	}
	//ɾ�����ﳵ�в��빺��Ĳ�Ʒ
	 /**
	 * �̵�ϵͳ��ɾ�����ﳵ�в��빺��Ĳ�Ʒ�ĺ���
	 * 
	 * @return void
	 *�޷���ֵ
	 * 
	 * @param str
	 * String ���ֱ�ʾ��Ʒ���Ƶķ���

	 */
    public static void DelCartPro(String str) throws SQLException{
		
    	MyMessage mm = new MyMessage(MessageType.DISRESERVE_GOODS,str);
		serverRe = sendMessage(mm);
		
		
	}
    //ȷ�Ϲ���
    /**
	 * �̵�ϵͳ��ȷ�Ϲ���ĺ���
	 * 
	 * @return String 
	 *�����Ƿ񸶷ѳɹ����ַ���
	 * 
	 * @param str1
	 * String ��ʾ��Ʒ�����ַ���
	 * @param str2
	 * String ��ʾ��Ʒ���Ƶ��ַ���
	 * @param str3
	 * String ��ʾ��Ʒ�۸�
	 * @param str4
	 * String ��ʾ������Ʒ����
	 * 

	 */
   public String PayForBill(String str1,String str2,String str3,String str4) {
		//��Ʒ��Ϣ���޸Ŀ�� str4 int
	   
	   double i1=Double.parseDouble(str3);
	    int i2=Integer.parseInt(str4);
	    ProductInfo p = new ProductInfo();
        p.ProsetAll(str1,str2, i1,i2);
        MyMessage mm = new MyMessage(MessageType.PAY_FOR_BILL,p);
		serverRe = sendMessage(mm);
	
		String i= (String) serverRe.getOb();
		System.out.println(i);
		return i;
	
	}
    
    
    
	//����Ա������ݿ����
	// �����������Ʒ���
   /**
	 * �̵�ϵͳ�з����������Ʒ���������Ա����ĺ���
	 * 
	 * @return Vector 
	 * ���ط�����������Ʒ��Ϣ
	 * 
	 * @param i
	 * String combobox�±� ����ѡ����ε��ַ���

	 */
	public static Vector Shkucun(String i) { // ���������Ŀ�����η�������������Աҳ��
		MyMessage mm = new MyMessage(MessageType.ADM_GET_COUNTS,i);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
	}
	
	// ��Ʒ�ϼ����
	/**
	 * �̵�ϵͳ����Ʒ�ϼ����ĺ���
	 * 
	 * @return void 
	 * �޷���ֵ
	 * 
	 * @param str1
	 * String ��ʾ��Ʒ�����ַ���
	 * @param str2
	 * String ��ʾ��Ʒ���Ƶ��ַ���
	 * @param i1
	 * double ��ʾ��Ʒ�۸�
	 * @param i2
	 * int ��ʾ������Ʒ����
	 * 

	 */
	public static  void AddPro(String str1, String str2, double i1, int i2)
			throws SQLException {
		ProductInfo p = new ProductInfo();
        p.ProsetAll(str1,str2, i1,i2);
        MyMessage mm = new MyMessage(MessageType.ADM_ADD_GOODS,p);
		serverRe = sendMessage(mm);
		

	}

	// �޸Ŀ��
	/**
	 * �̵�ϵͳ���޸Ŀ��ĺ���
	 * 
	 * @return void 
	 * �޷���ֵ
	 * 
	 * @param str
	 * String ��ʾ��Ʒ���Ƶ��ַ���
	 * 
	 * @param i1
	 * String ��ʾ���������������
	
	 * 

	 */
	public static void ChangeCount(String str, String i) {

		int n = Integer.parseInt(i);
		String str1=null;
		double i1=0;
		ProductInfo p = new ProductInfo();
        p.ProsetAll(str1,str, i1,n);
        MyMessage mm = new MyMessage(MessageType.ADM_MODIFY_COUNT,p);
		serverRe = sendMessage(mm);
	}

	// �޸ļ۸�
	/**
	 * �̵�ϵͳ���޸ļ۸�ĺ���
	 * 
	 * @return void 
	 * �޷���ֵ
	 * 
	 * @param str
	 * String ��ʾ��Ʒ���Ƶ��ַ���
	 * 
	 * @param i1
	 * String ��ʾ�۸��޸���������
	
	 * 

	 */


	public static void ChangePrice(String str, String i) throws SQLException {

		double n = Double.parseDouble(i);

		String str1=null;
		int i1=0;
		ProductInfo p = new ProductInfo();
        p.ProsetAll(str1,str, n ,i1);
        MyMessage mm = new MyMessage(MessageType.ADM_MODIFY_PRICE,p);
		serverRe = sendMessage(mm);
		
	}
	//��Ʒ�¼�
	/**
	 * �̵�ϵͳ���޸ļ۸�ĺ���
	 * 
	 * @return void 
	 * �޷���ֵ
	 * 
	 * @param str
	 * String ��ʾ��Ʒ���Ƶ��ַ���
	 * 

	
	 * 

	 */


	public static void DelPro(String str) throws SQLException{
		MyMessage mm = new MyMessage(MessageType.ADM_DELETE_GOODS,str);
		serverRe = sendMessage(mm);
		

		
		
	}
	
}
