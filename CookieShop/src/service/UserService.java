package service;

import dao.UserDao;
import model.User;

import java.sql.SQLException;

public class UserService {
    private UserDao userDao = new UserDao();
    // 注册功能
    public boolean register(User user){
        try {
            // 判断用户能否注册
            if(userDao.isUsernameExist(user.getUsername())){
                return false;
            }
            // 判断邮箱能否注册
            if(userDao.isUsernameExist(user.getEmail())){
                return false;
            }
            // 走到这里证明可以注册了
            userDao.addUser(user);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    // 登录功能
    public User login(String ue,String password){
        User user = null;
        // 使用用户名和密码登录
        try {
            user = userDao.selectUsernamePassword(ue, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 如果是用户名，就不用跑下面的 直接返回user对象
        if(user!=null){
            return user;
        }

        // 使用邮箱和密码登录
        try {
            user = userDao.selectEmailPassword(ue,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 返回user
        return user;
    }
}
