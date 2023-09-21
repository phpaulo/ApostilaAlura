package logica;

import dao.ContatoDao;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;


/**
 * @brief Classe NewClass
 * @author Paulo Henrique
 * @date   criado em: 05/09/2023
 */
public class RemoveContatoLogica implements Logica {
    
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Contato contato = new Contato();
        contato.setId(id);

        // (procure o ContatoDao no código existente)
        // busca a conexão pendurada na requisição
        Connection connection = (Connection) request.getAttribute("connection");
        
        // passe a conexão no contrutor
        ContatoDao dao = new ContatoDao(connection);
        dao.remove(contato);
        
        System.out.println("Excluindo contato...");
                
        return "mvc?logica=ListaContatosLogica";
    }

}
