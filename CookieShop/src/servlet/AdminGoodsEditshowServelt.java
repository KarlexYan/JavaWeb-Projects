package servlet;

import model.Goods;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// 后台点击商品修改跳转页面的数据显示控制层
@WebServlet(name = "admin_goods_editshow",urlPatterns = "/admin/goods_editshow")
public class AdminGoodsEditshowServelt extends HttpServlet {
    // 私有化商品业务层
    private GoodsService gService = new GoodsService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取变量id的值，即商品id
        int id = Integer.parseInt(request.getParameter("id"));
        // 调用商品业务层，根据id获取对应的商品对象
        Goods g = gService.getGoodsById(id);
        // 将商品对象写入到请求中
        request.setAttribute("g", g);
        // 将请求转发到后台商品编辑页
        request.getRequestDispatcher("/admin/goods_edit.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
