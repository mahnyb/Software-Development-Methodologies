
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 3

import java.util.Scanner;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		String name = null, month = null, roomType = null;
		int start = 0, end = 0, cost = 0, roomSize = 0;
		boolean bath;
		
		ArrayList<Reservation> ReservationBook = new ArrayList<Reservation>();
		Scanner keyboardInput = new Scanner(System.in);
		
		//Menu
		int MenuInput;
		
		do {System.out.printf("\n1. Create new Reservation\r\n"
				+ "2. Display all Reservations\r\n"
				+ "3. Display the total number of reservations\r\n"
				+ "0. Exit\n");
		
			MenuInput = keyboardInput.nextInt();

			switch(MenuInput) {

				// create new reservation
				case 1:
					System.out.printf("Hotel Name: \n");
					name = keyboardInput.next();
					
					System.out.printf("Room Type: \n");
					roomType = keyboardInput.next();
					
					System.out.printf("Reservation Month: \n");
					month = keyboardInput.next();
					
					System.out.printf("Reservation Start: \n");
					start = keyboardInput.nextInt();
					
					System.out.printf("Reservation End: \n");
					end = keyboardInput.nextInt();
					
					System.out.printf("Daily Cost: \n");
					cost = keyboardInput.nextInt();
					
					System.out.printf("Has Bath: \n");
					bath = keyboardInput.nextBoolean();
					
					System.out.printf("Room Size: \n");
					roomSize = keyboardInput.nextInt();
					
					ReservationBook.add(new Reservation(name, roomType, month, start, end, cost, bath, roomSize));
					System.out.printf("Reservation created successfully!!\n");
					break;

				// display all reservation
				case 2:
					for(Reservation Hotel: ReservationBook)
						Hotel.displayInfo();
					break;
				// display the total number of reservations	
				case 3:
					System.out.printf("%d reservation(s) have been created so far.\n", ReservationBook.size()); 
					break;
				
				// exit
				case 0:
					break;

				// invalid input
				default:
					System.out.printf("Invalid input. Try again.\n\n");
					break;
			}
			
		} while(MenuInput != 0);
		
	}
}
