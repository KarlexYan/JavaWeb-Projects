package servlet;

import model.Page;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 热销商品控制层
@WebServlet(name = "goodrecommendList",urlPatterns = "/goodsrecommend_list")
public class GoodRecommendListServlet extends HttpServlet {
    // 私有化商品业务层对象
    private GoodsService gService = new GoodsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取变量type的值，转换成int类型
        int type = Integer.parseInt(request.getParameter("type") ) ;
        // 初始化页码为1
        int pageNumber = 1;
        // 如果请求中获取变量pageNumber值不为空
        if(request.getParameter("pageNumber") != null) {
            try {
                // 将页码修改为请求中的页码
                pageNumber=Integer.parseInt(request.getParameter("pageNumber") ) ;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        // 如果页码小于1，将页码修正为1
        if(pageNumber<=0)
            pageNumber=1;
        // 调用商品业务层，获取热销商品页码对象
        Page p = gService.getGoodsRecommendPage(type, pageNumber);
        // 如果计算出来页码为0
        if(p.getTotalPage()==0)
        {
            // 设置当前页为1，总页码为1
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            // 如果当前页码大于总页码，重新获取页码对象
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = gService.getGoodsRecommendPage(type, p.getTotalPage());
            }
        }
        // 在请求中写入page对象和typeid
        request.setAttribute("p", p);
        request.setAttribute("t", type);
        // 将请求转发到热销商品页
        request.getRequestDispatcher("goodsrecommend_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
