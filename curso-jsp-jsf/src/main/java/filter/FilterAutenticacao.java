package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import connection.SingleConnectionBanco;

@WebFilter(urlPatterns = { "/principal/*" }) /* Intercepta todas as requisições que vierem do projeto ou mapeamento */
public class FilterAutenticacao extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	private static Connection connection;

	public FilterAutenticacao() {

	}

	/* Encerra os processo quando o servidor é parado */
	/* mataria os processo de conexão com banco */
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/* Intercepta as requisições e as respostas no sistema */
	/* Tudo que fizer no sistema vai fazer por aqui */
	/* validação de autenticação */
	/* Dar conmit e rolback de transaçãoe do banco */
	/* Validar e fazer redirecionamento de pagina */

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {

			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();

			String usuarioLogado = (String) session.getAttribute("usuario");

			String urlParaAutenticar = req.getServletPath();/* url que está sendo acessada */
			/* Validar se está logado senão redirecionar para a tela de login */

			if (usuarioLogado == null
					&& !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {/* Não esta logado */

				RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
				request.setAttribute("msg", "Por favor realize o login");
				redireciona.forward(request, response);
				return;/* Para a execução e redireciona e redireciona o login */

			} else {
				chain.doFilter(request, response);
			}
			
			connection.commit();/*Deu tudo certo, então comita as alterações no bando de dados*/
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	}

	/* Inicia os processo ou recursos quando o servidor sobre o projeto */
	/* iniciar a conexão com o banco */

	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnectionBanco.getConnection();
	}

}
