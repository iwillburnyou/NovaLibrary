package seu.Client.bz.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Vector;

import k.MyMessage;



//import client.util.SocketHelper;


public class ISubjseleImpl  extends CommonImpl {
	
	static MyMessage serverRe = null; 
	public ISubjseleImpl() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	/*
	 * 选课系统中添加一门课程的函数
	 * 
	 * 
	 * @parameter string 表示添加课程的命令语句
	 */
	public static void addSubj(String sql) {
	
		MyMessage mm2 = new MyMessage(k.MessageType.ADD_SUBJ, sql);
		serverRe = sendMessage(mm2);
		
	}
	
	
	
	/*
	 * 选课系统中获得所有课程的函数
	 * 
	 * @return Vector 获得所有课程信息
	 * 
	 * @parameter string 表示查询所有课程的命令语句
	 */

	public static Vector getAllCur(String sql) {
		MyMessage mm = new MyMessage(k.MessageType.GET_ALLCUR, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	

	/*
	 * 选课系统中修改一门课程的函数
	 * 
	 *
	 * 
	 * @parameter string 表示修改一门课程的命令语句
	 */
	public static void modSubj(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.MOD_SUBJ, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * 选课系统中删除一门课程的函数
	 * 
	 * 
	 * @parameter string 表示删除课程的命令语句
	 */

	public static void delSubj(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_SUBJ, sql);
		serverRe = sendMessage(mm);
	}
	
	
	

	/*
	 * 选课系统中为每位用户建表的函数
	 * 
	 * 
	 * @parameter string 表示建表的命令语句
	 */
	public static void stuCur(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.STU_CUR, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * 选课系统中用户界面面板获得数学类课程的函数
	 * 
	 * @return Vector 获得所有数学类课程所有信息
	 * 
	 * @parameter string 表示获得数学类课程命令语句
	 */

	public static Vector getMath(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_MATH, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	
	
	/*
	 * 选课系统中用户界面面板添加数学类课程的函数
	 * 
	 * 
	 * @parameter string 表示添加数学类课程命令语句
	 */
	public static void addMath(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_MATH, sql);
		serverRe = sendMessage(mm);
	}
	
	
	/*
	 * 选课系统中用户界面面板删除数学类课程的函数
	 * 
	 * 
	 * @parameter string 表示删除数学类课程命令语句
	 */
     public static void delMath(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_MATH, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * 选课系统中用户界面面板获得物理类课程的函数
	 * 
	 * @return Vector 获得所有物理类课程所有信息
	 * 
	 * @parameter string 表示获得物理类课程命令语句
	 */
	public static Vector getPhysics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_PHYSICS, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	
	
	/*
	 * 选课系统中用户界面面板添加物理类课程的函数
	 * 
	 * 
	 * @parameter string 表示添加物理类课程命令语句
	 */

	public static void addPhysics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_PHYSICS, sql);
		serverRe = sendMessage(mm);
	}
	
	
	

	/*
	 * 选课系统中用户界面面板删除物理类课程的函数
	 * 
	 * 
	 * @parameter string 表示删除物理类课程命令语句
	 */
	public static void delPhysics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_PHYSICS, sql);
		serverRe = sendMessage(mm);
	}
	
	
	

