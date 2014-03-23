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
 * ͼ���ģ�����Ա������
 * @author kidd
 *
 */
public class BookInfoFrm extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tblMainView;// ���
	private JButton btnAdd;// ����鼮��ť
	private JButton btnClear;// ɾ����ť
	private JPanel jPanelRight;// �ұ����
	private JPanel jPanelLeft;// ������
	private JLabel jLabel2; // ��ʾ��Ϣ���ַ���
	private JLabel jLabel1;// ��ʾ��Ϣ���ַ���
	private JButton btnDelete;// ɾ���鼮
	private JButton btnUpdate;// ���°�ť
	private JButton btnQuery;// ��ѯ��ť
	private JButton btnMaintain;// ά������
	private BookInfo StuVo;
	boolean isConnectToServer;

	private User user;// �����ӵ�½���ڽ��յ���Ϣ��

	// ������
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

	// Ĭ�Ϲ��캯��
	public BookInfoFrm() {
		super("���ϴ�ѧͼ���");
	}

	// ���캯������
	public BookInfoFrm(User u) {
		super();
		this.setResizable(false);// ���ɸı��С
		user = u;
		initGUI();
		
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);// ���

	}

	// ���湹����
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				final ImageIcon backgroudLeft = new ImageIcon(this.getClass().getResource("/image/������.jpg"));// ����ͼƬ
				// ���ñ������
				jPanelLeft = new JPanel() {
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (backgroudLeft != null)
							g.drawImage(backgroudLeft.getImage(), 0, 0,
									this.getWidth(), this.getHeight(), null);
					}
				};

				// ���ò���
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
					// ����������ť
					ImageIcon Image2 = new ImageIcon(this.getClass().getResource("/image/����.png"));
					btnClear = new JButton(Image2);
					btnClear.setContentAreaFilled(false);// ����͸��
					btnClear.setBorderPainted(false);// ȥ���߿�

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
						// ����鼮��ť
						ImageIcon Image3 = new ImageIcon(this.getClass().getResource("/image/����鼮.jpg"));
						btnAdd = new JButton();
						btnAdd.setIcon(Image3);
						btnAdd.setContentAreaFilled(false);// ����͸��
						btnAdd.setBorderPainted(false);// ȥ���߿�

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
						// ά�����ݰ�ť
						btnMaintain = new JButton();
						ImageIcon Image4 = new ImageIcon(this.getClass().getResource("/image/ά������.jpg"));
						btnMaintain = new JButton(Image4);
						btnMaintain.setContentAreaFilled(false);// ����͸��
						btnMaintain.setBorderPainted(false);// ȥ���߿�

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
						// ��Ӳ�ѯ��ť
						{
							ImageIcon Image5 = new ImageIcon(this.getClass().getResource("/image/��ѯ�鼮.jpg"));
							btnQuery = new JButton();
							btnQuery.setIcon(Image5);
							btnQuery.setContentAreaFilled(false);// ����͸��
							btnQuery.setBorderPainted(false);// ȥ���߿�

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

						// ���ø��°�ť
						ImageIcon Image6 = new ImageIcon(this.getClass().getResource("/image/����.jpg"));
						btnUpdate = new JButton();
						btnUpdate.setIcon(Image6);
						btnUpdate.setContentAreaFilled(false);// ����͸��
						btnUpdate.setBorderPainted(false);// ȥ���߿�

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

						// ����ɾ����ť

						btnDelete = new JButton();
						ImageIcon Image7 = new ImageIcon(this.getClass().getResource("/image/ɾ��.jpg"));
						btnDelete = new JButton();
						btnDelete.setIcon(Image7);
						btnDelete.setContentAreaFilled(false);// ����͸��
						btnDelete.setBorderPainted(false);// ȥ���߿�

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

					// �����ұ����
					final ImageIcon backgroudRight = new ImageIcon(
							this.getClass().getResource("/image/������.jpg"));// ����ͼƬ
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
						jLabel1.setFont(new java.awt.Font("΢���ź�", 0, 20));
						jLabel1.setPreferredSize(new java.awt.Dimension(182, 28));
					}
					{
						jLabel2 = new JLabel();
						jPanelRight.add(jLabel2, new AnchorConstraint(34, 855,
								163, 339, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
						jLabel2.setFont(new java.awt.Font("΢���ź�", 0, 22));
					}
					{
						TableModel tblMainViewModel = new DefaultTableModel(
								new String[][] { { "ͼ����", "01" },
										{ "ͼ����", "��ѧ" }, { "������", "���ϴ�ѧ" },
										{ "����", "���" }, { "�۸�", "27" },
										{ "��������", "1992-12-17" },
										{ "ͼ������", "������" } }, new String[] {
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
						tblMainView.setFont(new java.awt.Font("΢���ź�", 0, 16));
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
	 * ��Ӱ�ť����Ӧ����
	 */
	private void btnAddActionPerformed(ActionEvent evt) {
		System.out.println("btnAdd.actionPerformed, event=" + evt);
		System.out.println(tblMainView.getValueAt(0, 1));
		// ���Ϸ�
		for (int i = 0; i < 7; i++) {
			String str = (String) tblMainView.getValueAt(i, 1);
			if (str.isEmpty()) {
				JOptionPane.showMessageDialog(this, "�������Ϣ����ȫ��");
				jLabel2.setText("�������Ϣ����ȫ����Ӳ����޷����");
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
		if (stri.equals("��Ӳ����ɹ���")) {
			jLabel2.setForeground(Color.BLACK);
			jLabel2.setText("��Ӳ����ɹ���");
			JOptionPane.showMessageDialog(this, "��ӳɹ�");
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
	 * ͼ�����ϵͳ��ѯ���ܺ���
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
				jLabel2.setText("��ѯ���");
				Toolkit.getDefaultToolkit().beep();
				btnUpdate.setVisible(true);
			} else {
				jLabel2.setForeground(Color.RED);
				jLabel2.setText("���޴���");
				Toolkit.getDefaultToolkit().beep();
			}
			return;
		}

		jLabel2.setText("��ѯͼ��ID~");
		jLabel2.setForeground(Color.RED);
		Toolkit.getDefaultToolkit().beep();

	}

	/*
	 * ��һ��StudentInfo��������table�������
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
	 * ������ť����Ӧ
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
		jLabel2.setText("�������~");
	}

	/*
	 * ���°�ť����Ӧ����
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
			JOptionPane.showMessageDialog(this, "���³ɹ�");
			jLabel2.setText("���³ɹ�~");
		}

		else {
			jLabel2.setForeground(Color.RED);
			JOptionPane.showMessageDialog(this, "����ʧ��");
			jLabel2.setText("���³ɹ�~");
		}

	}

	/*
	 * ɾ����ť����Ӧ���� ֻ֧�ְ�ѧ����ɾ��
	 */
	private void btnDeleteActionPerformed(ActionEvent evt) {
		System.out.println("btnDelete.actionPerformed, event=" + evt);
		// TODO add your code for btnDelete.actionPerformed
		btnQueryActionPerformed(evt);
		jLabel2.setText("ɾ����Ϣ");
		if (JOptionPane.showConfirmDialog(this,
				"ȷ��ɾ��" + tblMainView.getValueAt(1, 1) + "��ѧ����Ϣ��") == 0) {
			if (BookInfoImpl.deleteBookInfo((String) tblMainView.getValueAt(0,
					1))) {
				jLabel2.setText("ɾ���ɹ�~");
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
