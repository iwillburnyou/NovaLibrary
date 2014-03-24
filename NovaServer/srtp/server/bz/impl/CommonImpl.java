package seu.server.bz.impl;

import java.security.Key;
import java.sql.SQLException;
import java.util.Vector;

import k.MessageType;
import k.MyMessage;
import seu.Client.vo.BookInfo;
import seu.Client.vo.ProductInfo;
import seu.Client.vo.StudentDorInfo;
import seu.Client.vo.StudentInfo;
import seu.server.bz.impl.StuInfoImpl;

/**
 * 服务器端公共的执行类
 * 
 */

public class CommonImpl implements k.MessageType {
	/**
	 * 服务器端用于执行命令的函数
	 * 
	 * @return boolean 
	 * 是否执行成功
	 * 
	 * @param 消息类
	 */
	public static boolean executeCmd(MyMessage mm) throws SQLException {
		System.out.println("server executeCmd:" + mm.getCmd());
		switch (mm.getCmd()) {
		// //选课系统
		case STU_CUR:
			SubjseleImpl.STU_CUR((String) mm.getOb());
			return true;
		case ADD_SUBJ:
			// System.out.println("server add subj ");
			SubjseleImpl.addSubj((String) mm.getOb());
			return true;
		case GET_ALLCUR:
			mm.setOb((Object) SubjseleImpl.getAllCur((String) mm.getOb()));
			return true;
		case MOD_SUBJ:
			// System.out.println("server mod subj ");
			SubjseleImpl.modSubj((String) mm.getOb());
			return true;
		case DEL_SUBJ:
			// System.out.println("server mod subj ");
			SubjseleImpl.delSubj((String) mm.getOb());
			return true;
		case GET_MATH:
			mm.setOb((Object) SubjseleImpl.getMath((String) mm.getOb()));
			return true;
		case ADD_MATH:
			SubjseleImpl.addMath((String) mm.getOb());
			return true;
		case DEL_MATH:
			SubjseleImpl.delMath((String) mm.getOb());
			return true;
		case GET_PHYSICS:
			mm.setOb((Object) SubjseleImpl.getPhysics((String) mm.getOb()));
			return true;
		case ADD_PHYSICS:
			SubjseleImpl.addPhysics((String) mm.getOb());
			return true;
		case DEL_PHYSICS:
			SubjseleImpl.delPhysics((String) mm.getOb());
			return true;
		case GET_ENGLISH:
			mm.setOb((Object) SubjseleImpl.getEnglish((String) mm.getOb()));
			return true;
		case ADD_ENGLISH:
			SubjseleImpl.addEnglish((String) mm.getOb());
			return true;
		case DEL_ENGLISH:
			SubjseleImpl.delEnglish((String) mm.getOb());
			return true;
		case GET_PE:
			mm.setOb((Object) SubjseleImpl.getPE((String) mm.getOb()));
			return true;
		case ADD_PE:
			SubjseleImpl.addPE((String) mm.getOb());
			return true;
		case DEL_PE:
			SubjseleImpl.delPE((String) mm.getOb());
			return true;
		case GET_COMPUTER:
			mm.setOb((Object) SubjseleImpl.getComputer((String) mm.getOb()));
			return true;
		case ADD_COMPUTER:
			SubjseleImpl.addComputer((String) mm.getOb());
			return true;
		case DEL_COMPUTER:
			SubjseleImpl.delComputer((String) mm.getOb());
			return true;
		case GET_ART:
			mm.setOb((Object) SubjseleImpl.getArt((String) mm.getOb()));
			return true;
		case ADD_ART:
			SubjseleImpl.addArt((String) mm.getOb());
			return true;
		case DEL_ART:
			SubjseleImpl.delArt((String) mm.getOb());
			return true;
		case GET_ECNOMICS:
			mm.setOb((Object) SubjseleImpl.getEcnomics((String) mm.getOb()));
			return true;
		case ADD_ECNOMICS:
			SubjseleImpl.addEcnomics((String) mm.getOb());
			return true;
		case DEL_ECNOMICS:
			SubjseleImpl.delEcnomics((String) mm.getOb());
			return true;
		case GET_SCIENCE:
			mm.setOb((Object) SubjseleImpl.getScience((String) mm.getOb()));
			return true;
		case ADD_SCIENCE:
			SubjseleImpl.addScience((String) mm.getOb());
			return true;
		case DEL_SCIENCE:
			SubjseleImpl.delScience((String) mm.getOb());
			return true;
		case GET_STUCUR:
			mm.setOb((Object) SubjseleImpl.getStuCur((String) mm.getOb()));
			return true;

			// //
			// canteen部分---by张雅淋
		case ADD_ADVICE:
			// System.out.println("server add advice ");
			CanteenInfoImpl.addAdvice((String) mm.getOb());
			mm.setOb("添加操作成功！");
			return true;
		case GET_ADVICE:
			// System.out.println("server get advice ");
			mm.setOb(CanteenInfoImpl.getAdvice((String) mm.getOb()));
			return true;
		case CHANGE_READ:
			// System.out.println("server add DishBuy ");
			CanteenInfoImpl.changeRead((String) mm.getOb());
			return true;
		case DEL_ADVICE:
			System.out.println("server del advice ");
			CanteenInfoImpl.delAdvice((String) mm.getOb());
			return true;
		case GET_DISH:
			mm.setOb(CanteenInfoImpl.getDish((String) mm.getOb()));
			return true;
		case ADD_DISH:
			CanteenInfoImpl.addDish((String) mm.getOb());
			return true;
		case CHANGE_DISH:
			CanteenInfoImpl.changeDish((String) mm.getOb());
			return true;
		case DEL_DISH:
			System.out.println("server del dish ");
			CanteenInfoImpl.delDish((String) mm.getOb());
			return true;
		case ADD_DISHBUY:
			// System.out.println("server add DishBuy ");
			CanteenInfoImpl.addDishBuy((String) mm.getOb());
			return true;
		case DEL_DISHBUY:
			// System.out.println("server del DishBuy ");
			CanteenInfoImpl.delDishBuy((String) mm.getOb());
			return true;
		case GET_ALLDISHBUY:
			// System.out.println("server get Dish ");
			mm.setOb(CanteenInfoImpl.getAllDishBuy((String) mm.getOb()));
			return true;
		case CHANGE_IFSEND:
			CanteenInfoImpl.changeIfSend((String) mm.getOb());
			return true;
		case DEL_TAKEAWAY:
			CanteenInfoImpl.delTakeAway((String) mm.getOb());
			return true;
			// canteen 部分 -by 张雅淋

			// 刘宇晨
		case GET_MESSAGE:
			mm.setOb(LoginImpl.getMessage((String) mm.getOb()));
			return true;
		case REGISTER_NEW:
			LoginImpl.registerNew((String) mm.getOb());
			return true;
		case CHANGE_PSD:
			LoginImpl.changePSD((String) mm.getOb());
			return true;
			// ////
			/*
			 * 學籍管理部分
			 * 
			 * @author 王一多
			 */
		case DELETE_STU:
			System.out.println("server delete ");
			StuInfoImpl.delStu((String) mm.getOb());
			return true;
		case ADD_STU:
			StuInfoImpl.addStu((StudentInfo) mm.getOb());
			mm.setOb("添加操作成功！");
			return true;
		case MessageType.INQUIRY_STU_BY_NAME:
			mm.setOb((Object) StuInfoImpl.queryByName((String) mm.getOb()));
			return true;
		case MessageType.INQUIRY_STU_BY_NO:
			mm.setOb((Object) StuInfoImpl.queryByNo((String) mm.getOb()));
			return true;
		case MODIFY_STU:
			StuInfoImpl.updateStu((StudentInfo) mm.getOb());
			mm.setOb(true);
			return true;
			/*
			 * 商店系统
			 */
		case INQUIRY_STUDY_PRO:// 展示学习用品
			mm.setOb((Object) ShopImpl.ShStudyPro((String) mm.getOb()));
			return true;
		case INQUIRY_LIFE_PRO:// 展示生活用品
			mm.setOb((Object)ShopImpl.ShLifePro((String) mm.getOb()));
			return true;
		case INQUIRY_FOOD_PRO:// 展示食品
			mm.setOb((Object)ShopImpl.ShFoodPro((String) mm.getOb()));
			return true;
		case INQUIRY_ALL_PRO:// 购物页面展示所有商品
			mm.setOb((Object)ShopImpl.ShAllPro((String) mm.getOb()));
			return true;
		case SHOW_PAID_PRO:// 显示已该买商品
			mm.setOb((Object)ShopImpl.ShPaidPro((String) mm.getOb()));
			return true;
		case PERSON_RESERVE_RECORD:// 展示购物车中商品
			mm.setOb((Object)ShopImpl.ShCart((String) mm.getOb()));
			return true;
		case RESERVE_GOODS:// 加入购物车
			ShopImpl.AddToCart((ProductInfo) mm.getOb());
			return true;
		case DISRESERVE_GOODS:// 删除购物车中商品
			ShopImpl.DelCartPro((String) mm.getOb());
			return true;
		case PAY_FOR_BILL:// 确认支付
			mm.setOb((Object)ShopImpl.PayForBill((ProductInfo) mm.getOb()));
			return true;
		case ADM_ADD_GOODS:// 管理员添加商品
			ShopImpl.AddPro((ProductInfo) mm.getOb());
			return true;
		case ADM_MODIFY_COUNT:// 管理员修改库存
			ShopImpl.ChangeCount((ProductInfo) mm.getOb());
			return true;
		case ADM_MODIFY_PRICE:// 管理员修改价格
			ShopImpl.ChangePrice((ProductInfo) mm.getOb());
			return true;
		case ADM_DELETE_GOODS:// 管理员删除商品
			ShopImpl.DelPro((String) mm.getOb());
			return true;
		case ADM_GET_COUNTS:// 管理员获得商品库存
			mm.setOb((Object)ShopImpl.Shkucun((String) mm.getOb()));
			return true;
		case IS_EXIST:// 库存中是否存在
			mm.setOb((Object) ShopImpl.IsExist((String) mm.getOb()));
			return true;
		case INQUIRY_GOODS_BY_NAME:// 通过名称查找课程
			mm.setOb((Object)ShopImpl.SearByName((String) mm.getOb()));
			return true;
			/*
			 * 宿舍那些事儿
			 */
		case GET_ALL_STU_INFO:
			System.out.println("server get all ");
			mm.setOb(StuDorInfoImpl.dor());
			return true;
		case ADD_STU_Dormitory_INFO:
			StuDorInfoImpl.StuAdd((Vector<String>) mm.getOb());
			return true;
		case MODIFY_Dormitory_INFO:
			StuDorInfoImpl.StuCha( ( (StudentDorInfo) mm.getOb()).getVec(),
					((StudentDorInfo) mm.getOb()).getStudentNo());
			return true;
		case INQUIRY_STU:
			mm.setOb(StuDorInfoImpl.LookSb((String) mm.getOb()));
			return true;
		case MODIFY_DormitoryID_INFO:
			mm.setOb(StuDorInfoImpl.StuChador((Vector) mm.getOb()));
			return true;
		case DELETE_Dormitory_INFO:
			StuDorInfoImpl.StuDel((String) mm.getOb());
			return true;
		case INQUIRY_STU_BY_ID:
			mm.setOb(StuDorInfoImpl.StuDorInfo((String) mm.getOb()));
			return true;
			//图书案管理
			//杨云
		case GET_ALL_BOOK://
			//mm.setOb((Object) StuInfoImpl.queryByNo((String) mm.getOb()) ) ;			
			mm.setOb(true);
			return true;
		case ADD_BOOK://
			BookInfoImpl.addBook((BookInfo)mm.getOb() );
			mm.setOb("添加操作成功！");
			return true;
		case MODIFY_BOOK://
			BookInfoImpl.updateBook((BookInfo)mm.getOb() );
			mm.setOb(true);
			return true;
		case DELETE_BOOK://
			BookInfoImpl.delBook((String)mm.getOb() );
			mm.setOb(true);
			return true;
		case INQUIRY_BOOK_BY_ID://
			mm.setOb((Object) BookInfoImpl.queryByNo((String) mm.getOb()) ) ;			
			
			return true;
		case SUBSCRIBE_BOOK:
			BookInfoImpl.addBookRent((String)mm.getOb());
			return true;
		case UNSUBSCRIBE_BOOK:
			BookInfoImpl.deletebookrent((String) mm.getOb());
			return true;
		case PERSON_BORROW_RECORD :
			mm.setOb(BookInfoImpl.getBookRent((String)mm.getOb()));
			return true;
		default:
			System.out.println("command not found!");
			return false;

		}
	}
}
