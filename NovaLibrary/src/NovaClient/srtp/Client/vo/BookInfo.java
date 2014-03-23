package seu.Client.vo;

import java.io.Serializable;

/**
 * @封装书籍信息的实体类
 * @author 杨云
 */
public class BookInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String BookNo;
	public String Name;
	public String Publiser;
	public String Writer;
	public String Price;
	public String Indate;
	public String BookType;
	/**
	 * 设置一个书籍信息实体类的全部成员
	 * @param bookNo
	 * 书籍的编号
	 * @param name
	 * 书籍名字
	 * @param Publiser
	 * 出版社
	 * @param Writer
	 * 作者
	 * @param Price
	 * 价钱
	 * @param Indate
	 * 入馆日期
	 * @param BookType
	 * 书籍类型
	 */
	public void setAll(String bookNo,String name,String Publiser , String Writer, String Price ,String Indate ,String BookType){
		this.BookNo = bookNo;
		this.Name = name;
		this.Publiser =Publiser ;
		this.Writer =Writer;
		this.Price = Price;
		this.Indate = Indate;
		this.BookType = BookType;
		
	}
	
	
//	学号", "Two" }, { "姓名", "Four" }, { "性别", "Four" }, { "年级", "Four" }
//	, { "院系", "Four" }, { "专业", "Four" }, { "身份证号", "Four" }

}

