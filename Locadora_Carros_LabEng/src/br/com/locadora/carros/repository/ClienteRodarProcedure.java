package br.com.locadora.carros.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

import br.com.locadora.carros.model.Cliente;
import br.com.locadora.carros.persistence.ClienteDAO;
import br.com.locadora.carros.persistence.ConectionMySqlJDBC;
import br.com.locadora.carros.persistence.IConnectionJDBC;

@WebServlet("/rodarprocedure")
public class ClienteRodarProcedure extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException{
		String nome = request.getParameter("nome");
		
		String query = "{ CALL alteraNomesClientes(?) }";
		 //Conector
		CallableStatement statment;
		try {
			IConnectionJDBC connectionAux = new ConectionMySqlJDBC();
			Connection conn =  connectionAux.getConnection();
			statment = (CallableStatement) conn.prepareCall(query);
			statment.setString(1, nome);
			statment.executeQuery();
			//statment.executeUpdate();
			connectionAux.commit();
			
			List<Cliente> listaCliente = new ArrayList<Cliente>();
			ClienteDAO  clienteDao = new ClienteDAO();
			listaCliente = clienteDao.getAllClientes();
			
			if(listaCliente.size() > 0 ) {
				String mensagem_de_retorno = "Todos os nomes dos Clientes foram alterados pelo nome: "+nome;
				request.setAttribute("listacliente", listaCliente);
				request.setAttribute("msg_retorno", mensagem_de_retorno);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrocliente.jsp");
				dispatcher.forward(request, response);
			}
				
		}catch (Exception ex) {
			ex.printStackTrace();
		}
      
	}
}
