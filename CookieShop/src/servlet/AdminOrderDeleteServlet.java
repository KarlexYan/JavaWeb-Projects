package servlet;

import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 后台订单删除操作控制层
@WebServlet(name = "admin_order_delete",urlPatterns = "/admin/order_delete")
public class AdminOrderDeleteServlet extends HttpServlet {
    // 私有化订单业务层对象
    private OrderService oService = new OrderService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取变量id的值，即订单id，将其转换为int类型
        int id = Integer.parseInt(request.getParameter("id"));
        // 调用订单业务层，执行订单删除操作
        oService.delete(id);
        // 将页面转发到AdminOrderListServlet处理后 更新后台订单管理页
        request.getRequestDispatcher("/admin/order_list").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
