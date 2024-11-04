<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Entity.product" %>
<%@ page import="common.LoginSession" %>
<%@ page import="model.Entity.user" %>
<%@ page import="model.Entity.ListRent" %>
<%@ page import="repository.impl.ListRentRepositoryImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="repository.impl.UserRoleRepositoryImpl" %>
<%@ page import="repository.impl.userRepositoryimpl" %><%--
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
    <link rel="stylesheet" href="styles/css/joinRentPage.css">
</head>
<jsp:include page="includes/navBarPage.jsp" />
<body>
<!-- navBar -->
<%
    // Tạo đối tượng LoginSession và lấy username từ session
    LoginSession loginSession = new LoginSession();
    user loggedInUser = loginSession.getLoginSession(request);
    String username = (loggedInUser != null) ? loggedInUser.getUsername() : "Guest";



    product product = (product) request.getAttribute("profile_product");



%>
<script>
    window.username = "<%= username%>"
</script>

<div class="container game" id="join-rent">

    <div class="row game-title">
        <%= product.getProductName() %>
    </div>

    <div class="row advertisement">
        <a href="">
            <img src="assets/img/Banner_ads.png" alt="">
        </a>
    </div>

    <div class="row body-game-page">

        <div class="col-7 rent-it-out-list">

            <div class="rent-it-out-list-table">
                <%
                    List<ListRent> listRentList = new ListRentRepositoryImpl().getListRent(product.getProductId());
                    userRepositoryimpl userRepositoryimpl = new userRepositoryimpl();
                    List<user> userList = new ArrayList<>();
                    for (ListRent listRent : listRentList){
                        userList.add(userRepositoryimpl.getUserByRentListId(listRent.getListRentId()));
                    }
                    request.setAttribute("userList",userList);
                %>
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
                    <c:forEach var="u" items="${userList}">
                        <tr>
                            <td>${u.getUserId()}</td>
                            <td>${u.getUsername()}</td>
                            <td>${u.getPhoneNumber()}</td>
                            <td>
                                <form onsubmit="handleConfirm(event)" action="ProductServlet" method="post">
                                    <input type="hidden" value="${u.getUserId()}" name="renter">
                                    <input class="Rent" type="submit" value="Rent" name="COMMAND">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>


                    </tbody>

                </table>
            </div>
            <form onsubmit="handleConfirm(event)" action="ProductServlet" method="post">
                <div class="join-rent-but">
                    <input type="submit" name="COMMAND" value="Join List" >
                </div>
            </form>


        </div>

        <div class="col-5 game-about">

            <div class="row about-img">
                <img src="<%= request.getContextPath() + "/" + product.getProductImage().replace("C:\\Users\\Admin\\Documents\\Github\\SteamKarimasu\\web\\", "") %>" alt="">
            </div>

            <div class="row about-content">
                <p><%= product.getProdcuctDescription()%></p>
            </div>


            <div class="row buy-game">
                <div class="buy-card">

                    <div class="buy-card-title">Buy <%= product.getProductName() %></div>

                    <div class="more-infor-buy">
                        <div class="buy-price">
                            $<%= product.getPrice() %>
                        </div>

                        <input type="submit" value="Purchase" onclick="submitForm('Purchase'); return false;">

                    </div>
                </div>
            </div>



            <div class="row rent-it-out">
                <div class="rent-it-out-card">

                    <div class="rent-it-out-card-title">Rent it out Or Rent this game!</div>

                    <div class="more-infor-rent-it-out">
                        <div class="rent-it-out-price">
                            Community
                        </div>

                        <input type="submit" value="Join" onclick="submitForm('Join'); return false;">

                    </div>
                </div>
            </div>


        </div>
    </div>
</div>

<form  action="ProductServlet" method="POST" id="priceForm" style="display: none;">
    <input type="hidden" name="name_product" id="name_product" value="<%=product.getProductName()%>">
    <input type="hidden" name="COMMAND" id="COMMAND">
</form>

<!-- footer -->


<!-- footer -->
<script>
        function submitForm(command) {
            document.getElementById('COMMAND').value = command
            document.getElementById('priceForm').submit();
        }

</script>

<script src="js/joinRentPage.js">

</script>
</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>
