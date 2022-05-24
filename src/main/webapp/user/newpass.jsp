<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
    <title></title>
    <style>
        html,body { height: 100%; }
        body{
            display: -ms-flexbox;
            display: -webkit-box;
            display: flex;
            -ms-flex-align: center;
            -ms-flex-pack: center;
            -webkit-box-align: center;
            align-items: center;
            -webkit-box-pack: center;
            justify-content: center;
            background-color: #f5f5f5;
        }
        form{
            padding-top: 10px;
            font-size: 13px;
            margin-top: 30px;
        }

        .card-title{ font-weight:300; }

        .btn{
            font-size: 13px;
        }

        .login-form{
            width:320px;
            margin:20px;
        }

        .sign-up{
            text-align:center;
            padding:20px 0 0;
        }

        span{
            font-size:14px;
        }

        .submit-btn{
            margin-top:20px;
        }
    </style>
</head>
<body>
<div class="card login-form">
    <div class="card-body">
        <h2 style="color:red;">${mes}</h2>
        <h3 class="card-title text-center">Change password</h3>
        <div class="card-text">
            <form method="post">
                <div class="form-group">
                    <label>Old password</label>
                    <input type="password" name="oldpassword" class="form-control form-control-sm">
                </div>
                <div class="form-group">
                    <label>Your new password</label>
                    <input type="password" name="newpassword" class="form-control form-control-sm">
                </div>
                <div class="form-group">
                    <label>Repeat password</label>
                    <input type="password" name="repassword" class="form-control form-control-sm">
                </div>
                <button type="submit" class="btn btn-primary btn-block submit-btn">Confirm</button>
            </form>
            <a href="">COME BACK HOME  BLOG</a>
        </div>
    </div>
</div>
</body>
</html>
