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

@WebServlet("/novocliente")
public class NovoClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setSobrenome(sobrenome);
		cliente.setRg(rg);
		cliente.setCpf(cpf);
		cliente.setTelefone(telefone);
		
		try {
			ClienteDAO clienteDao = new ClienteDAO();
			clienteDao.insertCliente(cliente);
			System.out.println("Cliente inserido com sucesso: "+cliente.getId());
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		response.sendRedirect("listacliente");
	}
}
