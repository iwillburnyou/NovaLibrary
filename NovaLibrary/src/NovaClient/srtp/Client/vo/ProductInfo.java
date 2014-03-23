package seu.Client.vo;

import java.io.Serializable;
/**
 *商品信息的实体类
 *@author 张梦微 
 */
public class ProductInfo implements Serializable{
	private static final long serialVersionUID = 1L;

	String Name;
	int Count;
	String Type;
	double Price;
	/**
	 * 商品信息实体类的默认构造函数
	 */
	public ProductInfo(){
		
	}

/**
 * 商品信息实体类的设置所有成员的函数
 * @param type
 * 商品类型
 * @param name
 * 商品名称
 * @param price
 * 商品价格
 * @param count
 * 库存数量
 */
	public  void ProsetAll(String type,String name,double price,int count) {
		this.Name = name;
		this.Count = count;
		this.Type = type;
		this.Price = price;

	}
	
	/**
	 * 获取商品ID
	 * 
	 * @return
	 * 商品ID
	 * public String getId() {
		return Id;
	}

	 */
	
	/**
	 * 设置商品ID
	 * 
	 * @param id
	 * 商品ID
	 * public void setId(String id) {
		Id = id;
	}

	 */
	
	/**
	 * 获取商品名称
	 * 
	 * @return
	 * 商品名称
	 */
	public String getName() {
		return Name;
	}

	/**
	 * 设置商品名称
	 * 
	 * @param name
	 * 商品名称
	 */
	public void setName(String name) {
		Name = name;
	}

	
	/**
	 * 获取商品数量
	 * 
	 * @return
	 * 商品数量
	 */
	public int getCount() {
		return Count;
	}

	/**
	 * 设置商品数量
	 * 
	 * @param count
	 * 商品数量
	 */
	public void setCount(int count) {
		Count = count;
	}

	/**
	 * 获取商品种类
	 * 
	 * @return
	 * 商品种类
	 */
	public String getType() {
		return Type;
	}

	/**
	 * 设置商品种类
	 * 
	 * @param type
	 * 商品种类
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * 获取商品价格
	 * 
	 * @return
	 * 商品价格
	 */
	public double getPrice() {
		return Price;
	}

	/**
	 * 设置商品价格
	 * 
	 * @param price
	 * 商品价格
	 */
	public void setPrice(double price) {
		Price = price;
	}

}
