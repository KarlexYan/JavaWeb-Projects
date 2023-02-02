package servlet;

import model.Type;
import org.apache.commons.beanutils.BeanUtils;
import service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 后台类目列表修改操作控制层
@WebServlet(name = "admin_type_edit",urlPatterns = "/admin/type_edit")
public class AdminTypeEditServlet extends HttpServlet {
    // 私有化业务层
    private TypeService tService = new TypeService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建Type对象
        Type t = new Type();
        try {
            // 使用工具类BeanUtils，将请求中获取到的变量Map依次存入Type对象中
            BeanUtils.copyProperties(t, request.getParameterMap());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 调用业务层，更新类型数据
        tService.update(t);
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
