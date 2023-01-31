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

// 后台用户添加控制层
@WebServlet(name = "admin_user_add",urlPatterns = "/admin/user_add")
public class AdminUserAddServlet extends HttpServlet {
    // 私有化用户业务层
    private UserService uService = new UserService();
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建User对象
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
            request.setAttribute("msg", "客户添加成功！");
            // 将请求转发到后台用户列表管理页
            request.getRequestDispatcher("/admin/user_list").forward(request, response);
        }else {
            // 注册失败，提示错误，设置请求中msg变量的值，并将请求转发到用户注册页面
            request.setAttribute("failMsg", "用户名或邮箱重复，请重新填写！");
            // 在请求中将user的值写入变量u中，这样在跳转回添加页时不用再重新输入所有信息
            request.setAttribute("u",user);
            // 将请求转发到后台用户添加页
            request.getRequestDispatcher("/admin/user_add.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
