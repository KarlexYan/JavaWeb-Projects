package servlet;

import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 购物车减少商品数量控制层
@WebServlet(name = "goods_lessen",urlPatterns = "/goods_lessen")
public class GoodsLessenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session查找order变量，将获取到的对象转化为Order对象
        Order o = (Order) request.getSession().getAttribute("order");
        // 将请求中的goodsid转换为int类型，传入变量goodsid中
        int goodsid = Integer.parseInt(request.getParameter("goodsid"));
        // 根据goodsid在订单中减少该商品的数量，如果为0，则移除该商品
        o.lessen(goodsid);
        // 响应ok
        response.getWriter().print("ok");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
