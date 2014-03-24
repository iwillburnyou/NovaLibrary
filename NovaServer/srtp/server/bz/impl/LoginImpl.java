package seu.server.bz.impl;

import java.sql.SQLException;
import java.util.Vector;

import seu.server.dao.DbHelper;
import k.MessageType;
import k.User;
/**
 * 服务器端登陆模块的功能函数
 * @author 刘宇晨
 */
public class LoginImpl implements MessageType{
	/**
	 * 按指定的sql语句获得一个用户实体类的信息
	 * @param ob
	 * 一条指定的sql语句
	 * @return User
	 * 用户实体类
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
	 * 注册的服务器端操作
	 * @throws SQLException
	 */
	public static void registerNew(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
	}
	/**
	 * 修改密码功能的服务器端操作
	 */
	public static void changePSD(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
	}

}
;