package k;


/**
 * MESSAGE TYPE
 * 
 * 常量定义
 * 
 * @author 全体成员
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
	 * 服务器端操作成功与否，通知客户端
	 */
	final int SERVER_OPERATION_SUCC =3290;
	final int SERVER_OPERATION_FAIL = 3291;
	/**
	 * 课程模块数据常量
	 * 通过查询不同的数据库表来区分从所以课程查询，还是从已选课程中查询
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
	 * 商品模块数据常量
	 */
final int ADM_MODIFY_GOODS = 22;	//修改商品
	
	final int INQUIRY_GOODS_BY_ID = 24;		//通过ID查找课程
	final int INQUIRY_GOODS_BY_NAME = 25;	//通过名称查找课程
	final int INQUIRY_GOODS_BY_TYPE = 26;   //通过类型查找商品


	final int INQUIRY_STUDY_PRO = 401;//展示学习用品
	final int INQUIRY_LIFE_PRO = 402;//展示生活用品
	final int INQUIRY_FOOD_PRO = 403;//展示食品
	final int INQUIRY_ALL_PRO = 404;//展示所有商品
	final int SHOW_PAID_PRO = 405;//展示已购买商品
	
	final int PERSON_RESERVE_RECORD = 406;   //查询个人预定商品记录 我的购物车
	final int RESERVE_GOODS = 407;    //预定商品 加入购物车
	final int DISRESERVE_GOODS = 408;  //退订商品 从购物车删除
	final int PAY_FOR_BILL=409;//确认付款
	
	final int ADM_ADD_GOODS = 410;		//管理员添加商品
	final int ADM_MODIFY_COUNT = 411;	//管理员修改商品库存
	final int ADM_MODIFY_PRICE = 412;	//管理员修改商品价格
	final int ADM_DELETE_GOODS = 413;	//管理员删除商品
	final int ADM_GET_COUNTS = 414;   //管理员获得商品库存
	
	final int IS_EXIST = 415;//库存中是否存在该商品
	final int IS_EXIST_CART = 416;//购物车中是否存在该商品
	/**
	
	

	
	/**
	 * 书籍模块数据常量
	 * 通过查询不同的数据库表来区分
	 */
	final int GET_ALL_BOOK = 50;		//查询所有书籍
	final int ADD_BOOK = 51;		//添加书籍
	final int MODIFY_BOOK = 52;		//修改书籍
	final int DELETE_BOOK = 53;		//删除书籍
	final int INQUIRY_BOOK_BY_ID = 54;		//通过ID查找书籍
	final int INQUIRY_BOOK_BY_NAME = 55;	//通过名称查找书籍
	final int INQUIRY_BOOK_BY_CODE = 56;	//通过图书种类编号查找书籍
	final int INQUIRY_BOOK_BY_TYPE = 154;	//通过图书种类查找书籍
	final int INQUIRY_BOOK_BY_WRITER = 155;	//通过责任者查找图书
	final int INQUIRY_BOOK_BY_PUBLISH = 156;//通过出版社查找图书
	
	final int SUBSCRIBE_BOOK = 57;			//借书
	final int UNSUBSCRIBE_BOOK = 58;		//还书
	final int PERSON_BORROW_RECORD = 59;	//个人借阅记录
	
	/**
	 * 教师管理学生学籍
	 */
	final int GET_ALL_STU = 60;
	final int ADD_STU = 61;		//添加学生
	final int MODIFY_STU = 62;	//修改学生
	final int DELETE_STU = 63;	//删除学生
	final int INQUIRY_STU_BY_NO = 64;	//通过ID查找学生
	final int INQUIRY_STU_BY_NAME = 65;	//通过名称查找学生
	final int INQUIRY_GRADE = 68;	//查询成绩//分布...
	
	/**
	 * 信息反馈，注册
	 */
	final int STU_REGISTER = 71;	//学生请求注册
	final int FEEDBACK = 72;		//信息反馈，留言板
	/**
	 * 餐厅管理模块数据常量---By张雅淋
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
	 * 宿舍管理
	 */
	final int GET_ALL_STU_INFO = 80;		//查询学生信息
	final int ADD_STU_Dormitory_INFO = 81;		//添加学生住宿信息
	final int MODIFY_Dormitory_INFO = 82;		//修改学生住宿信息
	final int DELETE_Dormitory_INFO = 83;		//删除学生住宿信息
	final int INQUIRY_STU_BY_ID = 84;		//通过ID查阅学生住宿信息
	final int MODIFY_DormitoryID_INFO=85; //调换宿舍
	final int INQUIRY_STU=86;     //修改时查看基本信息
}
