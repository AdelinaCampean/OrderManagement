package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Model.Orderr;

public class View {


	private JTextField idd =  new JTextField();
	private JTextField num =  new JTextField();
	private JTextField age =  new JTextField();

	private JFrame frameclients;
	private JFrame frame = new JFrame();
	private JFrame frameprod;
	private JFrame frameor;
	private JFrame frametab;
	private JFrame frametab2;
	private JFrame frametab3;

	
	private JButton viz = new JButton("TABLE VIEW");
	private JButton ins = new JButton("INSERT");
	private JButton upp = new JButton("UPDATE");
	private JButton delete = new JButton("DELETE");
	private JButton prod = new JButton("PRODUCTS");
	private JButton clienti = new JButton("CLIENTS");
	private JButton ord = new JButton("ORDERS");

	private JTextField n1=  new JTextField();
	private JTextField p1=  new JTextField();
	private JTextField q1=  new JTextField();

	private JTextField idclie;
	private JTextField nc=  new JTextField();
	private JTextField acf=  new JTextField();
	private JTextField idprod;
	private JTextField npp=  new JTextField();
	private JTextField pr1=  new JTextField();
	private JTextField quan1=  new JTextField();
	private JTextField nrqu;
	private JTextField message=  new JTextField();

	private JButton insert = new JButton("INSERT");
	private JButton upd = new JButton("UPDATE");
	private JButton del = new JButton("DELETE");
	private JButton VIZU = new JButton("TABLE VIEW");
	
	private JTable table= new JTable();
	private JTable tablep =  new JTable();
	private JTable tableo =  new JTable();

	private JButton in = new JButton("PLACE AN ORDER");
	private JButton tabv = new JButton("TABLE VIEW");
	private JTextField idpr = new JTextField();

	/**
	 * Metoda realizeaza frame-ul principal, din care alegem ce operatii efectuam, pe clienti, produse sau comenzi
	 */
	public View ()
	{
		frame.setResizable(false);
		frame.setBounds(100,100,800,500);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(230, 230, 250));
		panel.setLayout(null);
		
		JLabel OrderManagement = new JLabel("ORDER MANAGEMENT");
		OrderManagement.setForeground(Color.PINK);
		OrderManagement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		OrderManagement.setBounds(162, 77, 450, 74);
		panel.add(OrderManagement);
		
		clienti.setFont(new Font("Times New Roman", Font.BOLD, 25));
		clienti.setBounds(60, 250, 200, 90);
		panel.add(clienti);
		
		prod.setFont(new Font("Times New Roman", Font.BOLD, 25));
		prod.setBounds(300, 250, 200, 90);
		panel.add(prod);
		
		ord.setFont(new Font("Times New Roman", Font.BOLD, 25));
		ord.setBounds(540, 250, 200, 90);
		panel.add(ord);
		

