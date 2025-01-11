<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="common.LoginSession" %>
<%@ page import="model.Entity.user" %>
<%@ page import="model.Entity.CoinBill" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="repository.impl.CoinBillRepositoryImpl" %><%--
    Document   : depositPage
    Created on : Oct 24, 2024, 7:25:16 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Tạo đối tượng LoginSession và lấy username từ session
    LoginSession loginSession = new LoginSession();
    user loggedInUser = loginSession.getLoginSession(request);
    String username = (loggedInUser != null) ? loggedInUser.getUsername() : "Guest";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
        </script>
        <link rel="stylesheet" href="styles/css/depositPage.css">
        <script>
                window.username = "<%= username%>"
        </script>
        <script src="js/deposit.js">
        </script>
    </head>

    
    <jsp:include page="includes/navBarPage.jsp" />
<body>

    <div id="depositPage" class="container depositPage">

        <div class="row">

            <div class="col-8 deposit-infor">


                <div class="deposit-infor-head">
                    <div class="deposit-qr">

                    </div>



                    <div class="banking">

                        <div class="bank-options">
                            <table class="options">
                                <tbody>

                                    <tr>
                                        <td><input type="submit" id="btn1" value=""></td>
                                        <td><input type="submit" id="btn2" value=""></td>
                                        <td><input type="submit" id="btn3" value=""></td>
                                    </tr>
                                    <tr>
                                        <td><input type="submit" id="btn4" value=""></td>
                                        <td><input type="submit" id="btn5" value=""></td>
                                        <td><input type="submit" id="btn6" value=""></td>
                                    </tr>
    
                                </tbody>
                            </table>
                        </div>

                        <div class="amount">
                            <p id="amountDispay"></p>
                        </div>
                    </div>
                </div>
                <div id="countdown"></div>

                <div class="deposit-more-infor">
                    <div class="exchange-rate"> $10,00 = 10,00 Kcoins </div>

                    <div class="waiting">Waiting 10-15 seconds after sent the money for service check your payment </div>

                    <div class="takePhoto">
                        If you have problem, please take a photo of the successful transfer to gmail: Knight2s@gmail.com
                        so that the admin can confirm and add the money to you
                    </div>

                    <div class="Announcement">Announcement: 
                        <div>
                        Make sure the transfer content matches the requested
                        information
                        </div>
                    </div>
                </div>


            </div>

            <div class="col-3 deposit-history">
                
                <h1 class="deposit-history-title">Desposit History</h1>

                <div class="deposit-history-table">
                    <%
                        List<CoinBill> coinBills = new ArrayList<>();
                        try {
                            coinBills = new CoinBillRepositoryImpl().getDepositHistory(new LoginSession().getLoginSession(request).getUserId());
                        }
                        catch (NullPointerException e){
                            coinBills = new ArrayList<>();
                        }


                        request.setAttribute("DepositHistory", coinBills);
                    %>

                    <table>
                        <thead>
                            <tr>
                                <th>Amount</th>
                                <th>Time</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="deposit" items="${DepositHistory}">
                            <tr>
                                <td>${deposit.currency}</td>
                                <td>${deposit.dateOfCrate}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>

            </div>

        </div>

    </div>

    <form id="myForm" action="KcoinServlet" method="POST">
        <input type="hidden" name="MaGiaoDich" id="MaGiaoDich" />
        <input type="hidden" name="amount" id="amount" />
        <button type="submit" style="display:none;">Submit</button>
    </form>

</body>
    <jsp:include page="includes/mainFooterPage.jsp" />
</html>
