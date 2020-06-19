<%-- 
    Document   : home
    Created on : 19/06/2020, 14:36:59
    Author     : Fernanda
--%>

<%@page import="db.Attempt"%>
<%@page import="db.User"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/JSPF/logged.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/JSPF/header.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%@ include file="WEB-INF/JSPF/menu.jspf" %>
        <div>         
            <h1>Seja bem vindo ao desafio do Web Quiz.</h1>
        </div>
            <center>
                <h6>Teste seus conhecimentos respondendo a esse Web Quiz:</h6>
                
            </center>


        <%@ include file="WEB-INF/JSPF/footer.jspf" %>
    </body>
</html>
