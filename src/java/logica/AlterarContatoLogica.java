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
 * @brief Classe AlterarContatoLogica
 * @author Paulo Henrique
 * @date   criado em: 20/09/2023
 */
public class AlterarContatoLogica implements Logica {
    
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String dataEmTexto = request.getParameter("dataNascimento");
        
        Calendar dtNascimento = null;

        //fazendo a conversão da data
        try {
            System.out.println("dataEmTexto "+dataEmTexto);
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
        contato.setId(id);
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);
        contato.setDataNascimento(dtNascimento);
        
//        System.out.println("Println da classe AlteraContatoLogica");
//        System.out.println("Id: "+contato.getId());
//        System.out.println("Nome: "+contato.getNome());
//        System.out.println("Email: "+contato.getEmail());
//        System.out.println("Endereco: "+contato.getEndereco());
//        System.out.println("Data nascimento: "+contato.getDataNascimento());
        
        //salva o contato       
        // busca a conexão pendurada na requisição
        Connection connection = (Connection) request.getAttribute("connection");
        
        // passe a conexão no contrutor
        ContatoDao dao = new ContatoDao(connection);
        dao.altera(contato);
        
        // Guarda a lista no request
        request.setAttribute("nome", nome);        
        
        return "/WEB-INF/jsp/contato-alterado.jsp";
    }

}
