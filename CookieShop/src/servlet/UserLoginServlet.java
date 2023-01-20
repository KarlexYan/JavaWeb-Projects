package servlet;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/user_login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接受请求，接收参数 ue password
        String ue = request.getParameter("ue");
        String password = request.getParameter("password");

        // 调用业务层，通过返回的user对象是否为null来判断是否登录成功
        UserService userService = new UserService();
        User user = userService.login(ue, password);
        if(user!=null){
            request.setAttribute("user",user);
            request.getRequestDispatcher("user_center.jsp").forward(request,response);
        }else {
            request.setAttribute("failMsg","用户名、邮箱或密码错误，请重新登录！");
            request.getRequestDispatcher("user_login.jsp").forward(request,response);
        }
    }
}
