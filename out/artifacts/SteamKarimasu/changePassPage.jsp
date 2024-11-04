<%@ page import="model.Entity.user" %>
<%@ page import="common.LoginSession" %>
<%@ page import="repository.impl.RoleRepositoryImpl" %>
<%@ page import="repository.impl.UserRoleRepositoryImpl" %><%--
    Document   : changePassPage
    Created on : Oct 25, 2024, 9:00:25 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <%--    <link rel="stylesheet" href="bootstrap-5.3.3-dist/css/bootstrap.css">--%>
    <link rel="stylesheet" href="styles/css/changePassPage.css">
</head>
<jsp:include page="includes/navBarPage.jsp" />
<body>
<form action="ChangePass" method="post">
    <div id="changePassPage" class="container changePassPage">

        <div class="row profile">

            <div class="col-3 user-img">
                <img src="assets/img_profile_page/Blank_Rectangle.png" alt="">
            </div>

            <div class="col-9 user-infor">
                <table>
                    <%
                        UserRoleRepositoryImpl userRoleRepository = new UserRoleRepositoryImpl();
                        RoleRepositoryImpl roleRepository = new RoleRepositoryImpl();
                        user user = new LoginSession().getLoginSession(request);
                        int userRole = userRoleRepository.findRoleIdbyUserId(user.getUserId());
                        String roleName = roleRepository.findRoleById(userRole);
                    %>
                    <tbody>
                    <tr class="name">
                        <td style="padding-right: 30px;">Name: </td>
                        <td><%= user.getUsername()%></td>
                    </tr>

                    <tr class="role">
                        <td>Role: </td>
                        <td><%= roleName%></td>
                    </tr>

                    <tr class="kcoins">
                        <td>Kcoins: </td>
                        <td><%= user.getTotalAmount()%></td>
                    </tr>
                    </tbody>
                </table>

            </div>

        </div>

        <div class="row user-function">

            <div class="col-3 user-contact">

                <div class="main-information">
                    <a class="input-profile" href="${pageContext.request.contextPath}/profilePage.jsp" style="color: white; cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;"> Main Information</a>
                </div>

                <div class="change-password">
                    <a class="input-changePass" href="${pageContext.request.contextPath}/changePassPage.jsp" style="color: rgb(109, 174, 21);; cursor: pointer;text-decoration: none;font-size: 30px;margin-top: 10px;"> Change Password </a>
                </div>

            </div>

            <div class="col-9 user-more-infor">

                <div class="infor-items">

                    <div class="user-old-password">
                        <div class="old-password">Old Password</div>
                        <input class="input-old-password" type="password" style="color: white;"value="" name="old-password">
                    </div>

                    <div class="user-confirm-password">
                        <div class="confirm-password">Confirm Password</div>
                        <input class="input-comfirm-password" type="password" style="color: white;"value="", name="new-password">
                    </div>

                    <div class="user-new-password">
                        <div class="new-password">New Password</div>
                        <input class="input-new-password" type="password" style="color: white;" value="" name="confirm-password">
                    </div>

                </div>
            </div>
            <input id="conform-button" type="submit" value="CONFIRM">
        </div>

    </div>
</form>
</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>