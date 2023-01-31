package dao;

import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

// 用户持久层，负责用户相关的数据库操作
public class UserDao {
    // 私有化QueryRunner对象，简化SQL查询
    QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

    // 添加用户
    public void addUser(User user) throws SQLException {
        // 定义sql语句
        String sql = "insert into user(username,email,password,name,phone,address,isadmin,isvalidate) values(?,?,?,?,?,?,?,?)";
        // 执行语句，将数据依次插入数据表
        qr.update(sql,user.getUsername(),user.getEmail(),user.getPassword(),user.getName(),user.getPhone(),user.getAddress(),user.isIsadmin(),user.isIsvalidate());
    }

    // 判断用户是否存在
    public boolean isUsernameExist(String username) throws SQLException {
        // 定义sql语句，根据username查找所有信息
        String sql = "select * from user where username = ?";
        // 执行语句
        User u = qr.query(sql, new BeanHandler<User>(User.class),username);
        // 如果返回的是null，说明用户不存在，返回false
        if(u==null) {
            return false;
            // 否则用户已存在，返回true
        }else {
            return true;
        }
    }
    public boolean isEmailExist(String email) throws SQLException {
        String sql = "select * from user where email = ?";
        User u = qr.query(sql, new BeanHandler<User>(User.class),email);
        if(u==null) {
            return false;
        }else {
            return true;
        }
    }

    // 通过用户名密码方式查找用户
    public User selectByUsernamePassword(String username,String password) throws SQLException {
        // 定义sql语句
        String sql = "select * from user where username=? and password=?";
        // 执行语句，返回user对象
        return qr.query(sql, new BeanHandler<User>(User.class),username,password);
    }

    // 通过邮箱和密码方式查找用户
    public User selectByEmailPassword(String email,String password) throws SQLException {
        // 定义sql语句
        String sql = "select * from user where email=? and password=?";
        // 执行语句，返回user对象
        return qr.query(sql, new BeanHandler<User>(User.class),email,password);
    }
    public User selectById(int id) throws SQLException {
        String sql = "select * from user where id=?";
        return qr.query(sql, new BeanHandler<User>(User.class),id);
    }

    // 更新收货地址
    public int updateUserAddress(User user) throws SQLException {
        // 定义sql语句
        String sql ="update user set name = ?,phone=?,address=? where id = ?";
        // 执行更新语句
        int update = qr.update(sql, user.getName(), user.getPhone(), user.getAddress(), user.getId());
        // 如果更新成功，会返回大于0的数字
        return update;
    }

    // 修改密码
    public int updatePwd(User user) throws SQLException {
        // 定义sql语句
        String sql ="update user set password = ? where id = ?";
        // 执行更新语句
        int update = qr.update(sql, user.getPassword(), user.getId());
        // 如果更新成功，会返回大于0的数字
        return update;
    }

    // 查找用户数量
    public int selectUserCount() throws SQLException {
        // 定义sql语句
        String sql = "select count(*) from user";
        // 执行
        int i = qr.query(sql, new ScalarHandler<Long>()).intValue();
        // 返回数量
        return i;
    }

    // 获取指定页的客户信息列表
    public List selectUserList(int pageNo, int pageSize) throws SQLException {
        // 定义sql语句
        String sql = "select * from user limit ?,?";
        // 执行语句，获取到列表
        List<User> query = qr.query(sql, new BeanListHandler<User>(User.class), (pageNo - 1) * pageSize, pageSize);
        // 返回列表
        return query;
    }

    // 根据用户id删除指定用户
    public void delete(int id) throws SQLException {
        // 定义sql语句
        String sql = "delete from user where id = ?";
        qr.update(sql,id);
    }
}
