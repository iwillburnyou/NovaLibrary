package seu.server.bz.impl;



import java.sql.SQLException;
import java.util.Vector;

import seu.server.dao.DbHelper;
/**
 * 服务器端宿舍管理模块的功能函数类
 * @author朱帅
 */
public class StuDorInfoImpl {
	/**
	 * 宿舍管理系统中管理员查询所有学生信息的的服务器端函数
	 * @return
	 * 宿舍管理系统数据表中所有学生的信息
	 */
	public static Vector dor() {
		
		 Vector<Vector> vec=DbHelper.executeQuery("select * from Dormitory");
		 return vec;

		}
	/**
	 * 宿舍管理系统管理员添加学生信息的服务器端函数
	 * @param stu
	 * 需要添加的学生的基本信息
	 */
	public static void StuAdd(Vector<String> stu) {
		
		String sql="INSERT INTO Dormitory (StuID,Name,Sex,College,Birthday,Depart,Bed,Grade,Record) VALUES ('"+stu.get(0)+"','"+stu.get(1)+"','"+stu.get(2)+"','"+stu.get(3)+"','"+stu.get(4)+"','"+stu.get(5)+"','"+stu.get(6)+"','"+stu.get(7)+"','"+stu.get(8)+"' )" ;  
   	System.out.println(sql);
		
			DbHelper.executeUpdate(sql);
		
	}
	/**
	 * 宿舍管理系统中管理员删除学生信息的服务器端函数
	 * @param stu
	 * 需要删除的学生的学号
	 * 
	 */
	public static void StuDel(String stu){
		
		String sql="DELETE FROM Dormitory WHERE StuID='"+stu+"'";
		DbHelper.executeUpdate(sql);
	}
	/**
	 * 宿舍管理系统管理员修改学生基本信息的服务器端函数
	 * @param str
	 * 需要修改信息的学生的学号
	 * @return
	 * 需要修改信息的学生的基本信息
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
	 * 宿舍管理系统管理员修改学生基本信息的服务器端函数
	 * @param v
	 * 需要修改信息的学生的修改后的信息
	 * @param str
	 * 需要修改信息的学生的学号
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
	 * 宿舍管理系统管理员调整宿舍的服务器端函数
	 * @param v
	 * 表示需要调换宿舍学生的学号、目标宿舍号、目标床位号
	 * @return boolean
	 * 调换是否成功
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
	 * 宿舍管理系统学生查询基本信息的服务器端函数
	 * @param str
	 * 查询学生的学号
	 * @return
	 * 查询学生的所有基本信息
	 */
	public static Vector StuDorInfo(String str){
		
        Vector vec=DbHelper.executeQuery("select * from Dormitory WHERE Depart='"+str+"'");  
	    return vec;

	}
	
}

