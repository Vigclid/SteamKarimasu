<%@ page import="model.Entity.product" %><%--
    Document   : gamePage.jsp
    Created on : Oct 23, 2024, 11:49:31 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
    </script>

    <link rel="stylesheet" href="styles/css/gamePage.css">

</head>

<jsp:include page="includes/navBarPage.jsp" />
<body>
<!-- navBar -->

<div class="container game" id="game">
    <%
        product product = (product) request.getAttribute("profile_product");
    %>
    <div class="row game-title">
        <%= product.getProductName() %>
    </div>

    <div class="row advertisement">
        <a href="">
            <img src="assets/img/Banner_ads.png" alt="">
        </a>
    </div>

    <div class="row body-game-page">

        <div class="col-7 game-img">

            <div class="gallery">

                <div class="main-image" id="mainImage">
                    <img src="<%= request.getContextPath() + "/" + product.getProductImage().replace("C:\\Users\\Admin\\Documents\\Github\\SteamKarimasu\\web\\", "") %>" alt="Main Image">
                </div>

                <div class="thumbnail-container">

                    <!-- <div id="thumbnail" class="thumbnail" onclick="changeImage('assets/img/black-myth-wukong.png')">
                        <img src="assets/img/black-myth-wukong.png" alt="Thumbnail 1">
                    </div>

                    <div id="thumbnail" class="thumbnail"
                        onclick="changeImage('assets/img_game_page/Black_myth_img1.jpg')">
                        <img src="assets/img_game_page/Black_myth_img1.jpg" alt="Thumbnail 2">
                    </div>

                    <div id="thumbnail" class="thumbnail"
                        onclick="changeImage('assets/img_game_page/Black_myth_img2.jpg')">
                        <img src="assets/img_game_page/Black_myth_img2.jpg" alt="Thumbnail 3">
                    </div>

                    <div id="thumbnail" class="thumbnail"
                        onclick="changeImage('assets/img_game_page/Black_myth_img3.jpg')">
                        <img src="assets/img_game_page/Black_myth_img3.jpg" alt="Thumbnail 4">
                    </div> -->

                    <table>
                        <tr class="thumbnail-img">
                            <td id="thumbnail" class="thumbnail"
                                onclick="changeImage('https://assets.nintendo.com/image/upload/ar_16:9,c_lpad,w_1240/b_white/f_auto/q_auto/ncom/software/switch/70070000016597/0a33bcaba879403460afe2ff2aafaaefeede964e0fc11a430f71077867cc87f1')">
                                <img src="https://assets.nintendo.com/image/upload/ar_16:9,c_lpad,w_1240/b_white/f_auto/q_auto/ncom/software/switch/70070000016597/0a33bcaba879403460afe2ff2aafaaefeede964e0fc11a430f71077867cc87f1" alt="Thumbnail 2">
                            </td>
                            <td id="thumbnail" class="thumbnail"
                                onclick="changeImage('https://hoanghamobile.com/tin-tuc/wp-content/uploads/2024/05/cach-choi-minecraft-thumb.jpg')">
                                <img src="https://hoanghamobile.com/tin-tuc/wp-content/uploads/2024/05/cach-choi-minecraft-thumb.jpg" alt="Thumbnail 2">
                            </td>
                            <td id="thumbnail" class="thumbnail"
                                onclick="changeImage('https://cdn1.epicgames.com/offer/24b9b5e323bc40eea252a10cdd3b2f10/EGS_LeagueofLegends_RiotGames_S1_2560x1440-80471666c140f790f28dff68d72c384b')">
                                <img src="https://cdn1.epicgames.com/offer/24b9b5e323bc40eea252a10cdd3b2f10/EGS_LeagueofLegends_RiotGames_S1_2560x1440-80471666c140f790f28dff68d72c384b" alt="Thumbnail 2">
                            </td>
                            <td id="thumbnail" class="thumbnail"
                                onclick="changeImage('https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/911400/capsule_616x353.jpg?t=1692034844g')">
                                <img src="https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/911400/capsule_616x353.jpg?t=1692034844" alt="Thumbnail 2">
                            </td>
                            <td id="thumbnail" class="thumbnail"
                                onclick="changeImage('https://i.ytimg.com/vi/FUzJJB8wLvQ/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLCDhmAVZuX9V3ycuvqUdThCCDPwKA')">
                                <img src="https://i.ytimg.com/vi/FUzJJB8wLvQ/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLCDhmAVZuX9V3ycuvqUdThCCDPwKA" alt="Thumbnail 2">
                            </td>
                            <td id="thumbnail" class="thumbnail"
                                onclick="changeImage('https://i.ytimg.com/vi/nx_e9TH-pDY/maxresdefault.jpg')">
                                <img src="https://i.ytimg.com/vi/nx_e9TH-pDY/maxresdefault.jpg" alt="Thumbnail 2">
                            </td>

                        </tr>
                    </table>

                </div>
            </div>

        </div>

        <div class="col-5 game-about">

            <div class="row about-img">
                <img src="<%= request.getContextPath() + "/" + product.getProductImage().replace("C:\\Users\\Admin\\Documents\\Github\\SteamKarimasu\\web\\", "") %>" alt="">
            </div>

            <div class="row about-content">
                <p><%= product.getProdcuctDescription() %></p>
            </div>


            <div class="row buy-game">
                <div class="buy-card">

                    <div class="buy-card-title">Buy <%= product.getProductName() %></div>

                    <div class="more-infor-buy">
                        <%
                            if (product.getPrice() > 0) {
                        %>
                        <div class="buy-price">
                            $<%= product.getPrice() %>
                        </div>
                        <%
                            } else {
                        %>
                        <div class="buy-price">
                            Free
                        </div>
                        <%
                            }
                        %>
                        <input type="submit" value="Purchase" onclick="submitForm('<%= product.getProductName() %>','Purchase'); return false;">

                    </div>
                </div>
            </div>


            <!-- <div class="row rent-game">
                <div class="rent-card">

                    <div class="rent-card-title">Rent Black Myth: Wukong</div>

                    <div class="more-infor-rent">
                        <div class="rent-price">
                            $4.99
                        </div>

                        <input type="submit" value="Rent" class="" id="">

                    </div>
                </div>
            </div> -->


            <div class="row rent-it-out">
                <div class="rent-it-out-card">

                    <div class="rent-it-out-card-title">Rent it out Or Rent this game!</div>

                    <div class="more-infor-rent-it-out">
                        <div class="rent-it-out-price">
                            Community
                        </div>

                        <input type="submit" value="Join " onclick="submitForm('<%= product.getProductName() %>','Join'); return false;">

                    </div>
                </div>
            </div>


        </div>
    </div>
</div>

<form  action="ProductServlet" method="POST" id="priceForm" style="display: none;">
    <input type="hidden" name="name_product" id="name_product">
    <input type="hidden" name="COMMAND" id="COMMAND">
</form>

<!-- footer -->

<script>
    function submitForm(name,command) {
        document.getElementById('COMMAND').value = command
        document.getElementById('name_product').value = name;
        document.getElementById('priceForm').submit();
    }
    function changeImage(imageSrc) {
        document.getElementById('mainImage').querySelector('img').src = imageSrc;
    }
</script>
</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>
