package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 用户登录控制层
@WebServlet(name = "user_login",urlPatterns = "/user_login")
public class UserLoginServlet extends HttpServlet {
    // 私有化变量
    private UserService uService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求中的变量ue和password
        String ue = request.getParameter("ue");
        String password = request.getParameter("password");

        // 调用用户注册业务
        User user = uService.login(ue, password);
        // 如果获取到的user对象为null，说明查找不到用户，登录失败
        if(user==null) {
            // 登录失败，提示错误，设置请求中msg变量的值，并将请求转发到用户登录页面
            request.setAttribute("failMsg", "用户名、邮箱或者密码错误，请重新登录！");
            request.getRequestDispatcher("/user_login.jsp").forward(request, response);
        }else {
            // 登录成功，设置请求中user变量的值，并将请求转发到个人中心页
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/user_center.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
