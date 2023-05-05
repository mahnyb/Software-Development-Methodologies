// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 2

import java.util.Scanner;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		String name = null, month = null;
		int start = 0, end = 0, cost = 0;
		
		ArrayList<Reservation> ReservationBook = new ArrayList<Reservation>();
		Scanner keyboardInput = new Scanner(System.in);
		
		//Menu
		int MenuInput;
		
		do {System.out.printf("\n1. Create new Reservation\r\n"
				+ "2. Display all Reservations\r\n"
				+ "0. Exit\n");
		
			MenuInput = keyboardInput.nextInt();

			switch(MenuInput) {

				// create new reservation
				case 1:
					System.out.printf("Hotel name: \n");
					name = keyboardInput.next();
					
					System.out.printf("Reservation Month: \n");
					month = keyboardInput.next();
					
					System.out.printf("Reservation Start: \n");
					start = keyboardInput.nextInt();
					
					System.out.printf("Reservation End: \n");
					end = keyboardInput.nextInt();
					
					System.out.printf("Daily Cost: \n");
					cost = keyboardInput.nextInt();
					
					ReservationBook.add(new Reservation(name, month, start, end, cost));
					System.out.printf("Reservation created successfully!!\n");
					break;

				// display all reservation
				case 2:
					for(Reservation Hotel: ReservationBook)
						Hotel.displayInfo();
					break;
				
				// exit
				case 0:
					break;

				// invalid input
				default:
					System.out.printf("Invalid input. Try again.\n\n");
					break;
			}
			
		}while(MenuInput != 0);
		
	}
}
