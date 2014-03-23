package seu.Client.bz.impl;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

import seu.Client.vo.StudentDorInfo;
//import seu.server.dao.DbHelper;

import k.MyMessage;

/**
 * �ͻ����������ģ��Ĺ��ܺ�����
 * @author��˧
 */
public class StudentDorInfoImpl extends CommonImpl{

	public StudentDorInfoImpl() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * �������ϵͳ�й���Ա��ѯ����ѧ����Ϣ�ĵĿͻ��˺���
 * @return
 * �������ϵͳ���ݱ�������ѧ������Ϣ
 */
	public static Vector<?> dor(){
		Vector<?> v = null;
		//serverRe = new MyMessage();
		MyMessage mm = new MyMessage(k.MessageType.GET_ALL_STU_INFO,null );
		//System.out.println(mm.getCmd());
		serverRe = sendMessage(mm);
		//System.out.println(mm.getOb());
		return (Vector<?>) serverRe.getOb();
	}
	/**
	 * �������ϵͳ�й���Աɾ��ѧ����Ϣ�Ŀͻ��˺���
	 * @param str
	 * ��Ҫɾ����ѧ����ѧ��
	 * 
	 */
	public static void StuDel(String str){
		MyMessage mm=new MyMessage(k.MessageType.DELETE_Dormitory_INFO,str);
		serverRe=sendMessage(mm);
	}
	/**
	 * �������ϵͳ����Ա���ѧ����Ϣ�Ŀͻ��˺���
	 * @param v
	 * ��Ҫ��ӵ�ѧ���Ļ�����Ϣ
	 */
	public static void StuAdd(Vector v){
		MyMessage mm=new MyMessage(k.MessageType.ADD_STU_Dormitory_INFO,v);
		serverRe=sendMessage(mm);
	}
	/**
	 * �������ϵͳ����Ա�޸�ѧ��������Ϣ�Ŀͻ��˺���
	 * @param str
	 * ��Ҫ�޸���Ϣ��ѧ����ѧ��
	 * @return
	 * ��Ҫ�޸���Ϣ��ѧ���Ļ�����Ϣ
	 */
	public static Vector StuChaBasic(String str){
       
		MyMessage mm=new MyMessage(k.MessageType.INQUIRY_STU,str);
		serverRe=sendMessage(mm);
		//System.out.println(mm.getCmd());
		return  (Vector) serverRe.getOb();
	}
	/*
	 * 
	 *  
	 */
	public static void StuCha(Vector v,String str){
	       StudentDorInfo stu=new StudentDorInfo();
	       stu.setVec(v);
	       stu.setStudentNo(str);
		MyMessage mm=new MyMessage(k.MessageType.MODIFY_Dormitory_INFO,stu);
		serverRe=sendMessage(mm);
	
	}
	/**
	 * �������ϵͳ����Ա��������Ŀͻ��˺���
	 * @param str1
	 * ��ʾ��Ҫ���������ѧ����ѧ��
	 * @param str2
	 * ��ʾҪ�����������
	 * @param str3
	 * ��ʾҪ�����Ĵ�λ��
	 * @return boolean
	 * �����Ƿ�ɹ�
	 */
	public static String StuDorCha(String str1,String str2,String str3){
		Vector v=new Vector();
		v.add(str1);
		v.add(str2);
		v.add(str3);
		//System.out.println(v);
		MyMessage mm=new MyMessage(k.MessageType.MODIFY_DormitoryID_INFO,v);
		serverRe=sendMessage(mm);
		return (String) serverRe.getOb();
	}
	/**
	 * �������ϵͳѧ����ѯ������Ϣ�Ŀͻ��˺���
	 * @param str
	 * ��ѯѧ����ѧ��
	 * @return
	 * ��ѯѧ�������л�����Ϣ
	 */
public static Vector StuDorInfostu(String str){
		
	MyMessage mm=new MyMessage(k.MessageType.INQUIRY_STU,str);
	serverRe=sendMessage(mm);
	return  (Vector) serverRe.getOb();

	}
}
