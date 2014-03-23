package seu.Client.view;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
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
import seu.Client.bz.impl.BookInfoImpl;
import seu.Client.bz.impl.StudentInfoImpl;
import seu.Client.vo.BookInfo;
import k.User;
/**
 * 图书馆模块管理员主界面
 * @author kidd
 *
 */
public class BookInfoFrm extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tblMainView;// 面板
	private JButton btnAdd;// 添加书籍按钮
	private JButton btnClear;// 删除按钮
	private JPanel jPanelRight;// 右边面板
	private JPanel jPanelLeft;// 左边面板
	private JLabel jLabel2; // 提示信息的字符串
	private JLabel jLabel1;// 提示信息的字符串
	private JButton btnDelete;// 删除书籍
	private JButton btnUpdate;// 更新按钮
	private JButton btnQuery;// 查询按钮
	private JButton btnMaintain;// 维护数据
	private BookInfo StuVo;
	boolean isConnectToServer;

	private User user;// 包含从登陆窗口接收的信息；

	// 主函数
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				User user =new User();
				BookInfoFrm inst = new BookInfoFrm(user);
				inst.setLocationRelativeTo(null);
				//inst.setVisible(true);
			}
		});
	}

	// 默认构造函数
	public BookInfoFrm() {
		super("东南大学图书馆");
	}

	// 构造函数函数
	public BookInfoFrm(User u) {
		super();
		this.setResizable(false);// 不可改变大小
		user = u;
		initGUI();
		
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);// 最大化

	}

	// 界面构造器
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				final ImageIcon backgroudLeft = new ImageIcon(this.getClass().getResource("/image/背景左.jpg"));// 背景图片
				// 设置背景面板
				jPanelLeft = new JPanel() {
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (backgroudLeft != null)
							g.drawImage(backgroudLeft.getImage(), 0, 0,
									this.getWidth(), this.getHeight(), null);
					}
				};

				// 设置布局
				AnchorLayout jPanelLeftLayout = new AnchorLayout();
				jPanelLeft.setLayout(jPanelLeftLayout);
				getContentPane().add(
						jPanelLeft,
						new AnchorConstraint(0, 315, 1000, 0,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));

				{
					// 设置清屏按钮
					ImageIcon Image2 = new ImageIcon(this.getClass().getResource("/image/清屏.png"));
					btnClear = new JButton(Image2);
					btnClear.setContentAreaFilled(false);// 设置透明
					btnClear.setBorderPainted(false);// 去除边框

					jPanelLeft.add(btnClear, new AnchorConstraint(800, 750,
							950, 200, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));

					btnClear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnClearActionPerformed(evt);
						}
					});
				}
				btnClear.setVisible(false);

				{
					{
						// 添加书籍按钮
						ImageIcon Image3 = new ImageIcon(this.getClass().getResource("/image/添加书籍.jpg"));
						btnAdd = new JButton();
						btnAdd.setIcon(Image3);
						btnAdd.setContentAreaFilled(false);// 设置透明
						btnAdd.setBorderPainted(false);// 去除边框

						jPanelLeft.add(btnAdd, new AnchorConstraint(30, 750,
								180, 200, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));

						btnAdd.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnAddActionPerformed(evt);
							}
						});
					}
					{
						// 维护数据按钮
						btnMaintain = new JButton();
						ImageIcon Image4 = new ImageIcon(this.getClass().getResource("/image/维护数据.jpg"));
						btnMaintain = new JButton(Image4);
						btnMaintain.setContentAreaFilled(false);// 设置透明
						btnMaintain.setBorderPainted(false);// 去除边框

						jPanelLeft.add(btnMaintain, new AnchorConstraint(600,
								750, 750, 200, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));

						btnMaintain.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnMaintainActionPerformed(evt);
							}
						});
					}

					{
						// 添加查询按钮
						{
							ImageIcon Image5 = new ImageIcon(this.getClass().getResource("/image/查询书籍.jpg"));
							btnQuery = new JButton();
							btnQuery.setIcon(Image5);
							btnQuery.setContentAreaFilled(false);// 设置透明
							btnQuery.setBorderPainted(false);// 去除边框

							jPanelLeft.add(btnQuery, new AnchorConstraint(220,
									750, 370, 200, AnchorConstraint.ANCHOR_REL,
									AnchorConstraint.ANCHOR_REL,
									AnchorConstraint.ANCHOR_REL,
									AnchorConstraint.ANCHOR_REL));

							btnQuery.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnQueryActionPerformed(evt);
								}
							});
							btnQuery.setVisible(false);
						}

						// 设置更新按钮
						ImageIcon Image6 = new ImageIcon(this.getClass().getResource("/image/更新.jpg"));
						btnUpdate = new JButton();
						btnUpdate.setIcon(Image6);
						btnUpdate.setContentAreaFilled(false);// 设置透明
						btnUpdate.setBorderPainted(false);// 去除边框

						jPanelLeft.add(btnUpdate, new AnchorConstraint(395,
								750, 545, 200, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));

						btnUpdate.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnUpdateActionPerformed(evt);
							}
						});
						btnUpdate.setVisible(false);
					}

					{

						// 设置删除按钮

						btnDelete = new JButton();
						ImageIcon Image7 = new ImageIcon(this.getClass().getResource("/image/删除.jpg"));
						btnDelete = new JButton();
						btnDelete.setIcon(Image7);
						btnDelete.setContentAreaFilled(false);// 设置透明
						btnDelete.setBorderPainted(false);// 去除边框

						jPanelLeft.add(btnDelete, new AnchorConstraint(590,
								750, 740, 200, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));

						btnDelete.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnDeleteActionPerformed(evt);
							}
						});
						btnDelete.setVisible(false);
					}
				}
				{

					// 设置右边面板
					final ImageIcon backgroudRight = new ImageIcon(
							this.getClass().getResource("/image/背景右.jpg"));// 背景图片
					jPanelRight = new JPanel() {
						public void paintComponent(Graphics g) {
							super.paintComponent(g);
							if (backgroudRight != null)
								g.drawImage(backgroudRight.getImage(), 0, 0,
										this.getWidth(), this.getHeight(), null);
						}
					};
					AnchorLayout jPanelRightLayout = new AnchorLayout();
					jPanelRight.setLayout(jPanelRightLayout);
					getContentPane().add(
							jPanelRight,
							new AnchorConstraint(0, 1000, 1000, 310,
									AnchorConstraint.ANCHOR_REL,
									AnchorConstraint.ANCHOR_REL,
									AnchorConstraint.ANCHOR_REL,
									AnchorConstraint.ANCHOR_REL));

					{
						jLabel1 = new JLabel();
						jPanelRight.add(jLabel1, new AnchorConstraint(64, 461,
								141, 18, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
						jLabel1.setText("");
						jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 20));
						jLabel1.setPreferredSize(new java.awt.Dimension(182, 28));
					}
					{
						jLabel2 = new JLabel();
						jPanelRight.add(jLabel2, new AnchorConstraint(34, 855,
								163, 339, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
						jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 22));
					}
					{
						TableModel tblMainViewModel = new DefaultTableModel(
								new String[][] { { "图书编号", "01" },
										{ "图书名", "化学" }, { "出版社", "东南大学" },
										{ "作者", "沈军" }, { "价格", "27" },
										{ "出版日期", "1992-12-17" },
										{ "图书类型", "教育类" } }, new String[] {
										"Column 1", "Column 2" });
						tblMainView = new JTable() {
							public boolean isCellEditable(int row, int column) {
								if (column == 0)
									return false;
								else
									return true;
							}
						};
						jPanelRight.add(tblMainView, new AnchorConstraint(700,
								700, 950, 15, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
						tblMainView.setModel(tblMainViewModel);
						tblMainView.setFont(new java.awt.Font("微软雅黑", 0, 16));
						tblMainView.setRowHeight(25);
						tblMainView.setPreferredSize(new java.awt.Dimension(
								401, 188));
					}
				}
				pack();
				this.setSize(500, 600);
				this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent evt) {
						thisWindowClosing(evt);
					}
				});

			}
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
		// 检测合法
		for (int i = 0; i < 7; i++) {
			String str = (String) tblMainView.getValueAt(i, 1);
			if (str.isEmpty()) {
				JOptionPane.showMessageDialog(this, "所添加信息不完全！");
				jLabel2.setText("所添加信息不完全！添加操作无法完成");
				jLabel2.setForeground(Color.red);
				Toolkit.getDefaultToolkit().beep();
				return;
			}
		}

		StuVo = new BookInfo();
		StuVo.BookNo = (String) tblMainView.getValueAt(0, 1);
		StuVo.Name = (String) tblMainView.getValueAt(1, 1);
		StuVo.Publiser = (String) tblMainView.getValueAt(2, 1);
		StuVo.Writer = (String) tblMainView.getValueAt(3, 1);
		StuVo.Price = (String) tblMainView.getValueAt(4, 1);
		StuVo.Indate = (String) tblMainView.getValueAt(5, 1);
		StuVo.BookType = (String) tblMainView.getValueAt(6, 1);

		String stri = BookInfoImpl.addStuInfo(StuVo);
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
		jLabel2.setText("");
		jLabel2.setForeground(Color.RED);

		for (int i = 0; i < 7; i++)
			tblMainView.setValueAt("", i, 1);
	}

	/*
	 * 图书管理系统查询功能函数
	 */
	private void btnQueryActionPerformed(ActionEvent evt) {
		System.out.println("btnQuery.actionPerformed, event=" + evt);
		StuVo = null;
		String str = (String) tblMainView.getValueAt(0, 1);
		if (!str.isEmpty()) {
			StuVo = BookInfoImpl.queryStuInfo(str, false);
			if (StuVo != null) {
				setInfo(StuVo);
				jLabel2.setForeground(Color.BLACK);
				jLabel2.setText("查询完成");
				Toolkit.getDefaultToolkit().beep();
				btnUpdate.setVisible(true);
			} else {
				jLabel2.setForeground(Color.RED);
				jLabel2.setText("查无此书");
				Toolkit.getDefaultToolkit().beep();
			}
			return;
		}

		jLabel2.setText("查询图书ID~");
		jLabel2.setForeground(Color.RED);
		Toolkit.getDefaultToolkit().beep();

	}

	/*
	 * 用一个StudentInfo类来设置table里的内容
	 */
	private void setInfo(BookInfo stuVo2) {
		// TODO Auto-generated method stub
		tblMainView.setValueAt(stuVo2.BookNo, 0, 1);
		tblMainView.setValueAt(stuVo2.Name, 1, 1);
		tblMainView.setValueAt(stuVo2.Publiser, 2, 1);
		tblMainView.setValueAt(stuVo2.Writer, 3, 1);
		tblMainView.setValueAt(stuVo2.Price, 4, 1);
		tblMainView.setValueAt(stuVo2.Indate, 5, 1);
		tblMainView.setValueAt(stuVo2.BookType, 6, 1);

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
		// System.out.println("btnQuery.actionPerformed, event=" + evt);
		// TODO add your code for btnQuery.actionPerformed
		StuVo.setAll((String) tblMainView.getValueAt(0, 1),
				(String) tblMainView.getValueAt(1, 1),
				(String) tblMainView.getValueAt(2, 1),
				(String) tblMainView.getValueAt(3, 1),
				(String) tblMainView.getValueAt(4, 1),
				(String) tblMainView.getValueAt(5, 1),
				(String) tblMainView.getValueAt(6, 1));

		if (BookInfoImpl.updateBookInfo(StuVo)) {
			jLabel2.setForeground(Color.BLACK);
			JOptionPane.showMessageDialog(this, "更新成功");
			jLabel2.setText("更新成功~");
		}

		else {
			jLabel2.setForeground(Color.RED);
			JOptionPane.showMessageDialog(this, "更新失败");
			jLabel2.setText("更新成功~");
		}

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
			if (BookInfoImpl.deleteBookInfo((String) tblMainView.getValueAt(0,
					1))) {
				jLabel2.setText("删除成功~");
				btnClearActionPerformed(evt);
			}

		}
	}

	private void thisWindowClosing(WindowEvent evt) {
		System.out.println("this.windowClosing, event=" + evt);
		CommonImpl.closeSocket();

		this.dispose();
	}

}
