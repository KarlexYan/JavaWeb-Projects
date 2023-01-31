package dao;

import model.Goods;
import model.Recommend;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.*;

// 商品持久层，负责商品相关的数据库操作
public class GoodsDao {
    // 私有化QueryRunner对象，简化SQL查询
    QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

    // 获取输入参数对应类别的商品列表
    //select g.id,g.name,g.cover,g.price,t.name typename from recommend r,goods g,type t where type=2 and r.goods_id=g.id and g.type_id=t.id
    public List<Map<String,Object>> getGoodsList(int recommendType) throws SQLException {
        // 定义sql语句
        String sql="select g.id,g.name,g.cover,g.price,t.name typename from recommend r,goods g,type t " +
                "where type=? and r.goods_id=g.id and g.type_id=t.id";
        // 执行语句，获取到商品列表
        List<Map<String, Object>> query = qr.query(sql, new MapListHandler(), recommendType);
        // 返回得到的商品的列表
        return query;
    }

    // 获取轮播图
    public List<Map<String,Object>> getScrollGood()throws SQLException{
        // 定义sql语句
        String sql = "select g.id,g.name,g.cover,g.price from recommend r,goods g where r.goods_id=g.id group by id";
        // 执行语句，获取到轮播图列表
        List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
        // 返回轮播图列表
        return query;
    }

    // 获取指定typeid下指定pageNumber的商品列表对象
    public List<Goods> selectGoodsByTypeID(int typeID,int pageNumber,int pageSize) throws SQLException {
        // typeID==0即为全部系列，获取 指定页码 下的 指定数量 商品对象列表
        if(typeID==0)
        {
            // 定义sql语句 搜索从指定序号开始截取指定个数
            String sql="select * from goods limit ? , ?";
            // 获取商品对象列表  例如当前页码第5页，一页显示数量8个，参数即为 (5-1)*8,8  从第32个开始截取8个
            List<Goods> query = qr.query(sql, new BeanListHandler<Goods>(Goods.class), (pageNumber - 1) * pageSize, pageSize);
            // 返回列表
            return query;
        }
        // typeID不为0即为指定系列
        else
        {
            // 定义sql语句
            String sql="select * from goods where type_id=? limit ? , ?";
            // 获取指定类型商品对象列表
            List<Goods> query = qr.query(sql, new BeanListHandler<Goods>(Goods.class), typeID, (pageNumber - 1) * pageSize, pageSize);
            return query;
        }
    }

    // 获取指定typeid下所有商品数量
    public int getCountOfGoodsByTypeID(int typeID) throws SQLException {
        String sql="";
        // typeID==0即为全部系列，统计所有系列的所有商品数量
        if(typeID==0)
        {
            // 定义sql语句
            sql="select count(*) from goods";
            // 执行，获取到所有商品数量
            int i = qr.query(sql, new ScalarHandler<Long>()).intValue();
            // 返回数量
            return i;
        }
        // typeID不为0即为指定系列，统计该系列所有商品数量
        else
        {
            // 定义sql语句
            sql="select count(*) from goods where type_id=?";
            // 执行，获取到对应系列的所有商品数量
            int i = qr.query(sql, new ScalarHandler<Long>(), typeID).intValue();
            return i;
        }
    }
    // 获取指定typeid下指定pageNumber的热销商品列表对象
    public List<Goods> selectGoodsbyRecommend(int type,int pageNumber,int pageSize) throws SQLException {
        if(type==0) {
            // 当不添加推荐类型限制的时候
            // 定义sql语句
            String sql = " select g.id,g.name,g.cover,g.image1,g.image2,g.intro,g.price,g.stock,t.name typename " +
                    "from goods g,type t " +
                    "where g.type_id=t.id " +
                    "order by g.id " +
                    "limit ?,?";
            // 执行语句，得到列表，返回列表
            List<Goods> query = qr.query(sql, new BeanListHandler<Goods>(Goods.class), (pageNumber - 1) * pageSize, pageSize);
            return query;

        }
        // 定义sql语句
        String sql = " select g.id,g.name,g.cover,g.image1,g.image2,g.intro,g.price,g.stock,t.name typename " +
                "from goods g,recommend r,type t " +
                "where g.id=r.goods_id and g.type_id=t.id and r.type=? " +
                "order by g.id " +
                "limit ?,?";
        // 执行语句，得到列表，返回列表
        List<Goods> query = qr.query(sql, new BeanListHandler<Goods>(Goods.class), type, (pageNumber - 1) * pageSize, pageSize);
        return query;
    }
    // 获取所有热销商品数量
    public int getRecommendCountOfGoodsByTypeID(int type) throws SQLException {
        // 当不添加推荐类型限制的时候，获取所有系列商品数量
        if(type==0)return getCountOfGoodsByTypeID(0);

        // 定义sql语句
        String sql = "select count(*) from recommend where type=?";
        // 执行语句，返回总数量
        int i = qr.query(sql, new ScalarHandler<Long>(), type).intValue();
        return i;
    }

