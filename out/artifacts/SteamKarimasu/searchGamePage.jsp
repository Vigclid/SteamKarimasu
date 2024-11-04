<%@ page import="model.Entity.product" %>
<%@ page import="java.util.List" %>
<%@ page import="repository.impl.ProductRepositoryImpl" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/css/searchGamePage.css">
</head>
<body>
<jsp:include page="includes/navBarPage.jsp" />
<div class="container searchGamePage" id="searchGamePage">
    <div class="row">
        <div class="col search-game">
            <div class="search-bar-div">
                <input class="search-bar" type="text" name="name-search" id="searchInput" placeholder="Search..."
                       onclick="showSearchItems()" oninput="filterSearchItems()">
                <img class="search-icon" src="assets/img/searchIcon.png" alt="">
            </div>

            <%
                String name = request.getParameter("name-search");
                if (name != null) {
                    name = name.trim(); // Loại bỏ khoảng trắng ở đầu và cuối
                    if (!name.isEmpty()) {
                        product matchedProduct = new ProductRepositoryImpl().findProductByName(name);
                        if (matchedProduct != null) {
                            request.setAttribute("name-search", matchedProduct.getProductName());
                            request.getRequestDispatcher("profilePage.jsp").forward(request, response);
                            return;
                        }
                    }
                }

                List<product> products = new ProductRepositoryImpl().ListProduct();
                if (products.isEmpty()) {
            %>
            <div class="alert alert-warning">Không có sản phẩm nào được tìm thấy.</div>
            <%
                }
            %>

            <div id="search-list-table" class="search-list-table">
                <table class="search-items">
                    <tbody>
                    <% for (product product : products) { %>
                    <tr>
                        <td>
                            <div class="search-items-img">
                                <img src="assets/img/<%= product.getProductImage() %>" alt="<%= product.getProductName() %>">
                            </div>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/editGamePage.jsp?id=<%=product.getProductId()%>">
                                <input type="hidden" value="<%= product.getProductId() %>" name="" id="" class="">
                                <input type="submit" value="<%= product.getProductName() %>">
                            </a>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="js/searchGamePage.js">
</script>
<jsp:include page="includes/mainFooterPage.jsp" />
</body>
</html>