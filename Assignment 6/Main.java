
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 6

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.*;



enum MenuOptions{
	CREATE_WITH_ROOMTYPE("\n1. Create new Reservation with Room Type\r\n"),
	DISPLAY_ALL("2. Display all Reservations\r\n"),
	RESERVATION_LIST_SPECIFIC_CITY("3. List the reservations for a specific city\r\n"),
	EXTRA_SERVICES("4. Add extra services to a reservation\r\n"),
	TOTAL_COST_FOR_EACH_SERVICE("5. Calculate total cost for each service\r\n"),
	TOTAL_COST_EVERY_CUSTOMER("6. Display the total cost of every customer\r\n"),
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
		int start = 0, end = 0, extra = 0, ID = 0, clothe = 0, dayCount = 0;
		
		ArrayList<Service> HotelBook = new ArrayList<Service>(); 
		Scanner keyboardInput = new Scanner(System.in);
		
		//Menu
		int MenuInput;
		
		do { 
			for(MenuOptions option : MenuOptions.values()) {
			
				System.out.printf(option.getOption());
		}
		
			MenuInput = keyboardInput.nextInt();

			switch(MenuOptions.values()[MenuInput - 1]){
			
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
					
					HotelBook.add(new Reservation(name, roomType, month, start, end));
					System.out.printf("\nReservation ID %d is created!\n", Reservation.totalNumOfReservations);
					break;
				
				// display all reservation
				case DISPLAY_ALL:
					for(Service Hotel: HotelBook) {
						if(Hotel instanceof Reservation) {
							((Reservation) Hotel).displayInfo();
						}
					}
					
					break;
				
				// list of reservations in a specific city
					
				case RESERVATION_LIST_SPECIFIC_CITY:
					
					// get the name of the city from the suer
					System.out.printf("\nType a city name for a reservation search: \n");
					String cityName1 = keyboardInput.next(); 
					
					// traverse the reservation book to find all the reservations containing that city name
					
					List<Service> ListOfResCities = HotelBook;  
					Iterator<Service> iterator1 = ListOfResCities.iterator();
					
					while(iterator1.hasNext()) {
						
						Service ResList = iterator1.next();
						
						if(((Reservation) ResList).getHotelName().toLowerCase().contains(cityName1.toLowerCase())) { 
							
							System.out.printf("\n%s\n", ((Reservation) ResList).getHotelName());
						}
					}
					
					break;
				//	
				case EXTRA_SERVICES:
					
					System.out.printf("\nPlease select one of the extra services from below:\r\n"
							+ "1. Laundry Service\r\n"
							+ "2. Spa Service\r\n");
					extra = keyboardInput.nextInt();
					
					if(extra == 1) {
						System.out.printf("\nType the reservation ID to credit this service: \n");
						ID = keyboardInput.nextInt();
						System.out.printf("\nHow many pieces of clothing? \n");
						clothe = keyboardInput.nextInt();
						
						HotelBook.add(new Laundry(ID, clothe, 20));
					}
					else if(extra == 2) {
						System.out.printf("\nType the reservation ID to credit this service: \n");
						ID = keyboardInput.nextInt();					
						System.out.printf("\nHow many days? \n");
						dayCount = keyboardInput.nextInt();
						
						HotelBook.add(new Spa(ID, dayCount, 100));
					}
					
					break;
				
				//	calculate the total service cost per purchase per reservation
				case TOTAL_COST_FOR_EACH_SERVICE:
					
					for(Service Hotel : HotelBook) {
							double cost = Hotel.calculateService();
							ID = Hotel.getCustomerID();
							String serviceType = Hotel.ServiceType();
							System.out.printf("\nThe cost for the %s service of reservation ID %d: %.2f \n", serviceType, ID, cost);
					}
					break;
				
				//	calculate the grand total bill per Reservation ID
				case TOTAL_COST_EVERY_CUSTOMER:
					
					double[] HotelList = new double[Reservation.totalNumOfReservations + 1];
					for(Service Hotel : HotelBook) {
						HotelList[Hotel.getCustomerID()] += Hotel.calculateService();
					}
					for(int i = 1; i <= Reservation.totalNumOfReservations; i++) {
						System.out.printf("\nThe total cost of all services of the reservation with ID %d is: %.2f\n", i, HotelList[i]);
					}
					break;

				// exit
				case EXIT:
					System.out.printf("\nExiting, Goodbye!\n");
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
