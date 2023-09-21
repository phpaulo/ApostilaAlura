package logica;

import dao.ContatoDao;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;

/**
 * @brief Classe AdicionaContatoLogica
 * @author Paulo Henrique
 * @date   criado em: 19/09/2023
 */
public class AdicionaContatoLogica implements Logica {
    
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        
        //pegando os parâmetros do request
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String dataEmTexto = request.getParameter("dataNascimento");
        
        Calendar dtNascimento = null;

        //fazendo a conversão da data
        try {
            if (dataEmTexto != null) {                             
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
                dtNascimento = Calendar.getInstance();
                dtNascimento.setTime(date);
            } else {
                System.out.println("O valor da data é nulo!");
            }
        } catch (ParseException ex) {
            System.out.println("Erro de conversão de data!");
            System.out.println(ex.getMessage());
            return null; //para a execução do método
        }
        
        //monta um objeto contato
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);
        contato.setDataNascimento(dtNascimento);
        
        
//        System.out.println("Nome: "+nome);
//        System.out.println("Email: "+email);
//        System.out.println("Endereco: "+endereco);
//        System.out.println("Data nascimento: "+dtNascimento);
        
        //salva o contato       
        // busca a conexão pendurada na requisição
        Connection connection = (Connection) request.getAttribute("connection");
        
        // passe a conexão no contrutor
        ContatoDao dao = new ContatoDao(connection);
        dao.adiciona(contato);
        
        // Guarda a lista no request
        request.setAttribute("nome", nome);
        
        
        return "/WEB-INF/jsp/contato-adicionado.jsp";
    }

}
