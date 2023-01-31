package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 后台删除用户控制层
@WebServlet(name = "admin_user_delete",urlPatterns = "/admin/user_delete")
public class AdminUserDeleteServlet extends HttpServlet {
    // 私有化用户业务层对象
    private UserService uService = new UserService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 在请求中获取变量id的值，即用户id，转换成int类型
        int id = Integer.parseInt(request.getParameter("id"));
        // 调用用户业务层，删除用户，返回true说明删除成功，false则失败
        boolean isSuccess = uService.delete(id);
        // 删除成功
        if(isSuccess) {
            // 在请求中写入msg信息，提示删除成功
            request.setAttribute("msg", "客户删除成功");
        }else {
            // 删除失败，在请求中写入msg信息提示错误
            request.setAttribute("failMsg", "客户有下的订单，请先删除该客户下的订单，再来删除客户！");
        }
        // 将请求转发到AdminTypeListServlet处理后更新后台用户管理页
        request.getRequestDispatcher("/admin/user_list").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
