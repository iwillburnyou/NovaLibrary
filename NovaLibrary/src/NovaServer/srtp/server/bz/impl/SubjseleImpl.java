package seu.server.bz.impl;

import java.sql.SQLException;
import java.util.Vector;

import seu.server.dao.DbHelper;


import k.MessageType;

public class SubjseleImpl implements MessageType {
	
	
	/*
	 * 添加课程
	 */
	public static void addSubj(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}

	
	/*
	 * 获得所有课程
	 */
	public static Vector getAllCur(String ob) {
		return DbHelper.executeQuery(ob);
	}
	
	/*
	 * 修改课程
	 */
	public static void modSubj(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}
	
	/*
	 * 删除课程
	 */
	public static void delSubj(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
		
	}
	
	
	/*
	 * 建立个人数据表
	 */
	public static void STU_CUR(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	

	/*
	 * 获得面板中数学类课程信息
	 */
	public static Vector getMath(String ob) {
		// TODO Auto-generated method stub
		return DbHelper.executeQuery(ob);
	}
	
	
	/*
	 * 添加数学类课程
	 */
	public static void addMath(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * 删除数学类课程
	 */
	public static void delMath(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * 获得面板中物理类课程信息
	 */
	public static Vector getPhysics(String ob) {
		// TODO Auto-generated method stub
		return DbHelper.executeQuery(ob);
	}

	
	/*
	 * 添加物理类课程
	 */
	public static void addPhysics(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	/*
	 * 删除物理类课程
	 */
	public static void delPhysics(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * 获得面板中英语类课程信息
	 */
	public static Vector getEnglish(String ob) {
		// TODO Auto-generated method stub
		return DbHelper.executeQuery(ob);
	}

	
	/*
	 * 添加英语类课程
	 */
	public static void addEnglish(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * 删除英语类课程
	 */
	public static void delEnglish(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * 获得面板中体育类课程信息
	 */
	public static Vector getPE(String ob) {
		// TODO Auto-generated method stub
	   return DbHelper.executeQuery(ob);
	}

	
	/*
	 * 添加体育类课程
	 */
	public static void addPE(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * 删除体育类课程
	 */
	public static void delPE(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * 获得面板中计算机类课程信息
	 */
	public static Vector getComputer(String ob) {
		// TODO Auto-generated method stub
		  return DbHelper.executeQuery(ob);
	}

	
	/*
	 * 添加计算机类课程
	 */
	public static void addComputer(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * 删除计算机类课程
	 */
	public static void delComputer(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	
	/*
	 * 获得面板中艺术类课程信息
	 */
	public static Vector getArt(String ob) {
		// TODO Auto-generated method stub
		 return DbHelper.executeQuery(ob);
	}

	
	/*
	 * 添加艺术类课程
	 */
	public static void addArt(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * 删除艺术类课程
	 */
	public static void delArt(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * 获得面板中经济类课程信息
	 */
	public static Object getEcnomics(String ob) {
		// TODO Auto-generated method stub
		 return DbHelper.executeQuery(ob);
	}
	
	
	/*
	 * 添加经济类课程
	 */
	public static void addEcnomics(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}
	
	
	/*
	 * 删除经济类课程
	 */
	public static void delEcnomics(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * 获得面板中自然科学类课程信息
	 */
	public static Vector getScience(String ob) {
		// TODO Auto-generated method stub
		 return DbHelper.executeQuery(ob);
	}
	
	
	/*
	 * 添加自然科学类课程
	 */
	public static void addScience(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * 删除自然科学类课程
	 */
	public static void delScience(String ob) throws SQLException {
		// TODO Auto-generated method stub
		DbHelper.executeUpdate(ob);
	}

	
	/*
	 * 获得面个人课程课表
	 */
	public static Vector getStuCur(String ob) {
		// TODO Auto-generated method stub
		return DbHelper.executeQuery(ob);
	}

}

	
