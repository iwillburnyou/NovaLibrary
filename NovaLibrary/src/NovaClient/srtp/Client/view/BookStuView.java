package seu.Client.view;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import k.User;
import seu.Client.bz.impl.BookInfoImpl;
import seu.Client.bz.impl.CommonImpl;

/**
 * 图书馆模块用户主界面
 * @author kidd
 *
 */
public class BookStuView extends JPanel implements ActionListener{
	
	public static void main(String[] args) {
		User us=new User();
		JPanel p = new BookStuView(us);
		p.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
	int flag;//声明编号位
	String sql;
	User user;
	
	//创建各种控件
	private JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false); //分割窗体上下分割
	final ImageIcon backgroudUp=new ImageIcon(this.getClass().getResource("/image/长条.jpg"));//背景图片
	private JPanel jpt = new JPanel(){
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(backgroudUp!=null){
				g.drawImage(backgroudUp.getImage(),0, 0, this.getWidth(),this.getHeight(),null);
			}
		}
      
       
	};
	
	private String []str ={"图书名","图书id","作者"};
	private JComboBox jcb = new JComboBox(str);
	//设置查询书库按钮
	
	ImageIcon Image1=new ImageIcon(this.getClass().getResource("/image/查询书籍.jpg"));
	public  JButton jb = new JButton(Image1);
   
	//设置查询已经借阅图书
	ImageIcon Image2=new ImageIcon(this.getClass().getResource("/image/查询借书情况.jpg"));
	private JButton jbAdd = new JButton(Image2);
	
	//设置借阅图书按钮
	ImageIcon Image3=new ImageIcon(this.getClass().getResource("/image/借阅书籍.jpg"));
	private JButton jbborrow = new JButton(Image3);
	
	//设置还书按钮
	ImageIcon Image4=new ImageIcon(this.getClass().getResource("/image/还书.jpg"));
	private JButton jbrent = new JButton(Image4);
	
	//设置面板框架
	private JFrame frm ;

	private JTextField []jtxtArray = new JTextField[]{
			new JTextField(),new JTextField(),new JTextField(),new JTextField()
	};
	private JRadioButton []jrbArray = new JRadioButton[]{
			new JRadioButton("查询", true)
	};
	private ButtonGroup bg = new ButtonGroup();
	Vector<String> head = new Vector<String>();
	{head.add("图书id");head.add("图书名");head.add("出版社");head.add("作者");head.add("单价");head.add("出版日期");head.add("图书种类");
	};
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	DefaultTableModel dtm = new DefaultTableModel(data, head);//创建表格模型
	JTable jt = new JTable(dtm);
	JScrollPane jspn=new JScrollPane(jt);
	/**
	 * 查询界面构造器
	 */
	public BookStuView(User us){
		user =us;
		System.out.println(user.getCardNo());
		this.setLayout(new GridLayout(1,1));
		this.setName("东南大学图书馆");
		//设置布局
		jpt.setLayout(null);
		jpt.add(jcb);//添加组件下拉框
		jcb.setBounds(160, 20, 100, 20);
		jcb.addActionListener(this);
		jpt.add(jb);
		jpt.add(jbborrow);
		jpt.add(jbAdd);
		jpt.add(jbrent);
		//设置按钮大小位置
		jb.setBounds(230, 80, 160, 60);
		jb.setContentAreaFilled(false);//设置透明
		jb.setBorderPainted(false);//去除边框
		
		jbrent.setBounds(230, 160, 160, 60);
		jbrent.setContentAreaFilled(false);//设置透明
		jbrent.setBorderPainted(false);//去除边框
		
		jbborrow.setBounds(230, 240, 160, 60);
		jbborrow.setContentAreaFilled(false);//设置透明
		jbborrow.setBorderPainted(false);//去除边框
		
		jbAdd.setBounds(230, 320, 160, 60);
		jbAdd.setContentAreaFilled(false);//设置透明
		jbAdd.setBorderPainted(false);//去除边框
		
		//监听
		jb.addActionListener(this);
		jbborrow.addActionListener(this);
		jbAdd.addActionListener(this);
		jbrent.addActionListener(this);
	
		
		for(int i =0;i<1;i++){
			jrbArray[i].setBounds(20, 20+i*40, 100, 20);
			jpt.add(jrbArray[i]);
			jrbArray[i].addActionListener(this);
			bg.add(jrbArray[i]);
		}

		
		jtxtArray[3].setBounds(350, 20, 120, 20);
		jpt.add(jtxtArray[3]);
		jsp.setTopComponent(jpt);
		jsp.setBottomComponent(jspn);
		jsp.setDividerSize(4);
		jsp.setDividerLocation(500);//设置分界线位置
		
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event){
				if(event.getButton()==MouseEvent.BUTTON1){
					jbborrow.setEnabled(true);
				}
			}
		});
		
		this.add(jsp);