		frame.add(panel);
		frame.setVisible(true);
		SwingUtilities.updateComponentTreeUI(frame);


	}
	/**
	 * Aceasta metoda creeaza frame-ul pentru tabela clienti, in care putem insera, sterge sau actualiza un client si totodata putem vizualiza tabela clients.
	 */
	public void frame2() {
		
		frameclients = new JFrame();
		frameclients.setResizable(false);
		frameclients.setBounds(100,100,800,600);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setLayout(null);
		
		JLabel cl = new JLabel("CLIENTS");
		cl.setHorizontalAlignment(SwingConstants.CENTER);
		cl.setForeground(Color.MAGENTA);
		cl.setFont(new Font("Times New Roman", Font.BOLD, 45));
		cl.setBounds(220, 30, 360, 50);
		panel.add(cl);
		
		JLabel id = new JLabel("ID Client: ");
		id.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		id.setBounds(60, 130, 90, 25);
		panel.add(id);
		
		idd.setBounds(45, 160, 140, 40);
		panel.add(idd);
		
		JLabel name = new JLabel("NAME:");
		name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		name.setBounds(290, 130, 90, 25);
		panel.add(name);
		
		num.setBounds(271, 160, 215, 40);
		panel.add(num);
		
		JLabel lblNewLabel = new JLabel("AGE:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(555, 130, 90, 25);
		panel.add(lblNewLabel);
		
		age.setBounds(541, 160, 129, 40);
		panel.add(age);
		
		ins.setForeground(new Color(0, 0, 128));
		ins.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ins.setBounds(45, 300, 170, 80);
		panel.add(ins);
		
		upp.setForeground(new Color(0, 0, 128));
		upp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		upp.setBounds(301, 300, 170, 80);
		panel.add(upp);
		
		delete.setForeground(new Color(0, 0, 128));
		delete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		delete.setBounds(558, 300, 170, 80);
		panel.add(delete);
		
		viz.setForeground(new Color(0, 0, 128));
		viz.setFont(new Font("Times New Roman", Font.BOLD, 25));
		viz.setBounds(230, 435, 325, 70);
		panel.add(viz);
		
		frameclients.add(panel);
		frameclients.setVisible(true);
		SwingUtilities.updateComponentTreeUI(frameclients);

		
	}
	
	/**
	 * Aceasta metoda creeaza frame-ul pentru tabela produse, in care putem insera, sterge sau actualiza un produs si totodata putem vizualiza tabela products.
	 */
	public void frame3() {
		frameprod = new JFrame();

		frameprod.setResizable(false);
		frameprod.setBounds(100,100,860,650);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setLayout(null);
		
		JLabel prod1 = new JLabel("PRODUCTS");
		prod1.setForeground(new Color(148, 0, 211));
		prod1.setHorizontalAlignment(SwingConstants.CENTER);
		prod1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		prod1.setBounds(230, 25, 380, 65);
		panel.add(prod1);
		
		JLabel nam = new JLabel("Name: ");
		nam.setFont(new Font("Times New Roman", Font.BOLD, 25));
		nam.setBounds(282, 160, 160, 40);
		panel.add(nam);
		
		JLabel quant = new JLabel("Quantity:");
		quant.setFont(new Font("Times New Roman", Font.BOLD, 25));
		quant.setBounds(600, 160, 160, 40);
		panel.add(quant);
		
		JLabel idp = new JLabel("Id:");
		idp.setFont(new Font("Times New Roman", Font.BOLD, 25));
		idp.setBounds(80, 162, 70, 40);
		panel.add(idp);
		
		n1 = new JTextField();
		n1.setBounds(260, 215, 240, 50);
		panel.add(n1);
		n1.setColumns(10);
		
		idpr = new JTextField();
		idpr.setBounds(65, 215, 120, 50);
		panel.add(idpr);
		
		q1 = new JTextField();
		q1.setBounds(580, 215, 230, 50);
		panel.add(q1);
		q1.setColumns(10);
		
		
		insert.setForeground(new Color(0, 0, 205));
		insert.setFont(new Font("Times New Roman", Font.BOLD, 25));
		insert.setBounds(35, 350, 230, 80);
		panel.add(insert);
		
	
		upd.setForeground(new Color(0, 0, 205));
		upd.setFont(new Font("Times New Roman", Font.BOLD, 25));
		upd.setBounds(320, 350, 230, 80);
		panel.add(upd);
		

		del.setForeground(new Color(0, 0, 205));
		del.setFont(new Font("Times New Roman", Font.BOLD, 25));
		del.setBounds(600, 350, 230, 80);
		panel.add(del);
		
		VIZU.setForeground(new Color(75, 0, 130));
		VIZU.setFont(new Font("Times New Roman", Font.BOLD, 30));
		VIZU.setBounds(250, 500, 380, 70);
		panel.add(VIZU);
	
		frameprod.add(panel);
		frameprod.setVisible(true);
		
		SwingUtilities.updateComponentTreeUI(frameprod);
	}
	
	/**
	 * Aceasta metoda creeaza frame-ul pentru tabela comenzi, in care plasa o comanda in functie de un client ales, un produs ales si totodata putem vizualiza tabela comenzi, care contine comenzile anterioare.
	 */
  public void frame4() {

	  	frameor = new JFrame();
	  	frameor.setResizable(false);
		frameor.setBounds(100,100,910,590);
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setLayout(null);
		
		JLabel OR = new JLabel("ORDERS");
		OR.setBounds(250, 25, 370, 56);
		OR.setForeground(new Color(128, 0, 128));
		OR.setFont(new Font("Times New Roman", Font.BOLD, 40));
		OR.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(OR);
		
		JLabel c = new JLabel("CLIENT: ");
		c.setBounds(81, 110, 150, 30);
		c.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(c);
		
		JLabel di = new JLabel("ID:");
		di.setBounds(35, 180, 35, 30);
		di.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(di);
		
		idclie =  new JTextField();
		idclie.setBounds(85, 175, 90, 40);
		panel.add(idclie);
		
		JLabel prodd = new JLabel("PRODUCT: ");
		prodd.setBounds(358, 110, 150, 40);
		prodd.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(prodd);
		
		idprod =  new JTextField();
		idprod.setBounds(390, 175, 90, 40);
		panel.add(idprod);
		
		in.setBounds(315, 285, 240, 80);
		in.setForeground(new Color(0, 0, 139));
		in.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(in);
	
		tabv.setBounds(470, 420, 370, 80);
		tabv.setForeground(new Color(0, 0, 139));
		tabv.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(tabv);
		
		JLabel label = new JLabel("ID:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label.setBounds(340, 180, 35, 30);
		panel.add(label);
		
		JLabel quantity = new JLabel("QUANTITY:");
		quantity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		quantity.setBounds(539, 180, 115, 30);
		panel.add(quantity);
		
		nrqu = new JTextField();
		nrqu.setColumns(10);
		nrqu.setBounds(690, 175, 90, 40);
		panel.add(nrqu);
		
		message.setBounds(35, 440, 340, 50);
		panel.add(message);
	
		frameor.add(panel);
		frameor.setVisible(true);
		
		SwingUtilities.updateComponentTreeUI(frameor);

		
  }
  /**
   * Aceasta metoda contine frame-ul care afiseaza tabelul cu valorile din baza de date pentru Clienti
   */
   public void frametabcl() {

	   frametab = new JFrame();
	   	frametab.setResizable(false);
		frametab.setBounds(100,100,970,670);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setLayout(null);
		
		JLabel cli = new JLabel("CLIENTS TABLE");
		cli.setForeground(new Color(139, 0, 0));
		cli.setFont(new Font("Times New Roman", Font.BOLD, 40));
		cli.setBounds(281, 33, 360, 60);
		panel.add(cli);
		
		/*table.setBounds(50, 155, 860, 370);
		panel.add(table);*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 155, 886, 370);
		panel.add(scrollPane);		
		
		scrollPane.setViewportView(table);
		
		frametab.add(panel);
		frametab.setVisible(true);
		
		SwingUtilities.updateComponentTreeUI(frametab);

   }
   
   /**
    * Aceasta metoda contine frame-ul care afiseaza tabelul cu valorile din baza de date pentru products
    */
   public void frametabprod() {
	   
	    frametab2=new JFrame();
	   	frametab2.setResizable(false);
		frametab2.setBounds(100,100,970,670);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setLayout(null);
		
		JLabel cli = new JLabel("PRODUCTS TABLE");
		cli.setForeground(new Color(139, 0, 0));
		cli.setFont(new Font("Times New Roman", Font.BOLD, 40));
		cli.setBounds(281, 33, 390, 60);
		panel.add(cli);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 155, 886, 370);
		panel.add(scrollPane);		
		
		scrollPane.setViewportView(tablep);
		
		frametab2.add(panel);
		frametab2.setVisible(true);
		
		SwingUtilities.updateComponentTreeUI(frametab2);

  }
   /**
    * Aceasta metoda contine frame-ul care afiseaza tabelul cu valorile din baza de date pentru comenzi
    */
   
   public void frametabord() {

	    frametab3 = new JFrame();
	   	frametab3.setResizable(false);
		frametab3.setBounds(100,100,970,670);


		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setLayout(null);
		
		JLabel cli = new JLabel("ORDER TABLE");
		cli.setForeground(new Color(139, 0, 0));
		cli.setFont(new Font("Times New Roman", Font.BOLD, 40));
		cli.setBounds(281, 33, 360, 60);
		panel.add(cli);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 155, 880, 370);
		panel.add(scrollPane);		
		
		scrollPane.setViewportView(tableo);
		frametab3.add(panel);
		frametab3.setVisible(true);
		
		SwingUtilities.updateComponentTreeUI(frametab3);

		
 }
	
   

public JButton getTabv() {
	return tabv;
}

public void setTabv(JButton tabv) {
	this.tabv = tabv;
}

	public int getIdpr() {
		return Integer.parseInt(idpr.getText());
	}

	public void setIdpr(JTextField idpr) {
		this.idpr = idpr;
	}

	public JFrame getFrameprod() {
		return frameprod;
	}

	public void setFrameprod(JFrame frameprod) {
		this.frameprod = frameprod;
	}

	public String getN1() {
		return n1.getText();
	}

	public void setN1(JTextField n1) {
		this.n1 = n1;
	}

	public JTextField getP1() {
		return p1;
	}

	public void setP1(JTextField p1) {
		this.p1 = p1;
	}

	public int getQ1() {
		return Integer.parseInt(q1.getText());
	}

	public void setQ1(JTextField q1) {
		this.q1 = q1;
	}

	public String getNum() {
		return num.getText();
	}

	public void setNum(String num) {
		this.num.setText(num);
	}

	public int getAge() {
		return Integer.parseInt(age.getText());
	}

	public void setAge(JTextField age) {
		this.age = age;
	}

	public JButton getViz() {
		return viz;
	}

	public void setViz(JButton viz) {
		this.viz = viz;
	}

	public JButton getIns() {
		return ins;
	}

	public void setIns(JButton iNSERT) {
		ins = iNSERT;
	}

	public JButton getUP() {
		return upp;
	}

	public void setUP(JButton uP) {
		upp = uP;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public JButton getProd() {
		return prod;
	}

	public void setProd(JButton prod) {
		this.prod = prod;
	}

	public JButton getClienti() {
		return clienti;
	}

	public void setClienti(JButton clienti) {
		this.clienti = clienti;
	}

	public JButton getOrd() {
		return ord;
	}

	public void setOrd(JButton ord) {
		this.ord = ord;
	}
	

	public int getIdd() {
		return Integer.parseInt(idd.getText());
	}

	public void setIdd(JTextField idd) {
		this.idd = idd;
	}

	public JFrame getFrameclients() {
		return frameclients;
	}

	public void setFrameclients(JFrame frameclients) {
		this.frameclients = frameclients;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setNum(JTextField num) {
		this.num = num;
	}

	
	public JFrame getFrameor() {
		return frameor;
	}

	public void setFrameor(JFrame frameor) {
		this.frameor = frameor;
	}

	public JFrame getFrametab() {
		return frametab;
	}

	public void setFrametab(JFrame frametab) {
		this.frametab = frametab;
	}

	public JFrame getFrametab2() {
		return frametab2;
	}

	public void setFrametab2(JFrame frametab2) {
		this.frametab2 = frametab2;
	}

	public JFrame getFrametab3() {
		return frametab3;
	}

	public void setFrametab3(JFrame frametab3) {
		this.frametab3 = frametab3;
	}

	public JButton getUpp() {
		return upp;
	}

	public void setUpp(JButton upp) {
		this.upp = upp;
	}

	
	public JTextField getNc() {
		return nc;
	}

	public void setNc(JTextField nc) {
		this.nc = nc;
	}

	public JTextField getAcf() {
		return acf;
	}

	public void setAcf(JTextField acf) {
		this.acf = acf;
	}

	public JTextField getNpp() {
		return npp;
	}

	public void setNpp(JTextField npp) {
		this.npp = npp;
	}

	public JTextField getPr1() {
		return pr1;
	}

	public void setPr1(JTextField pr1) {
		this.pr1 = pr1;
	}

	public JTextField getQuan1() {
		return quan1;
	}

	public void setQuan1(JTextField quan1) {
		this.quan1 = quan1;
	}

	public JButton getInsert() {
		return insert;
	}

	public void setInsert(JButton insert) {
		this.insert = insert;
	}

	public JButton getUpd() {
		return upd;
	}

	public void setUpd(JButton upd) {
		this.upd = upd;
	}

	public JButton getDel() {
		return del;
	}

	public void setDel(JButton del) {
		this.del = del;
	}

	public JButton getVIZU() {
		return VIZU;
	}

	public void setVIZU(JButton vIZU) {
		VIZU = vIZU;
	}

	public JButton getIn() {
		return in;
	}

	public void setIn(JButton in) {
		this.in = in;
	}


	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTable getTablep() {
		return tablep;
	}

	public void setTablep(JTable tablep) {
		this.tablep = tablep;
	}

	public JTable getTableo() {
		return tableo;
	}

	public void setTableo(JTable tableo) {
		this.tableo = tableo;
	}

	public void addListenerButon1(ActionListener viz1) {
		// TODO Auto-generated method stub
		viz.addActionListener(viz1);
	}
	public void addListenerButon2(ActionListener up1) {
		// TODO Auto-generated method stub
		upp.addActionListener(up1);
	}
	public void addListenerButon3(ActionListener IN) {
		// TODO Auto-generated method stub
		ins.addActionListener(IN);
	}
	public void addListenerButon4(ActionListener del) {
		// TODO Auto-generated method stub
		delete.addActionListener(del);
	}
	
	public void addListenerButon5(ActionListener x) {
		// TODO Auto-generated method stub
		clienti.addActionListener(x);
	}
	public void addListenerButon6(ActionListener or) {
		// TODO Auto-generated method stub
		ord.addActionListener(or);
	}
	
	public void addListenerButon7(ActionListener pr) {
		// TODO Auto-generated method stub
		prod.addActionListener(pr);
	}
	
	public void addListenerButon8(ActionListener insert2) {
		// TODO Auto-generated method stub
		insert.addActionListener(insert2);
	}

	public void addListenerButon9(ActionListener upd2) {
		// TODO Auto-generated method stub
		upd.addActionListener(upd2);
	}

	public void addListenerButon10(ActionListener del2) {
		// TODO Auto-generated method stub
		del.addActionListener(del2);
	}

	public void addListenerButon11(ActionListener vizu2) {
		// TODO Auto-generated method stub
		VIZU.addActionListener(vizu2);
	}

	public void addListenerButon12(ActionListener in2) {
		// TODO Auto-generated method stub
		in.addActionListener(in2);
	}

	public void addListenerButon13(ActionListener tabv2) {
		// TODO Auto-generated method stub
		tabv.addActionListener(tabv2);
	}

	
	public int getIdclie() {
		return Integer.parseInt(idclie.getText());
	}

	public void setIdclie(JTextField idclie) {
		this.idclie = idclie;
	}

	public int getIdprod() {
		return Integer.parseInt(idprod.getText());
	}

	public void setIdprod(JTextField idprod) {
		this.idprod = idprod;
	}

	public void setMessage(String message) {
		this.message.setText(message);
	}

	public int getNrqu() {
		return Integer.parseInt(nrqu.getText());
	}

	public void setNrqu(JTextField nrqu) {
		this.nrqu = nrqu;
	}

	public JTextField getMessage() {
		return message;
	}

	public void setMessage(JTextField message) {
		this.message = message;
	}

	
}
