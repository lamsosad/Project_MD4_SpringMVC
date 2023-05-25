<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 22/05/2023
  Time: 8:20 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comment Manager</title>
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
<div class="container-admin">
    <jsp:include page="../navbarAdmin.jsp"></jsp:include>
    <div class="title">
        <h1>Comment Manager</h1>
        <div class="table">
            <table class="table-product">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã CMT</th>
                    <th>Tên người dùng</th>
                    <th>Feedback</th>
                    <th>Trạng thái</th>
                    <th>Duyệt</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${comment}" var="cmt">
                <tr>
                    <td>${cmt.id}</td>
                    <td>CMT0${cmt.id}</td>
                    <td>${cmt.fullname}</td>
                    <td>${cmt.comment}</td>
                    <td>${cmt.status?"Đã phê duyệt":"Chờ phê duyệt"}</td>
                    <td>
                        <a href="/commentController/changeStatus?idComment=${cmt.id}">
                            <button style="background-color: #2bda2b">Duyệt</button>
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
