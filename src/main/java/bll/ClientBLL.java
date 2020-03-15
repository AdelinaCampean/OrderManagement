package bll;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.swing.JTable;

import java.util.List;
import DAO.AbstractDAO;
import DAO.ClientDAO;
import Model.Client;
import Model.Product;
import bll.validators.Validator;

public class ClientBLL {

	private ArrayList<Validator<Client>> validators;
	private ClientDAO clientDAO;

	public ClientBLL() {
		validators = new ArrayList<Validator<Client>>();

		clientDAO = new ClientDAO();
	}

	public Client findClientById(int id) {
		Client c = clientDAO.findById(id);
		if (c == null) {
			throw new NoSuchElementException("Clientul cu id= " + id + " nu a fost gasit!");
		}
		
		return c;
	}
	/**
	 * Metoda are rolul de a insera un nou client in baza de date
	 * @param client este folosit pentru a prelua valorile din textField-uri
	 */
	public void insertClient(Client client) {
		
			String pop = new String();
			pop = "("+'"'+client.getName()+'"'+","+client.getAge()+");";
			
			clientDAO.insert(client,pop);
			//System.out.println(pop);
	}
	
	
	public List<Client> findAllClients() {
		
		return (List<Client>) clientDAO.findAll();
	}
	
	public JTable createTable(Object object) {
		return clientDAO.createTable(object);
		
	}
	
	/**
	 * Metoda actualizeaza un client deja existent in tabela, prin modificarea varstei sau a numelui unui client
	 * @param client 
	 */
	public void updateClient(Client client) {
		String[] val = new String[3];
		val[0]=client.getIdclients()+"";
		val[1]='"'+client.getName()+'"';
		val[2]=client.getAge()+"";
		
		clientDAO.update(client, client.getIdclients(), val,"idclients");
	}
	
	public void deleteClient(Client cl) {
		clientDAO.delete(cl,"idclients", cl.getIdclients());
	}
	
}
