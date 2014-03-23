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
 * �ͻ���ѧ������ģ��Ĺ��ܺ�����
 * @author ��һ��
 * 
 */
public class StudentInfoImpl extends CommonImpl{

	public StudentInfoImpl() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	static MyMessage serverRe = null; // ���������ص�message





	/**
	 * ѧ������ϵͳ�����һ��ѧ����Ϣ�ĺ���
	 * 
	 * @return boolean 
	 * �����Ƿ�ɹ�
	 * 
	 * @param StudentInfo 
	 * ѧ����Ϣ��
	 */
	public static String addStuInfo(StudentInfo s) {
	
			
			MyMessage mm = new MyMessage(k.MessageType.ADD_STU, s);
			serverRe =sendMessage(mm);
			System.out.println(serverRe.getOb());
			return (String) serverRe.getOb();
	}

	/**
	 * ѧ������ϵͳ�в�ѯһ��ѧ����Ϣ�ĺ���
	 * 
	 * @return boolean 
	 * �����Ƿ�ɹ�
	 * 
	 * @param str
	 * String һ����ʾѧ�Ż����������ַ���
	 * @param isName
	 * boolean ��Ǵ���������ѧ�Ż�������
	 */

	public static StudentInfo queryStuInfo(String str, boolean isName) {
		// TODO Auto-generated method stub
		serverRe = new MyMessage();

		if (isName) {
			try {
				
				// ����������ѯ
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
				
				// ��ѧ������ѯ
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
	 * ���°�ť�ķ�����Ϣ����
	 * @param stuVo
	 * StudentInfo һ��ѧ����Ϣ��ʵ�������
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
	 * ɾ��һ��ѧ��ѧ����Ϣ�Ŀͻ��˺���
	 * @param str
	 * ��Ҫɾ��ѧ����ѧ��
	 * @return boolean
	 * ָʾ�����Ƿ�ɹ�
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
