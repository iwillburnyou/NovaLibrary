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

/**服务器端商店系统模块功能函数类
 * 
 * @author 张梦微
 *
 */

	
public class ShopImpl {
    //商店购物页面相关操作
//是否存在该商品
	/**
	 * 商店系统中判断搜索的商品是否存在的函数
	 * 
	 * @return boolean 
	 * 是否存在
	 * 
	 * @param str
	 * String 表示商品名称的字符串

	 */
	public static int  IsExist(String str){
		String sql = "select * from tblProductInfo where Name='"+str+"'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);
		if(vec.size()==0) return 0;
		else return 1;
		
	
	}
	// 返回学习用品至购买页面

	/**
	 * 商店系统中返回学习用品至购买页面的函数
	 * 
	 * @return Vector 
	 * 返回符合条件的商品信息
	 * 
	 * @param str
     * String 空字符串

	 */
	public static Vector ShStudyPro(String str) {

		String sql = "select * from tblProductInfo where Type='学习用品'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);

		return vec;
	}

	// 返回生活用品至购买页面
	/**
	 * 商店系统中返回生活用品至购买页面的函数
	 * 
	 * @return Vector 
	 * 返回符合条件的商品信息
	 * 
	 * @param str
	 * String 空字符串

	 */
	public static Vector ShLifePro(String str) {

		String sql = "select * from tblProductInfo where Type='生活用品'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);

		return vec;
	}

	// 返回食品至购买页面
	
	/**
	 * 商店系统中返回食品至购买页面的函数
	 * 
	 * @return Vector 
	 * 返回符合条件的商品信息
	 * 
	 * @param str
	 * String 空字符串

	 */
	public static Vector ShFoodPro(String str) {

		String sql = "select * from tblProductInfo where Type='食品'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);

		return vec;
	}

	// 返回全部至购买页面
	/**
	 * 商店系统中返回全部至购买页面的函数
	 * 
	 * @return Vector 
	 * 返回符合条件的商品信息
	 * 
	 * @param str
	 * String 空字符串

	 */
	public static Vector ShAllPro(String str) {

		String sql = "select * from tblProductInfo ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);

		return vec;
	}

	// public Vector SearByName(String str,String type,String prilev){
	
	// 返回由商品名称完成的精确搜索至购买页面
	/**
	 * 商店系统中返回由商品名称完成的精确搜索至购买页面的函数
	 * 
	 * @return Vector 
	 * 返回符合条件的商品信息
	 * 
	 * @param str
	 * String 空字表示商品名称的符串

	 */
	public static Vector SearByName(String str) {
		String sql = "select * from tblProductInfo where Name='" + str + "'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);
		return vec;
	}
	//加入购物车
	/**
	 * 商店系统中加入购物车的函数
	 * 
	 * @return void 
	 * 无返回值
	 * 
	 * @param str1
	 * ProductInfo 表示选择加入购物车的商品信息的实体类
	 

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
	
	
	
    //购物车相关操作
    //是否已经存在在购物车中
    /**
	 * 商店系统中判断加入购物车的商品是否已经存在在购物车中的函数
	 * 
	 * @return boolean 
	 * 是否存在
	 * 
	 * @param str
	 * String 表示商品名称的字符串

	 */
    public static  boolean  IsExistCart(String str){
		String sql = "select * from MyCart where Name='"+str+"'ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);
		if(vec.size()==0) return false;
		else return true;
		
	
	}
	// 返回购物车表中数据至购物车页面
    /**
   	 * 商店系统中返回购物车表中数据至购物车页面的函数
   	 * 
   	 * @return Vector 
   	 * 返回符合条件的商品信息
   	 * 
   	 * @param str
   	 * String 空字表示商品名称的符串

   	 */
	public static Vector ShCart(String str) {
		String sql = "select * from MyCart ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);
		return vec;
	}

