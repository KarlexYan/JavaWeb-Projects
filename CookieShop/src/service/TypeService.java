package service;

import dao.TypeDao;
import model.Type;

import java.sql.SQLException;
import java.util.List;

// 类型对象业务层，负责类型相关的业务逻辑
public class TypeService {
    // 创建类型对象持久层私有化对象
    TypeDao tDao=new TypeDao();

    // 获取所有类型业务
    public List<Type> GetAllType()
    {
        // 创建List对象，初始化null
        List<Type> list=null;
        try {
            // 调用持久层，获取所有类型
            list=tDao.GetAllType();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回类型列表
        return list;
    }

    // 根据id查找对应的类型名称业务
    public Type selectTypeNameByID(int typeid)
    {
        // 创建type对象，初始化为null;
        Type type=null;
        try {
            // 调用类型的持久层，根据传入的typeid查找对应的类型名称
            type=tDao.selectTypeNameByID(typeid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回得到的type对象
        return type;
    }
    public Type select(int id) {
        Type t=null;
        try {
            t = tDao.select(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;
    }

    // 添加类型数据业务
    public void insert(Type t) {
        try {
            tDao.insert(t);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 更新类型数据业务
    public void update(Type t) {
        try {
            tDao.update(t);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 删除类型数据业务，删除成功返回true，失败返回false
    public boolean delete(int id) {
        try {
            tDao.delete(id);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
