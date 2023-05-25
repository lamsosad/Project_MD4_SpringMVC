<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/05/2023
  Time: 7:48 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Manager</title>
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
<div class="container-admin">
    <jsp:include page="../navbarAdmin.jsp"></jsp:include>
    <div class="title">
        <h1>User Manager</h1>
        <div class="table">
            <table class="table-product">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã User</th>
                    <th>Tên người dùng</th>
                    <th>Email</th>
                    <th>Chức vụ</th>
                    <th>Trạng thái</th>
                    <th>Khóa</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${user}" var="user">
                    <tr>
                        <td>${user.idUser}</td>
                        <td>US0${user.idUser}</td>
                        <td>${user.fullname}</td>
                        <td>${user.email}</td>
                        <td>${user.role?"Admin":"Người dùng"}</td>
                        <td>${user.status?"Đang hoạt động":"Bị khóa"}</td>
                        <td>
                            <c:if test="${!user.role}">
                                <a href="/userController/changeStatus?idUser=${user.idUser}&status=${user.status}">
                                    <button style="background-color: orange">Khóa/Mở</button>
                                </a>
                            </c:if>

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
