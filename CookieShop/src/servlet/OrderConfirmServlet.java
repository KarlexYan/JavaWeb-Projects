package servlet;

import model.*;
import org.apache.commons.beanutils.BeanUtils;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

// 确认订单提交控制层
@WebServlet(name = "order_confirm",urlPatterns = "/order_confirm")
public class OrderConfirmServlet extends HttpServlet {
    private OrderService oService = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session中获取变量order 转换成Order对象
        Order o = (Order) request.getSession().getAttribute("order");
        try {
            // 使用工具类BeanUtils，将请求中获取到的变量Map依次存入Order对象中
            BeanUtils.copyProperties(o, request.getParameterMap());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 设置订单日期
        o.setDatetime(new Date());
        // 设置订单状态为已付款
        o.setStatus(Order.Paid);
        // 从session中获取变量user，转换成User，放进Order对象里
        o.setUser((User) request.getSession().getAttribute("user"));
        // 调用订单业务层，添加订单
        oService.addOrder(o);
        // 提交后，说明需要清空购物车，所以在请求中移除order变量
        request.getSession().removeAttribute("order");
        // 请求中写入msg，提示支付成功
        request.setAttribute("msg", "订单支付成功！");
        // 将请求转发到订单支付成功页
        request.getRequestDispatcher("/order_success.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
