package seu.server.bz.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.sun.org.apache.regexp.internal.recompile;

import seu.Client.vo.StudentInfo;
import seu.server.dao.DbHelper;
import k.MessageType;
import k.MyMessage;
/**
 * �������˲�������ģ��Ĺ��ܺ�����
 * @author ������
 * 
 */
public class CanteenInfoImpl implements MessageType{
	
	/**
	 * �������˲�������ϵͳ��Ӳ�Ʒ�ĺ���
	 * 
	 * @param ob 
	 * ������sql���
	 */
	public static void addDish(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);	
		
	}
	
	/**
	 * �������˲�������ϵͳɾ����Ʒ�ĺ���
	 * 
	 * @param ob 
	 * ������sql���
	 */
	
	public static void delDish(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}
	
	/**
	 * �������˲�������ϵͳ�ı��Ʒ��Ϣ�ĺ���
	 * 
	 * @param ob 
	 * ������sql���
	 */
	public static void changeDish(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);	
		
	}

	/**
	 * �������˲�������ϵͳ�л�ò�Ʒ��Ϣ�ĺ���
	 * 
	 * @return Vector 
	 * ��Ʒ��Ϣ��Vector
	 * 
	 * @param ob 
	 * ������sql���
	 */
	public static Vector getDish(String ob) {
		return DbHelper.executeQuery(ob);	
	}
	
	/**
	 * �������˲�������ϵͳ���������ĺ���
	 * 
	 * @param ob 
	 * ������sql���
	 */
	public static void addDishBuy(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}
	
	/**
	 * �������˲�������ϵͳ�������������ĺ���
	 * 
	 * @param ob 
	 * ������sql���
	 */
	public static void delDishBuy(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}

	/**
	 * �������˲�������ϵͳ�л������������Ϣ�ĺ���
	 * 
	 * @return Object 
	 * ����������Ϣ
	 * 
	 * @param ob 
	 * ������sql���
	 */
	public static Object getAllDishBuy(String ob) {
		return DbHelper.executeQuery(ob);
	}
	/**
	 * �������˲�������ϵͳ�ı���������״̬�ĺ���
	 * 
	 * @param ob 
	 * ������sql���
	 */
	public static void changeIfSend(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);	
		
	}
	/**
	 * �������˲�������ϵͳɾ��������Ϣ�ĺ���
	 * 
	 * @param ob 
	 * ������sql���
	 */
	public static void delTakeAway(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}
	/**
	 * �������˲�������ϵͳ��ӽ���ĺ���
	 * 
	 * @param ob 
	 * ������sql���
	 */
    public static void addAdvice(String ob) throws SQLException {
		
		DbHelper.executeUpdate(ob);	
	}

	/**
	 * �������˲�������ϵͳ�л�ý�����Ϣ�ĺ���
	 * 
	 * @return Object 
	 * ������Ϣ
	 * 
	 * @param ob 
	 * ������sql���
	 */
	public static Object getAdvice(String ob) {
		return DbHelper.executeQuery(ob);
	}
	
	/**
	 * �������˲�������ϵͳ�ı佨���Ķ�״̬�ĺ���
	 * 
	 * @param ob 
	 * ������sql���
	 */
	
	public static void changeRead(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);	
	}
	
	/**
	 * �������˲�������ϵͳɾ������ĺ���
	 * 
	 * @param ob 
	 * ������sql���
	 */
	public static void delAdvice(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
	}

}
