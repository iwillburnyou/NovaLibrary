package seu.Client.view;

import java.awt.Color;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import seu.Client.bz.impl.CommonImpl;
import seu.Client.bz.impl.ISubjseleImpl;


/**
 * 选课模块显示所有课程信息的界面
 * @author kidd
 *
 */
public class allCurriculum extends JFrame  {
	
	private JTable table;
	
	public allCurriculum()
	{
		super("allCurriculum");
		this.setBounds(300,240,650,200);
		this.setBackground(java.awt.Color.lightGray);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel panel =new JPanel();
		this.getContentPane().add(panel,"North");
		System.out.print(1);
		setallCurriculum();
		this.getContentPane().add(new JScrollPane(table));
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
		this.setVisible(true);
	
	}

	public void setallCurriculum() {
		// TODO Auto-generated method stub
	
		   Vector titles = new Vector<String>();
		   {titles.add("课程编号");titles.add("课程信息");titles.add("任课老师");titles.add("课时");titles.add("学分");titles.add("课程类型");};	

			String sql="select * from SubjInfo";
		   
		    Vector v=ISubjseleImpl.getAllCur(sql); 
		   System.out.print(((Vector)v.get(0)).get(0));
		   table=new JTable(v,titles);
		   table.setBackground(Color.white);
		   table.setRowHeight(25);
		   table.setGridColor(Color.blue);
		  
	}
	    
//	public static void main(String[] args) {
//		allCurriculum sc=new allCurriculum();}
}