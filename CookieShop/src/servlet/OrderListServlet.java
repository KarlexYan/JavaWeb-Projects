package servlet;

import model.Order;
import model.User;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// 订单列表控制层
@WebServlet(name = "order_list", urlPatterns = "/order_list")
public class OrderListServlet extends HttpServlet {
    private OrderService oService = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 在session中获取user的值，转成User对象
        User u = (User) request.getSession().getAttribute("user");
        // 如果为空，说明未登录
        if(u==null)
        {
            // 跳转回首页
            response.sendRedirect("/index");
            return;
        }
        // 能运行到这里说明已经登录了
        // 调用订单业务层，根据用户id查询其订单所有信息，获取到信息列表
        List<Order> list = oService.selectAll(u.getId());
        // 在请求中添加变量orderList，参数为订单信息
        request.setAttribute("orderList", list);
        // 将请求转发到我的订单页
        request.getRequestDispatcher("/order_list.jsp").forward(request, response);
    }
}
