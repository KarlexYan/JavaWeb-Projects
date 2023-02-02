package servlet;

import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 后台商品推荐机制控制层 条幅 热销 新品
@WebServlet(name = "admin_goods_recommend",urlPatterns = "/admin/goods_recommend")
public class AdminGoodsRecommendServlet extends HttpServlet {
    // 私有化商品业务层
    private GoodsService gService = new GoodsService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取变量id的值即商品id
        int id = Integer.parseInt(request.getParameter("id"));
        // 从请求中获取变量method的值，即对商品的操作选项值
        String method = request.getParameter("method");
        // 从请求中获取变量typeTarget的值  1条幅 2热销 3新品
        int typeTarget=Integer.parseInt(request.getParameter("typeTarget"));
        // 根据获取到的操作值，调用对应的业务层
        if(method.equals("add")) {
            // 加入操作，调用商品业务层，将商品添加到推荐位
            gService.addRecommend(id, typeTarget);
        }else if(method.equals("remove")){
            // 移除操作，调用商品业务层，将商品从推荐位移除
            gService.removeRecommend(id, typeTarget);
        }
        // 将请求转发到AdminGoodsListServlet处理后更新后台商品管理页面数据
        request.getRequestDispatcher("/admin/goods_list").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
