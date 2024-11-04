<%@ page import="model.Entity.Product" %>
<%@ page import="model.repository.impl.ProductRepositoryImpl" %><%--
    Document   : addGamePage
    Created on : Oct 26, 2024, 11:12:29 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="bootstrap-5.3.3-dist/css/bootstrap.css">
    <link rel="stylesheet" href="css/addGamePage.css">
</head>
<jsp:include page="includes/navBarPage.jsp" />
<body>
<form method="post" action="AddGame">
    <div id="addGamePage" class="container-s addGamePage">

        <div class="row">

            <div class="col-3 add-edit-game">

                <a class="add-game-button" type="submit" value="Add Game" style="color: rgb(109, 174, 21); cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/addGamePage.jsp" > Add Game</a>

                <a class="edit-game-button" type="submit" value="Edit Game" style="color: white; cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/searchGamePage.jsp"> Search Game</a>

            </div>

            <div class="col-8 add-game-table">
                <div class="game-infor">
                    <input class="game-information" type="submit" value="Game Information"  name="">
                </div>

                <div class="add-game-name">
                    <div class="game-name">Game's Name</div>
                    <input class="input-game-name" type="text" value="" name="game-name" placeholder="Game's Name">
                </div>


                <div class="add-game-img">
                    <div class="game-img" >Game's Image</div>

                    <div class="upload-box" id="uploadBox">
                        <input class="plus-button" id="mainPlusButton" style="width: 50px; height: 50px;">
                        <input type="file" id="mainFileInput" accept="image/*" name="file-img" multiple>
                        <img id="mainPreviewImage" class="game-img" src="#"  width="620px" height="380px%" />
                      </div>

                </div>

                <div class="add-game-description">
                    <div class="game-description">Game's Description</div>
                    <textarea class="input-game-description" name="game-description" placeholder="Game's Description"></textarea>
                </div>

                <div class="add-game-down-link">

                    <div class="game-down-link">Game's Download Link</div>
                    <input class="input-game-down-link" type="text" name="game-link" placeholder="Game's Download Link">

                </div>

                <div class="add-game-price">

                    <div class="game-price">Price Buy</div>
                    <input class="input-game-price" type="text" name="game-price" placeholder="Price">

                </div>

                <div class="confirm-add-game">
                    <input type="submit" value="Confirm">
                </div>


            </div>

        </div>

    </div>

    <script src="js/addGamePage.js"></script>
</form>
</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>
