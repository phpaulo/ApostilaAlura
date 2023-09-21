package logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @brief Classe PrimeiraLogica
 * @author Paulo Henrique
 * @date criado em: 05/09/2023
 */
public class PrimeiraLogica implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Executando a logica ...");
        System.out.println("Retornando o nome da página JSP ...");
        
        return "/WEB-INF/jsp/primeira-logica.jsp";
    }
}
