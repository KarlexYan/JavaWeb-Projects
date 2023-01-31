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

// 后台用户修改页面的表单数据操作控制层
@WebServlet(name = "admin_user_edit",urlPatterns = "/admin/user_edit")
public class AdminUserEditServlet extends HttpServlet {
    // 私有化用户业务层对象
    private UserService uService = new UserService();
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建User对象
        User u = new User();
        try {
            // 使用工具类BeanUtils，将请求中获取到的修改后的变量Map依次存入User对象中
            BeanUtils.copyProperties(u, request.getParameterMap());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 调用用户业务层，执行用户信息更新
        uService.updateUserAddress(u);
        // 将请求转发到后台用户列表管理页面，更新页面
        request.getRequestDispatcher("/admin/user_list").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
