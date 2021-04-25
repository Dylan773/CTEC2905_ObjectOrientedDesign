package lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * A register contains an ArrayList of type Name which stores a first name and a
 * family name, and can produce a full name by combining these.
 * 
 * A separate field of type int (roomCapacity) defines the maximum number of
 * names that can be stored within the register.
 * 
 * @author Dylan Brand, P2523268
 */
public class Register implements Iterable<Name> {

	// Fields
	private ArrayList<Name> names;
	private int roomCapacity;

	// Constructors
	/**
	 * Default constructor. Creates a new instance of Register, instantiates an
	 * empty ArrayList<names> and sets the default value of the room capacity to 20.
	 */
	public Register() {
		names = new ArrayList<Name>();
		roomCapacity = 20;
	}

	/**
	 * Custom constructor. Creates a new instance of Register, instantiates an empty
	 * ArrayList<names> and accepts a room capacity value from the user.
	 * 
	 * @param roomCapacity The value of the room capacity to be set.
	 */
	public Register(int roomCapacity) {
		names = new ArrayList<Name>();
		this.roomCapacity = roomCapacity;
	}

	// Methods
	/**
	 * Returns the current room capacity (int value).
	 * 
	 * @return Room capacity.
	 */
	public int getRoomCapacity() {
		return roomCapacity;
	}

	/**
	 * Adds a new name to the register. If the room capacity is not full, new name
	 * is added to the register. If the room capacity is full, new name is not added
	 * to the register.
	 * 
	 * @param newName The name to be added.
	 */
	public void addName(Name newName) {
		if (names.size() < roomCapacity) {
			names.add(newName);
		} else {
			return; // Do nothing.
		}
	}

	/**
	 * Removes the name at index i from the register.
	 * 
	 * @param pos The index of the name to be removed.
	 * @return The name to be removed from the register.
	 */
	public Name removeName(int pos) {
		return names.remove(pos);
	}

	/**
	 * Method that accepts an ArrayList<Name> of names and adds each name to the
	 * register. If the size of the names to be added is greater than the room
	 * capacity, the names will not be added to the register.
	 * 
	 * @param newName The new name(s) to be added to the register.
	 */
	public void addNames(ArrayList<Name> newNames) {
		if (names.size() + newNames.size() <= roomCapacity) {
			names.addAll(newNames);
		} else {
			return; // If capacity is full, do nothing.
		}
	}

	/**
	 * Returns the name located at the given index.
	 * 
	 * @param pos The index of the name to be retrieved.
	 * @return The name within ArrayList<Name> names at the specified index.
	 */
	public Name getName(int pos) {
		return names.get(pos);
	}

	/**
	 * Returns the amount of names stored within the register, as an integer value.
	 * 
	 * @return The size of the register.
	 */
	public int sizeOfRegister() {
		return names.size();
	}

	/**
	 * Returns true if the register contains one or more names, returns false if
	 * register contains zero names.
	 * 
	 * @return Boolean result.
	 */
	public boolean isRegisterEmpty() {
		return names.isEmpty();
	}

	/**
	 * Removes all names stored within the register.
	 */
	public void clearRegister() {
		names.clear();
	}

	/**
	 * Compares the first character of a given first name stored within the register
	 * with the char argument provided (initial). Returns true, if the given first
	 * name starts with the provided argument. Returns false, if the given first
	 * name does not start with the provided argument.
	 * 
	 * @param initial The char value to be compared against the first character of
	 *                each first name stored in the register.
	 * @return Boolean result.
	 */
	public boolean searchRegisterByFirstNameInitial(char initial) {
		// Converting char value to a string value.
		String first = String.valueOf(initial);
		// Using a for-each loop to iterate through names.
		for (Name n : names) {
			if (n.getFirstName().startsWith(first)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Accepts a string argument and returns the number of occurrences of first
	 * names in the register that match the string argument, ignoring case
	 * sensitivity.
	 * 
	 * @param name The string argument used to compare against names in the
	 *             register.
	 * @return An int value of the number of occurrences of first names that match
	 *         the argument.
	 */
	public int countFirstNameOccurrences(String name) {
		int i = 0;
		for (Name n : names) {
			if (n.getFirstName().equalsIgnoreCase(name)) {
				i++;
			}
		}
		return i; // Returns the number of occurrences.
	}

	/**
	 * Sorts the register of names into ascending order.
	 */
	public void sortRegister() {
		Collections.sort(names);
	}

	/* Test Question */
	public boolean containsName(Name n) {
		if (n == null) {
			return false;
		} else if (names.contains(n)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a textual representation of the Register class.
	 */
	@Override
	public String toString() {
		return "Register:[name=" + names + ", room capacity=" + roomCapacity + "]";
	}

	/**
	 * Iterator used to iterate through the ArrayList of names.
	 * 
	 * @return Iterated names.
	 */
	@Override
	public Iterator<Name> iterator() {
		return names.iterator();
	}
}
