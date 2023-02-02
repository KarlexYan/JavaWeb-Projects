package service;

import dao.GoodsDao;
import model.Goods;
import model.Page;
//import sun.nio.cs.ext.IBM037;

import javax.management.monitor.StringMonitorMBean;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

// 商品业务层，负责商品相关的业务逻辑
public class GoodsService {
    // 私有化变量
    private GoodsDao gDao=new GoodsDao();

    // 获取对应商品类别的列表
    public List<Map<String,Object>> getGoodsList(int recommendType) {
        // 创建一个List存放商品
        List<Map<String,Object>> list=null;
        try {
            // 调用商品持久层，根据输入参数获取对应类别的商品，写入list
            list=gDao.getGoodsList(recommendType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回list
        return list;
    }

    // 获取轮播图的商品信息
    public List<Map<String,Object>> getScrollGood() {
        // 创建一个List存放轮播商品
        List<Map<String,Object>> list=null;
        try {
            // 调用商品持久层，获取轮播商品，写入list
            list=gDao.getScrollGood();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回list
        return list;
    }
    public List<Goods> selectGoodsByTypeID(int typeID, int pageNumber, int pageSize)
    {
        List<Goods> list=null;
        try {
            list=gDao.selectGoodsByTypeID(typeID,pageNumber,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 根据对应的typeid查找page对象
    public Page selectPageByTypeID(int typeID,int pageNumber)
    {
        // 创建page对象
        Page p=new Page();
        // 设置page对象的当前页为pageNumber
        p.setPageNumber(pageNumber);
        // 定义int类型用来统计所有商品数量
        int totalCount=0;
        // 调用商品持久层，获取该typeid下所有商品数量
        try {
            totalCount=gDao.getCountOfGoodsByTypeID(typeID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 一页有8个商品，计算总共有多少页，存放在Page实体类中
        p.SetPageSizeAndTotalCount(8,totalCount);

        // 创建一个List列表对象
        List list=null;
        try {
            // 调用商品持久层，根据typeid和页码查找商品列表，将得到的列表传入list中
            list=gDao.selectGoodsByTypeID(typeID,pageNumber,8);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 将获取到的列表存入page对象中
        p.setList(list);
        // 返回page对象
        return p;
    }
    // 获取热销商品页码对象
    public Page getGoodsRecommendPage(int type,int pageNumber) {
        // 创建page对象
        Page p = new Page();
        // 将页码修改为传入的页码
        p.setPageNumber(pageNumber);
        // 初始化总商品数量为0
        int totalCount = 0;
        try {
            // 调用商品持久层，根据typeid获取热销商品总数量
            totalCount = gDao.getRecommendCountOfGoodsByTypeID(type);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 设置一页8个商品，计算总共有多少页，存放在Page实体类中
        p.SetPageSizeAndTotalCount(8, totalCount);
        // 初始化list，用于存放获取到的商品
        List list=null;
        try {
            // 调用商品持久层，根据typeid和页码查找商品列表，将得到的列表传入list中
            list = gDao.selectGoodsbyRecommend(type, pageNumber, 8);
            // 遍历list，设置每一个商品对象是否为条幅、热销、新品
            for(Goods g : (List<Goods>)list) {
                g.setScroll(gDao.isScroll(g));
                g.setHot(gDao.isHot(g));
                g.setNew(gDao.isNew(g));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 将列表传入到page对象里
        p.setList(list);
        // 返回page对象
        return p;
    }

    // 使用id获取商品对象
    public Goods getGoodsById(int id) {
        // 创建商品对象
        Goods g=null;
        try {
            // 调用商品持久层，输入id获取商品信息，写入到goods对象中
            g = gDao.getGoodsById(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 返回对象
        return g;
    }

    //
    public Page getSearchGoodsPage(String keyword, int pageNumber) {
        // 创建页码对象
        Page p = new Page();
        // 设置页码为传入的参数pageNumber
        p.setPageNumber(pageNumber);
        // 初始化 商品数量为0
        int totalCount = 0;
        try {
            // 调用商品持久层，输入的参数为关键字，获取搜索到的商品数量
            totalCount = gDao.getSearchCount(keyword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 根据获取到的数量，按照每页8个，计算页数和总页码
        p.SetPageSizeAndTotalCount(8, totalCount);
        // 创建List对象，初始化为null
        List list=null;
        try {
            // 调用商品持久层，获取到当前页的所有商品信息，传入到list中
            list = gDao.selectSearchGoods(keyword,pageNumber,8);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 将list存入到page对象中
        p.setList(list);
        // 返回page对象
        return p;
    }

    // 添加推荐业务
    public void addRecommend(int id,int type) {
        try {
            gDao.addRecommend(id, type);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 移除推荐业务
    public void removeRecommend(int id,int type) {
        try {
            gDao.removeRecommend(id, type);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 调用商品持久层，插入数据
    public void insert(Goods goods) {
        try {
            gDao.insert(goods);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 商品信息更新业务
    public void update(Goods goods) {
        try {
            gDao.update(goods);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 商品删除业务
    public void delete(int id) {
        try {
            gDao.delete(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
