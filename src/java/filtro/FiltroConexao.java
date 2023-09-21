package filtro;

import dao.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @brief Classe FiltroConexao
 * @author Paulo Henrique
 * @date criado em: 20/09/2023
 */
@WebFilter("/*")
public class FiltroConexao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {        
    }

    // implementação do init e destroy, se necessário
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // abre uma conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        // "pendura um objeto no Request"
        request.setAttribute("connection", connection);

        // indica que o processamento do request deve prosseguir
        chain.doFilter(request, response);
        try {
            // fecha conexão
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connection.close();
                System.out.println("finally Closed conection");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void destroy() {       
    }

    

}
