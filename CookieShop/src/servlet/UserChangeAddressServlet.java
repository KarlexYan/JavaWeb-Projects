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

// 个人中心修改收货信息控制层
@WebServlet(name = "user_changeaddress",urlPatterns = "/user_changeaddress")
public class UserChangeAddressServlet extends HttpServlet {
    // 私有化变量
    private UserService uService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 在session中获取现有的user变量的值
        User loginUser = (User) request.getSession().getAttribute("user");

        try {
            // 使用工具类BeanUtils，将请求中获取到的修改后的变量Map依次存入loginUser对象中
            BeanUtils.copyProperties(loginUser, request.getParameterMap());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 调用更新用户收货地址业务，返回的是更新的行数，大于0说明更新成功
        if(uService.updateUserAddress(loginUser) > 0){
            // 设置请求中msg变量的值，并将请求转发到个人中心页面
            request.setAttribute("msg", "收件信息更新成功！");
            request.getRequestDispatcher("/user_center.jsp").forward(request, response);
        }else {
            // 如果返回0，说明没更新成功，提示错误，并将请求转发到页面
            request.setAttribute("failMsg", "未知错误！");
            request.getRequestDispatcher("/user_center.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
