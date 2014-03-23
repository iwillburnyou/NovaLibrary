/**
 * 修改课程对话框
 */
package seu.Client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import seu.Client.bz.impl.ISubjseleImpl;


import k.MessageType;

/**
 * 选课模块编辑一门课程的对话框
 * @author kidd
 *
 */
public class SubModifyCourseDialog extends JDialog implements ActionListener,
MessageType{



	JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	JButton jb1, jb2;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5;
	JComboBox<String> jcb6;
	JPanel jp;
	private ImageIcon background;
	Font font = new Font("微软雅黑", Font.ROMAN_BASELINE, 18);
	// 构造函数
	public SubModifyCourseDialog() {
		//super(arg0, arg1, arg2);

		background = new ImageIcon(this.getClass().getResource("/image/选课对话框.jpg"));// 背景图片
     	JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
     	label.setBounds(0,0, background.getIconWidth(),background.getIconHeight());// 把标签的大小位置设置为图片刚好填充整个面板
     	// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
     	jp = (JPanel) this.getContentPane();
     	this.getLayeredPane().setLayout(null);
     	jp.setOpaque(false);
     	// 内容窗格默认的布局管理器为BorderLayout
     	jp.setLayout(null);
     	
		jl1 = new JLabel("课程编号:", JLabel.CENTER);
		jl1.setFont(font);
		jl1.setForeground(Color.white);
		jl1.setBounds(10, 30, 100, 25);
		jp.add(jl1);
		
		jl2 = new JLabel("课程名称:", JLabel.CENTER);
		jl2.setFont(font);
		jl2.setForeground(Color.white);
		jl2.setBounds(10, 70, 100, 25);
		jp.add(jl2);
		
		jl3 = new JLabel("任课老师:", JLabel.CENTER);
		jl3.setFont(font);
		jl3.setForeground(Color.white);
		jl3.setBounds(10, 110, 100, 25);
		jp.add(jl3);
		
		jl4 = new JLabel("课时:", JLabel.CENTER);
		jl4.setFont(font);
		jl4.setFont(font);
		jl4.setForeground(Color.white);
		jl4.setBounds(10, 150, 100, 25);
		jp.add(jl4);
		
		jl5 = new JLabel("学分:", JLabel.CENTER);
		jl5.setFont(font);
		jl5.setForeground(Color.white);
		jl5.setBounds(10, 190, 100, 25);
		jp.add(jl5);
		
		jl6 = new JLabel("课程类型:", JLabel.CENTER);
		jl6.setFont(font);
		jl6.setForeground(Color.white);
		jl6.setBounds(10, 230, 100, 25);
		jp.add(jl6);
		
		jtf1 = new JTextField();
		jtf1.setBounds(110, 30, 180, 25);
		jp.add(jtf1);
		jtf2 = new JTextField();
		jtf2.setBounds(110, 70, 180, 25);
		jp.add(jtf2);
		jtf3 = new JTextField();
		jtf3.setBounds(110, 110, 180, 25);
		jp.add(jtf3);
		jtf4 = new JTextField();
		jtf4.setBounds(110, 150, 180, 25);
		jp.add(jtf4);
		jtf5 = new JTextField();
		jtf5.setBounds(110, 190, 180, 25);
		jp.add(jtf5);

		String[] type = { "数学", "物理", "英语", "体育", "计算机基础", "人文", "经济",
				"自然科学" };
		jcb6 = new JComboBox<String>(type);
		jcb6.setOpaque(false);
		jcb6.setBackground(Color.white);

		jcb6.setBounds(110, 230, 180, 25);
		jp.add(jcb6);

		jb1 = new JButton("确认修改");
		jb1.setFont(font);
		jb1.setForeground(Color.white);
		jb1.setBounds(30, 300, 120, 30);
		jb1.setBorderPainted(false);
		jb1.setContentAreaFilled(false);
		jb1.setOpaque(false);
		jb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jp.add(jb1);
		jb1.addActionListener(this);
		
		jb2 = new JButton("取消修改");
		jb2.setFont(font);
		jb2.setForeground(Color.white);
		jb2.setBounds(150, 300, 120, 30);
		jb2.setBorderPainted(false);
		jb2.setContentAreaFilled(false);
		jb2.setOpaque(false);
		jb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jp.add(jb2);
		jb2.addActionListener(this);

		 this.getLayeredPane().setLayout(null);
	    // 把背景图片添加到分层窗格的最底层作为背景
	    this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	   // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(background.getIconWidth(), background.getIconHeight());
	    this.setUndecorated(true);
	    this.setLocation(500, 200);
		this.setVisible(true);
		
    	try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	



	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)	{
			String sql;
	    sql="update  SubjInfo set 课程信息='"+jtf2.getText()+"',任课老师='"+jtf3.getText()+"',课时='"+jtf4.getText()+"',学分='"+jtf5.getText()+"',课程编号='"+jtf1.getText()+"' where 课程类型='"+jcb6.getSelectedItem()+"'";
	    ISubjseleImpl.modSubj(sql);
	    JOptionPane.showMessageDialog(null, "修改成功！");
	    this.dispose();
		/*try {
			DbHelper.executeUpdate(sql);
		} catch (SQLException c) {
			// TODO Auto-generated catch block
			c.printStackTrace();
		}*/
		
	}
	if(e.getSource()==jb2){
		this.setVisible(false);
			}
	}

    public static void main(String[] args) {
   	 SubModifyCourseDialog f1=new SubModifyCourseDialog();}

}
