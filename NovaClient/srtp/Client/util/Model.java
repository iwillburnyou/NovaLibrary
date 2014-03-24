/**
 * ģ���࣬ͨ��setCol()����ʵ�ֶԾ���ģ�͵Ĺ���
 */
package seu.Client.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

import k.MessageType;


public class Model extends AbstractTableModel implements MessageType {

	private static final long serialVersionUID = 1L;
	public static Vector rowData, columnNames;
	public ObjectInputStream is;
	public ObjectOutputStream os;
	Vector vec = null;

	/**
	 * Model�Ĺ��캯�� ͬʱִ�в�ͬ��Ĳ�ѯ���� ����type�ж��������ѯ
	 * 
	 * @param type
	 *            �ǻ��ȫ������������ѯ
	 * @param key
	 *            Ҫ��ѯ���ֶ�
	 */
	@SuppressWarnings("unchecked")	
	public Model(int type, String key) {
		this.is = SocketHelper.getIs();
		this.os = SocketHelper.getOs();
		columnNames = new Vector();
		
		rowData = new Vector();

		try {
			os.writeInt(type);
			os.flush();

			if (type % 10 != 0) {// Inquiry
				os.writeUTF(key);
				os.flush();
			}

			vec = (Vector) is.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < vec.size(); i++) {
			rowData.add(vec.get(i));
		}

	}
	public Model(){
		columnNames = new Vector();
		rowData = new Vector();
	}

	/**
	 * Model�Ĺ��캯�� ͬʱִ�в�ͬ��Ĳ�ѯ���� ����type�ж��������ѯ
	 * 
	 * @param type
	 *            �ǻ��ȫ������������ѯ
	 * @param key1
	 *            Ҫ��ѯ���ֶ�1
	 * @param key2
	 *            Ҫ��ѯ���ֶ�2
	 */
	@SuppressWarnings("unchecked")
	public Model(int type, String key1, String key2) {
		this.is = SocketHelper.getIs();
		this.os = SocketHelper.getOs();

		columnNames = new Vector();
		rowData = new Vector();

		try {
			os.writeInt(type);
			os.flush();

			if (type % 10 != 0) {// Inquiry
				os.writeUTF(key1);
				os.flush();
				os.writeUTF(key2);
				os.flush();
			}

			vec = (Vector) is.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < vec.size(); i++) {
			rowData.add(vec.get(i));
		}

	}

	@Override
	public String getColumnName(int arg0) {

		return (String) Model.columnNames.get(arg0);
	}


	public int getRowCount() {

		return Model.rowData.size();
	}

	@SuppressWarnings("unchecked")
	public Object getValueAt(int arg0, int arg1) {

		return ((Vector) Model.rowData.get(arg0)).get(arg1);
	}

	public int getColumnCount() {

		return Model.columnNames.size();
	}
}
