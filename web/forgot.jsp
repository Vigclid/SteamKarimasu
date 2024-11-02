<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 14/10/2024
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="styles/css/forgotPage.css">
</head>
<body>
<form action="ResetPasword"  method="POST">

    <div class="container baseCard">
        <div class="row">
            <div class="col navCard">
                <div class="logo_nav">
                    <img src="assets/img/smallogo.png" alt="">

                    <div>2Knights</div>
                </div>

                <div class="login">
                    <div class="inputUP">
                        <label for="username" class=""></label>
                        <input type="text" name="username" id="username" placeholder="Email Or Username">
                    </div>

                    <div class="inputUP">
                        <label for="password" class=""></label>
                        <input type="text" class="" name="password" placeholder="Password" id="password">
                    </div>

                    <input type="submit" class="login_card" value="Login">


                </div>
            </div>

            <div class="col get_back_accout_card">
                <div class="title_infor">
                    <h1>Get Back Accout Information</h1>
                    <h3>Please enter your email or phone number to search your accout</h3>
                </div>

                <div class="input_infor">
                    <label for="confirm_email"></label>
                    <input type="text" name="confirm_email" id="confirm_email"  placeholder="Email or Phone Number">
                </div>

                <div class="button_infor">


                    <a class="back_page" href="index.jsp">
                        <div>Back</div>
                    </a>

                    <input type="submit" class="find_email" value="Find">

                </div>
            </div>
        </div>
    </div>

    <div class="container-s footer">
        <div class="row">

        </div>
    </div>

</form>

<p class="text-bg-danger">${mess}</p>

</body>
</html>
