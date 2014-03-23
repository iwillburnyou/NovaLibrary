package seu.Client.view.Dorm;

//import DbHelper;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import seu.Client.bz.impl.StudentDorInfoImpl;

//import StuChaDialog.ChaDialog;
/**
 * 宿舍模块更改信息对话框
 * @author kidd
 *
 */


public class StuDorChaInfoDia1 extends JDialog {
	private static final long serialVersionUID = 1L;

	JLabel jlID;
	static JTextField jtfIDcha;
	JButton jbOK, jbCancel;
	JPanel jp1, jp2;

	public StuDorChaInfoDia1(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		// SocketHelper.getConnection();

		buildWidgets();
		setProperties();
	}

	private void buildWidgets() {

		jlID = new JLabel("学生学号", JLabel.CENTER);

		jbOK = new JButton("确认");
		jbCancel = new JButton("取消");
		jbOK.addActionListener(new Listener());
		jbCancel.addActionListener(new Listener());

		jtfIDcha = new JTextField();

		jp1 = new JPanel(new GridLayout(1, 2, 10, 10));
		jp1.add(jlID);
		jp1.add(jtfIDcha);

		jp2 = new JPanel();
		jp2.add(jbOK);
		jp2.add(jbCancel);

		this.add(jp1, "North");
		this.add(jp2, "South");

	}

	private void setProperties() {

		this.setResizable(false);
		this.setLocationRelativeTo(null); // 居中
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(200, 200);
		this.setVisible(true);
	}

