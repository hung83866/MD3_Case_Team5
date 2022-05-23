<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/21/2022
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>Jack Blogger</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- bootstrap css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- style css -->
    <link rel="stylesheet" href="css/style.css">
    <!-- Responsive-->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- fevicon -->
    <link rel="icon" href="images/fevicon.png" type="image/gif"/>
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
    <!-- Tweaks for older IEs-->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!-- body -->
<body class="main-layout">
<!-- loader  -->
<!-- end loader -->
<!-- header -->
<header>
    <!-- header inner -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3 logo_section">
                <div class="full">
                    <div class="center-desk">
                        <div class="logo"><a href="index.html"><img
                                src="images/Trắng%20và%20Xám%20Vòng%20nguyệt%20quế%20Hipster%20Logo.png"
                                style="height: 100px;width:100px;border-radius: 12%" alt="#"></a></div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="menu-area">
                    <div class="limit-box">
                        <nav class="main-menu">
                            <ul class="menu-area-main">
                                <!--                              <li class="active">-->
                                <!--                                 <a href="index.html">ADMIN</a>-->
                                <!--                              </li>-->
                                <li>
                                    <a href="/UserServlet?action=userlist">USER</a>
                                </li>
                                <li>
                                    <a href="/UserServlet?action=adminBlog">BLOG</a>
                                </li>
                                <li>
                                    <a href="/UserServlet?action=logout?">LOG OUT</a>
                                </li>
                                <li>
                                    <form action="/UserServlet?action=search">
                                        <input type="text" id="search" name="search" placeholder="Search..">
                                    </form>
                                </li>
                                <li>
                                    <a href="#"><img src="images/search_icon.png" alt="#"/></a>
                                </li>

                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<div style="background-image: url('/images/img4.webp')" class="section layout_padding">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="heading">
                    <h3>User <span class="orange_color">List</span></h3>
                </div>
            </div>
        </div>
        <c:forEach items="${users}" var="users">
            <div style="background-image: url('/images/im3.webp')" class="row">
                <div class="col-md-6">
                    <img style="height: 200px;border-radius: 50%" src=${users.img} alt="#"/>
                </div>
                <div class="col-md-6">
                    <div class=" full blog_cont">
                        <h4 style="text-align: center;font-family: 'Arial Rounded MT Bold'">${users.firstname} ${users.lastname}</h4>
                        <h2>username : ${users.userName}</h2>
                        <div class=" button_section">
                            <a STYLE="background: #184091;border-radius: 5%" href="/UserServlet?action=myblog&id=${users.id}">VIEW</a>
                            <a style="background: #184091;border-radius: 5%" href="/UserServlet?action=profile&id=${users.id}">PROFILE</a>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <br>
        </c:forEach>
    </div>
</div>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-md-6">
                <div class="footer_links">
                    <a href="index.html"><img src="images/Trắng%20và%20Xám%20Vòng%20nguyệt%20quế%20Hipster%20Logo.png" style="height: 100px;width:100px;border-radius: 12%" alt="#" /></a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <ul class="contact_information">
                    <li><span><img src="images/location_icon.png" alt="#" /></span><span class="text_cont">CodeGym<br>Ha Noi City</span></li>
                    <li><span><img src="images/phone_icon.png" alt="#" /></span><span class="text_cont">0814 229 299<br>0888 886 688</span></li>
                    <li><span><img src="images/mail_icon.png" alt="#" /></span><span class="text_cont">hungdz@codegym.com<br>binhdz@codegym.com</span></li>
                </ul>
                <ul class="social_icon">
                    <li><a href="https://www.facebook.com/buihaibinh.94.bui"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                </ul>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer_links">
                    <h3>Contact us</h3>
                    <form action="index.html">
                        <fieldset>
                            <div class="field">
                                <input type="text" name="name" placeholder="Your Name" required="" />
                            </div>
                            <div class="field">
                                <input type="email" name="email" placeholder="Email" required="" />
                            </div>
                            <div class="field">
                                <input type="text" name="subject" placeholder="Subject" required="" />
                            </div>
                            <div class="field">
                                <textarea placeholder="Message"></textarea>
                            </div>
                            <div class="field">
                                <div class="center">
                                    <button class="reply_bt">Send</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</footer>

<!-- end footer -->
<!-- Javascript files-->
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.0.0.min.js"></script>
<script src="js/plugin.js"></script>
<!-- Scrollbar Js Files -->
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="js/custom.js"></script>
</body>
</html>
