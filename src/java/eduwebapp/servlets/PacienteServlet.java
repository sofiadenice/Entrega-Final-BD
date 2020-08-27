
package eduwebapp.servlets;

import eduwebapp.logic.PacienteLogic;
import eduwebapp.objects.PacienteObj;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PacienteServlet", urlPatterns = {"/PacienteServlet"})
public class PacienteServlet extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  
   {
        String strConnString = "jdbc:mysql://localhost/hospitaldb?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strFormId = request.getParameter("formid");
        
        //SectionLogic logic;
        PacienteLogic logic = new PacienteLogic(strConnString);
       
        String strNombre, strApellido, strSexo, strDireccion, strEdad, strContacto, strIdFactura, 
                strIdFacturaTratamiento, strIdPaciente;
        int rows, iEdad, iContacto, iIdFactura, iIdFacturaTratamiento, iIdPaciente;
        request.getSession().setAttribute("rows", 0);
        
        switch(strFormId)
        {
            case "1":
                System.out.println("insert new paciente");
                
                //al inicio
                
                strNombre = request.getParameter("Nombre");
                strApellido = request.getParameter("Apellido");
                strSexo = request.getParameter("Sexo");
                strEdad = request.getParameter("Edad");
                iEdad = Integer.parseInt(strEdad);
                strDireccion = request.getParameter("Direccion");
                strContacto = request.getParameter("Contacto");
                iContacto = Integer.parseInt(strContacto);
                strIdFactura = request.getParameter("IdFactura");
                iIdFactura = Integer.parseInt(strIdFactura);
                strIdFacturaTratamiento = request.getParameter("IdFacturaTratamiento");
                iIdFacturaTratamiento = Integer.parseInt(strIdFacturaTratamiento);
                                
                //enmedio
                //logic = new SectionLogic(strConnString);
                rows = logic.insertNewPaciente(strNombre, strApellido, strSexo, strEdad, strDireccion, 
                        strContacto, iIdFactura, iIdFacturaTratamiento);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("PacienteServlet?formid=3");
                break;
            case "2":
                     System.out.println("code for delete paciente");
                     
                     //al inicio
                      strIdPaciente = request.getParameter("id");
                      iIdPaciente = Integer.parseInt(strIdPaciente);
                
                //enmedio
                rows = logic.deletePaciente(iIdPaciente);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("PacienteServlet?formid=3");
                             
                break;
            case "3":
                System.out.println("get all Paciente");
                //enmedio
                ArrayList<PacienteObj> pacienteArray = logic.getAllPaciente();
                
                //al final
                request.getSession().setAttribute("pacientearray", pacienteArray);
                response.sendRedirect("PacienteMain.jsp");
                
                break;
            case "4":
                System.out.println("code for update part 1...");
                
                //al inicio
                 strIdPaciente = request.getParameter("id");
                iIdPaciente = Integer.parseInt(strIdPaciente);
                
                //enmedio
                logic = new PacienteLogic(strConnString);
                PacienteObj pacienteObject = logic.getPacienteById(iIdPaciente);
                
                //al final
                request.getSession().setAttribute("pacienteObject", pacienteObject);
                response.sendRedirect("updatePaciente.jsp");
                break;
            case "5":
                System.out.println("code for update part 2...");
                
                strIdPaciente = request.getParameter("id");
                iIdPaciente = Integer.parseInt(strIdPaciente);
                
                strNombre = request.getParameter("Nombre");
                strApellido = request.getParameter("Apellido");
                strSexo = request.getParameter("Sexo");
                strDireccion = request.getParameter("Direccion");
                
                strEdad = request.getParameter("Edad");
                iEdad = Integer.parseInt(strEdad);
                strContacto = request.getParameter("Contacto");
                iContacto = Integer.parseInt(strContacto);
                strIdFactura = request.getParameter("IdFactura");
                iIdFactura = Integer.parseInt(strIdFactura);     
                strIdFacturaTratamiento = request.getParameter("IdFacturaTratamiento");
                iIdFacturaTratamiento = Integer.parseInt(strIdFacturaTratamiento);
                
                rows = logic.updatePaciente(iIdPaciente, strNombre, strApellido, strSexo, strEdad, strDireccion,
                        strContacto, strIdFactura, strIdFacturaTratamiento);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("PacienteServlet?formid=3");
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
