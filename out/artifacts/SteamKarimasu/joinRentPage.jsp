<%--
    Document   : joinRentPage
    Created on : Oct 24, 2024, 1:17:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
    </script>
</head>
<jsp:include page="includes/navBarPage.jsp" />
<body>
<!-- navBar -->

<div class="container game" id="join-rent">

    <div class="row game-title">
        Black Myth: Wukong
    </div>

    <div class="row advertisement">
        <a href="">
            <img src="assets/img/Banner_ads.png" alt="">
        </a>
    </div>

    <div class="row body-game-page">

        <div class="col-7 rent-it-out-list">

            <div class="rent-it-out-list-table">
                <table>
                    <thead>
                    <tr>
                        <th>No</th>
                        <th>Name</th>
                        <th>Contact</th>
                        <th>Rent Now</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>gyggyggy</td>
                        <td>uhhuhuhuuh</td>
                        <td>huuhhuuhu</td>
                        <td><input class="Rent" type="submit" value="Rent"></td>
                    </tr>

                    </tbody>

                </table>
            </div>

            <div class="join-rent-but">
                <input type="submit" name="" value="Join List" >
            </div>

        </div>

        <div class="col-5 game-about">

            <div class="row about-img">
                <img src="assets/img_game_page/about_game_img.png" alt="">
            </div>

            <div class="row about-content">
                <p>Black Myth: Wukong is an action RPG rooted in Chinese mythology. You shall set out as the
                    Destined One to venture into the challenges and marvels ahead, to uncover the obscured truth
                    beneath the veil of a glorious legend from the past.</p>
            </div>


            <div class="row buy-game">
                <div class="buy-card">

                    <div class="buy-card-title">Buy Black Myth: Wukong</div>

                    <div class="more-infor-buy">
                        <div class="buy-price">
                            $49.99
                        </div>

                        <input type="submit" value="Purchase" class="" id="">

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

                        <input type="submit" value="Join " class="" id="">

                    </div>
                </div>
            </div>


        </div>
    </div>
</div>


<!-- footer -->

</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>
