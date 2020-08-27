<%-- 
    Document   : updateServicioMedico
    Created on : 08-25-2020, 02:56:00 AM
    Author     : edgar
--%>

<%@page import="hospitalwebapp.objects.ServicioMedicoObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Servicio Medico</title>
    </head>
    <%
        ServicioMedicoObj serviciomedicoObj = (ServicioMedicoObj)request.getSession().getAttribute("serviciomedicoObject");
    %>
    <body>
        <h1>Update Servicio Medico</h1>
        <br>
        
        <form action="ServicioMedicoServlet" method="get">
            
            Id Servicio Medico:
            <br>
            <input type="number" id="id" name="id" value="<%= serviciomedicoObj.getIdServicioMedico() %>"/>/>
            <br><br>
            Medico responsable: 
            <br>
            <input type="number" id="idMedico" name="idMedico" value="<%= serviciomedicoObj.getIdMedico() %>"/>
            <br><br>
            Id Paciente:
            <br>
            <input type="number" id="idPaciente" name="idPaciente" value="<%= serviciomedicoObj.getIdPaciente() %>"/>
            <br><br>
            Numero de cama:
            <br>
            <input type="number" id="numeroCama" name="numeroCama" value="<%= serviciomedicoObj.getNumeroCama() %>"/>   
            <br><br>
            Diagnostico o Enfermedad:
            <br>
            <input type="text" id="diagnostico" name="diagnostico" value="<%= serviciomedicoObj.getDiagnostico() %>"/>   
            <br><br>
            Fecha:
            <br>
            <input type="date" id="fecha" name="fecha" value="<%= serviciomedicoObj.getFecha() %>"/>   
            <br><br>
            Hora:
            <br>
            <input type="number" id="hora" name="hora" value="<%= serviciomedicoObj.getHora() %>"/>   
            <br><br>
            
           
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= serviciomedicoObj.getIdServicioMedico() %>"/>
        </form>
    </body>
</html>
