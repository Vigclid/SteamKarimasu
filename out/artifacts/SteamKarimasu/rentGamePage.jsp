<%@ page import="model.Entity.product" %><%--
    Document   : rentGamePage
    Created on : Nov 2, 2024, 7:58:12 PM
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
    <link rel="stylesheet" href="styles/css/rentGamePage.css">
</head>
<jsp:include page="includes/navBarPage.jsp" />
<body>

<%
    product product = (product) request.getAttribute("profile_product");
%>



<div id="rentGamePage" class="container rentGamePage">

    <div class="row payment-card">
        <h1>Rent Games From Other Users</h1>

        <div class="col infor-card">
            <div class="items-infor-card">

                <div class="img-game">
                    <img src="assets/img_game_page/about_game_img.png" alt="">
                </div>

                <div class="infor-game">
                    <div class="title"><%=product.getProductName()%></div>

                    <div class="sub-title">
                        <div class="sub1">Ready to join list: </div>
                        <div class="sub2"><%=product.getProductName()%></div>
                    </div>
                </div>

                <div class="price"><%=product.getPrice()%> Kcoins</div>
            </div>
        </div>

        <div class="confirm">
            <input type="submit" value="Confirm">
        </div>
    </div>

</div>

</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>