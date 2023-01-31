package service;

import dao.*;
import model.*;
import utils.*;

import java.sql.*;
import java.util.List;

// 订单业务层，存放订单相关的业务逻辑
public class OrderService {
    // 私有化订单持久层
    private OrderDao oDao = new OrderDao();

    // 添加订单业务
    public void addOrder(Order order) {
        // 创建连接对象
        Connection con = null;
        try {
            // 获取连接
            con = DataSourceUtils.getConnection();
            // 关闭mysql的自动提交，防止sql报错产生脏数据
            con.setAutoCommit(false);
            // 调用订单持久层，插入订单数据
            oDao.insertOrder(con, order);
            // 获取 insert 进去记录的主键值
            int id = oDao.getLastInsertId(con);
            // 在订单对象里设置id为主键值
            order.setId(id);
            // 创建订单后，往订单里插入订单项
            for(OrderItem item : order.getItemMap().values()) {
                oDao.insertOrderItem(con, item);
            }
            // 以上都没报错后，提交mysql事务
            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            // 如果获取不到连接，回滚
            if(con!=null)
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        }
    }
    // 根据用户id查询订单信息业务
    public List<Order> selectAll(int userid){
        // 初始化List列表
        List<Order> list=null;
        try {
            // 调用订单持久层，查询用户id所有的订单信息，存入到list当中
            list = oDao.selectAll(userid);
            // 遍历list
            for(Order o :list) {
                // 根据订单id查找所有订单项
                List<OrderItem> l = oDao.selectAllItem(o.getId());
                // 在订单类中设置该ItemList，用于在我的订单页展示 商品详情 信息
                o.setItemList(l);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 返回列表
        return list;
    }

    // 获取订单的Page对象
    public Page getOrderPage(int status,int pageNumber) {
        // 创建page对象
        Page p = new Page();
        // 设置页码为传入的参数pageNumber
        p.setPageNumber(pageNumber);
        int pageSize = 10;
        // 初始化 商品数量为0
        int totalCount = 0;
        try {
            // 调用订单持久层，输入的参数为status，获取该状态的订单总数量
            totalCount = oDao.getOrderCount(status);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 根据获取到的数量，按照每页8个，计算页数和总页码
        p.SetPageSizeAndTotalCount(pageSize, totalCount);
        // 创建List对象，初始化为null
        List list=null;
        try {
            // 调用订单持久层，获取到当前页的所有商品信息，传入到list中
            list = oDao.selectOrderList(status, pageNumber, pageSize);
            // 得到列表后，遍历列表得到每一个Order对象
            for(Order o :(List<Order>)list) {
                // 根据订单id查找该订单所有订单项
                List<OrderItem> l = oDao.selectAllItem(o.getId());
                // 在订单类中设置该ItemList，用于在后台订单列表页展示 商品详情 信息
                o.setItemList(l);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 将列表设置进page对象中，返回
        p.setList(list);
        return p;
    }

    // 更新订单状态业务
    public void updateStatus(int id,int status) {
        try {
            // 调用订单持久层，执行更新状态操作
            oDao.updateStatus(id, status);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 删除订单业务
    public void delete(int id) {
        // 初始化Connection对象
        Connection con = null;
        try {
            // 获取连接
            con = DataSourceUtils.getDataSource().getConnection();
            // 关闭自动提交事务，避免产生垃圾数据
            con.setAutoCommit(false);
            // 调用订单持久层，先从订单中删除订单项
            oDao.deleteOrderItem(con, id);
            // 调用订单持久层，删除订单
            oDao.deleteOrder(con, id);
            // 如没有报错，提交事务
            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            // 如果获取不了连接
            if(con!=null)
                try {
                    // 执行回滚
                    con.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        }
    }
}
