package br.com.locadora.carros.controller.cliente;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.carros.model.Usuario;
import br.com.locadora.carros.persistence.UsuarioDAO;

@WebServlet("/validausuario")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = new Usuario();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		try {
			UsuarioDAO userDAO = new UsuarioDAO();
			user = userDAO.buscarUsuario(login, senha);
			userDAO.conexao.close();
			
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		//System.out.println("User trazido: "+user.getLogin());
		if(user.getLogin() != null && user.getSenha() != null) {
			request.setAttribute("perfil", user.getPerfil());
			request.setAttribute("loginRetorno", user.getLogin());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrocliente.jsp");
			dispatcher.forward(request, response);
			
		}else {
			String mensagemLoginInvalido = "Usuário ou Senha são inválido(s)";
			request.setAttribute("mensagem", mensagemLoginInvalido);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
