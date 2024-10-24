<%@ page import="common.CookieUtils" %>
<%@ page import="javax.servlet.http.HttpSession" %><%--

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
<%
    // Kiểm tra xem có Cookie lưu username hay không
    String cookieUsername = CookieUtils.get("username", request);
    HttpSession currentSession = request.getSession(false);

    // Nếu có cookie, tự động tạo session và chuyển hướng
    if (cookieUsername != null && currentSession.getAttribute("username") != null) {
        currentSession.setAttribute("username", cookieUsername);
        response.sendRedirect("mainPage.jsp");
        return;
    }
%>

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

                    <a  href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid
                                &redirect_uri=http://localhost:5000/StudentManagement_Web_exploded/LoginServlet
                                &response_type=code
                                &client_id=638003678670-95tt4o7buj11j1aplsf1h8m4vl23jsse.apps.googleusercontent.com
                                &approval_prompt=force
                                ">
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
                    <span>Don't Have Accout Yet?  <a href="register.jsp">Register for here</a></span>
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
