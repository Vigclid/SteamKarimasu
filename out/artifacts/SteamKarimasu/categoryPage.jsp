<%@ page import="repository.DAO.ProductsDAO" %>
<%@ page import="model.Entity.product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
    Document   : categoryPage
    Created on : Oct 27, 2024, 5:09:13 PM
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="styles/css/categoryPage.css">


</head>
<jsp:include page="includes/navBarPage.jsp" />
<body>

<div id="categoryPage" class="container categoryPage">

    <div class="row category-sort">

        <div class="col-3" class="page-category">
            <input type="submit" class="all-category" value="All Category >" id="" name="">
        </div>

        <div class="col-3" class="page-sort-by">
            <button id="sort-by" class="sort-by" onclick="toggleSortBy()">
                Sort By <div class="arrow">></div>
            </button>

            <div class="sort-by-table" id="sort-by-table">s
                <div class="sort-by-items">
                    <form action = "CategoryServlet" method="GET">
                        <input type="submit" value="Name" name = "command">
                        <input type="submit" value="Price" name = "command" >
                        <input type="submit" value="Most In Last Month" name = "command">
                    </form>
                </div>
            </div>
        </div>

    </div>

    <div class="row table-of-game">

        <table class="table-game" id="table-game">

            <%
                List<product> products = (List<product>) request.getAttribute("products");
                if (products == null || products.isEmpty()) {
                    ProductsDAO productDAO = new ProductsDAO();
                    products = productDAO.getProducts();
                }

                for (product p : products) {
            %>
            <td class="game-cell">

                <div class="table-game-items">

                    <div class="img-items">
                        <img src="<%= request.getContextPath() + "/" + p.getProductImage().replace("C:\\Users\\Admin\\Documents\\Github\\SteamKarimasu\\web\\", "") %>" alt="">
                    </div>

                    <div class="table-more-infor-items">

                        <div class="infor-items">
                            <a href="" class="items-name"><%= p.getProductName() %></a>
                            <div class="date"><%= p.getDateOfUpdate() %></div>
                            <div class="more-infor">10 bought 5 retend</div>
                        </div>

                        <div class="item-price">
                            <%
                                if (p.getPrice() != 0){
                            %>
                            <a href="" class="table-game-for-buy">$<%= p.getPrice() %></a>
                            <%
                            } else {
                            %>
                            <a href="" class="table-game-for-buy">Free</a>
                            <%
                                }
                            %>

                        </div>

                    </div>

                </div>

            </td>

            <%
                }
            %>




        </table>

    </div>

</div>



<script>
    window.onload = function() {
        const gameTable = document.getElementById('table-game');

        // Lấy tất cả các ô game có trong bảng
        const gameCells = gameTable.querySelectorAll('.game-cell');

        let row;

        gameCells.forEach((cell, index) => {
            // Nếu chưa có hàng hoặc đã đủ 5 game trong hàng, tạo hàng mới
            if (index % 5 === 0) {
                row = document.createElement('tr');
                gameTable.appendChild(row);
            }
            // Thêm ô game vào hàng
            row.appendChild(cell);
        });
    };

    function toggleSortBy() {
        var sidebar = document.getElementById("sort-by-table");
        sidebar.classList.toggle("active");

        var arrow = document.querySelector("#sort-by .arrow");
        arrow.classList.toggle("rotated");
    }

</script>
</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>
