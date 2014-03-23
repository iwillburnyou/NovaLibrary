/**
 * ���ܣ���װ�����ݿ�������Լ������ݿ�Ĳ���
 */
package seu.server.dao;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.Vector;



import sun.misc.IOUtils;



/**
 * �������ݿ�İ����࣬����odbc�Ž��������·���µ����ݿ� MydateBase.mdb
 * @author ��һ��
 */
public class DbHelper {
	//private static UserReader ur = new UserReader(); // �����࣬���ڴ��ļ���ȡ��������ݿ���û���������
	public static void main(String[] args) {
		System.out.println(getConnection());
		close();
	}
	private static final String DB_DRIVER_NAME = "sun.jdbc.odbc.JdbcOdbcDriver";
//	private static final String DB_PWD = ur.getUserPwd(); // �������ݿ������
//	private static final String DB_UNAME = ur.getUserName(); // �������ݿ���ʺ�
	private static  String url;
	public static String dbpath = "";
	public static Connection conn = null;
	private static Statement stt = null;
	private static ResultSet result = null;

	public DbHelper() {
		
	}

	/**
	 * ��ȡ�������ݿ��Connection
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		try {
			// ��������
			Class.forName(DB_DRIVER_NAME);
			
//			File tempDir = new File(System.getProperty("java.io.tmpdir"));
//			File temporaryFile = new File(tempDir, "my.mdb");
//			InputStream templateStream = DbHelper.class.getResourceAsStream("db/my.mdbt");
//			IOUtils.copy(templateStream, new FileOutputStream(temporaryFile));
//			String absolutePath = temporaryFile.getAbsolutePath();
			URL u = new DbHelper().getClass().getProtectionDomain().getCodeSource().getLocation();
			
			
			try {
				dbpath = u.toURI().getPath();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//dbpath = dbpath.replace("server.jar", "datebase/");
			dbpath = dbpath.replace("CampusServer/", "datebase/");
			dbpath+="MyDateBase.mdb";
			dbpath = dbpath.substring(1);
			System.out.println(dbpath);
			//String dbpath = new File("").getAbsolutePath().replace('\\', '/') + "/MyDateBase.mdb";
			// �������
			url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+dbpath;
			conn = DriverManager.getConnection(url, "", null);
			conn.setAutoCommit(true);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	/**
	 * ִ�и������ݿ����
	 * 
	 * @param sql
	 *            ���ݿ�����������
	 * 
	 * @return �Ƿ�����ɹ�
	 * @throws SQLException 
	 */
	public static boolean executeUpdate(String sql) {
		
			getConnection();
			System.out.println("executeUpdate\n"+sql);
			try {
				stt = conn.createStatement();
				stt.executeUpdate(sql);
				System.out.println("update talbe!");
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			finally{
				close();
			}
			
			
			
			
	}
	/**
	 * ִ�в�ѯ����
	 * 
	 * @param sql
	 *            ���ݿ�����������
	 * 
	 * @return ���ش���н���������ݵ�vector ,���Ǹ���ά����
	 */
	public static Vector executeQuery(String sql) {
		System.out.println("executeQuery\n"+sql);
		Vector rowData = new Vector();
		try {
			getConnection();
			stt = conn.createStatement();
			result = stt.executeQuery(sql);
			ResultSetMetaData rsmd = result.getMetaData();

			while (result.next()) {
				Vector record = new Vector();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					record.add(result.getString(i));
				}
				rowData.add(record);
			}
			return rowData;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rowData;
	}

	/**
	 * �ر�����
	 */
	public static void close() {
		try {
			if (result!=null ) {
				
					result.close();
					result = null;
		
			}
				
			if (stt!=null )
				stt.close();
			if (conn!=null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
