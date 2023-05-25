<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/05/2023
  Time: 2:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Detail</title>
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
    <div
            style="background-color: rgb(0, 0, 0);color: orange;text-align: center;height: 300px;display: flex;justify-content: center;align-items: center; margin-bottom: 50px;margin-top: -8px;">
        <h1>${list.nameProduct}</h1>
    </div>
    <div class="show_item">
        <div class="img_showone"
             style="background-color: white;width: 500px;height: 500px;margin: 50px 0;border-radius: 10px;">
            <img style="width: 450px;display: flex;margin: auto;"
                 src="<%=request.getContextPath()%>/image/${list.image}" alt="">
        </div>
        <div style="width: 30%;">

            <h3>${list.nameProduct}</h3>
            <hr>
            <b>Giá tiền: </b><span style="margin-right: 10px;">${list.price}$</span><span
                style="text-decoration: line-through;color: darkgray;">799$</span><br>
            <b>Danh mục: </b><span>${list.catalog.nameCatalog}</span><br>

            <b>Mô tả: </b>
            <p>${list.title}</p>
            <b>Trạng thái: </b><span>${list.status?"Còn hàng":"Hết hàng"}</span>
            <hr>
            <br>
            <br>
            <div class="next" style="margin: 0">
                <a style="text-decoration: none;" href="/productController/show">
                    <button class="btn btn-success ">Quay lại trang chủ</button>
                </a><br><br>
                <form action="/cartController/addToCart?idProduct=${list.idProduct}" method="post">
                    <button type="submit" class="btn btn-warning">Thêm vào giỏ hàng</button>
                </form>
            </div>
        </div>
    </div>
    <div style="background-color: white; width: 50%; border-radius: 20px; margin: 70px auto;">
        <div style="text-align: center; padding: 50px 0;">
            <h3>Đánh giá: </h3>
        </div>
        <c:forEach items="${comment}" var="cmt">
            <div style="padding:20px 50px;">
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor"
                     class="bi bi-person-circle" viewBox="0 0 16 16">
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                    <path fill-rule="evenodd"
                          d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                </svg>&nbsp;<b>${cmt.fullname}: </b><span>${cmt.comment}</span>
            </div>
        </c:forEach>
        <c:if test="${comment.size()==0}">
            <div style="padding:20px 50px;">
               <p style="text-align: center;color: orange">Chưa có đánh giá</p>
            </div>
        </c:if>
    </div>
    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Footer -->

</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
