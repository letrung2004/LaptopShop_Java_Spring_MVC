<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
                <meta name="author" content="Hỏi Dân IT" />
                <title>Dashboard Laptopshop</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manage Product</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active"><a href="/admin/product">Product</a></li>
                                    <li class="breadcrumb-item active">Detail Product</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <!-- Day la phan tren bang -->
                                            <div class="d-flex justify-content-between">
                                                <!-- id in h3 is id in UserController.java line 54 -->
                                                <h3>Product Detail</h3>

                                            </div>

                                            <hr />
                                            <div class="card" style="width: 70%;">
                                                <img class="card-img-top" src="/images/product/${product.image}"
                                                    alt=" Card image cap"
                                                    style="width: 350px; height: 250px; object-fit: cover;">
                                                <div class="card-header">
                                                    Product Information
                                                </div>
                                                <ul class="list-group list-group-flush">
                                                    <li class="list-group-item">ID Product: ${product.id}</li>
                                                    <li class="list-group-item">Product Name: ${product.name} </li>
                                                    <li class="list-group-item">Product Factory: ${product.factory}</li>
                                                    <li class="list-group-item">Product Price: ${product.price}</li>
                                                    <li class="list-group-item">Quantity: ${product.quantity}</li>
                                                    <li class="list-group-item">Detail description:
                                                        ${product.detailDesc}</li>
                                                    <li class="list-group-item">Short description: ${product.shortDesc}
                                                    </li>
                                                </ul>
                                            </div>
                                            <a style="margin-top: 10px;" class="btn btn-success"
                                                href="/admin/product">Back</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="js/scripts.js"></script>
            </body>

            </html>