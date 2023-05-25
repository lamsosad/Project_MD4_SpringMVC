<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/05/2023
  Time: 3:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Catalog</title>
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
        <form action="/adminController/updateCatalog" method="post">
            <div class="table">
                <table class="table_create">
                    <thead>
                    <tr>
                        <th><b>Mã danh mục: </b></th>
                        <td><input type="text" value="${catalog.idCatalog}" readonly name="idCatalog"/></td>
                    </tr>
                    <tr>
                        <th><b>Tên danh mục: </b></th>
                        <td><input type="text" value="${catalog.nameCatalog}" name="nameCatalog"/></td>
                    </tr>
                    <tr>
                        <th><b>Trạng thái danh mục: </b></th>
                        <td>
                            <select name="status" style="width: 100px;height: 35px;border-radius: 5px;">
                                <option value="true" ${catalog.status?"selected":""}>Mở</option>
                                <option value="false" ${!catalog.status?"selected":""}>Khóa</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2"><button type="submit"
                                                style="margin-top: 20px;background-color: rgb(211, 122, 5);border-radius: 5px;font-size: 25px;">
                            Sửa
                        </button></th>
                    </tr>
                    </thead>
                </table>

            </div>
        </form>
    </div>

</div>
</body>
</html>
