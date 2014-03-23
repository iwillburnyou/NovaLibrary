package seu.Client.view;
/**
 * ����Ա����鿴���� --by������
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
 * ʳ��ģ�鷴������ĶԻ������
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
	private JSplitPane Pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);//�����������·ָ�
	private JSplitPane topPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);//�ϰ벿�ֽ������ҷָ�
	
    private JButton showAllButton = new JButton("��ʾ���н���");
    private JButton showunreadButton = new JButton("��ʾδ������");
    private JButton seeselectButton = new JButton("�鿴ѡ����");
    private JButton delselectButton = new JButton("ɾ��ѡ����");
    private JLabel showJLabel = new JLabel("������ݣ�");
    private JTextArea showArea = new JTextArea();
    private JScrollPane showsJScrollPane = new JScrollPane(showArea);
	Vector<String> head = new Vector<String>();//��ѯ��Ʒ��ʾ�ı�
	{head.add("���");head.add("���");head.add("������");head.add("�Ƿ��Ķ�");
	};
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	DefaultTableModel dtm = new DefaultTableModel(data, head);//�������ģ��
	JTable jTable = new JTable(dtm);
	JScrollPane jspn=new JScrollPane(jTable);
	
	final ImageIcon backgroundtop = new ImageIcon(this.getClass().getResource("/image/��������3.png"));//����ͼƬ
	final ImageIcon backgroundtop2 = new ImageIcon(this.getClass().getResource("/image/��������4.png"));//����ͼƬ
	final ImageIcon backgroundtop3 = new ImageIcon(this.getClass().getResource("/image/��������2.png"));//����ͼƬ
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
		};//�Ͻ����󲿷�
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
		};//�Ͻ����Ҳ���
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
		};//�½���
		jpb.setLayout(null);
		jptr.setLayout(null);
		jptl.setLayout(null);
		//�Ͻ�����벿���趨
		showAllButton.setBounds(20, 20, 120, 30);
		showAllButton.setContentAreaFilled(false);
		//showAllButton.setBorderPainted(false);
		showunreadButton.setBounds(20, 60, 120, 30);
		showunreadButton.setContentAreaFilled(false);
		//showunreadButton.setBorderPainted(false);
		seeselectButton.setBounds(160, 20, 120, 30);//��
		seeselectButton.setContentAreaFilled(false);
		//seeselectButton.setBorderPainted(false);
		delselectButton.setBounds(160, 60, 120, 30);//��
		delselectButton.setContentAreaFilled(false);
		//delselectButton.setBorderPainted(false);
		showAllButton.setFont(new Font("��Բ", Font.PLAIN, 14));//�����
		showunreadButton.setFont(new Font("��Բ", Font.PLAIN, 14));
		seeselectButton.setFont(new Font("��Բ", Font.PLAIN, 14));
		delselectButton.setFont(new Font("��Բ", Font.PLAIN, 14));
		
		jspn.setBounds(50, 50, 550, 330);//���ñ���С
		
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
		//�Ͻ����Ұ벿���趨
		
		showJLabel.setBounds(20,20,100,30);
		showArea.setBounds(140,20,300,140);
		showArea.setLineWrap(true);
		showsJScrollPane.setBounds(140, 20, 300, 140);
		showJLabel.setFont(new Font("��Բ", Font.PLAIN, 16));
		showArea.setFont(new Font("��Բ", Font.PLAIN, 16));
		showsJScrollPane.setFont(new Font("��Բ", Font.PLAIN, 16));
		jptr.add(showJLabel);
		jptr.add(showsJScrollPane);
		
		topPane.setLeftComponent(jptl);
		topPane.setRightComponent(jptr);
		topPane.setDividerLocation(300);//��
		topPane.setDividerSize(4);
		jTable.setFont(new Font("��Բ", Font.PLAIN, 16));
		jTable.getTableHeader().setFont(new Font("��Բ", Font.PLAIN, 16));
		
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

		Vector<Vector<String>> vtemp =CanteenInfoImpl.getAdvice(sql);//��ű�����ݵ�����
		dtm.setDataVector(vtemp, head);//����table
		jTable.updateUI();
		jTable.repaint();
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==showAllButton){
			sql="select * from tblAdvice ";
			painttable(sql);
		}
		else if(e.getSource()==showunreadButton){
			sql = "select * from tblAdvice where Read = '��'";
			painttable(sql);
		}
		else if(e.getSource()==seeselectButton){
			int rowIndex = jTable.getSelectedRow();
			String adviceString = (String)jTable.getValueAt(rowIndex ,1);
			String iDSringString = (String)jTable.getValueAt(rowIndex ,0);
			showArea.setText(adviceString);
			CanteenInfoImpl.changeRead("update tblAdvice  set Read = '��' where ID = '"+iDSringString+"'");
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
 