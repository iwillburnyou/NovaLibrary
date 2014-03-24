/**
 * ��������ϵͳ����Ա������ͼ�� --By������
 */
package seu.Client.view;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

//import sun.security.mscapi.KeyStore.ROOT;

/**
 * ʳ��ģ�����Ա������
 * @author kidd
 *
 */
public class CanteenAdminView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	DefaultMutableTreeNode[] dmtn =    //�����ڵ�����
		{new DefaultMutableTreeNode(new NodeValue("����Ա����ѡ��") ),
		new DefaultMutableTreeNode(new NodeValue("��Ʒ����") ),
		new DefaultMutableTreeNode(new NodeValue("��������") ),
		new DefaultMutableTreeNode(new NodeValue("����鿴") ),
		new DefaultMutableTreeNode(new NodeValue("�˳�") )	
		};
	DefaultTreeModel dtm =  new DefaultTreeModel(dmtn[0]);//ָ�����ڵ�ΪSEU��������ϵͳ
	JTree jt = new JTree(dtm);
	JScrollPane jsp = new JScrollPane(jt); //ΪJTree���������
	private JSplitPane jsplr = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);//�������ҷָ�����
	private JPanel jp=new JPanel();
	Image image = new ImageIcon(this.getClass().getResource("/image/images.jpg")).getImage();
	ImageIcon ii = new ImageIcon(image);
	private JLabel jlRoot = new JLabel(ii);        
	CardLayout cl = new CardLayout(); //������Ƭ���ֶ���
	final ImageIcon backgroundLeft = new ImageIcon(this.getClass().getResource("/image/ʳ�ù���1.png"));
	
	
	
	public CanteenAdminView(User us){ //������
		user = us;
		
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
		

		this.initJp();
		this.addTreelistener(this);
		for (int i =1;i<5;i++){
			dtm.insertNodeInto(dmtn[i], dmtn[0], i-1);
		}
		jt.setEditable(false);
		jt.setFont(new Font("΢���ź�",Font.PLAIN,15));
		this.getContentPane().add(jsplr); //��ӹ�������
		jsplr.setLeftComponent(jpl);
		jsplr.setRightComponent(jp);
		jsplr.setDividerLocation(200);
		jsplr.setDividerSize(4);
		//jlRoot.setFont(new Font("Courier",Font.PLAIN,30));
		//jlRoot.setHorizontalAlignment(JLabel.CENTER);
		//jlRoot.setVerticalAlignment(JLabel.CENTER);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Image image = new ImageIcon(this.getClass().getResource("/image/canteenIcon.png")).getImage();//logo��ʼ��
		this.setIconImage(image);
		this.setTitle("SEU��������ϵͳ --"+user.getName());
		java.awt.Toolkit tk = this.getToolkit();
		Dimension screenSize = tk.getScreenSize(); //�����Ļ�ߴ�
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;
		int w = 1100;
		int h = 620;
		this.setBounds(centerX-w/2,centerY-h/2,w,h);
		jp.setBounds(200,0,w-200,h);
		jpl.setBounds(0, 0, 200, h);
		jpl.add(jt);
		
		jt.setBounds(35, 20, 145, 120);//�����������λ��
		jt.setOpaque(false);//�޸ģ�������͸��
		
		jsplr.setEnabled(false);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setResizable(false);
		jt.setShowsRootHandles(true);
	
	}

	private void addTreelistener(final CanteenAdminView canteenAdminView) { //Ϊ�����ѡ��ģ�͵ļ�����
		jt.addTreeSelectionListener(new TreeSelectionListener() {
			
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode cdmtn = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
				NodeValue cnv = (NodeValue)cdmtn.getUserObject();//�õ��Զ���ڵ����
				if(cnv.value.equals("����Ա����ѡ��")){
					cl.show(jp, "root");
				}
				if(cnv.value.equals("��Ʒ����")){
					cl.show(jp, "ds");
				}
				else if(cnv.value.equals("��������")){
					cl.show(jp, "cata");
				}
				else if(cnv.value.equals("����鿴")){
					cl.show(jp, "av");
				}
				else if(cnv.value.equals("�˳�")){
						
					canteenAdminView.dispose();
				}
			}	
		});	
	}

	private void initJp() {
		jp.setLayout(cl); //����Ϊ��Ƭ����
		jp.add(new CanMainPanelA(this.user),"root");
		jp.add(new CaDishSearch(this.user),"ds");//��Ӧ��������
		jp.add(new CaTakeAway(this.user),"cata");
		jp.add(new CaAdviceView(this.user),"av");	
		
	}


	class NodeValue{//�Զ���ڵ�����ַ�����
		String value;
		public NodeValue(String value){
			this.value = value;
		}
		public String getValue(){
			return this.value;
		}
		public String toString(){ //��дtoString����
			return value;
		}
	}

	public static void main(String[] args){
		User us = new User("213100363","09011235","������","mima","ѧ��") ;
		new CanteenAdminView(us);
	}
}
