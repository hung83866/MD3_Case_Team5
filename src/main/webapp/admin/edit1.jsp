
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

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
    <title>Edit User</title>
    <link rel="stylesheet" href="css/edit.css">
    <style>
        body{margin-top:20px;
            background-color:#f2f6fc;
            color:#69707a;
        }
        .img-account-profile {
            height: 10rem;
        }
        .rounded-circle {
            border-radius: 50% !important;
        }
        .card {
            box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);
        }
        .card .card-header {
            font-weight: 500;
        }
        .card-header:first-child {
            border-radius: 0.35rem 0.35rem 0 0;
        }
        .card-header {
            padding: 1rem 1.35rem;
            margin-bottom: 0;
            background-color: rgba(33, 40, 50, 0.03);
            border-bottom: 1px solid rgba(33, 40, 50, 0.125);
        }
        .form-control, .dataTable-input {
            display: block;
            width: 100%;
            padding: 0.875rem 1.125rem;
            font-size: 0.875rem;
            font-weight: 400;
            line-height: 1;
            color: #69707a;
            background-color: #fff;
            background-clip: padding-box;
            border: 1px solid #c5ccd6;
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
            border-radius: 0.35rem;
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
        }

        .nav-borders .nav-link.active {
            color: #0061f2;
            border-bottom-color: #0061f2;
        }
        .nav-borders .nav-link {
            color: #69707a;
            border-bottom-width: 0.125rem;
            border-bottom-style: solid;
            border-bottom-color: transparent;
            padding-top: 0.5rem;
            padding-bottom: 0.5rem;
            padding-left: 0;
            padding-right: 0;
            margin-left: 1rem;
            margin-right: 1rem;
        }
    </style>
</head>
<body>
<header>
    <!-- header inner -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3 logo_section">
                <div class="full">
                    <div class="center-desk">
                        <div class="logo"> <a href="/UserServlet?action=userlist"><img src="images/Trắng%20và%20Xám%20Vòng%20nguyệt%20quế%20Hipster%20Logo.png" style="height: 100px;width:100px;border-radius: 12%" alt="#"></a> </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="menu-area">
                    <div class="limit-box">
                        <nav class="main-menu">
                            <ul class="menu-area-main">
                                <li>
                                    <a href="/UserServlet?action=userlist">USER</a>
                                </li>
                                <li>
                                    <a href="/UserServlet?action=adminBlog">BLOG</a>
                                </li>
                                <li>
                                    <a href="/UserServlet?action=logout">Log out</a>
                                </li>
                                <li>
                                    <form method="post" action="UserServlet?action=search">
                                        <input type="text" name="name" placeholder="Search user by name..">
                                        <button><img style="background: #1d2124 ;border: solid" src="images/search_icon.png" alt="#"/></button>
                                    </form>
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
<div class="container-xl px-4 mt-4">
    <hr class="mt-0 mb-4">
    <div class="row">
        <div class="col-xl-4">
            <!-- Profile picture card-->
            <div class="card mb-4 mb-xl-0">
                <div class="card-header">Profile Picture</div>
                <div class="card-body text-center">
                    <!-- Profile picture image-->
                    <img class="img-account-profile rounded-circle mb-2" src="${user.img}" alt="">
                    <!-- Profile picture help block-->
                    <div class="small font-italic text-muted mb-4"><h4>${user.firstname} ${user.lastname}</h4></div>

                    <div class="small font-italic text-muted mb-4">${user.userName}</div>
                    <!-- Profile picture upload button-->
                    <a href="https://google.com/" target="_blank">Avatar update</a>
                    <a href="/UserServlet?action=newpass1&id=${user.id}">Password update</a>
                </div>
            </div>
        </div>
        <form method="post"></form>
        <div class="col-xl-8">
            <div class="card mb-4">
                <div class="card-header">Account Details</div>
                <div class="card-body">
                    <form method="post">
                        <h2 style="color:red;">${mes}</h2>
                        <h2 style="color:red;">${mes1}</h2>
                        <div class="mb-3">
                            <label class="small mb-1" for="img">Image</label>
                            <input class="form-control" id="img"  name="img" placeholder="image" value="${user.img}">
                        </div>
                        <div class="mb-3">
                            <label class="small mb-1" for="inputEmail">Email</label>
                            <input class="form-control" id="inputEmail" type="email" name="email" placeholder="Enter your Email" value="${user.email}">
                        </div>
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="firstname">First name</label>
                                <input class="form-control" id="firstname" type="text" name="firstname" placeholder="Enter your first name" value="${user.firstname}">
                            </div>
                            <!-- Form Group (last name)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="lastname">Last name</label>
                                <input class="form-control" id="lastname" type="text" name="lastname" placeholder="Enter your last name" value="${user.lastname}">
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="small mb-1">Address</label>
                            <input class="form-control" id="address" type="address" name="address" placeholder="Enter your  address" value="${user.address}">
                        </div>
                        <!-- Form Row-->
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (phone number)-->
                            <div class="col-md-6">
                                <label class="small mb-1" >Phone number</label>
                                <input class="form-control" id="telephonenumber" type="tel" name="telephonenumber" placeholder="Enter your phone number" value="${user.telephoneNumber}">
                            </div>
                        </div>
                        <!-- Save changes button-->
                        <button class="btn btn-primary">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
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
</body>
</html>

