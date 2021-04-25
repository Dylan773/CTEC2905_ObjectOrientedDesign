package lib;

/**
 * A player has a name, gamertag and a pair of dice.
 * 
 * The players name is of type Name, which stores a first name and a family name,
 * and can produce a full name by combining these.
 * 
 * A player has a gamertag of type String which is set to an empty string as default unless the
 * player is assigned a gamertag by the user, using a custom constructor.
 * 
 * The pair of dice is composed of two Die instances.
 * 
 * @author dylanbrand
 */

public class Player implements Rollable, Comparable<Player> {

	// Fields
	private Name name;
	private Rollable pairOfDice;
	private String gamertag;

	// Constructors
	/**
	 * Default Constructor.
	 * Creates a new instance of Player, using default Name and
	 * PairOfDice values and an empty string value for gamertag.
	 */
	public Player() {
		name = new Name();
		pairOfDice = new PairOfDice();
		gamertag = "";
	}

	/**
	 * Creates a new instance of Player which accepts a name and gamertag value from the user,
	 * whilst instantiating the default PairOfDice object/value.
	 * 
	 * @param name The name of the player.
	 * @param gamertag The players unique gamertag.
	 */
	public Player(Name name, String gamertag) {
		this.name = name;
		this.gamertag = gamertag;
		pairOfDice = new PairOfDice();
	}

	/**
	 * Creates a new instance of Player which accepts a name, gamertag and pair of dice value
	 * from the user.
	 * 
	 * @param name The name of the player.
	 * @param gamertag The players unique gamertag.
	 * @param pairOfDice The dice to be rolled.
	 */
	public Player(Name name, String gamertag, Rollable pairOfDice) {
		this.name = name;
		this.gamertag = gamertag;
		this.pairOfDice = pairOfDice;
	}

	// Methods
	/**
	 * Method that returns the players name.
	 * 
	 * @return The name of the player.
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Method to set a players name.
	 * 
	 * @param name The name of the player.
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * Method that returns the players gamertag.
	 * 
	 * @return The gamertag of the player.
	 */
	public String getGamerTag() {
		return gamertag;
	}

	/**
	 * Method that sets the players new gamertag.
	 * 
	 * @param gamertag The players unique gamertag.
	 */
	public void setGamerTag(String gamertag) {
		this.gamertag = gamertag;
	}

	/**
	 * Method that returns pairOfDice object.
	 * 
	 * @return pairOfDice.
	 */
	public Rollable getRollable() {
		return pairOfDice;
	}

	/**
	 * Rolls pair of dice using roll implementation within the Rollable interface.
	 */
	public void rollDice() {
		pairOfDice.roll();
	}

	/**
	 * Returns the score of the pair of dice.
	 * 
	 * @return The score of the dice.
	 */
	public int getDiceScore() {
		return pairOfDice.getScore();
	}

	/**
	 * Method that accepts a String value from the user and uses this to set a first
	 * and family name individually by splitting the String between the " " (space) within
	 * the user input.
	 * 
	 * Regardless of case sensitivity from the user input, the first initial of both the first
	 * and last name will be set to upper case, whilst the remaining characters will be lower case.
	 * 
	 * E.g. User input: "sarah ball" will return, "Sarah", "Ball".
	 * 
	 * @param name The argument provided to set a first and last name.
	 */
	public void setFullPlayerName(String name) {
		// Sets the index of the space in the user input to an int variable.
		int space = name.indexOf(" ");
		String firstName = name.substring(0, space);
		String familyName = name.substring(space + 1);

		String firstInitial = String.valueOf(firstName.charAt(0));
		String lastInitial = String.valueOf(familyName.charAt(0));

		// Set first name.
		getName().setFirstName(firstInitial.toUpperCase() + firstName.substring(1).toLowerCase()); 
		
		// Set family name.
		getName().setFamilyName(lastInitial.toUpperCase() + familyName.substring(1).toLowerCase());
	}

	/**
	 * Method that accepts an int value and uses this to generate a new GameTag.
	 * This method ensures the value provided is within the range of 1 to 100, anything outside
	 * this range will result in no change.
	 * 
	 * If the value provided is within the required range, the GamerTag will be updated to
	 * the players: full name in reverse order, all characters in lower case with no white space
	 * and the provided value (int i) at the end.
	 * 
	 * Ex: "Sarah Ball" and 15, would return "llabharas15".
	 * 
	 * @param i The int value used to generate a GamerTag.
	 */
	public void generateGamerTag(int i) {
		String fullName = name.getFullName().replaceAll("\\s", "").toLowerCase();
		// Converting from a String object to StringBuffer.
		StringBuffer reverseName = new StringBuffer(fullName);
		String newGamerTag = "";

		if (i >= 1 && i <= 100) {
			// Using .reverse method of the StringBuffer class to reverse the string.
			newGamerTag = reverseName.reverse().toString();
			setGamerTag(newGamerTag + i);
		}
	}

	/**
	 * Returns a textual representation of a Player's details.
	 */
	@Override
	public String toString() {
		return "Player:[name=" + name + ", gamertag=" + gamertag + ", pairOfDice=" + pairOfDice + "]";
	}

	/**
	 * Rolls the pair of dice using implemented roll from the Rollable interface.
	 */
	@Override
	public void roll() {
		pairOfDice.roll();
	}

	/**
	 * Returns the score of the pair of dice using implemented getScore
	 * from the Rollable interface.
	 */
	@Override
	public int getScore() {
		return pairOfDice.getScore();
	}

	/**
	 * Method that compares two player names, in the event that both names are the same
	 * then each player will be compared using their gamertags.
	 */
	@Override
	public int compareTo(Player name) {
		int result = getName().compareTo(name.getName());
		
		if (result == 0) {
			result = this.getGamerTag().compareTo(name.getGamerTag());
		}
		return result;
	}
}
