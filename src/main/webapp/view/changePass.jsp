<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/05/2023
  Time: 2:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đổi mật khẩu</title>
    <link rel="shortcut icon"
          href="https://i.pinimg.com/originals/1e/c1/1a/1ec11a869384bc5e59625bac39b6a099.png"
          type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<body style="  background-color: rgb(237, 236, 236);display: flex;justify-content: center;align-items: center;">
<div
        style="  background-color: rgb(255, 255, 255);box-shadow: 0px 0px 50px 5px gray;border-radius: 20px;width: 40vw; height: 95vh;margin-top: 10px;">
    <h1 style="text-align: center; color: orange;padding-top: 100px;">Đổi mật khẩu</h1>
    <a style="text-decoration: none;display: flex;justify-content: center" href="/productController/show"><button style="border-radius: 20px;margin: 20px 0;"
                                                                            class="btn btn-success">
        Quay lại trang chủ
    </button></a>
    <div style="display: flex;justify-content: center;align-items: center;">
        <form action="/userController/upPass" method="post">
            <table>
                <tr>
                    <th style="padding: 20px">Mật khẩu cũ:
                    </th>
                    <td style="text-align: center;"><input name="oldPass" style="border-radius: 10px;" type="password" required>
                    </td>

                </tr>
                <tr>
                    <th style="padding: 20px">Mật khẩu mới:
                    </th>
                    <td style="text-align: center;"><input name="newPass" style="border-radius: 10px;" type="password" required>
                    </td>

                </tr>
                <tr>
                    <th style="padding: 20px">Nhập lại mật khẩu:
                    </th>
                    <td style="text-align: center;"><input name="rePass" style="border-radius: 10px;" type="password" required>
                    </td>
                </tr>
                <tr>
                   <td colspan="2">
                       <div class="">
                           <p style="color: red" name="message">${message}</p>
                       </div>
                   </td>
                </tr>
                <tr>
                    <td style="text-align: center;padding-top: 30px;" colspan="3">
                        <button type="submit" style="border-radius: 20px;"
                                class="btn btn-warning">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                 fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                <path
                                        d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                <path fill-rule="evenodd"
                                      d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                            </svg>
                        </button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
