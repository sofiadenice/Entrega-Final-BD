<%-- 
    Document   : sesionEnfermeras
    Created on : Aug 25, 2020, 5:26:58 PM
    Author     : Sofia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pagina principal</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Bienvenido/a a su sesion Enfermero/a</div>
        <br>
        <a href="PacienteServlet?formid=3">Go to paciente</a>
        <br>
        <a href="ExpedienteServlet?formid=3">Go to expediente</a>
        <br>
        <a href="ServicioMedicoServlet?formid=3">Go to servicio medico</a>
        <br>
        <a href="TratamientoServlet?formid=3">Go to tratamiento</a>
        <br>
        <a href="FacturaServlet?formid=3">Go to factura</a>
        <br>
    </body>
    <br>
    <a href="Enfermeras.jsp">Regresar</a>
</html>
