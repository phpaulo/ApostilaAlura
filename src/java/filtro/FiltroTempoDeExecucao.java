package filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * @brief Classe FiltroTempoDeExecucao
 * @author Paulo Henrique
 * @date criado em: 20/09/2023
 */
@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {

    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long tempoInicial = System.currentTimeMillis();
        chain.doFilter(request, response);
        long tempoFinal = System.currentTimeMillis();
        String uri = ((HttpServletRequest) request).getRequestURI();
        String parametros = ((HttpServletRequest) request)
                .getParameter("logica");
        System.out.println("Tempo da requisicao de " + uri
                + "?logica="
                + parametros + " demorou (ms): "
                + (tempoFinal - tempoInicial));
    }
    //	métodos	init	e	destroy	omitidos

}
