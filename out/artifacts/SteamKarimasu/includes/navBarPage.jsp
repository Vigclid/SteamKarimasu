<%-- 
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
<<<<<<< Updated upstream
<body>
<div class="container-s navBarPage fixed-top">
=======

<!-- <link rel="stylesheet" href="bootstrap-5.3.3-dist/css/bootstrap.css"> -->
<link rel="stylesheet" href="bootstrap-5.3.3-dist/css/bootstrap.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/navBarPage.css">
<base href="/web/">

<body>
<div id="navBarPage" class="container-s navBar fixed-top">
>>>>>>> Stashed changes
    <button id="side-bar-button" class="side-bar-button" onclick="toggleSidebar()">
        <img src="${pageContext.request.contextPath}/assets/img/menuNav.png" alt="Menu">
    </button>

    <div class="side-bar" id="side-bar">
        <div class="side-bar-items">
            <a href="#">Home</a>
            <a href="#">Category</a>
            <a href="#">Buy</a>
            <a href="#">Rent</a>
        </div>
    </div>

<<<<<<< Updated upstream
    <div id="icon-nav-page">
        <img src="${pageContext.request.contextPath}/assets/img/mainPageLogo.png" alt="Logo">
=======

    <div class="icon-nav-page">
        <a href="">
            <img src="${pageContext.request.contextPath}/assets/img/mainPageLogo.png" alt="">
        </a>
>>>>>>> Stashed changes
    </div>

    <form action="" method="">
        <div class="nav-search-join">
            <div class="navbar-search">
                <input type="text" name="search" placeholder="Search">
            </div>
            <!-- Conditionally rendered login button -->

<<<<<<< Updated upstream
            <%
                String username = (String) session.getAttribute("username");
                if (username == null) {
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
                        <div class="accout-name">Name</div>
                        <div class="accout-role">Role: Slave</div>
                        <div class="accout-kcoins">
                            <input class="kcoins" type="text" value="99.99" readonly>
                        </div>
                    </div>
                    <div class="accout-feature">
                        <div class="row feature">
                            <div class="col-6"><input type="submit" value="Profile"></div>
                            <div class="col-6"><input type="submit" value="Deposit"></div>
                        </div>
                        <div class="row feature">
                            <div class="col-6"><input type="submit" value="News"></div>
                            <div class="col-6"><input type="submit" value="LogOut"></div>
                        </div>
                    </div>
=======
            <!-- <div class="navbar-join-us">
                <input type="submit" name="join-us" value="Join Us">
            </div> -->

            <button type="button" id="user-infor-button" class="user-infor-button" onclick="toggleUserInfor()">
                <img src="${pageContext.request.contextPath}/assets/img/user-infor-button.png" alt="">
            </button>

            <div id="user-infor-items" class="user-infor-items">
                <div class="infor-items">
                    <div class="row accout-infor">

                        <div class="accout-img">
                            <img src="${pageContext.request.contextPath}/assets/img/ARK.png" alt="">
                        </div>

                        <div class="accout-name">
                            Name
                        </div>

                        <div class="accout-role">
                            Role: Slave
                        </div>

                        <div class="accout-kcoins">
                            <input class="kcoins" type="text" value="99.99" name="" id="" readonly>
                        </div>

                    </div>

                    <div class="accout-feature">

                        <div class="row feature">

                            <div class="col-6">
                                <input type="submit" value="Profile" id="" name="">
                            </div>

                            <div class="col-6">
                                <input type="submit" value="Deposit" id="" name="">
                            </div>

                        </div>

                        <div class="row feature">

                            <div class="col-6">
                                <input type="submit" value="News" id="" name="">
                            </div>

                            <div class="col-6">
                                <input type="submit" value="LogOut" id="" name="">
                            </div>

                        </div>
                        <!--
                        <div id="manage" class="row feature">
                            <div class="col-6">
                                <input type="submit" value="Mange" id="" name="">
                            </div>
                        </div>
                        -->
                        <!--If else r unlock cái này ra :D-->

                    </div>

>>>>>>> Stashed changes
                </div>
            </div>
            <%
                }

            %>
            <%--            --%>

        </div>
<<<<<<< Updated upstream
    </form>
=======
        <form>

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    function toggleUserInfor() {
        var userInfor = document.getElementById("user-infor-items");
        userInfor.classList.toggle("active-user-infor");
=======
    button.addEventListener('click', function () {
        button.classList.toggle('rotated');
    });

    function toggleUserInfor() {
        var sidebar = document.getElementById("user-infor-items");
        sidebar.classList.toggle("active-user-infor");

>>>>>>> Stashed changes
    }
</script>
</body>

</html>