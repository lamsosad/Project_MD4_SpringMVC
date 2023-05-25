<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 13/05/2023
  Time: 9:53 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Manager</title>
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
<div class="container-admin">
    <jsp:include page="../navbarAdmin.jsp"></jsp:include>
    <div class="title">
        <h1>Order Manager</h1>
        <div class="table">
            <table class="table-product">
                <thead>
                <tr>
                    <th style="padding: 20px 5px">STT</th>
                    <th style="padding: 20px 5px">Mã Order</th>
                    <th style="padding: 20px 5px">Tên người nhận</th>
                    <th style="padding: 20px 5px">Ngày đặt</th>
                    <th style="padding: 20px 5px">Thành tiền</th>
                    <th style="padding: 20px 5px">Trạng thái</th>
                    <th style="padding: 20px 5px" colspan="2">SỬA/XÓA</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listOrder}" var="order">
                <tr>
                    <td style="padding: 20px 5px">${order.id}</td>
                    <td style="padding: 20px 5px">OD0${order.id}</td>
                    <td style="padding: 20px 5px">${order.nameReceiver}</td>
                    <td style="padding: 20px 5px">${order.date}</td>
                    <td style="padding: 20px 5px">$${order.total}</td>
                    <td style="padding: 20px 5px">${order.status?"Chưa xác nhận":"Đã giao hàng"}</td>
                    <td style="padding: 20px 5px"><a href="/orderController/showAllOrder?idOrder=${order.id}">
                        <button
                                style="background-color: rgb(4, 111, 4);border-radius: 5px;color: white;">Xem
                        </button>
                    </a>
                    </td>
                    <td style="padding: 20px 5px"><a href="/orderController/changeStatusOrder?idOrder=${order.id}">
                        <button
                                style="background-color: rgb(146, 4, 4);border-radius: 5px;color: white;">Xác
                            nhận
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
