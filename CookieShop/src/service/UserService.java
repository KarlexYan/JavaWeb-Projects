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
}
