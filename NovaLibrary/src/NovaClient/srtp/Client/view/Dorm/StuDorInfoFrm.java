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
 * ����ģ�����Ա����
 * @author kidd
 *
 */
public class StuDorInfoFrm extends JFrame {
	/**
	 * 
	 */
	//�������

	private JTable table;
	private Vector<String> head;
    String[] h=new String[]{"ID","ѧ��","����","�Ա�","רҵ","��������",
    		"�����","��λ��","�����ɼ�","Υ�ͼ�¼"};
    DefaultTableModel mb = new DefaultTableModel(h,0);
	public  StuDorInfoFrm()  {
		super("����Ա��¼");
		head = new Vector<String>();
		head.add("ID");
		head.add("ѧ��");
		head.add("����");
		head.add("�Ա�");
		head.add("רҵ");
		head.add("��������");
		head.add("�����");
		head.add("��λ��");
		head.add("�����ɼ�");
		head.add("Υ�ͼ�¼");
		mb.setDataVector(StudentDorInfoImpl.dor(), head);	
		//���ñ���ͼƬ
		  ImageIcon imag = new ImageIcon(this.getClass().getResource("/image/manager.jpg"));
		  JLabel lab = new JLabel(imag); // ��ͼƬ���뵽label��
		  lab.setBounds(0, 0, imag.getIconWidth(), imag.getIconHeight()); // ���÷���ͼƬ��label��λ��
		  //����tableΪ͸��
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
	        scrollPane.getViewport().setOpaque(false);//��JScrollPane����Ϊ͸��  
	        scrollPane.setOpaque(false);//���м��viewport����Ϊ͸��  
	        scrollPane.setViewportView(table);//װ�ر��  
	        scrollPane.setColumnHeaderView(table.getTableHeader());//����ͷ����HeaderView���֣�  
	        scrollPane.getColumnHeader().setOpaque(false);//��ȡ��ͷ����������Ϊ͸��  
	          
	        JTableHeader header = table.getTableHeader();//��ȡͷ��   
	        //header.setPreferredSize(new Dimension(30, 26));   
	        header.setOpaque(false);//����ͷ��Ϊ͸��  
	        header.getTable().setOpaque(false);//����ͷ������ı��͸��  
	        
		    getContentPane().add(lab, -1);
		    getContentPane().add(scrollPane,0); 

		    setSize(666,488);
			setLocation(200,200); 
		    //�˵���
		    JMenu m1=new JMenu("����ѧ����Ϣ");
		    JMenu m2=new JMenu("�޸�ѧ����Ϣ");
		    
			JMenuItem delItem=new JMenuItem("ɾ����Ϣ");
			delItemActionListener delItemAction=new delItemActionListener();
			delItem.addActionListener(delItemAction);
			JMenuItem addItem=new JMenuItem("������Ϣ");
			addItem.addActionListener(new addItemActionListener());
			
			JMenuItem chaINFO=new JMenuItem("�޸Ļ�����Ϣ");
			chaINFO.addActionListener(new chaINFOActionListener());
			JMenuItem chaDor=new JMenuItem("��������");
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

	//����Աɾ���������ڲ���
	class delItemActionListener implements ActionListener{  
		

		public delItemActionListener() {
			// TODO Auto-generated constructor stub
		}

		public void actionPerformed(ActionEvent e) {  
			StuDorDelInfoDia studel=new StuDorDelInfoDia (StuDorInfoFrm.this,"ɾ����Ϣ",true);
		}
	}
	//����������ڲ���
class addItemActionListener implements ActionListener{  
		public void actionPerformed(ActionEvent e) { 
			StuDorAddInfoDia stuadd=new StuDorAddInfoDia(StuDorInfoFrm.this,"������Ϣ",true);	
		}    
		}  

  ///////�޸Ļ�����Ϣ
  class chaINFOActionListener implements ActionListener{  
		public void actionPerformed(ActionEvent e) { 
			StuDorChaInfoDia1 stucha=new StuDorChaInfoDia1(StuDorInfoFrm.this,"�޸Ļ�����Ϣ",true);	
		}    
		}  
  /////��������
  class chaDorActionListener implements ActionListener{  
		public void actionPerformed(ActionEvent e) { 
			StuDorChaInfoDia2 stuchador=new StuDorChaInfoDia2(StuDorInfoFrm.this,"��������",true);	
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
	