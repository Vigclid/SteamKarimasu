<%@ page import="model.Entity.Product" %>
<%@ page import="model.repository.impl.ProductRepositoryImpl" %><%--
    Document   : editGamePage
    Created on : Oct 30, 2024, 10:11:50 PM
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
    <link rel="stylesheet" href="css/editGamePage.css">
</head>

<jsp:include page="includes/navBarPage.jsp" />
<body>
    <div id="editGamePage" class="container-s editGamePage">

        <div class="row">

            <div class="col-3 add-edit-game">

                <a class="add-game-button" type="submit" value="Add Game" style="color:white ; cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/addGamePage.jsp" > Add Game</a>

                <a class="search-game-button" type="submit" value="Edit Game" style="color: white; cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/searchGamePage.jsp"> Search Game</a>

                <a class="edit-game-button" type="submit" value="Edit Game" style="color: rgb(109, 174, 21); cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/searchGamePage.jsp"> Search Game</a>


            </div>

            <%
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = new ProductRepositoryImpl().findProductById(id);
                if (product == null) {
                    response.sendRedirect("searchGamePage.jsp");
                    return;
                } else {
            %>


            <div class="col-8 edit-game-table">

                <div class="rent-infor">
                    <input class="game-information" type="submit" value="Game Information" id="" name="">

                    <input class="rent-out-list" type="submit" value="Rent Out List" id="" name="">
                </div>
                <input type="hidden" name="id" value="<%= product.getProductId() %>">
                <div class="edit-game-name">
                    <div class="game-name">Game's Name</div>
                    <input class="input-game-name" type="text" value="<%= product.getProductName() %>"  name="" placeholder="Game's Name">
                </div>


                <div class="edit-game-img">
                    <div class="game-img">Game's Image</div>

                    <div class="upload-box" id="uploadBox">
                        <img id="mainPreviewImage" class="preview" src="#" alt="Preview"/>
                        <input type="file" id="mainFileInput" accept="image/*" style="display: none;">
                      </div>
                      
                      <div class="thumbnail-container" id="thumbnailContainer">
                          
                      </div>

                </div>

                <div class="edit-game-description">
                    <div class="game-description">Game's Description</div>
                    <textarea class="input-game-description" name="" id="" placeholder="Game's Description"></textarea>
                </div>

                <div class="edit-game-down-link">

                    <div class="game-down-link">Game's Download Link</div>
                    <input class="input-game-down-link" type="text" value="" id="" name="" placeholder="Game's Download Link">

                </div>

                <div class="edit-game-price">

                    <div class="game-price">Price Buy</div>
                    <input class="input-game-price" type="text" value="" id="" name="" placeholder="Price">

                </div>


                <div class="confirm-edit-game">
                    <input type="submit" value="Confirm" class="confirm-edit" name="" value="">

                    <input type="submit" value="Delete" class="delete-edit" name="" value="">
                </div>
                <%}%>
            </div>

        </div>

    </div>


<script id="imageData" type="application/json">
  {
    "mainImage": "assets/img/god-of-war.png",
    "thumbnails": [
      "assets/img/god-of-war.png",
      "assets/img/god-of-war.png",
      "assets/img/god-of-war.png"
    ]
  }
</script>
    
<script src="js/editGamePage.js"></script>    
</body>
<jsp:include page="includes/mainFooterPage.jsp" />

</html>
