package seu.Client.bz.impl;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.JOptionPane;

import k.*;
import seu.Client.util.SocketHelper;
import seu.Client.vo.BookInfo;
/**
 * 客户端图书馆管理模块的功能函数类
 * @author kidd
 */
public class BookInfoImpl extends CommonImpl{

	public BookInfoImpl() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

//	private static ObjectInputStream is;
//	private static ObjectOutputStream os;
	static MyMessage serverRe = null; // 服务器返回的message
	/*
	 * 获得对象输入输出流
	 */
//	public static void initSocket() throws UnknownHostException, IOException {
//		SocketHelper.getConnection();
//		is = SocketHelper.getIs();
//		os = SocketHelper.getOs();
//	}

//	public StudentInfoImpl() throws UnknownHostException, IOException {
//		initSocket();
//	}

	/*
	 * 学籍管理系统中添加一名学生信息的函数
	 * 
	 * @return boolean 操作是否成功
	 * 
	 * @parameter StudentInfo 学生信息类
	 */
	public static void addBookRent(String sqlString) {
		MyMessage mm = new MyMessage(k.MessageType.SUBSCRIBE_BOOK, sqlString);
		serverRe = sendMessage(mm);	
	}

	public static Vector<Vector<String>> getBookRent(String sqlString) {
		Vector vector = new Vector();
		MyMessage mm = new MyMessage(k.MessageType.PERSON_BORROW_RECORD, sqlString);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	public static void deletebookrent(String sqlString) {
		MyMessage mm = new MyMessage(k.MessageType.UNSUBSCRIBE_BOOK, sqlString);
		serverRe = sendMessage(mm);	
	}
	public static String addStuInfo(BookInfo s) {
	
			// os.writeInt(61);
			
//			os.writeObject(new k.MyMessage(61, s));
//			os.flush();
//			serverRe = (MyMessage) is.readObject();
//			System.out.println(serverRe);
//			if (serverRe.getCmd() == MessageType.SERVER_OPERATION_SUCC) {
//				return true;
//			} else {
//				return false;
//			}
			MyMessage mm = new MyMessage(k.MessageType.ADD_BOOK, s);
			serverRe = sendMessage(mm);
			System.out.println(serverRe.getOb());
			return (String) serverRe.getOb();
	}

	/*
	 * 学籍管理系统中查询一名学生信息的函数
	 * 
	 * @return boolean 操作是否成功
	 * 
	 * @parameter string 一个表示学号或者姓名的字符串
	 */

	public static BookInfo queryStuInfo(String str, boolean isName) {
		// TODO Auto-generated method stub
		serverRe = new MyMessage();

			try {
				
				// 按图书编号来查询
				MyMessage mm = new MyMessage(MessageType.INQUIRY_BOOK_BY_ID,
						str);
				serverRe = sendMessage(mm);
				
				return (BookInfo) serverRe.getOb();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		//}

	}

	/*
	 * 更新按钮的发送消息操作
	 */
	public static boolean updateBookInfo(BookInfo stuVo) {
		try {
			System.out.println("update in client"+stuVo.BookNo);
			MyMessage mm = new MyMessage(MessageType.MODIFY_BOOK,
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

	/*
	 * 删除一个学生学籍信息的客户端函数
	 */
	public static boolean deleteBookInfo(String str) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DELETE_BOOK, str);
		serverRe = sendMessage(mm);

		if (serverRe.getCmd() == MessageType.SERVER_OPERATION_SUCC) {
			return true;
		} else {
			return false;
		}
	}

}