package main;

import lib.Name;
import lib.Register;

/**
 * This RegisterApp class contains a method called execute that accepts a Name
 * and a Register object and returns a string.
 * 
 * This method, removes a name at index 1 from the register, and adds the Name
 * 'nm' which is passed as a parameter to the register.
 * 
 * All names within the register are then iterated through to meet a certain
 * criteria (further explained below) and if a name meets that criteria, an
 * emailAddress string is returned. If no names match the criteria, nothing (an empty string)
 * is returned.
 * 
 * @author Dylan Brand, P2523268
 */
public class RegisterApp {

	public static String execute(Name nm, Register regst) {

		// Removes the name at index 1 from the register.
		regst.removeName(1);

		// Adds the name 'nm' passed as a parameter to the register.
		regst.addName(nm);

		/**
		 * A for-each loop is used to iterate through names stored within the given
		 * register (regst). If the first name of each user name stored in the register
		 * contains an 'a' or an 'e' character, that user name is added to the string
		 * emailAddress with a specific format and that string is returned.
		 * 
		 * The format as follows: "initial.surnamefirst3letters@email.com" to lower case,
		 * followed by a new line. E.g. Sarah Ball = "s.bal@email.com".
		 */
		// String emailAddress is initially set as an empty string.
		String emailAddress = "";

		// Using a for-each loop to iterate through the names....?
		for (Name n : regst) {
			if (n.getFirstName().contains("a") || n.getFirstName().contains("e"))
				/*
				 * If a given name matches the requirements, that name is added to the String
				 * emailAddress with the described format applied.
				 */
				emailAddress += n.getFirstName().toLowerCase().charAt(0) + "."
						+ n.getFamilyName().substring(0, 3).toLowerCase() + "@email.com\n";
		}
		return emailAddress;

	}
}
