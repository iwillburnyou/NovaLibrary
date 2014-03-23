package seu.Client.view.ShopView;
import java.awt.Graphics;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import k.User;

import seu.Client.bz.impl.*;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

/**
 * 商店模块的管理员界面
 * @author kidd
 *
 */
public class AdminShopView extends javax.swing.JFrame implements ActionListener {
	private JLabel jLabel2;
	//private static User user;
	private JPanel jPanel1;
	private JButton jButton7;
	private JComboBox kucunSearch;
	private JButton jButton6;
	private JTable tblKucun;
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JButton jButton3;
	private JButton jButton2;
	private Vector<String>  head;
	private DefaultTableModel dtm ;//创建表格模型
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AdminShopView inst = new AdminShopView( );
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	/**
	 *构造函数
	 */
	public AdminShopView() {
		super();
		//user=us;
		initGUI();
	}
	/**
	 * 初始化界面的函数
	 */
	private void initGUI() {
	
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			final ImageIcon backgroud = new ImageIcon(
					this.getClass().getResource("/image/333.jpg"));
			jPanel1 = new JPanel(){
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					if (backgroud != null)
						g.drawImage(backgroud.getImage(), 0, 0,
								this.getWidth(), this.getHeight(), null);
				}
			};
			AnchorLayout jPanel1Layout = new AnchorLayout();
			getContentPane().add(jPanel1, new AnchorConstraint(1, 1010, 1126, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			jPanel1.setLayout(jPanel1Layout);
			jPanel1.setBackground(new java.awt.Color(255,255,255));
			jPanel1.setPreferredSize(new java.awt.Dimension(729, 504));
		
			getContentPane().setBackground(new java.awt.Color(255,255,255));
			{
				jButton2 = new JButton();
				jPanel1.add(jButton2, new AnchorConstraint(145, 247, 247, 95, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton2.setText("\u5546\u54c1\u4e0b\u67b6");
				jButton2.setEnabled(false);
				jButton2.setPreferredSize(new java.awt.Dimension(111, 51));
				jButton2.setContentAreaFilled(false);
				jButton2.addActionListener(this);
			}
			{
				jButton3 = new JButton();
				jPanel1.add(jButton3, new AnchorConstraint(38, 936, 124, 788, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton3.setText("\u65b0\u54c1\u4e0a\u67b6");
				jButton3.setPreferredSize(new java.awt.Dimension(108, 43));
				jButton3.setContentAreaFilled(false);
				jButton3.addActionListener(this);
			}
			{
				jScrollPane1 = new JScrollPane();
				jPanel1.add(jScrollPane1);
				jScrollPane1.setBackground(new java.awt.Color(255,255,255));
				{
					head=new Vector<String>();
					{head.add("商品编号");head.add("商品类别");head.add("商品名称");head.add("商品价格");head.add("商品库存");}
					Vector<Vector> data = new Vector<Vector>();
					dtm=new DefaultTableModel(data,head);
					tblKucun=new JTable();
					jPanel1.add(jScrollPane1, new AnchorConstraint(320, 923, 800, 45, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jScrollPane1.setPreferredSize(new java.awt.Dimension(640, 242));
					jScrollPane1.setViewportView(tblKucun);
					
					tblKucun.setLayout(null);
					tblKucun.setModel(dtm);
					tblKucun.getTableHeader().setPreferredSize(new java.awt.Dimension(708, 21));
					tblKucun.getTableHeader().setBounds(0, 0, 708, 21);
					tblKucun.setBounds(12, 208, 693, 214);
					tblKucun.addMouseListener(new  MouseAdapter() {
						public void mouseClicked(MouseEvent e){
							if (e.getButton()==MouseEvent.BUTTON1){
								
								jButton2.setEnabled(true);
								
							}
						}
					});

					/**TableModel tblKucunModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] {  "商品类别" , "商品名称", "商品价格" ,  "库存" });
					tblKucun = new JTable();
					jScrollPane1.setViewportView(tblKucun);
					tblKucun.setModel(tblKucunModel);
					*/
				}
			}
			{
				jButton6 = new JButton();
				jPanel1.add(jButton6, new AnchorConstraint(145, 508, 249, 340, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton6.setText("\u589e\u52a0\u5e93\u5b58");
				jButton6.setPreferredSize(new java.awt.Dimension(122, 52));
				jButton6.setContentAreaFilled(false);
				jButton6.addActionListener(this);
			}
			{
				ComboBoxModel kucunSearchModel = 
						new DefaultComboBoxModel(
								new String[] { "低于50件", "50件以上","全部" });
				kucunSearch = new JComboBox();
				jPanel1.add(kucunSearch, new AnchorConstraint(36, 410, 114, 265, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				kucunSearch.setModel(kucunSearchModel);
				kucunSearch.setPreferredSize(new java.awt.Dimension(106, 39));
			
			}
			{
				jButton7 = new JButton();
				jPanel1.add(jButton7, new AnchorConstraint(40, 567, 112, 450, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton7.setText("\u67e5\u8be2");
				jButton7.setPreferredSize(new java.awt.Dimension(85, 36));
				jButton7.setContentAreaFilled(false);
				jButton7.addActionListener(this);
			}
			{
				jLabel2 = new JLabel();
				jPanel1.add(jLabel2, new AnchorConstraint(50, 224, 110, 45, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel2.setText("\u5546\u54c1\u5e93\u5b58\u67e5\u8be2\u4e00\u89c8\u8868");
				jLabel2.setPreferredSize(new java.awt.Dimension(130, 30));
			}
			{
				jButton1 = new JButton();
				jPanel1.add(jButton1, new AnchorConstraint(145, 740, 245, 582, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton1.setText("\u4fee\u6539\u4ef7\u683c");
				jButton1.setPreferredSize(new java.awt.Dimension(115, 50));
				jButton1.setContentAreaFilled(false);
				jButton1.addActionListener(this);
			}
			pack();
			;
			this.setSize(745, 542);
			this.setTitle("SEU商店管理系统-管理员");

			this.setExtendedState(this.MAXIMIZED_BOTH);
			
			this.setVisible(true);
	
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	/**
	 * 各种按钮的响应函数
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//查询库存较少商品信息
		/**if (e.getSource()==jButton7){
			//jButton7查询按钮 根据 选择的库存段进行调用数据库 显示库存价格
			Vector<Vector> vec = new ShopImpl().ShAllPro();
			dtm.setDataVector(vec, head);//更新table
			tblKucun.updateUI();
			tblKucun.repaint();	
		
		}
		//查找需要增加库存商品信息
		else if (e.getSource()==jButton4){
			//jButton7查询按钮 根据 选择的库存段进行调用数据库 显示库存价格
			Vector<Vector> vec = new ShopImpl().ShNeedAddPro();
			dtm.setDataVector(vec, head);//更新table
			tblKucun.updateUI();
			tblKucun.repaint();	
		
		}
		*/
		//查询库存较少商品信息含下拉限制条件的
				if (e.getSource()==jButton7){
					//jButton7查询按钮 根据 选择的库存段进行调用数据库 显示库存价格
					Vector<Vector> vec = null;
					try {
						Object i=kucunSearch.getSelectedIndex();
						String s=i.toString();
						vec = new ShopImpl().Shkucun(s);
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dtm.setDataVector(vec, head);//更新table
					tblKucun.updateUI();
					tblKucun.repaint();	
				
				}
		
			
		
		//修改商品信息
		else if(e.getSource()==jButton6||e.getSource()==jButton1){
			new ChangeProInfoJDialog(null);
			//   弹出对话框 根据表格显示数据 输入待修改产品名称  进行修改添加库存 修改价格等操作
			//
			 
			 
			
		}
	
		//新品上架 弹出对话框
		else if(e.getSource()==jButton3){
			new AddProJDialog(null);
		   /*
		    * 将输入框数据入表
		    */
			
		}
		//商品下架操作
		else if (e.getSource()==jButton2){
			/*
			 * 根据选中行进行删除操作 弹出对话框进行确认
			 * 
			 */
			int i=JOptionPane.showConfirmDialog(this, "是否确认删除该商品？", "商品下架",JOptionPane.YES_NO_CANCEL_OPTION );
			//int column=tblKucun.getSelectedColumn();
			if(i==JOptionPane.YES_OPTION){
				int row=tblKucun.getSelectedRow();
				Object obj=tblKucun.getValueAt(row,2);
				dtm.removeRow(row);
				String str=obj.toString() ;		
				try {
					try {
						new ShopImpl().DelPro(str);
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			//new DelComfJDialog(null);
		}
	}

}
