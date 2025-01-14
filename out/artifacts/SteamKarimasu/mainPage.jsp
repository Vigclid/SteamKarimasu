<%-- 
    Document   : mainPage.jsp
    Created on : Oct 16, 2024, 11:46:39 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>

</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
</script>
<link rel="stylesheet" href="styles/css/mainPage.css">
<jsp:include page="includes/navBarPage.jsp" />
<body>
<div class="khoang-cach"> k </div>
<jsp:include page="includes/mainTopPage.jsp" />
<div class="container top-game">
    <div class="row">

        <div class="col-12 game-top">

            <div class="top-game-items">
                <a href="">
                    <img src="assets/img/Monster-Hunter.png" alt="">
                    <div class="top-game-price">
                        $20.99
                    </div>
                </a>
            </div>

            <div class="top-game-items">
                <a href="">
                    <img src="assets/img/ARK.png" alt="">
                    <div class="top-game-price">
                        $20.99
                    </div>
                </a>
            </div>

            <div class="top-game-items">
                <a href="">
                    <img src="assets/img/DragonBallSPZ.png" alt="">
                    <div class="top-game-price">
                        $20.99
                    </div>
                </a>
            </div>

            <div class="top-game-items">
                <a href="">
                    <img src="assets/img/Rainbowsix.png" alt="">
                    <div class="top-game-price">
                        $20.99
                    </div>
                </a>
            </div>

            <div class="top-game-items">
                <a href="">
                    <img src="assets/img/SWO.png" alt="">
                    <div class="top-game-price">
                        $20.99
                    </div>
                </a>
            </div>

        </div>

    </div>
</div>

<div class="container trending-game">
    <div class="row">
        <a href="" class="trending-title">Trending</a>
        <div class="col-12 game-trending">

            <div class="trending-game-items">

                <div class="img-items">
                    <img src="assets/images_product/BMW.jpg" alt="">
                </div>

                <div class="trending-more-infor-items">

                    <div class="infor-items">
                        <a href="" class="items-name">Black Myth: Wukong</a>
                        <div class="date">2023-08-10</div>
                        <div class="more-infor">10 bought 5 retend</div>
                    </div>

                    <div class="item-price">
                        <a href="#" class="trending-for-buy" onclick="submitForm('Black Myth: Wukong'); return false;">$49.99</a>
                        <a href="#" class="trending-for-rent" onclick="submitForm('Black Myth: Wukong'); return false;">$5.99</a>
                    </div>

                </div>

            </div>

            <div class="trending-game-items">

                <div class="img-items">
                    <img src="assets/images_product/Brawlhalla.jpg" alt="">
                </div>

                <div class="trending-more-infor-items">

                    <div class="infor-items">
                        <a href="" class="items-name">Brawlhalla</a>
                        <div class="date">2023-09-05</div>
                        <div class="more-infor">11 bought 5 retend</div>
                    </div>

                    <div class="item-price">
                        <a href="#" class="trending-for-buy" onclick="submitForm('Brawlhalla'); return false;">Free</a>
                        <a href="#" class="trending-for-rent" onclick="submitForm('Brawlhalla'); return false;">$1.99</a>
                    </div>

                </div>

            </div>


            <div class="trending-game-items">

                <div class="img-items">
                    <img src="assets/images_product/Sekiro.jpg" alt="">
                </div>

                <div class="trending-more-infor-items">

                    <div class="infor-items">
                        <a href="" class="items-name">Sekiro</a>
                        <div class="date">2023-07-20</div>
                        <div class="more-infor">10 bought 5 retend</div>
                    </div>

                    <div class="item-price">
                        <a href="#" class="trending-for-buy" onclick="submitForm('Sekiro: Shadows Die Twice'); return false;">$59.99</a>
                        <a href="#" class="trending-for-rent" onclick="submitForm('SekSekiro: Shadows Die Twice'); return false;">$7.99</a>
                    </div>

                </div>

            </div>


            <div class="trending-game-items">

                <div class="img-items">
                    <img src="assets/images_product/PUBG.jpg">
                </div>

                <div class="trending-more-infor-items">

                    <div class="infor-items">
                        <a href="" class="items-name">PUBG</a>
                        <div class="date">2023-08-25</div>
                        <div class="more-infor">10 bought 5 retend</div>
                    </div>

                    <div class="item-price">
                        <a href="#" class="trending-for-buy" onclick="submitForm('PUBG'); return false;">$29.99</a>
                        <a href="#" class="trending-for-rent" onclick="submitForm('PUBG'); return false;">4.99</a>
                    </div>

                </div>

            </div>


            <div class="trending-game-items">

                <div class="img-items">
                    <img src="assets/images_product/Luffy.jpg" alt="">
                </div>

                <div class="trending-more-infor-items">

                    <div class="infor-items">
                        <a href="" class="items-name">Luffy Online</a>
                        <div class="date">2023-06-15</div>
                        <div class="more-infor">10 bought 5 retend</div>
                    </div>

                    <div class="item-price">
                        <a href="#" class="trending-for-buy" onclick="submitForm('Luffy Online'); return false;">$39.99</a>
                        <a href="#" class="trending-for-rent" onclick="submitForm('Luffy Online'); return false;">$4.99</a>
                    </div>

                </div>

            </div>


        </div>
    </div>
