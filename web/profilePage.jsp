<%@ page import="model.Entity.User" %><%--
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
<%--    <jsp:include page="" />--%>
    <body>
    
    <div id="profilePage" class="container profilePage">

        <div class="row profile">

            <div class="col-3 user-img">
                <img src="assets/img_profile_page/Blank_Rectangle.png" alt="">
            </div>
            <div class="col-9 user-infor">
                <table>
                    <tbody>
                        <tr class="name">
                            <td style="padding-right: 30px;">Name: </td>
                            <td></td>
                        </tr>

                        <tr class="role">
                            <td>Role: </td>
                            <td></td>
                        </tr>

                        <tr class="kcoins">
                            <td>Kcoins: </td>
                            <td></td>
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
                        <input class="input-email" type="text" value="" readonly>
                    </div>

                    <div class="user-phone">
                        <div class="email">Phone Number</div>
                        <input class="input-phone" type="text" value="" readonly>
                    </div>

                    <div class="user-date">
                        <div class="date">Date</div>
                        <input class="input-date" type="text" value="" readonly>
                    </div>

                </div>

            </div>

        </div>

    </div>

</body>
<%--<jsp:include page="mainFooterPage.jsp" />--%>
</html>
