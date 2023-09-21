<%-- 
    Document   : contato-adicionado
    Created on : 05/09/2023, 10:05:26
    Author     : Paulo Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contato adicionado</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        Contato ${param.nome} adicionado com sucesso!
        <a href="mvc?logica=ListaContatosLogica">Lista de Contatos</a>
        <c:import url="rodape.jsp"/>
    </body>
</html>
