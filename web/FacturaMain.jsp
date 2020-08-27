<%-- 
    Document   : teacherMain
    Created on : Jul 20, 2020, 6:59:00 AM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.FacturaObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura Main</title>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<FacturaObj> array = 
                (ArrayList<FacturaObj>) request.getSession()
                        .getAttribute("facturaarray");
    %>
    <body>
        <h1>Factura Main</h1>
        <br>
        
        <a href="newFactura.html">New factura</a>
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
             <th>Id Factura</th>
            <th>Fecha de emisión:</th>
            <th>Hora de emisión:</th>
            <th>Correlativo:</th>
            <th>Id Tratamiento</th>
            <th>Total</th>
          </tr>
          <%
              Iterator<FacturaObj> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  FacturaObj temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
          %>
                    <tr>
                      <td><%= temp.getIdFactura()%></td>
                      <td><%= temp.getFechaDeEmision() %></td>
                      <td><%= temp.getHoraDeEmision() %></td>
                      <td><%= temp.getCorrelativo() %></td>
                      <td><%= temp.getIdTratamiento() %></td>
                      <td><%= temp.getTotal() %></td>
                      
                      <td><a href="FacturaServlet?formid=4&id=<%= temp.getIdFactura() %>">update</a></td>
                      <td><a href="FacturaServlet?formid=2&id=<%= temp.getIdFactura() %>">delete</a></td>
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
