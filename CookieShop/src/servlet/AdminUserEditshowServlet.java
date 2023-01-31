package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// 后台点击用户修改跳转页面的数据显示控制层
@WebServlet(name = "admin_user_editshow",urlPatterns = "/admin/user_editshow")
public class AdminUserEditshowServlet extends HttpServlet {
    // 私有化用户业务层对象
    private UserService uService = new UserService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取到用户id，转换成int类型
        int id = Integer.parseInt(request.getParameter("id"));
        // 调用用户业务层，根据用户id获取到用户user对象
        User user = uService.selectById(id);
        // 在请求中将user对象写入
        request.setAttribute("u", user);
        // 将请求转发到后台用户修改页
        request.getRequestDispatcher("/admin/user_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
