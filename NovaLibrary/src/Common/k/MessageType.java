package k;


/**
 * MESSAGE TYPE
 * 
 * ��������
 * 
 * @author ȫ���Ա
 *
 */
public interface MessageType {
	
	final int BYE_BYE = -1;
	final int NULL_MESSAGE = 666;
	/**
	 * Login
	 */
	final int STU_LOG_IN = 0;
	final int MANAGER_LOG_IN = 1;
	
	/*
	 * �������˲����ɹ����֪ͨ�ͻ���
	 */
	final int SERVER_OPERATION_SUCC =3290;
	final int SERVER_OPERATION_FAIL = 3291;
	/**
	 * �γ�ģ�����ݳ���
	 * ͨ����ѯ��ͬ�����ݿ�������ִ����Կγ̲�ѯ�����Ǵ���ѡ�γ��в�ѯ
	 */
	final int STU_CUR = 300;
	final int ADD_SUBJ = 301;
	final int GET_ALLCUR = 302;
	final int MOD_SUBJ = 303;
	final int DEL_SUBJ = 304;
	final int GET_STUCUR = 305;
	final int INQUIREBYTYPE = 306;
	
	final int GET_MATH = 310;
	final int ADD_MATH = 311;
	final int DEL_MATH = 312;
	final int GET_PHYSICS = 320;
	final int ADD_PHYSICS = 321;
	final int DEL_PHYSICS = 322;
	final int GET_ENGLISH = 330;
	final int ADD_ENGLISH = 331;
	final int DEL_ENGLISH = 332;
	final int GET_PE = 340;
	final int ADD_PE = 341;
	final int DEL_PE = 342;
	final int GET_COMPUTER = 350;
	final int ADD_COMPUTER = 351;
	final int DEL_COMPUTER = 352;
	final int GET_ART = 360;
	final int ADD_ART = 361;
	final int DEL_ART = 362;
	final int GET_ECNOMICS = 370;
	final int ADD_ECNOMICS = 371;
	final int DEL_ECNOMICS = 372;
	final int GET_SCIENCE = 380;
	final int ADD_SCIENCE = 381;
	final int DEL_SCIENCE = 382;
	
	/**
	 * ��Ʒģ�����ݳ���
	 */
final int ADM_MODIFY_GOODS = 22;	//�޸���Ʒ
	
	final int INQUIRY_GOODS_BY_ID = 24;		//ͨ��ID���ҿγ�
	final int INQUIRY_GOODS_BY_NAME = 25;	//ͨ�����Ʋ��ҿγ�
	final int INQUIRY_GOODS_BY_TYPE = 26;   //ͨ�����Ͳ�����Ʒ


	final int INQUIRY_STUDY_PRO = 401;//չʾѧϰ��Ʒ
	final int INQUIRY_LIFE_PRO = 402;//չʾ������Ʒ
	final int INQUIRY_FOOD_PRO = 403;//չʾʳƷ
	final int INQUIRY_ALL_PRO = 404;//չʾ������Ʒ
	final int SHOW_PAID_PRO = 405;//չʾ�ѹ�����Ʒ
	
	final int PERSON_RESERVE_RECORD = 406;   //��ѯ����Ԥ����Ʒ��¼ �ҵĹ��ﳵ
	final int RESERVE_GOODS = 407;    //Ԥ����Ʒ ���빺�ﳵ
	final int DISRESERVE_GOODS = 408;  //�˶���Ʒ �ӹ��ﳵɾ��
	final int PAY_FOR_BILL=409;//ȷ�ϸ���
	
	final int ADM_ADD_GOODS = 410;		//����Ա�����Ʒ
	final int ADM_MODIFY_COUNT = 411;	//����Ա�޸���Ʒ���
	final int ADM_MODIFY_PRICE = 412;	//����Ա�޸���Ʒ�۸�
	final int ADM_DELETE_GOODS = 413;	//����Աɾ����Ʒ
	final int ADM_GET_COUNTS = 414;   //����Ա�����Ʒ���
	
