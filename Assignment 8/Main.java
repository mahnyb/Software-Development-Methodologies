
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 8

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
	ADD_EMPLOYEE("7. Add an employee\r\n"),
	ADD_BILL("8. Add a bill\r\n"),
	MONTHLY_BALANCE("9. Get monthly balance\r\n"),
	SERVICES_BASED_ON_COST("10. List all Services sorted based on cost\r\n"),
	RESERVATIONS_BASED_ON_HOTEL_NAME("11. List all Reservations sorted based on hotel names\r\n"),
	EXIT("12. Exit\r\n\n");
	
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
		
		String name = null, month = null, roomType = null, employeeName = null, employeeSurname = null, billType = null, billMonth = null, balanceMonth = null;
		int start = 0, end = 0, extra = 0, ID = 0, clothe = 0, dayCount = 0, employeeID = 0;
		double employeePayment = 0, billAmount = 0;
		
		ArrayList<Calculable> HotelBook = new ArrayList<Calculable>(); 
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
					
					System.out.printf("\nHotel Name: ");
					keyboardInput.nextLine(); // to clear the scanner
					name = keyboardInput.nextLine();
					
					System.out.printf("\nRoom Type: ");
					roomType = keyboardInput.next();
					
					System.out.printf("\nReservation Month: ");
					month = keyboardInput.next();
					
					System.out.printf("\nReservation Start: ");
					start = keyboardInput.nextInt();
					
					System.out.printf("\nReservation End: ");
					end = keyboardInput.nextInt();
					
					HotelBook.add(new Reservation(name, roomType, month, start, end));
					System.out.printf("\nReservation ID %d is created!\n", Reservation.totalNumOfReservations);
					break;
				
				// display all reservation
				case DISPLAY_ALL:
					for(Calculable Hotel: HotelBook) {
						if(Hotel instanceof Reservation) {
							((Reservation) Hotel).displayInfo();
						}
					}
					
					break;
				
				// list of reservations in a specific city
					
				case RESERVATION_LIST_SPECIFIC_CITY:
					
					// get the name of the city from the suer
					System.out.printf("\nType a city name for a reservation search: ");
					String cityName1 = keyboardInput.next(); 
					
					// traverse the reservation book to find all the reservations containing that city name
					
					List<Calculable> ListOfResCities = HotelBook;  
					Iterator<Calculable> iterator1 = ListOfResCities.iterator();
					
					while(iterator1.hasNext()) {
						
						Calculable ResList = iterator1.next();
						
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
						System.out.printf("\nType the reservation ID to credit this service: ");
						ID = keyboardInput.nextInt();
						System.out.printf("\nHow many pieces of clothing? ");
						clothe = keyboardInput.nextInt();
						
						HotelBook.add(new Laundry(ID, clothe, 20));
					}
					else if(extra == 2) {
						System.out.printf("\nType the reservation ID to credit this service: ");
						ID = keyboardInput.nextInt();					
						System.out.printf("\nHow many days? ");
						dayCount = keyboardInput.nextInt();
						
						HotelBook.add(new Spa(ID, dayCount, 100));
					}
					
					break;
				
				//	calculate the total service cost per purchase per reservation
				case TOTAL_COST_FOR_EACH_SERVICE:
					
					for(Calculable Hotel : HotelBook) {
							double cost = ((Service) Hotel).calculateService();
							ID = ((Service) Hotel).getCustomerID();
							String serviceType = ((Service) Hotel).getServiceType();
							System.out.printf("\nThe cost for the %s service of reservation ID %d: %.2f \n", serviceType, ID, cost);
					}
					break;
				
				//	calculate the grand total bill per Reservation ID
				case TOTAL_COST_EVERY_CUSTOMER:
					
					double[] HotelList = new double[Reservation.totalNumOfReservations + 1];
					for(Calculable Hotel : HotelBook) {
						HotelList[((Service) Hotel).getCustomerID()] += ((Service) Hotel).calculateService();
					}
					for(int i = 1; i <= Reservation.totalNumOfReservations; i++) {
						System.out.printf("\nThe total cost of all services of the reservation with ID %d is: %.2f\n", i, HotelList[i]);
					}
					break;
					
				// ask for employee's name, surname, ID, monthly payment, and create a new employee based on those info
				case ADD_EMPLOYEE:
					
					System.out.printf("\nName: ");
					employeeName = keyboardInput.next();
					
					System.out.printf("\nSurname: ");
					employeeSurname = keyboardInput.next();
					
					System.out.printf("\nID: ");
					employeeID = keyboardInput.nextInt();
					
					System.out.printf("\nMonthly Payment: ");
					employeePayment = keyboardInput.nextDouble();
					
					HotelBook.add(new Employees(employeeName, employeeSurname, employeePayment, employeeID));
				
					
					break;
					
				// ask about the type of the bill and the amount. the months should be taken into account 
				case ADD_BILL:
					
					System.out.printf("\nType: ");
					billType = keyboardInput.next();
					
					System.out.printf("\nAmount: ");
					billAmount = keyboardInput.nextDouble();
					
					System.out.printf("\nMonth: ");
					billMonth = keyboardInput.next();
					
					HotelBook.add(new Bills(billType, billAmount, billMonth));
					
					break;
				
				// calculate the general balance of the hotel for a specific month (Incomes: Reservation & Services | Expenditure: Bills & Employees)
				case MONTHLY_BALANCE:
					
					System.out.printf("\nEnter Month: ");
					balanceMonth = keyboardInput.next();
					
					double overallRevenue = 0; // how much the hotel is making from Reservations and Extra Services
					double overallExpenditure = 0; // Bills + Employees
					double profit = 0, employeeTotal = 0, billTotal = 0;
					LinkedList<Integer> IDArray = new LinkedList<Integer>(); // to store the IDs 
					
					for(Calculable Hotel : HotelBook) {
						
						if(Hotel instanceof Reservation) {  // cost of all the Reservations for a specific month 
														
							if (balanceMonth.equals(((Reservation) Hotel).getReservationMonth())){
								
								overallRevenue += Hotel.getCost();
								IDArray.add(((Service) Hotel).getCustomerID());
								
								System.out.printf("\nFor reservation ID: %d, Service type: Room booking, Service Cost: %.2f\n", ((Service) Hotel).getCustomerID(), Hotel.getCost() );
							}								
						}
						
						else if(Hotel instanceof Service) {  // cost of all the Extra Services for a specific month
							
							for(Integer IDnumber : IDArray) {
								
								if (IDnumber.equals(((Service) Hotel).getCustomerID())){
									
									overallRevenue += Hotel.getCost();
									
									System.out.printf("\nFor reservation ID: %d, Service type: %s, Service Cost: %.2f\n", ((Service) Hotel).getCustomerID(), ((Service) Hotel).getServiceType(), Hotel.getCost() );
									break;
								}
							}
							
						}
						
						else if(Hotel instanceof Bills) {   // cost of all the Bills for a specific month
							
							if (balanceMonth.equals(((Bills) Hotel).getMonth())){
								
								billTotal += Hotel.getCost();
							}
							
						}
						
						else if(Hotel instanceof Employees) {  // cost of all the Payments for the Employees for each month
							
							employeeTotal += Hotel.getCost();
							
						}
					}
					
					overallExpenditure = billTotal + employeeTotal;
					profit = overallRevenue - overallExpenditure;

					System.out.printf("\nTotal monthly income: %.2f\n", overallRevenue);
					System.out.printf("\nTotal monthly bills due: %.2f\n", billTotal);
					System.out.printf("\nTotal monthly employee cost: %.2f\n", employeeTotal);
					System.out.printf("\nEnd of month balance: %.2f\n", profit);
					
					
					break;
							
				
				// arrange the services based on their total cost in descending order	
				case SERVICES_BASED_ON_COST:
					
					ArrayList<Service> serviceList = new ArrayList<Service>();
					
					for(Calculable item : HotelBook) {
						if(item instanceof Service) {
							serviceList.add((Service) item);
						}
					}
					
					serviceList.sort(Collections.reverseOrder(new CostComparator())); // sorts them in descending order 
					
					for(Service extraservice : serviceList) {
						
						System.out.printf("\n");
						extraservice.displayServiceInfo();
						
					}
															
					break;
					
				// sort reservations in ascending order based on their hotel name attribute
				case RESERVATIONS_BASED_ON_HOTEL_NAME:
					
					ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
					
					for(Calculable Hotel : HotelBook) {
						if(Hotel instanceof Reservation) {
							reservationList.add(((Reservation) Hotel));
						}
					}
					
					Collections.sort(reservationList); 
					for(Reservation reservation : reservationList) {
						
						System.out.printf("\nHotel Name: %s, ", reservation.getHotelName());
						reservation.displayServiceInfo();
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
			
		} while(MenuInput != 12);
		
		keyboardInput.close();
		
	}
}
