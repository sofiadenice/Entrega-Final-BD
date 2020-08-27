<%-- 
    Document   : Enfermeras
    Created on : Aug 25, 2020, 5:16:15 PM
    Author     : Sofia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Bienvenida/o enfermera/o </title>
    </head>
     <%
            String message 
                    = (String)request.getSession().getAttribute("message");
        %>
        
    <body>
        <h1>Log in Enfermera/o</h1>
        <br>
        
        <div>
            <%
                if(message!=null && !message.equals(""))
                {
            %>
            <p style="color:red;"><%= message %></p>
            <%
                }
            %>
        </div>
        <br>
        
           <form action="UsuarioServlet" method="post">
            User:<br>
            <input type="User" name="User" required/>
            <br><br>
            Password:<br>
            <input type="Password" name="Password" required/>
            <br><br>
            Cargo:<br>
            <input type="Cargo" name="Cargo" required/>
            <br><br>
            <input type="submit" value="Login"/>
            <input type="hidden" name="formid" value="3"/>
          
            
        </form>
    </body>
    <br>
    <a href="index.html">Regresar a la pagina principal</a>
</html>
