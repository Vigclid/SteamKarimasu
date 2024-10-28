<%@ page import="model.Entity.User" %>
<%@ page import="model.repository.impl.userRepositoryimpl" %>
<%@ page import="model.repository.impl.userRoleRepositoryImpl" %>>
<%@ page import="model.repository.impl.roleRepositoryImpl" %>>
<%--
    Document   : profilePage
    Created on : Oct 25, 2024, 8:09:29 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="bootstrap-5.3.3-dist/css/bootstrap.css">
        <link rel="stylesheet" href="css/profilePage.css">
        <base href="/web/">      
    </head>
    <jsp:include page="includes/navBarPage.jsp" />
    <body>
    
    <div id="profilePage" class="container profilePage">

        <div class="row profile">

            <div class="col-3 user-img">
                <img src="assets/img/black-myth-wukong.png" alt="">
            </div>
            <div class="col-9 user-infor">
                <table>
                    <% HttpSession httpSession = request.getSession(false);
                    if (httpSession != null) {
                        userRoleRepositoryImpl userRoleRepository = new userRoleRepositoryImpl();
                        roleRepositoryImpl roleRepository = new roleRepositoryImpl();
                        Object userName = httpSession.getAttribute("username");
                        userRepositoryimpl repositoryimpl = new userRepositoryimpl();
                        User user = repositoryimpl.findUserbyName((String) userName);
                        int userRole = userRoleRepository.findRoleIdbyUserId(user.getUserid());
                        String roleName = roleRepository.findRoleById(userRole);

                    %>
                    <tbody>
                        <tr class="name">
                            <td>Name: </td>
                            <td><%= user.getUsername() %></td>
                        </tr>

                        <tr class="role">
                            <td>Role: </td>
                            <td><%= roleName %></td>
                        </tr>

                        <tr class="kcoins">
                            <td>Kcoins: </td>
                            <td> <%= user.getTotalAmount()%> </td>
                        </tr>
                    </tbody>
                </table>
                
            </div>

        </div>

        <div class="row user-function">
            
            <div class="col-3 user-contact">

                <div class="main-information">
                    <input type="submit" value="Main Information" class="" id="" name="">
                </div>
    
                <div class="change-password">
                    <input type="submit" value="Change Password" class="" id="" name="">
                </div>

            </div>

            <div class="col-9 user-more-infor">

                <div class="infor-items">

                    <div class="user-email">
                        <div class="email">Email</div>
                        <input class="input-email" type="text" value="<%=user.getEmail() %>" readonly>
                    </div>

                    <div class="user-phone">
                        <div class="email">Phone Number</div>
                        <input class="input-phone" type="text" value="<%=user.getPhonenumber()%>" readonly>
                    </div>

                    <div class="user-date">
                        <div class="date">Date</div>
                        <input class="input-date" type="text" value="<%=user.getDob()%>" readonly>
                    </div>
                    <%}%>
                </div>

            </div>

        </div>

    </div>

</body>
<jsp:include page="includes/mainFooterPage.jsp" />
</html>
