package seu.server.bz.impl;

import java.sql.SQLException;
import java.util.Vector;

import seu.server.dao.DbHelper;


import k.MessageType;

public class SubjseleImpl implements MessageType {
	
	
	/*
	 * ��ӿγ�
	 */
	public static void addSubj(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}

	
	/*
	 * ������пγ�
	 */
	public static Vector getAllCur(String ob) {
		return DbHelper.executeQuery(ob);
	}
	
	/*
	 * �޸Ŀγ�
	 */
	public static void modSubj(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}
	
	/*
	 * ɾ���γ�
	 */
	public static void delSubj(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
		
	}
	
	
	/*
	 * �����������ݱ�
	 */
	public static void STU_CUR(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	

	/*
	 * ����������ѧ��γ���Ϣ
	 */
	public static Vector getMath(String ob) {
		// TODO Auto-generated method stub
		return DbHelper.executeQuery(ob);
	}
	
	
	/*
	 * �����ѧ��γ�
	 */
	public static void addMath(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * ɾ����ѧ��γ�
	 */
	public static void delMath(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * ��������������γ���Ϣ
	 */
	public static Vector getPhysics(String ob) {
		// TODO Auto-generated method stub
		return DbHelper.executeQuery(ob);
	}

	
	/*
	 * ���������γ�
	 */
	public static void addPhysics(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	/*
	 * ɾ��������γ�
	 */
	public static void delPhysics(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * ��������Ӣ����γ���Ϣ
	 */
	public static Vector getEnglish(String ob) {
		// TODO Auto-generated method stub
		return DbHelper.executeQuery(ob);
	}

	
	/*
	 * ���Ӣ����γ�
	 */
	public static void addEnglish(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * ɾ��Ӣ����γ�
	 */
	public static void delEnglish(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * ��������������γ���Ϣ
	 */
	public static Vector getPE(String ob) {
		// TODO Auto-generated method stub
	   return DbHelper.executeQuery(ob);
	}

	
	/*
	 * ���������γ�
	 */
	public static void addPE(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * ɾ��������γ�
	 */
	public static void delPE(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * �������м������γ���Ϣ
	 */
	public static Vector getComputer(String ob) {
		// TODO Auto-generated method stub
		  return DbHelper.executeQuery(ob);
	}

	
	/*
	 * ��Ӽ������γ�
	 */
	public static void addComputer(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * ɾ���������γ�
	 */
	public static void delComputer(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	
	/*
	 * ��������������γ���Ϣ
	 */
	public static Vector getArt(String ob) {
		// TODO Auto-generated method stub
		 return DbHelper.executeQuery(ob);
	}

	
	/*
	 * ���������γ�
	 */
	public static void addArt(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * ɾ��������γ�
	 */
	public static void delArt(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * �������о�����γ���Ϣ
	 */
	public static Object getEcnomics(String ob) {
		// TODO Auto-generated method stub
		 return DbHelper.executeQuery(ob);
	}
	
	
	/*
	 * ��Ӿ�����γ�
	 */
	public static void addEcnomics(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * ɾ��������γ�
	 */
	public static void delEcnomics(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * ����������Ȼ��ѧ��γ���Ϣ
	 */
	public static Vector getScience(String ob) {
		// TODO Auto-generated method stub
		 return DbHelper.executeQuery(ob);
	}
	
	
	/*
	 * �����Ȼ��ѧ��γ�
	 */
	public static void addScience(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * ɾ����Ȼ��ѧ��γ�
	 */
	public static void delScience(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * �������˿γ̿α�
	 */
	public static Vector getStuCur(String ob) {
		// TODO Auto-generated method stub
		return DbHelper.executeQuery(ob);
	}

}

	
