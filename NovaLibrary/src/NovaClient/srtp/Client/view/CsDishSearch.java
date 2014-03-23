package seu.Client.view;
/**
 * 学生菜品查询的类 --by 张雅淋
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import k.User;

import seu.Client.bz.impl.CanteenInfoImpl;
import seu.Client.bz.impl.CommonImpl;


public class CsDishSearch extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int flag;
	String sql;
	User user;
	
	private JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true); //分割窗体上下分割
	
	
	
	private String []str ={"菜名","菜系","食堂","全部"};
	private JComboBox<String> jcb = new JComboBox<String>(str);
	private JButton jb ;
	private JLabel []jlArray= new JLabel[]{
			new JLabel("菜   名"),new JLabel("菜   系"),new JLabel("食   堂")
	};
	private JTextField []jtxtArray = new JTextField[]{
			new JTextField(),new JTextField(),new JTextField(),new JTextField()
	};
	
	private String []str2 ={"鲁菜","川菜","苏菜","浙菜","粤菜","湘菜","徽菜","闽菜"};
	private JComboBox<String> jcb2 = new JComboBox<String>(str2);
	private String []str3 ={"梅园","橘园","桃园"};
	private JComboBox<String> jcb3 = new JComboBox<String>(str3);
	private JRadioButton []jrbArray = new JRadioButton[]{
			new JRadioButton("简单查询", true),new JRadioButton("高级查询")
	};
	private ButtonGroup bg = new ButtonGroup();
	Vector<String> head = new Vector<String>();
	{head.add("菜名");head.add("菜系");head.add("食堂");head.add("外卖");head.add("价格");
	};
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	DefaultTableModel dtm = new DefaultTableModel(data, head);//创建表格模型
	JTable jt = new JTable(dtm);
	JScrollPane jspn=new JScrollPane(jt);
	
	final ImageIcon backgroundtop = new ImageIcon(this.getClass().getResource("/image/食堂右1.png"));
	final ImageIcon backgroundtop2 = new ImageIcon(this.getClass().getResource("/image/食堂右2.png"));
	/**
	 * 查询界面构造器
	 */
	public CsDishSearch(User us){
		user = us;
		
		JPanel jpt = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundtop != null){
					g.drawImage(backgroundtop.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
				}
			}
		};
		 JPanel jpb = new JPanel(){
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					if (backgroundtop2 != null){
						g.drawImage(backgroundtop2.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
					}
				}	
		};
		
		jb=new JButton();
	    Icon generl1=new ImageIcon (this.getClass().getResource("/image/cx1.png"));
		Icon press1=new ImageIcon(this.getClass().getResource("/image/cx2.png"));
		Icon rollover1=new ImageIcon(this.getClass().getResource("/image/cx3.png"));
		jb.setRolloverEnabled(true);
		jb.setIcon(generl1);
		jb.setRolloverIcon(rollover1);
		jb.setPressedIcon(press1);
		jb.setContentAreaFilled(false);
		jb.setBorderPainted(false);
		
		jpt.setOpaque(false);
		this.setLayout(new GridLayout(1,1));
		
		jt.setFont(new Font("幼圆", Font.PLAIN, 16));
		jt.getTableHeader().setFont(new Font("幼圆", Font.PLAIN, 16));
		jt.getTableHeader().setBackground(Color.white);
		
		
		jspn.setBounds(0, 0, 870, 440);//调整下方表格大小
		jpt.setLayout(null);
		jpb.setLayout(null);
		jpt.add(jcb);
		jcb.setBounds(160, 20, 80, 20);
		jcb.setFont(new Font("幼圆", Font.PLAIN, 14));
		jcb.setEditable(false);
		jcb.addActionListener(this);
		jpt.add(jb);
		jpb.add(jspn);
		jb.setBounds(520, 2, 180, 150);
		jb.setFont(new Font("幼圆", Font.PLAIN, 16));
		jb.addActionListener(this);
		for(int i =0;i<2;i++){
			jrbArray[i].setBounds(20, 20+i*40, 100, 20);
			jrbArray[i].setFont(new Font("幼圆", Font.PLAIN, 16));
			jpt.add(jrbArray[i]);
			jrbArray[i].addActionListener(this);
			bg.add(jrbArray[i]);
		}

		for(int i =0;i<3;i++){
			jlArray[i].setBounds(160,50+i*30, 80, 20);
			jlArray[i].setFont(new Font("幼圆", Font.PLAIN, 16));
			jpt.add(jlArray[i]);
		}
		
		jtxtArray[0].setBounds(270, 50, 80, 20);
		jtxtArray[0].setFont(new Font("幼圆", Font.PLAIN, 16));
		jpt.add(jtxtArray[0]);
		jtxtArray[0].setEditable(false);
		jcb2.setBounds(270, 80, 80, 20);
		jcb2.setFont(new Font("幼圆", Font.PLAIN, 14));
		jpt.add(jcb2);
		jcb2.setEnabled(false);
		jcb2.setEditable(false);
		jcb3.setBounds(270, 110, 80, 20);
		jcb3.setFont(new Font("幼圆", Font.PLAIN, 14));
		jpt.add(jcb3);
		jcb3.setEnabled(false);
		jcb3.setEditable(false);
		
		jtxtArray[3].setBounds(270, 20, 80, 20);
		jpt.add(jtxtArray[3]);
		
		jsp.setTopComponent(jpt);
		jpt.setBackground(Color.white);
		jsp.setBottomComponent(jpb);
		jspn.setBackground(Color.white);
		jsp.setDividerSize(4);
		jsp.setDividerLocation(150);
		
		this.add(jsp);
		this.setBounds(0, 0, 800, 600);
		this.setVisible(true);
	
		sql =  "select * from tblDishSearch ";
		paintTable(sql);
	}
	/**
	 * 绘制菜品表格的函数
	 * @param sqlString
	 */
	private void paintTable(String sqlString) {

		Vector<Vector<String>> vtemp =CanteenInfoImpl.getDish(sqlString);//存放表格数据的向量
		dtm.setDataVector(vtemp, head);//更新table
		jt.updateUI();
		jt.repaint();	
	}
	
	public void actionPerformed(ActionEvent e) {
		/**
		 * 简单查询处理
		 */
		if(jrbArray[0].isSelected()){//选中简单查询按钮
			jcb.setEnabled(true);
			jtxtArray[3].setEditable(true);
			for(int i =0;i<jtxtArray.length-1;i++){
				jtxtArray[i].setEditable(false);
			}
			jcb2.setEnabled(false);
			jcb3.setEnabled(false);
			if (jcb.getSelectedIndex()>=0 && jcb.getSelectedIndex()<4) {//索引项在0-2之间
				jtxtArray[3].requestFocus();
				if(e.getSource()==jb&&jcb.getSelectedIndex()<3){
					String str = jtxtArray[3].getText().trim();//得到查询条件
					if(str.equals("")){
						JOptionPane.showMessageDialog(this, "请输入查询信息！","信息",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					if(jcb.getSelectedIndex()==0){//按菜名查询
						sql = "select * from tblDishSearch where DishName='"+str+"'";
						jtxtArray[3].setText("");
					}
					else if(jcb.getSelectedIndex()==1){//按菜系查询
						sql = "select * from tblDishSearch where DishCate='"+str+"'";
						jtxtArray[3].setText("");
					}
					else if(jcb.getSelectedIndex()==2){//按食堂查询
						sql = "select * from tblDishSearch where CanteenNum='"+str+"'";
						jtxtArray[3].setText("");
					}
				
					paintTable(sql);
				}
				else if(e.getSource()==jb&&jcb.getSelectedIndex()==3){
					sql = "select *from tblDishSearch";
					paintTable(sql);
				}
			}
		}
		/**
		 * 高级查询处理
		 */
		if(jrbArray[1].isSelected()){//选中高级查询按钮？
			jtxtArray[0].requestFocus();
			jtxtArray[3].setEditable(false);
			for(int i=0;i<jtxtArray.length-1;i++){//设置下方三个按钮可编辑
				jtxtArray[i].setEditable(true);
			}
			jcb.setEnabled(false);
			jcb2.setEnabled(true);
			jcb3.setEnabled(true);
			if(e.getSource()==jb){//单击“提交”按钮
				int bz=this.seniorSearch();
				if(bz!=0){return;}
		
				paintTable(sql);
			}
		}
		
	}
	private int seniorSearch() {
		int flag = 0;
		String str0 = jtxtArray[0].getText().trim();//获得输入框的内容
		String str1 = (String) jcb2.getSelectedItem();
		String str2 = (String) jcb3.getSelectedItem();
		//String str1 = jtxtArray[1].getText().trim();
		//String str2 = jtxtArray[2].getText().trim();
		if(str0.equals("")&&str1.equals("")&&str2.equals("")){
			JOptionPane.showMessageDialog(this, "请输入必要的信息","信息",JOptionPane.INFORMATION_MESSAGE);
			flag = 1;
		}
		else if(((!str0.equals(""))&&(str1.equals(""))&&(str2.equals("")))||((str0.equals(""))&&(!str1.equals(""))&&(str2.equals("")))||((str0.equals(""))&&(str1.equals(""))&&(!str2.equals("")))){
			JOptionPane.showMessageDialog(this, "请使用简单搜索","信息",JOptionPane.INFORMATION_MESSAGE);
			flag = 1;
		}
		else if((!str0.equals(""))&&(!str1.equals(""))&&(str2.equals(""))){//菜名和菜系组合
			sql = "select * from tblDishSearch where DishName='"+str0+"' and DishCate='"+str1+"'";
			for(int i=0;i<3;i++){
				jtxtArray[i].setText("");
			}
		}
		else if((!str0.equals(""))&&(str1.equals(""))&&(!str2.equals(""))){//菜名和食堂组合
			sql = "select * from tblDishSearch where DishName='"+str0+"' and CanteenNum='"+str2+"'";
			for(int i=0;i<3;i++){
				jtxtArray[i].setText("");
			}
		}
		else if((str0.equals(""))&&(!str1.equals(""))&&(!str2.equals(""))){//食堂和菜系组合
			sql = "select * from tblDishSearch where DishCate='"+str1+"' and CanteenNum='"+str2+"'";
			for(int i=0;i<3;i++){
				jtxtArray[i].setText("");
			}
		}
		else if((!str0.equals(""))&&(!str1.equals(""))&&(!str2.equals(""))){//三者组合
			sql = "select * from tblDishSearch where DishName='"+str0+"' and DishCate='"+str1+"' and CanteenNum='"+str2+"'";
			for(int i=0;i<3;i++){
				jtxtArray[i].setText("");
			}
		}
		return flag;
	}
	
	 
}
