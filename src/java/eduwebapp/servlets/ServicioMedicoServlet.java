package eduwebapp.servlets;

import eduwebapp.logic.ServicioMedicoLogic;
import eduwebapp.objects.ServicioMedicoObj;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServicioMedicoServlet", urlPatterns = {"/ServicioMedicoServlet"})
public class ServicioMedicoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String strConnString = "jdbc:mysql://localhost/hospitaldb?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strFormId = request.getParameter("formid");
        
        ServicioMedicoLogic logic = new ServicioMedicoLogic(strConnString);
        request.getSession().setAttribute("rows", 0);
        
        String diagnostico, fecha, hora, stridServicioMedico, stridMedico, stridPaciente, strNumeroCama;
        int rows, idServicioMedico, idMedico, idPaciente, numeroCama;
        
        switch(strFormId)
        {
            case "1":
                System.out.println("insert new Servicio Medico");
                
                //al inicio
                diagnostico = request.getParameter("diagnostico_enfermedad");
                fecha = request.getParameter("fecha");
                hora = request.getParameter("hora");
                stridServicioMedico = request.getParameter("id");
                idServicioMedico = Integer.parseInt(stridServicioMedico);
                stridMedico = request.getParameter("id_medico");
                idMedico = Integer.parseInt(stridMedico);
                stridPaciente = request.getParameter("id_expediente");
                idPaciente = Integer.parseInt(stridPaciente);
                strNumeroCama = request.getParameter("id_paciente_cama");
                numeroCama = Integer.parseInt(strNumeroCama);
                
                //enmedio
                rows = logic.insertNewServicioMedico(idServicioMedico, idMedico, idPaciente, numeroCama, diagnostico, fecha, hora);
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("MedicoServlet?formid=3");
                break;
            case "2":
                     System.out.println("code for delete Servicio Medico");
                      stridServicioMedico = request.getParameter("id");
                      idServicioMedico = Integer.parseInt(stridServicioMedico);
                
                //enmedio
                rows = logic.deleteServicioMedico(idServicioMedico);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ServicioMedicoServlet?formid=3");
                
             
                break;
            case "3":
                System.out.println("get all Medicos");
                //enmedio
                ArrayList<ServicioMedicoObj> serviciomedicoArray = logic.getAllServicioMedico();

                
                //al final
                request.getSession().setAttribute("serviciomedicoarray", serviciomedicoArray);
                response.sendRedirect("ServicioMedicoMain.jsp");
                
                break;
            case "4":
                System.out.println("code for update part 1...");
                
                //al inicio
                stridServicioMedico = request.getParameter("id");
                idServicioMedico = Integer.parseInt(stridServicioMedico);
                
                //enmedio
                logic = new ServicioMedicoLogic(strConnString);
                ServicioMedicoObj serviciomedicoObject = logic.getServicioMedicoById(idServicioMedico);
                
                //al final
                request.getSession().setAttribute("serviciomedicoObject", serviciomedicoObject);
                response.sendRedirect("updateServicioMedico.jsp");
                break;
            case "5":
                System.out.println("code for update part 2...");
                
                diagnostico = request.getParameter("diagnostico_enfermedad");
                fecha = request.getParameter("fecha");
                hora = request.getParameter("hora");
                stridServicioMedico = request.getParameter("id");
                idServicioMedico = Integer.parseInt(stridServicioMedico);
                stridMedico = request.getParameter("id_medico");
                idMedico = Integer.parseInt(stridMedico);
                stridPaciente = request.getParameter("id_expediente");
                idPaciente = Integer.parseInt(stridPaciente);
                strNumeroCama = request.getParameter("id_paciente_cama");
                numeroCama = Integer.parseInt(strNumeroCama);
                
                rows = logic.updateServicioMedico(idServicioMedico, idMedico, idPaciente, numeroCama, diagnostico, fecha, hora);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ServicioMedicoServlet?formid=3");
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
