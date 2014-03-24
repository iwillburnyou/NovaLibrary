package seu.Client.view;
/**
 * ѧ������������� --By������
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;
import java.util.*;
import java.sql.*;

import k.User;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import k.User;
import seu.Client.bz.impl.CanteenInfoImpl;

public class CsAdvice extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private JLabel jLabel = new JLabel("�����������");
	private JTextArea jTextArea = new JTextArea();
	private JScrollPane jScrollPane = new JScrollPane(jTextArea);
	private JButton jButton ;
	
	private JButton jButton2 ;

	private ImageIcon background;
	
	public CsAdvice(User us){
		user = us;
		
		background = new ImageIcon(this.getClass().getResource("/image/ʳ��2.png")); 
        JLabel label = new JLabel(background); 
        label.setBounds(0, 0, this.getWidth(), this.getHeight()); 
		this.setOpaque(false);	
		
		jButton=new JButton();//�ύ
		Icon generl1=new ImageIcon (this.getClass().getResource("/image/sta1.png"));
		  Icon press1=new ImageIcon(this.getClass().getResource("/image/sta2.png"));
		  Icon rollover1=new ImageIcon(this.getClass().getResource("/image/sta3.png"));
		  jButton.setRolloverEnabled(true);
		  jButton.setIcon(generl1);
		  jButton.setRolloverIcon(rollover1);
		  jButton.setPressedIcon(press1);
		  jButton.setContentAreaFilled(false);
		  jButton.setBorderPainted(false);
		  
		jButton2=new JButton();//���
		Icon generl2=new ImageIcon (this.getClass().getResource("/image/sta4.png"));
		  Icon press2=new ImageIcon(this.getClass().getResource("/image/sta5.png"));
		  Icon rollover2=new ImageIcon(this.getClass().getResource("/image/sta6.png"));
		  jButton2.setRolloverEnabled(true);
		  jButton2.setIcon(generl2);
		  jButton2.setRolloverIcon(rollover2);
		  jButton2.setPressedIcon(press2);
		  jButton2.setContentAreaFilled(false);
		  jButton2.setBorderPainted(false);
		  
		this.setLayout(null);
		this.setVisible(true);
		jLabel.setBounds(30, 35, 200, 30);
		jLabel.setFont(new Font("��Բ", Font.PLAIN, 20));
		this.add(jLabel);
		jTextArea.setFont(new Font("��Բ", Font.PLAIN, 18));
		jTextArea.setLineWrap(true);
		jScrollPane.setBounds(30, 85, 400, 250);
		this.add(jScrollPane);
		jButton.setBounds(60, 320, 200, 100);
		jButton.setFont(new Font("��Բ", Font.PLAIN, 16));
		jButton2.setBounds(180, 320, 200, 100);
		jButton2.setFont(new Font("��Բ", Font.PLAIN, 16));
		jButton.addActionListener(this);
		jButton2.addActionListener(this);
		this.add(jButton);
		this.add(jButton2);
		this.setBounds(200, 0, 800, 600);
		this.setBackground(Color.WHITE);
		
			
	}
	
	public void actionPerformed(ActionEvent e) {
		String adviceString = jTextArea.getText();
		Date currentTime = new Date(System.currentTimeMillis()); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
		String dateString = formatter.format(currentTime); 
		String advicer = user.getName();
		String read = "��";
		String sqlString = "insert into tblAdvice values('"+dateString+"','"+ adviceString +"','"+advicer+"','"+read+"')";
		if(e.getSource()==jButton){
			
			String str  = CanteenInfoImpl.addAdvice(sqlString);//���÷���
			if(str.equals("��Ӳ����ɹ���")){
				jTextArea.setText("����ѷ����ɹ�����л���ı��������");
			}	
			else{
				jTextArea.setText("������������쳣��");
			}
		}
		else if (e.getSource() == jButton2){ //�������ť
			jTextArea.setText("");
			jTextArea.requestFocus();
		}
	}
	 public void paintComponent(Graphics g) { 
			g.drawImage(background.getImage(), 0, 0 ,this);   
			super.paintComponents(g); 
		}

}
