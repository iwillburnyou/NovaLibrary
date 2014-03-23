package seu.Client.bz.impl;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

import seu.Client.vo.StudentDorInfo;
//import seu.server.dao.DbHelper;

import k.MyMessage;

/**
 * 客户端宿舍管理模块的功能函数类
 * @author朱帅
 */
public class StudentDorInfoImpl extends CommonImpl{

	public StudentDorInfoImpl() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * 宿舍管理系统中管理员查询所有学生信息的的客户端函数
 * @return
 * 宿舍管理系统数据表中所有学生的信息
 */
	public static Vector<?> dor(){
		Vector<?> v = null;
		//serverRe = new MyMessage();
		MyMessage mm = new MyMessage(k.MessageType.GET_ALL_STU_INFO,null );
		//System.out.println(mm.getCmd());
		serverRe = sendMessage(mm);
		//System.out.println(mm.getOb());
		return (Vector<?>) serverRe.getOb();
	}
	/**
	 * 宿舍管理系统中管理员删除学生信息的客户端函数
	 * @param str
	 * 需要删除的学生的学号
	 * 
	 */
	public static void StuDel(String str){
		MyMessage mm=new MyMessage(k.MessageType.DELETE_Dormitory_INFO,str);
		serverRe=sendMessage(mm);
	}
	/**
	 * 宿舍管理系统管理员添加学生信息的客户端函数
	 * @param v
	 * 需要添加的学生的基本信息
	 */
	public static void StuAdd(Vector v){
		MyMessage mm=new MyMessage(k.MessageType.ADD_STU_Dormitory_INFO,v);
		serverRe=sendMessage(mm);
	}
	/**
	 * 宿舍管理系统管理员修改学生基本信息的客户端函数
	 * @param str
	 * 需要修改信息的学生的学号
	 * @return
	 * 需要修改信息的学生的基本信息
	 */
	public static Vector StuChaBasic(String str){
       
		MyMessage mm=new MyMessage(k.MessageType.INQUIRY_STU,str);
		serverRe=sendMessage(mm);
		//System.out.println(mm.getCmd());
		return  (Vector) serverRe.getOb();
	}
	/*
	 * 
	 *  
	 */
	public static void StuCha(Vector v,String str){
	       StudentDorInfo stu=new StudentDorInfo();
	       stu.setVec(v);
	       stu.setStudentNo(str);
		MyMessage mm=new MyMessage(k.MessageType.MODIFY_Dormitory_INFO,stu);
		serverRe=sendMessage(mm);
	
	}
	/**
	 * 宿舍管理系统管理员调整宿舍的客户端函数
	 * @param str1
	 * 表示需要调换宿舍的学生的学号
	 * @param str2
	 * 表示要调换的宿舍号
	 * @param str3
	 * 表示要调换的床位号
	 * @return boolean
	 * 调换是否成功
	 */
	public static String StuDorCha(String str1,String str2,String str3){
		Vector v=new Vector();
		v.add(str1);
		v.add(str2);
		v.add(str3);
		//System.out.println(v);
		MyMessage mm=new MyMessage(k.MessageType.MODIFY_DormitoryID_INFO,v);
		serverRe=sendMessage(mm);
		return (String) serverRe.getOb();
	}
	/**
	 * 宿舍管理系统学生查询基本信息的客户端函数
	 * @param str
	 * 查询学生的学号
	 * @return
	 * 查询学生的所有基本信息
	 */
public static Vector StuDorInfostu(String str){
		
	MyMessage mm=new MyMessage(k.MessageType.INQUIRY_STU,str);
	serverRe=sendMessage(mm);
	return  (Vector) serverRe.getOb();

	}
}
