<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/05/2023
  Time: 10:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Manager</title>
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
<div class="container-admin">
    <jsp:include page="../navbarAdmin.jsp"></jsp:include>
    <div class="title" style="height: 100vh; overflow: auto">
        <h1>Product Manager</h1>
        <div class="button_createPro"><a href="/productController/create">
            <button class="create_product">Thêm mới sản phẩm</button>
        </a></div>
        <div class="table" style="margin-bottom: 50px">
            <table class="table-product">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>MSP</th>
                    <th>ẢNH</th>
                    <th>TÊN SP</th>
                    <th>SỐ LƯỢNG</th>
                    <th>GIÁ</th>
                    <th>Danh mục</th>
                    <th>TRẠNG THÁI</th>
                    <th colspan="2">SỬA/XÓA</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="adPro">
                    <tr>
                        <td>${adPro.idProduct}</td>
                        <td>SP00${adPro.idProduct}</td>
                        <td class="crossword_img"><img class="img_manager" src="<%=request.getContextPath()%>/image/${adPro.image}" alt="Product"></td>
                        <td>${adPro.nameProduct}</td>
                        <td>${adPro.quantity}</td>
                        <td>${adPro.price}$</td>
                        <td>${adPro.catalog.nameCatalog}</td>
                        <td>${adPro.status?"Còn hàng":"Hết hàng"}</td>
                        <td><a href="/productController/edit?idProduct=${adPro.idProduct}">
                            <button style="background-color: rgb(113, 113, 0);border-radius: 5px;color: white;">Sửa
                            </button>
                        </a></td>
                        <td><a href="/productController/delete?idProduct=${adPro.idProduct}">
                            <button style="background-color: rgb(146, 4, 4);border-radius: 5px;color: white;">Xóa
                            </button>
                        </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
