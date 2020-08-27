<%-- 
    Document   : teacherMain
    Created on : Jul 20, 2020, 6:59:00 AM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.TratamientoObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tratamiento Main</title>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<TratamientoObj> array = 
                (ArrayList<TratamientoObj>)request.getSession()
                        .getAttribute("tratamientoarray");
    %>
    <body>
        <h1>Tratamiento Main</h1>
        <br>
        
        <a href="newTratamiento.html">New tratamiento</a>
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
             <th>Id Tratamiento</th>
            <th>Medicameto</th>
            <th>Cobro</th>
          </tr>
          <%
              Iterator<TratamientoObj> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  TratamientoObj temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
          %>
                    <tr>
                      <td><%= temp.getIdTratamiento() %></td>
                      <td><%= temp.getMedicamentos() %></td>
                      <td><%= temp.getPrecio() %></td>

                      <td><a href="TratamientoServlet?formid=4&id=<%= temp.getIdTratamiento() %>">update</a></td>
                      <td><a href="TratamientoServlet?formid=2&id=<%= temp.getIdTratamiento() %>">delete</a></td>
                    </tr>
          <%
                   }
              }
          %>
          
        </table>
    </body>
</html>
