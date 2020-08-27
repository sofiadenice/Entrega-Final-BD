<%-- 
    Document   : updateMedico
    Created on : 08-25-2020, 12:49:25 AM
    Author     : edgar
--%>

<%@page import="hospitalwebapp.objects.MedicoObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Medico</title>
    </head>
    <%
        MedicoObj medicoObj = (MedicoObj)request.getSession().getAttribute("medicoObject");
    %>
    <body>
        <h1>Update Medico</h1>
        <br>
        
        <form action="MedicoServlet" method="get">
            
           Nombre:
            <br>
            <input type="text" id="nombre" name="nombre" value="<%= medicoObj.getNombreDoctor() %>"/>/>
            <br><br>
            Apellido: 
            <br>
            <input type="text" id="apellido" name="apellido" value="<%= medicoObj.getApellidoDoctor() %>"/>
            <br><br>
            Cargo:
            <br>
            <input type="text" id="cargo" name="cargo" value="<%= medicoObj.getCargo() %>"/>
            <br><br>
            Usuario:
            <br>
            <input type="text" id="usuario" name="usuario" value="<%= medicoObj.getUsuario() %>"/>   
            <br><br>
            
           
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= medicoObj.getIdDoctor() %>"/>
        </form>
    </body>
</html>
