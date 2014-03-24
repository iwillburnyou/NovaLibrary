package seu.server.bz.thread;


/**
 * �������˿���������ʱ���̣߳����߳�
 * ֧�ֶ��û�ͬʱ��¼����
 */


import java.io.IOException;
import java.net.*;

import seu.server.view.*;
/**
 * �������˵���Ҫ�߳��࣬���������������������ÿ�������û��Ķ��߳�
 * @author ��һ��
 */
public class MainThread extends Thread {
	private Socket socket; // ���ڶԿͻ��˵�ͨ��
	private ServerSocket server = null; // �����server

/**
 * ���̵߳Ĺ��캯��
 */
	public MainThread() {
		this.start();		//�����������߳�
		System.out.println("������");
	}
	
	/**
	 * �رշ��������رշ����
	 */
	public void close() {
		try {
			this.stop();
			if (socket != null ) {
				if(!socket.isClosed()) {
					socket.close();		//socket�ر�
					System.out.println("socket�رգ�");
				}
				socket = null;
				
			}
			if (server!=null) {
					server.close();		//serverSocket�ر�
					System.out.println("serverSocket�رգ�");
				server = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �߳�run����
	 */
	@Override
	public void run() {
		try {
			server = new ServerSocket(5678);
			System.out.println("���Ƿ���������5678�˿ڼ���");
			// ����,�ȴ�����
			while (true) {
				//�������û���¼ʱ����������
				socket = server.accept();
				System.out.println("���ӳɹ�");
				
				
				// ���տͻ��˷�������Ϣ.
				new SubThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				server.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
