package seu.server.bz.impl;

import java.sql.SQLException;
import java.util.Vector;

import seu.server.dao.DbHelper;
import k.MessageType;
import k.User;
/**
 * �������˵�½ģ��Ĺ��ܺ���
 * @author ���
 */
public class LoginImpl implements MessageType{
	/**
	 * ��ָ����sql�����һ���û�ʵ�������Ϣ
	 * @param ob
	 * һ��ָ����sql���
	 * @return User
	 * �û�ʵ����
	 */
	public static User getMessage(String ob) {
		User tempUser = new User();
		Vector<Vector<String>> vVector = DbHelper.executeQuery(ob);
		Vector<String> vector =  vVector.firstElement();
		if(vector.size()>0){
			tempUser.setCardNo((String)vector.get(0));
			tempUser.setPsd((String)vector.get(1));
			tempUser.setStudentNo((String)vector.get(2));
			tempUser.setName((String)vector.get(3));
			tempUser.setRole((String)vector.get(4));	
			return tempUser;
		}
		else{
			return null;
		}
	}
	/**
	 * ע��ķ������˲���
	 * @throws SQLException
	 */
	public static void registerNew(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
	}
	/**
	 * �޸����빦�ܵķ������˲���
	 */
	public static void changePSD(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
	}

}
;