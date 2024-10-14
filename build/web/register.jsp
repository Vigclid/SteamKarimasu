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
    <link rel="stylesheet" href="css/registerPage.css">
</head>
<body>
<form action="UserRegister" class="" method="POST">

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


            <div class="col registerCard">
                <div class="titleRegister">
                    <h1>Register</h1>
                </div>

                <div class="username">
                    <label for="username"></label>
                    <input type="text" name="username" placeholder="Username">
                </div>
                <br>
                <div class="email">
                    <label ></label>
                    <input type="text" name="email" placeholder="Email">
                </div>
                <br>
                <div class="phonenumber">
                    <label ></label>
                    <input type="text" name="phonenumber" placeholder="Phone Number">
                </div>
                <br>
                <div class="date">
                    <div class="day">
                        <label ></label>
                        <input type="text" name="day" placeholder="Day">
                    </div>

                    <div class="month">
                        <label ></label>
                        <input type="text" name="month" placeholder="Month">
                    </div>

                    <div class="year">
                        <label ></label>
                        <input type="text" name="year" placeholder="Year">
                    </div>
                </div>
                <br>
                <div class="password">
                    <label for="password"></label>
                    <input type="text" name="password" placeholder="Password">
                </div>
                <br>
                <div class="comfirm_password">
                    <label for=></label>
                    <input type="text" name="comfirm_password" placeholder="Comfirm Password">
                </div>

                <input type="submit" class="Create" value="Create Accout">


            </div>


        </div>
    </div>

    <div class="container-s footer">
        <div class="row">

        </div>
    </div>

</form>

</body>
</html>