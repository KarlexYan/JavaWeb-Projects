package servlet;

import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

// 首页控制层
@WebServlet(name = "IndexServlet",urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    // 私有化变量
    private GoodsService gService=new GoodsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 调用商品业务层，获取轮播图列表
        List<Map<String,Object>> ScrollGood=gService.getScrollGood();
        // 在请求中将轮播图列表写入变量scroll
        request.setAttribute("scroll",ScrollGood);

        // 调用商品业务层，获取商品类别为2的商品列表
        List<Map<String,Object>>hotList=gService.getGoodsList(2);
        // 在请求中将商品列表写入变量hotList，作为首页的热销推荐展示
        request.setAttribute("hotList",hotList);

        // 调用商品业务层，获取商品类别为3的商品列表
        List<Map<String,Object>>newList=gService.getGoodsList(3);
        // 在请求中将商品列表写入变量newList，作为首页的新品推荐展示
        request.setAttribute("newList",newList);

        // 将请求转发到index.jsp，渲染主页的各种信息
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }
}
