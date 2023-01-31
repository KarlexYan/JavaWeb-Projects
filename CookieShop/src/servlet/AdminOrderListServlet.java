package servlet;

import model.Page;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 后台订单管理控制层
@WebServlet(name = "admin_order_list",urlPatterns = "/admin/order_list")
public class AdminOrderListServlet extends HttpServlet {
    // 私有化订单业务层对象
    private OrderService oService = new OrderService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 初始化status为0
        int status = 0;
        // 从请求中获取status，如果不为空，说明点击了 未付款/已付款/配送中/已完成 中的选项
        if(request.getParameter("status") != null) {
            // 获取请求中status的值，转换成int类型
            status=Integer.parseInt(request.getParameter("status") ) ;
        }
        // 在请求中设置status变量的当前值
        request.setAttribute("status", status);
        // 初始化页码为1
        int pageNumber = 1;
        // 获取请求中的pageNumber值
        if(request.getParameter("pageNumber") != null) {
            try {
                // 转换成int类型
                pageNumber=Integer.parseInt(request.getParameter("pageNumber") ) ;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if(pageNumber<=0)
            pageNumber=1;
        // 调用订单业务层，获取订单管理的page对象
        Page p = oService.getOrderPage(status,pageNumber);
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
                p = oService.getOrderPage(status,pageNumber);
            }
        }
        // 在请求中写入page对象
        request.setAttribute("p", p);
        // 将请求转发到后台订单列表页
        request.getRequestDispatcher("/admin/order_list.jsp").forward(request, response);
    }


}
