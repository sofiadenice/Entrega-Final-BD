
package eduwebapp.servlets;

import eduwebapp.logic.TratamientoLogic;
import eduwebapp.objects.TratamientoObj;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TratamientoServlet", urlPatterns = {"/TratamientoServlet"})
public class TratamientoServlet extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  
   {
        String strConnString = "jdbc:mysql://localhost/hospitaldb?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strFormId = request.getParameter("formid");
        
        TratamientoLogic logic = new TratamientoLogic(strConnString);
       
        String strMedicamento, strIdTratamiento, strPrecio;
        int rows, iIdTratamiento;
        request.getSession().setAttribute("rows", 0);
        
        switch(strFormId)
        {
            case "1":
                System.out.println("insert new tratamiento");
                
                //al inicio
                
                strMedicamento = request.getParameter("medicamento");
                strPrecio = request.getParameter("precio");
                
                //enmedio
                rows = logic.insertNewTratamiento(strMedicamento, strPrecio);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("TratamientoServlet?formid=3");
                break;
            case "2":
                     System.out.println("code for delete tratamiento");
                      strIdTratamiento = request.getParameter("id");
                      iIdTratamiento = Integer.parseInt(strIdTratamiento);
                
                //enmedio
                rows = logic.deleteTratamieto(iIdTratamiento);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("TratamientoServlet?formid=3");
                
             
                break;
            case "3":
                System.out.println("get all Tratamiento");
                //enmedio
                ArrayList<TratamientoObj> tratamientoArray = logic.getAllTratamiento();
                
                //al final
                request.getSession().setAttribute("tratamientoarray", tratamientoArray);
                response.sendRedirect("TratamientoMain.jsp");
                
                break;
            case "4":
                System.out.println("code for update part 1...");
                
                //al inicio
                 strIdTratamiento = request.getParameter("id");
                iIdTratamiento = Integer.parseInt(strIdTratamiento);
                
                //enmedio
                logic = new TratamientoLogic(strConnString);
                TratamientoObj tratamientoObject = logic.getTratamientoById(iIdTratamiento);
                
                //al final
                request.getSession().setAttribute("tratamientoObject", tratamientoObject);
                response.sendRedirect("updateTratamiento.jsp");
                break;
            case "5":
                System.out.println("code for update part 2...");
                
                strIdTratamiento = request.getParameter("id");
                iIdTratamiento = Integer.parseInt(strIdTratamiento);
                
                strMedicamento = request.getParameter("medicamento");
                strPrecio = request.getParameter("precio");
               
                
                rows = logic.updateTratamiento(iIdTratamiento, strMedicamento, strPrecio);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("TratamientoServlet?formid=3");
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
