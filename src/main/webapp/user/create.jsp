<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<section class="vh-100 bg-image"
         style="background-image: url('images/Oai-huong.jpg'); max-height: 500px">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Create an account</h2>

                            <form method="post" action="/UserServlet?action=create">

                                <div class="form-outline mb-4">
                                    <input type="text" id="username" name="username" placeholder="User Name" class="form-control form-control-lg" />
                                    <span style="color: red">${mes1}${mes3}</span>
                                    <!--                                    <label class="form-label" for="form3Example1cg">Your Name</label>-->
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="email" id="email" name="email" placeholder="Your Email" class="form-control form-control-lg" />
                                    <span style="color: red">${mes2}${mes3}</span>
                                    <!--                                    <label class="form-label" for="form3Example3cg">Your Email</label>-->
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="password" id="password" name="password" placeholder="Password" class="form-control form-control-lg" />
                                    <span style="color: red">${mes3}</span>
                                    <!--                                    <label class="form-label" for="form3Example4cg">Password</label>-->
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="password" id="repass" name="repass" placeholder="Repeat your password" class="form-control form-control-lg" />
                                    <span style="color: red">${mes4}</span>
                                    <!--                                    <label class="form-label" for="form3Example4cdg">Repeat your password</label>-->
                                </div>
                                <div class="d-flex justify-content-center">
                                    <button
                                            class="btn btn-success btn-block btn-lg gradient-custom-4 text-body" >Register</button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="index.jsp"
                                                                                                        class="fw-bold text-body"><u>Login here</u></a></p>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>