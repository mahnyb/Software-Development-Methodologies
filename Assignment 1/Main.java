// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 1

package assigments1;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		
		StandardRoom Hotel = new StandardRoom();
		Scanner keyboardInput = new Scanner(System.in); // input from the user
		
		// Menu
		int MenuInput;
		int countIn, priceIn; 
		
		do {System.out.printf("\n1. Create new Standard Room\r\n"
					+ "2. Display all room information\r\n"
					+ "3. Display the total number rooms\r\n"
					+ "0. Exit \n");
		
			MenuInput = keyboardInput.nextInt();
			
			switch (MenuInput){
			
			// create a new standard room
			case 1:
				System.out.printf("Person Count: \n");
				countIn = keyboardInput.nextInt();
				System.out.printf("Price: \n");
				priceIn = keyboardInput.nextInt();
				Hotel.createRoom(countIn, priceIn);
				break;
				 
			// display all the room info
			case 2:
				Hotel.displayInfo();
				break;
			
			// display the total number of rooms
			case 3: 
			System.out.printf("%d room(s) have been created so far.\n", Hotel.i);
			break;
			
			// exit
			case 0:
				keyboardInput.close();
				System.exit(0);
				break;
				
			// invalid input
			default:
				System.out.println("Invalid input. Try again.\n");
				System.out.println();
				break;
			}
			
		} while(MenuInput != 0);

	}

}
