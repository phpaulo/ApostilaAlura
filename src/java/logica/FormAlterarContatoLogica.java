package logica;

import dao.ContatoDao;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;

/**
 * @brief Classe AlterarContatoLogica
 * @author Paulo Henrique
 * @date criado em: 20/09/2023
 */
public class FormAlterarContatoLogica implements Logica {
    
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));

        // busca a conexão pendurada na requisição
        Connection connection = (Connection) request.getAttribute("connection");
        
        // passe a conexão no contrutor
        ContatoDao dao = new ContatoDao(connection);

        Contato contato = dao.get(id);

        request.setAttribute("contato", contato);

        return "/WEB-INF/jsp/altera-contato.jsp";
    }

}
