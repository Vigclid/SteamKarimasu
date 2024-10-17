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
                        <input type="text" name="username_header" id="username" placeholder="Email Or Username">
                    </div>

                    <div class="inputUP">
                        <label for="password" class=""></label>
                        <input type="password" class="" name="password_header" placeholder="Password" id="password">
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
                    <input type="email" name="email" placeholder="Email">
                </div>
                <br>
                <div class="phonenumber">
                    <label ></label>
                    <input type="number" name="phonenumber" placeholder="Phone Number">
                </div>
                <br>
                <div class="date">
                    <div class="day">
                        <label ></label>
                        <select name="day" required>
                            <option value="" disabled selected>Day</option>
                            <script>
                                const daySelect = document.querySelector('select[name="day"]');
                                for (let i = 1; i <= 31; i++) {
                                    const option = document.createElement('option');
                                    option.value = i;
                                    option.textContent = i; // Set the text to the day number
                                    daySelect.appendChild(option);
                                }
                            </script>
                        </select>
                    </div>

                    <div class="month">
                        <label ></label>
                        <select name="month" required>
                            <option value="" disabled selected>Month</option>
                            <!-- Generate options for months (1-12) -->
                            <script>
                                const monthSelect = document.querySelector('select[name="month"]');
                                for (let i = 1; i <= 12; i++) {
                                    const option = document.createElement('option');
                                    option.value = i;
                                    option.textContent = i; // You can replace this with the month name if you want
                                    monthSelect.appendChild(option);
                                }
                            </script>
                        </select>
                    </div>

                    <div class="year">
                        <label ></label>
                        <select name="year" required>
                            <option value="" disabled selected>Year</option>
                            <!-- Generate options for years (1990-2100) -->
                            <script>
                                const yearSelect = document.querySelector('select[name="year"]');
                                const currentYear = new Date().getFullYear();
                                for (let i = currentYear - 100; i <= currentYear + 20; i++) {
                                    const option = document.createElement('option');
                                    option.value = i;
                                    option.textContent = i;
                                    yearSelect.appendChild(option);
                                }
                            </script>
                        </select>
                    </div>
                </div>
                <br>
                <div class="password">
                    <label for="password"></label>
                    <input type="password" name="password" placeholder="Password">
                </div>
                <br>
                <div class="comfirm_password">
                    <label for=></label>
                    <input type="password" name="confirm_password" placeholder="Comfirm Password">
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