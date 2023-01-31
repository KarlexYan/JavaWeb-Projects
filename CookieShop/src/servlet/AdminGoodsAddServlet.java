package servlet;

import model.Goods;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
// 后台添加商品控制层
@WebServlet(name = "admin_goods_add",urlPatterns = "/admin/goods_add")
public class AdminGoodsAddServlet extends HttpServlet {
    // 私有化商品业务层对象
    private GoodsService gService = new GoodsService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建FileItem对象的工厂，用于实现文件上传
        DiskFileItemFactory factory=new DiskFileItemFactory();
        // 创建Servlet上传工具对象，用于实现Servlet文件上传
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            // 解析出请求中form表单中的每个字段的数据，并将它们分别包装成独立的Fileltem对象
            List<FileItem> list = upload.parseRequest(request);
            // 创建商品对象
            Goods g = new Goods();
            // 遍历表单对象list，判断是否为普通字段
            for(FileItem item:list) {
                // 如果是普通字段
                if(item.isFormField()) {
                    // 获取普通字段及其对应的值，使用switch筛选关键字，设置Good商品对象的值
                    switch(item.getFieldName()) {
                        case "name":
                            g.setName(item.getString("utf-8"));
                            break;
                        case "price":
                            g.setPrice(Integer.parseInt(item.getString("utf-8")));
                            break;
                        case "intro":
                            g.setIntro(item.getString("utf-8"));
                            break;
                        case "stock":
                            g.setStock(Integer.parseInt(item.getString("utf-8")));
                            break;
                        case "typeid":
                            g.setTypeid(Integer.parseInt(item.getString("utf-8")));
                            break;
                    }
                }else {
                    // 如果不是普通字段，说明是文件，读取出来，保存到服务器端
                    // FileItem.getInputStream() 以流的形式返回上传文件的数据内容
                    // InputStream.available() 获取数据流里有多少个字节可以被读取
                    // 如果可以被获取的字节 <=0,跳过本次循环
                    if(item.getInputStream().available()<=0)continue;

                    // 获取文件名
                    String fileName = item.getName();
                    // 截取文件后缀名
                    fileName = fileName.substring(fileName.lastIndexOf("."));
                    // 修改文件名格式，以时间毫秒数命名，添加后缀名
                    fileName = "/"+new Date().getTime()+fileName;
                    // 创建保存路径，连接上文件名，组成一条完整的文件路径
                    String path = this.getServletContext().getRealPath("/picture")+fileName;
                    // 读取并保存到服务端路径
                    // 创建输入流和输出流，创建缓冲数组
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(path);
                    byte[] buffer = new byte[1024];
                    int len=0;
                    // 如果可以读取的字节大于0，写入到服务器路径中
                    while( (len=in.read(buffer))>0 ) {
                        out.write(buffer);
                    }

                    // 释放资源
                    in.close();
                    out.close();
                    item.delete();

                    // 使用switch筛选关键字，设置商品对象里的图片路径
                    switch(item.getFieldName()) {
                        case "cover":
                            g.setCover("/picture"+fileName);
                            break;
                        case "image1":
                            g.setImage1("/picture"+fileName);
                            break;
                        case "image2":
                            g.setImage2("/picture"+fileName);
                            break;
                    }
                }
            }
            // 调用商品业务层，添加商品
            gService.insert(g);
            // 执行完毕后，将请求转发到后台商品管理列表页
            request.getRequestDispatcher("/admin/goods_list").forward(request, response);
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
