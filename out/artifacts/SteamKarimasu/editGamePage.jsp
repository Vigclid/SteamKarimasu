<%@ page import="model.Entity.product" %>
<%@ page import="repository.impl.ProductRepositoryImpl" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Game Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/css/editGamePage.css">
</head>

<jsp:include page="includes/navBarPage.jsp" />
<body>
<div id="editGamePage" class="container-s editGamePage">
    <form method="post" action="EditGame">
        <div class="row">
            <div class="col-3 add-edit-game" style="margin-left: 20px">
                <a class="add-game-button" type="submit" value="Add Game" style="color:white; cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/addGamePage.jsp"> Add Game</a>
                <a class="search-game-button" type="submit" value="Edit Game" style="color: white; cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href="${pageContext.request.contextPath}/searchGamePage.jsp"> Search Game</a>
                <a class="edit-game-button" type="submit" value="Edit Game" style="color: rgb(109, 174, 21); cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;" href=""> Edit Game</a>
            </div>

            <%
                int id = Integer.parseInt(request.getParameter("id"));
                product product = new ProductRepositoryImpl().findProductById(id);
                if (product == null) {
                    response.sendRedirect("searchGamePage.jsp");
                    return;
                } else {
            %>

            <div class="col-8 edit-game-table">
                <div class="rent-infor">
                    <a class="game-information">Game's Information</a>

                    <a href="rentOutListPage.jsp?id=<%= product.getProductId() %>" class="rent-out-list" >
                        Rent Out List
                    </a>
                </div>

                <input type="hidden" name="id" value="<%= product.getProductId() %>">
                <div class="edit-game-name">
                    <div class="game-name">Game's Name</div>
                    <input class="input-game-name" type="text" value="<%= product.getProductName() %>" name="game-name" placeholder="Game's Name" required>
                </div>

                <div class="edit-game-img">
                    <div class="game-img">Game's Image</div>

                    <div class="upload-box" id="uploadBox">
                        <!-- Đặt src của ảnh về mặc định là "none" để ẩn hình ảnh khi chưa có file -->
                        <input class="plus-button" id="mainPlusButton" style="width: 50px; height: 50px;">
                        <input type="file" id="mainFileInput" accept="image/*" name="file-img" multiple>
                        <img id="mainPreviewImage" class="game-img" src="#"  width="620px" height="380px%" />
                    </div>

                </div>

                <div class="edit-game-description">
                    <div class="game-description">Game's Description</div>
                    <textarea class="input-game-description" name="game-description" placeholder="Game's Description" required><%= product.getProdcuctDescription() %></textarea>
                </div>

                <div class="edit-game-down-link">
                    <div class="game-down-link">Game's Download Link</div>
                    <input class="input-game-down-link" type="text" value="<%= product.getLinkKeyGame() %>" name="game-link" placeholder="Game's Download Link" required>
                </div>

                <div class="edit-game-price">
                    <div class="game-price">Price Buy</div>
                    <input class="input-game-price" type="text" value="<%= product.getPrice() %>" name="game-price" placeholder="Price" required>
                </div>

                <div class="confirm-edit-game">
                    <form method="post" action="EditGame">
                        <input type="hidden" name="productId" value="<%= product.getProductId() %>">
                        <input type="hidden" name="action" id="action" value="EDIT">

                        <button type="submit" onclick="document.getElementById('action').value='EDIT'" class="confirm-edit">Confirm</button>
                        <button type="submit" onclick="document.getElementById('action').value='DELETE'" class="delete-edit">Delete</button>
                    </form>
                </div>

                <% } %>
            </div>
        </div>
    </form>
</div>
<script>
    // Lắng nghe sự kiện thay đổi khi người dùng chọn file
    document.getElementById("mainFileInput").addEventListener("change", function(event) {
        const file = event.target.files[0];
        const previewImage = document.getElementById("mainPreviewImage");

        if (file) {
            // Tạo URL để hiển thị ảnh xem trước
            const reader = new FileReader();
            reader.onload = function(e) {
                previewImage.src = e.target.result;
                previewImage.style.display = "block"; // Hiển thị hình ảnh khi đã chọn file
            };
            reader.readAsDataURL(file);
        } else {
            // Ẩn hình ảnh xem trước nếu không có file nào được chọn
            previewImage.style.display = "none";
            previewImage.src = "#";
        }
    });
</script>


<script src="js/editGamePage.js"></script>
</body>
<jsp:include page="includes/mainFooterPage.jsp" />

</html>