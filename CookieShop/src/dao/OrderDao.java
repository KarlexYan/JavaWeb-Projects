package dao;

import model.*;
import org.apache.commons.dbutils.*;
import utils.*;
import java.math.*;
import java.sql.*;
import java.util.*;
import org.apache.commons.dbutils.handlers.*;

// 订单持久层，负责订单相关的数据库操作
public class OrderDao {
    QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
    // 插入订单数据
    public void insertOrder(Connection con, Order order) throws SQLException {
        // 定义sql语句，往order表里插入订单数据
        String sql = "insert into `order`(total,amount,status,paytype,name,phone,address,datetime,user_id) values(?,?,?,?,?,?,?,?,?)";
        // 执行语句
        qr.update(con,sql,
                order.getTotal(),order.getAmount(),order.getStatus(),
                order.getPaytype(),order.getName(),order.getPhone(),
                order.getAddress(),order.getDatetime(),order.getUser().getId() );
    }
    //
    public int getLastInsertId(Connection con) throws SQLException {
        // 定义sql语句，得到刚 insert 进去记录的主键值，只适用与自增主键
        String sql = "select last_insert_id()";
        // 执行语句 主键值转换为String类型
        String query = qr.query(con, sql, new ScalarHandler<BigInteger>()).toString();
        // 转换为int类型，返回获得到的id
        return Integer.parseInt(query);
    }

    // 在订单内插入订单项
    public void insertOrderItem(Connection con, OrderItem item) throws SQLException {
        // 定义sql语句，将商品插入订单项表
        String sql ="insert into orderitem(price,amount,goods_id,order_id) values(?,?,?,?)";
        // 执行语句
        qr.update(con,sql,item.getPrice(),item.getAmount(),item.getGoods().getId(),item.getOrder().getId());
    }

    // 根据用户id查找用户的所有订单
    public List<Order> selectAll(int userid) throws SQLException {
        // 定义sql语句，查找订单所有信息，根据订单日期倒序输出
        String sql = "select * from `order` where user_id=? order by datetime desc";
        // 执行语句，返回订单列表
        List<Order> query = qr.query(sql, new BeanListHandler<Order>(Order.class), userid);
        return query;
    }
    // 根据订单id查找该订单所有订单项
    public List<OrderItem> selectAllItem(int orderid) throws SQLException{
        // 定义sql语句，查找该订单id下的所有订单项商品信息
        String sql = "select i.id,i.price,i.amount,g.name from orderitem i,goods g where order_id=? and i.goods_id=g.id";
        // 执行语句，得到一个订单项列表
        List<OrderItem> query = qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class), orderid);
        // 返回列表
        return query;
    }
    public int getOrderCount(int status) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "";
        if(status==0) {
            sql = "select count(*) from `order`";
            return r.query(sql, new ScalarHandler<Long>()).intValue();
        }else {
            sql = "select count(*) from `order` where status=?";
            return r.query(sql, new ScalarHandler<Long>(),status).intValue();
        }
    }

    // 获取指定状态的订单列表
    public List<Order> selectOrderList(int status, int pageNumber, int pageSize) throws SQLException {
        // 当不添加订单状态类型限制的时候
        if(status==0) {
            // 定义sql语句
            String sql = "select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username " +
                    "from `order` o,user u " +
                    "where o.user_id=u.id " +
                    "order by o.datetime desc " +
                    "limit ?,?";
            // 执行，返回列表
            return qr.query(sql, new BeanListHandler<Order>(Order.class), (pageNumber-1)*pageSize,pageSize );
        }else {
            // 定义sql语句
            String sql = "select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username " +
                    "from `order` o,user u " +
                    "where o.user_id=u.id and o.status=? " +
                    "order by o.datetime desc " +
                    "limit ?,?";
            // 执行，返回列表
            return qr.query(sql, new BeanListHandler<Order>(Order.class),status, (pageNumber-1)*pageSize,pageSize );
        }
    }

    // 修改指定id订单的状态
    public void updateStatus(int id,int status) throws SQLException {
        // 定义sql语句
        String sql ="update `order` set status=? where id = ?";
        // 执行更新语句
        qr.update(sql,status,id);
    }

    // 删除订单
    public void deleteOrder(Connection con ,int id) throws SQLException {
        // 定义sql语句
        String sql ="delete from `order` where id = ?";
        // 执行更新语句
        qr.update(con,sql,id);
    }

    // 从订单中删除订单项
    public void deleteOrderItem(Connection con ,int id) throws SQLException {
        // 定义sql语句，根据订单id删除该订单下的订单项
        String sql ="delete from orderitem where order_id=?";
        // 执行更新语句
        qr.update(con,sql,id);
    }
}