	// 对按钮事件的响应
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jbOK) {
				doOk();
			} else if (e.getSource() == jbCancel) {
				doCancel();
			}
		}
	}

	public void doOk() {
		System.out.println("do ok");

		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				Vector<?> vec = StudentDorInfoImpl.StuChaBasic(jtfIDcha
						.getText());
				if(vec.size()==0){
					JOptionPane.showMessageDialog(null, "查无此人");
				}
				else{
				ChaDialog cha = new ChaDialog(null, "修改信息",
						rootPaneCheckingEnabled, vec);
				cha.jtfID.setText((String) ((Vector<?>) vec.get(0)).get(1));
				//System.out.println("edit text");
				cha.jtfName.setText((String) ((Vector<?>) vec.get(0)).get(2));
				cha.jtfCollege.setText((String) ((Vector<?>) vec.get(0)).get(4));
				cha.jtfAge.setText((String) ((Vector<?>) vec.get(0)).get(5));
				cha.jtfSex.setText((String) ((Vector<?>) vec.get(0)).get(3));
				cha.jtfGrade.setText((String) ((Vector<?>) vec.get(0)).get(8));
				cha.jtfRecord.setText((String) ((Vector<?>) vec.get(0)).get(9));
			}
			}
		});
		// System.out.println("hehe");

		this.dispose();
	}

	//

	public void doCancel() {
		this.dispose();
	}

	//

	private boolean isQualified() {

		return rootPaneCheckingEnabled;

	}

	// 修改信息内部类
	private class ChaDialog extends JDialog {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JLabel jlID, jlName, jlCollege, jlAge, jlSex, jlBed, jlDepart, jlGrade,
				jlRecord;
		JTextField jtfID;
		JTextField jtfName;
		JTextField jtfCollege;
		JTextField jtfAge;
		JTextField jtfSex;
		JTextField jtfBed;
		JTextField jtfDepart;
		JTextField jtfGrade;
		JTextField jtfRecord;
		JButton jbOK, jbCancel;
		JPanel jp1, jp2;

		public ChaDialog(Frame owner, String title, boolean modal) {
			super(owner, title, modal);
			// SocketHelper.getConnection();
			// SocketHelper.getConnection();
			System.out.println("buildWidgets");
			buildWidgets();
			System.out.println("setProperties");
			setProperties();
			System.out.println("constructor over");
		}

		public ChaDialog(Object object, String string,
				boolean rootPaneCheckingEnabled, Vector<?> vec) {
			// TODO Auto-generated constructor stub
			this((Frame) object, string, rootPaneCheckingEnabled);
			jtfID.setText((String) ((Vector<?>) vec.get(0)).get(1));
			jtfName.setText((String) ((Vector<?>) vec.get(0)).get(2));
			jtfCollege.setText((String) ((Vector<?>) vec.get(0)).get(4));
			jtfAge.setText((String) ((Vector<?>) vec.get(0)).get(5));
			jtfSex.setText((String) ((Vector<?>) vec.get(0)).get(3));
			jtfGrade.setText((String) ((Vector<?>) vec.get(0)).get(8));
			jtfRecord.setText((String) ((Vector<?>) vec.get(0)).get(9));
			setVisible(true);

		}

		private void buildWidgets() {

			jlID = new JLabel("学号", JLabel.CENTER);
			jlCollege = new JLabel("学院", JLabel.CENTER);
			jlName = new JLabel("姓名", JLabel.CENTER);
			jlSex = new JLabel("性别", JLabel.CENTER);
			jlAge = new JLabel("出生年月", JLabel.CENTER);
			jlGrade = new JLabel("卫生成绩", JLabel.CENTER);
			jlRecord = new JLabel("违章记录", JLabel.CENTER);

			jbOK = new JButton("确认");
			jbCancel = new JButton("取消");
			jbOK.addActionListener(new Listener());
			jbCancel.addActionListener(new Listener());

			jtfID = new JTextField();
			jtfName = new JTextField();
			jtfCollege = new JTextField();
			jtfAge = new JTextField();
			jtfSex = new JTextField();
			jtfDepart = new JTextField();
			jtfBed = new JTextField();
			jtfGrade = new JTextField();
			jtfRecord = new JTextField();

			jp1 = new JPanel(new GridLayout(9, 2, 10, 10));
			jp1.add(jlID);
			jp1.add(jtfID);
			jp1.add(jlName);
			jp1.add(jtfName);
			jp1.add(jlCollege);
			jp1.add(jtfCollege);
			jp1.add(jlAge);
			jp1.add(jtfAge);
			jp1.add(jlSex);
			jp1.add(jtfSex);
			jp1.add(jlGrade);
			jp1.add(jtfGrade);
			jp1.add(jlRecord);
			jp1.add(jtfRecord);

			jp2 = new JPanel();
			jp2.add(jbOK);
			jp2.add(jbCancel);

			this.add(jp1, "North");
			this.add(jp2, "South");

		}

		private void setProperties() {

			this.setResizable(false);
			this.setLocationRelativeTo(null); // 居中
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setSize(200, 400);
			
			//this.setVisible(true);
			System.out.println("setProperties over");
		}

		// 对按钮事件的响应
		private class Listener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jbOK) {
					doOk();
				} else if (e.getSource() == jbCancel) {
					doCancel();
				}
			}
		}

		public void doOk() {
			// throws SQLException {
			if (isQualified()) {
				
				StudentDorInfoImpl.StuCha(getStuInfo(), jtfIDcha.getText());

				this.dispose();
			}
		}

		// }

		public void doCancel() {
			this.dispose();
		}

		public Vector<String> getStuInfo() {
			Vector<String> stu = new Vector<String>();

			stu.add(jtfID.getText());
			stu.add(jtfName.getText());
			stu.add(jtfSex.getText());
			stu.add(jtfCollege.getText());
			stu.add(jtfAge.getText());
			stu.add(jtfGrade.getText());
			stu.add(jtfRecord.getText());

			return stu;
		}

		private boolean isQualified() {
			Vector<String> vec = getStuInfo();

			for (int i = 1; i < vec.size(); i++) {
				if (vec.get(i).equals("")) {
					JOptionPane.showMessageDialog(null, "有未录入项目，请重新输入");
					return false;
				}
			}
			return true;
		}
	}
}
