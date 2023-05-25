<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/05/2023
  Time: 11:24 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog Manager</title>
    <link rel="shortcut icon"
          href="https://i.pinimg.com/originals/1e/c1/1a/1ec11a869384bc5e59625bac39b6a099.png"
          type="image/x-icon">
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
<div class="container-admin">
    <jsp:include page="../navbarAdmin.jsp"></jsp:include>
    <div class="title">
        <h1>Catalog Manager</h1>
        <div class="button_createPro"><a href="/adminController/createCatalog">
            <button class="create_product">Thêm mới danh
                mục
            </button>
        </a></div>
        <div class="table">
            <table class="table-product">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã danh mục</th>
                    <th>TÊN DM</th>
                    <th>TRẠNG THÁI</th>
                    <th colspan="2">SỬA/XÓA</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="cata">
                    <tr>
                        <td>${cata.idCatalog}</td>
                        <td>DM0${cata.idCatalog}</td>
                        <td>${cata.nameCatalog}</td>
                        <td>${cata.status?"ON":"OFF"}</td>
                        <td><a href="/adminController/editCatalog?idCatalog=${cata.idCatalog}">
                            <button
                                    style="background-color: rgb(113, 113, 0);border-radius: 5px;color: white;">Sửa
                            </button>
                        </a>
                        </td>
                        <td><a href="/adminController/deleteCatalog?idCatalog=${cata.idCatalog}">
                            <button
                                    style="background-color: rgb(146, 4, 4);border-radius: 5px;color: white;">Xóa
                            </button>
                        </a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
