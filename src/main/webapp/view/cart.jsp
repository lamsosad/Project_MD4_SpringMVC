<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 13/05/2023
  Time: 9:54 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="shortcut icon"
          href="https://i.pinimg.com/originals/1e/c1/1a/1ec11a869384bc5e59625bac39b6a099.png"
          type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/cart.css">
    <link rel="stylesheet" href="/css/home.css">
</head>
<body>
<div class="container-fluid">

    <!-- cart -->
    <div style="background-color: rgba(0, 0, 0, 0);color: black;text-align: center;height: 50px;display: flex;justify-content: center;align-items: center; margin: 50px 0">
        <h1><b>Giỏ hàng của tôi</b></h1>
    </div>

    <div class="card" style="margin-bottom: 200px">
        <div class="row" style="align-items: center">
            <div class="col-md-8 cart">
                <div class="title">
                    <div class="row">
                        <div class="col">
                            <h4><b>Sản phẩm đã thêm: </b></h4>
                        </div>
                        <div class="col align-self-center text-right text-muted"><h4>${listCart.size()} sản phẩm</h4>
                        </div>
                    </div>
                </div>
                <c:forEach items="${listCart}" var="cart">
                    <div class="row border-top border-bottom">
                        <div class="row main align-items-center">
                            <div class="col-2">
                                <img class="img-fluid img_cart"
                                     src="<%=request.getContextPath()%>/image/${cart.productImage}">
                            </div>
                            <div class="col">
                                <div class="row text-muted">${cart.catalogName}</div>
                                <div class="row text-muted">$${cart.productPrice}</div>
                                <div class="row">${cart.productName}</div>
                            </div>
                            <div class="col">
                                <a href="/cartController/quantityDown?idDown=${cart.idCartDetail}">-</a>
                                <a href="#" class="border">${cart.quantityBuy}</a>
                                <a href="/cartController/quantityUp?idUp=${cart.idCartDetail}">+</a>
                            </div>
                            <div class="col">
                                &dollar;${cart.productTotal}
                                <a href="/cartController/delete?idCart=${cart.idCartDetail}"><span class="close">&#10005;</span></a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <div class="back-to-shop"><a href="/productController/show">&leftarrow;&nbsp;<span class="text-muted">Quay lại trang
                                chủ</span></a></div>
            </div>
            <div class="col-md-4 summary" style="padding: 0 15px;border-radius: 15px">
                <form id="order-form" action="/orderController/createOrder" method="post">
                    <input type="hidden" name="listCart" value="${listCart}" />
                    <div>
                        <h5><b>Thông tin đặt hàng</b></h5>
                    </div>
                    <hr>
                    <div class="row mx-0 cart-input">

                        <div><input name="nameReceiver" id="name" type="text" placeholder=" Tên người nhận..." required>
                        </div>
                        <br><br>
                        <div>
                            <input name="phone" id="phone" type="text" placeholder=" Số điện thoại..." required>
                        </div>
                        <br>
                        <div><input name="address" id="address" type="text" placeholder=" Địa chỉ nhận hàng..."
                                    required></div>
                        <br><br>
                        <p id="message" style="color: red">
                        </p>
                    </div>

                    <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                        <div class="col">Tổng tiền</div>
                        <div class="col text-right">&dollar; ${total}</div>
                    </div>
                    <button id="submit-btn" type="submit" class="btn btn-dark btn_oder">Đặt hàng</button>
                </form>
            </div>
        </div>


    </div>
    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Footer -->

</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous">
</script>

<script>
    document.getElementById("submit-btn").addEventListener("click", function (event) {
        event.preventDefault();
        let inputPhone = document.getElementById("phone").value;
        let inputName = document.getElementById("name").value;
        let inputAddress = document.getElementById("address").value;
        let validPhoneNumber = isValidPhoneNumber(inputPhone)
        if (inputName == "" || inputAddress == "" || inputPhone=="" ) {
            document.getElementById("message").innerHTML = "Không được để trống!";
        } else if (validPhoneNumber) {
            document.getElementById("order-form").submit();
        } else {
            document.getElementById("message").innerHTML = "Số điện thoại không đúng định dạng!";
        }
    })


    function isValidPhoneNumber(phoneNumber) {
        var phonePattern = /^[0-9]{10}$/;
        if (phonePattern.test(phoneNumber)) {
            return true;
        } else {
            return false;
        }
    }
</script>
</html>