	/*
	 * 选课系统中用户界面面板获得英语类课程的函数
	 * 
	 * @return Vector 获得所有英语类课程所有信息
	 * 
	 * @parameter string 表示获得英语类课程命令语句
	 */
	public static Vector getEnglish(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_ENGLISH, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	

	/*
	 * 选课系统中用户界面面板添加英语类课程的函数
	 * 
	 * 
	 * @parameter string 表示添加英语类课程命令语句
	 */
	public static void addEnglish(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_ENGLISH, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * 选课系统中用户界面面板删除英语类课程的函数
	 * 
	 * 
	 * @parameter string 表示删除英语类课程命令语句
	 */

	public static void delEnglish(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_ENGLISH, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * 选课系统中用户界面面板获得体育类课程的函数
	 * 
	 * @return Vector 获得所有体育类课程所有信息
	 * 
	 * @parameter string 表示获得体育类课程命令语句
	 */

	public static Vector getPE(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_PE, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	
	/*
	 * 选课系统中用户界面面板添加体育类课程的函数
	 * 
	 * 
	 * @parameter string 表示添加体育类课程命令语句
	 */

	public static void addPE(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_PE, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * 选课系统中用户界面面板删除体育类课程的函数
	 * 
	 * 
	 * @parameter string 表示删除体育类课程命令语句
	 */

	public static void delPE(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_PE, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * 选课系统中用户界面面板获得计算机类课程的函数
	 * 
	 * @return Vector 获得所有计算机类课程所有信息
	 * 
	 * @parameter string 表示获得计算机类课程命令语句
	 */

	public static Vector getComputer(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_COMPUTER, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	/*
	 * 选课系统中用户界面面板添加计算机类课程的函数
	 * 
	 * 
	 * @parameter string 表示添加计算机类课程命令语句
	 */

	public static void addComputer(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_COMPUTER, sql);
		serverRe = sendMessage(mm);
	}
	
	
	

	/*
	 * 选课系统中用户界面面板删除计算机类课程的函数
	 * 
	 * 
	 * @parameter string 表示删除计算机类课程命令语句
	 */
	public static void delComputer(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_COMPUTER, sql);
		serverRe = sendMessage(mm);
	}
	
	
	/*
	 * 选课系统中用户界面面板获得艺术类课程的函数
	 * 
	 * @return Vector 获得所有艺术类课程所有信息
	 * 
	 * @parameter string 表示获得艺术类课程命令语句
	 */

	public static Vector getArt(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_ART, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}

	
	
	/*
	 * 选课系统中用户界面面板添加艺术类课程的函数
	 * 
	 * 
	 * @parameter string 表示添加艺术类课程命令语句
	 */
	public static void addArt(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_ART, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * 选课系统中用户界面面板删除艺术类课程的函数
	 * 
	 * 
	 * @parameter string 表示删除艺术类课程命令语句
	 */

	public static void delArt(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_ART, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * 选课系统中用户界面面板获得经济类课程的函数
	 * 
	 * @return Vector 获得所有经济类课程所有信息
	 * 
	 * @parameter string 表示获得经济类课程命令语句
	 */

	public static Vector getEcnomics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_ECNOMICS, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	
	/*
	 * 选课系统中用户界面面板添加经济类课程的函数
	 * 
	 * 
	 * @parameter string 表示添加经济类课程命令语句
	 */

	public static void addEcnomics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_ECNOMICS, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * 选课系统中用户界面面板删除经济类课程的函数
	 * 
	 * 
	 * @parameter string 表示删除经济类课程命令语句
	 */

	public static void delEcnomics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_ECNOMICS, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * 选课系统中用户界面面板获得自然科学类课程的函数
	 * 
	 * @return Vector 获得所有自然科学类课程所有信息
	 * 
	 * @parameter string 表示获得自然科学类课程命令语句
	 */

	public static Vector getScience(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_SCIENCE, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	/*
	 * 选课系统中用户界面面板添加自然科学类课程的函数
	 * 
	 * 
	 * @parameter string 表示添加自然科学类课程命令语句
	 */

	public static void addScience(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_SCIENCE, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * 选课系统中用户界面面板删除自然科学类课程的函数
	 * 
	 * 
	 * @parameter string 表示删除自然科学类课程命令语句
	 */

	public static void delScience(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_SCIENCE, sql);
		serverRe = sendMessage(mm);	
	}
	
	
	/*
	 * 选课系统中用户界面面板获得个人课表的函数
	 * 
	 * @return Vector 获得个人课表所有信息
	 * 
	 * @parameter string 表示获得个人课表命令语句
	 */

	public static Vector getStuCur(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_STUCUR, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}





	





	



}

