<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.repository.impl.ListRentRepositoryImpl" %><%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 4/11/2024
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("rentId"));
    int idProduct = Integer.parseInt(request.getParameter("productId"));
    ListRentRepositoryImpl listRentRepository = new ListRentRepositoryImpl();
    listRentRepository.deleteByListRentId(id);
    PrintWriter printWriter = response.getWriter();
//    request.getRequestDispatcher("rentOutListPage.jsp?id=" +idProduct);
    printWriter.println("<script type=\"text/javascript\">");
    printWriter.println("location='rentOutListPage.jsp?id=" + idProduct + "';");
    printWriter.println("</script>");
//    response.sendRedirect("rentOutListPage.jsp?id=" + idProduct);

%>
</body>
</html>
