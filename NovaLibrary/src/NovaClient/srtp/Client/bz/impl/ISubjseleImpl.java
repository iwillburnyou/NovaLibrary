package seu.Client.bz.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Vector;

import k.MyMessage;



//import client.util.SocketHelper;


public class ISubjseleImpl  extends CommonImpl {
	
	static MyMessage serverRe = null; 
	public ISubjseleImpl() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	/*
	 * ѡ��ϵͳ�����һ�ſγ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾ��ӿγ̵��������
	 */
	public static void addSubj(String sql) {
	
		MyMessage mm2 = new MyMessage(k.MessageType.ADD_SUBJ, sql);
		serverRe = sendMessage(mm2);
		
	}
	
	
	
	/*
	 * ѡ��ϵͳ�л�����пγ̵ĺ���
	 * 
	 * @return Vector ������пγ���Ϣ
	 * 
	 * @parameter string ��ʾ��ѯ���пγ̵��������
	 */

	public static Vector getAllCur(String sql) {
		MyMessage mm = new MyMessage(k.MessageType.GET_ALLCUR, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	

	/*
	 * ѡ��ϵͳ���޸�һ�ſγ̵ĺ���
	 * 
	 *
	 * 
	 * @parameter string ��ʾ�޸�һ�ſγ̵��������
	 */
	public static void modSubj(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.MOD_SUBJ, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * ѡ��ϵͳ��ɾ��һ�ſγ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾɾ���γ̵��������
	 */

	public static void delSubj(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_SUBJ, sql);
		serverRe = sendMessage(mm);
	}
	
	
	

	/*
	 * ѡ��ϵͳ��Ϊÿλ�û�����ĺ���
	 * 
	 * 
	 * @parameter string ��ʾ������������
	 */
	public static void stuCur(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.STU_CUR, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * ѡ��ϵͳ���û������������ѧ��γ̵ĺ���
	 * 
	 * @return Vector ���������ѧ��γ�������Ϣ
	 * 
	 * @parameter string ��ʾ�����ѧ��γ��������
	 */

	public static Vector getMath(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_MATH, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	
	
	/*
	 * ѡ��ϵͳ���û�������������ѧ��γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾ�����ѧ��γ��������
	 */
	public static void addMath(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_MATH, sql);
		serverRe = sendMessage(mm);
	}
	
	
	/*
	 * ѡ��ϵͳ���û��������ɾ����ѧ��γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾɾ����ѧ��γ��������
	 */
     public static void delMath(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_MATH, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * ѡ��ϵͳ���û����������������γ̵ĺ���
	 * 
	 * @return Vector �������������γ�������Ϣ
	 * 
	 * @parameter string ��ʾ���������γ��������
	 */
	public static Vector getPhysics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_PHYSICS, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	
	
	/*
	 * ѡ��ϵͳ���û�����������������γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾ���������γ��������
	 */

	public static void addPhysics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_PHYSICS, sql);
		serverRe = sendMessage(mm);
	}
	
	
	

	/*
	 * ѡ��ϵͳ���û��������ɾ��������γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾɾ��������γ��������
	 */
	public static void delPhysics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_PHYSICS, sql);
		serverRe = sendMessage(mm);
	}
	
	
	

