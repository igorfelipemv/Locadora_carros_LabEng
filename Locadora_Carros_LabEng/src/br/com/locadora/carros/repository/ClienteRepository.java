package br.com.locadora.carros.repository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.carros.model.Cliente;
import br.com.locadora.carros.persistence.ClienteDAO;

@WebServlet("/buscacliente")
public class ClienteRepository extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		String nome = request.getParameter("nome");
		
		
		try {
			ClienteDAO clienteDao = new ClienteDAO();
			listaCliente = clienteDao.getClientesByNameLike(nome);
			clienteDao.conexao.close();
			
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		if(listaCliente.size() > 0 ) {
			String mensagem_de_retorno = "";
			if(nome == "" || nome == null) mensagem_de_retorno = "Quantidade total de Clientes na base: "+listaCliente.size();
			else mensagem_de_retorno = "Quantiade de clientes iniciados com a sequencia: \""+nome+"\": "+listaCliente.size();
			
			request.setAttribute("mensagem_de_retorno", mensagem_de_retorno);
			request.setAttribute("listacliente", listaCliente);
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrocliente.jsp");
		dispatcher.forward(request, response);
	}
}
