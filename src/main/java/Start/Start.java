package Start;

import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Client;
import Presentation.Controller;
import Presentation.View;
import bll.ClientBLL;

public class Start {

	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) {

		View v = new View();
		Controller c = new Controller(v);
		
		
	}

}
