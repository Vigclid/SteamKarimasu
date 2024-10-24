<%-- 
    Document   : mainFooterPage
    Created on : Oct 16, 2024, 11:31:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/mainFooterPage.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
        </script>
    </head>
    <body>
    <div class="container-s footter-card">
        <div class="footter-left">
                <div class="infor">
                    <div class="company-logo">
                        <img src="${pageContext.request.contextPath}/assets/img/mainPageLogo.png" alt="">
                    </div>
                    <div class="copy-right">
                        © 2024 Knight2s company, Inc. All Rights Reserved.
                    </div>
                </div>
                
            

            <div class="footer-right">

                <div class="contact-1">
                    <div class="about">
                        <a href="" class="items-about">
                            About
                        </a>
                        <a href="" class="items-shop">
                            Shop
                        </a>
                        <a href="" class="items-community">
                            Community
                        </a>
                        <a href="" class="items-help-center">
                            Help Center
                        </a>
                    </div>

                    <div class="border-high-light"></div>

                    <div class="social-network">
                        <a href="" class="network">
                            <img src="${pageContext.request.contextPath}/assets/img/instragmLogo.png" alt="">

                            <div>Instagram</div>
                        </a>

                        <a href="" class="network">
                            <img src="${pageContext.request.contextPath}/assets/img/twitterLogo.png" alt="">

                            <div>Twitter</div>
                        </a>

                        <a href="" class="network">
                            <img src="${pageContext.request.contextPath}/assets/img/youtubeLogo.png" alt="">

                            <div>Youtube</div>
                        </a>

                        <div class="orther-contact">
                            <a href="" class="contact-us">Contact Us</a>
                            <a href="" class="privacy-policy">Privacy Policy</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
