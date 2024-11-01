<%-- 
    Document   : depositPage
    Created on : Oct 24, 2024, 7:25:16 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script src="js/deposit.js"></script>

    </head>

    <jsp:include page="includes/navBarPage.jsp" />

    <body>

    <div id="depositPage" class="container depositPage">

        <div class="row">

            <div class="col-7 deposit-infor">


                <div class="deposit-infor-head">
                    <div class="deposit-qr">

                    </div>

                    <div class="accout-infor">
                        <div class="accout-number">
                            Account Number: 0921 386 9999
                        </div>

                        <div class="accout-bank">
                            Bank: Tpbank
                        </div>

                        <div class="accout-owner">
                            Owner: Nguyen Viet Nguyen
                        </div>

                        <div class="accout-content">
                            Content: <div>Desposit NameofUser</div>
                        </div>
                    </div>
                </div>


                <div class="deposit-more-infor">
                    <div class="exchange-rate"> $10,00 = 10,00 Kcoins </div>

                    <div class="waiting">Waiting 3-5 minutes for Admin check your payment </div>

                    <div class="takePhoto">
                        Please take a photo of the successful transfer to gmail: Knight2s@gmail.com
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

            <div class="col-4 deposit-history">
                
                <h1 class="deposit-history-title">Desposit History</h1>

                <div class="deposit-history-table">

                    <table>
                        <thead>
                            <tr>
                                <th>Amount</th>
                                <th>Time</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>huh</td>
                                <td>huh</td>
                            </tr>
                        </tbody>
                    </table>

                </div>

            </div>

        </div>

    </div>


</body>

<jsp:include page="includes/mainFooterPage.jsp" />
</html>
