package bll;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JTable;

import DAO.AbstractDAO;
import DAO.OrderDAO;
import Model.Client;
import Model.Orderr;
import Model.Product;
import bll.validators.Validator;

public class OrderBLL {

	private ArrayList<Validator<Orderr>> validators;
	private OrderDAO orderDAO;

	public OrderBLL() {
		validators = new ArrayList<Validator<Orderr>>();

		orderDAO = new OrderDAO();
	}

	public Orderr findOrderById(int id) {
		Orderr or =  orderDAO.findById(id);
		if (or == null) {
			throw new NoSuchElementException("The order with id =" + id + " was not found!");
		}
		return or;
	}
	
	/**
	 * metoda are rolul de a plasa o comanda prin alegerea unui client si a unui produs 
	 * @param order este folosit pentru a prelua datele din textField-uri
	 * @return un obiect de tip produs pentru a-i putea modifica ulterior cantitatea, astfel incat sa se scada valoarea comandata
	 */
	public Product insertOrder(Orderr order) {
		PrintWriter writer;		
			ProductBLL p = new ProductBLL();
			ClientBLL c = new ClientBLL();
			String pop = new String();
			pop = "("+order.getIdclient()+","+order.getIdproduct()+","+order.getQuantity()+");";
			Product ax=p.findProductById(order.getIdproduct());
			Client cx=c.findClientById(order.getIdclient());
			String cc =cx.toString();
			String pp = ax.toString();
		  
			orderDAO.insert(order,pop);	
			
			try {
				writer = new PrintWriter("orderInfo.txt");
				writer.println("FACTURĂ\r\n");
				writer.println("Comanda contine: ");
				if(order.getQuantity()==1)
					writer.println(pp+"\r\nA fost comandata o bucata.");
				writer.println(pp+"\r\nAu fost comandate "+order.getQuantity()+" bucati.");
				writer.println("Produsul a fost comandat de :");
				writer.println(cc);
				writer.close();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} 
			return ax;
	}
	/**
	 * metoda afiseaza toate comenzile efectuate de clienti
	 * @return o lista de obiecte
	 */
	
	public List<Orderr> findAllOrders() {
		
		return (List<Orderr>) orderDAO.findAll();
	}

	public JTable createTable(Object object) {
		return orderDAO.createTable(object);
		
	}
	

}
