<%-- 
    Document   : navBarPage
    Created on : Oct 21, 2024, 12:08:59 PM
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

<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/navBarPage.css">
<body>
<div class="container-s navBar fixed-top">
    <button id="side-bar-button" class="side-bar-button" onclick="toggleSidebar()">
        <img src="${pageContext.request.contextPath}/assets/img/menuNav.png" alt="">
    </button>

    <div class="side-bar" id="side-bar">
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

    <form action="" method="">
        <div class="nav-search-join">

            <div class="navbar-search">
                <input type="text" name="search" placeholder="Search">
            </div>

            <div class="navbar-join-us">
                <a href="${pageContext.request.contextPath}/login.jsp" class="button">Join Us</a>
            </div>
                <a href="${pageContext.request.contextPath}/profilePage.jsp"> qua </a>
            </div>

        </div>
        </form>

</div>

<script>
    function toggleSidebar() {
        var sidebar = document.getElementById("side-bar");
        sidebar.classList.toggle("active");
    }

    const button = document.getElementById('side-bar-button');

    button.addEventListener('click', function() {
        button.classList.toggle('rotated');
    });
</script>
</body>
</html>
