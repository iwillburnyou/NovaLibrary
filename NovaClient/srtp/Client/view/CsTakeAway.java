package seu.Client.view;
/**
 * 学生外卖订购的类 --By张雅淋
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import k.User;

import seu.Client.bz.impl.CanteenInfoImpl;
import sun.jdbc.odbc.JdbcOdbc;


public class CsTakeAway extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int flag;
	String sql;
	String sql1;
	User user;
	private JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);//界面上下分割
	private JSplitPane jpt = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false);//界面左右分割
	
	private JLabel jl = new JLabel("查询条件");
	private String []str ={"菜名","菜系","食堂","全部"};
	private JComboBox<String> jcb = new JComboBox<String>(str);
	private JTextField jtf = new JTextField();
	private JButton jbs = new JButton("查询");
	private JButton jbdx = new JButton("订购选中项");
	private JButton jbdc = new JButton("撤销选中项");
	private JButton jbdf = new JButton("订购完毕");
	Vector<String> headt = new Vector<String>();
	{headt.add("菜名");headt.add("价格");headt.add("订购人");headt.add("订购时间");headt.add("是否发货");
	};
	Vector<Vector<String>> datat = new Vector<Vector<String>>();
	DefaultTableModel dtmt = new DefaultTableModel(datat, headt);//创建上部分表格模型
	JTable jtt = new JTable(dtmt); //订购外卖显示的表
	JScrollPane jspnt=new JScrollPane(jtt);
	
	Vector<String> head = new Vector<String>();//查询菜品显示的表
	{head.add("菜名");head.add("菜系");head.add("食堂");head.add("外卖");head.add("价格");
	};
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	DefaultTableModel dtm = new DefaultTableModel(data, head);//创建表格模型
	JTable jt = new JTable(dtm);

	JScrollPane jspn=new JScrollPane(jt);
	private ImageIcon background= new ImageIcon(this.getClass().getResource("/image/食堂右1.png")); 
	final ImageIcon background2 = new ImageIcon(this.getClass().getResource("/image/食堂右1.png"));
	final ImageIcon background3 = new ImageIcon(this.getClass().getResource("/image/食堂右2.png"));
	
	public CsTakeAway(User us){
		user = us;
		
		JPanel jptl = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				//if (background1 != null){
					//g.drawImage(background1.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
				}
			};
		
		//上界面左部分
		
		JPanel jptr = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (background2!= null){
					g.drawImage(background2.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
				}
			}
		};//上界面右部分
		JPanel jpb = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (background3 != null){
					g.drawImage(background3.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
				}
			}
		
		};//下界面
        JLabel label = new JLabel(background); 
        label.setBounds(0, 0, this.getWidth(), this.getHeight()); 
		this.setOpaque(false);	
		
		this.setLayout(new GridLayout(1, 1));
		jl.setFont(new Font("幼圆", Font.PLAIN, 16));
		jbdc.setFont(new Font("幼圆", Font.PLAIN, 14));//字体改
	    jbdc.setBackground(null);
		jbs.setFont(new Font("幼圆", Font.PLAIN, 16));
		jbs.setBackground(null);
		jbdf.setFont(new Font("幼圆", Font.PLAIN, 14));//字体改
	    jbdf.setBackground(null);
		jbdx.setFont(new Font("幼圆", Font.PLAIN, 14));//字体改
	    jbdx.setBackground(null);
		jt.setFont(new Font("幼圆", Font.PLAIN, 16));
		jt.getTableHeader().setFont(new Font("幼圆", Font.PLAIN, 16));
		jtt.setFont(new Font("幼圆", Font.PLAIN, 16));
		jtt.getTableHeader().setFont(new Font("幼圆", Font.PLAIN, 16));
		jtf.setFont(new Font("幼圆", Font.PLAIN, 16));
		jcb.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		jpb.setLayout(null);
		jptr.setLayout(null);
		jptl.setLayout(null);
		jptl.add(jl);
		jl.setBounds(20,5,100,20);
		jptl.add(jcb);
		jcb.setBounds(20,30,100,30);
		jcb.addActionListener(this);
		jptl.add(jtf);
		jtf.setBounds(20,70,100,30);
		jptl.add(jbs);
		jbs.setBounds(20,110, 100, 30);
		jbs.addActionListener(this);
		jptr.add(jbdx);//上右界面
		jbdx.setBounds(20,20, 100, 30);
		jbdx.addActionListener(this);
		jbdx.setEnabled(false);
		jptr.add(jbdc);
		jbdc.setBounds(20,70, 100, 30);
		jbdc.addActionListener(this);
		jbdc.setEnabled(false);
		jptr.add(jbdf);
		jbdf.setBounds(20,120, 100, 30);
	    jbdf.setBackground(null);
		jbdf.addActionListener(this);
		jptr.add(jspnt);
		
		jspnt.setBounds(160, 20, 450, 120);//调整上方表格大小
		jspn.setBounds(0, 0, 870, 420);//调整下方表格大小
		
		
		jpt.setLeftComponent(jptl);
		jptl.setBackground(Color.white);
		jpt.setRightComponent(jptr);
		jptr.setBackground(Color.white);
		jpt.setDividerLocation(140);
		jpt.setDividerSize(4);
		jt.getTableHeader().setBackground(Color.white);
		jtt.getTableHeader().setBackground(Color.white);
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event){
				if(event.getButton()==MouseEvent.BUTTON1){
					jbdx.setEnabled(true);
				}
			}
		});
		
		jtt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event){
				if(event.getButton()==MouseEvent.BUTTON1){
					jbdc.setEnabled(true);
				}
			}
		});
		
		
		jsp.setDividerSize(4);
		jsp.setDividerLocation(170);
		jsp.setTopComponent(jpt);
		jpt.setBackground(Color.white);
		jsp.setBottomComponent(jpb);
		jpb.add(jspn);
		jspn.setBackground(Color.white);
		
		this.add(jsp);
		this.setBounds(0, 0, 800, 600);
		this.setVisible(true);
		sql =  "select * from tblDishSearch where TakeAway = '是'";
	    sql1 = "select * from tblDishBuy where Buyer = '"+user.getName()+"'";
		paintTable(sql);
		paintTopTable(sql1);
	}
	 /** 绘制菜品表格的函数
	 * @param sqlString
	 */
	private void paintTable(String sqlString) {//绘制下方表格

		Vector<Vector<String>> vtemp =CanteenInfoImpl.getDish(sqlString);//存放表格数据的向量
		dtm.setDataVector(vtemp, head);//更新table
		jt.updateUI();
		jt.repaint();	
	
	}
	private void paintTopTable(String sqlString) {//绘制上方表格

		Vector<Vector<String>> vtemp =CanteenInfoImpl.getDish(sqlString);//存放表格数据的向量
		dtmt.setDataVector(vtemp, headt);//更新table
		jtt.updateUI();
		jtt.repaint();	
	}
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbs&&jcb.getSelectedIndex() == 3){
				sql =  "select * from tblDishSearch where TakeAway = '是'";
				jtf.setText("");
				paintTable(sql);
			}
		else if(e.getSource()==jbs){//点击查询按钮
			String str = jtf.getText().trim();//得到查询条件
			if(str.equals("")){
				JOptionPane.showMessageDialog(this, "请输入查询信息！","信息",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(jcb.getSelectedIndex()==0){//按菜名查询
				sql = "select * from tblDishSearch where DishName='"+str+"'and TakeAway = '是'";
				jtf.setText("");
			}
			else if(jcb.getSelectedIndex()==1){//按菜系查询
				sql = "select * from tblDishSearch where DishCate='"+str+"'and TakeAway = '是'";
				jtf.setText("");
			}
			else if(jcb.getSelectedIndex()==2){//按食堂查询
				sql = "select * from tblDishSearch where CanteenNum='"+str+"'and TakeAway = '是'";
				jtf.setText("");
			}
			paintTable(sql);
		}
		
		if(e.getSource()==jbdx){//点订购选中项的操作 
			int rowIndex = jt.getSelectedRow();
			String dishNameString = (String)jt.getValueAt(rowIndex ,0);
			String Price = (String)jt.getValueAt(rowIndex, 4); 
			Date currentTime = new Date(System.currentTimeMillis()); 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
			String dateString = formatter.format(currentTime); 
			String buyerString = user.getName();
			String ifSendString  = "否";
			String sqlString = "insert into tblDishBuy  values('" + dishNameString +"','" +Price + "','" +buyerString+ "','" +dateString + "','" +ifSendString + "')";
		
			CanteenInfoImpl.addDishBuy(sqlString);
			paintTopTable("select * from tblDishBuy where Buyer = '"+user.getName()+"'");
			jbdx.setEnabled(false);
		}
		if(e.getSource()==jbdc){//点订购撤销操作
			int rowIndex = jtt.getSelectedRow();
			String dishString = (String)jtt.getValueAt(rowIndex, 0);
			String sqlString = "delete from tblDishBuy where DishName = '"+dishString+"'";
			CanteenInfoImpl.delDishBuy(sqlString);
			paintTopTable("select * from tblDishBuy where Buyer = '"+user.getName()+"'");
			jbdc.setEnabled(false);
		}
		if(e.getSource()==jbdf){//点订购完毕按钮
			int sumPrice = getSumPrice();
			JOptionPane.showMessageDialog(this, "总价格为："+sumPrice,"信息",JOptionPane.INFORMATION_MESSAGE);
	
		}
	}
	private int getSumPrice() {
		int sum = 0;
		Vector<Vector<String>> vtemp = CanteenInfoImpl.getAllDishBuy("select * from tblDishBuy where Buyer = '"+user.getName()+"'");
		for(int i =0;i<vtemp.size();i++){
			Vector<String> vector =vtemp.get(i);
			//System.out.println(vector.elementAt(1));
			sum += Integer.parseInt(vector.elementAt(1) );
		}
		return sum;
	}
	
	 public void paintComponent(Graphics g) { 
			g.drawImage(background.getImage(), 0, 0,this);   
			super.paintComponents(g); 
		}
}
