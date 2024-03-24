import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LabPost")
public class LabPost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve form data
        String studentRegNo = request.getParameter("studentRegNo");
        String name = request.getParameter("name");
        String labResults = request.getParameter("labResults");


        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mis", "root", "pass123");

            // Create a SQL prepared statement
            String sql = "insert into labresults values(?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentRegNo);
            pstmt.setString(2, name);
            pstmt.setString(3, labResults);
            

            // Execute the prepared statement
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                out.println("<html><head><title>Success</title></head><body>");
                out.println("<h1>Record added successfully</h1>");
                out.println("</body></html>");
            } else {
                out.println("<html><head><title>Error</title></head><body>");
                out.println("<h1>Error adding record</h1>");
                out.println("</body></html>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(out); // Print stack trace to the PrintWriter
        } finally {
            // Close the database resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(out);
            }
        }
    }
}
