package seu.Client.vo;

import java.io.Serializable;
/**
 * 学科信息的实体类
 * @author 张雯露
 *
 */
public class Subject implements Serializable{
	private static final long serialVersionUID = 1L;
	String Id;    //课程ID
	String Name;   //课程名称
	String Teacher;   //任课老师
	String Num;       //课时
	String Credit;   //学分
	String Type;     //课程类型
	/**
	 * 学科信息实体类的构造函数
	 * @param s0
	 * 课程代码
	 * @param s1
	 * 课程名字
	 * @param s2
	 * 授课老师
	 * @param s3
	 * 课程编号
	 * @param s4
	 * 学分数
	 * @param s5
	 * 课程类型
	 */

	public Subject(String s0, String s1, String s2, String s3, String s4,
			String s5) {
		// TODO Auto-generated constructor stub
		Id=s0;
		Name=s1;
		Teacher=s2;
		Num=s3;
		Credit=s4;
		Type=s5;
		
	}



	/**
	 * 获取课程ID
	 * 
	 * @return
	 * 课程ID
	 */
	public String getId() {
		return Id;
	}
	
	/**
	 * 设置课程ID
	 * 
	 * @param id
	 * 课程类ID
	 */
	public void setId(String id) {
		Id = id;
	}
	
	/**
	 * 获取课程名称
	 * 
	 * @return
	 * 课程名称
	 */
	public String getName() {
		return Name;
	}
	
	/**
	 * 设置课程名称
	 * 
	 * @param name
	 * 课程名称
	 */
	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * 获取老师
	 * 
	 * @return
	 * 老师
	 */
	public String getTeacher() {
		return Teacher;
	}
	
	/**
	 * 设置老师姓名
	 * 
	 * @param teacher
	 * 老师姓名
	 */
	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
	
	/**
	 * 获取课时
	 * 
	 * @return
	 * 课时
	 */
	public String getNum() {
		return Num;
	}
	
	/**
	 * 设置课时
	 * 
	 * @param num
	 * 课时
	 */
	public void setNum(String num) {
		Num = num;
	}
	
	/**
	 * 获取学分
	 * 
	 * @return
	 * 学分
	 */
	public String getCredit() {
		return Credit;
	}
	
	/**
	 * 设置学分
	 * 
	 * @param credit
	 * 学分
	 */
	public void setCredit(String credit) {
		Credit = credit;
	}
	
	/**
	 * 获取课程种类
	 * 
	 * @return
	 * 课程种类
	 */
	public String getType() {
		return Type;
	}
	
	/**
	 * 设置课程种类
	 * 
	 * @param type
	 * 课程种类
	 */
	public void setType(String type) {
		Type = type;
	}

}
