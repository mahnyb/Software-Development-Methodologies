
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 5

public class Reservation {
	static int totalNumOfReservations = 0;
	private Room room;
	String hotelName;
	String reservationMonth;
	int reservationStart;
	int reservationEnd;
	int dailyCost;
	
	public Reservation(String hotelName, String roomType, String reservationMonth, int reservationStart, int reservationEnd) {
        this.hotelName = hotelName;
        
        // to create rooms
        
        	if (roomType.equals("Single")) {
            	room = new Single();
            }
            else if (roomType.equals("Double")) {
            	room = new Double();
            }
            else if (roomType.equals("Club")) {
            	room = new Club();
            }
            else if (roomType.equals("Family")) {
            	room = new Family();
            }
            else if (roomType.equals("Family with View")) {
            	room = new FamilyView();
            }
            else if (roomType.equals("Suite")) {
            	room = new Suite();
            }
        
        this.reservationMonth = reservationMonth;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.dailyCost = room.getCost();
        totalNumOfReservations++;
    }
    
	// Hotel Name
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
    	this.hotelName = hotelName;
    }
    
    // Room
    public Room getRoom() {
    	return room;
    }
    public void setRoom(Room room) {
    	this.room = room;
    }
    
    // Reservation Month
    public String getReservationMonth() {
        return reservationMonth;
    }
    public void setReservationMonth(String reservationMonth) {
    	this.reservationMonth = reservationMonth;
    }
    
    // Reservation Start
    public int getReservationStart() {
        return reservationStart;
    }
    public void setReservationStart(int reservationStart) {
    	this.reservationStart = reservationStart;
    }
    
    // Reservation End
    public int getReservationEnd() {
        return reservationEnd;
    }
    public void setReservationEnd(int reservationEnd) {
    	this.reservationEnd = reservationEnd;
    }
    
    // Daily Cost
    public int getDailyCost() {
        return dailyCost;
    }
    public void setDailyCost(int dailyCost) {
    	this.dailyCost = dailyCost;
    }
    
    // Total Price
    public int calculateTotalPrice() {
        int duration = getReservationEnd() - getReservationStart();
        int multiplier = 1;
        if (getReservationMonth().toLowerCase().equals("june") || getReservationMonth().toLowerCase().equals("july") || getReservationMonth().toLowerCase().equals("august")) {
            multiplier = 2;
        }
        return duration * getDailyCost() * multiplier;
        
    }
    
    public void displayInfo() {
       System.out.printf("\nReservation for a %s room in %s Hotel starts on %s %d and ends on %s %d. The reservation has a total cost of $%d.\n", getRoom().getType(), getHotelName(), getReservationMonth(), getReservationStart(), getReservationMonth(), getReservationEnd(), calculateTotalPrice());
    }
}
	
