
package eduwebapp.servlets;

import eduwebapp.logic.ExpedienteLogic;
import eduwebapp.objects.ExpedienteObj;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ExpedienteServlet", urlPatterns = {"/ExpedienteServlet"})
public class ExpedienteServlet extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  
   {
        String strConnString = "jdbc:mysql://localhost/hospitaldb?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strFormId = request.getParameter("formid");
        
        ExpedienteLogic logic = new ExpedienteLogic(strConnString);
       
        String strFechaIngreso, strIdExpediente, strFechaAlta, strIdPaciente;
        int rows, iIdExpediente, iIdPaciente;
        request.getSession().setAttribute("rows", 0);
        
        switch(strFormId)
        {
            case "1":
                System.out.println("insert new expediente");
                
                //al inicio
                
                strFechaIngreso = request.getParameter("FechaIngreso");
                strFechaAlta = request.getParameter("FechaAlta");
                strIdPaciente = request.getParameter("idPaciente");
                                
                //enmedio
                rows = logic.insertNewExpediente(strFechaIngreso, strFechaAlta, strIdPaciente);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ExpedienteServlet?formid=3");
                break;
            case "2":
                     System.out.println("code for delete expediente");
                      strIdExpediente = request.getParameter("id");
                      iIdExpediente = Integer.parseInt(strIdExpediente);
                
                //enmedio
                rows = logic.deleteExpediente(iIdExpediente);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ExpedienteServlet?formid=3");
                             
                break;
            case "3":
                System.out.println("get all Expediente");
                //enmedio
                ArrayList<ExpedienteObj> expedienteArray = logic.getAllExpediente();
                
                //al final
                request.getSession().setAttribute("expedientearray", expedienteArray);
                response.sendRedirect("ExpedienteMain.jsp");
                
                break;
            case "4":
                System.out.println("code for update part 1...");
                
                //al inicio
                 strIdExpediente = request.getParameter("id");
                iIdExpediente = Integer.parseInt(strIdExpediente);
                
                //enmedio
                logic = new ExpedienteLogic(strConnString);
                ExpedienteObj expedienteObject = logic.getExpedienteById(iIdExpediente);
                
                //al final
                request.getSession().setAttribute("expedienteObject", expedienteObject);
                response.sendRedirect("updateExpediente.jsp");
                break;
            case "5":
                System.out.println("code for update part 2...");
                
                strIdExpediente = request.getParameter("id");
                iIdExpediente = Integer.parseInt(strIdExpediente);
                
                strFechaIngreso = request.getParameter("FechaIngreso");
                strFechaAlta = request.getParameter("FechaAlta");
                
                strIdPaciente = request.getParameter("id");
                iIdPaciente = Integer.parseInt(strIdPaciente);                
                
                rows = logic.updateExpediente(iIdExpediente, strFechaIngreso, strFechaAlta, iIdPaciente);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ExpedienteServlet?formid=3");
                break;
               default:
                break;
                
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
