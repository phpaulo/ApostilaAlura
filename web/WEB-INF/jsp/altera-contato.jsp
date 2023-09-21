<%-- 
    Document   : altera-contato
    Created on : 20/09/2023, 17:24:36
    Author     : Paulo Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="componentCalendar" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
        <title>Altera Contato</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />
        
        <form action="mvc?logica=AlterarContatoLogica" method="POST">
            <input type="hidden" name="id" value="${contato.id}"/>
            Nome: <input type="text" name="nome" value="${contato.nome}"/><br />
            E-mail: <input type="text" name="email" value="${contato.email}"/><br/>
            Endereço: <input type="text" name="endereco" value="${contato.endereco}"/><br/>           
            Data Nascimento: <input type="text" name="dataNascimento" value="<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />"><br/>                       
            
            <input type="submit" value="Gravar" />
            
        </form>
        <a href="mvc?logica=ListaContatosLogica">Retornar a lista de Contatos</a>
        
        <c:import url="rodape.jsp" /> 
    </body>
</html>
