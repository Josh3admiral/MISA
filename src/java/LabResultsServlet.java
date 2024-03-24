import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.Lab;
import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Lab-Results")
public class LabResultsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establishing database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mis", "root", "pass123");

            // Fetching data from the database
            stmt = conn.prepareStatement("SELECT studentRegNo,name,labResults FROM labresults");
            rs = stmt.executeQuery();

            // Start HTML document
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Hospital Management System - Lab Results</title>");
            out.println("<style>");
            out.println("table { border-collapse: collapse; width: 100%; }");
            out.println("th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }");
            out.println("tr:hover { background-color: #f5f5f5; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            // Page header
            out.println("<h2>Lab Results</h2>");

            // Start form for processing selected records
            out.println("<form method='post' action='Doctr.html'>");

            // Start table
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Select</th>");
            out.println("<th>Student Reg No</th>");
            out.println("<th>Name</th>");
            out.println("<th>Lab Result</th>");
            out.println("</tr>");

            // Populate table with data from database
            while (rs.next()) {
                String studentRegNo = rs.getString("studentRegNo");
                String name = rs.getString("name");
                String labResults = rs.getString("labResults");

                out.println("<tr>");
                out.println("<td><input type='checkbox' name='selectedRecords' value='" + studentRegNo + "'></td>");
                out.println("<td>" + studentRegNo + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + labResults + "</td>");
                out.println("</tr>");
            }

            // End table
            out.println("</table>");

            // Submit button for processing selected records
            out.println("<input type='submit' value='Process Selected'>");

            // End form
            out.println("</form>");

            // End HTML document
            out.println("</body>");
            out.println("</html>");
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
