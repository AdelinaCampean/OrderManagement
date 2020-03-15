package bll.validators;

import Model.Client;

public class AgeValidator implements Validator<Client>{
	private static final int MINIM_AGE = 16;
	private static final int MAXIM_AGE = 70;

	public void validate(Client t) {

		if(t.getAge() < MINIM_AGE || t.getAge() > MAXIM_AGE) {
			throw new IllegalArgumentException("Varsta clientului nu este respectata!");
		}
		
	}
	

}
