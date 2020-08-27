<%-- 
    Document   : teacherMain
    Created on : Jul 20, 2020, 6:59:00 AM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.PacienteObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paciente Main</title>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<PacienteObj> array = 
                (ArrayList<PacienteObj>)request.getSession()
                        .getAttribute("pacientearray");
    %>
    <body>
        <h1>Paciente Main</h1>
        <br>
        
        <a href="newPaciente.html">New Paciente</a>
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
             <th>Id Paciente</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Sexo</th>
            <th>Edad</th>
            <th>Direccion</th>
            <th>Contacto</th>
            <th>Id Factura</th>
            <th>Id Factura Tratamiento</th>
          </tr>
          <%
              Iterator<PacienteObj> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  PacienteObj temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
          %>
                    <tr>
                      <td><%= temp.getIdPaciente() %></td>
                      <td><%= temp.getNombre() %></td>
                      <td><%= temp.getApellido() %></td>
                      <td><%= temp.getSexo() %></td>
                      <td><%= temp.getEdad() %></td>
                      <td><%= temp.getDireccion() %></td>
                      <td><%= temp.getContacto() %></td>
                      <td><%= temp.getIdFactura() %></td>
                      <td><%= temp.getIdFacturaTratamiento() %></td>

                      <td><a href="PacienteServlet?formid=4&id=<%= temp.getIdPaciente() %>">update</a></td>
                      <td><a href="PacienteServlet?formid=2&id=<%= temp.getIdPaciente() %>">delete</a></td>
                    </tr>
          <%
                   }
              }
          %>
          
        </table>
    </body>
</html>
