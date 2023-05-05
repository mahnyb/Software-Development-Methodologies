
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 5

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;


enum MenuOptions{
	CREATE_RESERVATION("\n1. Create new Reservation\r\n"),
	CREATE_WITH_ROOMTYPE("2. Create new Reservation with Room Type\r\n"),
	DISPLAY_ALL("3. Display all Reservations\r\n"),
	DISPLAY_TOTAL_NUMBER("4. Display the total number of reservations\r\n"),
	RESERVATION_LIST_SPECIFIC_CITY("5. List the reservations for a specific city\r\n"),
	REMOVE_SPECIFIC_CITY_RESERVATIONS("6. Remove reservations in a specific city\r\n"),
	EXIT("7. Exit\n");
	
	private final String option;

	MenuOptions( String option) {
		this.option = option;
	}
	
	public String getOption() {
		return option;
	}

}

public class Main {

	public static void main(String[] args) {
		
		String name = null, month = null, roomType = null;
		int start = 0, end = 0;
		
		ArrayList<Reservation> ReservationBook = new ArrayList<Reservation>(3); // array of size 3
		Scanner keyboardInput = new Scanner(System.in);
		
		//Menu
		int MenuInput;
		
		do { 
			for(MenuOptions option : MenuOptions.values()) {
			
				System.out.printf(option.getOption());
		}
		
			MenuInput = keyboardInput.nextInt();

			switch(MenuOptions.values()[MenuInput - 1]){

				// create new reservation
				case CREATE_RESERVATION:
					
					System.out.printf("Hotel Name: \n");
					keyboardInput.nextLine(); // to clear the scanner
					name = keyboardInput.nextLine();
					
					System.out.printf("Reservation Month: \n");
					month = keyboardInput.next();
					
					System.out.printf("Reservation Start: \n");
					start = keyboardInput.nextInt();
					
					System.out.printf("Reservation End: \n");
					end = keyboardInput.nextInt();
					
					ReservationBook.add(new Reservation(name, "Single", month, start, end));
					System.out.printf("\nReservation created successfully!!\n");
					break;

				// create new reservation with room type
				case CREATE_WITH_ROOMTYPE:
					System.out.printf("\nROOM INFOS:\r\n"
							+ "Room Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: false\r\n"
							+ "Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: false\r\n"
							+ "Room Type: Club, Daily Cost: 250, Room Size: 45, Has Bath: true\r\n"
							+ "Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: false\r\n"
							+ "Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: true\r\n"
							+ "Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: true\r\n");
					
					System.out.printf("\nHotel Name: \n");
					keyboardInput.nextLine(); // to clear the scanner
					name = keyboardInput.nextLine();
					
					System.out.printf("Room Type: \n");
					roomType = keyboardInput.next();
					
					System.out.printf("Reservation Month: \n");
					month = keyboardInput.next();
					
					System.out.printf("Reservation Start: \n");
					start = keyboardInput.nextInt();
					
					System.out.printf("Reservation End: \n");
					end = keyboardInput.nextInt();
					
					ReservationBook.add(new Reservation(name, roomType, month, start, end));
					System.out.printf("\nReservation created successfully!!\n");
					break;
					
				// display all reservation
				case DISPLAY_ALL:
					for(Reservation Hotel: ReservationBook)
						Hotel.displayInfo();
					break;
					
				// display the total number of reservations	
				case DISPLAY_TOTAL_NUMBER:
					System.out.printf("\n%d reservation(s) have been created so far.\n", Reservation.totalNumOfReservations); 
					break;
					
				// list of reservations in a specific city
					
				case RESERVATION_LIST_SPECIFIC_CITY:
					
					// get the name of the city from the suer
					System.out.printf("\nType a city name for a reservation search: \n");
					String cityName1 = keyboardInput.next(); // !
					
					// traverse the reservation book to find all the reservations containing that city name
					
					List<Reservation> ListOfResCities = ReservationBook;  // !
					Iterator<Reservation> iterator1 = ListOfResCities.iterator();
					
					while(iterator1.hasNext()) {
						
						Reservation ResList = iterator1.next();
						
						if(ResList.getHotelName().toLowerCase().contains(cityName1.toLowerCase())) {
							
							System.out.printf("%s\n", ResList.getHotelName());
						}
					}
					
					break;
					
				// remove all reservations for a specific city
					
				case REMOVE_SPECIFIC_CITY_RESERVATIONS:
					
					System.out.printf("\nType a city name for a reservation search: \n");
					String cityName2 = keyboardInput.next();
					
					List<Reservation> ListOfToBeRemoved = new ArrayList<>(ReservationBook);
					Iterator<Reservation> iterator2 = ListOfToBeRemoved.iterator();
					
					while(iterator2.hasNext()) {
						
						Reservation RemoveList = iterator2.next();
						
						if(RemoveList.getHotelName().contains(cityName2)) {
							iterator2.remove();
							Reservation.totalNumOfReservations--; // to decrement the number of reservations
						}	
					}
					
					// sets the existing array list to null
					ReservationBook = null;
					
					// inserts the resulting list to the existing array list
					ReservationBook = new ArrayList<>(ListOfToBeRemoved);
					
					break;
				
				// exit
				case EXIT:
					break;

				// invalid input
				default:
					System.out.printf("Invalid input. Try again.\n\n");
					break;
			}
			
		} while(MenuInput != 7);
		
		keyboardInput.close();
		
	}
}
