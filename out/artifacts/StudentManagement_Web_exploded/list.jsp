
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="includes/header.jsp" %>

<jsp:useBean id="sList" class = "model.StudentDAO">
    <scope>session</scope>
</jsp:useBean>

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
            List<student> myList = sList.getStudents();
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
