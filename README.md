# ApostilaAlura  

### **Sistema Web de Lista de Contato da apostila da Alura FJ-21**  
  
Este projeto tem como finalidade o estudo da apostila da Alura FJ-21 buscando consolidar o aprendizado adquirido.  
  
### **Público-alvo**  
  
O público alvo são todos que estão estudando a apostila FJ-21 da Alura e ou estudantes de programação.  
  
### **Benefícios**  
  
Os benefícios do sistema são todas as operações de um CRUD totalmente funcional:  
  
Create  
Read  
Update  
Delete.  
  
### **Arquitetura**  
Utilizando a arquitetura de MVC (Model, View, Controller), o sistema é desenvolvido em Java e usa uma arquitetura baseada em componentes. O sistema é composto por um servidor web, um banco de dados e um aplicativo cliente. O servidor web é responsável por servir as páginas web do sistema. O banco de dados é responsável por armazenar os dados. O aplicativo cliente é responsável por permitir que os usuários interajam com o sistema.  
  
### **Funcionalidades**  
  
O sistema oferece as seguintes funcionalidades:  
  
* Os usuários podem visualizar a lista de contatos;  
* Os usuários podem inserir um novo contato;  
* Os usuários podem alterar um contato da lista;  
* Os usuários podem deletar um contato da lista;  
  
### **Conclusão**  
  
O sistema web desenvolvido durante o estudo da apostila da Alura FJ-21.  
     
Esta versão de app utiliza um recurso importate: Filtro.  
Filtros são classes que permitem que executemos código antes da requisição e também depois que a resposta foi gerada. A ideia é ele interceptar as requests e executar algo.  
Foi implementado um FiltroConexao para interceptar TODAS as requisições da aplicação e gerenciar as conexões com o banco de dados. Com isso podemos abrir um recurso (conexão) antes quando chegar a request e fechar no final após a response ser gerada.   
