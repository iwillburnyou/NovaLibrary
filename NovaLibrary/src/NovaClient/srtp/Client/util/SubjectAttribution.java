package seu.Client.util;


//import client.util.Model;

import k.MessageType;

public class SubjectAttribution extends Model implements MessageType{

	public SubjectAttribution(int type,String key) {
		super(type, key);
		setCol();
	}
	private void setCol() {
		columnNames.add("�γ̱���");	
		columnNames.add("�γ�����");
		columnNames.add("�ο���ʦ");
		columnNames.add("��ʱ");
		columnNames.add("ѧ��");
		columnNames.add("�γ�����");
		
	}

}
