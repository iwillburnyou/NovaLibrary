package seu.Client.vo;

import java.io.Serializable;
import java.util.Vector;
/**
 * 宿舍信息的实体类
 * @author 朱帅
 *
 */
public class StudentDorInfo implements Serializable{
	public String StudentNo;
	public String Name;
	public String Gender;
	public String Grade;
	public String Birthday;
	public String Department;
	public String Bed;
	public String Major;
	public String Record;
    public Vector vec;
    public StudentDorInfo(){
    	
    }
    public void setBirthday(String str){
    	Birthday=str;
    }
	public void setStudentNo(String str){
		this.StudentNo=str;
	}
	public void setName(String str){
		this.Name=str;
	}
	public void setGender(String str){
		this.Gender=str;
	}
	public void setGrade(String str){
		this.Grade=str;
	}	
	public void setDepartment(String str){
		this.Department=str;
	}
	public void setMajor(String str){
		this.Major=str;
	}	public void Bed(String str){
		this.Bed=str;
	}
	public void setRecord(String str){
		this.Record=str;
	}	
	public String getBirthday(){

		return Birthday;
	}
	public String getStudentNo( ){
		return StudentNo ;
	}
	public String getName( ){
		return Name ;
	}
	public String getGender( ){
		return Gender ;
	}
	public String getGrade( ){
		return Grade;
	}	
	public String getDepartment( ){
		return Department ;
	}
	public String getMajor( ){
		return Major ;
	}	
	public String getBed(){
		return Bed ;
	}
	public String getRecord(){
		return Record ;
	}	
	public void setVec(Vector str){
		this.vec=str;
	}	
	public Vector getVec(){

		return vec;
	
}
}
