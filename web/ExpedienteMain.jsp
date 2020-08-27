<%-- 
    Document   : teacherMain
    Created on : Jul 20, 2020, 6:59:00 AM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.ExpedienteObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expediente Main</title>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<ExpedienteObj> array = 
                (ArrayList<ExpedienteObj>)request.getSession()
                        .getAttribute("expedientearray");
    %>
    <body>
        <h1>Expediente Main</h1>
        <br>
        
        <a href="newExpediente.html">New Expediente</a>
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
             <th>Id Expediente</th>
            <th>Fecha de ingreso</th>
            <th>Fecha de alta</th>
            <th>Id Paciente</th>
          </tr>
          <%
              Iterator<ExpedienteObj> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  ExpedienteObj temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
          %>
                    <tr>
                      <td><%= temp.getIdExpediente() %></td>
                      <td><%= temp.getFechaIngreso() %></td>
                      <td><%= temp.getFechaAlta() %></td>
                      <td><%= temp.getIdPaciente() %></td>

                      <td><a href="ExpedienteServlet?formid=4&id=<%= temp.getIdExpediente() %>">update</a></td>
                      <td><a href="ExpedienteServlet?formid=2&id=<%= temp.getIdExpediente() %>">delete</a></td>
                    </tr>
          <%
                   }
              }
          %>
          
        </table>
    </body>
</html>
