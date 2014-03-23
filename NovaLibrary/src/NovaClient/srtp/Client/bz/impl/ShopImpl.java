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
/**客户端商店系统模块功能函数类
 * 
 * @author 张梦微
 *
 */

public class ShopImpl extends CommonImpl{
	public ShopImpl() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	static MyMessage serverRe = null; // 服务器返回的message
	/**
	 * 商店系统中判断搜索的商品是否存在的函数
	 * 
	 * @return boolean 
	 * 是否存在
	 * 
	 * @param str
	 * String 表示商品名称的字符串

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
	
	
    //商店购物页面相关操作

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
		MyMessage mm = new MyMessage(MessageType.INQUIRY_STUDY_PRO,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
	}


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

		MyMessage mm = new MyMessage(MessageType.INQUIRY_LIFE_PRO,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
	}

	
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

		MyMessage mm = new MyMessage(MessageType.INQUIRY_FOOD_PRO,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
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

		MyMessage mm = new MyMessage(MessageType.INQUIRY_ALL_PRO,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
	}


	
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
		MyMessage mm = new MyMessage(MessageType.INQUIRY_GOODS_BY_NAME,
				str);
		serverRe = sendMessage(mm);
		return (Vector) serverRe.getOb();
	}
	
	//加入购物车
	/**
	 * 商店系统中加入购物车的函数
	 * 
	 * @return void 
	 * 无返回值
	 * 
	 * @param str1
	 * String 表示商品类别的字符串
	 * @param str2
	 * String 表示商品名称的字符串
	 * @param i1
	 * double 表示商品价格
	 * @param i2
	 * int 表示购买商品数量
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
	
	
	
    //购物车相关操作
    //是否已经存在在购物车中
    /*
    public static  boolean  IsExistCart(String str){
    	MyMessage mm = new MyMessage(MessageType.INQUIRY_STUDY_PRO,str);
		serverRe = sendMessage(mm);
		Vector vector=(Vector) serverRe.getOb();
		
		if(vector.size()==0) return false;
		else  return true;
	
	}
    */
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
		MyMessage mm = new MyMessage(MessageType.PERSON_RESERVE_RECORD,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
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
		MyMessage mm = new MyMessage(MessageType.SHOW_PAID_PRO,str);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
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
		
    	MyMessage mm = new MyMessage(MessageType.DISRESERVE_GOODS,str);
		serverRe = sendMessage(mm);
		
		
	}
    //确认购买
    /**
	 * 商店系统中确认购买的函数
	 * 
	 * @return String 
	 *返回是否付费成功的字符串
	 * 
	 * @param str1
	 * String 表示商品类别的字符串
	 * @param str2
	 * String 表示商品名称的字符串
	 * @param str3
	 * String 表示商品价格
	 * @param str4
	 * String 表示购买商品数量
	 * 

	 */
   public String PayForBill(String str1,String str2,String str3,String str4) {
		//商品信息表修改库存 str4 int
	   
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
    
    
    
	//管理员相关数据库操作
	// 返回需进货商品库存
   /**
	 * 商店系统中返回需进货商品库存至管理员界面的函数
	 * 
	 * @return Vector 
	 * 返回符合条件的商品信息
	 * 
	 * @param i
	 * String combobox下标 用以选择库存段的字符串

	 */
	public static Vector Shkucun(String i) { // 根据搜索的库存量段返回数据至管理员页面
		MyMessage mm = new MyMessage(MessageType.ADM_GET_COUNTS,i);
		serverRe = sendMessage(mm);
		
		return (Vector) serverRe.getOb();
	}
	
	// 新品上架入表
	/**
	 * 商店系统中新品上架入表的函数
	 * 
	 * @return void 
	 * 无返回值
	 * 
	 * @param str1
	 * String 表示商品类别的字符串
	 * @param str2
	 * String 表示商品名称的字符串
	 * @param i1
	 * double 表示商品价格
	 * @param i2
	 * int 表示新增商品数量
	 * 

	 */
	public static  void AddPro(String str1, String str2, double i1, int i2)
			throws SQLException {
		ProductInfo p = new ProductInfo();
        p.ProsetAll(str1,str2, i1,i2);
        MyMessage mm = new MyMessage(MessageType.ADM_ADD_GOODS,p);
		serverRe = sendMessage(mm);
		

	}

	// 修改库存
	/**
	 * 商店系统中修改库存的函数
	 * 
	 * @return void 
	 * 无返回值
	 * 
	 * @param str
	 * String 表示商品名称的字符串
	 * 
	 * @param i1
	 * String 表示库存增加至的数量
	
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

	// 修改价格
	/**
	 * 商店系统中修改价格的函数
	 * 
	 * @return void 
	 * 无返回值
	 * 
	 * @param str
	 * String 表示商品名称的字符串
	 * 
	 * @param i1
	 * String 表示价格修改至的数量
	
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
		MyMessage mm = new MyMessage(MessageType.ADM_DELETE_GOODS,str);
		serverRe = sendMessage(mm);
		

		
		
	}
	
}
