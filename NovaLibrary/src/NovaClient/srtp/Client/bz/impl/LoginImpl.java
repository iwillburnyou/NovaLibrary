package seu.Client.bz.impl;

import java.io.IOException;
import java.net.UnknownHostException;

import k.MyMessage;
import k.User;
/**
	 * 登陆界面
	 * @author 刘宇晨
	 */

public class LoginImpl extends CommonImpl{

	public LoginImpl() throws UnknownHostException, IOException {
		super();	
	}
/**
	 * 登陆界面显示登陆者身份函数
	 * 
	 * @return User 
	 * 返回用户身份
	 * 
	 * @param string
	 * String 一个表示用户身份的字符串
	 * 
	 */
	public static User getMessage(String string) {
		MyMessage mm = new MyMessage(k.MessageType.GET_MESSAGE, string);
		serverRe = sendMessage(mm);
		return (User)serverRe.getOb();
	}

/**
	 * 注册函数
	 * 
	 * @return void 
	 * 无返回值
	 * 
	 * @param sql
	 * String 信息插入数据库的sql语句
	 * 
	 */
	public static void registerNew(String sql) {
		MyMessage mm = new MyMessage(k.MessageType.REGISTER_NEW,sql);
		serverRe = sendMessage(mm);
	}
/**
	 * 修改密码函数
	 * 
	 * @return void 
	 * 无返回值
	 * 
	 * @param sql
	 * String 一个用于修改数据库中已有密码的sql语句
	 * 
	 */
	public static void changePsd(String sql) {
		MyMessage mm = new MyMessage(k.MessageType.CHANGE_PSD,sql);
		serverRe = sendMessage(mm);	
	}
	

}