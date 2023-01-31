package servlet;

import model.Page;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 后台客户管理页控制层
@WebServlet(name = "admin_user_list",urlPatterns = "/admin/user_list")
public class AdminUserListServlet extends HttpServlet {
    // 私有化用户业务层对象
    private UserService uService = new UserService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 初始化页码为1
        int pageNumber = 1;
        // 获取请求中的pageNumber值
        if(request.getParameter("pageNumber") != null) {
            try {
                // 转换成int类型
                pageNumber=Integer.parseInt(request.getParameter("pageNumber") ) ;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        // 如果页码小于0，将页码修正为1
        if(pageNumber<=0)
            pageNumber=1;
        // 调用用户业务层，获取客户管理的page对象
        Page p = uService.getUserPage(pageNumber);
        // 如果计算页码为0
        if(p.getTotalPage()==0)
        {
            // 设置当前页为1，总页码为1
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            // 如果当前页码大于总页码，重新获取页码对象
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = uService.getUserPage(pageNumber);
            }
        }
        // 在请求中写入page对象
        request.setAttribute("p", p);
        // 将请求转发到后台用户列表页
        request.getRequestDispatcher("/admin/user_list.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
