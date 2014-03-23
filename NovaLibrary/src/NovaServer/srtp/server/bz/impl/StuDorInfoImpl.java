package seu.server.bz.impl;



import java.sql.SQLException;
import java.util.Vector;

import seu.server.dao.DbHelper;
/**
 * ���������������ģ��Ĺ��ܺ�����
 * @author��˧
 */
public class StuDorInfoImpl {
	/**
	 * �������ϵͳ�й���Ա��ѯ����ѧ����Ϣ�ĵķ������˺���
	 * @return
	 * �������ϵͳ���ݱ�������ѧ������Ϣ
	 */
	public static Vector dor() {
		
		 Vector<Vector> vec=DbHelper.executeQuery("select * from Dormitory");
		 return vec;

		}
	/**
	 * �������ϵͳ����Ա���ѧ����Ϣ�ķ������˺���
	 * @param stu
	 * ��Ҫ��ӵ�ѧ���Ļ�����Ϣ
	 */
	public static void StuAdd(Vector<String> stu) {
		
		String sql="INSERT INTO Dormitory (StuID,Name,Sex,College,Birthday,Depart,Bed,Grade,Record) VALUES ('"+stu.get(0)+"','"+stu.get(1)+"','"+stu.get(2)+"','"+stu.get(3)+"','"+stu.get(4)+"','"+stu.get(5)+"','"+stu.get(6)+"','"+stu.get(7)+"','"+stu.get(8)+"' )" ;  
   	System.out.println(sql);
		
			DbHelper.executeUpdate(sql);
		
	}
	/**
	 * �������ϵͳ�й���Աɾ��ѧ����Ϣ�ķ������˺���
	 * @param stu
	 * ��Ҫɾ����ѧ����ѧ��
	 * 
	 */
	public static void StuDel(String stu){
		
		String sql="DELETE FROM Dormitory WHERE StuID='"+stu+"'";
		DbHelper.executeUpdate(sql);
	}
	/**
	 * �������ϵͳ����Ա�޸�ѧ��������Ϣ�ķ������˺���
	 * @param str
	 * ��Ҫ�޸���Ϣ��ѧ����ѧ��
	 * @return
	 * ��Ҫ�޸���Ϣ��ѧ���Ļ�����Ϣ
	 */
	public static Vector LookSb(String str){
		 Vector vec1=DbHelper.executeQuery("select * from Dormitory WHERE StuID='"+str+"'");
		 if(vec1.size()==0){
			 return vec1;
		 }
		 else{
		 Vector<Vector> vec=DbHelper.executeQuery("select * from Dormitory WHERE StuID='"+str+"'");
		 return vec;
		 }
	}
	/**
	 * �������ϵͳ����Ա�޸�ѧ��������Ϣ�ķ������˺���
	 * @param v
	 * ��Ҫ�޸���Ϣ��ѧ�����޸ĺ����Ϣ
	 * @param str
	 * ��Ҫ�޸���Ϣ��ѧ����ѧ��
	 */
	public static void StuCha(Vector v,String str){
		String sqlID="UPDATE Dormitory SET StuID='"+v.get(0)+" '         WHERE  StuID='"+str+"'";
		String sqlName="UPDATE Dormitory SET Name='"+v.get(1)+"'         WHERE  StuID='"+str+"'";
		String sqlSex="UPDATE Dormitory SET Sex='"+v.get(2)+"'           WHERE  StuID='"+str+"'";
		String sqlCollege="UPDATE Dormitory SET College='"+v.get(3)+"'   WHERE  StuID='"+str+"'";
		String sqlBirthday="UPDATE Dormitory SET Birthday='"+v.get(4)+"' WHERE  StuID='"+str+"'";
		String sqlGrade="UPDATE Dormitory SET Grade='"+v.get(5)+"'       WHERE  StuID='"+str+"'";
		String sqlRecord="UPDATE Dormitory SET Record='"+v.get(6)+"'     WHERE  StuID='"+str+"'";
		
		DbHelper.executeUpdate(sqlName);
		DbHelper.executeUpdate(sqlSex);
		DbHelper.executeUpdate(sqlCollege);
		DbHelper.executeUpdate(sqlBirthday);
		DbHelper.executeUpdate(sqlGrade);
		DbHelper.executeUpdate(sqlRecord);
		DbHelper.executeUpdate(sqlID);
	}
	/**
	 * �������ϵͳ����Ա��������ķ������˺���
	 * @param v
	 * ��ʾ��Ҫ��������ѧ����ѧ�š�Ŀ������š�Ŀ�괲λ��
	 * @return boolean
	 * �����Ƿ�ɹ�
	 */
	public static String StuChador(Vector v){
		System.out.println((String) v.get(0));
        Vector vec1=DbHelper.executeQuery("select * from Dormitory WHERE Depart='"+v.get(1)+"'");
        Vector vec2=DbHelper.executeQuery("select * from Dormitory WHERE Bed='"+v.get(2)+"'");

      if(vec1.size()==0){
    	  String sqlDepart="UPDATE Dormitory SET Depart='"+v.get(1)+" '    WHERE  StuID='"+v.get(0)+"'";
  		  String sqlBed="UPDATE Dormitory SET Bed='"+v.get(2)+"'         WHERE  StuID='"+v.get(0)+"'";		
  		  DbHelper.executeUpdate(sqlDepart);
		DbHelper.executeUpdate(sqlBed);
  		return "Y";
            }
         else{
             if(vec2.size()==0){
    	         String sqlDepart="UPDATE Dormitory SET Depart='"+v.get(1)+" '    WHERE  StuID='"+v.get(0)+"'";
   		         String sqlBed="UPDATE Dormitory SET Bed='"+v.get(2)+"'         WHERE  StuID='"+v.get(0)+"'";		
   		         DbHelper.executeUpdate(sqlDepart);
   			      DbHelper.executeUpdate(sqlBed);
   		      return "Y";
	         }
     
      else{
	      return "NO";
        }
      }
	}
	/**
	 * �������ϵͳѧ����ѯ������Ϣ�ķ������˺���
	 * @param str
	 * ��ѯѧ����ѧ��
	 * @return
	 * ��ѯѧ�������л�����Ϣ
	 */
	public static Vector StuDorInfo(String str){
		
        Vector vec=DbHelper.executeQuery("select * from Dormitory WHERE Depart='"+str+"'");  
	    return vec;

	}
	
}

