package servlet;

import model.Goods;
import model.Page;
import model.Type;
import service.GoodsService;
import service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// 商品列表控制层
@WebServlet(name = "goods_List",urlPatterns = "/goods_list")
public class GoodsListServlet extends HttpServlet {
    // 私有化商品业务层和类别业务层对象
    private GoodsService gService=new GoodsService();
    private TypeService tService=new TypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 定义一个int类型存放从前端传来的typeid数值，初始值0
        int id=0;
        // 从请求中获取typeid的值，如果不等于null，说明点击的不是全部系列
        if(request.getParameter("typeid")!=null)
        {
            // 将string类型的typeid转换为int类型，并传入id变量
            id=Integer.parseInt(request.getParameter("typeid"));
        }
        // 定义一个int类型存放从前端传来的pageNumber数值，初始值1
        int pageNumber=1;
        // 从请求中获取pageNumber变量的值，如果不为null,
        if(request.getParameter("pageNumber")!=null) {
            try {
                // 将获取到的pageNumber转换为int类型
                pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        // 创建类型对象
        Type t=null;
        // 如果接收到的id不为0，调用类型业务层，根据typeid查找对应的类型对象
        if(id!=0)
        {
            // 得到type对象
            t=tService.selectTypeNameByID(id);
        }
        // 在请求中添加变量t，值为得到的type对象
        request.setAttribute("t",t);
        // 如果得到的pageNumber少于0，将其修正为1
        if(pageNumber<=0)
            pageNumber=1;
        // 调用商品业务层，根据对应的type和pageNumber获取到对应的商品对象
        Page p=gService.selectPageByTypeID(id,pageNumber);
        // 如果计算到的总页数为0
        if(p.getTotalPage()==0)
        {
            // 修改总共为1页
            p.setTotalPage(1);
            // 修改当前页码为1
            p.setPageNumber(1);
        }
        // 如果计算到总页数大于0
        else {
            // 如果当前页码大于总共页码+1
            if(pageNumber>=p.getTotalPage()+1)
            {
                // 重新获取，一直显示最后一页的内容
                p=gService.selectPageByTypeID(id,p.getTotalPage());
            }
        }
        // 在请求中存入变量p为，参数为当前页应该显示的内容
        request.setAttribute("p",p);
        // 将int类型的id转换为string类型，存入请求的变量id中
        request.setAttribute("id",String.valueOf(id));
        // 将请求内容转发到商品列表页中
        request.getRequestDispatcher("/goods_list.jsp").forward(request,response);
    }
}