</div>


<div class="container featurated-game">
    <div class="row">
        <a href="" class="featurated-title">Featurated Game</a>
        <div class="col-12 game-featurated">

            <div class="featurated-game-items">

                <div class="img-items">
                    <img src="assets/images_product/JapaneseBook.jpg" alt="">
                </div>

                <div class="featurated-more-infor-items">

                    <div class="infor-items">
                        <a href="" class="items-name">Japanese Book</a>
                        <div class="date">2023-09-01</div>
                        <div class="more-infor">6 bought 5 retend</div>
                    </div>
                    <div class="item-price">
                        <a href="#" class="featurated-for-buy" onclick="submitForm('Japanese Book'); return false;">$19.99</a>
                        <a href="#" class="featurated-for-rent" onclick="submitForm('Japanese Book'); return false;">$1.99</a>
                    </div>

                </div>

            </div>

            <div class="featurated-game-items">

                <div class="img-items">
                    <img src="assets/images_product/Headphones.jpg" alt="">
                </div>

                <div class="featurated-more-infor-items">

                    <div class="infor-items">
                        <a href="" class="items-name">Headphones Testing</a>
                        <div class="date">2023-07-11</div>
                        <div class="more-infor">10 bought 5 retend</div>
                    </div>

                    <div class="item-price">
                        <a href="#" class="featurated-for-buy" onclick="submitForm('Headphones Testing'); return false;">$99.99</a>
                        <a href="#" class="featurated-for-rent" onclick="submitForm('Headphones Testing'); return false;">$10.99</a>
                    </div>

                </div>

            </div>


            <div class="featurated-game-items">

                <div class="img-items">
                    <img src="assets/images_product/WearingSimulator.jpg" alt="">
                </div>

                <div class="featurated-more-infor-items">

                    <div class="infor-items">
                        <a href="" class="items-name">Wearing Simulator</a>
                        <div class="date">2023-08-18</div>
                        <div class="more-infor">10 bought 5 retend</div>
                    </div>

                    <div class="item-price">
                        <a href="#" class="featurated-for-buy" onclick="submitForm('Wearing Simulator'); return false;">$19.99</a>
                        <a href="#" class="featurated-for-rent" onclick="submitForm('Wearing Simulator'); return false;">$1.99</a>
                    </div>

                </div>

            </div>


            <div class="featurated-game-items">

                <div class="img-items">
                    <img src="assets/images_product/Paladin.jpg" alt="">
                </div>

                <div class="featurated-more-infor-items">

                    <div class="infor-items">
                        <a href="" class="items-name">Paladin</a>
                        <div class="date">2023-08-02</div>
                        <div class="more-infor">10 bought 5 retend</div>
                    </div>

                    <div class="item-price">
                        <a href="#" class="featurated-for-buy" onclick="submitForm('Paladin'); return false;">Free</a>
                        <a href="#" class="featurated-for-rent" onclick="submitForm('Paladin'); return false;">$1.99</a>
                    </div>

                </div>

            </div>


            <div class="featurated-game-items">

                <div class="img-items">
                    <img src="assets/images_product/basketball.jpg" alt="">
                </div>

                <div class="featurated-more-infor-items">

                    <div class="infor-items">
                        <a href="" class="items-name">Basketball</a>
                        <div class="date">2023-09-15</div>
                        <div class="more-infor">10 bought 5 retend</div>
                    </div>

                    <div class="item-price">
                        <a href="#" class="featurated-for-buy" onclick="submitForm('Basketball'); return false;">$14.99</a>
                        <a href="#" class="featurated-for-rent" onclick="submitForm('Basketball'); return false;">$1.99</a>
                    </div>

                </div>

            </div>


        </div>
    </div>
