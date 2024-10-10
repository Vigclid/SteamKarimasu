
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="includes/header.jsp" %>
<%@include file="includes/column_left_home.jsp" %>
<section id="main-contain" class="column">
    <h1>
        SEARCH STUDENT
    </h1>
    <h2>
        INPUT WHAT YOU KNOW (NO FULL INFORMATION NEEDED)
    </h2>
    <form action = "StudentServlet" method="POST">
        <table border="0">
            <tr >
                <td>StudentID: </td>
                <td> <input type="text" name="ID"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td> <input type="text" name="name"></td>
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
                <td> <input type="submit" value="SEARCH" name="COMMAND"> </td>
            </tr>
        </table>
    </form>
</section>
<%@include file="includes/column_right_news.jsp" %>
<%@include file="includes/footer.jsp" %>
