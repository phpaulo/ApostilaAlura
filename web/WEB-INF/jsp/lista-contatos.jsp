<%-- 
    Document   : lista-contato
    Created on : 05/09/2023, 11:32:35
    Author     : Paulo Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista contatos</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />                
        
        <h1>Listagem dos contatos!</h1>
        <a href="mvc?logica=FormAdicionaContatoLogica">Incluir novo contato</a>
        <br />
        <br />
        <!<!-- utilizando o padrão MVC -->                
        <table border="1">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Endereço</th>
                    <th>Data Nascimento</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <!-- percorre contatos montando as linhas da tabela aaee88-->
            <c:forEach var="contato" items="${contatos}" varStatus="id">
                <tr bgcolor="#${id.count % 2 == 0 ? '#ADD8E6' : 'ffffff' }">
                    <td>${contato.nome}</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty contato.email}">
                                <a href="mailto=${contato.email}">${contato.email}</a>
                            </c:when>
                            <c:otherwise>
                                E-mail não informado
                            </c:otherwise>    
                        </c:choose>
                    </td>
                    <td>${contato.endereco}</td>
                    <td>
                        <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
                    </td>
                    <td>
                        <a href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a>
                        |
                        <a href="mvc?logica=FormAlterarContatoLogica&id=${contato.id}">Alterar</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </table>
        
        <c:import url="rodape.jsp" />
    </body>
</html>