//		this.setBounds(3, 10, 700, 400);
		this.setBounds(0, 0, 100, 100);
		this.setVisible(true);
		//显示所有图书
		

		sql =  "select * from tbBookInfo ";
		paintTable(sql);
		frm = new JFrame("东南大学图书馆");
		frm.add(this);
		frm.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frm.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		
		//选中简单查询按钮
		if(jrbArray[0].isSelected()){
			jtxtArray[3].setEditable(true);
			for(int i =0;i<jtxtArray.length-1;i++){
				jtxtArray[i].setEditable(false);
			}
			if (jcb.getSelectedIndex()>=0 && jcb.getSelectedIndex()<4) {//索引项在0-2之间
				jtxtArray[3].requestFocus();
				if(e.getSource()==jb && jcb.getSelectedIndex()<3){
					String str = jtxtArray[3].getText().trim();//得到查询条件
					if(str.equals("")){
						JOptionPane.showMessageDialog(this, "请输入查询信息！","信息",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					if(jcb.getSelectedIndex()==0){//按图书名查询
						sql = "select * from tbBookInfo where Name='"+str+"'";
						paintTable(sql);
						jtxtArray[3].setText("");
					}
					else if(jcb.getSelectedIndex()==1){//按图书id查询
						sql = "select * from tbBookInfo where BookNo='"+str+"'";
						jtxtArray[3].setText("");
					}
					else if(jcb.getSelectedIndex()==2){//按作者查询
						sql = "select * from tbBookInfo where Writer='"+str+"'";
						jtxtArray[3].setText("");
					}
					
				}
			}
		}

		//点击借阅图书
		if(e.getSource()==jbborrow){
			int rowIndex = jt.getSelectedRow();
			String Bookid= (String)jt.getValueAt(rowIndex ,0);
			sql= "insert into tbBookRent(BookNo,cardNo) values('"+Bookid+"','"+user.getCardNo()+"')";
			paintTable(sql);
			jbborrow.setEnabled(true);
		}
		//查询已借阅
		if(e.getSource()==jbAdd)
		{
			
			System.out.println(user.getCardNo());
			sql =  "select * from tbBookInfo where BookNo in( select BookNo from tbBookRent where cardNo='"+user.getCardNo()+"')";
			paintTable(sql);
			jbrent.setEnabled(true);	
		}
		//点击还书按钮
		if(e.getSource()==jbrent)
		{
			int rowIndex = jt.getSelectedRow();
			String  Bookid= (String)jt.getValueAt(rowIndex ,0);
			sql = "delete from tbBookRent  where BookNo = '"+Bookid+"'and cardNo ='"+user.getCardNo()+"'";
			paintTable(sql);
			jbrent.setEnabled(true);
	
		}
		
	    
		
	}
	
	
	void paintTable(String sqlString) {

		Vector<Vector<String>> vtemp =BookInfoImpl.getBookRent(sqlString);//存放表格数据的向量
		//System.out.println("123    "+vtemp.size());
		dtm.setDataVector(vtemp, head);//更新table
		jt.updateUI();
		jt.repaint();	
	}
	

}
