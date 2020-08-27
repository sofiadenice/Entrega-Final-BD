<%-- 
    Document   : MedicoMain
    Created on : 08-25-2020, 12:23:11 AM
    Author     : edgar
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.MedicoObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medico Main</title>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<MedicoObj> array = 
                (ArrayList<MedicoObj>) request.getSession()
                        .getAttribute("medicoarray");
    %>
    <body>
        <h1>Medico Main</h1>
        <br>
        
        <a href="newMedico.html">New medico</a>
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
             <th>Id Medico</th>
            <th>Nombre:</th>
            <th>Apellido:</th>
            <th>Cargo:</th>
            <th>User:</th>
            <th>Total</th>
          </tr>
          <%
              Iterator<MedicoObj> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  MedicoObj temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
          %>
                    <tr>
                      <td><%= temp.getIdDoctor()%></td>
                      <td><%= temp.getNombreDoctor() %></td>
                      <td><%= temp.getApellidoDoctor() %></td>
                      <td><%= temp.getCargo() %></td>
                      <td><%= temp.getUsuario() %></td>
                      
                      <td><a href="MedicoServlet?formid=4&id=<%= temp.getIdDoctor() %>">update</a></td>
                      <td><a href="MedicoServlet?formid=2&id=<%= temp.getIdDoctor() %>">delete</a></td>
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
