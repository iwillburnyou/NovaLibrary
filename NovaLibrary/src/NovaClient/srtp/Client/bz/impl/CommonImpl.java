package seu.Client.bz.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;

import k.MessageType;
import k.MyMessage;
import seu.Client.util.SocketHelper;
import seu.Client.vo.StudentInfo;
/**
 * k�ͻ��˹���ģ�鹦�ܺ����������ȡsocket��IO�����Լ�������Ϣ
 * @author kidd
 *
 */
public class CommonImpl {
	private static ObjectInputStream is;
	private static ObjectOutputStream os;
	static MyMessage serverRe = null; // ���������ص�message

	/**
	 * ��ö������������
	 */
	public static void initSocket() throws UnknownHostException, IOException {
		SocketHelper.getConnection();
		is = SocketHelper.getIs();
		os = SocketHelper.getOs();
	}
	public static void closeSocket() {
		SocketHelper.close();
		try {
			if (is != null)
				is.close();
			if (os != null)
				os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public CommonImpl() throws UnknownHostException, IOException {
		//initSocket();
	}

	/**
	 * �ͻ��˷�����Ϣ�ķ�װ����
	 * @param mm
	 * һ����Ϣ����
	 * @return
	 * �ӷ������˷��ص�һ����Ϣ����
	 */
	public static MyMessage sendMessage(MyMessage mm) {
		try {
			//os.writeInt(61);
			System.out.println("send message "+mm.getCmd());
			//initSocket();
			os.writeObject(mm );
			os.flush();
			serverRe = (MyMessage) is.readObject();
			//System.out.println(serverRe);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			return serverRe;
			
		}
	
}
}
