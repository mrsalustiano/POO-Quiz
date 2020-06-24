<%-- 
    Document   : login
    Created on : 19/06/2020, 14:37:11
    Author     : Fernanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="db.User"%>
<%@page import="web.DbListener"%>
<%@include file="WEB-INF/JSPF/logged.jspf" %>
<%    if (logged != null) {
        response.sendRedirect("home.jsp");
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/JSPF/header.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%@ include file="WEB-INF/JSPF/menu.jspf" %>
        <div>
            <div>
                <h1>Login</h1>
          <%
           String errorMessage = null;
            if(request.getParameter("session.login") != null){
                String login = request.getParameter("user.login");
                String password = request.getParameter("user.password");
                try{
                    User user = User.getUser(login, password);
                    if(user == null){
                        errorMessage = "Login/password incorrect";
                    }else{
                        session.setAttribute("user.login", login);
                        session.setAttribute("user.name", user.getName());
                        response.sendRedirect(request.getRequestURI());
                    }
                }catch(Exception ex){
                    errorMessage = ex.getMessage();
                }
            }else if(request.getParameter("session.logout") != null){
                session.removeAttribute("user.login");
                session.removeAttribute("user.name");
                response.sendRedirect(request.getRequestURI());
            }
            %>
            <%if(session.getAttribute("user.login") == null){%>
                <form method="post">
                    <div>
                        <input type="text" id="user" name="user.login" placeholder="Login" required>
                        <input type="password" id="user" name="user.password" placeholder="Password" required>
                        <button type="submit" value="Log in">Login</button>               
                    </div>  
                </form>
                <%if(errorMessage != null){%>
                <div style="color:red"><%= errorMessage %></div>
                <%}%>
            <%}%>
            <%if(DbListener.exceptionMessage != null){%>
                <h3 style="color:red"><%= DbListener.exceptionMessage %></h3>
            <%}%>
            </div>
        </div>
    </body>
</html>
