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
 * 服务器端餐厅管理模块的功能函数类
 * @author 张雅淋
 * 
 */
public class CanteenInfoImpl implements MessageType{
	
	/**
	 * 服务器端餐厅管理系统添加菜品的函数
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	public static void addDish(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);	
		
	}
	
	/**
	 * 服务器端餐厅管理系统删除菜品的函数
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	
	public static void delDish(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}
	
	/**
	 * 服务器端餐厅管理系统改变菜品信息的函数
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	public static void changeDish(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);	
		
	}

	/**
	 * 服务器端餐厅管理系统中获得菜品信息的函数
	 * 
	 * @return Vector 
	 * 菜品信息的Vector
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	public static Vector getDish(String ob) {
		return DbHelper.executeQuery(ob);	
	}
	
	/**
	 * 服务器端餐厅管理系统订购外卖的函数
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	public static void addDishBuy(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}
	
	/**
	 * 服务器端餐厅管理系统撤销外卖订购的函数
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	public static void delDishBuy(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}

	/**
	 * 服务器端餐厅管理系统中获得外卖订购信息的函数
	 * 
	 * @return Object 
	 * 外卖订购信息
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	public static Object getAllDishBuy(String ob) {
		return DbHelper.executeQuery(ob);
	}
	/**
	 * 服务器端餐厅管理系统改变外卖发送状态的函数
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	public static void changeIfSend(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);	
		
	}
	/**
	 * 服务器端餐厅管理系统删除外卖信息的函数
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	public static void delTakeAway(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}
	/**
	 * 服务器端餐厅管理系统添加建议的函数
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
    public static void addAdvice(String ob) throws SQLException {
		
		DbHelper.executeUpdate(ob);	
	}

	/**
	 * 服务器端餐厅管理系统中获得建议信息的函数
	 * 
	 * @return Object 
	 * 建议信息
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	public static Object getAdvice(String ob) {
		return DbHelper.executeQuery(ob);
	}
	
	/**
	 * 服务器端餐厅管理系统改变建议阅读状态的函数
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	
	public static void changeRead(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);	
	}
	
	/**
	 * 服务器端餐厅管理系统删除建议的函数
	 * 
	 * @param ob 
	 * 操作的sql语句
	 */
	public static void delAdvice(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
	}

}
