<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>
<!-- Section: Design Block -->
<section class="text-center text-lg-start">
    <style>
        .cascading-right {
            margin-right: -50px;
        }

        @media (max-width: 991.98px) {
            .cascading-right {
                margin-right: 0;
            }
        }
    </style>

    <!-- Jumbotron -->
    <div class="container py-4">
        <div class="row g-0 align-items-center">
            <div class="col-lg-6 mb-5 mb-lg-0">
                <div class="card cascading-right" style="
           background: hsla(266,70%,100%,0.78%);
            backdrop-filter: blur(30px);

            ">
                    <div class="card-body p-5 shadow-5 text-center">
                        <h2 class="fw-bold mb-5">Sign up now</h2>
                        <p>${mes}</p>
                        <form method="post" action="/UserServlet">
                            <!-- 2 column grid layout with text inputs for the first and last names -->
                            <div class="row">
                                <!--                                <div class="col-md-6 mb-4">-->
                                <!--                                    <div class="form-outline">-->
                                <!--                                        <input type="text" id="form3Example1" placeholder="First name" class="form-control" />-->
                                <!--                                        <label class="form-label" for="form3Example1">First name</label>-->
                                <!--                                    </div>-->
                                <!--                                </div>-->
                                <div class="form-outline mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="username" name="username" placeholder="User Name" class="form-control"/>
                                        <!--                                        <label class="form-label" for="form3Example2">Last name</label>-->
                                    </div>
                                </div>
                            </div>

                            <!-- Email input -->
<%--                            <div class="form-outline mb-4">--%>
<%--                                <input type="email" id="email" name="email" placeholder="Email address" class="form-control" />--%>
<%--                                <!--                                <label class="form-label" for="form3Example3">Email address</label>-->--%>
<%--                            </div>--%>


                            <!-- Password input -->
                            <div class="form-outline mb-4">
                                <input type="password" id="password" name="password" placeholder="Password" class="form-control" height="100" />
                                <!--                                <label class="form-label" for="form3Example4">Password</label>-->
                            </div>

                            <!-- Checkbox -->
                            <div class="form-check d-flex justify-content-center mb-4">
                                <input class="form-check-input me-2" type="checkbox" value="" id="form2Example33" checked />
                                <label class="form-check-label" for="form2Example33">
                                    Subscribe to our newsletter
                                </label>
                            </div>


                            <!-- Submit button -->
                            <form method="post" action="/UserServlet">
                                <button class="btn btn-success btn-block btn-lg gradient-custom-4 text-body ">
                                    Sign up
                                </button>
                            </form>



                            <!-- Register buttons -->
                            <div class="text-center">
                                <!--                                <p>or sign up with:</p>-->
                                <!--                                <button type="button" class="btn btn-link btn-floating mx-1">-->
                                <!--                                    <i class="fab fa-facebook-f"></i>-->
                                <!--                                </button>-->

                                <!--                                <button type="button" class="btn btn-link btn-floating mx-1">-->
                                <!--                                    <i class="fab fa-google"></i>-->
                                <!--                                </button>-->

                                <!--                                <button type="button" class="btn btn-link btn-floating mx-1">-->
                                <!--                                    <i class="fab fa-twitter"></i>-->
                                <!--                                </button>-->

                                <!--                                <button type="button" class="btn btn-link btn-floating mx-1">-->
                                <!--                                    <i class="fab fa-github"></i>-->
                                <!--                                </button>-->
                                <p>Don't have an account? <a href="/UserServlet?action=create" class="link-info">Register here</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-lg-6 mb-5 mb-lg-0">
                <img src="images/hinh-nen-mau-tim-5.jpg" height="575" class="w-100 rounded-4 shadow-4"
                     alt="" />
            </div>
        </div>
    </div>
    <!-- Jumbotron -->
</section>
<!-- Section: Design Block -->
</body>
</html>