<%-- 
    Document   : updateTeacher
    Created on : Jul 21, 2020, 9:14:49 AM
    Author     : balbi
--%>

<%@page import="eduwebapp.objects.ExpedienteObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Expediente</title>
    </head>
    <%
        ExpedienteObj expedienteObj = (ExpedienteObj)request.getSession().getAttribute("expedienteObject");
    %>
    <body>
        <h1>Update Expediente</h1>
        <br>
        
        <form action="ExpedienteServlet" method="get">
            Fecha de ingreso: 
            <br>
            <input type="date" id="FechaIngreso" name="FechaIngreso" value="<%= expedienteObj.getFechaIngreso()%>"/>
            <br><br>
            Fecha de alta: 
            <br>
            <input type="date" id="FechaAlta" name="FechaAlta" value="<%= expedienteObj.getFechaAlta()%>"/>
            <br><br>
            Id Paciente:
            <br>
            <input type="number" id="IdPaciente" name="IdPaciente" value="<%= expedienteObj.getIdPaciente() %>"/>
            <br><br>
            <input type="submit" value="Send" />
           
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= expedienteObj.getIdExpediente() %>"/>
        </form>
    </body>
</html>
