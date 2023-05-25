<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/05/2023
  Time: 4:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
  <link rel="shortcut icon"
        href="https://i.pinimg.com/originals/1e/c1/1a/1ec11a869384bc5e59625bac39b6a099.png"
        type="image/x-icon">
  <link rel="stylesheet" href="/css/login_register.css">
</head>
<body>
<form action="/userController/newLogin" method="post">
<section>
  <div class="form-box">
    <div class="form-value">
      <form action="">
        <h2>Đăng nhập</h2>
        <div class="inputbox">
          <ion-icon name="mail-outline"></ion-icon>
          <input type="text" name="username" required>
          <label>Tên đăng nhập</label>
        </div>
        <div class="inputbox">
          <ion-icon name="lock-closed-outline"></ion-icon>
          <input type="password" name="password" required>
          <label>Mật Khẩu</label>
        </div>
        <div class="">
          <p name="message" style="color: red;">${message}</p>
        </div>
        <button type="submit">Đăng nhập</button>
        <div class="register">
          <p>Bạn chưa có tài khoản? <a href="/userController/register">Đăng kí</a></p>
        </div>
      </form>
    </div>
  </div>
</section>
</form>
</body>
</html>
