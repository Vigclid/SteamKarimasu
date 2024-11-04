<%@ page import="model.Entity.product" %>
<%@ page import="common.LoginSession" %>
<%@ page import="model.Entity.user" %>
<%@ page import="repository.impl.ListRentRepositoryImpl" %><%--
    Document   : buyGamePage
    Created on : Nov 2, 2024, 7:57:23 PM
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
    <link rel="stylesheet" href="styles/css/buyGamePage.css">
</head>
<jsp:include page="includes/navBarPage.jsp" />
<body>

<%
    // Tạo đối tượng LoginSession và lấy username từ session
    LoginSession loginSession = new LoginSession();
    user loggedInUser = loginSession.getLoginSession(request);
    String username = (loggedInUser != null) ? loggedInUser.getUsername() : "Guest";
%>



<div id="buyGamePage" class="container buyGamePage">
    <%
        product product = (product) request.getAttribute("profile_product");


        Boolean checkError = (Boolean) request.getAttribute("check");
        if (checkError == null) {
            checkError = false;
        }
        try {
            checkError = new ListRentRepositoryImpl().checkUserHaveProduct(product.getProductId(), new LoginSession().getLoginSession(request).getUserId());
        } catch (Exception ignore){}
    %>
    <div class="row payment-card">
        <h1><%=product.getProductName()%></h1>

        <div class="col infor-card">
            <div class="items-infor-card">

                <div class="img-game">
                    <img src="<%= request.getContextPath() + "/" + product.getProductImage().replace("C:\\Users\\Admin\\Documents\\Github\\SteamKarimasu\\web\\", "") %>" alt="">

                </div>

                <div class="infor-game">
                    <div class="title"><%=product.getProductName()%></div>

                    <div class="sub-title">
                        <%
                            if (!checkError) {
                        %>
                        <div class="sub1">Ready to own: </div>
                        <div class="sub2"><%=product.getProductName()%></div>
                        <%
                            } else {
                        %>

                        <div class="sub1">Your Download Link Here: </div>
                        <a href="https://download.com.vn/download/black-myth-wukong-165910" target="_blank" class="sub2">https://download.com.vn/download/black-myth-wukong-165910</a>
                        <%
                            }
                        %>
                    </div>
                </div>

                <%
                    if (!checkError) {
                %>
                <div class="price"><%=product.getPrice()%> Kcoins</div>
                <%
                }
                %>



            </div>
        </div>

        <%
            if (!checkError) {
        %>

        <form onsubmit="handleConfirm(event)" action="ProductServlet" method="post">
            <input type="hidden" name="name_product" value="<%=product.getProductName()%>">
            <input type="hidden" name="COMMAND" value="Confirm_Purchase">
            <div class="confirm">
                <input type="submit" value="Confirm">
            </div>
        </form>

        <%
        } else {
        %>
        <from action="mainPage.jsp">
            <div class="exit">
                <input type="submit" value="Exit">
            </div>
        </from>
        <%
            }
        %>
    </div>

</div>
<script>window.username = "<%= username%>"</script>
<script src="js/buyGamePage.js"></script>
</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>
