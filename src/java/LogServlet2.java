import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LogServlet2")
public class LogServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String role = request.getParameter("role");
            // Redirect based on role
            
            if(role.equals("consultationRoom1")) { 
                RequestDispatcher r=request.getRequestDispatcher("ConsultationQueue1");
                r.forward(request,response);
            }else if(role.equals("consultationRoom2")) { 
                RequestDispatcher r=request.getRequestDispatcher("ConsultationQueue2");
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




    

    