	// 返回已购买商品表中数据至购物车页面
	/**
	 * 商店系统中返回已购买商品表中数据至购物车页面的函数
	 * 
	 * @return Vector 
	 * 返回符合条件的商品信息
	 * 
	 * @param str
	 * String 空字表示商品名称的符串

	 */
	public static Vector ShPaidPro(String str) {
		String sql = "select * from PaidPro ORDER BY ID";
		Vector vec = DbHelper.executeQuery(sql);
		return vec;
	}
	//删除购物车中不想购买的产品
	/**
	 * 商店系统中删除购物车中不想购买的产品的函数
	 * 
	 * @return void
	 *无返回值
	 * 
	 * @param str
	 * String 空字表示商品名称的符串

	 */
    public static void DelCartPro(String str) throws SQLException{
		
		String sql = "delete * from MyCart  where Name='"+str+"'";
		DbHelper.executeUpdate(sql);
		System.out.println(sql);
	}
    //确认购买
    /**
   	 * 商店系统中确认购买的函数
   	 * 
   	 * @return String 
   	 *返回是否付费成功的字符串
   	 * 
   	 * @param P
   	 * ProductInfo 表示要购买商品的信息的实体类
   	

   	 */
   public static String PayForBill(ProductInfo p) throws SQLException{
		//商品信息表修改库存 str4 int
	   String str ="1";
	    //判断购买数量是否大于库存 是的话报错！
	    String sql = "select * from tblProductInfo where Count>="+p.getCount()+" and name='"+p.getName()+"'";
	    Vector vec=DbHelper.executeQuery(sql);
	    if(vec.size()==0){
	    	str="库存不够";
	    //JOptionPane.showMessageDialog(null,"商品"+p.getName()+"库存不够 请进行修改！","确认付款",JOptionPane.WARNING_MESSAGE);
	    }
	    
	    else {
	    	String sql1 = "update tblProductInfo set Count=Count-"+p.getCount()+" where Name='"+p.getName()+"'";
			DbHelper.executeUpdate(sql1);
			//JOptionPane.showMessageDialog(null, "商品删除成功！");
			System.out.println(sql1);
			
			//删减购物车表 str2 按名称删除
			String sql2 = "delete * from MyCart  where Name='"+p.getName()+"'";
			DbHelper.executeUpdate(sql2);
			//JOptionPane.showMessageDialog(null, "商品删除成功！");
			System.out.println(sql2);
			//入已购买产品表
			
			String sql3 = "insert into PaidPro (Type,Name,Price,Count) values ('"
					+ p.getType() + "','" + p.getName() + "','" + p.getPrice() + "','" + p.getCount() + "')";
			DbHelper.executeUpdate(sql3);
			//JOptionPane.showMessageDialog(null, "商品删除成功！");
			System.out.println(sql3);
		    String sql4 = "select * from MyCart ";
			Vector vec2=DbHelper.executeQuery(sql4);
		    if(vec2.size()==0){
		    	str="付费成功";
		    //JOptionPane.showMessageDialog(null,"商品"+p.getName()+"库存不够 请进行修改！","确认付款",JOptionPane.WARNING_MESSAGE);
		    }
		
	
	    }
	    
	    System.out.println(str);
		return str;
		
	
		
		
	}
    
    
    
	//管理员相关数据库操作
	// 返回需进货商品库存
   /**
	 * 商店系统中返回需进货商品库存至管理员界面的函数
	 * 
	 * @return Vector 
	 * 返回符合条件的商品信息
	 * 
	 * @param n
	 * String combobox下标 用以选择库存段的字符串

	 */
	public static Vector Shkucun(String n) { // 根据搜索的库存量段返回数据至管理员页面
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

	// 新品上架入表
	 /**
   	 * 商店系统中确认购买的函数
   	 * 
   	 * @return void 
   	 *无返回值
   	 * 
   	 * @param P
   	 * ProductInfo 表示要上架新品的信息的实体类
   	

   	 */
	public static void AddPro(ProductInfo p)
			throws SQLException {

		// String sql="insert into Test1 values ('str1','str2','i1','i2')";
		String sql = "insert into tblProductInfo (Type,Name,Price,Count) values ('"
				+ p.getType() + "','" + p.getName() + "','" + p.getPrice() + "','" + p.getCount() + "')";
		System.out.println(sql);
		DbHelper.executeUpdate(sql);
	

	}

	// 修改库存
	/**
	 * 商店系统中修改库存的函数
	 * 
	 * @return void 
	 * 无返回值
	 * 
	 * 
   	 * @param P
   	 * ProductInfo 表示要进行修改的商品的信息的实体类
   	

	 */
	public static void ChangeCount(ProductInfo p) {

		
		
		String sql = "update tblProductInfo set Count="+p.getCount()+" where Name='"+p.getName()+"'";
	
		 
	DbHelper.executeUpdate(sql);
		System.out.println(sql);
		
	}

	// 修改价格
	/**
	 * 商店系统中修改价格的函数
	 * 
	 * @return void 
	 * 无返回值
	 * 
	 * 
   	 * @param P
   	 * ProductInfo 表示要进行修改的商品的信息的实体类
   	

	 */
	public static void ChangePrice(ProductInfo p) throws SQLException {

	
		// String
		// sql="update Test2 (Price) values ('"+i+"') where Name='"+str+"'";
		
		String sql = "update tblProductInfo set Price='" + p.getPrice() + "' where Name='"+p.getName()+"'";

		DbHelper.executeUpdate(sql);
		
		System.out.println(sql);
	}
	//商品下架
	/**
	 * 商店系统中修改价格的函数
	 * 
	 * @return void 
	 * 无返回值
	 * 
	 * @param str
	 * String 表示商品名称的字符串
	 * 

	
	 * 

	 */

	public static void DelPro(String str) throws SQLException{
		
		String sql = "delete * from tblProductInfo  where Name='"+str+"'";
		DbHelper.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "商品删除成功！");
		System.out.println(sql);
	}
}
