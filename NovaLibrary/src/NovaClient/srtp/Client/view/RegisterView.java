package seu.Client.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import javax.swing.border.*;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import seu.Client.bz.impl.LoginImpl;
/**
 * 登录模块注册界面
 * @author kidd
 *
 */
public class RegisterView extends JDialog {
	private ImageIcon background;
	

	public RegisterView()  {
		
		this.setUndecorated(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//关闭
		this.jbInit();
		this.setTitle("注册用户");
		this.setSize(376,520);
		this.setLocation(420, 75);
		this.setVisible(true);
		
	}
	
	private void jbInit() {
		
		JPanel panel1=new JPanel();
		ImageIcon background = new ImageIcon(this.getClass().getResource("/image/注册1.png")); 
        JLabel label = new JLabel(background); 
        //label.setBounds(0, 0, this.getWidth(), this.getHeight()); 
		panel1.setOpaque(false); 
	
		final JTextField jtextfield1=new JTextField ("");
		jtextfield1.setBorder(BorderFactory.createLoweredBevelBorder()); 
		//jtextfield1.setForeground(Color.BLUE);
		final JPasswordField jPassword1=new JPasswordField ("");
		 jPassword1.setBorder(BorderFactory.createLoweredBevelBorder()); 
		//jtextfield2.setForeground(Color.BLUE);
		final JPasswordField jPassword2=new JPasswordField ("");
		jPassword2.setBorder(BorderFactory.createLoweredBevelBorder()); 
		//jtextfield3.setForeground(Color.BLUE);
		final JTextField jtextfield4=new JTextField ("");
		jtextfield4.setBorder(BorderFactory.createLoweredBevelBorder()); 
		//jtextfield4.setForeground(Color.BLUE);
		final JTextField jtextfield5=new JTextField ("");
		jtextfield5.setBorder(BorderFactory.createLoweredBevelBorder()); 
		//jtextfield5.setForeground(Color.BLUE);
		final JTextField jtextfield6=new JTextField ("");
		jtextfield6.setBorder(BorderFactory.createLoweredBevelBorder()); 
		//jtextfield6.setForeground(Color.BLUE);
		String []str ={"学生","管理员"};
		final JComboBox jcb = new JComboBox(str);
		jcb.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel jlabel1=new JLabel();
		JLabel jlabel2=new JLabel();
		JLabel jlabel3=new JLabel();
		JLabel jlabel4=new JLabel();
		JLabel jlabel5=new JLabel();
		JLabel jlabel6=new JLabel();
		JLabel jlabel7=new JLabel();
		
		JButton jbutton1=new JButton();
	
		Icon generl1=new ImageIcon (this.getClass().getResource("/image/bb1.png"));
		Icon press1=new ImageIcon(this.getClass().getResource("/image/bb2.png"));
		Icon rollover1=new ImageIcon(this.getClass().getResource("/image/bb3.png"));
		jbutton1.setRolloverEnabled(true);
		jbutton1.setIcon(generl1);
		jbutton1.setRolloverIcon(rollover1);
		jbutton1.setPressedIcon(press1);
		jbutton1.setContentAreaFilled(false);
		jbutton1.setBorderPainted(false);
		
		JLabel closeButton=new JLabel("X");
		closeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event){
				dispose();
				}
			 });
		
		panel1.setLayout(null);
		jtextfield1.setBounds(155,80,170,20);
		jPassword1.setBounds(155,140,170,20);
		jPassword2.setBounds(155,200,170,20);
		jtextfield4.setBounds(155,260,170,20);
		jtextfield5.setBounds(155,320,170,20);
		//jtextfield6.setBounds(160,380,170,20);
		jcb.setBounds(155,380,170,20);
			
		jlabel1.setText("一 卡 通");
		jlabel1.setForeground(Color.BLACK) ;
		Font font1 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,13);
		jlabel1.setFont(font1);
		jlabel1.setBounds(55,83,150,15);
		
		jlabel2.setText("密          码");
		jlabel2.setForeground(Color.BLACK) ;
		Font font2 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,13);
		jlabel2.setBounds(55,143,150,15);
		
		jlabel3.setText("确认密码");
		jlabel3.setForeground(Color.BLACK) ;
		Font font3 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,13);
		jlabel3.setFont(font3);
		jlabel3.setBounds(55,203,150,15);
		
		jlabel4.setText("学    号");
		jlabel4.setForeground(Color.BLACK) ;
		Font font4 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,13);
		jlabel4.setFont(font4);
		jlabel4.setBounds(55,263,150,15);
		
		jlabel5.setText("姓    名");
		jlabel5.setForeground(Color.BLACK) ;
		Font font5 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,13);
		jlabel5.setFont(font5);
		jlabel5.setBounds(55,323,150,15);
		
		//jlabel6.setText("身 份 证");
		//jlabel6.setForeground(Color.BLACK) ;
		//Font font6 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,13);
		//jlabel6.setFont(font1);
		//jlabel6.setBounds(60,383,150,15);
		
		jlabel7.setText("身    份  ");
		jlabel7.setForeground(Color.BLACK) ;
		Font font7 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,13);
		jlabel7.setFont(font1);
		jlabel7.setBounds(55,383,150,15);	
		
		jbutton1.setText("注册");
		jbutton1.setForeground(Color.BLACK) ;
		Font font8 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,13);
		jbutton1.setFont(font8);
		jbutton1.setBounds(125,450,150,50);
		closeButton.setBounds(340,15,50,50);
		
		label.setBounds(-65,-90,500,700);//背景

		this.setBounds(0,0, 376, 524);
		this.add(jlabel7);
		this.add(jlabel6);
		this.add(jlabel5);
		this.add(jlabel4);
		this.add(jlabel3);
		this.add(jlabel2);
		this.add(jlabel1);
		this.add(jbutton1);
		this.add(closeButton);
		//this.add(jtextfield6);
		this.add(jtextfield5);
		this.add(jtextfield4);
		this.add(jPassword1);
		this.add(jPassword2);
		this.add(jtextfield1);
		this.add(label);
		this.add(jcb);
		this.add(panel1);//背景
		
	
		
		jbutton1.addActionListener(new ActionListener()
		   {
			 public void actionPerformed(ActionEvent Event)
		 	{
			
				String stuCard = jtextfield1.getText().trim();
				String password = jPassword1.getText().trim();
				String passwordagain = jPassword2.getText().trim();
				String StuNum = jtextfield4.getText().trim();
				String name = jtextfield5.getText().trim();
				String IDNum = jtextfield6.getText().trim();
				String roleString = (String) jcb.getSelectedItem();
				
				if(stuCard.equals("")||password.equals("")||passwordagain.equals("")||StuNum.equals("")||name.equals("")||roleString.equals("")){
					JOptionPane.showMessageDialog(null, "亲，注册表任一项不能为空！", "出错啦!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				else {
					if(password.equals(passwordagain)){
						String sql = "insert into tblUserManager values('"+stuCard+"','"+password+"','"+StuNum+"','"+name+"','"+roleString+"')";
						LoginImpl.registerNew(sql);
						JOptionPane.showMessageDialog(null, "注册成功！", "信息", JOptionPane.INFORMATION_MESSAGE);
						jtextfield1.setText("");
						jPassword1.setText("");
				    	jPassword2.setText("");
				    	jtextfield4.setText("");
				    	jtextfield5.setText("");
				    	jtextfield6.setText("");
				    	dispose();
					}
			   
			    //密码不匹配监听
					else 
					{
						JOptionPane.showMessageDialog(null, "亲，清确认您两次输入的的密码是否相同！", "出错啦!", JOptionPane.INFORMATION_MESSAGE);
					    return;
					}
				}
				
				}
			 
		   });
		
		
	}
	    public void paintComponent(Graphics g) { 
		g.drawImage(background.getImage(), 0, 0,this);   
		super.paintComponents(g); 
	}

	
}

		


