package servlet;

import service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 后台删除类目控制层
@WebServlet(name = "admin_type_delete",urlPatterns = "/admin/type_delete")
public class AdminTypeDeleteServlet extends HttpServlet {
    // 私有化业务层
    private TypeService tService = new TypeService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取变量id的值，即类型id
        int id = Integer.parseInt(request.getParameter("id"));
        // 调用业务层，删除该类型
        boolean isSuccess = tService.delete(id);
        // 删除成功，在变量写入成功提示
        if(isSuccess) {
            request.setAttribute("msg", "删除成功");
        }else {
            // 删除失败，提示错误
            request.setAttribute("failMsg", "类目下包含商品，无法直接删除类目！");
        }
        // 将请求转发到AdminTypeListServlet，更新后台管理页数据
        request.getRequestDispatcher("/admin/type_list").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
