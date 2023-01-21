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
        // 调用
        List<Map<String,Object>> ScrollGood=gService.getScrollGood();
        request.setAttribute("scroll",ScrollGood);

        List<Map<String,Object>>newList=gService.getGoodsList(3);
        request.setAttribute("newList",newList);

        List<Map<String,Object>>hotList=gService.getGoodsList(2);
        request.setAttribute("hotList",hotList);

        //response.sendRedirect("index.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }
}
