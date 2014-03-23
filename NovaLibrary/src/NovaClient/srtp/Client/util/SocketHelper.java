/**
 *创建Socket连接（全局静态量）并创建输入输出流 
 */
package seu.Client.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHelper {

	private static String StuId;
	private static Socket socket = null; // 定义socket连接
	private static ObjectOutputStream os =null; // 定义输出对象
	private static ObjectInputStream is = null; // 定义输入对象

	/**
	 * 建立Socket 与服务器端通信
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void getConnection() throws UnknownHostException, IOException {
		
			socket = new Socket("127.0.0.1", 5678); 
			System.out.println("客户端socket建立");
			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(socket.getInputStream());

//		} catch (UnknownHostException e) {
//			System.out.println("offline");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("1");
//			e.printStackTrace();
//		}
	}

	/**
	 * 获得对象输出流
	 * 
	 * @return ObjectOutputStream
	 */
	public static ObjectOutputStream getOs() {
		return os;
	}

	/**
	 * 设置对象输出流
	 * 
	 * @param os
	 */
	public static void setOs(ObjectOutputStream os) {
		SocketHelper.os = os;
	}

	/**
	 * 获得对象输入流
	 * 
	 * @return ObjectInputStream
	 */
	public static ObjectInputStream getIs() {
		return is;
	}

	/**
	 * 设置对象输输入流
	 * 
	 * @param is
	 */
	public static void setIs(ObjectInputStream is) {
		SocketHelper.is = is;
	}

	/**
	 * 获得与服务器连接的Socket
	 * 
	 * @return Socket
	 */
	public static Socket getSocket() {
		return socket;
	}

	/**
	 * 设置Socket
	 * 
	 * @param socket
	 */
	public static void setSocket(Socket socket) {
		SocketHelper.socket = socket;
	}
	
	public static void close() {
		try {
			if(is !=null) {
				is.close() ;is = null;
			}
			
			if(os !=null) {
				os.close() ; os = null;
			}
			
			if(socket !=null) {
				socket.close() ; socket = null;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
