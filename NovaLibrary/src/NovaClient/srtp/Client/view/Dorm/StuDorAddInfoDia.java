package seu.Client.view.Dorm;



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

import seu.Client.bz.impl.StudentDorInfoImpl;


/**
 * 宿舍模块增加信息对话框
 * @author kidd
 *
 */


public class StuDorAddInfoDia extends JDialog {
	
	JLabel jlID, jlName,jlCollege, jlAge, jlSex, jlBed, jlDepart, jlGrade,jlRecord;
	JTextField jtfID, jtfName,jtfCollege,jtfAge, jtfSex,jtfBed, jtfDepart, jtfGrade,jtfRecord;
	JButton jbOK, jbCancel;
	JPanel jp1, jp2;
	
	public StuDorAddInfoDia(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		//SocketHelper.getConnection();

		buildWidgets();
		setProperties();
	}

	private void buildWidgets() {
		

		
		jlID=new JLabel("学号",JLabel.CENTER);
		jlCollege=new JLabel("学院",JLabel.CENTER);
		jlName=new JLabel("姓名",JLabel.CENTER);
		jlSex=new JLabel("性别",JLabel.CENTER);
		jlAge=new JLabel("出生年月",JLabel.CENTER);
		jlDepart=new JLabel("宿舍号",JLabel.CENTER);
		jlBed=new JLabel("床位号",JLabel.CENTER);
		jlGrade=new JLabel("卫生成绩",JLabel.CENTER);
		jlRecord=new JLabel("违章记录",JLabel.CENTER);

		jbOK = new JButton("确认");
		jbCancel = new JButton("取消");
		jbOK.addActionListener(new Listener());
		jbCancel.addActionListener(new Listener());

		jtfID = new JTextField();
		jtfName = new JTextField();
		jtfCollege =new JTextField();
		jtfAge = new JTextField();
		jtfSex =new JTextField();
		jtfDepart = new JTextField();
		jtfBed = new JTextField();
		jtfGrade = new JTextField();
		jtfRecord=new JTextField();

		
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
		jp1.add(jlDepart);
		jp1.add(jtfDepart);
		jp1.add(jlBed);
		jp1.add(jtfBed);
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

	public void doOk(){
			//throws SQLException {
		if (isQualified()) {
		//	DormitoryINFO dormi = new DormitoryINFO();
		  //  dormi.StuAdd(getStuInfo());
			StudentDorInfoImpl.StuAdd(getStuInfo());
			this.dispose();
		}
	}
	//}

	public void doCancel() {
		this.dispose();
	}

	private Vector<String> getStuInfo() {
		Vector<String> stu = new Vector<String>();

		stu.add(jtfID.getText());
		stu.add(jtfName.getText());
		stu.add(jtfSex.getText());
		stu.add(jtfCollege.getText());
		stu.add(jtfAge.getText());
		stu.add(jtfDepart.getText());
		stu.add(jtfBed.getText());
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
