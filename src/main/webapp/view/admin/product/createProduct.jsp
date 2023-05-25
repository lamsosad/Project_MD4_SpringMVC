<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/05/2023
  Time: 2:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
<form action="/productController/add" method="post" enctype="multipart/form-data">
    <div class="container-admin">
        <jsp:include page="../navbarAdmin.jsp"></jsp:include>
        <div class="title">
            <h1>Product Manager</h1>
            <div class="table">
                <table class="table_create">
                    <thead>
                    <tr>
                        <th><b>Ảnh sản phẩm: </b></th>
                        <td>
                            <input style="color: white" type="file" name="image" required/>
                        </td>
                    </tr>
                    <tr>
                        <th><b>Tên sản phẩm: </b></th>
                        <td><input type="text" name="name" required/></td>
                    </tr>
                    <tr>
                        <th><b>Mô tả sản phẩm: </b></th>
                        <td><input type="text" name="title" required/></td>
                    </tr>
                    <tr>
                        <th><b>Số lượng sản phẩm: </b></th>
                        <td><input type="number" name="quantity" required/></td>
                    </tr>
                    <tr>
                        <th><b>Giá sản phẩm: </b></th>
                        <td><input type="number" name="price" required/></td>
                    </tr>
                    <tr>
                        <th><b>Danh mục sản phẩm: </b></th>
                        <td>
                            <select name="catalog" style="width: 100px;height: 35px;border-radius: 5px;">
                                <c:forEach items="${catalog}" var="cata">
                                    <option value="${cata.idCatalog}">${cata.nameCatalog}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                    </thead>
                </table>
            </div>
            <button style="margin-top: 20px;background-color: rgb(47, 216, 47);border-radius: 5px;font-size: 25px;" type="submit">Thêm mới</button>
        </div>
    </div>
</form>
</body>
</html>
