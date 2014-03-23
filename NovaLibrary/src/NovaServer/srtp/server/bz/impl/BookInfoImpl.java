package seu.server.bz.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.sun.org.apache.regexp.internal.recompile;

import seu.Client.vo.BookInfo;
import seu.server.dao.DbHelper;
import k.MessageType;
import k.MyMessage;
/**
 * 服务器端图书馆模块的功能函数
 * @author 杨云
 */
public class BookInfoImpl implements MessageType{
	/**
	 * 更新某本图书的信息
	 * @param ob
	 * 图书信息实体类
	 * @author 杨云
	 */
	static void updateBook(BookInfo ob) throws SQLException {
		// TODO Auto-generated method stub
		String sql;
		sql="delete from tbBookInfo where BookNo ='"+ob.BookNo+"'";
		DbHelper.executeUpdate(sql);
		 sql="insert into tbBookInfo (BookNo,Name,Publiser,Writer,Price,Indate,BookType)values ('"
				+ob.BookNo+"','"
				+ob.Name+"','"
				+ob.Publiser+"','"
				+ob.Writer+"','"
				+ob.Price+"','"
				+ob.Indate+"','"
				+ob.BookType+"')";

		DbHelper.executeUpdate(sql);
	}
	/**
	 * 按书本号来检索图书
	 * @param No
	 * 书本号
	 */
	static BookInfo queryByNo(String No) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from tbBookInfo where BookNo='"+No+"'";

		BookInfo si = new BookInfo();
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		if(vec.size()!=0){
			Vector<String> re = vec.firstElement();
			si.setAll(re.get(0),re.get(1), re.get(2) , re.get(3), re.get(4), re.get(5), re.get(6));
			return si;
		}
		else {
			
			return null;
		}
		
	}
/**
 * 按学生姓名来查询
 */
/*	static BookInfo queryByName(String Name) {
		// TODO Auto-generated method stub
		String sql = "select * from tblBookInfo where StuName='"+Name+"'";
		//System.out.println("in queryByName");
		StudentInfo si = new StudentInfo();
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		System.out.println(vec.size());
		if(vec.size()!=0){
			Vector<String> re = vec.firstElement();
			si.setAll(re.get(1), re.get(2) , re.get(3), re.get(4), re.get(5), re.get(6), re.get(7));
		}
		else {
			//查无此人？？
			return null;
		}
		return si;
	}*/
	/**
	 * 添加一本新的图书
	 * @param ob
	 * 图书信息的实体类
	 */
	static void addBook(BookInfo ob) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into tbBookInfo (BookNo,Name,Publiser,Writer,Price,Indate,BookType)values ('"
				+ob.BookNo+"','"
				+ob.Name+"','"
				+ob.Publiser+"','"
				+ob.Writer+"','"
				+ob.Price+"','"
				+ob.Indate+"','"
				+ob.BookType+"')";
		
		DbHelper.executeUpdate(sql);
		
	}
	/**
	 * 删除一个学生学籍信息的服务器端操作
	 * @param ob
	 * 图书的标号
	 */
	public static void delBook(String ob) throws SQLException {//delete    book
		// TODO Auto-generated method stub
		String sql = "delete from tbBookInfo where BookNo = '"+ob+"'";
		DbHelper.executeUpdate(sql);
	}
	public static void addBookRent(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}
	public static void deletebookrent(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
		
	}
	public static Vector getBookRent(String ob) {
		return DbHelper.executeQuery(ob);	
	}
	
}
