package seu.Client.view;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;


import java.awt.Color;

import java.awt.Graphics;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import seu.Client.bz.impl.CommonImpl;
import seu.Client.bz.impl.StudentInfoImpl;
import seu.Client.vo.StudentInfo;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import k.User;

/**
 * 学籍管理模块的主界面
 * 
 * @author kidd
 * 
 */
public class StuInfoFrm extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblMainView;
	private JButton btnAdd;
	private JButton btnPika;
	private JButton btnQuit;
	private JButton btnClear;
	private JPanel jPanelRight;
	private JPanel jPanelLeft;
	private JLabel jLabel2; // 提示信息的字符串
	private JLabel jLabel1;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnQuery;
	private JButton btnMaintain;
	private StudentInfo StuVo;
	boolean isConnectToServer;

	InputStream fileau;
	InputStream fileau1;
	AudioStream as;
	private User user;// 包含从登陆窗口接收的信息；

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StuInfoFrm inst = new StuInfoFrm();
				inst.setLocationRelativeTo(null);

				inst.setVisible(true);

			}
		});
	}

	public StuInfoFrm(User u) {
		this();
		user = u;
	}

	public StuInfoFrm() {
		super();

		try {
			/**
			 * 加入声音的地方
			 */
			
//			URL url = this.getClass().getResource("/src/sound/1A银铃般的笑声.wav");
//			System.out.println(url.toURI().getPath().substring(1));
			 fileau = this.getClass().getResourceAsStream("/src/sound/1A银铃般的笑声.wav");
			as = new AudioStream(fileau);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(this, "FileNotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(this, "IOException");
			e.printStackTrace();
		}

		this.setUndecorated(true);
		initGUI();
		this.setTitle("学籍管理系统管理员界面");
		isConnectToServer = false;
		this.setResizable(false);

		// 检测服务器是否在线

		// try {
		//
		// isConnectToServer = true;
		// } catch (UnknownHostException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// jLabel2.setText("暂时无法连接到服务器！");
		// btnAdd.setEnabled(false);
		// e.printStackTrace();
		// }
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			/**
			 * 美化按钮的地方
			 */
			final ImageIcon backgroudLeft = new ImageIcon(this.getClass()
					.getResource("/src/image/StuInfoLeftBkg.jpg"));
			final ImageIcon backgroudRgiht = new ImageIcon(this.getClass()
					.getResource("/src/image/StuInfoRightBGC_副本.jpg"));
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				jPanelLeft = new JPanel() {
					// public void paintComponent( Graphics g ) {    
					//  super.paintComponent(g);//继承超类绘制组件方法     
					//  if (imageIcon != null) 
					//  g.drawImage(imageIcon.getImage(), 0, 0, this.getWidth(),this.getHeight());
					// }
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (backgroudLeft != null)
							g.drawImage(backgroudLeft.getImage(), 0, 0,
									this.getWidth(), this.getHeight(), null);
					}
				};
				AnchorLayout jPanelLeftLayout = new AnchorLayout();
				jPanelLeft.setLayout(jPanelLeftLayout);
				getContentPane().add(
						jPanelLeft,
						new AnchorConstraint(1, 310, 1001, 0,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jPanelLeft.setPreferredSize(new java.awt.Dimension(187, 364));
				{
					btnClear = new JButton();
					final ImageIcon btnClearIcon = new ImageIcon(this
							.getClass().getResource("/src/image/清屏.png"));
					final ImageIcon btnClearRoll = new ImageIcon(this
							.getClass().getResource("/src/image/清屏1.png"));

					btnClear.setFocusPainted(false);
					btnClear.setRolloverEnabled(true);
					btnClear.setIcon(btnClearIcon);
					btnClear.setRolloverIcon(btnClearRoll);
					// btnDelete.setPressedIcon(btnAddPress);
					btnClear.setContentAreaFilled(false);
					btnClear.setBorderPainted(false);
					jPanelLeft.add(btnClear, new AnchorConstraint(880, 771,
							993, 250, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					btnClear.setText("\u6e05\u5c4f");
					btnClear.setPreferredSize(new java.awt.Dimension(97, 41));
					btnClear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnClearActionPerformed(evt);
						}
					});
				}
				btnClear.setVisible(false);
				{
					btnAdd = new JButton();
					final ImageIcon btnAddIcon = new ImageIcon(this.getClass()
							.getResource("/src/image/未命名_副本1.png"));
					final ImageIcon btnAddRoll = new ImageIcon(this.getClass()
							.getResource("/src/image/btnStuInfoAddR.png"));
					final ImageIcon btnAddPress = new ImageIcon(this.getClass()
							.getResource("/src/image/btnStuInfoAddP.png"));

					btnAdd.setFocusPainted(false);
					btnAdd.setRolloverEnabled(true);
					btnAdd.setIcon(btnAddIcon);
					btnAdd.setRolloverIcon(btnAddRoll);
					btnAdd.setPressedIcon(btnAddPress);
					btnAdd.setContentAreaFilled(false);
					btnAdd.setBorderPainted(false);

					jPanelLeft.add(btnAdd, new AnchorConstraint(144, 873, 396,
							153, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					btnAdd.setPreferredSize(new java.awt.Dimension(134, 92));
					btnAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnAddActionPerformed(evt);
						}
					});
				}
				{
					final ImageIcon btnMaintainIcon = new ImageIcon(this
							.getClass().getResource(
									"/src/image/btnMaintainS.png"));
					final ImageIcon btnMaintainRoll = new ImageIcon(this
							.getClass().getResource(
									"/src/image/btnMaintainS_副本.png"));
					btnMaintain = new JButton();
					jPanelLeft.add(btnMaintain, new AnchorConstraint(457, 868,
							971, 147, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					btnMaintain.setText("");
					btnMaintain.setPreferredSize(new java.awt.Dimension(134,
							187));
					btnMaintain.setFocusPainted(false);
					btnMaintain.setRolloverEnabled(true);
					btnMaintain.setRolloverEnabled(true);
					btnMaintain.setIcon(btnMaintainIcon);
					btnMaintain.setRolloverIcon(btnMaintainRoll);
					btnMaintain.setContentAreaFilled(false);
					btnMaintain.setBorderPainted(false);
					btnMaintain.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnMaintainActionPerformed(evt);
						}
					});
				}
				{
					// btnAdd = new JButton();
					btnQuery = new JButton();
					final ImageIcon btnQueryIcon = new ImageIcon(this
							.getClass().getResource("/src/image/查询1_副本13.png"));
					final ImageIcon btnQueryRoll = new ImageIcon(this
							.getClass().getResource("/src/image/查询1_副本.png"));
					final ImageIcon btnQueryPress = new ImageIcon(this
							.getClass().getResource("/src/image/查询1_副本1.png"));

					btnQuery.setFocusPainted(false);
					btnQuery.setRolloverEnabled(true);
					btnQuery.setIcon(btnQueryIcon);
					btnQuery.setRolloverIcon(btnQueryRoll);
					btnQuery.setPressedIcon(btnQueryPress);
					btnQuery.setContentAreaFilled(false);
					btnQuery.setBorderPainted(false);

					jPanelLeft.add(btnQuery, new AnchorConstraint(493, 771,
							583, 250, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					btnQuery.setText("");
					btnQuery.setPreferredSize(new java.awt.Dimension(97, 33));
					btnQuery.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnQueryActionPerformed(evt);
						}
					});
					btnQuery.setVisible(false);
				}
				{
					btnUpdate = new JButton();
					final ImageIcon btnUpdateIcon = new ImageIcon(this
							.getClass().getResource("/src/image/更新.png"));
					final ImageIcon btnUpdateRoll = new ImageIcon(this
							.getClass().getResource("/src/image/更新1.png"));

					btnUpdate.setFocusPainted(false);
					btnUpdate.setRolloverEnabled(true);
					btnUpdate.setIcon(btnUpdateIcon);
					btnUpdate.setRolloverIcon(btnUpdateRoll);
					// btnDelete.setPressedIcon(btnAddPress);
					btnUpdate.setContentAreaFilled(false);
					btnUpdate.setBorderPainted(false);
					jPanelLeft.add(btnUpdate, new AnchorConstraint(748, 776,
							836, 250, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					btnUpdate.setText("");
					btnUpdate.setPreferredSize(new java.awt.Dimension(98, 32));
					btnUpdate.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnUpdateActionPerformed(evt);
						}
					});
					btnUpdate.setVisible(false);
				}
				{
					btnDelete = new JButton();
					final ImageIcon btnDelIcon = new ImageIcon(this.getClass()
							.getResource("/src/image/删除1.png"));
					final ImageIcon btnDelRoll = new ImageIcon(this.getClass()
							.getResource("/src/image/删除1_副本.png"));

					btnDelete.setFocusPainted(false);
					btnDelete.setRolloverEnabled(true);
					btnDelete.setIcon(btnDelIcon);
					btnDelete.setRolloverIcon(btnDelRoll);
					// btnDelete.setPressedIcon(btnAddPress);
					btnDelete.setContentAreaFilled(false);
					btnDelete.setBorderPainted(false);
					jPanelLeft.add(btnDelete, new AnchorConstraint(627, 771,
							718, 250, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					btnDelete.setText("");
					btnDelete.setPreferredSize(new java.awt.Dimension(97, 33));
					btnDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnDeleteActionPerformed(evt);
						}
					});
					btnDelete.setVisible(false);
				}
			}
			{
				jPanelRight = new JPanel() {
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (backgroudRgiht != null)
							g.drawImage(backgroudRgiht.getImage(), 0, 0,
									this.getWidth(), this.getHeight(), null);
					}
				};
				AnchorLayout jPanelRightLayout = new AnchorLayout();
				jPanelRight.setLayout(jPanelRightLayout);
				getContentPane().add(
						jPanelRight,
						new AnchorConstraint(1, 1000, 1001, 309,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jPanelRight.setPreferredSize(new java.awt.Dimension(417, 364));
				{
					btnPika = new JButton();
					btnPika.setFocusPainted(false);
					btnPika.setText("");
					btnPika.setContentAreaFilled(false);
					btnPika.setBorderPainted(false);
					jPanelRight.add(btnPika, new AnchorConstraint(861, 606,
							953, 431, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					btnPika.setPreferredSize(new java.awt.Dimension(75, 37));
					btnPika.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							btnPikaMouseEntered(evt);
						}
					});
				}
				{
					btnQuit = new JButton();
					btnQuit.setFocusPainted(false);
					btnQuit.setRolloverEnabled(true);
					// btnQuit.setPressedIcon(btnq);
					final ImageIcon btnQuitI = new ImageIcon(this.getClass()
							.getResource("/src/image/退出.jpg"));
					final ImageIcon btnQuitR = new ImageIcon(this.getClass()
							.getResource("/src/image/退出1.jpg"));
					btnQuit.setIcon(btnQuitI);
					btnQuit.setPressedIcon(btnQuitR);
					btnQuit.setRolloverIcon(btnQuitR);
					btnQuit.setText("");
					jPanelRight.add(btnQuit, new AnchorConstraint(812, 966,
							953, 762, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					btnQuit.setContentAreaFilled(false);
					btnQuit.setBorderPainted(false);
					btnQuit.setPreferredSize(new java.awt.Dimension(87, 57));
					btnQuit.addMouseListener(new MouseAdapter() {
						public void mouseEntered(MouseEvent evt) {
							btnQuitMouseEntered(evt);
						}
					});
					btnQuit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnQuitActionPerformed(evt);
						}
					});
				}
				{
					jLabel1 = new JLabel();
					jPanelRight.add(jLabel1, new AnchorConstraint(64, 461, 141,
							18, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f\uff1a");
					jLabel1.setFont(new java.awt.Font("幼圆", 0, 30));
					jLabel1.setPreferredSize(new java.awt.Dimension(182, 28));
				}
				{
					jLabel2 = new JLabel();
					jPanelRight.add(jLabel2, new AnchorConstraint(34, 855, 163,
							339, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel2.setFont(new java.awt.Font("幼圆", 0, 30));
					jLabel2.setPreferredSize(new java.awt.Dimension(212, 47));
					jLabel2.setText("welcome to \u5b66\u7c4d\u7ba1\u7406\u7cfb\u7edf");
				}
				{
					TableModel tblMainViewModel = new DefaultTableModel(
							new String[][] { { "学号", "06013101" },
									{ "姓名", "王一朵" }, { "性别", "UnKnown" },
									{ "年级", "大一" }, { "院系", "电子" },
									{ "专业", "技术" }, { "身份证号", "12345" } },
							new String[] { "Column 1", "Column 2" });
					tblMainView = new JTable() {
						public boolean isCellEditable(int row, int column) {
							if (column == 0)
								return false;
							else
								return true;
						}
					};
					jPanelRight.add(tblMainView, new AnchorConstraint(179,
							1001, 696, 1, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					tblMainView.setModel(tblMainViewModel);
					tblMainView.setFont(new java.awt.Font("微软雅黑", 0, 16));
					tblMainView.setRowHeight(30);
					tblMainView.setPreferredSize(new java.awt.Dimension(411,
							188));
				}
			}
			pack();
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			this.setSize(619, 402);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	/*
	 * 添加按钮的响应函数
	 */
	private void btnAddActionPerformed(ActionEvent evt) {
		System.out.println("btnAdd.actionPerformed, event=" + evt);
		System.out.println(tblMainView.getValueAt(0, 1));
		// TODO add your code for btnAdd.actionPerformed
		// 检测合法
		for (int i = 0; i < 7; i++) {
			String str = (String) tblMainView.getValueAt(i, 1);
			if (str.isEmpty()) {
				JOptionPane.showMessageDialog(this, "所添加信息不完全！");
				jLabel2.setText("所添加信息不完全！添加操作无法完成");
				jLabel2.setForeground(Color.red);
				//Toolkit.getDefaultToolkit().beep();
				return;
			}
		}

		StuVo = new StudentInfo();
		StuVo.StudentNo = (String) tblMainView.getValueAt(0, 1);
		StuVo.Name = (String) tblMainView.getValueAt(1, 1);
		StuVo.Gender = (String) tblMainView.getValueAt(2, 1);
		StuVo.Grade = (String) tblMainView.getValueAt(3, 1);
		StuVo.Department = (String) tblMainView.getValueAt(4, 1);
		StuVo.Major = (String) tblMainView.getValueAt(5, 1);
		StuVo.ID = (String) tblMainView.getValueAt(6, 1);

		String stri = StudentInfoImpl.addStuInfo(StuVo);
		if (stri.equals("添加操作成功！")) {
			jLabel2.setForeground(Color.BLACK);
			jLabel2.setText("添加操作成功！");
			JOptionPane.showMessageDialog(this, "添加成功");
		}

		else {
			jLabel2.setForeground(Color.RED);
			JOptionPane.showMessageDialog(this, stri);
		}

	}

	private void btnMaintainActionPerformed(ActionEvent evt) {
		System.out.println("btnMaintain.actionPerformed, event="
				+ evt.getActionCommand());
		// TODO add your code for btnMaintain.actionPerformed
		btnDelete.setVisible(true);
		btnQuery.setVisible(true);
		btnClear.setVisible(true);
		btnMaintain.setVisible(false);
		jLabel2.setText("维护数据中,请键入必要的信息~");
		jLabel2.setForeground(Color.RED);

		for (int i = 0; i < 7; i++)
			tblMainView.setValueAt("", i, 1);
	}

	/*
	 * 学籍管理系统查询功能函数
	 */
	private void btnQueryActionPerformed(ActionEvent evt) {
		System.out.println("btnQuery.actionPerformed, event=" + evt);
		// TODO add your code for btnQuery.actionPerformed
		StuVo = null;
		String str = (String) tblMainView.getValueAt(0, 1);
		if (!str.isEmpty()) {
			StuVo = StudentInfoImpl.queryStuInfo(str, false);
			if (StuVo != null) {
				setInfo(StuVo);
				jLabel2.setForeground(Color.BLACK);
				jLabel2.setText("查询完成");
				//Toolkit.getDefaultToolkit().beep();
				btnUpdate.setVisible(true);
			} else {
				jLabel2.setForeground(Color.RED);
				jLabel2.setText("查无此人");
				//Toolkit.getDefaultToolkit().beep();
			}
			return;
		}

		str = (String) tblMainView.getValueAt(1, 1);
		if (!str.isEmpty()) {
			StuVo = StudentInfoImpl.queryStuInfo(str, true);
			if (StuVo != null) {
				setInfo(StuVo);
				jLabel2.setForeground(Color.black);
				jLabel2.setText("查询完成,可以进行信息的更新");
				//Toolkit.getDefaultToolkit().beep();
			} else {
				jLabel2.setForeground(Color.RED);
				jLabel2.setText("查无此人");
				btnClearActionPerformed(evt);
				//Toolkit.getDefaultToolkit().beep();
			}
			return;
		}

		jLabel2.setText("查询只支持按学号或者姓名哦~");
		jLabel2.setForeground(Color.RED);
		//Toolkit.getDefaultToolkit().beep();

	}

	/*
	 * 用一个StudentInfo类来设置table里的内容
	 */
	private void setInfo(StudentInfo stuVo2) {
		// TODO Auto-generated method stub
		tblMainView.setValueAt(stuVo2.StudentNo, 0, 1);
		tblMainView.setValueAt(stuVo2.Name, 1, 1);
		tblMainView.setValueAt(stuVo2.Gender, 2, 1);
		tblMainView.setValueAt(stuVo2.Grade, 3, 1);
		tblMainView.setValueAt(stuVo2.Department, 4, 1);
		tblMainView.setValueAt(stuVo2.Major, 5, 1);
		tblMainView.setValueAt(stuVo2.ID, 6, 1);

	}

	/*
	 * 清屏按钮的响应
	 */
	private void btnClearActionPerformed(ActionEvent evt) {
		System.out.println("btnClear.actionPerformed, event=" + evt);
		// TODO add your code for btnClear.actionPerformed

		tblMainView.setValueAt("", 0, 1);
		tblMainView.setValueAt("", 1, 1);
		tblMainView.setValueAt("", 2, 1);
		tblMainView.setValueAt("", 3, 1);
		tblMainView.setValueAt("", 4, 1);
		tblMainView.setValueAt("", 5, 1);
		tblMainView.setValueAt("", 6, 1);
		jLabel2.setText("清屏完成~");
	}

	/*
	 * 更新按钮的响应函数
	 */
	private void btnUpdateActionPerformed(ActionEvent evt) {
		System.out.println("btnQuery.actionPerformed, event=" + evt);
		// TODO add your code for btnQuery.actionPerformed
		StuVo.setAll((String) tblMainView.getValueAt(0, 1),
				(String) tblMainView.getValueAt(1, 1),
				(String) tblMainView.getValueAt(2, 1),
				(String) tblMainView.getValueAt(3, 1),
				(String) tblMainView.getValueAt(4, 1),
				(String) tblMainView.getValueAt(5, 1),
				(String) tblMainView.getValueAt(6, 1));

		if (StudentInfoImpl.updateStuInfo(StuVo)) {
			jLabel2.setForeground(Color.BLACK);
			JOptionPane.showMessageDialog(this, "更新成功");
			jLabel2.setText("更新成功~");
		}

		else {
			jLabel2.setForeground(Color.RED);
			JOptionPane.showMessageDialog(this, "更新失败");
			jLabel2.setText("更新成功~");
		}

		/*
		 * tblMainView.setValueAt(stuVo2.StudentNo,0, 1);
		 * tblMainView.setValueAt(stuVo2.Name,1, 1);
		 * tblMainView.setValueAt(stuVo2.Gender,2, 1);
		 * tblMainView.setValueAt(stuVo2.Grade,3, 1);
		 * tblMainView.setValueAt(stuVo2.Department,4, 1);
		 * tblMainView.setValueAt(stuVo2.Major,5, 1);
		 * tblMainView.setValueAt(stuVo2.ID,6, 1);
		 */

	}

	/*
	 * 删除按钮的响应函数 只支持按学号来删除
	 */
	private void btnDeleteActionPerformed(ActionEvent evt) {
		System.out.println("btnDelete.actionPerformed, event=" + evt);
		// TODO add your code for btnDelete.actionPerformed
		btnQueryActionPerformed(evt);
		jLabel2.setText("删除信息");
		if (JOptionPane.showConfirmDialog(this,
				"确定删除" + tblMainView.getValueAt(1, 1) + "的学籍信息？") == 0) {
			if (StudentInfoImpl.deleteStuInfo((String) tblMainView.getValueAt(
					0, 1))) {
				jLabel2.setText("删除成功~");
				btnClearActionPerformed(evt);
			}

		}
	}

	private void thisWindowClosing(WindowEvent evt) {
		System.out.println("this.windowClosing, event=" + evt);
		// TODO add your code for this.windowClosing

		AudioPlayer.player.stop(as);
		this.dispose();
	}

	private void btnQuitActionPerformed(ActionEvent evt) {
		System.out.println("btnQuit.actionPerformed, event=" + evt);
		AudioPlayer.player.stop(as);

		this.dispose();

		// TODO add your code for btnQuit.actionPerformed
	}

	private void btnPikaMouseEntered(MouseEvent evt) {
		System.out.println("btnPika.mouseEntered, event=" + evt);
		// TODO add your code for btnPika.mouseEntered
		try {
			/**
			 * pika
			 */
//			 fileau = this.getClass().getResourceAsStream("/src/sound/1A银铃般的笑声.wav");
//				as = new AudioStream(fileau);
			 fileau1 = this.getClass()
					.getResourceAsStream("/src/sound/皮卡丘的短信铃声.wav");
			AudioStream as = new AudioStream(fileau1);
			AudioPlayer.player.start(as);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void btnQuitMouseEntered(MouseEvent evt) {
		System.out.println("btnQuit.mouseEntered, event=" + evt);
		// TODO add your code for btnQuit.mouseEntered
		try {

			AudioPlayer.player.start(as);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
