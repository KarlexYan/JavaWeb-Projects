package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 订单提交控制层
@WebServlet(name = "order_submit",urlPatterns = "/order_submit")
public class OrderSubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session获取user变量
        if(request.getSession().getAttribute("user")!=null) {
            // 如果不为空，说明已登录，将请求转发到订单信息提交页
            request.getRequestDispatcher("/order_submit.jsp").forward(request, response);
        }else {
            // 如果为空，提示需要登录后再提交
            request.setAttribute("failMsg", "请登录后，再提交订单！");
            // 将请求转发到用户登录页
            request.getRequestDispatcher("/user_login.jsp").forward(request, response);
        }
    }
}
