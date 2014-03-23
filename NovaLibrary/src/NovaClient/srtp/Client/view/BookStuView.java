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
 * ͼ���ģ���û�������
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
	int flag;//�������λ
	String sql;
	User user;
	
	//�������ֿؼ�
	private JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false); //�ָ�����·ָ�
	final ImageIcon backgroudUp=new ImageIcon(this.getClass().getResource("/image/����.jpg"));//����ͼƬ
	private JPanel jpt = new JPanel(){
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(backgroudUp!=null){
				g.drawImage(backgroudUp.getImage(),0, 0, this.getWidth(),this.getHeight(),null);
			}
		}
      
       
	};
	
	private String []str ={"ͼ����","ͼ��id","����"};
	private JComboBox jcb = new JComboBox(str);
	//���ò�ѯ��ⰴť
	
	ImageIcon Image1=new ImageIcon(this.getClass().getResource("/image/��ѯ�鼮.jpg"));
	public  JButton jb = new JButton(Image1);
   
	//���ò�ѯ�Ѿ�����ͼ��
	ImageIcon Image2=new ImageIcon(this.getClass().getResource("/image/��ѯ�������.jpg"));
	private JButton jbAdd = new JButton(Image2);
	
	//���ý���ͼ�鰴ť
	ImageIcon Image3=new ImageIcon(this.getClass().getResource("/image/�����鼮.jpg"));
	private JButton jbborrow = new JButton(Image3);
	
	//���û��鰴ť
	ImageIcon Image4=new ImageIcon(this.getClass().getResource("/image/����.jpg"));
	private JButton jbrent = new JButton(Image4);
	
	//���������
	private JFrame frm ;

	private JTextField []jtxtArray = new JTextField[]{
			new JTextField(),new JTextField(),new JTextField(),new JTextField()
	};
	private JRadioButton []jrbArray = new JRadioButton[]{
			new JRadioButton("��ѯ", true)
	};
	private ButtonGroup bg = new ButtonGroup();
	Vector<String> head = new Vector<String>();
	{head.add("ͼ��id");head.add("ͼ����");head.add("������");head.add("����");head.add("����");head.add("��������");head.add("ͼ������");
	};
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	DefaultTableModel dtm = new DefaultTableModel(data, head);//�������ģ��
	JTable jt = new JTable(dtm);
	JScrollPane jspn=new JScrollPane(jt);
	/**
	 * ��ѯ���湹����
	 */
	public BookStuView(User us){
		user =us;
		System.out.println(user.getCardNo());
		this.setLayout(new GridLayout(1,1));
		this.setName("���ϴ�ѧͼ���");
		//���ò���
		jpt.setLayout(null);
		jpt.add(jcb);//������������
		jcb.setBounds(160, 20, 100, 20);
		jcb.addActionListener(this);
		jpt.add(jb);
		jpt.add(jbborrow);
		jpt.add(jbAdd);
		jpt.add(jbrent);
		//���ð�ť��Сλ��
		jb.setBounds(230, 80, 160, 60);
		jb.setContentAreaFilled(false);//����͸��
		jb.setBorderPainted(false);//ȥ���߿�
		
		jbrent.setBounds(230, 160, 160, 60);
		jbrent.setContentAreaFilled(false);//����͸��
		jbrent.setBorderPainted(false);//ȥ���߿�
		
		jbborrow.setBounds(230, 240, 160, 60);
		jbborrow.setContentAreaFilled(false);//����͸��
		jbborrow.setBorderPainted(false);//ȥ���߿�
		
		jbAdd.setBounds(230, 320, 160, 60);
		jbAdd.setContentAreaFilled(false);//����͸��
		jbAdd.setBorderPainted(false);//ȥ���߿�
		
		//����
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
		jsp.setDividerLocation(500);//���÷ֽ���λ��
		
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
		//��ʾ����ͼ��
		

		sql =  "select * from tbBookInfo ";
		paintTable(sql);
		frm = new JFrame("���ϴ�ѧͼ���");
		frm.add(this);
		frm.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frm.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		
		//ѡ�м򵥲�ѯ��ť
		if(jrbArray[0].isSelected()){
			jtxtArray[3].setEditable(true);
			for(int i =0;i<jtxtArray.length-1;i++){
				jtxtArray[i].setEditable(false);
			}
			if (jcb.getSelectedIndex()>=0 && jcb.getSelectedIndex()<4) {//��������0-2֮��
				jtxtArray[3].requestFocus();
				if(e.getSource()==jb && jcb.getSelectedIndex()<3){
					String str = jtxtArray[3].getText().trim();//�õ���ѯ����
					if(str.equals("")){
						JOptionPane.showMessageDialog(this, "�������ѯ��Ϣ��","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					if(jcb.getSelectedIndex()==0){//��ͼ������ѯ
						sql = "select * from tbBookInfo where Name='"+str+"'";
						paintTable(sql);
						jtxtArray[3].setText("");
					}
					else if(jcb.getSelectedIndex()==1){//��ͼ��id��ѯ
						sql = "select * from tbBookInfo where BookNo='"+str+"'";
						jtxtArray[3].setText("");
					}
					else if(jcb.getSelectedIndex()==2){//�����߲�ѯ
						sql = "select * from tbBookInfo where Writer='"+str+"'";
						jtxtArray[3].setText("");
					}
					
				}
			}
		}

		//�������ͼ��
		if(e.getSource()==jbborrow){
			int rowIndex = jt.getSelectedRow();
			String Bookid= (String)jt.getValueAt(rowIndex ,0);
			sql= "insert into tbBookRent(BookNo,cardNo) values('"+Bookid+"','"+user.getCardNo()+"')";
			paintTable(sql);
			jbborrow.setEnabled(true);
		}
		//��ѯ�ѽ���
		if(e.getSource()==jbAdd)
		{
			
			System.out.println(user.getCardNo());
			sql =  "select * from tbBookInfo where BookNo in( select BookNo from tbBookRent where cardNo='"+user.getCardNo()+"')";
			paintTable(sql);
			jbrent.setEnabled(true);	
		}
		//������鰴ť
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

		Vector<Vector<String>> vtemp =BookInfoImpl.getBookRent(sqlString);//��ű�����ݵ�����
		//System.out.println("123    "+vtemp.size());
		dtm.setDataVector(vtemp, head);//����table
		jt.updateUI();
		jt.repaint();	
	}
	

}
