package k;

import java.io.Serializable;

import org.omg.CORBA.UNKNOWN;

import k.MessageType;
/**
 * ��Ϣ��ʵ����
 * @author ��һ��
 *  		
 */
public class MyMessage implements Serializable,MessageType{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int cmd;
	Object  ob;
	/**
	 * MyMessage���캯��
	 * @param cmd
	 *  int�͵����ָ�����ĸ�����
	 *  @param ob
	 *  һ����װ�õ�����Ϣ�����Ĳ���������������Ҫ��ȫ����Ϣ
	 */
	
	public MyMessage(int cmd , Object ob) {
		this.cmd = cmd;
		this.ob = ob;
	}
	
	public MyMessage() {
		this.cmd = NULL_MESSAGE;
		this.ob = null;
	}
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public Object getOb() {
		return ob;
	}
	public void setOb(Object ob) {
		this.ob = ob;
	}
	public String toString() {
		return ""+cmd+ob;
	}
}