	/*
	 * ѡ��ϵͳ���û����������Ӣ����γ̵ĺ���
	 * 
	 * @return Vector �������Ӣ����γ�������Ϣ
	 * 
	 * @parameter string ��ʾ���Ӣ����γ��������
	 */
	public static Vector getEnglish(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_ENGLISH, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	

	/*
	 * ѡ��ϵͳ���û�����������Ӣ����γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾ���Ӣ����γ��������
	 */
	public static void addEnglish(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_ENGLISH, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * ѡ��ϵͳ���û��������ɾ��Ӣ����γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾɾ��Ӣ����γ��������
	 */

	public static void delEnglish(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_ENGLISH, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * ѡ��ϵͳ���û����������������γ̵ĺ���
	 * 
	 * @return Vector �������������γ�������Ϣ
	 * 
	 * @parameter string ��ʾ���������γ��������
	 */

	public static Vector getPE(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_PE, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	
	/*
	 * ѡ��ϵͳ���û�����������������γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾ���������γ��������
	 */

	public static void addPE(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_PE, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * ѡ��ϵͳ���û��������ɾ��������γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾɾ��������γ��������
	 */

	public static void delPE(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_PE, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	
	/*
	 * ѡ��ϵͳ���û���������ü������γ̵ĺ���
	 * 
	 * @return Vector ������м������γ�������Ϣ
	 * 
	 * @parameter string ��ʾ��ü������γ��������
	 */

	public static Vector getComputer(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_COMPUTER, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	/*
	 * ѡ��ϵͳ���û����������Ӽ������γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾ��Ӽ������γ��������
	 */

	public static void addComputer(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_COMPUTER, sql);
		serverRe = sendMessage(mm);
	}
	
	
	

	/*
	 * ѡ��ϵͳ���û��������ɾ���������γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾɾ���������γ��������
	 */
	public static void delComputer(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_COMPUTER, sql);
		serverRe = sendMessage(mm);
	}
	
	
	/*
	 * ѡ��ϵͳ���û����������������γ̵ĺ���
	 * 
	 * @return Vector �������������γ�������Ϣ
	 * 
	 * @parameter string ��ʾ���������γ��������
	 */

	public static Vector getArt(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_ART, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}

	
	
	/*
	 * ѡ��ϵͳ���û�����������������γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾ���������γ��������
	 */
	public static void addArt(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_ART, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * ѡ��ϵͳ���û��������ɾ��������γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾɾ��������γ��������
	 */

	public static void delArt(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_ART, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * ѡ��ϵͳ���û���������þ�����γ̵ĺ���
	 * 
	 * @return Vector ������о�����γ�������Ϣ
	 * 
	 * @parameter string ��ʾ��þ�����γ��������
	 */

	public static Vector getEcnomics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_ECNOMICS, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	
	/*
	 * ѡ��ϵͳ���û����������Ӿ�����γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾ��Ӿ�����γ��������
	 */

	public static void addEcnomics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_ECNOMICS, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * ѡ��ϵͳ���û��������ɾ��������γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾɾ��������γ��������
	 */

	public static void delEcnomics(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_ECNOMICS, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * ѡ��ϵͳ���û������������Ȼ��ѧ��γ̵ĺ���
	 * 
	 * @return Vector ���������Ȼ��ѧ��γ�������Ϣ
	 * 
	 * @parameter string ��ʾ�����Ȼ��ѧ��γ��������
	 */

	public static Vector getScience(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_SCIENCE, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}
	
	
	/*
	 * ѡ��ϵͳ���û�������������Ȼ��ѧ��γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾ�����Ȼ��ѧ��γ��������
	 */

	public static void addScience(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.ADD_SCIENCE, sql);
		serverRe = sendMessage(mm);
	}
	
	
	
	/*
	 * ѡ��ϵͳ���û��������ɾ����Ȼ��ѧ��γ̵ĺ���
	 * 
	 * 
	 * @parameter string ��ʾɾ����Ȼ��ѧ��γ��������
	 */

	public static void delScience(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.DEL_SCIENCE, sql);
		serverRe = sendMessage(mm);	
	}
	
	
	/*
	 * ѡ��ϵͳ���û���������ø��˿α�ĺ���
	 * 
	 * @return Vector ��ø��˿α�������Ϣ
	 * 
	 * @parameter string ��ʾ��ø��˿α��������
	 */

	public static Vector getStuCur(String sql) {
		// TODO Auto-generated method stub
		MyMessage mm = new MyMessage(k.MessageType.GET_STUCUR, sql);
		serverRe = sendMessage(mm);
		return (Vector)serverRe.getOb();
	}





	





	



}

