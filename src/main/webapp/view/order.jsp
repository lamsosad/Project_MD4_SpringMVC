<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 19/05/2023
  Time: 4:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="shortcut icon"
          href="https://i.pinimg.com/originals/1e/c1/1a/1ec11a869384bc5e59625bac39b6a099.png"
          type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body style="background-color: rgb(237, 236, 236)">
<jsp:include page="navbar.jsp"></jsp:include>
<h1 style="color: orange; text-align: center;font-size: 70px; margin: 100px;">Đơn hàng</h1>
<c:forEach items="${listOrder}" var="order">
    <div style="display: flex;justify-content: center;align-items: center;margin-bottom: 10px">
        <div style="width: 70vw; height: auto;box-shadow: 0 0 20px 10px gray; background-color: white; border-radius: 20px;margin-bottom: 30px">
            <div style="padding: 20px 20px; display: flex;justify-content: space-between; background-color: rgb(211, 208, 208);border-radius: 20px;">
                <b>Mã đơn hàng: #${order.id}</b>
                <span><b>Trạng thái: </b><span
                        style="color:blue;"></span>${order.status?"Chờ xác nhận":"Đã giao hàng"}</span>
            </div>
            <div style="padding: 20px;">
                <table style="display: flex;justify-content: center;align-items: center">
                    <tr>
                        <td><b>Ngày đặt: </b><span>${order.date}</span></td>
                        <td style="padding: 10px 50px"><b>Số điện thoại: </b><span>${order.phone}</span></td>
                    </tr>
                    <tr>
                        <td><b>Người nhận: </b><span>${order.nameReceiver}</span></td>
                        <td style="padding: 10px 50px"><b>Địa chỉ: </b><span>${order.address}</span></td>
                    </tr>
                </table>
                <div style="display: flex;justify-content: center;align-items: center;">
                    <table>
                        <tr>
                            <td colspan="5" style="text-align: center; padding-top: 50px"><b>Tổng
                                tiền: ${order.total}$</b></td>
                        </tr>
                        <tr>
                            <td colspan="5" style="text-align: right;padding: 30px;">
                                <a href="/productController/show" style="text-decoration: none">
                                    <button style="border-radius: 20px;background-color: orange;color: white">Quay lại
                                        trang chủ
                                    </button>
                                </a>
                                <a href="/orderController/showAll?idOrder=${order.id}" style="text-decoration: none">
                                    <button style="border-radius: 20px;background-color: green; color: white">Chi tiết
                                    </button>
                                </a>
                            </td>
                        </tr>
                    </table>

                </div>
            </div>
        </div>
    </div>
</c:forEach>
<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
