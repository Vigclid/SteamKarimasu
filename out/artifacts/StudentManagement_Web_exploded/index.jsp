<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/13/2024
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="styles/css/loginPage.css">
</head>
<body>

<div class="container baseCard">
    <div class="row">
        <div class="col-5 loginPart">
            <div class="loginCard">

                <div class="loginTitle">
                    <h1>Login</h1>
                </div>
                <br>
                <form action="LoginServlet" method="POST">
                    <div class="login_infor">
                        <div class="inputUP">
                            <label for="username" class=""></label>
                            <input type="text" name="username" id="username" placeholder="Username">
                        </div>
                        <br>
                        <div class="inputUP">
                            <label for="password" class=""></label>
                            <input type="text" class="" name="password" placeholder="Password" id="password">
                        </div>
                    </div>

                    <div class="ask_more">
                        <div class="remember_forgot">
                            <div class="remember_me">
                                <input type="checkbox" class="" name="remember_me" id="remember_me">
                                <label for="remember_me">Remember Me</label>
                            </div>

                            <div class="forgot_password">
                                <a href="forgotPage.html">Forgot Password?</a>
                            </div>
                        </div>
                    </div>

                    <input type="submit" class="login_card" value="Login">


                </form>




                <div class="Continue">
                    <span>Or Continue With</span>
                </div>

                <div class="Continue_Item">

                    <a  href="">
                        <div class="ortherLogin">
                            <img src="assets/img/GoogleLogo.png" alt="">
                        </div>
                    </a>



                    <a href="">
                        <div class="ortherLogin">
                            <img src="assets/img/SteamLogo.png" alt="">
                        </div>
                    </a>



                    <a href="">
                        <div class="ortherLogin">
                            <img src="assets/img/FacebookLogo.png" alt="">
                        </div>
                    </a>

                </div>

                <div class="register">
                    <span>Don't Have Accout Yet?  <a href="registerPage.html">Register for here</a></span>
                </div>


            </div>
        </div>
        <div class="col-7 iconCard">
            <img src="assets/img/TeamLogo.png" alt="">
        </div>
    </div>
</div>

<div class="container-s footer">
    <div class="row">

    </div>
</div>



</body>
</html>
