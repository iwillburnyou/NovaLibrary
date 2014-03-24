package seu.server.bz.thread;

/**
 * ��������̡߳�ÿ�������û�Ψһ��Ӧһ�����߳�
 * ���û���¼�������û�����ע��ʱ����
 * 
 * @see Thread, MessageType
 * 
 */

import java.io.*;
import java.net.*;
import java.sql.SQLException;

import k.MyMessage;
import k.MessageType;

import seu.Client.bz.impl.StudentInfoImpl;
import seu.server.bz.impl.CommonImpl;
import seu.server.bz.impl.StuInfoImpl;
import seu.server.view.ServerView;

//import server.bz.intf.ICanteenServerImpl;
//import server.bz.intf.ICourseServerImpl;
//import server.bz.intf.IFeedbackServerImpl;
//import server.bz.intf.ILibraryServerImpl;
//import server.bz.intf.ILogInServerImpl;
//import server.bz.intf.IShopServerImpl;
//import server.bz.intf.IStuInfoServerImpl;
//import server.view.ServerView;
//import common.MessageType;
/**
 * ������ÿ�������Ϸ������û������߳���
 * @author ��һ��
 */
public class SubThread extends Thread {

	private ObjectInputStream is;
	private ObjectOutputStream os;
	private Socket socket; // ���û�ͨ����������
	// private int cmd; //�û�����ָ�ΪMessageType�е�һ����Ա
	private MyMessage mm; // ���տͻ���������Ϣ��Ҳ��Ϊ������Ϣ���ظ��ͻ���

	public SubThread() {
	}
	/**
	 * ���������ÿ�����ӿͻ��ķ��̵߳Ĺ��캯��
	 * @author ��һ��
	 */
	public SubThread(Socket socket) {
		this.socket = socket; // ����socket����

		// ��������
		try {
			(ServerView.count)++;
			is = new ObjectInputStream(this.socket.getInputStream());
			os = new ObjectOutputStream(this.socket.getOutputStream());
			System.out.println("��������socket����ȡ");
		} catch (IOException e) {
			(ServerView.count)--; // ���ӽ���ʧ��
			e.printStackTrace();
		}

	}

	/**
	 * run����ʵ���û��ڿͻ��������˵�ͨ�ţ�һ�ν���һ����Ϣ
	 * 
	 * MessageType�У�ͨ����ͬģ��ռ�ò�ͬ��������������ģ������
	 * 
	 */
	@Override
	public void run() {
			while(!socket.isClosed()) {
				try {
					mm = (MyMessage) is.readObject(); // ���������ΪMessageType�е�һ����Ա,��������!
					if (CommonImpl.executeCmd(mm)) {
						mm.setCmd(MessageType.SERVER_OPERATION_SUCC);
					} else {
						mm.setCmd(MessageType.SERVER_OPERATION_FAIL);
						mm.setOb("cmdִ�г�����");
					}

				} catch (SQLException eSQL) {
					
					eSQL.printStackTrace();
					mm.setCmd(MessageType.SERVER_OPERATION_FAIL);
					mm.setOb("�������ݲ��Ϸ������������ܾ�");
				} catch (Exception e) {
					if(mm!=null)
						mm.setCmd(MessageType.SERVER_OPERATION_FAIL);
					e.printStackTrace();
				} finally {
					try {
						// ���ظ��ͻ��˵���Ϣ
						os.writeObject(mm);
						os.flush();
					} catch (IOException e2) {
						System.out.println("���ظ��ͻ��˵���Ϣʧ�ܣ�client offline��");
						ServerView.count--;
						try {
							os.close();
							is.close();
							socket.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						break;

					}
			}
			
		
			}
			

		
	}
}
