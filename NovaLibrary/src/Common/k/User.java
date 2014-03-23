package k;

import java.io.Serializable;

/**
 * 学生实体类定义，用来掌握每个登陆账号的必要信息
 * setters and getters 的javadoc就省略了 都是存在的
 * @author 王一多
 */


public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String cardNo; //一卡通号也是登陆账户名
	String studentNo;//学号
	String name;		
	String psd;	//密码
	String role;// 'super' '学生' '食堂管理员' '学籍系统管理员' '图书馆管理员' 选课系统管理员 宿舍管理员 商店系统管理员
	String accounts;//账号余额
	/**
	 * User类的构造函数，按顺序初始化User类每个数据成员
	 * 
	 * @author 王一多
	 */
	public User(String str1,String str2,String str3,String str4,String str5){
		cardNo = str1;
		studentNo = str2;
		name = str3;
		psd = str4;
		role = str5;
	}
	/**
	 * User类的默认构造函数
	 * 
	 * 
	 */
	public User(){
		cardNo = "213100262";
		studentNo = "09011222";
		name = "ZWL";
		psd = "zwl";
		role = "学生";
	}
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}





	



}


