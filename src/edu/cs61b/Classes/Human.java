/**
 * 
 */
package edu.cs61b.Classes;

/**
 * @author arpitm
 * 
 *         Definition of Human class
 *
 */
public class Human {
	public static int numberOfHumans;
	public String name;
	public int age;

	/**
	 * Constructor
	 * 
	 * Properties: 1. Constructors always have to have the same name as the
	 * class. 2. It always returns an object of that class.
	 * 
	 * Now since Java requires a constructor always has the above 2 properties,
	 * we are not required to mention the return type.
	 */
	public Human(String givenName, int givenAge) {
		this.name = givenName;
		this.age = givenAge;
		numberOfHumans += 1;
	}

	/**
	 * Java provides a default constructor with no parameters. This constructor
	 * does no initialization.
	 * 
	 * Note: If this constructor is not explicitly defined in Human class then
	 * only the above defined constructor is available to the world.
	 */
	public Human() {
		// If this constructor is not empty then the "default constructor" is
		// overridden
		numberOfHumans++;
	}
	
	public static void printNumberOfHumans() {
		System.out.println("Number of Humans: " + numberOfHumans);
	}

	public void introduce() {
		System.out.println("Hi there! My name is " + this.name + " and I'm "
				+ this.age + " years old.");
	}

	public void copy(Human original) {
		this.age = original.age;
		this.name = original.name;
	}
	
	public void change(String name, int age) {
		// Note that the input var names are the same as the field variable names.
		// "this" is the right way to handle variables in this case.
		this.name = name;
		this.age = age;
	}
	
	// Notes:
	// You CANNOT change the value of 'this'. i.e
	// this = human; will throw an error. Here human is a Human object
}
