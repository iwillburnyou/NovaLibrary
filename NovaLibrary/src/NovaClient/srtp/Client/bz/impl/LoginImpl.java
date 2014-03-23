package seu.Client.bz.impl;

import java.io.IOException;
import java.net.UnknownHostException;

import k.MyMessage;
import k.User;
/**
	 * ��½����
	 * @author ���
	 */

public class LoginImpl extends CommonImpl{

	public LoginImpl() throws UnknownHostException, IOException {
		super();	
	}
/**
	 * ��½������ʾ��½����ݺ���
	 * 
	 * @return User 
	 * �����û����
	 * 
	 * @param string
	 * String һ����ʾ�û���ݵ��ַ���
	 * 
	 */
	public static User getMessage(String string) {
		MyMessage mm = new MyMessage(k.MessageType.GET_MESSAGE, string);
		serverRe = sendMessage(mm);
		return (User)serverRe.getOb();
	}

/**
	 * ע�ắ��
	 * 
	 * @return void 
	 * �޷���ֵ
	 * 
	 * @param sql
	 * String ��Ϣ�������ݿ��sql���
	 * 
	 */
	public static void registerNew(String sql) {
		MyMessage mm = new MyMessage(k.MessageType.REGISTER_NEW,sql);
		serverRe = sendMessage(mm);
	}
/**
	 * �޸����뺯��
	 * 
	 * @return void 
	 * �޷���ֵ
	 * 
	 * @param sql
	 * String һ�������޸����ݿ������������sql���
	 * 
	 */
	public static void changePsd(String sql) {
		MyMessage mm = new MyMessage(k.MessageType.CHANGE_PSD,sql);
		serverRe = sendMessage(mm);	
	}
	

}