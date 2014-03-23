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

public class StuDorChaInfoDia2 extends JDialog{
	
	JLabel jlstu,jldepart,jlbed ;
	JButton jbOK,jbCancel;
	JTextField jtfstu,jtfdepart,jtfbed ;
	JPanel jp1,jp2;
	
	StuDorChaInfoDia2(Frame owner, String title, boolean modal){
		super(owner, title, modal);
		//SocketHelper.getConnection();
		buildWidgets();
		setProperties();
	}

	

	private void buildWidgets() {
		// TODO Auto-generated method stub
		    jlstu=new JLabel("学生学号",JLabel.CENTER);
		    jtfstu = new JTextField();
		    jldepart=new JLabel("迁往宿舍号",JLabel.CENTER);
		    jtfdepart=new JTextField();
		    jlbed=new JLabel("迁往床号",JLabel.CENTER);
		    jtfbed=new JTextField();
			jbOK = new JButton("确认");
			jbCancel = new JButton("取消");
			jbOK.addActionListener(new Listener());
			jbCancel.addActionListener(new Listener());

			jp1 = new JPanel(new GridLayout(3, 2, 10, 10));
			jp1.add(jlstu);
			jp1.add(jtfstu);
			jp1.add(jldepart);
			jp1.add(jtfdepart);
			jp1.add(jlbed);
			jp1.add(jtfbed);
			

			jp2 = new JPanel();
			jp2.add(jbOK);
			jp2.add(jbCancel);

			this.add(jp1, "North");
			this.add(jp2, "South");
	}
	private void setProperties() {
		// TODO Auto-generated method stub
		this.setResizable(false);
		this.setLocationRelativeTo(null); // 居中
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(200, 200);
		this.setVisible(true);

	}
	private void doCancel() {
		// TODO Auto-generated method stub
		this.dispose();
	}

	private void doOk() {
		
        if(StudentDorInfoImpl.StuDorCha(jtfstu.getText(),jtfdepart.getText(),jtfbed.getText()).equals("NO")){
        JOptionPane.showMessageDialog(null, "该位子已有人，请重新选择");
        }
			this.dispose();
		
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jbOK) {
				doOk();
			} else if (e.getSource() == jbCancel) {
				doCancel();
			}
		}

	}

		
	}




