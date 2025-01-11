<%@ page import="common.LoginSession" %>
<%@ page import="model.Entity.user" %>
<%@ page import="repository.UserRoleRepository" %>
<%@ page import="repository.impl.UserRoleRepositoryImpl" %><%--
    Document   : navBarPage
    Created on : Oct 21, 2024, 12:08:59 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/navBarPage.css">
</head>
<body>
<div class="container-s navBarPage fixed-top">
    <button id="side-bar-button" class="side-bar-button" onclick="toggleSidebar()">
        <img src="${pageContext.request.contextPath}/assets/img/menuNav.png" alt="Menu">
    </button>

    <div class="side-bar" id="side-bar">
        <div class="side-bar-items">
            <a href="${pageContext.request.contextPath}/mainPage.jsp">Home</a>
            <a href="${pageContext.request.contextPath}/CategoryServlet?page=1&command=Name">Category</a>
            <a href="${pageContext.request.contextPath}/commingSoon.jsp">Buy</a>
            <a href="${pageContext.request.contextPath}/commingSoon.jsp">Rent</a>
        </div>
    </div>

    <div id="icon-nav-page">
        <img src="${pageContext.request.contextPath}/assets/img/mainPageLogo.png" alt="Logo">
        <a href="${pageContext.request.contextPath}/mainPage.jsp"></a>
    </div>

    <form action="" method="">
        <div class="nav-search-join">
            <div class="navbar-search">
                <input type="text" name="search" placeholder="Search">
            </div>
            <!-- Conditionally rendered login button -->
            <% user user = new LoginSession().getLoginSession(request);
                if (user == null){

            %>
            <div class="navbar-join-us">
                <a href="${pageContext.request.contextPath}/login.jsp" class="button">Join Us</a>
            </div>
            <%
            } else {

            %>
            <button type="button" id="user-infor-button" class="user-infor-button" onclick="toggleUserInfor()">
                <img src="${pageContext.request.contextPath}/assets/img/user-infor-button.png" alt="User Info">
            </button>
            <div id="user-infor-items" class="user-infor-items">
                <div class="infor-items">
                    <div class="row accout-infor">
                        <div class="accout-img">
                            <img src="${pageContext.request.contextPath}/assets/img/ARK.png" alt="User">
                        </div>
                        <div class="accout-name"><%= user.getUsername() %></div>
                        <div class="accout-role"><%= new LoginSession().getRoleNameUser(request)%></div>
                        <div class="accout-kcoins">
                            <input class="kcoins" type="text" value="<%= user.getTotalAmount()%>" readonly>
                        </div>
                    </div>
                    <div class="accout-feature">
                        <div class="row feature">
                            <div class="col-6">
                                <a href="${pageContext.request.contextPath}/profilePage.jsp" class="button-link">Profile</a>
                            </div>
                            <div class="col-6">
                                <a href="${pageContext.request.contextPath}/depositPage.jsp" class="button-link">Deposit</a>
                            </div>
                        </div>
                        <div class="row feature">
                            <div class="col-6">
                                <a href="${pageContext.request.contextPath}/commingSoon.jsp" class="button-link">News</a>
                            </div>
                            <div class="col-6">
                                <a href="LogoutServlet" class="button-link">LogOut</a>
                            </div>
                        </div>

                        <% int id = new LoginSession().getLoginSession(request).getUserId();
                            if(id == 1) {

                        %>
                        <div class="row feature">
                            <div class="col-12 ">
                                <a href="${pageContext.request.contextPath}/searchGamePage.jsp" class="button-link" style="background-color: rgb(222, 81, 25);">Manage</a>
                            </div>
                        </div>
                        <%}%>

                    </div>
                </div>

            </div>
            <%
                }

            %>

        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
</script>
<script>
    function toggleSidebar() {
        var sidebar = document.getElementById("side-bar");
        sidebar.classList.toggle("active-side-bar");
    }

    const button = document.getElementById('side-bar-button');
    if (button) {
        button.addEventListener('click', function () {
            button.classList.toggle('rotated');
        });
    }

    function toggleUserInfor() {
        var userInfor = document.getElementById("user-infor-items");
        userInfor.classList.toggle("active-user-infor");
    }
</script>
</body>
</html>