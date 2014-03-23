package seu.Client.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;

import seu.Client.bz.impl.CommonImpl;
import seu.Client.view.Dorm.StuDorInfoFrm;
import seu.Client.view.Dorm.StuDorInfoFrmstu;
import seu.Client.view.ShopView.AdminShopView;
import seu.Client.view.ShopView.StuShopProView;

import java.util.*;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.*;

import k.User;
/**
 * 登陆模块主菜单，包含虚拟校园系统所有功能
 * @author kidd
 *
 */
public class ClauseView extends JFrame implements ActionListener {
	private ImageIcon background;
	User user;
	private JPanel jp1;
	private JButton jb1, jb2, jb3, jb4, jb5, jb6;
	String roleString;
	private Component closeJLabel;

	public ClauseView(final User user) {
		//this.setUndecorated(true);
		this.user = user;
		this.setTitle("SEU校园服务系统--" + user.getName()+" 权限:"+user.getRole());



		JLabel picLabel = new JLabel();
		picLabel.setIcon(new ImageIcon(this.getClass().getResource("/image/Background3.png")));
		this.getLayeredPane().add(picLabel, new Integer(Integer.MIN_VALUE));
		picLabel.setBounds(150, 0, 1200, 750);

		// 再在JFrame的最上层contentpane上添加按钮并且设置contentpane为透明。

		JLabel closeJLabel = new JLabel("X");
		closeJLabel.setBounds(1100, 20, 50, 50);

		jb1 = new JButton("");// 图 书 馆
		Icon generl1 = new ImageIcon(this.getClass().getResource("/image/Icon1.png"));
		Icon press1 = new ImageIcon(this.getClass().getResource("/image/Icon2.png"));
		Icon rollover1 = new ImageIcon(this.getClass().getResource("/image/Icon3.png"));
		jb1.setRolloverEnabled(true);
		jb1.setIcon(generl1);
		jb1.setRolloverIcon(rollover1);
		jb1.setPressedIcon(press1);
		jb1.setContentAreaFilled(false);
		jb1.setBorderPainted(false);
		jb1.addActionListener(this);
		// jb1.setBounds(50, 90, 30, 40);
		// jb1.setHorizontalTextPosition(JButton.CENTER);
		// jb1.setVerticalTextPosition(JButton.BOTTOM);

		jb2 = new JButton("");// 食 堂
		Icon generl2 = new ImageIcon(this.getClass().getResource("/image/Rollover1.png"));
		Icon press2 = new ImageIcon(this.getClass().getResource("/image/Rollover3.png"));
		Icon rollover2 = new ImageIcon(this.getClass().getResource("/image/Rollover2.png"));
		jb2.setRolloverEnabled(true);
		jb2.setIcon(generl2);
		jb2.setRolloverIcon(rollover2);
		jb2.setPressedIcon(press2);
		jb2.addActionListener(null);
		jb2.setContentAreaFilled(false);
		jb2.setBorderPainted(false);
		jb2.addActionListener(this);
		// jb2.setBounds(80, 90, 30, 40);
		// jb2.setHorizontalTextPosition(JButton.CENTER);
		// jb2.setVerticalTextPosition(JButton.BOTTOM);

		jb3 = new JButton("");// 超 市
		Icon generl3 = new ImageIcon(this.getClass().getResource("/image/Super2.png"));
		Icon press3 = new ImageIcon(this.getClass().getResource("/image/Super3.png"));
		Icon rollover3 = new ImageIcon(this.getClass().getResource("/image/Super1.png"));
		jb3.setRolloverEnabled(true);
		jb3.setIcon(generl3);
		jb3.setRolloverIcon(rollover3);
		jb3.setPressedIcon(press3);
		jb3.setContentAreaFilled(false);
		jb3.setBorderPainted(false);
		jb3.addActionListener(this);
		// jb3.setBounds(50, 120, 30, 400);
		// jb3.setHorizontalTextPosition(JButton.CENTER);
		// jb3.setVerticalTextPosition(JButton.BOTTOM);

		jb4 = new JButton("");// 学籍管理
		Icon generl4 = new ImageIcon(this.getClass().getResource("/image/Manager2.png"));
		Icon press4 = new ImageIcon(this.getClass().getResource("/image/Manager1.png"));
		Icon rollover4 = new ImageIcon(this.getClass().getResource("/image/Manager3.png"));
		jb4.setRolloverEnabled(true);
		jb4.setIcon(generl4);
		jb4.setRolloverIcon(rollover4);
		jb4.setPressedIcon(press4);
		jb4.setContentAreaFilled(false);
		jb4.setBorderPainted(false);
		jb4.addActionListener(this);
		// jb4.setBounds(80, 120, 30, 40);
		// jb4.setHorizontalTextPosition(JButton.CENTER);
		// jb4.setVerticalTextPosition(JButton.BOTTOM);

		jb5 = new JButton("");// 选课系统
		Icon generl5 = new ImageIcon(this.getClass().getResource("/image/Select3.png"));
		Icon press5 = new ImageIcon(this.getClass().getResource("/image/Select1.png"));
		Icon rollover5 = new ImageIcon(this.getClass().getResource("/image/Select2.png"));
		jb5.setRolloverEnabled(true);
		jb5.setIcon(generl5);
		jb5.setRolloverIcon(rollover5);
		jb5.setPressedIcon(press5);
		jb5.setContentAreaFilled(false);
		jb5.setBorderPainted(false);
		jb5.addActionListener(this);
		// jb5.setBounds(50, 150, 30, 40);
		// jb5.setHorizontalTextPosition(JButton.CENTER);
		// jb5.setVerticalTextPosition(JButton.BOTTOM);

		jb6 = new JButton("");// 宿舍管理
		Icon generl6 = new ImageIcon(this.getClass().getResource("/image/home3.png"));
		Icon press6 = new ImageIcon(this.getClass().getResource("/image/home2.png"));
		Icon rollover6 = new ImageIcon(this.getClass().getResource("/image/home1.png"));
		jb6.setRolloverEnabled(true);
		jb6.setIcon(generl6);
		jb6.setRolloverIcon(rollover6);
		jb6.setPressedIcon(press6);
		jb6.setContentAreaFilled(false);
		jb6.setBorderPainted(false);
		jb6.addActionListener(this);
		// jb6.setBounds(80, 150, 30, 40);

		// jb6.setHorizontalTextPosition(JButton.CENTER);
		// jb6.setVerticalTextPosition(JButton.BOTTOM);

		jb1.setBounds(310, 48, 250, 140);
		jb2.setBounds(552, 59, 250, 240);
		jb3.setBounds(331, 234, 230, 180);
		jb4.setBounds(716, 340, 250, 150);
		jb5.setBounds(860, 120, 150, 140);
		jb6.setBounds(170, 110, 220, 140);
		// c.setLayout(null);
		// c.setLayout(new FlowLayout());//设置布局管理器
		JPanel c = new JPanel();
		c = (JPanel) getContentPane();
		c.setOpaque(false);
		c.add(jb1);
		c.add(jb2);
		c.add(jb3);
		c.add(jb4);
		c.add(jb5);
		c.add(jb6);
		c.add(closeJLabel);
		/**
		 * c.add(jb1); c.add(jb2); c.add(jb3); c.add(jb4); c.add(jb5);
		 * c.add(jb6);
		 **/
		c.setLayout(null);
		// this.add(c);

		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		closeJLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				dispose();
				CommonImpl.closeSocket();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb2) {// 食堂
			System.out.println("in jb2");
			if (user.getRole().equals("餐厅管理员")
					|| user.getRole().equals("super")) {
				new CanteenAdminView(user);
				//this.dispose();
			} else {
				new CanteenStuView(user);
				//this.dispose();
			}
		} else if (e.getSource() == jb4) {// 学籍管理系统
			System.out.println("in jb4");
			if (user.getRole().equals("学籍系统管理员")
					|| user.getRole().equals("super")) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						StuInfoFrm inst = new StuInfoFrm();
						inst.setLocationRelativeTo(null);

						inst.setVisible(true);
					

					}
				});
				// this.dispose();
			}
			else {
				jb4.setEnabled(false);
			}
		}
		else if (e.getSource() == jb3) {//商店系统
			
			if (user.getRole().equals("商店系统管理员")
					|| user.getRole().equals("super")) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						AdminShopView inst = new AdminShopView();
						inst.setLocationRelativeTo(null);

						inst.setVisible(true);
					

					}
				});
			}
			else{
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						StuShopProView inst = new StuShopProView();
						inst.setLocationRelativeTo(null);

						inst.setVisible(true);
					

					}
				});
			}
		}
		else if (e.getSource() == jb1) {//  图书馆
			
			if (user.getRole().equals("图书馆管理员")
					|| user.getRole().equals("super")) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						BookInfoFrm inst = new BookInfoFrm(user);
						inst.setLocationRelativeTo(null);

					
					

					}
				});
			}
			else{
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						BookStuView inst = new BookStuView(user);
						//inst.setLocationRelativeTo(null);

						inst.setVisible(true);
					

					}
				});
			}
		}
		else if (e.getSource() == jb5) {//选课系统
			
			if (user.getRole().equals("选课系统管理员")
					|| user.getRole().equals("super")) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						AdminView inst = new AdminView();
						inst.setLocationRelativeTo(null);

						inst.setVisible(true);
					

					}
				});
			}
			else{
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						SubjSeleView inst = new SubjSeleView(user);
						inst.setLocationRelativeTo(null);

						inst.setVisible(true);
					

					}
				});
			}
		}
		else if (e.getSource() == jb6) {//宿舍系统
			
			if (user.getRole().equals("宿舍管理员")
					|| user.getRole().equals("super")) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						StuDorInfoFrm inst = null;
						inst = new StuDorInfoFrm();
						inst.setLocationRelativeTo(null);

						inst.setVisible(true);
					

					}
				});
			}
			else{
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						StuDorInfoFrmstu inst = new StuDorInfoFrmstu(user);
						inst.setLocationRelativeTo(null);

						inst.setVisible(true);
					

					}
				});
			}
		}

	}
}
