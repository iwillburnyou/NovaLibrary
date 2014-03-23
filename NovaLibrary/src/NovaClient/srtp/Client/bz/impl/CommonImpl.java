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
 * k客户端公共模块功能函数，负责获取socket和IO流，以及发送消息
 * @author kidd
 *
 */
public class CommonImpl {
	private static ObjectInputStream is;
	private static ObjectOutputStream os;
	static MyMessage serverRe = null; // 服务器返回的message

	/**
	 * 获得对象输入输出流
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
	 * 客户端发送消息的封装函数
	 * @param mm
	 * 一个消息对象
	 * @return
	 * 从服务器端返回的一个消息对象
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
