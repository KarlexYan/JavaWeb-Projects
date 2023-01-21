package servlet;

import model.Goods;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 商品详情控制层
@WebServlet(name = "goods_detail",urlPatterns = "/goods_detail")
public class GoodsDetailServlet extends HttpServlet {
    // 私有化商品业务层变量
    private GoodsService gService = new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求中的变量id，将其从String转换为int类型
        int id = Integer.parseInt(request.getParameter("id"));
        // 调用商品业务层，使用id获取商品信息
        Goods g = gService.getGoodsById(id);
        // 在请求中设置g变量的值
        request.setAttribute("g", g);
        // 将请求转发到商品详情页
        request.getRequestDispatcher("/goods_detail.jsp").forward(request, response);
    }
}
