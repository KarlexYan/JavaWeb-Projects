package servlet;

import model.Type;
import service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 后台添加类目控制层
@WebServlet(name = "admin_type_add",urlPatterns = "/admin/type_add")
public class AdminTypeAddServlet extends HttpServlet {
    // 私有化业务层
    private TypeService tService = new TypeService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取到变量name的值，即要添加的类目名称
        String name = request.getParameter("name");
        // 调用业务层，新增类目数据
        tService.insert(new Type(name));
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
