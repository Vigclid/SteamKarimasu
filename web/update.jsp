
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="includes/header.jsp" %>
<%@include file="includes/column_left_home.jsp" %>
<section id="main-contain" class="column">
    <h1>
        Update student with ID <%= request.getAttribute("StudentID")%>
    </h1>
    <form action = "StudentServlet" method="POST" accept-charset="UTF-8">
        <input style="display: none" value="<%=request.getAttribute("StudentID")%>" name="id">
        <table border="0">
            <tr>
                <td>Name: </td>
                <td> <input type="text" name="name" accept="UTF-8"></td>
            </tr>
            <tr>
                <td>Gender: </td>
                <td> <input type="radio" name="gender" value="male"> Male </td>
                <td> <input type="radio" name="gender" value="female"> Female </td>
            </tr>
            <tr>
                <td>DOB: </td>
                <td> <input type="date" name="DOB"></td>
            </tr>
            <tr>
                <td> <input type="submit" value="UPDATE" name="COMMAND"> </td>
            </tr>
        </table>
    </form>
</section>
<%@include file="includes/column_right_news.jsp" %>
<%@include file="includes/footer.jsp" %>
