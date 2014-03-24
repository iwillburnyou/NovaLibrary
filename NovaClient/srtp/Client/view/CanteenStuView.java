/**
 * 餐厅管理系统学生所见视图类 --by张雅淋
 */
package seu.Client.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


import k.User;
/**
 * 食堂模块用户主界面
 * @author kidd
 *
 */
public class CanteenStuView extends JFrame {

	private static final long serialVersionUID = 1L;
	User  user ;

	DefaultMutableTreeNode[] dmtn =    //创建节点数组
		{new DefaultMutableTreeNode(new NodeValue("学生操作选择") ),
		new DefaultMutableTreeNode(new NodeValue("菜品查询") ),
		new DefaultMutableTreeNode(new NodeValue("外卖订购") ),
		new DefaultMutableTreeNode(new NodeValue("意见反馈") ),
		new DefaultMutableTreeNode(new NodeValue("退出") )	
		};
	DefaultTreeModel dtm =  new DefaultTreeModel(dmtn[0]);//指定根节点为SEU餐厅管理系统
	JTree jt = new JTree(dtm);
	JScrollPane jsp = new JScrollPane(jt); //为JTree创建活动窗口
	
	private JSplitPane jsplr = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);//创建左右分割窗体对象
	
	private JPanel jp = new JPanel();
	Image image = new ImageIcon(this.getClass().getResource("/image/images.jpg")).getImage();
	ImageIcon ii = new ImageIcon(image);
	private JLabel jlRoot = new JLabel(ii);     
	CardLayout cl = new CardLayout(); //创建卡片布局对象
	final ImageIcon backgroundLeft = new ImageIcon(this.getClass().getResource("/image/食堂左1.png"));
	
	
	public CanteenStuView( User us){ //构造器
	    user = us;
	    
		this.initJp();
		this.addTreelistener(this);
		for (int i =1;i<5;i++){
			dtm.insertNodeInto(dmtn[i], dmtn[0], i-1);
		}
		jt.setEditable(false); 
		jt.setFont(new Font("微软雅黑",Font.PLAIN,15));
		//jt.setVisibleRowCount(5);
		//jt.setForeground(Color.MAGENTA);
		this.getContentPane().add(jsplr); //添加滚动窗口
		
		JPanel jpl = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundLeft != null){
					g.drawImage(backgroundLeft.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
				}
			}
		};
		jpl.setLayout(null);
		jpl.setOpaque(false);
		jsplr.setLeftComponent(jpl);
		jsplr.setRightComponent(jp);
		jsplr.setDividerLocation(200);
		jsplr.setDividerSize(4);
		//jlRoot.setForeground(Color.MAGENTA);
		//jlRoot.setFont(new Font("微软雅黑",Font.PLAIN,20));
		//jlRoot.setHorizontalAlignment(JLabel.CENTER);
		//jlRoot.setVerticalAlignment(JLabel.CENTER);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Image image = new ImageIcon(this.getClass().getResource("/image/canteenIcon.png")).getImage();//logo初始化
		this.setIconImage(image);
		this.setTitle("SEU餐厅管理系统 --"+user.getName());
		Toolkit tk = this.getToolkit();
		Dimension screenSize = tk.getScreenSize(); //获得屏幕尺寸
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;
		int w = 1100;
		int h = 620;
		this.setBounds(centerX-w/2,centerY-h/2,w,h);
		jp.setBounds(200,0,w-200,h);
		jpl.setBounds(0, 0, 200, h);
		//jsp.setBounds(50,50, 170, h-230);
		jsp.setOpaque(false);
	
		jt.setBounds(39, 25, 142, 120);//调整左侧树的位置
		jt.setOpaque(false);//修改，设置树透明
		jpl.add(jt);
		
		jsplr.setEnabled(false);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setResizable(false);
		jt.setShowsRootHandles(true);
	}

	

	private void addTreelistener(final CanteenStuView canteenStuView) { //为树添加选择模型的监听器
		jt.addTreeSelectionListener(new TreeSelectionListener() {
			
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode cdmtn = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
				NodeValue cnv = (NodeValue)cdmtn.getUserObject();//得到自定义节点对象
				if(cnv.value.equals("学生操作选择")){
					cl.show(jp, "root");
				}
				if(cnv.value.equals("菜品查询")){
					cl.show(jp, "ds");
				}
				else if(cnv.value.equals("外卖订购")){
					cl.show(jp, "ta");
				}
				else if(cnv.value.equals("意见反馈")){
					cl.show(jp, "ad");
				}
				else if(cnv.value.equals("退出")){
					canteenStuView.dispose();
				
				}
			}	
		});	
	}
	

	private void initJp() {
		jp.setLayout(cl); //设置为卡片布局
		jp.add(new CanMainPanel(this.user),"root");
		jp.add(new CsDishSearch(this.user),"ds");
		jp.add(new CsTakeAway(this.user),"ta");
		jp.add(new CsAdvice(this.user),"ad");	

	}

	class NodeValue{//自定义节点对象字符属性
		String value;
		public NodeValue(String value){
			this.value = value;
		}
		public String getValue(){
			return this.value;
		}
		public String toString(){ //重写toString方法
			return value;
		}
	}

	public static void main(String[] args){
		User us = new User("213100363","09011235","张雅淋","mima","学生") ;
		//new CanteenStuView(us);
	}
}

