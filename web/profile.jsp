<%-- 
    Document   : profile
    Created on : 19/06/2020, 14:37:25
    Author     : Fernanda
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.User"%>
<%@page import="db.Attempt"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/JSPF/logged.jspf" %>
<%  if (logged == null) {
        response.sendRedirect("login.jsp");
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/JSPF/header.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil do Usuário</title>
    </head>
    <body>

        <%@ include file="WEB-INF/JSPF/menu.jspf" %>

        <div>

            <h1>Bem Vindo, <%= logged%></h1>
        </div>
        <div>

            <div>

                <div>
                    <h2>Seus Últimos Testes</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Nota</th>
                                <th>Data</th>
                            </tr>
                        </thead>
                        <tbody>                            
                    </table>
                </div>
                <div>
                    <h2>Sua Média</h2>            
                </div>
                <a href="quiz.jsp">Realizar Quiz</a>
            </div>
        </div>
        <%@ include file="WEB-INF/JSPF/footer.jspf" %>
    </body>
</html>
