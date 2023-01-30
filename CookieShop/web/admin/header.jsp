<%--
  Created by IntelliJ IDEA.
  User: 19767
  Date: 2018/11/30
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>

<%--管理后台的母版页头--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">蛋糕店后台</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <%--指向AdminOrderListServlet--%>
                <li><a href="/admin/order_list">订单管理</a></li>
                <%--指向AdminUserListServlet--%>
                <li><a href="/admin/user_list">客户管理</a></li>
                <%--指向AdminGoodsListServlet--%>
                <li><a href="/admin/goods_list">商品管理</a></li>
                <%--指向AdminTypeListServlet--%>
                <li><a href="/admin/type_list">类目管理</a></li>
                <%--指向UserLogoutServlet--%>
                <li><a href="/user_logout">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