    // 通过id获取商品信息
    // select g.id,g.name,g.cover,g.image1,g.image2,g.price,g.intro,g.stock,t.id typeid,t.name typename from goods g,type t where g.id = 9 and g.type_id=t.id
    public Goods getGoodsById(int id) throws SQLException {
        // 编写sql语句
        String sql = "select g.id,g.name,g.cover,g.image1,g.image2,g.price,g.intro,g.stock,t.id typeid,t.name typename " +
                "from goods g,type t " +
                "where g.id = ? and g.type_id=t.id";
        // 执行语句，获取到对应的商品对象
        Goods query = qr.query(sql, new BeanHandler<Goods>(Goods.class), id);
        // 返回商品对象
        return query;
    }
    // 通过关键字搜索获取总共的商品数量
    public int getSearchCount(String keyword) throws SQLException {
        // 定义sql语句，搜索到对应关键字的商品数量
        String sql = "select count(*) from goods where name like ?";
        // 执行语句，使用ScalarHandler获取聚合函数的值，将其转换为int类型，
        int i = qr.query(sql, new ScalarHandler<Long>(), "%" + keyword + "%").intValue();
        // 返回查找到的数量
        return i;
    }
    // 通过关键字、页码、单页商品总数量获取商品信息列表
    public List<Goods> selectSearchGoods(String keyword, int pageNumber, int pageSize) throws SQLException{
        // 定义sql语句，获取商品信息的信息
        String sql = "select * from goods where name like ? limit ?,?";
        // 执行语句，获取到商品信息列表
        List<Goods> query = qr.query(sql, new BeanListHandler<Goods>(Goods.class), "%" + keyword + "%", (pageNumber - 1) * pageSize, pageSize);
        // 返回列表
        return query;
    }
    // 判断是否为横幅商品
    public boolean isScroll(Goods g) throws SQLException {
        return isRecommend(g, Recommend.BANNERS);
    }
    // 判断是否为热销商品
    public boolean isHot(Goods g) throws SQLException {
        return isRecommend(g, Recommend.HOTSALE);
    }
    // 判断是否为新品
    public boolean isNew(Goods g) throws SQLException {
        return isRecommend(g, Recommend.NEWPRODUCTS);
    }

    // 判断是否为推荐商品
    private boolean isRecommend(Goods g,int type) throws SQLException {
        // 定义语句
        String sql = "select * from recommend where type=? and goods_id=?";
        // 执行语句，获取到Recommend对象
        Recommend recommend = qr.query(sql, new BeanHandler<Recommend>(Recommend.class),type,g.getId());
        // 如果为null，则不是推荐商品
        if(recommend==null) {
            return false;
        }else {
            // 否则为推荐商品
            return true;
        }
    }
    public void addRecommend(int id,int type) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into recommend(type,goods_id) values(?,?)";
        r.update(sql,type,id);
    }
    public void removeRecommend(int id,int type) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from recommend where type=? and goods_id=?";
        r.update(sql,type,id);
    }

    // 插入数据到商品表
    public void insert(Goods g) throws SQLException {
        // 定义sql语句，
        String sql = "insert into goods(name,cover,image1,image2,price,intro,stock,type_id) values(?,?,?,?,?,?,?,?)";
        // 执行语句
        qr.update(sql,g.getName(),g.getCover(),g.getImage1(),g.getImage2(),g.getPrice(),g.getIntro(),g.getStock(),g.getType().getId());
    }

    // 修改商品信息
    public void update(Goods g) throws SQLException {
        // 定义sql语句
        String sql = "update goods set name=?,cover=?,image1=?,image2=?,price=?,intro=?,stock=?,type_id=? where id=?";
        // 执行语句
        qr.update(sql,g.getName(),g.getCover(),g.getImage1(),g.getImage2(),g.getPrice(),g.getIntro(),g.getStock(),g.getType().getId(),g.getId());
    }

    // 根据id删除对应商品
    public void delete(int id) throws SQLException {
        // 定义sql语句
        String sql = "delete from goods where id = ?";
        // 执行语句
        qr.update(sql,id);
    }
}
