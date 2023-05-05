/ Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 2

public class Reservation {
	String hotelName;
	String reservationMonth;
	int reservationStart;
	int reservationEnd;
	int dailyCost;
	
	public Reservation(String hotelName, String reservationMonth, int reservationStart, int reservationEnd, int dailyCost) {
        this.hotelName = hotelName;
        this.reservationMonth = reservationMonth;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.dailyCost = dailyCost;
    }
    
    public String getHotelName() {
        return hotelName;
    }
    
    public String getReservationMonth() {
        return reservationMonth;
    }
    
    public int getReservationStart() {
        return reservationStart;
    }
    
    public int getReservationEnd() {
        return reservationEnd;
    }
    
    public int getDailyCost() {
        return dailyCost;
    }
    
    public int calculateTotalPrice() {
        int duration = reservationEnd - reservationStart;
        return duration * dailyCost;
    }
    
    public void displayInfo() {
       System.out.printf("\nReservation for %s starts on %s %d and ends on %s %d. The reservation has a total cost of $%d.\n", getHotelName(), getReservationMonth(), getReservationStart(), getReservationMonth(), getReservationEnd(), calculateTotalPrice());
    }
}
