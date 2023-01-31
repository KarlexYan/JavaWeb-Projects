package servlet;

import model.Page;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 后台商品管理控制层
@WebServlet(name = "admin_goods_list",urlPatterns = "/admin/goods_list")
public class AdminGoodsListServlet extends HttpServlet {
    // 私有化商品业务层对象
    private GoodsService gService = new GoodsService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type = 0;//推荐类型

        // 获取请求中的typeid
        if(request.getParameter("type") != null) {
            type=Integer.parseInt(request.getParameter("type") ) ;
        }
        // 初始化页码
        int pageNumber = 1;

        // 获取请求中的pageNumber值
        if(request.getParameter("pageNumber") != null) {
            try {
                pageNumber=Integer.parseInt(request.getParameter("pageNumber") ) ;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }

        // 如果页码小于0，将页码修正为1
        if(pageNumber<=0)
            pageNumber=1;

        // 调用商品业务层，获取热销商品页码对象
        Page p = gService.getGoodsRecommendPage(type, pageNumber);
        // 如果计算页码为0
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
                p = gService.getGoodsRecommendPage(type, pageNumber);
            }
        }
        // 在请求中写入page对象
        request.setAttribute("p", p);
        // 在请求中写入typeid
        request.setAttribute("type", type);
        // 将请求转发到后台商品管理页
        request.getRequestDispatcher("/admin/goods_list.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
