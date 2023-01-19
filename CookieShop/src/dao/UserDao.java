package dao;

import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DBUtil;

import java.sql.SQLException;

public class UserDao {
    // 拿到执行者对象
    private static QueryRunner qr = new QueryRunner(DBUtil.getDataSource());

    // 添加用户
    public void addUser(User user) throws SQLException {
        // sql语句
        String sql = "insert into user(username,email,password,name,phone,address,isadmin,isvalidate) " +
                "values(?,?,?,?,?,?,?,?)";
        // 执行
        qr.update(sql,user.getUsername(),user.getEmail(),user.getPassword(),user.getName(),user.getPhone(),user.getAddress(),user.isIsadmin(),user.isIsvalidate());
    }

    // 判断用户是否存在
    public boolean isUsernameExist(String username) throws SQLException {
        // sql语句
        String sql = "select * from user where username = ?";
        // 执行
        User user = qr.query(sql, new BeanHandler<User>(User.class), username);
        if(user != null){
            return true;
        }
        return false;
    }

    // 判断邮箱是否存在
    public boolean isEmailExist(String email) throws SQLException {
        // sql语句
        String sql = "select * from user where email = ?";
        // 执行
        User user = qr.query(sql, new BeanHandler<User>(User.class), email);
        if(user != null){
            return true;
        }
        return false;
    }
}
