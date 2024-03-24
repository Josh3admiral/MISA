import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String role = request.getParameter("role");
        int userID = Integer.parseInt(request.getParameter("userID"));
        String password = request.getParameter("password");
        
        //Check if userID is 6681 and password is "lOGIN22"
        if(userID == 6681 && password.equals("lOGIN22")) {
            // Redirect based on role
            
            if (role.equals("doctor")) {
                response.sendRedirect("Cons.html");
            } else if (role.equals("lab_technician")) {
                response.sendRedirect("LabWork.html");
            } else if (role.equals("receptionist")) {
                response.sendRedirect("Recept.html"); 
            }else if(role.equals("labwork")) { 
                RequestDispatcher r=request.getRequestDispatcher("LabWorkServlet");
                r.forward(request,response);
            }else if (role.equals("labres")) {
                RequestDispatcher r=request.getRequestDispatcher("LabResultsServlet");
                r.forward(request,response);
            }else {
                //Display error message if credentials are invalid
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><head><title>Login Error</title></head><body>");
                out.println("<h2>Login Error</h2>");
                out.println("<p>Invalid userID or password. Please try again.</p>");
                out.println("<a href=\"index.html\">Try again.</a>");
                out.println("</body></html>");
            } 
        } 
        
    }
}



    

    