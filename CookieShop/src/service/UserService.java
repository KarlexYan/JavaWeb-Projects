package service;

import dao.UserDao;
import model.Page;
import model.User;

import java.sql.SQLException;
import java.util.List;

// 用户业务层，存放用户相关的业务逻辑
public class UserService {
    // 私有化对象
    private UserDao uDao = new UserDao();

    // 用户注册业务
    public boolean register(User user) {
        try {
            // 判断用户名是否存在，如果已存在，说明不能注册，返回false
            if(uDao.isUsernameExist(user.getUsername())) {
                return false;
            }
            // 判断邮箱是否存在，如果已存在，说明不能注册，返回false
            if(uDao.isEmailExist(user.getEmail())) {
                return false;
            }
            // 经过上面判断，证明用户不存在，可以正常注册
            uDao.addUser(user);
            // 注册成功返回true
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    // 用户登录业务
    public User login(String ue,String password) {
        User user=null;
        try {
            // 通过用户名密码方式查找用户，获取到user对象
            user = uDao.selectByUsernamePassword(ue, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 如果user不为空，说明已经查找到用户，返回user对象
        if(user!=null) {
            return user;
        }
        try {
            // 通过邮箱和密码方式查找用户，获取到user对象
            user=uDao.selectByEmailPassword(ue, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 如果user不为空，说明已经查找到用户，返回user对象
        if(user!=null) {
            return user;
        }
        // 查找不到用户，返回null
        return null;
    }
    public User selectById(int id) {
        User u=null;
        try {
            u = uDao.selectById(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return u;
    }

    // 个人中心修改收货地址业务
    public int updateUserAddress(User user) {
        int i = 0;
        try {
            // 更新收货地址
            i = uDao.updateUserAddress(user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 如果更新成功，会返回大于0的数字
        return i;
    }

    // 用户修改密码业务
    public int updatePwd(User user) {
        int i = 0;
        try {
            // 调用持久层，更新密码
            i = uDao.updatePwd(user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 如果更新成功，会返回大于0的数字
        return i;
    }

    // 获取用户的Page对象
    public Page getUserPage(int pageNumber) {
        // 创建page对象
        Page p = new Page();
        // 设置页码为传入的参数pageNumber
        p.setPageNumber(pageNumber);
        // 设置一页存放7个数据
        int pageSize = 7;
        // 初始化客户数量为0
        int totalCount = 0;
        try {
            // 调用用户持久层，查找并获取到用户总数量
            totalCount = uDao.selectUserCount();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 根据获取到的数量，按照每页7个，计算页数和总页码
        p.SetPageSizeAndTotalCount(pageSize, totalCount);
        // 创建List对象，初始化为null
        List list=null;
        try {
            // 调用用户持久层，获取到当前页的所有用户信息，传入到list中
            list = uDao.selectUserList( pageNumber, pageSize);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 将列表设置进page对象中，返回
        p.setList(list);
        return p;
    }

    // 删除用户业务
    public boolean delete(int id ) {
        try {
            // 调用用户持久层，根据id删除用户
            uDao.delete(id);
            // 删除成功，返回true
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            // 删除失败，返回false
            return false;
        }
    }
}
