package seu.server.bz.impl;


import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import com.sun.org.apache.regexp.internal.recompile;


import seu.server.dao.DbHelper;
import k.MessageType;
import k.MyMessage;
import seu.server.dao.DbHelper;
import seu.Client.vo.*;
import sun.net.www.content.text.plain;

/**���������̵�ϵͳģ�鹦�ܺ�����
 * 
 * @author ����΢
 *
 */

	
public class ShopImpl {
    //�̵깺��ҳ����ز���
//�Ƿ���ڸ���Ʒ
	/**
	 * �̵�ϵͳ���ж���������Ʒ�Ƿ���ڵĺ���
	 * 
	 * @return boolean 
	 * �Ƿ����
	 * 
	 * @param str
	 * String ��ʾ��Ʒ���Ƶ��ַ���

	 */
	public static int  IsExist(String str){
		String sql = "select * from tblProductInfo where Name='"+str+"'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);
		if(vec.size()==0) return 0;
		else return 1;
		
	
	}
	// ����ѧϰ��Ʒ������ҳ��

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

		String sql = "select * from tblProductInfo where Type='ѧϰ��Ʒ'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);

		return vec;
	}

	// ����������Ʒ������ҳ��
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

		String sql = "select * from tblProductInfo where Type='������Ʒ'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);

		return vec;
	}

	// ����ʳƷ������ҳ��
	
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

		String sql = "select * from tblProductInfo where Type='ʳƷ'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);

		return vec;
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

		String sql = "select * from tblProductInfo ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);

		return vec;
	}

	// public Vector SearByName(String str,String type,String prilev){
	
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
		String sql = "select * from tblProductInfo where Name='" + str + "'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);
		return vec;
	}
	//���빺�ﳵ
	/**
	 * �̵�ϵͳ�м��빺�ﳵ�ĺ���
	 * 
	 * @return void 
	 * �޷���ֵ
	 * 
	 * @param str1
	 * ProductInfo ��ʾѡ����빺�ﳵ����Ʒ��Ϣ��ʵ����
	 

	 */
    public static void AddToCart(ProductInfo P) throws SQLException{
    	if(IsExistCart(P.getName())==true){
    		String sql1 = "update MyCart set Count=Count+"+P.getCount()+" where Name='"+P.getName()+"'";
    		DbHelper.executeUpdate(sql1);
		}
    	else{
    		String sql = "insert into MyCart (Type,Name,Price,Count) values ('"
    				+ P.getType() + "','" + P.getName() + "','" + P.getPrice() + "','" +P.getCount() + "')";
    		 DbHelper.executeUpdate(sql);
    	}
		
    	 
	}
	
	
	
    //���ﳵ��ز���
    //�Ƿ��Ѿ������ڹ��ﳵ��
    /**
	 * �̵�ϵͳ���жϼ��빺�ﳵ����Ʒ�Ƿ��Ѿ������ڹ��ﳵ�еĺ���
	 * 
	 * @return boolean 
	 * �Ƿ����
	 * 
	 * @param str
	 * String ��ʾ��Ʒ���Ƶ��ַ���

	 */
    public static  boolean  IsExistCart(String str){
		String sql = "select * from MyCart where Name='"+str+"'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);
		if(vec.size()==0) return false;
		else return true;
		
	
	}
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
		String sql = "select * from MyCart ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);
		return vec;
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
		String sql = "select * from PaidPro ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);
		return vec;
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
		
		String sql = "delete * from MyCart  where Name='"+str+"'";
		DbHelper.executeUpdate(sql);
		System.out.println(sql);
	}
    //ȷ�Ϲ���
    /**
   	 * �̵�ϵͳ��ȷ�Ϲ���ĺ���
   	 * 
   	 * @return String 
   	 *�����Ƿ񸶷ѳɹ����ַ���
   	 * 
   	 * @param P
   	 * ProductInfo ��ʾҪ������Ʒ����Ϣ��ʵ����
   	

   	 */
   public static String PayForBill(ProductInfo p) throws SQLException{
		//��Ʒ��Ϣ���޸Ŀ�� str4 int
	   String str ="1";
	    //�жϹ��������Ƿ���ڿ�� �ǵĻ�����
	    String sql = "select * from tblProductInfo where Count>="+p.getCount()+" and name='"+p.getName()+"'";
	    Vector vec=DbHelper.executeQuery(sql);
	    if(vec.size()==0){
	    	str="��治��";
	    //JOptionPane.showMessageDialog(null,"��Ʒ"+p.getName()+"��治�� ������޸ģ�","ȷ�ϸ���",JOptionPane.WARNING_MESSAGE);
	    }
	    
	    else {
	    	String sql1 = "update tblProductInfo set Count=Count-"+p.getCount()+" where Name='"+p.getName()+"'";
			DbHelper.executeUpdate(sql1);
			//JOptionPane.showMessageDialog(null, "��Ʒɾ���ɹ���");
			System.out.println(sql1);
			
			//ɾ�����ﳵ�� str2 ������ɾ��
			String sql2 = "delete * from MyCart  where Name='"+p.getName()+"'";
			DbHelper.executeUpdate(sql2);
			//JOptionPane.showMessageDialog(null, "��Ʒɾ���ɹ���");
			System.out.println(sql2);
			//���ѹ����Ʒ��
			
			String sql3 = "insert into PaidPro (Type,Name,Price,Count) values ('"
					+ p.getType() + "','" + p.getName() + "','" + p.getPrice() + "','" + p.getCount() + "')";
			DbHelper.executeUpdate(sql3);
			//JOptionPane.showMessageDialog(null, "��Ʒɾ���ɹ���");
			System.out.println(sql3);
		    String sql4 = "select * from MyCart ";
			Vector vec2=DbHelper.executeQuery(sql4);
		    if(vec2.size()==0){
		    	str="���ѳɹ�";
		    //JOptionPane.showMessageDialog(null,"��Ʒ"+p.getName()+"��治�� ������޸ģ�","ȷ�ϸ���",JOptionPane.WARNING_MESSAGE);
		    }
		
	
	    }
	    
	    System.out.println(str);
		return str;
		
	
		
		
	}
    
    
    
	//����Ա������ݿ����
	// �����������Ʒ���
   /**
	 * �̵�ϵͳ�з����������Ʒ���������Ա����ĺ���
	 * 
	 * @return Vector 
	 * ���ط�����������Ʒ��Ϣ
	 * 
	 * @param n
	 * String combobox�±� ����ѡ����ε��ַ���

	 */
	public static Vector Shkucun(String n) { // ���������Ŀ�����η�������������Աҳ��
		String sql = null;
		
		Vector vec = null;
		int i=Integer.parseInt(n);
		// sql = "select * from Test1 ORDER BY ID";
		// vec = DbHelper.executeQuery(sql);
		if (i == 0) {
			sql = "select * from tblProductInfo where Count<=50 ORDER BY ID";
			vec = DbHelper.executeQuery(sql);

		}

		else if (i == 1) {
			sql = "select * from tblProductInfo where Count>50 ORDER BY ID";
			vec = DbHelper.executeQuery(sql);

		} else if (i == 2) {
			sql = "select * from tblProductInfo  ORDER BY ID";
			vec = DbHelper.executeQuery(sql);

		}

		return vec;
	}

	// ��Ʒ�ϼ����
	 /**
   	 * �̵�ϵͳ��ȷ�Ϲ���ĺ���
   	 * 
   	 * @return void 
   	 *�޷���ֵ
   	 * 
   	 * @param P
   	 * ProductInfo ��ʾҪ�ϼ���Ʒ����Ϣ��ʵ����
   	

   	 */
	public static void AddPro(ProductInfo p)
			throws SQLException {

		// String sql="insert into Test1 values ('str1','str2','i1','i2')";
		String sql = "insert into tblProductInfo (Type,Name,Price,Count) values ('"
				+ p.getType() + "','" + p.getName() + "','" + p.getPrice() + "','" + p.getCount() + "')";
		System.out.println(sql);
		DbHelper.executeUpdate(sql);
	

	}

	// �޸Ŀ��
	/**
	 * �̵�ϵͳ���޸Ŀ��ĺ���
	 * 
	 * @return void 
	 * �޷���ֵ
	 * 
	 * 
   	 * @param P
   	 * ProductInfo ��ʾҪ�����޸ĵ���Ʒ����Ϣ��ʵ����
   	

	 */
	public static void ChangeCount(ProductInfo p) {

		
		
		String sql = "update tblProductInfo set Count="+p.getCount()+" where Name='"+p.getName()+"'";
	
		 
	DbHelper.executeUpdate(sql);
		System.out.println(sql);
		
	}

	// �޸ļ۸�
	/**
	 * �̵�ϵͳ���޸ļ۸�ĺ���
	 * 
	 * @return void 
	 * �޷���ֵ
	 * 
	 * 
   	 * @param P
   	 * ProductInfo ��ʾҪ�����޸ĵ���Ʒ����Ϣ��ʵ����
   	

	 */
	public static void ChangePrice(ProductInfo p) throws SQLException {

	
		// String
		// sql="update Test2 (Price) values ('"+i+"') where Name='"+str+"'";
		
		String sql = "update tblProductInfo set Price='" + p.getPrice() + "' where Name='"+p.getName()+"'";

		DbHelper.executeUpdate(sql);
		
		System.out.println(sql);
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
		
		String sql = "delete * from tblProductInfo  where Name='"+str+"'";
		DbHelper.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "��Ʒɾ���ɹ���");
		System.out.println(sql);
	}
}
