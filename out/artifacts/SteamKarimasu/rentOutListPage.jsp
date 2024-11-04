<%@ page import="repository.impl.ProductRepositoryImpl" %>
<%@ page import="model.Entity.product" %>
<%@ page import="repository.impl.ListRentRepositoryImpl" %>
<%@ page import="model.Entity.ListRent" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Entity.user" %>
<%@ page import="repository.impl.userRepositoryimpl" %><%--
    Document   : rentOutListPage
    Created on : Oct 30, 2024, 11:35:58 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/css/rentOutListPage.css">
</head>
<jsp:include page="includes/navBarPage.jsp" />
<body>
<div id="rentOutListPage" class="container-s rentOutListPage">

    <div class="row">

        <div class="col-3 add-edit-game" style="margin-left: 20px">

            <a class="add-game-button" type="submit" value="Add Game" style="color:white; cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/addGamePage.jsp"> Add Game</a>
            <a class="search-game-button" type="submit" value="Edit Game" style="color: white; cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/searchGamePage.jsp"> Search Game</a>
            <a class="edit-game-button" type="submit" value="Edit Game" style="color: rgb(109, 174, 21); cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href=""> Edit Game</a>

        </div>

        <div class="col-8 list-rent-game">
            <% int id = Integer.parseInt(request.getParameter("id"));
                product product = new ProductRepositoryImpl().findProductById(id);
                if (product != null) {

            %>

            <div class="rent-infor">
                <a href="${pageContext.request.contextPath}/editGamePage.jsp?id=<%=product.getProductId()%>" class="game-information">Game's Information</a>

                <a  class="rent-out-list">Rent Out List</a>
            </div>

            <div class="list-rent-game-table">
                <input type="hidden" name="id">

                <table>


                    <thead>

                    <tr>
                        <th>No</th>
                        <th>Accout Name</th>
                        <th>Mail</th>
                        <th>Phone Number</th>
                        <th>Remove</th>
                    </tr>

                    </thead>
                    <%
                        List<ListRent> rents = new ListRentRepositoryImpl().getListRent(product.getProductId());
                        for (ListRent rent : rents){
                            user user = new userRepositoryimpl().getUserByRentListId(rent.getListRentId());

                    %>
                    <tbody>

                    <tr>
                        <td><%=rent.getListRentId()%></td>
                        <td><%=user.getUsername()%></td>
                        <td><%=user.getEmail()%></td>
                        <td><%=user.getPhoneNumber()%></td>
                        <td>
                            <%--                                    <a href="${pageContext.request.contextPath}/Delete.jsp?id=<%=rent.getListRentId()%> " style="text-decoration-color: white;color: white">Delete--%>
                            <%--                                        <input type="hidden" value="<%=product.getProductId()%>">--%>
                            <%--                                        <input type="submit">--%>
                            <%--                                    </a>--%>
                            <form action="${pageContext.request.contextPath}/Delete.jsp" method="post" style="display: inline;">
                                <input type="hidden" name="rentId" value="<%= rent.getListRentId() %>">
                                <input type="hidden" name="productId" value="<%= product.getProductId() %>">
                                <button type="submit" style="background: none; border: none; color: white; text-decoration: underline; cursor: pointer;">
                                    Delete
                                </button>
                            </form>
                        </td>
                        <%--                                <td><input class="delete-list" id="" type="submit" value="Delete"></td>--%>
                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>

                </table>


            </div>


        </div>

    </div>

</div>





</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>