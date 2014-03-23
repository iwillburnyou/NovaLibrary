/**
 * 选课对话框
 */
package seu.Client.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

import seu.Client.bz.impl.ISubjseleImpl;
import seu.Client.util.SubjectAttribution;
import seu.Client.vo.Subject;

import k.MessageType;


/**
 * 选课模块显示所有已经选择课程的对话框
 * @author kidd
 *
 */
public  class SubjectSelectDialog extends JDialog implements MessageType {

	private static final long serialVersionUID = 1L;
	private static final int INQUIRY_COURSE_BY_TYPE = 0;
	SubjectAttribution cm = null;
	ISubjseleImpl isub;
	Subject mCourse = null;
	TableRowSorter<?> trs = null;
	// 顶部面板
	private JPanel jpTop = new JPanel();
	private JButton jbElect = new JButton("选择");
	private JButton jbQuit = new JButton("退出");
	// 课程信息面板
	private JScrollPane jsp;
	private JTable jt = new JTable();
	private String type;

	boolean OK = false; // 成员变量，标记是否确认选择课程

	public boolean isOK() {
		return OK;
	}

	public void setOK(boolean oK) {
		OK = oK;
	}

	public SubjectSelectDialog(/*Frame arg0, String arg1, boolean arg2,
			String type*/) {
		/*super(arg0, arg1, arg2);*/
		try {
			isub = new ISubjseleImpl();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.type = type;
		setTopPanel();
		setMainPanel();
		setListeners();
		buildWidgets();
		setProperties();
	}

	private void setProperties() {
		this.setBounds(200, 50, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	private void buildWidgets() {
		this.setLayout(new BorderLayout());
		this.add(jpTop, BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
	}

	private void setMainPanel() {

		jsp = new JScrollPane(jt);
		jsp.getVerticalScrollBar().setUnitIncrement(10);
		cm = new SubjectAttribution(INQUIRY_COURSE_BY_TYPE, type);
		jt.setModel(cm);
		trs = new TableRowSorter<SubjectAttribution>(cm);
		jt.setRowSorter(trs);
	}

	private void setTopPanel() {
		jpTop.setLayout(new FlowLayout());
		jpTop.add(jbElect);
		jpTop.add(jbQuit);
	}

	private void setListeners() {
		jbElect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 监听按钮“选择”
			//	doSelect();
			}
		});

		jbQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	doQuit();
			}
		});
	}

	/**
	 * 获得当前选中的课程
	 * 
	 * @return Course
	 */


	protected void doQuit() {
		this.setOK(false);
		this.dispose();
	}

	
	
}
