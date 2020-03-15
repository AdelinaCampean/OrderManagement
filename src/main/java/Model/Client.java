package Model;
/**
 * Aceasta clasa este legatura tabelelor cu baza de date, avand acelasi nume cu tabela Client si variabilele de instanta reprezinta numele coloanelor din tabela
 * @author Adelina
 *
 */

public class Client {
	
	private int idclients;
	private String name;
	private int age;
	
	public Client(String name, int age) {
		super();
		this.name = name;
		this.age=age;
	}
	
	public Client(int idclients, String name, int age) {
		super();
		this.idclients = idclients;
		this.name = name;
		this.age = age;
	}

	public Client()
	{
		
	}
	
	


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getIdclients() {
		return idclients;
	}
	public void setIdclients(int idclients) {
		this.idclients = idclients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Clientul "  + name + ", cu id: "  + idclients + " si varsta de " +age +" ani";
	}


}
