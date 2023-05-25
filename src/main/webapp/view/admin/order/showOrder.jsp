<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 18/05/2023
  Time: 9:28 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Order</title>
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
<div class="container-admin">
    <jsp:include page="../navbarAdmin.jsp"></jsp:include>
    <div class="title">
        <div>
            <h3>Đơn hàng số #${order.idOrder}</h3>
            <hr>
            <div class="total"><b> Trạng thái: </b><span span
                                                         style="font-size: 13px;color: white">${order.status?"Chưa xác nhận":"Đang giao hàng"}</span>
            </div>
            <div class="total"><b>Sản phẩm: </b></div>
            <div>
                <table class="table_order">
                    <c:forEach items="${listOrder}" var="pro">
                        <tr>
                            <td style="color: white">Tên sản phẩm: ${pro.nameProduct}</td>
                            <td style="color: white"><img class="img_order"
                                                          src="<%=request.getContextPath()%>/image/${pro.image}"
                                                          alt="Order"></td>
                            <td style="color: white">x${pro.quantity}</td>
                            <td style="color: white">Giá sản phẩm: ${pro.price}$</td>
                            <td style="color: white">Thành tiền: ${pro.quantity*pro.price}$</td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="total"><b>Tổng tiền: </b><span style="font-size: 13px;">${order.total}$</span></div>
                <hr>
                <div class="total">
                    <b>Thông tin đặt hàng: </b><br><br>
                    <b>Ngày đặt: </b><span style="font-size: 15px;">${order.date}</span><br><br>
                    <b>Tài khoản đặt: </b> <span style="font-size: 15px;"></span><br><br>
                    <b>Tên người nhận:</b> <span style="font-size: 15px;">${order.nameReceiver}</span><br><br>
                    <b>Số điện thoại:</b> <span style="font-size: 15px;">${order.phone}</span><br><br>
                    <b>Địa chỉ:</b> <span style="font-size: 15px;">${order.address}</span><br><br>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
