package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 个人中心修改密码控制层
@WebServlet(name = "user_changepwd",urlPatterns = "/user_changepwd")
public class UserChangePwdServlet extends HttpServlet {
    // 私有化变量
    private UserService uService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求中的变量
        String password = request.getParameter("password");
        String newPwd = request.getParameter("newPassword");
        // 从请求中获取user变量对象
        User u = (User) request.getSession().getAttribute("user");
        // 修改密码时需要先与原来密码进行比对，一致才可以进行密码的修改
        if(password.equals(u.getPassword())) {
            // 与原密码一致，修改用户的密码为newPwd里的值
            u.setPassword(newPwd);
            // 调用更新密码业务，返回的是更新的行数，大于0说明更新成功
            if(uService.updatePwd(u) > 0){
                // 设置请求中msg变量的值，并将请求转发到个人中心页面
                request.setAttribute("msg", "修改成功！");
                request.getRequestDispatcher("/user_center.jsp").forward(request, response);
            }else {
                // 如果返回0，说明没更新成功，提示错误，并将请求转发到个人中心页面
                request.setAttribute("failMsg", "未知错误！");
                request.getRequestDispatcher("/user_center.jsp").forward(request, response);
            }
        }else {
            // 输入的密码与原密码不一致，提示错误，并将请求转发到个人中心页面
            request.setAttribute("failMsg", "修改失败，原密码不正确，你再想想！");
            request.getRequestDispatcher("/user_center.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
