package seu.Client.view;
/**
 * 管理员意见查看的类 --by张雅淋
 */
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import k.User;
import seu.Client.bz.impl.CanteenInfoImpl;

/**
 * 食堂模块反馈意见的对话框界面
 * @author kidd
 *
 */
public class CaAdviceView extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String sql;
	User user;
	private JSplitPane Pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);//整个界面上下分割
	private JSplitPane topPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);//上半部分界面左右分割
	
    private JButton showAllButton = new JButton("显示所有建议");
    private JButton showunreadButton = new JButton("显示未读建议");
    private JButton seeselectButton = new JButton("查看选中项");
    private JButton delselectButton = new JButton("删除选中项");
    private JLabel showJLabel = new JLabel("意见内容：");
    private JTextArea showArea = new JTextArea();
    private JScrollPane showsJScrollPane = new JScrollPane(showArea);
	Vector<String> head = new Vector<String>();//查询菜品显示的表
	{head.add("编号");head.add("意见");head.add("建议者");head.add("是否阅读");
	};
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	DefaultTableModel dtm = new DefaultTableModel(data, head);//创建表格模型
	JTable jTable = new JTable(dtm);
	JScrollPane jspn=new JScrollPane(jTable);
	
	final ImageIcon backgroundtop = new ImageIcon(this.getClass().getResource("/image/餐厅管理3.png"));//背景图片
	final ImageIcon backgroundtop2 = new ImageIcon(this.getClass().getResource("/image/餐厅管理4.png"));//背景图片
	final ImageIcon backgroundtop3 = new ImageIcon(this.getClass().getResource("/image/餐厅管理2.png"));//背景图片
	public  CaAdviceView(User us) {
		this.setLayout(new GridLayout(1,1));
		user = us;
		JPanel jptl = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundtop2 != null){
					g.drawImage(backgroundtop2.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
				}
			}
		};//上界面左部分
		JPanel jptr = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundtop3 != null){
					g.drawImage(backgroundtop3.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
				}
			}
		};//上界面右部分
		JPanel jpb = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundtop != null){
					g.drawImage(backgroundtop.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
				}
			}
		};//下界面
		jpb.setLayout(null);
		jptr.setLayout(null);
		jptl.setLayout(null);
		//上界面左半部分设定
		showAllButton.setBounds(20, 20, 120, 30);
		showAllButton.setContentAreaFilled(false);
		//showAllButton.setBorderPainted(false);
		showunreadButton.setBounds(20, 60, 120, 30);
		showunreadButton.setContentAreaFilled(false);
		//showunreadButton.setBorderPainted(false);
		seeselectButton.setBounds(160, 20, 120, 30);//改
		seeselectButton.setContentAreaFilled(false);
		//seeselectButton.setBorderPainted(false);
		delselectButton.setBounds(160, 60, 120, 30);//改
		delselectButton.setContentAreaFilled(false);
		//delselectButton.setBorderPainted(false);
		showAllButton.setFont(new Font("幼圆", Font.PLAIN, 14));//字体改
		showunreadButton.setFont(new Font("幼圆", Font.PLAIN, 14));
		seeselectButton.setFont(new Font("幼圆", Font.PLAIN, 14));
		delselectButton.setFont(new Font("幼圆", Font.PLAIN, 14));
		
		jspn.setBounds(50, 50, 550, 330);//设置表格大小
		
		jptl.add(showAllButton);
		jptl.add(showunreadButton);
		jptl.add(seeselectButton);
		jptl.add(delselectButton);
		jpb.add(jspn);
		showAllButton.addActionListener(this);
		showunreadButton.addActionListener(this);
		seeselectButton.addActionListener(this);
		delselectButton.addActionListener(this);
		
		seeselectButton.setEnabled(false);
		delselectButton.setEnabled(false);
		//上界面右半部分设定
		
		showJLabel.setBounds(20,20,100,30);
		showArea.setBounds(140,20,300,140);
		showArea.setLineWrap(true);
		showsJScrollPane.setBounds(140, 20, 300, 140);
		showJLabel.setFont(new Font("幼圆", Font.PLAIN, 16));
		showArea.setFont(new Font("幼圆", Font.PLAIN, 16));
		showsJScrollPane.setFont(new Font("幼圆", Font.PLAIN, 16));
		jptr.add(showJLabel);
		jptr.add(showsJScrollPane);
		
		topPane.setLeftComponent(jptl);
		topPane.setRightComponent(jptr);
		topPane.setDividerLocation(300);//改
		topPane.setDividerSize(4);
		jTable.setFont(new Font("幼圆", Font.PLAIN, 16));
		jTable.getTableHeader().setFont(new Font("幼圆", Font.PLAIN, 16));
		
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event){
				if(event.getButton()==MouseEvent.BUTTON1){
					delselectButton.setEnabled(true);
					seeselectButton.setEnabled(true);
				}
			}
		});
		Pane.setDividerSize(4);
		Pane.setDividerLocation(170);
		Pane.setTopComponent(topPane);
		Pane.setBottomComponent(jpb);
		
		this.add(Pane);
		this.setBounds(3, 10, 700, 400);
		this.setVisible(true);
		sql = "select * from tblAdvice";
		painttable(sql);
	}

	private void painttable(String sql) {

		Vector<Vector<String>> vtemp =CanteenInfoImpl.getAdvice(sql);//存放表格数据的向量
		dtm.setDataVector(vtemp, head);//更新table
		jTable.updateUI();
		jTable.repaint();
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==showAllButton){
			sql="select * from tblAdvice ";
			painttable(sql);
		}
		else if(e.getSource()==showunreadButton){
			sql = "select * from tblAdvice where Read = '否'";
			painttable(sql);
		}
		else if(e.getSource()==seeselectButton){
			int rowIndex = jTable.getSelectedRow();
			String adviceString = (String)jTable.getValueAt(rowIndex ,1);
			String iDSringString = (String)jTable.getValueAt(rowIndex ,0);
			showArea.setText(adviceString);
			CanteenInfoImpl.changeRead("update tblAdvice  set Read = '是' where ID = '"+iDSringString+"'");
			painttable("select * from tblAdvice");
		}
		else if(e.getSource()==delselectButton){
			int rowIndex = jTable.getSelectedRow();
			String IDString = (String)jTable.getValueAt(rowIndex, 0);
			sql = "delete from tblAdvice where ID = '"+IDString+"'";
			CanteenInfoImpl.delAdvice(sql);
			painttable("select * from tblAdvice");
		}
	}

}
 