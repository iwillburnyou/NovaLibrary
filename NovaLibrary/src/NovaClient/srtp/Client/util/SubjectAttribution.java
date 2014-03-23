package seu.Client.util;


//import client.util.Model;

import k.MessageType;

public class SubjectAttribution extends Model implements MessageType{

	public SubjectAttribution(int type,String key) {
		super(type, key);
		setCol();
	}
	private void setCol() {
		columnNames.add("课程编码");	
		columnNames.add("课程名称");
		columnNames.add("任课老师");
		columnNames.add("课时");
		columnNames.add("学分");
		columnNames.add("课程类型");
		
	}

}
