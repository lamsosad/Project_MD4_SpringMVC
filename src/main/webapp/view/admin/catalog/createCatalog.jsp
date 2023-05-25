<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/05/2023
  Time: 1:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Catalog</title>
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
        <form action="/adminController/addCatalog" method="post">
            <div class="table">
                <table class="table_create">
                    <thead>
                    <tr>
                        <th><b>Tên danh mục: </b></th>
                        <td><input type="text" name="nameCatalog" required/></td>
                    </tr>
                    </thead>
                </table>
            </div>

                <button type="submit" style="margin-top: 20px;background-color: rgb(47, 216, 47);border-radius: 5px;font-size: 25px;">
                    Thêm mới
                </button>

        </form>
    </div>
</div>
</body>
</html>
