import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import business.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Labb")
public class Labb extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Patient> doctr = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establishing database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mis", "root", "pass123");

            // Fetching data from the database
            PreparedStatement ps= conn.prepareStatement("select*from doctr");

            // Processing ResultSet and populating doctors list
            while (rs.next()) {
                String a = rs.getString("studentRegNo");
                String b = rs.getString("name");
                String c = rs.getString("prescription");
                String d = rs.getString("symptoms");
                String e = rs.getString("labTest");
                
                Patient patient = new Patient(a, b, c, d, e);
                // Set doctors list as an attribute in request
                request.setAttribute("patient", patient); 
            }

            // Forwarding the request to the JSP page
            request.getRequestDispatcher("labwork.jsp").forward(request, response);
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exception
            }
        }
    }
}
