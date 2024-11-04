<%--
    Document   : rentOutListPage
    Created on : Oct 30, 2024, 11:35:58 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/css/rentOutListPage.css">
</head>
<jsp:include page="includes/navBarPage.jsp" />
<body>
<div id="rentOutListPage" class="container-s rentOutListPage">

    <div class="row">

        <div class="col-3 add-edit-game">

            <input class="add-game-button" type="submit" value="Add Game" id="" name="">

            <input class="search-game-button" type="submit" value="Search Game" id="" name="">

            <input class="edit-game-button" type="submit" value="Edit Game" id="" name="">

        </div>

        <div class="col-8 list-rent-game">

            <div class="rent-infor">
                <input class="game-information" type="submit" value="Game Information" id="" name="">

                <input class="rent-out-list" type="submit" value="Rent Out List" id="" name="">
            </div>


            <div class="list-rent-game-table">

                <table>

                    <thead>

                    <tr>
                        <th>No</th>
                        <th>Accout Name</th>
                        <th>Mail</th>
                        <th>Phone Number</th>
                        <th>Remove</th>
                    </tr>

                    </thead>

                    <tbody>

                    <tr>
                        <td>1</td>
                        <td>Nguyen</td>
                        <td>@gmail.com</td>
                        <td>0123456789</td>
                        <td><input class="delete-list" id="" type="submit" value="Delete"></td>
                    </tr>



                    </tbody>

                </table>


            </div>

            <div class="confirm-rent-out-list">
                <input type="submit" value="Confirm" class="" name="" value="">
            </div>

        </div>

    </div>

</div>





</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>
