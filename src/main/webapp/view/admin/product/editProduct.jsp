<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/05/2023
  Time: 4:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
<form action="/productController/update" method="post" enctype="multipart/form-data">
    <div class="container-admin">
        <jsp:include page="../navbarAdmin.jsp"></jsp:include>
        <div class="title">
            <h1>Product Manager</h1>
            <div class="table">
                <table class="table_create">
                    <thead>
                    <tr>
                        <th><b>Mã sản phẩm: </b></th>
                        <td><input type="text" name="id" value="${product.idProduct}" readonly/></td>
                    </tr>
                    <tr>
                        <th><b>Ảnh sản phẩm: </b></th>
                        <td>
                            <img style="width: 100px" src="<%=request.getContextPath()%>/image/${product.image}" alt="">
                            <input type="text" name="oldImage" value="${product.image}" hidden/>
                            <input type="file" name="image"/>
                        </td>

                    </tr>
                    <tr>
                        <th><b>Tên sản phẩm: </b></th>
                        <td><input type="text" name="name" value="${product.nameProduct}"/></td>
                    </tr>
                    <tr>
                        <th><b>Mô tả sản phẩm: </b></th>
                        <td><input type="text" name="title" value="${product.title}"/></td>
                    </tr>
                    <tr>
                        <th><b>Số lượng sản phẩm: </b></th>
                        <td><input type="number" name="quantity" value="${product.quantity}" /></td>
                    </tr>
                    <tr>
                        <th><b>Giá sản phẩm: </b></th>
                        <td><input type="number" name="price" value="${product.price}"/></td>
                    </tr>
                    <tr>
                        <th><b>Danh mục sản phẩm: </b></th>
                        <td>
                            <select  name="catalog" style="width: 100px;height: 35px;border-radius: 5px;">

                                <c:forEach items="${catalog}" var="cata">
                                    <option ${product.catalog.idCatalog==cata.idCatalog?"selected":""} value="${cata.idCatalog}">${cata.nameCatalog}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><b>Trạng thái sản phẩm: </b></th>
                        <td>
                            <select name="status" style="width: 100px;height: 35px;border-radius: 5px;">
                                <option value="true" ${product.status?"selected":""}>Bán</option>
                                <option value="false" ${!product.status?"selected":""}>Hết</option>
                            </select>
                        </td>
                    </tr>

                    </thead>
                </table>
            </div>
            <button type="submit" style="margin-top: 20px;background-color: rgb(211, 122, 5);border-radius: 5px;font-size: 25px;">Sửa
            </button>
        </div>
    </div>
</form>
</body>
</html>
