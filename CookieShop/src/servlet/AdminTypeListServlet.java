package servlet;

import model.Type;
import service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
// 后台类目管理控制层
@WebServlet(name = "admi_type_list",urlPatterns = "/admin/type_list")
public class AdminTypeListServlet extends HttpServlet {
    // 私有化类型业务层对象
    private TypeService tService = new TypeService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 调用类型业务层，获得所有类型的表
        List<Type> list= tService.GetAllType();
        // 在请求中写入list
        request.setAttribute("list", list);
        // 更新Servlet中的变量typeList
		this.getServletContext().removeAttribute("typeList");
        this.getServletContext().setAttribute("typeList",list);
        // 将请求转发到后台类目管理列表页
        request.getRequestDispatcher("/admin/type_list.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
