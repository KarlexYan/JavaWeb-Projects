package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 用户拦截器 判断当前用户是否为管理员，如果不是管理员跳转回首页，防止非管理用户进入后台控制
@WebFilter(filterName = "AdminFilter",urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse requestp = (HttpServletResponse)resp;
        // 从session获取变量user的值
        User u = (User) request.getSession().getAttribute("user");
        // 如果用户未登录 或 非管理用户
        if(u==null || u.isIsadmin()==false) {
            // 跳转回首页
            requestp.sendRedirect("../index.jsp");
        }else {
            // 放行
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
