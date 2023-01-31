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

// 后台用户重置密码控制层
@WebServlet(name = "admin_user_reset",urlPatterns = "/admin/user_reset")
public class AdminUserResetServlet extends HttpServlet {
    private UserService uService = new UserService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建User对象
        User u = new User();
        try {
            // 使用工具类BeanUtils，将请求中获取到的修改后的变量Map依次存入User对象中
            BeanUtils.copyProperties(u, request.getParameterMap());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 调用用户业务层，执行用户密码更新
        uService.updatePwd(u);
        // 将请求转发到后台用户列表管理页面，更新页面
        request.getRequestDispatcher("/admin/user_list").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
