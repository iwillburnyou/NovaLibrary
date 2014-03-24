package seu.server.bz.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.sun.org.apache.regexp.internal.recompile;

import seu.Client.vo.StudentInfo;
import seu.server.dao.DbHelper;
import k.MessageType;
import k.MyMessage;
/**
 * ��������ѧ������ģ��Ĺ��ܺ���
 * @author ��һ��
 */	
public class StuInfoImpl implements MessageType{
	/**
	 * �������˸���һ��ѧ����Ϣ�ĺ���
	 * @author ��һ��
	 * @param ob
	 * ѧ����Ϣʵ�������
	 */	
	static void updateStu(StudentInfo ob) throws SQLException {
		// TODO Auto-generated method stub
		String sql;
		sql="delete from tblStudentInfo where StudentNo ='"+ob.StudentNo+"'";
		DbHelper.executeUpdate(sql);
		 sql="insert into tblStudentInfo (StudentNo,StuName,Gender,Grade,Department,Major,IDNumber)values ('"
				+ob.StudentNo+"','"
				+ob.Name+"','"
				+ob.Gender+"','"
				+ob.Grade+"','"
				+ob.Department+"','"
				+ob.Major+"','"
				+ob.ID+"')";
		DbHelper.executeUpdate(sql);
	}
	/**
	 * ��ѧ�������в�ѯ
	 * @param No
	 * ѧ��
	 */
	static StudentInfo queryByNo(String No) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from tblStudentInfo where StudentNo='"+No+"'";

		StudentInfo si = new StudentInfo();
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		if(vec.size()!=0){
			Vector<String> re = vec.firstElement();
			si.setAll(re.get(1), re.get(2) , re.get(3), re.get(4), re.get(5), re.get(6), re.get(7));
		}
		else {
			//���޴��ˣ���
			return null;
		}
		//��������
//		if( rs.next() )
//			si.setAll(rs.getString("StudentNo"), rs.getString("StuName"), rs.getString("Gender"), rs.getString("Grade"), rs.getString("Department"), rs.getString("Major"), rs.getString("IDNumber"));
		return si;
	}
/**
 * ��ѧ����������ѯ
 */
	static StudentInfo queryByName(String Name) {
		// TODO Auto-generated method stub
		String sql = "select * from tblStudentInfo where StuName='"+Name+"'";
		//System.out.println("in queryByName");
		StudentInfo si = new StudentInfo();
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		System.out.println(vec.size());
		if(vec.size()!=0){
			Vector<String> re = vec.firstElement();
			si.setAll(re.get(1), re.get(2) , re.get(3), re.get(4), re.get(5), re.get(6), re.get(7));
		}
		else {
			//���޴��ˣ���
			return null;
		}
		return si;
	}

	static void addStu(StudentInfo ob) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into tblStudentInfo (StudentNo,StuName,Gender,Grade,Department,Major,IDNumber)values ('"
				+ob.StudentNo+"','"
				+ob.Name+"','"
				+ob.Gender+"','"
				+ob.Grade+"','"
				+ob.Department+"','"
				+ob.Major+"','"
				+ob.ID+"')";
		
		DbHelper.executeUpdate(sql);
		
	}
	/**
	 * ɾ��һ��ѧ��ѧ����Ϣ�ķ������˲���
	 */
	public static void delStu(String ob) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from tblStudentInfo where StudentNo = '"+ob+"'";
		DbHelper.executeUpdate(sql);
	}
}
