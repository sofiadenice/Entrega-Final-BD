<%-- 
    Document   : updateTeacher
    Created on : Jul 21, 2020, 9:14:49 AM
    Author     : balbi
--%>

<%@page import="eduwebapp.objects.PacienteObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Paciente</title>
    </head>
    <%
        PacienteObj pacienteObj = (PacienteObj)request.getSession().getAttribute("pacienteObject");
    %>
    <body>
        <h1>Update Paciente</h1>
        <br>
        
        <form action="PacienteServlet" method="get">
            Nombre: 
            <br>
            <input type="text" id="Nombre" name="Nombre" value="<%= pacienteObj.getNombre()%>"/>
            <br><br>
            Apellido:
            <br>
            <input type="text" id="Apellido" name="Apellido" value="<%= pacienteObj.getApellido()%>"/>
            <br><br>
            Sexo:
            <br>
            <input type="text" id="Sexo" name="Sexo" value="<%= pacienteObj.getSexo()%>"/>
            <br><br>
            Edad:
            <br>
            <input type="number" id="Edad" name="Edad" value="<%= pacienteObj.getEdad() %>"/>
            <br><br>
            Direccion:
            <br>
            <input type="text" id="Direccion" name="Direccion" value="<%= pacienteObj.getDireccion()%>"/>
            <br><br>
            Contacto:
            <br>
            <input type="number" id="Contacto" name="Contacto" value="<%= pacienteObj.getContacto() %>"/>
            <br><br>
            Id Factura:
            <br>
            <input type="number" id="IdFactura" name="IdFactura" value="<%= pacienteObj.getIdFactura() %>"/>
            <br><br>
            Id Factura Tratamiento:
            <br>
            <input type="number" id="IdFacturaTratamiento" name="IdFacturaTratamiento" value="<%= pacienteObj.getIdFacturaTratamiento() %>"/>
            <br><br>
            <input type="submit" value="Send" />
           
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= pacienteObj.getIdPaciente() %>"/>
        </form>
    </body>
</html>
