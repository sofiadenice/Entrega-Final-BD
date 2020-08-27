
package eduwebapp.servlets;

import eduwebapp.logic.FacturaLogic;
import eduwebapp.objects.FacturaObj;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FacturaServlet", urlPatterns = {"/FacturaServlet"})
public class FacturaServlet extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  
   {
        String strConnString = "jdbc:mysql://localhost/hospitaldb?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strFormId = request.getParameter("formid");
        
        FacturaLogic logic = new FacturaLogic(strConnString);
        request.getSession().setAttribute("rows", 0);
        
        String strFechaDeEmision, strHoraDeEmision, strTotal, strCorrelativo,strIdTratamiento, strIdFactura;
        int rows, iCorrelativo, iIdTratamiento,iIdFactura;
        

        
        switch(strFormId)
        {
            case "1":
                System.out.println("insert new Factura");
                
                //al inicio
                strFechaDeEmision = request.getParameter("fecha");
                strHoraDeEmision = request.getParameter("hora");
                strTotal = request.getParameter("Total");
                strIdTratamiento = request.getParameter("tratamiento_id");
                iIdTratamiento = Integer.parseInt(strIdTratamiento);
                strCorrelativo = request.getParameter("correlativo");
                iCorrelativo = Integer.parseInt(strCorrelativo);
                
                
                //enmedio
                rows = logic.insertNewFactura(strFechaDeEmision, strHoraDeEmision, iCorrelativo, strTotal, iIdTratamiento);
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("FacturaServlet?formid=3");
                break;
            case "2":
                     System.out.println("code for delete Factura");
                      strIdFactura = request.getParameter("id");
                      iIdFactura = Integer.parseInt(strIdFactura);
                
                //enmedio
                rows = logic.deleteFactura(iIdFactura);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("FacturaServlet?formid=3");
                
             
                break;
            case "3":
                System.out.println("get all Factura");
                //enmedio
                ArrayList<FacturaObj> facturaArray = logic.getAllFactura();

                
                //al final
                request.getSession().setAttribute("facturaarray", facturaArray);
                response.sendRedirect("FacturaMain.jsp");
                
                break;
            case "4":
                System.out.println("code for update part 1...");
                
                //al inicio
                 strIdFactura = request.getParameter("id");
                iIdFactura = Integer.parseInt(strIdFactura);
                
                //enmedio
                logic = new FacturaLogic(strConnString);
                FacturaObj facturaObject = logic.getFacturaById(iIdFactura);
                
                //al final
                request.getSession().setAttribute("facturaObject", facturaObject);
                response.sendRedirect("updateFactura.jsp");
                break;
            case "5":
                System.out.println("code for update part 2...");
                
                strIdFactura = request.getParameter("id");
                iIdFactura = Integer.parseInt(strIdFactura);
                strFechaDeEmision = request.getParameter("fecha");
                strHoraDeEmision = request.getParameter("hora");
                strTotal = request.getParameter("Total");
                strIdTratamiento = request.getParameter("tratamiento_id");
                iIdTratamiento = Integer.parseInt(strIdTratamiento);
                strCorrelativo = request.getParameter("correlativo");
                iCorrelativo = Integer.parseInt(strCorrelativo);
               
                
                rows = logic.updateFactura(iIdFactura, strFechaDeEmision, strHoraDeEmision, iCorrelativo, strTotal, iIdTratamiento);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("FacturaServlet?formid=3");
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



