package br.com.locadora.carros.controller.cliente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.carros.model.Cliente;
import br.com.locadora.carros.persistence.ClienteDAO;

@WebServlet("/mostracliente")
public class MostraClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Long id = Long.parseLong(paramId);
		
		Cliente clientePesquisado = new Cliente();
		
		clientePesquisado.setId(id);
		
		try {
			ClienteDAO clienteDao = new ClienteDAO();
			clientePesquisado = clienteDao.findCliente(clientePesquisado);
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		request.setAttribute("cliente", clientePesquisado);
		RequestDispatcher rd = request.getRequestDispatcher("alteracliente.jsp");
		rd.forward(request, response);
	}

}
