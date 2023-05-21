
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 10

public class Laundry extends Service{

	int clothingPieces;
	double laundryCost;
	
	public Laundry(int customerID, int clothingPieces) {
		this.customerID = customerID;
		this.clothingPieces = clothingPieces;
		//this.laundryCost = laundryCost;
	}
	
	@Override
	public String getServiceType() {
		
		return "Laundry";
	}

	@Override
	public double calculateService() {
		
		return 20 * clothingPieces;
	}

	@Override
	public double getCost() {
		return calculateService();
	}
	
	public String displayLaundryInfo() {
		
		return "Reservation ID #" + getCustomerID() + " has " + clothingPieces + " pieces assigned for Laundry Service.";
	}

}
