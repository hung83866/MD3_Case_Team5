<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/22/2022
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<center>
<section class="vh-100" style="background-image: url('/images/1633045291_883_Background-dep-don-gian-lam-hinh-nen-hoac-thiet-ke.jpg');">
    <div  class="container py-5 h-100">
        <div  class="row d-flex justify-content-center align-items-center h-100">
            <div  class="col col-md-9 col-lg-7 col-xl-5">
                <div class="card" style="width: 600px" style="border-radius: 15px;">
                    <div  class="card-body p-4">
                        <div class="d-flex text-black">
                            <div  class="flex-shrink-0">
                                <img src="${user.img}"
                                     alt="Generic placeholder image" class="img-fluid"
                                     style="width: 180px; border-radius: 30%;">
                            </div>
                            <div class="flex-grow-1 ms-3">
                                <h3 style="color: #1e7e34" class="mb-1"> ${user.firstname} ${user.lastname}</h3>
                                <p class="mb-2 pb-1" style="color: #2b2a2a;">username : ${user.userName}</p>
                                <div class="d-flex justify-content-start rounded-3 p-2 mb-2"
                                     style="background: #9fcdff">
                                    <div>
                                        <p class="small text-muted mb-1">Address</p>
                                        <p class="mb-0">${user.address}</p>
                                    </div>
                                    <div class="px-3">
                                        <p class="small text-muted mb-1">Phone</p>
                                        <p class="mb-0">${user.telephoneNumber}</p>
                                    </div>
                                    <div>
                                        <p class="small text-muted mb-1">Email</p>
                                        <p class="mb-0">${user.email}</p>
                                    </div>
                                </div>
                                <div  class="">
                                        <a href="/UserServlet?action=edit&id=${user.id}" style="width: 150px" class="btn btn-outline-primary me-1 flex-grow-1">Edit</a>
                                        <a href="/UserServlet?action=delete&id=${user.id}" style="width: 150px" class="btn btn-outline-primary me-1 flex-grow-1">Delete</a>
                                </div >
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</center>
</body>
</html>
