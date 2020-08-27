<%-- 
    Document   : updateTeacher
    Created on : Jul 21, 2020, 9:14:49 AM
    Author     : balbi
--%>

<%@page import="eduwebapp.objects.TratamientoObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Classroom</title>
    </head>
    <%
        TratamientoObj tratamientoObj = (TratamientoObj)request.getSession().getAttribute("tratamientoObject");
    %>
    <body>
        <h1>Update tratamiento</h1>
        <br>
        
        <form action="TratamientoServlet" method="get">
            Medicamento: 
            <br>
            <input type="text" id="Medicamento" name="medicamento" value="<%= tratamientoObj.getMedicamentos()%>"/>
            <br><br>
            Precio:
            <br>
            <input type="number" id="precio" name="precio" value="<%= tratamientoObj.getPrecio() %>"/>
            <br><br>
            <input type="submit" value="Send" />
           
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= tratamientoObj.getIdTratamiento() %>"/>
        </form>
    </body>
</html>
