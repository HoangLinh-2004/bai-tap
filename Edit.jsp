<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh Sửa Thông Tin Người Dùng</title>
    <style>
        body {
            font-family: Times New Roman;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            max-width: 450px; /* Đặt chiều rộng tối đa cho khung biểu mẫu */
            margin: 0 auto; /* Căn giữa khung biểu mẫu */
            background: #ffffff; /* Màu nền trắng cho khung biểu mẫu */
            padding: 35px; /* Khoảng cách bên trong */
            border-radius: 8px; /* Bo tròn góc */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Đổ bóng cho khung */
            background-color: #e7f1ff; /* Thay đổi màu nền */
        }
        /* Sử dụng box-sizing để đảm bảo tất cả các ô bằng nhau */
        *, *:before, *:after {
            box-sizing: border-box; /* Thiết lập box-sizing cho tất cả phần tử */
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="email"],
        input[type="text"],
        input[type="password"],
        input[type="date"],
        button {
            width: 100%; /* Để các trường nhập chiếm 100% chiều rộng của khung */
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #28a745; /* Màu nền nút */
            color: white; /* Màu chữ nút */
            border: none; /* Không có viền */
            cursor: pointer; /* Con trỏ chuột khi di chuột qua nút */
        }
        button:hover {
            background-color: #218838; /* Màu nền nút khi di chuột qua */
        }
        .checkbox-label {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h1>CHỈNH SỬA THÔNG TIN NGƯỜI DÙNG</h1>

    <form action="SaveEdit" method="post">

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${email}" required>
        
        <label for="Mssv">Mã sinh viên (MSSV):</label>
        <input type="text" id="Mssv" name="Mssv" value="${Mssv}" required>

        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" value="${password}" required>

        <label for="DOB">Ngày sinh:</label>
        <input type="date" id="DOB" name="DOB" value="${DOB}" required>

        <label>Loại hình vận chuyển:</label>
        <div class="checkbox-label">
            <input type="checkbox" name="typeShip" value="Fast Shipping" ${typeShip == 'Fast Shipping' ? 'checked' : ''}> Giao hàng nhanh<br>
            <input type="checkbox" name="typeShip" value="Standard Shipping" ${typeShip == 'Standard Shipping' ? 'checked' : ''}> Giao hàng tiêu chuẩn<br>
            <input type="checkbox" name="typeShip" value="Free Shipping" ${typeShip == 'Free Shipping' ? 'checked' : ''}> Giao hàng miễn phí<br>
        </div>

        <button type="submit">Lưu Thay Đổi</button>
    </form>
</body>
</html>