</div>

<div class="container buy-rent-online-game" id="buy-rent-online-game">
    <div class="row">

        <div class="col-7 content">
            <div class="title">
                <h1>Buy & Rent Online Game</h1>
            </div>

            <div class="subtitle">
                <p>
                    Knight2s is home to the most exciting collection of online games. Play our beautiful games on
                    desktop, where users can easily connect with game renters. Just click to jump straight into exciting
                    games.
                </p>

                <p>
                    Buy or rent games at the best prices, come to Knight2s.
                </p>
            </div>

            <form action="" method="" class="">
                <div class="learn-more">
                    <input type="submit" value="Learn More">
                </div>
            </form>
        </div>

<%--        <div class="col-5 more-infor-img">--%>
<%--            <div class="main-img">--%>
<%--                <img src="assets/img/buy&rentimg1.png" alt="">--%>
<%--            </div>--%>


<%--            <div class="sup-img">--%>
<%--                <img src="assets/img/buy&rentimg2.png" alt="">--%>
<%--                <img src="assets/img/buy&rentimg3.png" alt="">--%>
<%--            </div>--%>
<%--        </div>--%>

    </div>

</div>

<div class="container-s body-infor-img" id="body-infor-img">
    <div class="content">
        Extra income by renting out games
    </div>
</div>


<div id="leader-board" class="container leader-board">
    <h1>Leader Board</h1>
    <div class="row">
        <div class="col">
            <div class="card">

                <div class="head-card">
                    <div class="head-content">
                        <div class="name-card">Buy Game</div>
                        <div class="sub-til-card">In this month</div>
                    </div>

                    <div class="icon-card">
                        <img src="assets/img/ledearboard element.png" alt="">
                    </div>
                </div>

                <div class="content-card">

                </div>

            </div>

        </div>

        <div class="col">
            <div class="card">

                <div class="head-card">
                    <div class="head-content">
                        <div class="name-card">Buy Game</div>
                        <div class="sub-til-card">In this month</div>
                    </div>

                    <div class="icon-card">
                        <img src="assets/img/ledearboard element.png" alt="">
                    </div>
                </div>

                <div class="content-card">

                </div>

            </div>

        </div>
    </div>

</div>

<form action="ProductServlet" method="POST" id="priceForm" style="display: none;">
    <input type="hidden" name="name_product" id="name_product">
    <input type="hidden" name="COMMAND" id = "COMMAND">
</form>

<script>
    function submitForm(name) {
        document.getElementById('COMMAND').value = "VIEWPAGE"
        document.getElementById('name_product').value = name;
        document.getElementById('priceForm').submit();
    }
</script>

</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>