package servlet;

import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 后台订单状态修改操作控制层
@WebServlet(name = "admin_order_status",urlPatterns = "/admin/order_status")
public class AdminOrderStatusServlet extends HttpServlet {
    // 私有化订单业务层
    private OrderService oService = new OrderService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取到变量id和status，分别为订单id和订单状态，将其转换为int类型
        int id = Integer.parseInt(request.getParameter("id"));
        int status = Integer.parseInt(request.getParameter("status"));
        // 调用订单业务层，更新订单状态
        oService.updateStatus(id, status);
        // 页面跳转，经由OrderListServlet处理后重新将更新后的数据转发到后台管理订单页
        response.sendRedirect("/admin/order_list?status="+status);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
