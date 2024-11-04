<%--
    Document   : profileRentInforPage
    Created on : Nov 4, 2024, 2:40:03 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="styles/css/profileRentInforPage.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<jsp:include page="includes/navBarPage.jsp" />
<body>

<div id="profileRentInforPage" class="container profileRentInforPage">

    <div class="row profile">

        <div class="col-3 user-img">
            <img src="assets/img_profile_page/Blank_Rectangle.png" alt="">
        </div>

        <div class="col-9 user-infor">
            <table>
                <tbody>
                <tr class="game-renter">
                    <td style="padding-right: 30px;">Game Renter: </td>
                    <td>User123</td>
                </tr>

                <tr class="game-lender">
                    <td>Game Lender: </td>
                    <td>Pussy Slayer</td>
                </tr>
                </tbody>
            </table>

        </div>

    </div>

    <div class="row user-function">

        <div class="col-3 user-contact">

            <div class="main-information">
                <input type="submit" value="Main Information" class="" id="" name="">
            </div>

        </div>

        <div class="col-9 user-more-infor">

            <div class="infor-items">

                <div class="user-email">
                    <div class="email">Email</div>
                    <input class="input-email" type="text" value="">
                </div>

                <div class="user-phone">
                    <div class="email">Phone Number</div>
                    <input class="input-phone" type="text" value="">
                </div>

            </div>

        </div>

    </div>

    <div class="row payment-card">
        <h3>Connect Via Game</h3>


        <div class="col-9 infor-card">
            <div class="items-infor-card">

                <div class="img-game">
                    <img src="assets/img_game_page/about_game_img.png" alt="">
                </div>

                <div class="infor-game">
                    <div class="title">Black Myth: Wukong</div>

                    <div class="sub-title">
                        <div class="sub1">Game Lender: </div>
                        <div class="sub2">Pussy Slayer</div>
                    </div>
                </div>

                <div class="price">Time Payment</div>
            </div>
        </div>


    </div>

    <div class="row confirm">
        <input type="submit" value="Confirm">
    </div>
</div>

</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>
