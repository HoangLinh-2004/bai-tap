<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
    <style>
        body {
            font-family: Times New Roman ;
            text-align: center;
            padding: 20px;
        }

        h1 {
            color: red;
            font-size: 40px; /* Tăng kích thước chữ */
        }

        a {
            color: blue;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>ERROR_TYPE</h1>
    <p><%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "Đã xảy ra lỗi!" %></p>
    
    <!-- Thêm liên kết quay lại trang chính -->
    <p><a href="thông tin.jsp">Quay lại trang chính</a></p>
</body>
</html>
