<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 21/05/2023
  Time: 2:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết hóa đơn</title>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="shortcut icon"
          href="https://i.pinimg.com/originals/1e/c1/1a/1ec11a869384bc5e59625bac39b6a099.png"
          type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div style="display: flex;justify-content: center;align-items: center;margin: 100px 50px">
    <div
            style="width: 70vw; height: auto;box-shadow: 0 0 20px 10px gray; background-color: white; border-radius: 20px;">
        <div
                style="padding: 20px 20px; display: flex;justify-content: space-between; background-color: rgb(211, 208, 208);border-radius: 20px;">
            <b>Mã đơn hàng: #${order.idOrder}</b>
            <span><b>Trạng thái: </b><span
                    style="color:blue;"></span>${order.status?"Chờ xác nhận":"Đã giao hàng"}</span>
        </div>
        <div style="padding: 20px;">
            <div style="display: flex;justify-content: center;align-items: center;">
                <table>
                    <c:forEach items="${listOrder}" var="pro">
                        <tr>
                            <td style="padding: 10px 30px;"><b>${pro.nameProduct}</b></td>
                            <td style="padding: 10px 30px;">
                                <img style="width: 150px;" src="<%=request.getContextPath()%>/image/${pro.image}"
                                     alt="Order">
                            </td>
                            <td style="padding: 10px 30px;">x${pro.quantity}</td>
                            <td style="padding: 10px 30px;">${pro.price}$</td>
                            <td style="padding: 10px 30px;"><b>Thành tiền: </b>${pro.price*pro.quantity}$</td>
                        </tr>
                        <tr>
                            <td colspan="5">
                                <c:if test="${!order.status}">
                                    <div style="background-color: rgb(211, 208, 208);padding:20px 50px;border: 1px solid black; border-bottom-left-radius: 20px;border-bottom-right-radius: 20px;margin: auto">
                                        <form action="/commentController/createComment?idOrderDetail=${pro.id}" method="post">
                                   <input
                                            style="width: 60%; border-radius: 20px;"
                                            type="text"
                                            name="comment"
                                            placeholder="  Cho biết cảm nhận của bạn về sản phẩm..."><button type="submit"
                                        style="border-radius: 20px;background-color: orange;">Gửi</button></span>
                                        </form>
                                    </div>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5" style="text-align: center; padding-top: 50px"><b>Tổng
                            tiền: ${order.total}$</b></td>
                    </tr>
                    <tr>
                        <td colspan="5" style="text-align: right;padding: 30px;">
                            <a href="/orderController/showOrderToUser" style="text-decoration: none">
                                <button style="border-radius: 20px;background-color: orange;color: white">Quay lại
                                </button>
                            </a>
                        </td>
                    </tr>
                </table>

            </div>
        </div>
    </div>
</div>
</body>
</html>