	final int IS_EXIST = 415;//������Ƿ���ڸ���Ʒ
	final int IS_EXIST_CART = 416;//���ﳵ���Ƿ���ڸ���Ʒ
	/**
	
	

	
	/**
	 * �鼮ģ�����ݳ���
	 * ͨ����ѯ��ͬ�����ݿ��������
	 */
	final int GET_ALL_BOOK = 50;		//��ѯ�����鼮
	final int ADD_BOOK = 51;		//����鼮
	final int MODIFY_BOOK = 52;		//�޸��鼮
	final int DELETE_BOOK = 53;		//ɾ���鼮
	final int INQUIRY_BOOK_BY_ID = 54;		//ͨ��ID�����鼮
	final int INQUIRY_BOOK_BY_NAME = 55;	//ͨ�����Ʋ����鼮
	final int INQUIRY_BOOK_BY_CODE = 56;	//ͨ��ͼ�������Ų����鼮
	final int INQUIRY_BOOK_BY_TYPE = 154;	//ͨ��ͼ����������鼮
	final int INQUIRY_BOOK_BY_WRITER = 155;	//ͨ�������߲���ͼ��
	final int INQUIRY_BOOK_BY_PUBLISH = 156;//ͨ�����������ͼ��
	
	final int SUBSCRIBE_BOOK = 57;			//����
	final int UNSUBSCRIBE_BOOK = 58;		//����
	final int PERSON_BORROW_RECORD = 59;	//���˽��ļ�¼
	
	/**
	 * ��ʦ����ѧ��ѧ��
	 */
	final int GET_ALL_STU = 60;
	final int ADD_STU = 61;		//���ѧ��
	final int MODIFY_STU = 62;	//�޸�ѧ��
	final int DELETE_STU = 63;	//ɾ��ѧ��
	final int INQUIRY_STU_BY_NO = 64;	//ͨ��ID����ѧ��
	final int INQUIRY_STU_BY_NAME = 65;	//ͨ�����Ʋ���ѧ��
	final int INQUIRY_GRADE = 68;	//��ѯ�ɼ�//�ֲ�...
	
	/**
	 * ��Ϣ������ע��
	 */
	final int STU_REGISTER = 71;	//ѧ������ע��
	final int FEEDBACK = 72;		//��Ϣ���������԰�
	/**
	 * ��������ģ�����ݳ���---By������
	 * 
	 */
	final int ADD_ADVICE = 200;
	final int GET_DISH = 201;
	final int ADD_DISHBUY = 202;
	final int DEL_DISHBUY = 203;
	final int GET_ALLDISHBUY = 204;
	final int GET_ADVICE = 205;
	final int CHANGE_READ = 206;
	final int DEL_ADVICE = 207;
	final int DEL_DISH = 208;
	final int ADD_DISH = 209;
	final int CHANGE_DISH = 210;
	final int CHANGE_IFSEND = 211;
	final int DEL_TAKEAWAY = 212;
	
	////liuyuchen
	final int GET_MESSAGE = 500;
	final int REGISTER_NEW = 501;
	final int CHANGE_PSD = 502;
	/**
	 * �������
	 */
	final int GET_ALL_STU_INFO = 80;		//��ѯѧ����Ϣ
	final int ADD_STU_Dormitory_INFO = 81;		//���ѧ��ס����Ϣ
	final int MODIFY_Dormitory_INFO = 82;		//�޸�ѧ��ס����Ϣ
	final int DELETE_Dormitory_INFO = 83;		//ɾ��ѧ��ס����Ϣ
	final int INQUIRY_STU_BY_ID = 84;		//ͨ��ID����ѧ��ס����Ϣ
	final int MODIFY_DormitoryID_INFO=85; //��������
	final int INQUIRY_STU=86;     //�޸�ʱ�鿴������Ϣ
}
