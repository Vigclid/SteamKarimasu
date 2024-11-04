<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oops</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/includes/error_page/css_error_page/error.css">
</head>
<body>
<div class="error-container">
    <h1>Oops! error 404</h1>
    <p>Maybe you don't have this 😥</p>
    <p>Click here, let's make it again.</p>
    <form action="${pageContext.request.contextPath}/mainPage.jsp">
        <input type="submit" value="Return to main page">
    </form>
</div>
</body>
</html>