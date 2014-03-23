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
 * ����ģ��������Ϣ�Ի���
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
		

		
		jlID=new JLabel("ѧ��",JLabel.CENTER);
		jlCollege=new JLabel("ѧԺ",JLabel.CENTER);
		jlName=new JLabel("����",JLabel.CENTER);
		jlSex=new JLabel("�Ա�",JLabel.CENTER);
		jlAge=new JLabel("��������",JLabel.CENTER);
		jlDepart=new JLabel("�����",JLabel.CENTER);
		jlBed=new JLabel("��λ��",JLabel.CENTER);
		jlGrade=new JLabel("�����ɼ�",JLabel.CENTER);
		jlRecord=new JLabel("Υ�¼�¼",JLabel.CENTER);

		jbOK = new JButton("ȷ��");
		jbCancel = new JButton("ȡ��");
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
		this.setLocationRelativeTo(null); // ����
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(200, 400);
		this.setVisible(true);
	}

	// �԰�ť�¼�����Ӧ
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
				JOptionPane.showMessageDialog(null, "��δ¼����Ŀ������������");
				return false;
			}
		}
		return true;
	}

}
