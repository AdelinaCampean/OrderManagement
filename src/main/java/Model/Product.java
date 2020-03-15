package Model;
/**
 * Aceasta clasa este legatura tabelelor cu baza de date, avand acelasi nume cu tabela Product si variabilele de instanta reprezinta numele coloanelor din tabela
 * @author Adelina
 *
 */
public class Product {
	private int idProducts;
	private String name;
	private int quantity;
	
	public Product(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	
	public Product()
	{
		
	}

	public Product(int idProducts, String name, int quantity) {
		super();
		this.idProducts = idProducts;
		this.name = name;
		this.quantity = quantity;
	}

	public int getIdProducts() {
		return idProducts;
	}
	
	public void setIdProducts(int idProducts) {
		this.idProducts = idProducts;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Produsul "+ this.name+ " cu id: "+ this.idProducts;
	}
	
}
