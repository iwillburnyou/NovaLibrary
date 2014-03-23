package seu.Client.view.Dorm;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import seu.Client.bz.impl.CommonImpl;
import seu.Client.bz.impl.StudentDorInfoImpl;
import seu.Client.bz.impl.StudentInfoImpl;
import seu.Client.vo.StudentInfo;



import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.sun.xml.internal.ws.api.server.Container;
/**
 * 宿舍模块管理员界面
 * @author kidd
 *
 */
public class StuDorInfoFrm extends JFrame {
	/**
	 * 
	 */
	//构建表格

	private JTable table;
	private Vector<String> head;
    String[] h=new String[]{"ID","学号","姓名","性别","专业","出生年月",
    		"宿舍号","床位号","卫生成绩","违纪记录"};
    DefaultTableModel mb = new DefaultTableModel(h,0);
	public  StuDorInfoFrm()  {
		super("管理员登录");
		head = new Vector<String>();
		head.add("ID");
		head.add("学号");
		head.add("姓名");
		head.add("性别");
		head.add("专业");
		head.add("出生年月");
		head.add("宿舍号");
		head.add("床位号");
		head.add("卫生成绩");
		head.add("违纪记录");
		mb.setDataVector(StudentDorInfoImpl.dor(), head);	
		//设置背景图片
		  ImageIcon imag = new ImageIcon(this.getClass().getResource("/image/manager.jpg"));
		  JLabel lab = new JLabel(imag); // 将图片放入到label中
		  lab.setBounds(0, 0, imag.getIconWidth(), imag.getIconHeight()); // 设置放有图片的label的位置
		  //设置table为透明
		    table =new JTable(mb){
            public Component prepareRenderer(TableCellRenderer renderer,
		    	     int row, int column) {
		    	    Component c = super.prepareRenderer(renderer, row, column);
		    	    if (c instanceof JComponent) {
		    	     ((JComponent) c).setOpaque(false);
		    	    }
		    	    return c;
		    	   }
		    };
		    table.setOpaque(false); 
		    
		    JScrollPane scrollPane = new JScrollPane();  
	        scrollPane.getViewport().setOpaque(false);//将JScrollPane设置为透明  
	        scrollPane.setOpaque(false);//将中间的viewport设置为透明  
	        scrollPane.setViewportView(table);//装载表格  
	        scrollPane.setColumnHeaderView(table.getTableHeader());//设置头部（HeaderView部分）  
	        scrollPane.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明  
	          
	        JTableHeader header = table.getTableHeader();//获取头部   
	        //header.setPreferredSize(new Dimension(30, 26));   
	        header.setOpaque(false);//设置头部为透明  
	        header.getTable().setOpaque(false);//设置头部里面的表格透明  
	        
		    getContentPane().add(lab, -1);
		    getContentPane().add(scrollPane,0); 

		    setSize(666,488);
			setLocation(200,200); 
		    //菜单项
		    JMenu m1=new JMenu("管理学生信息");
		    JMenu m2=new JMenu("修改学生信息");
		    
			JMenuItem delItem=new JMenuItem("删除信息");
			delItemActionListener delItemAction=new delItemActionListener();
			delItem.addActionListener(delItemAction);
			JMenuItem addItem=new JMenuItem("增添信息");
			addItem.addActionListener(new addItemActionListener());
			
			JMenuItem chaINFO=new JMenuItem("修改基本信息");
			chaINFO.addActionListener(new chaINFOActionListener());
			JMenuItem chaDor=new JMenuItem("调换宿舍");
			chaDor.addActionListener(new chaDorActionListener());
			
			m1.add(delItem);
			m1.addSeparator();
			m1.add(addItem);
			
			m2.add(chaINFO);
			m2.addSeparator();
			m2.add(chaDor);
			
			JMenuBar menubar=new JMenuBar();
			menubar.add(m1);
			menubar.add(m2);
			setJMenuBar(menubar);
			setVisible(true);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}

	//管理员删除操作的内部类
	class delItemActionListener implements ActionListener{  
		

		public delItemActionListener() {
			// TODO Auto-generated constructor stub
		}

		public void actionPerformed(ActionEvent e) {  
			StuDorDelInfoDia studel=new StuDorDelInfoDia (StuDorInfoFrm.this,"删除信息",true);
		}
	}
	//增添操作的内部类
class addItemActionListener implements ActionListener{  
		public void actionPerformed(ActionEvent e) { 
			StuDorAddInfoDia stuadd=new StuDorAddInfoDia(StuDorInfoFrm.this,"增添信息",true);	
		}    
		}  

  ///////修改基本信息
  class chaINFOActionListener implements ActionListener{  
		public void actionPerformed(ActionEvent e) { 
			StuDorChaInfoDia1 stucha=new StuDorChaInfoDia1(StuDorInfoFrm.this,"修改基本信息",true);	
		}    
		}  
  /////调换宿舍
  class chaDorActionListener implements ActionListener{  
		public void actionPerformed(ActionEvent e) { 
			StuDorChaInfoDia2 stuchador=new StuDorChaInfoDia2(StuDorInfoFrm.this,"调换宿舍",true);	
		}    
		}  
 
		///test
  
  public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StuDorInfoFrm inst = null;
				inst = new StuDorInfoFrm();
				
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
            
			}
		});
	}
		
  		

}
	