package dao;

import model.Type;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

// 类型对象持久层，负责类型相关的数据库操作
public class TypeDao {
    // 私有化QueryRunner对象，简化SQL查询
    QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

    // 获取所有类型，返回一个List表
    public List<Type> GetAllType() throws SQLException {
        // 定义sql语句
        String sql="select * from type";
        // 执行语句，返回list表
        return qr.query(sql,new BeanListHandler<Type>(Type.class));
    }

    // 根据传入的typeid查找对应的类型名称
    // select * from type where id=2
    public Type selectTypeNameByID(int typeid) throws SQLException {
        // 定义sql语句
        String sql="select * from type where id=?";
        // 执行语句，得到的是对应的type对象
        Type query = qr.query(sql, new BeanHandler<Type>(Type.class), typeid);
        // 返回对象
        return query;
    }
    public Type select(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from type where id = ?";
        return r.query(sql, new BeanHandler<Type>(Type.class),id);
    }

    // 添加类型数据
    public void insert(Type t) throws SQLException {
        // 定义sql语句
        String sql = "insert into type(name) values(?)";
        // 执行语句
        qr.update(sql,t.getName());
    }

    // 更新类型数据
    public void update(Type t) throws SQLException {
        // 定义sql语句
        String sql = "update type set name=? where id = ?";
        // 执行语句
        qr.update(sql,t.getName(),t.getId());
    }

    // 删除类型数据
    public void delete(int id) throws SQLException {
        // 定义sql语句
        String sql = "delete from type where id = ?";
        // 执行语句
        qr.update(sql,id);
    }
}
