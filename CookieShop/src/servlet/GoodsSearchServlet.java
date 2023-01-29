package servlet;

import service.GoodsService;
import model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

// 关键字搜索商品控制层
@WebServlet(name = "goods_search",urlPatterns = "/goods_search")
public class GoodsSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    // 私有化商品业务层对象
    private GoodsService gService = new GoodsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从前端发送的请求中获取到keyword变量的值，即搜索的关键字
        String keyword = request.getParameter("keyword");
        // 初始化页码为1
        int pageNumber = 1;
        // 如果获取到的pageNumber不为空
        if(request.getParameter("pageNumber") != null) {
            try {
                // 将前端获取到的pageNumber转换成int类型，赋给pageNumber
                pageNumber=Integer.parseInt(request.getParameter("pageNumber") ) ;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        // 如果pageNumber少于1，将页码修正为1
        if(pageNumber<=0)
        {
            pageNumber=1;
        }
        // 调用商品业务层业务，输入的参数为关键字和页码，获取到总商品数量和商品信息列表，返回到page对象
        Page p =gService.getSearchGoodsPage(keyword,pageNumber);

        // 如果page对象获取到的总页码为0
        if(p.getTotalPage()==0)
        {
            // 则设置总页码为1，当前页码为1
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        // 否则
        else {
            // 如果当前页码大于总页码
            if(pageNumber>=p.getTotalPage()+1)
            {
                // 调用商品业务层，重新获取page对象
                p =gService.getSearchGoodsPage(keyword,pageNumber);
            }
        }
        // 往请求中设置变量p,内容为page对象
        request.setAttribute("p", p);
        // 往请求中设置变量keyword，使用URLEncoder.encode()方法解决Tomcat发送HTTP请求中文参数乱码的问题
        request.setAttribute("keyword", URLEncoder.encode(keyword,"utf-8"));
        // 将请求转发到goods_search.jsp页面中
        request.getRequestDispatcher("/goods_search.jsp").forward(request, response);
    }

}
