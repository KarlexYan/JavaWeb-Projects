package servlet;

import model.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
// 用户注册控制层
@WebServlet(name = "user_register",urlPatterns = "/user_rigister")
public class UserRegisterServlet extends HttpServlet {
    // 私有化变量
    private UserService uService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            // 使用工具类BeanUtils，将请求中获取到的变量Map依次存入user对象中
            BeanUtils.copyProperties(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 调用用户注册业务，如果返回的true，说明注册成功，false则是失败
        if(uService.register(user)) {
            // 注册成功，设置请求中msg变量的值，并将请求转发到用户登录页面，前后页面共享一个request
            // RequestDispatcher.forward()方法仅是容器中控制权的转向，在客户端浏览器地址栏中不会显示出转向后的地址。
            request.setAttribute("msg", "注册成功，请登录！");
            request.getRequestDispatcher("user_login.jsp").forward(request, response);
        }else {
            // 注册失败，提示错误，设置请求中msg变量的值，并将请求转发到用户注册页面
            request.setAttribute("msg", "用户名或邮箱重复，请重新填写！");
            request.getRequestDispatcher("user_register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
