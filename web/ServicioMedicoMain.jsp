<%-- 
    Document   : ServicioMedicoMain
    Created on : 08-25-2020, 02:44:58 AM
    Author     : edgar
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.ServicioMedicoObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicio Medico Main</title>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<ServicioMedicoObj> array = 
                (ArrayList<ServicioMedicoObj>) request.getSession()
                        .getAttribute("serviciomedicoarray");
    %>
    <body>
        <h1>Servicio Medico Main</h1>
        <br>
        
        <a href="newServicioMedico.html">New servicio medico</a>
        <br><br>
        <%
        if(rows>0)
        {
        %>
            <p style="color:red;"><%= rows %> affected</p>
            <br><br>
        <%
        }
        %>
        <table style="width:40%" border="1">
          <tr>
             <th>Id Servicio Medico:</th>
            <th>Medico responsable:</th>
            <th>Id Paciente:</th>
            <th>Numero de cama:</th>
            <th>Diagnostico o Enfermedad:</th>
            <th>Fecha:</th>
            <th>Hora:</th>
          </tr>
          <%
              Iterator<ServicioMedicoObj> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  ServicioMedicoObj temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
          %>
                    <tr>
                      <td><%= temp.getIdServicioMedico()%></td>
                      <td><%= temp.getIdMedico() %></td>
                      <td><%= temp.getIdPaciente() %></td>
                      <td><%= temp.getNumeroCama() %></td>
                      <td><%= temp.getDiagnostico() %></td>
                      <td><%= temp.getFecha() %></td>
                      <td><%= temp.getHora() %></td>
                      
                      <td><a href="ServicioMedicoServlet?formid=4&id=<%= temp.getIdServicioMedico() %>">update</a></td>
                      <td><a href="ServicioMedicoServlet?formid=2&id=<%= temp.getIdServicioMedico() %>">delete</a></td>
                    </tr>
          <%
                   }
              }
          %>
          
        </table>
          
          <br><br>
          <a href="index.html">regresar</a>
    </body>
</html>
