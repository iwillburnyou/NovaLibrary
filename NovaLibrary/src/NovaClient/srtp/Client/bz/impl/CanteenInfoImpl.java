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
 * 客户端餐厅管理模块的功能函数类
 * @author 张雅淋
 * 
 */

public class CanteenInfoImpl extends CommonImpl{

	static MyMessage serverRe = null;  // 服务器返回的message

	public CanteenInfoImpl() throws UnknownHostException, IOException {
		super();
	}
	
	/**
	 * 客户端餐厅管理系统中添加菜品的函数
	 * 
	 * @param string 
	 * 操作的sql语句
	 */
	
	public static void addDish(String sqlString) {
		MyMessage mm = new MyMessage(k.MessageType.ADD_DISH, sqlString);
		serverRe = sendMessage(mm);	
	}
	
	/**
	 * 客户端餐厅管理系统中修改菜品信息的函数
	 * 
	 * @param string 
	 * 操作的sql语句
	 */
	
	public static void changeDish(String sql) {
		MyMessage mm = new MyMessage(k.MessageType.CHANGE_DISH, sql);
		serverRe = sendMessage(mm);	
	}
	
	/**
	 * 客户端餐厅管理系统中删除菜品的函数
	 * 
	 * @param string 
	 * 操作的sql语句
	 */
	
	public static void delDish(String string) {
		MyMessage mm = new MyMessage(k.MessageType.DEL_DISH, string);
		serverRe = sendMessage(mm);	
	}

	/**
	 * 客户端餐厅管理系统中获得菜品信息的函数
	 * 
	 * @return Vector<Vector<String>>
	 * 菜品信息的Vector存储
	 * 
	 * @param sqlString 
	 * 操作的sql语句
	 */
	
	public static Vector<Vector<String>> getDish(String sqlString) {
		Vector vector = new Vector();
		MyMessage mm = new MyMessage(k.MessageType.GET_DISH, sqlString);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();	
	}

	/**
	 * 客户端餐厅管理系统中订购外卖的函数
	 * 
	 * @param sqlString 
	 * 操作的sql语句
	 */
	
	public static void addDishBuy(String sqlString) {
		MyMessage mm = new MyMessage(k.MessageType.ADD_DISHBUY, sqlString);
		serverRe = sendMessage(mm);	
	}
	
	/**
	 * 客户端餐厅管理系统中撤销外卖订购的函数
	 * 
	 * @param sqlString 
	 * 操作的sql语句
	 */
	
	public static void delDishBuy(String sqlString) {
		MyMessage mm = new MyMessage(k.MessageType.DEL_DISHBUY, sqlString);
		serverRe = sendMessage(mm);	
		
	}

	/**
	 * 客户端餐厅管理系统中删除外卖信息的函数
	 * 
	 * @param string 
	 * 操作的sql语句
	 */
	
	public static void delTakeAway(String string) {
		MyMessage mm = new MyMessage(k.MessageType.DEL_TAKEAWAY, string);
		serverRe = sendMessage(mm);	
	}

	/**
	 * 客户端餐厅管理系统中获得外卖订购信息的函数
	 * 
	 * @return Vector<Vector<String>>
	 * 外卖订购信息的Vector存储
	 * 
	 * @param string 
	 * 操作的sql语句
	 */

	public static Vector<Vector<String>> getAllDishBuy(String string) {
		
		Vector vector = new Vector();
		MyMessage mm = new MyMessage(k.MessageType.GET_ALLDISHBUY,string);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();	
	}
	
	/**
	 * 客户端餐厅管理系统中改变外卖发送状态的函数
	 * 
	 * @param string 
	 * 操作的sql语句
	 */
	
	public static void changeIfSend(String sql) {
		MyMessage mm = new MyMessage(k.MessageType.CHANGE_IFSEND, sql);
		serverRe = sendMessage(mm);	
		
	}

	/**
	 * 客户端餐厅管理系统中添加建议的函数
	 * 
	 * @return String
	 * 操作的实现状态
	 * 
	 * @param sqlString 
	 * 操作的sql语句
	 */
	
	public static String addAdvice(String sqlString) {
		MyMessage mm = new MyMessage(k.MessageType.ADD_ADVICE, sqlString);
		serverRe = sendMessage(mm);
		return (String)serverRe.getOb();
	}
	/**
	 * 客户端餐厅管理系统中改变建议阅读状态的函数
	 * 
	 * @param string 
	 * 操作的sql语句
	 */
	
	public static void changeRead(String string) {
		MyMessage mm = new MyMessage(k.MessageType.CHANGE_READ, string);
		serverRe = sendMessage(mm);	
		
	}
	

	/**
	 * 客户端餐厅管理系统中删除建议的函数
	 * 
	 * @param string 
	 * 操作的sql语句
	 */
	
	public static void delAdvice(String string) {
		MyMessage mm = new MyMessage(k.MessageType.DEL_ADVICE, string);
		serverRe = sendMessage(mm);	
		
		
	}
	/**
	 * 客户端餐厅管理系统中获得建议信息的函数
	 * 
	 * @return Vector<Vector<String>>
	 * 建议信息的Vector存储
	 * 
	 * @param sql
	 * 操作的sql语句
	 */
	
	public static Vector<Vector<String>> getAdvice(String sql) {
		Vector vector = new Vector();
		MyMessage mm = new MyMessage(k.MessageType.GET_ADVICE,sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	


	
}
