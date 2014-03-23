package seu.Client.view.ShopView;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import k.User;

import seu.Client.bz.impl.*;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

/**
 * ���ﳵ���������
 * @author kidd
 *
 */
public class StuCartView extends javax.swing.JFrame implements ActionListener {
	private JLabel jLabel2;
	private JPanel jPanel1;
	private JButton jButton4;
	private JButton jButton1;
	private JScrollPane jScrollPane1;
	private JTable tblCart;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabel1;
	private JButton jButton2;
	private JButton jButton5;
	private JButton jButton3;
	private Vector<String> head;
	private DefaultTableModel dtm;// �������ģ��

	/**
	 * Auto-generated main method to display this JFrame
	 * 
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StuCartView inst = new StuCartView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public StuCartView() {
		super();

		initGUI();

	}
	/**
	 * ��ʼ������ĺ���
	 */
	private void initGUI() {
		this.setTitle("SEU�̵����ϵͳ-ѧ��-�ҵĹ��ﳵ");
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			final ImageIcon backgroudLeft = new ImageIcon(this.getClass().getResource("/image/333.jpg"));
			{
				jPanel1 = new JPanel() {

					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (backgroudLeft != null)
							g.drawImage(backgroudLeft.getImage(), 0, 0,
									this.getWidth(), this.getHeight(), null);
					}
				};
				AnchorLayout jPanel1Layout = new AnchorLayout();
				getContentPane().add(
						jPanel1,
						new AnchorConstraint(1, 1004, 1066, -4,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBackground(new java.awt.Color(142, 238, 211));
				jPanel1.setPreferredSize(new java.awt.Dimension(727, 504));
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1, new AnchorConstraint(245, 984,
							758, 25, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane1.setPreferredSize(new java.awt.Dimension(694,
							259));
					{
						Vector<Vector> data = new Vector<Vector>();
						head = new Vector<String>();
						{
							head.add("��Ʒ���");
							head.add("��Ʒ���");
							head.add("��Ʒ����");
							head.add("��Ʒ�۸�");
							head.add("��������");
						}
						;
						dtm = new DefaultTableModel(data, head);
						tblCart = new JTable();

						jPanel1.add(jScrollPane1, new AnchorConstraint(292,
								992, 786, 17, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
						jScrollPane1.setPreferredSize(new java.awt.Dimension(
								701, 249));
						jScrollPane1.setViewportView(tblCart);

						tblCart.setLayout(null);
						tblCart.setModel(dtm);
						tblCart.getTableHeader().setPreferredSize(
								new java.awt.Dimension(708, 21));
						tblCart.getTableHeader().setBounds(0, 0, 708, 21);
						tblCart.setBounds(12, 208, 693, 214);

						tblCart.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								if (e.getButton() == MouseEvent.BUTTON1) {

									jButton2.setEnabled(true);

								}
							}
						});
					}
				}
			}

			{
				jButton3 = new JButton();
				jPanel1.add(jButton3, new AnchorConstraint(22, 472, 90, 283,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton3.setText("\u7ee7\u7eed\u6dfb\u52a0");
				jButton3.setFont(new java.awt.Font("΢���ź�", 0, 14));
				jButton3.setPreferredSize(new java.awt.Dimension(138, 34));
				jButton3.setBackground(new java.awt.Color(171, 238, 241));
				jButton3.setContentAreaFilled(false);
				jButton3.addActionListener(this);

			}
			{
				jButton4 = new JButton();
				jPanel1.add(jButton4, new AnchorConstraint(100, 250, 167, 61,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton4.setText("\u786e\u8ba4\u652f\u4ed8");
				jButton4.setFont(new java.awt.Font("΢���ź�", 0, 14));
				jButton4.setPreferredSize(new java.awt.Dimension(138, 34));
				jButton4.setBackground(new java.awt.Color(171, 238, 241));
				jButton4.setContentAreaFilled(false);
				jButton4.addActionListener(this);
			}
			{
				jLabel2 = new JLabel();
				jPanel1.add(jLabel2, new AnchorConstraint(824, 681, 887, 572,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel2.setText("\u603b\u8ba1\u91d1\u989d");
				jLabel2.setFont(new java.awt.Font("΢���ź�", 0, 14));
				jLabel2.setPreferredSize(new java.awt.Dimension(79, 32));
			}
			{
				jButton5 = new JButton();
				jPanel1.add(jButton5, new AnchorConstraint(24, 250, 90, 59,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton5.setText("\u6211\u7684\u8d2d\u7269\u8f66");
				jButton5.setPreferredSize(new java.awt.Dimension(139, 33));
				jButton5.setBackground(new java.awt.Color(171, 238, 241));
				jButton5.setContentAreaFilled(false);
				jButton5.addActionListener(this);
			}
			{
				jButton2 = new JButton();
				jPanel1.add(jButton2, new AnchorConstraint(824, 225, 895, 80,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton2.setText("\u5220\u9664\u8be5\u5546\u54c1");
				jButton2.setEnabled(false);
				jButton2.setPreferredSize(new java.awt.Dimension(106, 36));
				jButton2.setBackground(new java.awt.Color(171, 238, 241));
				jButton2.setContentAreaFilled(false);
				jButton2.addActionListener(this);
			}
			{
				jLabel1 = new JLabel();
				jPanel1.add(jLabel1, new AnchorConstraint(18, 704, 92, 571,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("\u8d26\u6237\u4f59\u989d");
				jLabel1.setFont(new java.awt.Font("΢���ź�", 0, 14));
				jLabel1.setPreferredSize(new java.awt.Dimension(97, 37));
			}
			{
				jLabel3 = new JLabel();
				jPanel1.add(jLabel3, new AnchorConstraint(36, 790, 78, 720,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel3.setText("100");// ����getCount���� ��ʾ�˻����
				jLabel3.setPreferredSize(new java.awt.Dimension(51, 21));
			}
			{
				jLabel4 = new JLabel();
				jPanel1.add(jLabel4, new AnchorConstraint(842, 745, 875, 716,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel4.setText("100");// ����getSum���� ��ʾ���ﳵ��Ʒ�ܼ�
				jLabel4.setPreferredSize(new java.awt.Dimension(21, 17));
			}
			{
				jButton1 = new JButton();
				jPanel1.add(jButton1, new AnchorConstraint(100, 473, 171, 283,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton1.setText("\u5df2\u8d2d\u4e70\u5546\u54c1");
				jButton1.setPreferredSize(new java.awt.Dimension(139, 36));
				jButton1.setBackground(new java.awt.Color(171, 238, 241));
				jButton1.setContentAreaFilled(false);
				jButton1.addActionListener(this);
			}
			pack();
			this.setSize(736, 511);
			this.setExtendedState(this.MAXIMIZED_BOTH);
			this.setVisible(true);

		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jButton3) {// �����̵�������
			new StuShopProView();
			this.dispose();
		}

		else if (e.getSource() == jButton5) {// ��ʾ�ҵĹ��ﳵ��
			Vector<Vector> vec = null;
			try {
				String str = null;
				vec = new ShopImpl().ShCart(str);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dtm.setDataVector(vec, head);// ����table
			tblCart.updateUI();
			tblCart.repaint();
		} else if (e.getSource() == jButton1) {// ��ʾ�ѹ�����Ʒ���
			Vector<Vector> vec = null;

			try {
				String str = null;
				vec = new ShopImpl().ShPaidPro(str);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dtm.setDataVector(vec, head);// ����table
			tblCart.updateUI();
			tblCart.repaint();
		} else if (e.getSource() == jButton2) {// ɾ�����ﳵ����Ʒ

			// if (PayComfJDialog().)
			int row = tblCart.getSelectedRow();
			Object obj = tblCart.getValueAt(row, 2);
			dtm.removeRow(row);
			String str = obj.toString();
			try {
				try {
					new ShopImpl().DelCartPro(str);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jButton2.setEnabled(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource() == jButton4) {// ȷ��֧��
			int i = JOptionPane.showConfirmDialog(this, "���Ƿ����ȷ��֧����", "���ﳵ",
					JOptionPane.YES_NO_OPTION);
			// new PayComfJDialog(null);
			// if (PayComfJDialog().)
			if (i == JOptionPane.YES_OPTION) {
				// ������ �ӹ��ﳵ�Ƴ� �ѹ��������� ѧ���˺ſ�Ǯ ����Ա�˺ż�Ǯ
				/**
				 * int row=tblKucun.getSelectedRow(); Object
				 * obj=tblKucun.getValueAt(row,2); dtm.removeRow(row); String
				 * str=obj.toString() ; try { new ShopImpl().DelPro(str); }
				 * catch (SQLException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 */
				int row = dtm.getRowCount();
				int r = 0;
				if (tblCart.getRowCount() == 0)
					JOptionPane.showMessageDialog(this, "���ﳵΪ�գ��������Ʒ��", "ȷ�ϸ���",
							JOptionPane.WARNING_MESSAGE);
				// while(tblCart.getValueAt(r,1)!=null){
				else {
					// �жϹ��������Ƿ���ڿ�棡 �ǵĻ�����
					for (r = 0; r < row; r++) {
						Object obj1 = tblCart.getValueAt(r, 1);
						String str1 = obj1.toString();
						Object obj2 = tblCart.getValueAt(r, 2);
						String str2 = obj2.toString();
						Object obj3 = tblCart.getValueAt(r, 3);
						String str3 = obj3.toString();
						Object obj4 = tblCart.getValueAt(r, 4);
						String str4 = obj4.toString();

						try {
							String string = new ShopImpl().PayForBill(str1,
									str2, str3, str4);
							System.out.println("222" + string);
							if (string.equals("��治��")) {
								System.out.println("111" + string);
								JOptionPane.showMessageDialog(this, "��Ʒ" + str2
										+ "��治�� ������޸ģ�", "ȷ�ϸ���",
										JOptionPane.WARNING_MESSAGE);
								break;
							}

						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					System.out.println(tblCart.getRowCount());
					if (r == row)
						JOptionPane.showMessageDialog(this, "���ѳɹ���", "��Ϣ",
								JOptionPane.INFORMATION_MESSAGE);
					System.out.println("end");

				}

			}
		}
	}

}
