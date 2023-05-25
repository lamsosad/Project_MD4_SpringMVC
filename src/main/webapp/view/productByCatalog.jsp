<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/05/2023
  Time: 4:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product By Catalog</title>
    <link rel="shortcut icon"
          href="https://i.pinimg.com/originals/1e/c1/1a/1ec11a869384bc5e59625bac39b6a099.png"
          type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/home.css">
</head>
<body>
<div class="container-fluid">
    <jsp:include page="navbar.jsp"></jsp:include>
    <div style="background-color: rgba(0, 0, 0, 0);color: black;text-align: center;height: 50px;display: flex;justify-content: center;align-items: center; margin-top: 100px;">

    </div>
    <div>
        <div class="row g-3 mt-4 product">
            <c:forEach items="${listCata}" var="pro">
                <div class="col-3 ">
                    <div class="card h-100 img-fluid">
                        <img style="width: 200px; margin: 5px auto"
                             src="<%=request.getContextPath()%>/image/${pro.image}"
                             alt="Product"/>
                        <div class="card-body">
                            <h5 class="card-title">${pro.nameProduct}</h5>
                            <p class="card-text">Giá: ${pro.price}$</p>
                                <%--                            <p class="card-text">Danh mục: ${pro.catalog.nameCatalog}</p>--%>
                        </div>
                        <c:if test="${userlogin!=null}">
                            <c:if test="${pro.status}">
                                <div class="card-footer">
                                    <a href="/productController/showProductDetail?idProduct=${pro.idProduct}">
                                        <button class="btn btn-dark">Xem</button>
                                    </a>
                                    <a href="">
                                        <button class="btn btn-dark">
                                            <svg
                                                    xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                                    fill="currentColor"
                                                    class="bi bi-bag-plus" viewBox="0 0 16 16">
                                                <path fill-rule="evenodd"
                                                      d="M8 7.5a.5.5 0 0 1 .5.5v1.5H10a.5.5 0 0 1 0 1H8.5V12a.5.5 0 0 1-1 0v-1.5H6a.5.5 0 0 1 0-1h1.5V8a.5.5 0 0 1 .5-.5z"/>
                                                <path
                                                        d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>
                                            </svg>
                                        </button>
                                    </a>
                                </div>
                            </c:if>
                            <c:if test="${!pro.status}">
                                <div class="card-footer">
                                    <button class="btn btn-danger" style="color: white">Hết hàng</button>
                                </div>
                            </c:if>
                        </c:if>

                        <c:if test="${userlogin==null}">
                            <div class="card-footer">
                                <a href="/userController/login"><p style="color: orange">Đăng nhập để mua</p></a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="next my-5" style="width: auto">
            <a href="/productController/show">
                <button class="btn btn-light">Xem tất cả
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                         fill="currentColor" class="bi bi-arrow-right-circle" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"/>
                    </svg>
                </button>
            </a>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Footer -->

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
