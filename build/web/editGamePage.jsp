<%@ page import="model.Entity.Product" %>
<%@ page import="model.repository.impl.ProductRepositoryImpl" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Game Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="css/editGamePage.css">
</head>

<jsp:include page="includes/navBarPage.jsp" />
<body>
<div id="editGamePage" class="container-s editGamePage">
    <div class="row">
        <div class="col-3 add-edit-game" style="margin-left: 20px">
            <a class="add-game-button" type="submit" value="Add Game" style="color:white; cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/addGamePage.jsp"> Add Game</a>
            <a class="search-game-button" type="submit" value="Edit Game" style="color: white; cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/searchGamePage.jsp"> Search Game</a>
            <a class="edit-game-button" type="submit" value="Edit Game" style="color: rgb(109, 174, 21); cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/editGamePage.jsp"> Edit Game</a>
        </div>

        <%
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = new ProductRepositoryImpl().findProductById(id);
            if (product == null) {
                response.sendRedirect("searchGamePage.jsp");
                return;
            } else {
        %>
        <form method="post" action="EditGame">
        <div class="col-8 edit-game-table">
            <div class="rent-infor">
                <input class="game-information" type="button" value="Game Information" id="" name="">
                <input class="rent-out-list" type="button" value="Rent Out List" id="" name="">
            </div>
                <input type="hidden" name="id" value="<%= product.getProductId() %>">
                <div class="edit-game-name">
                    <div class="game-name">Game's Name</div>
                    <input class="input-game-name" type="text" value="<%= product.getProductName() %>" name="game-name" placeholder="Game's Name" required>
                </div>

                <div class="edit-game-img">
                    <div class="game-img">Game's Image</div>
                    <div class="upload-box" id="uploadBox">
                        <img id="mainPreviewImage" class="preview" src="<%= product.getProductImage() %>" alt="Preview" style="display: <%= product.getProductImage() == null ? "none" : "block" %>;"/>
                        <input type="file" id="mainFileInput" accept="image/*" style="display: none;" name="game-img" >
<%--                        <label for="mainFileInput">Choose Image</label>--%>
                    </div>
                </div>

                <div class="edit-game-description">
                    <div class="game-description">Game's Description</div>
                    <textarea class="input-game-description" name="game-description" placeholder="Game's Description" required><%= product.getDescription() %></textarea>
                </div>

                <div class="edit-game-down-link">
                    <div class="game-down-link">Game's Download Link</div>
                    <input class="input-game-down-link" type="text" value="<%= product.getLinkKeyGame() %>" name="game-link" placeholder="Game's Download Link" required>
                </div>

                <div class="edit-game-price">
                    <div class="game-price">Price Buy</div>
                    <input class="input-game-price" type="text" value="<%= product.getPrice() %>" name="game-price" placeholder="Price" required>
                </div>

            <div class="confirm-edit-game">
                <form method="post" action="EditGame" style="display: inline;">
                    <input type="hidden" name="action" value="EDIT">
                    <input type="hidden" name="productId" value="<%= product.getProductId() %>">
                    <button type="submit" value="Confirm" class="confirm-edit">Confirm</button>
                </form>

                <form method="post" action="EditGame" style="display: inline;">
                    <input type="hidden" name="action" value="DELETE">
                    <input type="hidden" name="productId" value="<%= product.getProductId() %>">
                    <button type="submit" value="Delete" class="delete-edit">Delete</button>
                </form>
            </div>

            <% } %>
        </div>
        </form>
    </div>
</div>


    
<script src="js/editGamePage.js"></script>    
</body>
<jsp:include page="includes/mainFooterPage.jsp" />

</html>
