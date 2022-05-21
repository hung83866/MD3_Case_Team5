<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/21/2022
  Time: 2:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="icon" href="images/fevicon.png" type="image/gif" />
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
<a href="/UserServlet?action=editUser&id=${id}"></a>
<!-- end loader -->
<!-- header -->
<header>
    <!-- header inner -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3 logo_section">
                <div class="full">
                    <div class="center-desk">
                        <div class="logo"> <a href="index.html"><img src="images/Trắng%20và%20Xám%20Vòng%20nguyệt%20quế%20Hipster%20Logo.png" style="height: 100px;width:100px;border-radius: 12%" alt="#"></a> </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="menu-area">
                    <div class="limit-box">
                        <nav class="main-menu">
                            <ul class="menu-area-main">
                                <li class="active">
                                    <a href="index.html">MyBlog</a>
                                </li>
                                <li>
                                    <a href="about.html">New Blog</a>
                                </li>
                                <li>
                                    <a href="blog.html">Edit Blog</a>
                                </li>
                                <li>
                                    <a href="contact.html">Delete</a>
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
<!-- end header -->
<!-- revolution slider -->
<div class="banner-slider">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-7">
                <div id="slider_main" class="carousel slide" data-ride="carousel">
                    <!-- The slideshow -->
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="images/slider_1.png" alt="#" />
                        </div>
                        <div class="carousel-item">
                            <img src="images/slider_1.png" alt="#" />
                        </div>
                    </div>
                    <!-- Left and right controls -->
                    <a class="carousel-control-prev" href="#slider_main" data-slide="prev">
                        <i class="fa fa-angle-left" aria-hidden="true"></i>
                    </a>
                    <a class="carousel-control-next" href="#slider_main" data-slide="next">
                        <i class="fa fa-angle-right" aria-hidden="true"></i>
                    </a>
                </div>
            </div>
            <div class="col-md-5">
                <div class="full slider_cont_section">
                    <h4>More Featured in</h4>
                    <h3>Jack Blogger</h3>
                    <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look</p>
                    <div class="button_section">
                        <a href="about.html">Read More</a>
                        <a href="contact.html">Contact Us</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end revolution slider -->
<!-- section -->
<div class="section layout_padding">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="heading">
                    <h3>About <span class="orange_color">Us</span></h3>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <img src="images/blog1.png" alt="#" />
            </div>
            <div class="col-md-6">
                <div class="full blog_cont">
                    <h4>The biggest and most awesome camera  of  year</h4>
                    <h5>MAY 14 2019 5 READ</h5>
                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.</p>
                </div>
            </div>
        </div>
        <div class="row margin_top_30">
            <div class="col-md-6">
                <img src="images/blog2.png" alt="#" />
            </div>
            <div class="col-md-6">
                <div class="full blog_cont">
                    <h4>What 3 years of android taught me the hard way</h4>
                    <h5>MAY 19 2019  5 READ</h5>
                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.</p>
                </div>
            </div>
        </div>
        <div class="row margin_top_30">
            <div class="col-md-12">
                <div class="button_section full center margin_top_30">
                    <a style="margin:0;" href="about.html">Read More</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end section -->
<!-- section -->
<div class="section layout_padding dark_bg">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="heading">
                    <h3>Marketing</h3>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <img src="images/marketing_img.png" alt="#" />
            </div>
            <div class="col-md-6">
                <div class="full blog_cont">
                    <h3 class="white_font">Where can I get some</h3>
                    <h5 class="grey_font">March 19 2019 5 READ</h5>
                    <p class="white_font">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined g to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator..</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end section -->
<!-- section -->
<section class="layout_padding">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="heading" style="padding-left: 15px;padding-right: 15px;">
                    <h4 style="border-bottom: solid #333 1px;">Comments / 2</h4>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="full comment_blog_line">
                    <div class="row">
                        <div class="col-md-1">
                            <img src="images/c_1.png" alt="#" />
                        </div>
                        <div class="col-md-9">
                            <div class="full contact_text">
                                <h3>Veniam</h3>
                                <h4>Posted on Jan 10 / 2017 at 06:53 am</h4>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet
                                    dolore magna aliquam erat volutpat.
                                </p>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <a class="reply_bt" href="#">Reply</a>
                        </div>
                    </div>
                </div>
                <div class="full comment_blog_line">
                    <div class="row">
                        <div class="col-md-1">
                            <img src="images/c_2.png" alt="#" />
                        </div>
                        <div class="col-md-9">
                            <div class="full contact_text">
                                <h3>Jack</h3>
                                <h4>Posted on Jan 10 / 2017 at 06:53 am</h4>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet
                                    dolore magna aliquam erat volutpat.
                                </p>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <a class="reply_bt" href="#">Reply</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row margin_top_30">
            <div class="col-md-12 margin_top_30">
                <div class="heading" style="padding-left: 15px;padding-right: 15px;">
                    <h4>Post : Your Comment</h4>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="full comment_form">
                    <form action="index.html">
                        <fieldset>
                            <div class="col-md-12">
                                <div class="row">
                                    <div class="col-md-6">
                                        <input type="text" name="name" placeholder="Name" required="#" />
                                        <input type="email" name="email" placeholder="Email" required="#" />
                                    </div>
                                    <div class="col-md-6">
                                        <textarea placeholder="Comment"></textarea>
                                    </div>
                                </div>
                                <div class="row margin_top_30">
                                    <div class="col-md-12">
                                        <div class="center">
                                            <button>Send</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end section -->
<!-- section -->
<div class="section layout_padding blog_blue_bg light_silver">
    <div class="container">
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="heading">
                    <h3>Blog</h3>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="full">
                    <div class="big_blog">
                        <img class="img-responsive" src="images/blog_1.png" alt="#" />
                    </div>
                    <div class="blog_cont_2">
                        <h3>Why do we use it</h3>
                        <p class="sublittle">March 19 2019  5 READ</p>
                        <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters as opposed to using Content here content here making..</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end section -->
<!-- footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <a href="#"><img src="images/footer_logo.png" alt="#" /></a>
                <ul class="contact_information">
                    <li><span><img src="images/location_icon.png" alt="#" /></span><span class="text_cont">London 145<br>United Kingdom</span></li>
                    <li><span><img src="images/phone_icon.png" alt="#" /></span><span class="text_cont">987 654 3210<br>987 654 3210</span></li>
                    <li><span><img src="images/mail_icon.png" alt="#" /></span><span class="text_cont">demo@gmail.com<br>support@gmail.com</span></li>
                </ul>
                <ul class="social_icon">
                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                </ul>
            </div>
            <div class="col-lg-2 col-md-6">
                <div class="footer_links">
                    <h3>Quick link</h3>
                    <ul>
                        <li><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i> Home</a></li>
                        <li><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i> Features</a></li>
                        <li><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i> Evens</a></li>
                        <li><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i> Markrting</a></li>
                        <li><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i> Blog</a></li>
                        <li><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i> Testimonial</a></li>
                        <li><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i> Contact</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer_links">
                    <h3>Instagram</h3>
                    <ol>
                        <li><img class="img-responsive" src="images/footer_blog.png" alt="#" /></li>
                        <li><img class="img-responsive" src="images/footer_blog.png" alt="#" /></li>
                        <li><img class="img-responsive" src="images/footer_blog.png" alt="#" /></li>
                        <li><img class="img-responsive" src="images/footer_blog.png" alt="#" /></li>
                    </ol>
                </div>
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