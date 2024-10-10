<%-- 
    Document   : list
    Created on : Apr 22, 2022, 3:28:04 AM
    Author     : Ly Quynh Tran
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="includes/header.jsp" %>
<%@include file="includes/column_left_home.jsp" %>
<section id="main-contain" class="column">
    <h1>
        Student List
    </h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>DOB</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<student> myList = (List<student>) request.getAttribute("StudentList");
            for (student elem : myList) {
        %>
        <tr>
            <td><%=elem.getId()%></td>
            <td><%=elem.getName()%></td>
            <td>
                <input type="checkbox" <%= elem.getGender() == 1 ? "checked" : "" %>>
            </td>
            <td><%=elem.getDob()%></td>

            <!-- Cột chứa nút DELETE và UPDATE -->
            <td>
                <!-- Form for DELETE -->
                <form action="StudentServlet" method="POST" style="display:inline;">
                    <input type="hidden" name="COMMAND" value="DELETE">
                    <input type="hidden" name="studentId" value="<%=elem.getId()%>">
                    <button type="submit">DELETE</button>
                </form>

                <!-- Form for UPDATE -->
                <form action="StudentServlet" method="POST" style="display:inline;">
                    <input type="hidden" name="COMMAND" value="BEFORE_UPDATE">
                    <input type="hidden" name="studentId" value="<%=elem.getId()%>">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>

    </table>    
</section>
<%@include file="includes/column_right_news.jsp" %>
<%@include file="includes/footer.jsp" %>
