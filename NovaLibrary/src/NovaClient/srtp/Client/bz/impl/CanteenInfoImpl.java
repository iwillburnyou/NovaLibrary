package seu.Client.bz.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.util.Vector;

import k.MessageType;
import k.MyMessage;
import seu.Client.util.SocketHelper;
/**
 * �ͻ��˲�������ģ��Ĺ��ܺ�����
 * @author ������
 * 
 */

public class CanteenInfoImpl extends CommonImpl{

	static MyMessage serverRe = null;  // ���������ص�message

	public CanteenInfoImpl() throws UnknownHostException, IOException {
		super();
	}
	
	/**
	 * �ͻ��˲�������ϵͳ����Ӳ�Ʒ�ĺ���
	 * 
	 * @param string 
	 * ������sql���
	 */
	
	public static void addDish(String sqlString) {
		MyMessage mm = new MyMessage(k.MessageType.ADD_DISH, sqlString);
		serverRe = sendMessage(mm);	
	}
	
	/**
	 * �ͻ��˲�������ϵͳ���޸Ĳ�Ʒ��Ϣ�ĺ���
	 * 
	 * @param string 
	 * ������sql���
	 */
	
	public static void changeDish(String sql) {
		MyMessage mm = new MyMessage(k.MessageType.CHANGE_DISH, sql);
		serverRe = sendMessage(mm);	
	}
	
	/**
	 * �ͻ��˲�������ϵͳ��ɾ����Ʒ�ĺ���
	 * 
	 * @param string 
	 * ������sql���
	 */
	
	public static void delDish(String string) {
		MyMessage mm = new MyMessage(k.MessageType.DEL_DISH, string);
		serverRe = sendMessage(mm);	
	}

	/**
	 * �ͻ��˲�������ϵͳ�л�ò�Ʒ��Ϣ�ĺ���
	 * 
	 * @return Vector<Vector<String>>
	 * ��Ʒ��Ϣ��Vector�洢
	 * 
	 * @param sqlString 
	 * ������sql���
	 */
	
	public static Vector<Vector<String>> getDish(String sqlString) {
		Vector vector = new Vector();
		MyMessage mm = new MyMessage(k.MessageType.GET_DISH, sqlString);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();	
	}

	/**
	 * �ͻ��˲�������ϵͳ�ж��������ĺ���
	 * 
	 * @param sqlString 
	 * ������sql���
	 */
	
	public static void addDishBuy(String sqlString) {
		MyMessage mm = new MyMessage(k.MessageType.ADD_DISHBUY, sqlString);
		serverRe = sendMessage(mm);	
	}
	
	/**
	 * �ͻ��˲�������ϵͳ�г������������ĺ���
	 * 
	 * @param sqlString 
	 * ������sql���
	 */
	
	public static void delDishBuy(String sqlString) {
		MyMessage mm = new MyMessage(k.MessageType.DEL_DISHBUY, sqlString);
		serverRe = sendMessage(mm);	
		
	}

	/**
	 * �ͻ��˲�������ϵͳ��ɾ��������Ϣ�ĺ���
	 * 
	 * @param string 
	 * ������sql���
	 */
	
	public static void delTakeAway(String string) {
		MyMessage mm = new MyMessage(k.MessageType.DEL_TAKEAWAY, string);
		serverRe = sendMessage(mm);	
	}

	/**
	 * �ͻ��˲�������ϵͳ�л������������Ϣ�ĺ���
	 * 
	 * @return Vector<Vector<String>>
	 * ����������Ϣ��Vector�洢
	 * 
	 * @param string 
	 * ������sql���
	 */

	public static Vector<Vector<String>> getAllDishBuy(String string) {
		
		Vector vector = new Vector();
		MyMessage mm = new MyMessage(k.MessageType.GET_ALLDISHBUY,string);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();	
	}
	
	/**
	 * �ͻ��˲�������ϵͳ�иı���������״̬�ĺ���
	 * 
	 * @param string 
	 * ������sql���
	 */
	
	public static void changeIfSend(String sql) {
		MyMessage mm = new MyMessage(k.MessageType.CHANGE_IFSEND, sql);
		serverRe = sendMessage(mm);	
		
	}

	/**
	 * �ͻ��˲�������ϵͳ����ӽ���ĺ���
	 * 
	 * @return String
	 * ������ʵ��״̬
	 * 
	 * @param sqlString 
	 * ������sql���
	 */
	
	public static String addAdvice(String sqlString) {
		MyMessage mm = new MyMessage(k.MessageType.ADD_ADVICE, sqlString);
		serverRe = sendMessage(mm);
		return (String)serverRe.getOb();
	}
	/**
	 * �ͻ��˲�������ϵͳ�иı佨���Ķ�״̬�ĺ���
	 * 
	 * @param string 
	 * ������sql���
	 */
	
	public static void changeRead(String string) {
		MyMessage mm = new MyMessage(k.MessageType.CHANGE_READ, string);
		serverRe = sendMessage(mm);	
		
	}
	

	/**
	 * �ͻ��˲�������ϵͳ��ɾ������ĺ���
	 * 
	 * @param string 
	 * ������sql���
	 */
	
	public static void delAdvice(String string) {
		MyMessage mm = new MyMessage(k.MessageType.DEL_ADVICE, string);
		serverRe = sendMessage(mm);	
		
		
	}
	/**
	 * �ͻ��˲�������ϵͳ�л�ý�����Ϣ�ĺ���
	 * 
	 * @return Vector<Vector<String>>
	 * ������Ϣ��Vector�洢
	 * 
	 * @param sql
	 * ������sql���
	 */
	
	public static Vector<Vector<String>> getAdvice(String sql) {
		Vector vector = new Vector();
		MyMessage mm = new MyMessage(k.MessageType.GET_ADVICE,sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	


	
}
