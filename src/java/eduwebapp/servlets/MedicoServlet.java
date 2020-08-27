package eduwebapp.servlets;

import eduwebapp.logic.MedicoLogic;
import eduwebapp.objects.MedicoObj;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MedicoServlet", urlPatterns = {"/MedicoServlet"})
public class MedicoServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String strConnString = "jdbc:mysql://localhost/hospitaldb?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strFormId = request.getParameter("formid");
        
        MedicoLogic logic = new MedicoLogic(strConnString);
        request.getSession().setAttribute("rows", 0);
        
        String nombreDoctor, apellidoDoctor, cargo, usuario, stridDoctor;
        int rows, idDoctor;
        
        switch(strFormId)
        {
            case "1":
                System.out.println("insert new Medico");
                
                //al inicio
                nombreDoctor = request.getParameter("nombre");
                apellidoDoctor = request.getParameter("apellido");
                cargo = request.getParameter("cargo");
                usuario = request.getParameter("usuario");
                
                
                //enmedio
                rows = logic.insertNewMedico(nombreDoctor, apellidoDoctor, cargo, usuario);
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("MedicoServlet?formid=3");
                break;
            case "2":
                     System.out.println("code for delete Medico");
                      stridDoctor = request.getParameter("id");
                      idDoctor = Integer.parseInt(stridDoctor);
                
                //enmedio
                rows = logic.deleteMedico(idDoctor);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("MedicoServlet?formid=3");
                
             
                break;
            case "3":
                System.out.println("get all Medicos");
                //enmedio
                ArrayList<MedicoObj> medicoArray = logic.getAllMedico();

                
                //al final
                request.getSession().setAttribute("medicoarray", medicoArray);
                response.sendRedirect("MedicoMain.jsp");
                
                break;
            case "4":
                System.out.println("code for update part 1...");
                
                //al inicio
                stridDoctor = request.getParameter("id");
                idDoctor = Integer.parseInt(stridDoctor);
                
                //enmedio
                logic = new MedicoLogic(strConnString);
                MedicoObj medicoObject = logic.getMedicoById(idDoctor);
                
                //al final
                request.getSession().setAttribute("medicoObject", medicoObject);
                response.sendRedirect("updateMedico.jsp");
                break;
            case "5":
                System.out.println("code for update part 2...");
                
                nombreDoctor = request.getParameter("nombre");
                apellidoDoctor = request.getParameter("apellido");
                cargo = request.getParameter("cargo");
                usuario = request.getParameter("usuario");
                stridDoctor = request.getParameter("id");
                idDoctor = Integer.parseInt(stridDoctor);
               
                
                rows = logic.updateMedico(idDoctor, nombreDoctor, apellidoDoctor, cargo, usuario);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("MedicoServlet?formid=3");
                break;
               default:
                break;
                
        }
    }
    
}

    