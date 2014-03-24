package seu.Client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import seu.Client.bz.impl.CommonImpl;
import seu.Client.bz.impl.ISubjseleImpl;
import k.User;

public class stuCurriculum extends JFrame  {
	private static final String DbHelper = null;
	private JTextField userField;
	private JButton checkButton=new JButton("查询课表");
	private JTable table;
	User user;
	
	public stuCurriculum(User user1)
	{
		super("stuCurriculum of " /*+UserAdministration.k1.getText()+""*/);
		user= user1;
		this.setBounds(300,240,740,400);
		this.setBackground(java.awt.Color.lightGray);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel panel =new JPanel();
		this.getContentPane().add(panel,"North");
		setstuCurriculum();
		this.getContentPane().add(new JScrollPane(table));
		this.setVisible(true);
	
	}

	public void setstuCurriculum() {
		// TODO Auto-generated method stub
	
		   Vector titles = new Vector<String>();
		   {titles.add("课程编号");titles.add("课程信息");titles.add("任课老师");titles.add("课时");titles.add("学分");};	

			String sql="select * from " +user.getCardNo()+"";
		
			Vector v=ISubjseleImpl.getStuCur(sql);
		   // Vector v=DbHelper.executeQuery(sql); 
		   
		    table=new JTable(v,titles);
		  
	}
	    
	//public static void main(String[] args) {
	//	stuCurriculum sc=new stuCurriculum();}
}
