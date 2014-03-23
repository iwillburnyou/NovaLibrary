package seu.Client.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.IOException;
import java.net.UnknownHostException;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import k.User;


import seu.Client.bz.impl.CommonImpl;
import seu.Client.bz.impl.LoginImpl;

/**
 * 登陆模块登陆主界面
 * @author kidd
 *
 */
public class ClauseLogin extends JFrame
{
	private ImageIcon background;
	static Statement stmt = null;
	static Connection con = null;
	static ResultSet rs = null;
	User user;


	
	public ClauseLogin() {
		user = new User();
		this.setUndecorated(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//关闭
		this.jbInit();
		this.setTitle("登录");
		this.setSize(630,328);
		this.setLocation(320, 140);	   
		this.setVisible(true);
		//this.setUndecorated(true);	
		try {
			CommonImpl.initSocket();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println(1);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "无法连接至服务器，请重启！");
			System.exit(0);
		}
	}
	
	
	private void jbInit() {
		
		JPanel panel1=new JPanel();
		ImageIcon background = new ImageIcon(this.getClass().getResource("/image/Background2.png")); 
        JLabel label = new JLabel(background); 
        label.setBounds(0, 0, this.getWidth(), this.getHeight()); 
		panel1.setOpaque(false); 
		
		panel1.setLayout(null);
		final JButton ok=new JButton("");
		Icon generl6=new ImageIcon (this.getClass().getResource("/image/ok1.png"));
		  Icon press6=new ImageIcon(this.getClass().getResource("/image/ok1.png"));
		  Icon rollover6=new ImageIcon(this.getClass().getResource("/image/ok1.png"));
		  ok.setRolloverEnabled(true);
		  ok.setIcon(generl6);
		  ok.setRolloverIcon(rollover6);
		  ok.setPressedIcon(press6);
		  ok.setContentAreaFilled(false);
		  ok.setBorderPainted(false);
		ok.setBounds(310,260,122,50);
		
		
		JLabel name= new JLabel("用户名  ");
		name.setForeground(Color.BLACK) ;
	    Font font = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,15);
	    name.setFont(font);
	    name.setBounds(150,40,170,20);
		
	    JLabel password=new JLabel("密  码 ");
	    password.setForeground(Color.BLACK) ;
		Font font1 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,15);
		password.setFont(font1);
		password.setBounds(150,130,170,20);
	    
		
		JLabel change=new JLabel("修改密码");
		change.setForeground(Color.WHITE) ;
		Font font2 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,15);
		change.setFont(font2);
		change.setBounds(510,140,90,50);
		
		JLabel forget = new JLabel("忘记密码");
		forget.setForeground(Color.WHITE) ;
		Font font3 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,15);
		forget.setFont(font3);
		forget.setBounds(510,200,90,50);
		
		JLabel close = new JLabel("X");
		close.setBounds(610,20,40,40);
		
		JLabel register=new JLabel("注册用户");
		register.setForeground(Color.WHITE) ;
		Font font4 = new Font("幼圆",Font.LAYOUT_RIGHT_TO_LEFT,15);
		register.setFont(font4);
		register.setBounds(510,260,95,50);
		
		final JTextField nameinput=new JTextField("");
		nameinput.setBounds(150,72,260,40);
		nameinput.setBorder(BorderFactory.createLoweredBevelBorder());  
		//nameinput.setForeground(Color.DARK_GRAY) ;
		final JPasswordField passwordinput=new JPasswordField(15);
		passwordinput.setBounds(150,162,260,40);
		passwordinput.setBorder(BorderFactory.createLoweredBevelBorder());  
	   // passwordinput.setForeground(Color.DARK_GRAY);
	  
		
		label.setBounds(95,201,200,200);//背景添加
		this.setBounds(10, 10, 200, 200);
		
		this.add(ok);
		this.add(register);
		this.add(name);
		this.add(password);
		this.add(change);
		this.add(forget);
		this.add(panel1);
		this.add(nameinput);
		this.add(passwordinput);
	    
		this.add(close);
		this.add(label);
		
		this.setVisible(true);
		
		nameinput.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event){
				if(event.getSource()==nameinput){
					nameinput.setText("");
					nameinput.setForeground(Color.black);
				}
			}
		});
		
	
		//jbutton1.addActionListener(new Dialog_enroll_jbutton1_actionAdapter(this));
		ok.addActionListener(new ActionListener()//进入系统空间的监听方法
		{
		public void actionPerformed(ActionEvent Event) 
		{
			//处理登录按钮组件
			String account = nameinput.getText().trim(); //得到帐号
			String password = String.valueOf(passwordinput.getPassword());//得到密码
			
			//user = IDbSrvlmpl.getMessage(account);
			String sql = "select * from tblUserManager where cardNo ='"+account+"'";
			user = LoginImpl.getMessage(sql);
			if(user.getPsd().equals(password)){  
			   new ClauseView(user);
			   dispose();
			}
			else{
				nameinput.setText("");
				passwordinput.setText("");
				nameinput.requestFocus();
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			}
			
		}

	});
		

 
 register.addMouseListener(new MouseListener()
 {
	 public void mouseClicked(MouseEvent event)
	 {
	    new RegisterView();     //此界面是单击注册后的主界面
		//loginframe.dispose();
     }

	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
 });
 
 close.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent event){
			dispose();
			}
		 });
	
 
 change.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent event){
			new ChangePassword();
			}
		});
	}
	
	    public void paintComponent(Graphics g) { 
		g.drawImage(background.getImage(), 100, 5,this);   
		super.paintComponents(g); 
	}
		public static void main(String[]args) throws InterruptedException
		{
		      //new SplashWithImage();
	         // Thread.sleep(9000);
			  ClauseLogin login = new ClauseLogin();
	  
		}
}

		


