
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 10

public class Spa extends Service {

	int days;
	double spaCost;
	
	public Spa(int customerID, int days) {
		this.customerID = customerID;
		this.days = days;
		//this.spaCost = spaCost;
	}
	
	@Override
	public String getServiceType() {
		
		return "Spa";
	}

	@Override
	public double calculateService() {

		return 100 * days;
	}

	@Override
	public double getCost() {
		return calculateService();
	}
		
	public String displaySpaInfo() {
		
		return "Reservation ID #" + getCustomerID() + " has " + days + " days of Spa Services.";
	}

}
