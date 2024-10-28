<%-- 
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
    <link rel="stylesheet" href="css/changePassPage.css">
</head>
<jsp:include page="" />
<body>
    
    <div id="changePassPage" class="container changePassPage">

        <div class="row profile">

            <div class="col-3 user-img">
                <img src="assets/img_profile_page/Blank_Rectangle.png" alt="">
            </div>

            <div class="col-9 user-infor">
                <table>
                    <tbody>
                        <tr class="name">
                            <td style="padding-right: 30px;">Name: </td>
                            <td>User123</td>
                        </tr>

                        <tr class="role">
                            <td>Role: </td>
                            <td>Pussy Slayer</td>
                        </tr>

                        <tr class="kcoins">
                            <td>Kcoins: </td>
                            <td>999.99</td>
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

                    <div class="user-old-password">
                        <div class="old-password">Old Password</div>
                        <input class="input-old-password" type="text" value="">
                    </div>

                    <div class="user-confirm-password">
                        <div class="confirm-password">Confirm Password</div>
                        <input class="input-comfirm-password" type="text" value="">
                    </div>

                    <div class="user-new-password">
                        <div class="new-password">New Password</div>
                        <input class="input-new-password" type="text" value="">
                    </div>

                </div>

            </div>

        </div>

    </div>

</body>
<%--<jsp:include page="mainFooterPage.jsp" />--%>
</html>