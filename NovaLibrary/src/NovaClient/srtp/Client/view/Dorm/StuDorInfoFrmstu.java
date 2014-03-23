package seu.Client.view.Dorm;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import k.User;

import seu.Client.bz.impl.CommonImpl;
import seu.Client.bz.impl.StudentDorInfoImpl;


/**
 * 宿舍模块学生界面
 * @author kidd
 *
 */
public class StuDorInfoFrmstu extends JFrame {
	
	JLabel jlStuID, jlName,jlCollege, jlBirthday, jlSex, jlBed, jlDepart, jlGrade,jlRecord,jlPicture;
	JTextField jtfStuID, jtfName,jtfCollege,jtfBirthday, jtfSex,jtfBed, jtfDepart, jtfGrade,jtfRecord;
	JButton jbOK, jbCancel;
	NewPanel jp1;
	 ImageIcon background;
	
	public StuDorInfoFrmstu (User u){
		super( "宿舍信息查询");
		buildWidgets();
		setProperties(u.getStudentNo());
		
	}
	
	private void buildWidgets() {
		
		setSize(600,600);
		setLocation(300,300);
		Container content=getContentPane();
		content.setLayout(new BorderLayout());
	
		jp1=new NewPanel();
		jp1.setLayout(new GridLayout(10,2));
		jp1.setBorder(BorderFactory.createTitledBorder("~seu~~~~seu~~~~seu~~~~seu~~~~seu~"));
		
		background=new ImageIcon(this.getClass().getResource("/image/Dormitory1.jpg"));
		jlPicture=new JLabel(background);

		 jlStuID=new JLabel("学号",JLabel.CENTER);
		 jlStuID.setFont(new java.awt.Font("楷体", 1, 18)); 
		 jlName=new JLabel("姓名",JLabel.CENTER);
		 jlName.setFont(new java.awt.Font("楷体", 1, 18)); 
		 jlSex=new JLabel("性别",JLabel.CENTER);
		 jlSex.setFont(new java.awt.Font("楷体", 1, 18)); 
		 jlBirthday=new JLabel("出生年月",JLabel.CENTER);
		 jlBirthday.setFont(new java.awt.Font("楷体", 1, 18)); 
		 jlDepart=new JLabel("宿舍号",JLabel.CENTER);
		 jlDepart.setFont(new java.awt.Font("楷体", 1, 18)); 
		 jlBed=new JLabel("床位号",JLabel.CENTER);
		 jlBed.setFont(new java.awt.Font("楷体", 1, 18)); 
		 jlCollege=new JLabel("学院",JLabel.CENTER);
		 jlCollege.setFont(new java.awt.Font("楷体", 1, 18)); 
		 jlGrade=new JLabel("卫生成绩",JLabel.CENTER);
		 jlGrade.setFont(new java.awt.Font("楷体", 1, 18)); 
		 jlRecord=new JLabel("违纪记录",JLabel.CENTER);
		 jlRecord.setFont(new java.awt.Font("楷体", 1, 18)); 
		 
		 jtfStuID=new JTextField();
		 jtfName=new JTextField();
		 jtfSex=new JTextField();
		 jtfBirthday=new JTextField();
		 jtfDepart=new JTextField();
		 jtfBed=new JTextField();
		 jtfCollege=new JTextField();
		 jtfGrade=new JTextField();
		 jtfRecord=new JTextField();
		 
		
		 
		jp1.add(jlStuID);
		jp1.add(jtfStuID);
		jp1.add(jlName);
		jp1.add(jtfName);
		jp1.add(jlSex);
		jp1.add(jtfSex);
		jp1.add(jlBirthday);
		jp1.add(jtfBirthday);
		jp1.add(jlDepart);
		jp1.add(jtfDepart);
		jp1.add(jlBed);
		jp1.add(jtfBed);
		jp1.add(jlCollege);
		jp1.add(jtfCollege);
		jp1.add(jlGrade);
		jp1.add(jtfGrade);
		jp1.add(jlRecord);
		jp1.add(jtfRecord);
		jp1.setBackground(java.awt.Color.white);
		jp1.setOpaque(false);

		this.add(jlPicture,"North");
		this.add(jp1,"South");
	
		
		setVisible(true);
	}
	private void setProperties(String StuNo) {

		this.setResizable(false);
		this.setLocationRelativeTo(null); // 居中
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(261, 440);
		
		Vector vec=StudentDorInfoImpl.StuDorInfostu(StuNo);
		if(vec.size()==0){
			JOptionPane.showMessageDialog(null, "查无此人");
		}
		else{
		this.jtfStuID.setText((String)   ((Vector) vec.get(0)).get(1));
		this.jtfStuID.setOpaque(false);
		this.jtfStuID.setFont(new java.awt.Font("楷体", 1, 18)); 
		this.jtfName.setText((String)    ((Vector) vec.get(0)).get(2));
		this.jtfName.setOpaque(false);
		this.jtfName.setFont(new java.awt.Font("楷体", 1, 18)); 
		this.jtfCollege.setText((String) ((Vector) vec.get(0)).get(4));
		this.jtfCollege.setOpaque(false);
		this.jtfCollege.setFont(new java.awt.Font("楷体", 1, 18)); 
		this.jtfBirthday.setText((String)((Vector) vec.get(0)).get(5));
		this.jtfBirthday.setOpaque(false);
		this.jtfBirthday.setFont(new java.awt.Font("楷体", 1, 18)); 
		this.jtfSex.setText((String)     ((Vector) vec.get(0)).get(3));
		this.jtfSex.setOpaque(false);
		this.jtfSex.setFont(new java.awt.Font("楷体", 1, 18)); 
		this.jtfGrade.setText((String)   ((Vector) vec.get(0)).get(8));
		this.jtfGrade.setOpaque(false);
		this.jtfGrade.setFont(new java.awt.Font("楷体", 1, 18)); 
		this.jtfRecord.setText((String)  ((Vector) vec.get(0)).get(9));
		this.jtfRecord.setOpaque(false);
		this.jtfRecord.setFont(new java.awt.Font("楷体", 1, 18)); 
		this.jtfDepart.setText((String)  ((Vector) vec.get(0)).get(6));
		this.jtfDepart.setOpaque(false);
		this.jtfDepart.setFont(new java.awt.Font("楷体", 1, 18)); 
		this.jtfBed.setText((String)     ((Vector) vec.get(0)).get(7));
		this.jtfBed.setOpaque(false);
		this.jtfBed.setFont(new java.awt.Font("楷体", 1, 18)); 
		
		this.setVisible(true);
		
		
		}
		
	}
	
	
		public static void main(String[] args) {
		
		}
		class NewPanel extends JPanel
		   {
		     public NewPanel()
		     {

		     }

		     public void paintComponent(Graphics g)
		     {
		        int x=0,y=0;
		        //java.net.URL imgURL=getClass().getResource("c://aaa.jpg");

		        //test.jpg是测试图片，与Demo.java放在同一目录下
		        ImageIcon icon=new ImageIcon(this.getClass().getResource("/image/studentdor.jpg"));
		        //g.drawImage(icon.getImage(),x,y,getSize().width,getSize().height,this);
		        while(true)
		        {
		          g.drawImage(icon.getImage(),x,y,this);
		          if(x>getSize().width && y>getSize().height)break;
		          //这段代码是为了保证在窗口大于图片时，图片仍能覆盖整个窗口
		          if(x>getSize().width)
		          {
		             x=0;
		             y+=icon.getIconHeight();
		          }
		          else
		           x+=icon.getIconWidth();
		        }
		     }
		   }
}

