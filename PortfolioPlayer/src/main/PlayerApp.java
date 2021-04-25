package main;

import java.util.ArrayList;
import lib.Player;

/**
 * A class that contains a method 'execute'.
 * The execute method accepts an ArrayList of Player and an int value. This method iterates
 * through names stored within the ArrayList, and returns a String that contains the name of
 * each player whose gamertag contains their surname (not case-sensitive) as well as the
 * int (number) value passed as a parameter to the execute method (as long as the int value
 * matches the argument).
 * 
 * The String format for this method returns: "FIRSTNAME, surname".
 * E.g. int number = 50: "Sarah Ball", 50 returns "SARAH, ball"
 * 
 * @author Dylan Brand, P2523268
 */
public class PlayerApp {

	public static String execute(ArrayList<Player> participants, int number) {
		String gamertag = "";

		for (Player names : participants) {
			// String used to compare the family name of a player with their GamerTag stored
			// within the list 'participants'.
			String familyNameLower = names.getName().getFamilyName().toLowerCase();

			if (names.getGamerTag().toLowerCase().contains(familyNameLower)
					&& names.getGamerTag().contains(String.valueOf(number)))
				gamertag += names.getName().getFirstName().toUpperCase() + ", "
						+ names.getName().getFamilyName().toLowerCase() + "\n";
		}
		return gamertag;
	}
}