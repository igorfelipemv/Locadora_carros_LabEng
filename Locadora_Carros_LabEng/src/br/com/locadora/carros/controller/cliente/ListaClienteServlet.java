package br.com.locadora.carros.controller.cliente;

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

@WebServlet("/")
public class ListaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		try {
			ClienteDAO clienteDao = new ClienteDAO();
			listaCliente = clienteDao.getAllClientes();
			clienteDao.conexao.close();
			
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		request.setAttribute("listacliente", listaCliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrocliente.jsp");
		dispatcher.forward(request, response);
	}

}
