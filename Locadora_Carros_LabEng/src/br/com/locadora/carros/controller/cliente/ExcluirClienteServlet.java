package br.com.locadora.carros.controller.cliente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.carros.model.Cliente;
import br.com.locadora.carros.persistence.ClienteDAO;

@WebServlet("/excluircliente")
public class ExcluirClienteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String paramId = request.getParameter("id");
		Long id = Long.parseLong(paramId);
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		
		try {
			ClienteDAO clienteDao = new ClienteDAO();
			clienteDao.removeCliente(cliente);
			//clienteDao.conexao.close();
			
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		response.sendRedirect("listaanimal");
	}
}
