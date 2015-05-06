/**
 * 
 */
package edu.cs61b.class2.Classes;

/**
 * @author arpitm
 *
 */
public class HumanClassTest {

	/**
	 * NOTE: main() is ALWAYS static. This because this method is not called on
	 * any particular object. When the main methos is called, there is no object
	 * in existence to be passed implicitly
	 */
	public static void main(String[] args) {
		Human human1 = new Human();
		human1.age = 27;
		human1.name = "Arpit Mehta";

		// The introduce() call implicitly passes human1 to the "this" variable
		// in the method
		human1.introduce();

		// Copy test
		Human human2 = new Human();
		human2.age = 22;
		human2.name = "Rishi";
		human1.copy(human2);
		human1.introduce();

		// Change test
		human2.change("Tom", 19);
		human2.introduce();

		// Public Static field test
		System.out.println("Number of Humans: " + Human.numberOfHumans);

		// Public static method test
		Human.printNumberOfHumans();
	}

}
