package AllServerlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Demo1")
public class Demo1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Biến toàn cục để đếm số lượng yêu cầu
    private int requestCount = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Thiết lập kiểu nội dung trả về là HTML và mã hóa UTF-8
        response.setContentType("text/html;charset=UTF-8");

        // Tăng biến toàn cục mỗi khi có yêu cầu
        synchronized (this) {
            requestCount++;
        }

        // Lấy dữ liệu từ form
        String email = request.getParameter("email");
        String mssv = request.getParameter("Mssv");
        String password = request.getParameter("password");
        String dob = request.getParameter("DOB");
        String[] typeShip = request.getParameterValues("typeShip");
        String edit = request.getParameter("edit"); // Lấy giá trị của checkbox edit

        // Kiểm tra kiểu dữ liệu MSSV
        try {
            // Gây lỗi nếu MSSV không phải là số nguyên
            int mssvNumber = Integer.parseInt(mssv);

            // Gây lỗi NullPointerException nếu email là null
            String upperCaseEmail = email.toUpperCase(); // Sẽ gây ra lỗi 500 nếu email là null

            // Kiểm tra nếu người dùng muốn chỉnh sửa thông tin
            if (edit != null && edit.equals("yes")) {
                // Chuyển đến trang edit.jsp và gửi thông tin đã nhập
                request.setAttribute("email", email);
                request.setAttribute("Mssv", mssv);
                request.setAttribute("password", password);
                request.setAttribute("DOB", dob);
                request.setAttribute("typeShip", typeShip);
                request.getRequestDispatcher("Edit.jsp").forward(request, response);
            } else {
                // Hiển thị dữ liệu
                StringBuilder responseHtml = new StringBuilder();
                responseHtml.append("<html><body>");
                responseHtml.append("<h1>Thông tin người dùng đã đăng ký:</h1>");
                responseHtml.append("<p>Email: ").append(email).append("</p>");
                responseHtml.append("<p>Mã sinh viên (MSSV): ").append(mssv).append("</p>");
                responseHtml.append("<p>Mật khẩu: ").append(password).append("</p>");
                responseHtml.append("<p>Ngày sinh: ").append(dob).append("</p>");
                responseHtml.append("<p>Loại hình vận chuyển:</p>");

                if (typeShip != null) {
                    for (String ship : typeShip) {
                        responseHtml.append("<li>").append(ship).append("</li>");
                    }
                } else {
                    responseHtml.append("<p>Không chọn loại hình vận chuyển</p>");
                }

                // Hiển thị số lượng yêu cầu đã được gửi đến servlet
                responseHtml.append("<p>Số lượng yêu cầu đã gửi đến servlet: ").append(requestCount).append("</p>");

                responseHtml.append("</body></html>");
                
                response.getWriter().println(responseHtml.toString());
            }
        } catch (NumberFormatException e) {
            // Nếu có lỗi kiểu, chuyển hướng đến trang lỗi và lấy thông điệp lỗi
            String errorMessage = "MSSV phải là một chuỗi số nguyên!"; // Thông điệp lỗi cố định
            request.setAttribute("errorMessage", errorMessage); // Truyền thông điệp lỗi
            request.getRequestDispatcher("errortype.jsp").forward(request, response); // Chuyển đến trang lỗi
            
        } catch (NullPointerException e) {
            // Ném một lỗi 500 và chuyển đến trang lỗi 500
            request.setAttribute("errorMessage", "Đã xảy ra lỗi 500: Email bị thiếu hoặc null."); // Thông điệp lỗi
            request.getRequestDispatcher("error_500.jsp").forward(request, response); // Chuyển đến trang lỗi 500
        } catch (Exception e) {
            // Nếu có lỗi khác, cũng chuyển đến trang lỗi 500
            request.setAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
            request.getRequestDispatcher("error_500.jsp").forward(request, response); // Chuyển đến trang lỗi 500
        }
    }
}
