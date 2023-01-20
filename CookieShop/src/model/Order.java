package model;

import utils.PriceUtils;

import java.util.*;

// 订单类
public class Order {
    private int id;
    private float total;//总价
    private int amount;// 商品总数
    private int status;//1未付款/2已付款/3已发货/4已完成
    private int paytype;//1微信/2支付宝/3货到付款
    private String name;
    private String phone;
    private String address;
    private Date datetime;
    private User user;
    private Map<Integer,OrderItem> itemMap = new HashMap<Integer,OrderItem>();
    private List<OrderItem> itemList = new ArrayList<OrderItem>();

    public void setUsername(String username) {
        user = new User();
        user.setUsername(username);
    }

    // 增加商品
    public void addGoods(Goods g) {
        // 如果该商品id已存在，获取该商品对象，商品数量+1
        if(itemMap.containsKey(g.getId())) {
            OrderItem item = itemMap.get(g.getId());
            item.setAmount(item.getAmount()+1);
        // 商品不存在，新建订单项，存放(价格 数量 商品对象 订单对象)
        }else {
            OrderItem item = new OrderItem(g.getPrice(),1,g,this);
            // itemMap存放id和订单项对象
            itemMap.put(g.getId(), item);
        }
        // 购物车订单里商品总数数量+1
        amount++;
        // 重新计算价格
        total = PriceUtils.add(total, g.getPrice());
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    // 减少商品
    public void lessen(int goodsid) {
        // 在itemMap中查找goodsid是否存在
        if(itemMap.containsKey(goodsid)) {
            // 如果存在，先获取订单项对象，将该订单商品数量-1
            OrderItem item = itemMap.get(goodsid);
            item.setAmount(item.getAmount()-1);
            // 购物车订单里商品总数数量-1
            amount--;
            // 重新计算几个
            total = PriceUtils.subtract(total, item.getPrice());
            // 如果总数数量为0，则直接移除该商品
            if(item.getAmount()<=0) {
                itemMap.remove(goodsid);
            }
        }
    }

    // 删除商品
    public void delete(int goodsid)
    {
        // 在itemMap中查找goodsid是否存在
        if(itemMap.containsKey(goodsid)) {
            // 如果存在，先获取订单项对象
            OrderItem item = itemMap.get(goodsid);
            // 购物车里重新计算价格，减少的价格为原来订单项的数量*金额
            total = PriceUtils.subtract(total, item.getAmount()*item.getPrice());
            // 从购物车里减少商品总数
            amount-=item.getAmount();
            // 移除该商品
            itemMap.remove(goodsid);
        }
    }

    public Map<Integer, OrderItem> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Integer, OrderItem> itemMap) {
        this.itemMap = itemMap;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getPaytype() {
        return paytype;
    }
    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getDatetime() {
        return datetime;
    }
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Order() {
        super();
    }
}
