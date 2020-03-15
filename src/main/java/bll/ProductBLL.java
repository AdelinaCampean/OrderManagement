package bll;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.swing.JTable;

import DAO.AbstractDAO;
import DAO.ProductDAO;

import Model.Product;
import bll.validators.Validator;

public class ProductBLL {
	

	private ArrayList<Validator<Product>> validators;
	private ProductDAO prodDAO;

	public ProductBLL() {
		validators = new ArrayList<Validator<Product>>();

		prodDAO = new ProductDAO();
	}

	/**
	 * Metoda are rolul de a gasi un produs in functie de id-ul acestuia, astfel incat sa avem acces la celelalte atribute ale sale
	 * @param id-ul produsului
	 * @return produsul obtinut, cu toate valorile sale
	 */
	public Product findProductById(int id) {
		Product p = prodDAO.findById(id);
		if (p == null) {
			throw new NoSuchElementException("The product with id =" + id + " was not found!");
		}
		return p;
	}
	
	public void insertProduct(Product pro) {
		
			String pop = new String();
			pop = "(" +'"'+pro.getName()+'"'+","+pro.getQuantity()+");";
			prodDAO.insert(pro,pop);
		
	}
	
	/**
	 * Metoda afiseaza toate produsele introduse in tabela Product
	 * @return o lista de produse
	 */
	
	public List<Product> findAllProducts() {
		
		return (List<Product>) prodDAO.findAll();
	}

	public JTable createTable(Object object) {
		return prodDAO.createTable(object);
		
	}
	
	public void updateProduct(Product pro) {
		String[] val = new String[3];
		val[0]=pro.getIdProducts()+"";
		val[1]='"'+pro.getName()+'"';
		val[2]=pro.getQuantity()+"";
		
		prodDAO.update(pro, pro.getIdProducts(), val,"idProducts");
	}
	
	public void deleteProduct(Product pro) {
		prodDAO.delete(pro,"idProducts", pro.getIdProducts());
	}
	
}
