package seu.Client.bz.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import k.*;

import seu.Client.util.SocketHelper;

import seu.Client.vo.StudentInfo;
/**
 * 客户端学籍管理模块的功能函数类
 * @author 王一多
 * 
 */
public class StudentInfoImpl extends CommonImpl{

	public StudentInfoImpl() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	static MyMessage serverRe = null; // 服务器返回的message





	/**
	 * 学籍管理系统中添加一名学生信息的函数
	 * 
	 * @return boolean 
	 * 操作是否成功
	 * 
	 * @param StudentInfo 
	 * 学生信息类
	 */
	public static String addStuInfo(StudentInfo s) {
	
			
			MyMessage mm = new MyMessage(k.MessageType.ADD_STU, s);
			serverRe =sendMessage(mm);
			System.out.println(serverRe.getOb());
			return (String) serverRe.getOb();
	}

	/**
	 * 学籍管理系统中查询一名学生信息的函数
	 * 
	 * @return boolean 
	 * 操作是否成功
	 * 
	 * @param str
	 * String 一个表示学号或者姓名的字符串
	 * @param isName
	 * boolean 标记传进来的是学号还是名字
	 */

	public static StudentInfo queryStuInfo(String str, boolean isName) {
		// TODO Auto-generated method stub
		serverRe = new MyMessage();

		if (isName) {
			try {
				
				// 按名字来查询
				MyMessage mm = new MyMessage(MessageType.INQUIRY_STU_BY_NAME,
						str);
				serverRe = sendMessage(mm);
				
				return (StudentInfo) serverRe.getOb();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			try {
				
				// 按学号来查询
				MyMessage mm = new MyMessage(MessageType.INQUIRY_STU_BY_NO,
						str);
				serverRe = sendMessage(mm);
				
				return (StudentInfo) serverRe.getOb();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	/**
	 * 更新按钮的发送消息操作
	 * @param stuVo
	 * StudentInfo 一个学生信息的实体类对象
	 */
	public static boolean updateStuInfo(StudentInfo stuVo) {
		// TODO Auto-generated method stub
		try {
			System.out.println("update in client"+stuVo.Gender);
			MyMessage mm = new MyMessage(MessageType.MODIFY_STU,
					stuVo);
			serverRe = sendMessage(mm);
			
			if(serverRe.getCmd()==MessageType.SERVER_OPERATION_SUCC)
				return true;
			else
				return false;
			// SocketHelper.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 删除一个学生学籍信息的客户端函数
	 * @param str
	 * 需要删除学生的学号
	 * @return boolean
	 * 指示操作是否成功
	 */
	public static boolean deleteStuInfo(String str) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DELETE_STU, str);
		serverRe = sendMessage(mm);
		
		if (serverRe.getCmd() == MessageType.SERVER_OPERATION_SUCC) {
			return true;
		} else {
			return false;
		}
	}

}
