<%-- 
    Document   : bemvindo
    Created on : 04/09/2023, 08:06:53
    Author     : Paulo Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body {
                background-color: #fbfcfb;
                flex-direction: row;
                font-family: Aptos;
            }
            .page {
                background-color: #f0f3f1;
                font-size: 22px;
                font-weight: bold;
                margin: 5px auto;
                padding: 10px 5px;
                border-radius: 10px;
            }
            .container {
                background-color: #f0f3f1;
                margin: 10px auto;
                padding: 10px 5px;
                border-radius: 10px;
            }
            .container a {
                line-height: 15px;
            }
            .container p {                
                margin-bottom: 0px;
                margin-top: 0px;
            }
            .container p span {
                font-weight: bold;
            }
            .ultimoParagrafo {
                width: 700px;                
            }
            .ultimoParagrafo p {
                text-align: justify;
                margin-top: 4px;
                margin-bottom: 4px;
            }
        </style>
        <title>Bem vindo</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <br/>
        <%-- comentário em JSP aqui: nossa primeira página JSP --%>
                
        <% 
            String mensagem = "Bem vindo ao sistema de agenda da apostila da alura FJ-21!";
        %>        
        <% out.println(mensagem); %> 
        <br/>        
        <%
            String desenvolvido = "Desenvolvido por github.com/phpaulo";
        %>
        <%= desenvolvido %>
        <br/>
        <div class="page">      
            <%
                String paginas = "Páginas do projeto CRUD - Lista de Contatos:";
            %>
            <%= paginas%>
        </div>
        <div class="container">
            <a href="http://localhost:8080/ApostilaAlura/mvc?logica=ListaContatosLogica" target="_blank">Lista de Contatos</a>        
            <p>http://localhost:8080/ApostilaAlura/mvc?logica=ListaContatosLogica --- <span>OK! </span></p> 

            <a href="http://localhost:8080/ApostilaAlura/mvc?logica=FormAdicionaContatoLogica" target="_blank">Formulário Adiciona Contato</a>
            <p>http://localhost:8080/ApostilaAlura/mvc?logica=FormAdicionaContatoLogica ---<span> OK! </span></p>  

            <p>http://localhost:8080/ApostilaAlura/mvc?logica=AdicionaContatoLogica --- <span> OK! OBS: não há link, apenas a lógica por trás do Formulário Adiciona Contato</span></p>
            <p>http://localhost:8080/ApostilaAlura/mvc?logica=FormAlterarContatoLogica&id=1 --- <span> OK! OBS: não há link, apenas a lógica por trás do Formulário Alterar Contato</span></p>
        </div>
        <div class="ultimoParagrafo">
            <p>Todas as funções do CRUD estão funcionais.</p>
            <p>É possível realizar um cadastro de um novo contato, listar todos os contatos já cadastrados, alterar um contado da lista de contatos e deletar um contato.</p>
            <p>Esta versão de app utiliza um recurso importate: <span>Filtro.</span></p>
            <p>
                Filtros são classes que permitem que executemos código antes da requisição e também depois que a resposta foi gerada. A ideia é ele interceptar as requests e executar algo.
            </p>
            <p>
                Foi implementado um FiltroConexao para interceptar TODAS as requisições da aplicação e gerenciar as conexões com o banco de dados.
                Com isso podemos abrir um recurso (conexão) antes quando chegar a request e fechar no final após a response ser gerada.
            </p>
        </div>
        <%
            System.out.println("Tudo foi executado!");
        %>
        <%--	comentário em jsp --%>
    </body>
</html>
