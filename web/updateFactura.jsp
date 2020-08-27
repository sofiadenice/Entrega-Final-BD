<%-- 
    Document   : updateFactura
    Created on : Jul 21, 2020, 9:14:49 AM
    Author     : balbi
--%>

<%@page import="eduwebapp.objects.FacturaObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Factura</title>
    </head>
    <%
        FacturaObj facturaObj = (FacturaObj)request.getSession().getAttribute("facturaObject");
    %>
    <body>
        <h1>Update Factura</h1>
        <br>
        
        <form action="FacturaServlet" method="get">
            
            Fecha de emision:
            <br>
            <input type="date" id="fecha" name="fecha" value="<%= facturaObj.getFechaDeEmision() %>"/>/>
            <br><br>
            Hora de emision: 
            <br>
            <input type="text" id="hora" name="hora" value="<%= facturaObj.getHoraDeEmision() %>"/>
            <br><br>
            Correlativo:
            <br>
            <input type="number" id="correlativo" name="correlativo" value="<%= facturaObj.getCorrelativo() %>"/>
            <br><br>
            Id Tratamiento:
            <br>
            <input type="number" id="idTratamiento" name="tratamiento_id" value="<%= facturaObj.getIdTratamiento() %>"/>   
            <br><br>
            Total:
            <br>
            <input type="number" id="total" name="Total" value="<%= facturaObj.getTotal() %>"/>
            <br><br>
            <input type="submit" value="Send" />
            
           
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= facturaObj.getIdFactura() %>"/>
        </form>
    </body>
</html>
