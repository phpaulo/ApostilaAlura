<%-- 
    Document   : cabecalho
    Created on : 04/09/2023, 14:05:21
    Author     : Paulo Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cabecalho</title>
    </head>
    <body>
        <c:url value="/img/caelum_logo.png" var="image"/>
        <img src="${image}" style="width: 40%; height: 180px;"/>
        <hr />
    </body>
</html>
