package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Model.Client;
import Model.Orderr;
import Model.Product;
import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
/**
 * Aceasta clasa are rolul de a face legatura cu interfata grafica, implementand metode de ActionListener pentru fiecare buton din toate cele 7 frame-uri
 * @author Adelina
 *
 */
public class Controller {
	
	public View myV;

	public Controller(View v) {
		myV = v;
		myV.addListenerButon1(new viz());
		myV.addListenerButon2(new upp());
		myV.addListenerButon3(new ins());
		myV.addListenerButon4(new delete());
		myV.addListenerButon5(new clienti());
		myV.addListenerButon6(new ord());
		myV.addListenerButon7(new prod());
		myV.addListenerButon8(new insert());
		myV.addListenerButon9(new upd());
		myV.addListenerButon10(new del());
		myV.addListenerButon11(new VIZU());
		myV.addListenerButon12(new in());
		myV.addListenerButon13(new tabv());

	}
	
	class viz implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			try {
				
			ClientBLL client1 = new ClientBLL();
			Client c2 = new Client();
				myV.setTable(client1.createTable(c2));
			
				myV.frametabcl();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
				
		}
	}
	
	class upp implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			ClientBLL cc = new ClientBLL();
			Client c = new Client(myV.getIdd(), myV.getNum(), myV.getAge());
			cc.updateClient(c);
			myV.setTable(cc.createTable(c));
			myV.frametabcl();


			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	class ins implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			ClientBLL cc = new ClientBLL();
			Client c = new Client(myV.getNum(), myV.getAge());
			cc.insertClient(c);
			myV.setTable(cc.createTable(c));
			myV.frametabcl();

			System.out.println("as");
			
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	class delete implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			ClientBLL cc = new ClientBLL();
			Client c = new Client(myV.getIdd(), myV.getNum(), myV.getAge());
			cc.deleteClient(c);
			myV.setTable(cc.createTable(c));

			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	

	class clienti implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			myV.frame2();
			myV.getFrameclients().setVisible(true);
				
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}

		}
	}
	

	class ord implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				myV.frame4();
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	class prod implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				myV.frame3();
				myV.getFrameprod().setVisible(true);
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
		}
	}
	
	class insert implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			ProductBLL product = new ProductBLL();
			Product p1 = new Product(myV.getN1(),myV.getQ1());
			product.insertProduct(p1);
			myV.setTablep(product.createTable(p1));
			myV.frametabprod();

			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	class upd implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			try {
			ProductBLL product = new ProductBLL();
			Product p1 = new Product(myV.getIdpr(),myV.getN1(),myV.getQ1());
			product.updateProduct(p1);
			myV.setTablep(product.createTable(p1));

			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	class del implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			ProductBLL product = new ProductBLL();
			Product p1 = new Product(myV.getIdpr(),myV.getN1(),myV.getQ1());
			product.deleteProduct(p1);
			myV.setTablep(product.createTable(p1));

			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	class VIZU implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			ProductBLL PRO = new ProductBLL();
			Product P1= new Product();

				myV.setTablep(PRO.createTable(P1));
			
				myV.frametabprod();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		
		}
	}
	
	class in implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			OrderBLL op = new OrderBLL();
			Orderr or1 = new Orderr(myV.getIdclie(), myV.getIdprod(), myV.getNrqu());
			Product p = op.insertOrder(or1);
			if(p.getQuantity()-myV.getNrqu()<0)
			{
				myV.setMessage("Nu mai sunt sufieciente produse pe stoc!");
				
			}
			else 
				{
				myV.setMessage("Comanda a fost efectuata cu succes!");
				
				p.setQuantity(p.getQuantity()-myV.getNrqu());
				}

			
			
			ProductBLL p2= new ProductBLL();
			p2.updateProduct(p);
			
			
			myV.setTableo(op.createTable(or1));
			

			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	class tabv implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
			OrderBLL or = new OrderBLL();
			Orderr order1 = new Orderr();
				myV.setTableo(or.createTable(order1));
			
				myV.frametabord();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
				
			
		
	}
}
