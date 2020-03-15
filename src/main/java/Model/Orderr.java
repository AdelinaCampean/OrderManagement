package Model;
/**
 * Aceasta clasa este legatura tabelelor cu baza de date, avand acelasi nume cu tabela Orderr si variabilele de instanta reprezinta numele coloanelor din tabela
 * @author Adelina
 *
 */
public class Orderr {
	private int idorder;
	private int idclient;
	private int idproduct;
	private int quantity;

	public Orderr(int idclient, int idproduct, int quantity) {
		super();
		this.idclient = idclient;
		this.idproduct = idproduct;
		this.quantity = quantity;
	}
	
	public Orderr() {

	}



	public Orderr(int idorder, int idclient, int idproduct, int quantity) {
		super();
		this.idorder = idorder;
		this.idclient = idclient;
		this.idproduct = idproduct;
		this.quantity = quantity;
	}
	
	public int getIdorder() {
		return idorder;
	}

	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Orderr [idorder=" + idorder + ", idclient=" + idclient + ", idproduct=" + idproduct + ", quantity="
				+ quantity + "]";
	}


	
}
