package seu.Client.view.ShopView;
import seu.Client.bz.impl.*;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import k.User;


/**
 * 商店模块学生界面
 */
public class StuShopProView extends javax.swing.JFrame 
		implements ActionListener {
	private JPanel jPanel1;
	private  User user;
	private JButton jButton1;
	private JLabel jLabel2;
	private JScrollPane jScrollPane1;
	private JButton jButton2;
	private JTextField jTextField1;
	private JLabel jLabel3;
	private JButton jButton7;
	private JButton jButton6;
	private JButton jButton5;
	private JButton jButton4;
	private JButton jButton3;
	private JTable tblProduct;
	private JTextField jTextFieldProName;
	private JLabel jLabelSearch;
	private JLabel jLabel1;
	private Vector<String>  head;
	private DefaultTableModel dtm ;//创建表格模型
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StuShopProView inst = new StuShopProView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public StuShopProView() {
		super();
		//user=user;
		initGUI();
	}
	/**
	 * 商店学生模块的构造函数
	 * @author kidd
	 * @param user
	 * 用户信息实体类的一个对象
	 */
	public StuShopProView(User user) {
		// TODO Auto-generated constructor stub
		super();
		this.user=user;
		//System.out.println(this.user);
		initGUI();
	}
	/**
	 * 初始化界面的函数
	 */
	private void initGUI() {
		//try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			
	
			getContentPane().setBackground(new java.awt.Color(255,255,255));
			final ImageIcon backgroudLeft = new ImageIcon(
					this.getClass().getResource("/image/333.jpg"));
			{
				jPanel1 = new JPanel(){
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (backgroudLeft != null)
							g.drawImage(backgroudLeft.getImage(), 0, 0,
									this.getWidth(), this.getHeight(), null);
					}
				};
				AnchorLayout jPanel1Layout = new AnchorLayout();
				getContentPane().add(jPanel1, new AnchorConstraint(0, 1000, 991, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBackground(new java.awt.Color(255,255,255));
				jPanel1.setPreferredSize(new java.awt.Dimension(729, 499));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(43, 126, 94, 33, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("\u5546\u54c1\u5206\u7c7b");
					jLabel1.setPreferredSize(new java.awt.Dimension(68, 26));
				}
				{
					jLabelSearch = new JLabel();
					jPanel1.add(jLabelSearch, new AnchorConstraint(153, 142, 215, 32, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabelSearch.setText("\u9ad8\u7ea7\u641c\u7d22");
					jLabelSearch.setPreferredSize(new java.awt.Dimension(79, 31));
				}
				{
					jTextFieldProName = new JTextField();
					jPanel1.add(jTextFieldProName, new AnchorConstraint(161, 498, 225, 333, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jTextFieldProName.setPreferredSize(new java.awt.Dimension(119, 32));
					
					
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2, new AnchorConstraint(165, 294, 215, 180, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel2.setText("\u5546\u54c1\u540d\u79f0");
					jLabel2.setPreferredSize(new java.awt.Dimension(82, 25));
				}
				{
					jButton1 = new JButton();
		
					jPanel1.add(jButton1, new AnchorConstraint(157, 689, 215, 569, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButton1.setText("\u67e5\u8be2");
					jButton1.setPreferredSize(new java.awt.Dimension(86, 29));
					jButton1.setContentAreaFilled(false);
					jButton1.addActionListener(this);
					//jButton1.setFocusPainted(false);
					//jButton1.setRolloverEnabled(true);
					//jButton1.setIcon(btnClearIcon);
					//jButton1.setRolloverIcon( (Icon) jButton1);
					//btnDelete.setPressedIcon(btnAddPress);
					//jButton1.setContentAreaFilled(false);
					//jButton1.setBorderPainted(false);
					
					
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBackground(new java.awt.Color(255,255,255));
				}
				{
					jButton3 = new JButton();
					jPanel1.add(jButton3, new AnchorConstraint(870, 608, 934, 430, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButton3.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
					jButton3.setEnabled(false);
					jButton3.setPreferredSize(new java.awt.Dimension(130, 33));
					jButton3.setContentAreaFilled(false);
					jButton3.addActionListener(this);

				}
				{
					jButton4 = new JButton();
					jPanel1.add(jButton4, new AnchorConstraint(37, 279, 94, 151, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButton4.setText("\u5b66\u4e60\u7528\u54c1");
					jButton4.setPreferredSize(new java.awt.Dimension(93, 29));
					jButton4.setContentAreaFilled(false);
					jButton4.addActionListener(this);
				}
				{
					jButton5 = new JButton();
					jPanel1.add(jButton5, new AnchorConstraint(37, 417, 94, 294, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButton5.setText("\u751f\u6d3b\u7528\u54c1");
					jButton5.setPreferredSize(new java.awt.Dimension(90, 29));
					jButton5.setContentAreaFilled(false);
					jButton5.addActionListener(this);
				}
				{
					jButton6 = new JButton();
					jPanel1.add(jButton6, new AnchorConstraint(37, 546, 94, 424, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButton6.setText("\u98df\u54c1");
					jButton6.setPreferredSize(new java.awt.Dimension(89, 29));
					jButton6.setContentAreaFilled(false);
					jButton6.addActionListener(this);
				}
				{
					jButton7 = new JButton();
					jPanel1.add(jButton7, new AnchorConstraint(37, 672, 94, 554, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButton7.setText("\u5168\u90e8\u5546\u54c1");
					jButton7.setPreferredSize(new java.awt.Dimension(86, 29));
					jButton7.setContentAreaFilled(false);
					jButton7.addActionListener(this);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3, new AnchorConstraint(870, 184, 930, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel3.setText("\u9009\u62e9\u5546\u54c1\u6570\u91cf");
					jLabel3.setPreferredSize(new java.awt.Dimension(98, 31));
				}
				{
					jTextField1 = new JTextField();
					jPanel1.add(jTextField1, new AnchorConstraint(870, 305, 938, 209, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jTextField1.setText("1");
					jTextField1.setPreferredSize(new java.awt.Dimension(70, 35));
				}
				{
					jButton2 = new JButton();
					jPanel1.add(jButton2, new AnchorConstraint(870, 899, 927, 725, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButton2.setText("\u6211\u7684\u8d2d\u7269\u8f66");
					jButton2.setPreferredSize(new java.awt.Dimension(125, 29));
					jButton2.setContentAreaFilled(false);
					jButton2.addActionListener(this);
				}
				{
					//new String[][] { { "", "" }, { "", "" } },
					
					Vector<Vector> data = new Vector<Vector>();
					head = new Vector<String>();
					{head.add("商品编号");head.add("商品类别");head.add("商品名称");head.add("商品价格");head.add("库存");
					
					};
					//						TableModel tblProductModel = 
							//								new DefaultTableModel(
									//										data,
									//										head);
					dtm = new DefaultTableModel(data,head);
					tblProduct = new JTable();
					
					jPanel1.add(jScrollPane1, new AnchorConstraint(292, 992, 858, 17, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jScrollPane1.setPreferredSize(new java.awt.Dimension(701, 285));
					jScrollPane1.setViewportView(tblProduct);
					
					tblProduct.setLayout(null);
					tblProduct.setModel(dtm);
					tblProduct.getTableHeader().setPreferredSize(new java.awt.Dimension(708, 21));
					tblProduct.getTableHeader().setBounds(0, 0, 708, 21);
					tblProduct.setBounds(12, 208, 693, 214);
					
			
					tblProduct.addMouseListener(new  MouseAdapter() {
						public void mouseClicked(MouseEvent e){
							if (e.getButton()==MouseEvent.BUTTON1){
								
								jButton3.setEnabled(true);
								
							}
						}
					});
				}
			}
			pack();
			this.setSize(745, 542);
			this.setTitle("SEU商店管理系统-学生-商城");

			this.setExtendedState(this.MAXIMIZED_BOTH);
			
			this.setVisible(true);
			//this.setResizable(false);
		
	//	} catch (Exception e) {
		    //add your error handling code here
//			e.printStackTrace();
	//	}
	}

	public void actionPerformed(ActionEvent e) {
	if (e.getSource() == jButton2) {
			new StuCartView();
			
			this.setVisible(false);
	}else if (e.getSource()==jButton3){
		//取得选中的行的商品信息  及输入框中商品数量添加到购物车 
		//判断选中的商品在购物车中是否已经存在 存在的话直接改MyCart表中购买数量 不存在的话插入新行

		int row=tblProduct.getSelectedRow();
		Object obj1=tblProduct.getValueAt(row,1);
		String str1=obj1.toString() ;	
		Object obj2=tblProduct.getValueAt(row,2);
		String str2=obj2.toString() ;	
		Object obj3=tblProduct.getValueAt(row,3);
		String str3=obj3.toString() ;
		double i=Double.parseDouble(str3);
		
		try {
			try {
				
				new ShopImpl().AddToCart(str1,str2,i,Integer.parseInt(jTextField1.getText().trim()));
				JOptionPane.showMessageDialog(this, "加入购物车成功！");
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
		
	}
	
	else if(e.getSource()==jButton4){
		/*
		 * 调用数据库传值 将学习用品信息展示
		 * 
		 */
		//ShowStudyProImpl();
		
//		for (int i = 0; i < vec.size(); i++) {
//			Vector<String> rec = vec.get(i);
//			tblProduct.setValueAt(rec.get(1), i, 0);
//			tblProduct.setValueAt(rec.get(2), i, 1);
//			tblProduct.setValueAt(rec.get(3), i, 2);
//			tblProduct.setValueAt(rec.get(4), i, 3);
//		}
		//Vector vec = fun(jTextFieldProName.getText());
		Vector<Vector> vec = null;
		String str=null;
		try {
			vec = new ShopImpl().ShStudyPro(str);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dtm.setDataVector(vec, head);//更新table
		tblProduct.updateUI();
		tblProduct.repaint();	
	}
	
	else if(e.getSource()==jButton5){
		/*
		 * 调用数据库传值 将生活用品信息展示
		 * 
		 */
		Vector<Vector> vec = null;
		String str=null;
		try {
			vec = new ShopImpl().ShLifePro(str);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dtm.setDataVector(vec, head);//更新table
		tblProduct.updateUI();
		tblProduct.repaint();	
	}	
	else if(e.getSource()==jButton6){
		/*
		 * 调用数据库传值 将食品信息展示
		 * 
		 */
		Vector<Vector> vec = null;
		String str=null;
		try {
			vec = new ShopImpl().ShFoodPro(str);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dtm.setDataVector(vec, head);//更新table
		tblProduct.updateUI();
		tblProduct.repaint();	
	}	
		
	else if(e.getSource()==jButton7){
		/*
		 * 调用数据库传值 将全部商品信息展示
		 * 
		 */
		Vector<Vector> vec = null;
		String str=null;
		try {
			vec = new ShopImpl().ShAllPro(str);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dtm.setDataVector(vec, head);//更新table
		tblProduct.updateUI();
		tblProduct.repaint();	
	}	
	else if(e.getSource()==jButton1){
		/*
		 * 调用数据库传值 输入名称 进行精确查询
		 * 
		 * String sqlString="SELECT Name FROM Test2";
		if(jTextFieldProName.getText().trim()){
			
		}
		 */
		//Vector<Vector>  vec = new ShopImpl().SearByName(jTextFieldProName.getText();jComboBoxPriceCho.getSelectedIndex();jComboBoxPriceCho.getSelectedIndex());
		try {
			if(new ShopImpl().IsExist(jTextFieldProName.getText().trim())==false) {
				JOptionPane.showMessageDialog(this,"此商品不存在", "商品搜索",JOptionPane.WARNING_MESSAGE);
				return;
			}
			else{
				Vector<Vector>  vec = new ShopImpl().SearByName(jTextFieldProName.getText().trim());
				dtm.setDataVector(vec, head);//更新table
				tblProduct.updateUI();
				tblProduct.repaint();	
			}
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}	
	}

}
