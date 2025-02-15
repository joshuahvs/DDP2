import java.util.*; // Import the ArrayList class

public class ArrayList {
    public static void main(String[] args) {
        java.util.ArrayList<Integer> numbers = new java.util.ArrayList<>();
        // Create an ArrayList of Integers

        // Add elements to the ArrayList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Print the elements of the ArrayList
        System.out.println("Numbers in the ArrayList:");
        for (Integer num : numbers) {
            System.out.println(num);
        }

        // Remove an element from the ArrayList
        numbers.remove(2); // Removes the element at index 2

        // Print the modified ArrayList
        System.out.println("Numbers after removing element at index 2:");
        for (Integer num : numbers) {
            System.out.println(num);
        }

        // Get the size of the ArrayList
        System.out.println("Size of the ArrayList: " + numbers.size());

        // Check if the ArrayList contains a specific element
        System.out.println("Does the ArrayList contain 40? " + numbers.contains(40));

        // Clear the ArrayList
        numbers.clear();

        // Print the ArrayList after clearing it
        System.out.println("ArrayList after clearing:");
        for (Integer num : numbers) {
            System.out.println(num);
        }
    }
}
