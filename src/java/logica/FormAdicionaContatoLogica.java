package logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @brief Classe AdicionaContatoLogica
 * @author Paulo Henrique
 * @date criado em: 05/09/2023
 */
public class FormAdicionaContatoLogica implements Logica {
   
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        
        //pegando os parâmetros do request
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String dataEmTexto = request.getParameter("dataNascimento");       
        
        // Guarda a lista no request
        request.setAttribute("nome", nome);
        request.setAttribute("email", email);
        request.setAttribute("endereco", endereco);
        request.setAttribute("dataNascimento", dataEmTexto);

        return "/WEB-INF/jsp/adiciona-contato.jsp";
    }

}
