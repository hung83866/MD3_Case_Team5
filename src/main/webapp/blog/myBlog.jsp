<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/21/2022
  Time: 2:02 AM
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
    <title>Blog HBT</title>
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
    <link rel="icon" href="/images/Trắng%20và%20Xám%20Vòng%20nguyệt%20quế%20Hipster%20Logo.png" type="image/gif" />
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
                        <div class="logo"> <a href="/UserServlet?action=n&id=${id}"><img src="images/Trắng%20và%20Xám%20Vòng%20nguyệt%20quế%20Hipster%20Logo.png" style="height: 100px;width:100px;border-radius: 12%" alt="#"></a> </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="menu-area">
                    <div class="limit-box">
                        <nav class="main-menu">
                            <ul class="menu-area-main">
                                <li class="active">
                                    <a href="/UserServlet?action=n&id=${id}">home</a>
                                </li>
                                <li class="active">
                                    <a href="/UserServlet?action=myblog&id=${id}">MyBlog</a>
                                </li>
                                <li>
                                    <a href="/UserServlet?action=profile&id=${id} ">profile</a>
                                </li>
                                <li>
                                    <a href="/UserServlet?action=logout">Log out</a>
                                </li>
                                <li>
                                    <form>
                                        <input type="text" name="search" placeholder="Search..">
                                    </form>
                                </li>
                                <li>
                                    <a href="/UserServlet?action=search"><img src="images/search_icon.png" alt="#" /></a>
                                </li>

                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end header inner -->
</header>
<div class="button_section">
    <a STYLE=" margin-top:20px;float : right; background: #abdde5" href="/BlogServlet?action=create&id=${id}">NEW BLOG</a>
</div>
<div class="section layout_padding">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="heading">
                    <h3> My <span class="orange_color">Blog</span></h3>
                </div>
            </div>
        </div>
        <c:forEach items="${blogs}" var="blogs">
        <div class="row">
            <div class="col-md-6">
                <img src="${blogs.img}" alt="#" />
            </div>
            <div class="col-md-6">
                <div class="full blog_cont">
                    <h4>${blogs.title}</h4>
                    <h5>${blogs.date}</h5>
<%--                    <p>${blogs.role}</p>--%>
                    <div class="button_section">
                        <a STYLE="background: #1e7e34" href="/BlogServlet?action=view&id=${id}">VIEW</a>
                        <a STYLE="background: #117a8b" href="/BlogServlet?action=edit1&id=${id}">EDIT</a>
                        <a STYLE="background: #1d2124 "  href="/BlogServlet?action=delete&id=${id}">DELETE</a>
                    </div>
                </div>
            </div>
        </div>
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
<div class="cpy">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p>Copyright © 2019 Design by <a href="https://html.design/">Free Html Templates</a></p>
            </div>
        </div>
    </div>
</div>
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