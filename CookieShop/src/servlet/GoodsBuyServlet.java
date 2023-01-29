package servlet;

import model.Goods;
import model.Order;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 加入购物车控制层
@WebServlet(name = "goods_buy",urlPatterns = "/goods_buy")
public class GoodsBuyServlet extends HttpServlet {
    // 私有化商品业务层对象
    private GoodsService gService = new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建订单对象，初始化为null
        Order o = null;
        // 在session中查找order变量
        if(request.getSession().getAttribute("order") != null) {
            // 不为空,将获取到的变量order转换为order对象
            o = (Order) request.getSession().getAttribute("order");
        }else {
            // 为空，说明没有订单，创建订单对象，将order对象传入session中
            o = new Order();
            request.getSession().setAttribute("order", o);
        }
        // 将请求中的goodsid转换为int类型，传入变量goodsid中
        int goodsid = Integer.parseInt(request.getParameter("goodsid"));
        // 调用商品业务层，根据goodsid查找商品，获取到该商品对象信息
        Goods goods = gService.getGoodsById(goodsid);
        // 判断库存是否大于0
        if(goods.getStock()>0) {
            // 如果大于0，将商品添加到订单对象中，并响应ok
            o.addGoods(goods);
            response.getWriter().print("ok");
        }else {
            // 否则响应返回fail
            response.getWriter().print("fail");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
