
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 6

public class Laundry extends Service{

	int clothingPieces;
	double laundryCost;
	
	public Laundry(int customerID, int clothingPieces, double laundryCost ) {
		this.customerID = customerID;
		this.clothingPieces = clothingPieces;
		this.laundryCost = laundryCost;
	}
	
	@Override
	public String ServiceType() {
		
		return "Laundry";
	}

	@Override
	public double calculateService() {
		
		return 20 * clothingPieces;
	}

}
