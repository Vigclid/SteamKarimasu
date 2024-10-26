<%--
    Document   : navBarPage
    Created on : Oct 21, 2024, 12:08:59 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/navBarPage.css">
<body>
<div class="container-s navBar">
    <button class="side-bar-button" onclick="toggleSidebar()">
        <img src="${pageContext.request.contextPath}/assets/img/menuNav.png" alt="">
    </button>

    <div class="side-bar" id="side-bar">
        <a class="close-side-bar" onclick="toggleSidebar()">x</a>
        <div class="side-bar-items">
            <a href="">Home</a>
            <a href="">Category</a>
            <a href="">Buy</a>
            <a href="">Rent</a>
        </div>
    </div>


    <div class="icon-nav-page">
        <img src="${pageContext.request.contextPath}/assets/img/mainPageLogo.png" alt="">
    </div>

    <form action="" method="get">
        <div class="nav-search-join">

            <div class="navbar-search">
                <input type="text" name="search" placeholder="Search">
            </div>

<%--            <div class="navbar-join-us" >--%>
<%--                <input type="submit" name="join-us" value="Join Us" onclick="location.href='../login.jsp'">--%>
<%--            </div>--%>
            <>
            <>
            <div class="navbar-join-us">
                <a href="/StudentManagement_Web_exploded/login.jsp" class="button">Join Us</a>
            </div>

        </div>
        </form>

</div>

<script>
    function toggleSidebar() {
        var sidebar = document.getElementById("side-bar");
        sidebar.classList.toggle("active");
    }
</script>
</body>
</html>