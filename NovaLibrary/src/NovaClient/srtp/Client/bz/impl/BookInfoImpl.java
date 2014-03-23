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
 * �ͻ���ͼ��ݹ���ģ��Ĺ��ܺ�����
 * @author kidd
 */
public class BookInfoImpl extends CommonImpl{

	public BookInfoImpl() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

//	private static ObjectInputStream is;
//	private static ObjectOutputStream os;
	static MyMessage serverRe = null; // ���������ص�message
	/*
	 * ��ö������������
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
	 * ѧ������ϵͳ�����һ��ѧ����Ϣ�ĺ���
	 * 
	 * @return boolean �����Ƿ�ɹ�
	 * 
	 * @parameter StudentInfo ѧ����Ϣ��
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
	 * ѧ������ϵͳ�в�ѯһ��ѧ����Ϣ�ĺ���
	 * 
	 * @return boolean �����Ƿ�ɹ�
	 * 
	 * @parameter string һ����ʾѧ�Ż����������ַ���
	 */

	public static BookInfo queryStuInfo(String str, boolean isName) {
		// TODO Auto-generated method stub
		serverRe = new MyMessage();

			try {
				
				// ��ͼ��������ѯ
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
	 * ���°�ť�ķ�����Ϣ����
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
	 * ɾ��һ��ѧ��ѧ����Ϣ�Ŀͻ��˺���
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