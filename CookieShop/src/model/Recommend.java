package model;

// 推荐对象类
public class Recommend {
	// 设置推荐的样式 1条幅 2热销 3新品
	public static final int BANNERS = 1;
	public static final int HOTSALE = 2;
	public static final int NEWPRODUCTS = 3;

	private int id;
	private int type;//1条幅 2热销 3新品
	private Goods goods;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Recommend(int id, int type, Goods goods) {
		super();
		this.id = id;
		this.type = type;
		this.goods = goods;
	}
	public Recommend() {
		super();
	}
	
	
}
