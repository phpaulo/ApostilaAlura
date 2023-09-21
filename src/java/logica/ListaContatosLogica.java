package logica;

import dao.ContatoDao;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;


/**
 * @brief Classe ListaContatosLogica
 * @author Paulo Henrique
 * @date   criado em: 05/09/2023
 */
public class ListaContatosLogica implements Logica {
    
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        Connection connection = (Connection)request.getAttribute("connection");
        ContatoDao dao = new ContatoDao(connection);
        
        // Monta a lista de contatos
        List<Contato> contatos = dao.getLista();
        
        // Guarda a lista no request
        request.setAttribute("contatos", contatos);
                
        return "/WEB-INF/jsp/lista-contatos.jsp";
    }

}
