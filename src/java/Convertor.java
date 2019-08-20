import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Convertor"})
public class Convertor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            double amt = Double.parseDouble(request.getParameter("amount"));
            double val = 0.0;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Convertor</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if(amt>0)
            {
                
                if(from.equalsIgnoreCase("India") && to.equalsIgnoreCase("India"))
                {
                    val = amt;
                    out.println("<b>"+amt+"</b> INR = <b>"+val+"</b> INR");
                }
                else if(from.equalsIgnoreCase("India") && to.equalsIgnoreCase("USA"))
                {
                    val = amt*0.014;
                    out.println("<b>"+amt+"</b> INR = <b>"+val+"</b> $");
                }
                else if(from.equalsIgnoreCase("India") && to.equalsIgnoreCase("Europe"))
                {
                    val = amt*0.013;
                    out.println("<b>"+amt+"</b> INR = <b>"+val+"</b> $");
                }
                else if(from.equalsIgnoreCase("USA") && to.equalsIgnoreCase("USA"))
                {
                    val = amt;
                    out.println("<b>"+amt+"</b> $ = <b>"+val+"</b> $");
                }
                else if(from.equalsIgnoreCase("USA") && to.equalsIgnoreCase("India"))
                {
                    val = amt*71.63;
                    out.println("<b>"+amt+"</b> $ = <b>"+val+"</b> INR");
                }
                else if(from.equalsIgnoreCase("USA") && to.equalsIgnoreCase("Europe"))
                {
                    val = amt*0.90;
                    out.println("<b>"+amt+"</b> $ = <b>"+val+"</b> Euro");
                }
                else if(from.equalsIgnoreCase("Europe") && to.equalsIgnoreCase("Europe"))
                {
                    val = amt;
                    out.println("<b>"+amt+"</b> Euro = <b>"+val+"</b> Euro");
                }
                else if(from.equalsIgnoreCase("Europe") && to.equalsIgnoreCase("India"))
                {
                    val = amt*79.43;
                    out.println("<b>"+amt+"</b> Euro = <b>"+val+"</b> INR");
                }
                else if(from.equalsIgnoreCase("Europe") && to.equalsIgnoreCase("USA"))
                {
                    val = amt*1.11;
                    out.println("<b>"+amt+"</b> Euro = <b>"+val+"</b> $");
                }
                else
                {
                    if(!(from.equalsIgnoreCase("India")||from.equalsIgnoreCase("usa")||from.equalsIgnoreCase("usa")))
                    {
                        out.println("<h1>SORRY</h1><p>"+from+" Country not found in our database!!!<p>");
                    }
                    else
                    {
                        out.println("<h1>SORRY</h1><p>"+to+" Country not found in our database!!!<p>");
                    }     
                }
            }
            else
            {
                out.println("<h1>ERROR</h1><p>Enter Amount more than zero!!!<p>");
            }          
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
